package org.insightcentre.pthg24.imports;

import org.insightcentre.pthg24.datamodel.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import static org.insightcentre.pthg24.imports.Keys.scopusKey;
import static org.insightcentre.pthg24.logging.LogShortcut.*;

public class ImportScopus {
    Scenario base;
    String scopusDir;

    Hashtable<String,Affiliation> affHash = new Hashtable<>();
    public ImportScopus(Scenario base, String scopusDir){
        this.base = base;
        this.scopusDir = scopusDir;
        assert(scopusDir.endsWith("/"));

        for(Work w: base.getListWork().stream().sorted(Comparator.comparing(Work::getYear).reversed()).toList()) {
            info("Scopus "+w.getName());
            scopus(w);
        }
        updateCountryNrWorks();
    }

    // alternative API for testing
    public void scopus(String key){
        Work work = Work.findByName(base,key);
        assert(work != null);
        scopus(work);
    }

    public void scopus(Work w){
        String target = "";
        String saveFile = scopusDir+w.getKey()+".xml";
        try {
            if (exists(saveFile)){
                info("Reading file "+saveFile);
                interpret(w,contents(saveFile));
            } else {
                if (w.getDoi() != null && !w.getDoi().equals("")) {
                    target = "https://api.elsevier.com/content/abstract/doi/" +
                            URLEncoder.encode(properDOI(w.getDoi()), StandardCharsets.UTF_8.toString())+
                            // get key from hidden file
                            "?apiKey="+scopusKey;
                    URI targetURI = new URI(target);
                    HttpRequest httpRequest = HttpRequest.newBuilder()
                            .uri(targetURI)
//                            .header("apiKey",token)
                            .GET()
                            .build();
                    HttpClient httpClient = HttpClient.newHttpClient();
                    HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                    info("Result " + response + " body " + response.body());
                    PrintWriter out = new PrintWriter(saveFile);
                    out.print(response.body());
                    out.close();
                    interpret(w, response.body());
                } else {
                    warning("DOI not usable for work " + w.getName() + " doi " + w.getDoi());
                    w.setScopusStatus(false);
                }
            }
        } catch (IOException e) {
            severe("Bad HttpRequest GET " + target + ", exception " + e.getMessage());
        } catch (URISyntaxException e) {
            severe("URI Syntax " + target + ", exception " + e.getMessage());
        } catch (InterruptedException e) {
            severe(" Interrupted request " + target + ", exception " + e.getMessage());
        } catch(Exception e){
            severe("Other exception "+e.getMessage());
        }

    }

    private void interpret(Work w,String body){
        try {
            String full = "<?xml version=\"1.0\"?>\n"+body+"\n";
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(full)));
            doc.getDocumentElement().normalize();
//            info("Node "+doc.getNodeName());
            Node child = doc.getFirstChild();
            info("child "+child.getNodeName());
            if (child.getNodeName().equals("service-error")){
                w.setScopusStatus(false);
            } else if (child.getNodeName().equals("abstracts-retrieval-response")){
                w.setScopusStatus(true);
                NodeList list = child.getChildNodes();
                for(int i=0;i<list.getLength();i++){
                    Node node = list.item(i);
                    if (node.getNodeType()==Node.ELEMENT_NODE && node.getNodeName().equals("coredata")){
                        info("node "+node.getNodeName()+node.getTextContent());
                    }
                }
                NodeList citedBy = doc.getElementsByTagName("citedby-count");
                assert(citedBy.getLength()<=1);
                if (citedBy.getLength()==1){
                    Node cited = citedBy.item(0);
                    int cnt = Integer.parseInt(cited.getTextContent());
                    w.setScopusCitations(cnt);
                }
                // this is probably not ok, includes affiliation inside coredata?
                NodeList affs = doc.getElementsByTagName("affiliation");
                for(int i=0;i<affs.getLength();i++){
                    Node aff = affs.item(i);
                    NodeList fields = aff.getChildNodes();
                    String name="";
                    String city="";
                    String country="";
                    for(int j=0;j<fields.getLength();j++){
                        Node field = fields.item(j);
                        switch(field.getNodeName()){
                            case "affilname":
                                name = field.getTextContent();
                                break;
                            case "affiliation-city":
                                city = field.getTextContent();
                                break;
                            case "affiliation-country":
                                country = field.getTextContent();
                                break;
                            default:
                                severe("Bad field "+field.getNodeName());
                        }
                    }
                    if (!country.equals("")) {
                        ScopusAffiliation affil = lookupAffiliation(name, city, country);
                        WorkAffiliation wa = new WorkAffiliation(base);
                        wa.setWork(w);
                        wa.setScopusAffiliation(affil);
                    }
                }


            }
        } catch(Exception e){
            severe("Cannot parse XML for "+w.getKey()+" "+e.getMessage());
        }

     }

     private ScopusAffiliation lookupAffiliation(String inst,String city,String country){
        String name = inst+", "+city+", "+country;
        ScopusAffiliation sa = ScopusAffiliation.findByName(base,name);
        if (sa == null){
            sa = new ScopusAffiliation(base);
            sa.setName(name);
            sa.setInst(inst);
            ScopusCity scopusCity = lookupCity(city,country);
            sa.setScopusCity(scopusCity);


        }
        sa.incWorkCount();
         sa.getScopusCity().incWorkCount();
         sa.getScopusCity().getScopusCountry().incWorkCount();
        return sa;
    }

    private ScopusCity lookupCity(String city,String country){
        String name = city+", "+country;
        ScopusCity sc = ScopusCity.findByName(base,name);
        if (sc==null){
            sc = new ScopusCity(base);
            sc.setName(name);
            sc.setScopusCountry(lookupCountry(country));
        }
        return sc;
    }

    private ScopusCountry lookupCountry(String name){
        ScopusCountry sc = ScopusCountry.findByName(base,name);
        if (sc == null){
            sc = new ScopusCountry(base);
            sc.setName(name);
        }
        return sc;
    }

    public static boolean exists(String fileName){
        Path path = Paths.get(fileName);
        return Files.exists(path);
    }

    public static String contents(String fileName) throws IOException{
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    /*
    we allow for LaTeX escaped underscores in the doi string
    get rid of any https:// stuff at front
    normalize to lower case
     */
    public static String properDOI(String text){
        if (text==null){
            return null;
        }
        if (text.startsWith("10.")){
            return text.replace("\\","").toLowerCase();
        }
        if (text.startsWith("https://doi.org/")){
            return text.substring(16).replace("\\","").toLowerCase();
        }
        return null;
    }

    private void updateCountryNrWorks(){
        for(ScopusCountry sc:base.getListScopusCountry()){
            int nrWorks = (int) base.getListWorkAffiliation().stream().
                    filter(x->x.getScopusAffiliation().getScopusCity().getScopusCountry()==sc).
                    map(WorkAffiliation::getWork).
                    distinct().
                    count();
            sc.setNrWorks(nrWorks);
        }
    }
}
