package org.insightcentre.pthg24.imports;

import org.insightcentre.pthg24.datamodel.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
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
import java.util.stream.Collectors;

import static org.insightcentre.pthg24.logging.LogShortcut.*;

public class ImportCrossref {
    Scenario base;
    String crossrefDir;
    String missingDir;
    Hashtable<String,Affiliation> affHash = new Hashtable<>();

    public ImportCrossref(Scenario base, String crossrefDir,String missingDir){
        this.base = base;
        this.crossrefDir = crossrefDir;
        this.missingDir = missingDir;
        assert(crossrefDir.endsWith("/"));
        assert(missingDir.endsWith("/"));
        initWorkLookup();

        for(Work w: base.getListWork().stream().sorted(Comparator.comparing(Work::getYear).reversed()).toList()) {
            info("Crossref "+w.getName());
            crossrefs(w);
        }
    }

    // alternative API for testing
    public void crossrefs(String key){
        Work work = Work.findByName(base,key);
        assert(work != null);
        crossrefs(work);
    }

    public void crossrefs(Work w){
        String target = "";
        String saveFile = crossrefDir+w.getKey()+".json";
        try {
            String encodedDoi = URLEncoder.encode(properDOI(w.getDoi()), StandardCharsets.UTF_8.toString());
            String missingWorkFile = missingDir+encodedDoi+".json";
            if (exists(saveFile)) {
                info("Reading file " + saveFile);
                interpret(w, contents(saveFile));
            } else if (exists(missingWorkFile)){
                    info("Reading file "+saveFile);
                    interpret(w,contents(saveFile));
            } else {
                if (w.getDoi() != null && !w.getDoi().equals("")) {
                    w.setDoiStatus(true);
                    target = "https://api.crossref.org/works/" +
                            URLEncoder.encode(properDOI(w.getDoi()), StandardCharsets.UTF_8.toString());
                    URI targetURI = new URI(target);
                    HttpRequest httpRequest = HttpRequest.newBuilder()
                            .uri(targetURI)
//                            .header("authorization",token)
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
                    w.setCrossrefStatus(false);
                    w.setDoiStatus(false);
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
        if (body.startsWith("Resource not found.")){
            severe(w.getKey()+ " Resource not found");
            w.setCrossrefStatus(false);
            return;
        }
        w.setCrossrefStatus(true);
        // parse the JSON
        JSONObject obj = new JSONObject(body);
        String status = obj.getString("status");
        String type = obj.getString("message-type");
        JSONObject message = obj.getJSONObject("message");
        int referenceCount = message.getInt("reference-count");
        int referencedByCount = message.getInt("is-referenced-by-count");
        String messageType = message.getString("type");
        JSONArray title = message.getJSONArray("title");
        String title1 = title.getString(0);
        int refCount = 0;
        if(message.has("reference")) {
            JSONArray reference = message.getJSONArray("reference");
            refCount = reference.length();
            extractReferences(w,reference);

        }

        List<Authorship> ships = base.getListAuthorship().stream().
                filter(x->x.getWork()==w).
                sorted(Comparator.comparing(Authorship::getSeqNr)).
                toList();
        if (message.has("author")) {
            JSONArray authors = message.getJSONArray("author");
            String authorInfo = extractAuthors(authors, ships);
        }
//        info("content "+status+" "+type+" "+refCount+" "+referenceCount+" "+referencedByCount+" "+messageType+" "+title.length()+" "+title1+" "+authors.length()+" "+authorInfo);
        w.setCrossrefReferences(referenceCount);
        w.setCrossrefCitations(referencedByCount);
    }

    private void extractReferences(Work w,JSONArray arr){
        for(int i=0;i<arr.length();i++){
            JSONObject ref = arr.getJSONObject(i);
            String key = ref.getString("key");
            String name = key;
            String unstructured = (ref.has("unstructured") ? ref.getString("unstructured") : "");
            String author = (ref.has("author") ? ref.getString("author") : "");
            String articleTitle = (ref.has("article-title") ? ref.getString("article-title") : "");
            String journalTitle = (ref.has("journal-title") ? ref.getString("journal-title") : "");
            String seriesTitle = (ref.has("series-title") ? ref.getString("series-title") : "");
            String volumeTitle = (ref.has("volumeTitle") ? ref.getString("volume-title") : "");
            String source = journalTitle+seriesTitle+volumeTitle;
            String title = (articleTitle.equals("")?unstructured:articleTitle);
            Integer year = (ref.has("year")?ref.getInt("year"):null);
//            info("ref "+ref.toString());
            if (ref.has("DOI")) {
                String doi = (ref.has("DOI") ? ref.getString("DOI").toLowerCase() : "");
                DoiReference struc = new DoiReference(base);
                struc.setDoi(doi);
                struc.setName(name);
                struc.setKey(key);
                struc.setWork(w);
                Work referred = workLookup(doi);
                struc.setReferredWork((referred));
                struc.setYear(year);
                struc.setTitle(title);
                struc.setAuthor(author);
                struc.setSource(source);
            } else {
                UncategorizedReference un = new UncategorizedReference(base);
                un.setName(name);
                un.setKey(key);
                un.setWork(w);
                un.setYear(year);
                un.setTitle(title);
                un.setAuthor(author);
                un.setSource(source);
            }
        }

    }


    private String extractAuthors(JSONArray arr,List<Authorship> ships){
        if (ships.size() == arr.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length(); i++) {
                sb.append(extractAuthor(arr.getJSONObject(i), ships.get(i)));
                sb.append(" ");
            }
            return sb.toString();
        } else {
            severe("_______________________________________________________");
            severe("ExtractAuthor "+arr.length()+" "+ships.size());
            severe("Nr Authors different");
            severe(arr.toString());
            for(Authorship ship:ships){
                severe(ship.getSeqNr()+" "+ship.getAuthor().getName());
            }
            return "";
        }
    }


    private String extractAuthor(JSONObject obj,Authorship ship){
        Author a = ship.getAuthor();
        String given = obj.getString("given");
        String family = obj.getString("family");
        a.setCrossGiven(given);
        a.setCrossFamily(family);
        String sequence = obj.getString("sequence");
        ship.setSequence(sequence);
        JSONArray affiliation = obj.getJSONArray("affiliation");
        extractAffiliation(ship,affiliation);
        String orcID="";
        if(obj.has("ORCID")){
            orcID = obj.getString("ORCID");
            if (!a.getOrcid().equals("")){
                if (!a.getOrcid().equals(orcID)) {
                    severe("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    severe("ORCID MIXUP " + a.getOrcid() + " " + orcID + " " + given + " " + family + " " + a.getName());
                }
            } else {
                a.setOrcid(orcID);
            }

        }
        Set<String> keys = obj.keySet();
        keys.remove("given");
        keys.remove("family");
        keys.remove("sequence");
        keys.remove("affiliation");
        keys.remove("ORCID");
        keys.remove("authenticated-orcid");
        for(String key:keys){
            info("Other key "+key);
        }
        return given+" "+family+orcID;
    }

    private void extractAffiliation(Authorship ship,JSONArray aff){
        for(int j=0;j<aff.length();j++){
            JSONObject affj = aff.getJSONObject(j);
            if (affj.has("name")){
                String name = affj.getString("name");
                Affiliation a = affHash.get(name);
                if (a== null){
                    a = new Affiliation(base);
                    a.setName(name);
                    a.setShortName(name);
                    affHash.put(name,a);
                }
                a.incNrUsed();
                ship.getAffiliation().add(a);
            }

        }
    }

    public static boolean exists(String fileName){
        Path path = Paths.get(fileName);
        return Files.exists(path);
    }

    public static String contents(String fileName) throws IOException{
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    Hashtable<String,Work> doiLookup = new Hashtable<>();

    private void initWorkLookup(){
        for(Work w:base.getListWork()){
            String doi = properDOI(w.getDoi());
            if (doi != null && !doi.equals("")) {
                doiLookup.put(doi, w);
            }
        }
    }
    private Work workLookup(String doi){
        if (doi==null){
            return null;
        }
        return doiLookup.get(doi);
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
}
