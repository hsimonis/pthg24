package org.insightcentre.pthg24.imports;

import org.insightcentre.pthg24.datamodel.Citation;
import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.datamodel.Work;
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
import java.util.stream.Collectors;

import static org.insightcentre.pthg24.imports.ImportCrossref.properDOI;
import static org.insightcentre.pthg24.imports.Keys.opencitationsKey;
import static org.insightcentre.pthg24.logging.LogShortcut.*;

public class ImportOpenCitations {
    Scenario base;
    String citationDir;
    public ImportOpenCitations(Scenario base, String citationDir){
        this.base = base;
        this.citationDir = citationDir;
        assert(citationDir.endsWith("/"));
        info("Reading opencitations");
        initWorkLookup();
        for(Work w: base.getListWork().stream().sorted(Comparator.comparing(Work::getYear)).toList()) {
            info("Citations "+w.getName());
            citations(w);
        }
    }

    public void citations(String key){
        Work work = Work.findByName(base,key);
        assert(work != null);
        citations(work);
    }

    public void citations(Work w){
        String target = "";
        String saveFile = citationDir+w.getKey()+".json";
        try {
            if (exists(saveFile)){
                info("Reading file "+saveFile);
                interpret(w,contents(saveFile));
            } else {
                if (w.getDoi() != null && !w.getDoi().equals("")) {
                    target = "https://opencitations.net/index/coci/api/v1/citations/" +
                            URLEncoder.encode(properDOI(w.getDoi()), StandardCharsets.UTF_8.toString());
                    URI targetURI = new URI(target);
                    HttpRequest httpRequest = HttpRequest.newBuilder()
                            .uri(targetURI)
                            // key taken from hidden file
                            .header("authorization",opencitationsKey)
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
                }
            }
        } catch (IOException e) {
            severe("Bad HttpRequest GET " + target + ", exception " + e.getMessage());
        } catch (URISyntaxException e) {
            severe("URI Syntax " + target + ", exception " + e.getMessage());
        } catch (InterruptedException e) {
            severe(" Interrupted request " + target + ", exception " + e.getMessage());
        }

    }

    private void interpret(Work w,String body){
        if (body.startsWith("HTTP status code")){
            severe("Problem with Citation "+w.getKey());
        } else {
            JSONArray arr = new JSONArray(body);
            int covered = 0;
            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                String citing = obj.getString("citing").toLowerCase();
                String cited = obj.getString("cited").toLowerCase();
                String oci = obj.getString("oci");
                String creation = obj.getString("creation");
                String timespan = obj.getString("timespan");
                String author_sc = obj.getString("author_sc");
                String journal_sc = obj.getString("journal_sc");
                Citation citation = new Citation(base);
                citation.setName(oci);
                citation.setOci(oci);
                citation.setCitedWork(w);
                citation.setCitingWork(workLookup(citing));
                if (citation.getCitingWork() != null) {
                    covered++;
                }
                citation.setCited(cited);
                citation.setCiting(citing);
                citation.setCreation(creation);
                citation.setTimespan(timespan);
                citation.setAuthorSC(author_sc);
                citation.setJournalSC(journal_sc);
            }
            w.setNrCitations(arr.length());
            w.setNrCitationsCovered(covered);
            w.setPercentCitationsCovered(100.0 * covered / arr.length());
        }
    }

    private boolean exists(String fileName){
        info("fileName "+fileName);
        Path path = Paths.get(fileName);
        return Files.exists(path);
    }

    private String contents(String fileName) throws IOException{
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    Hashtable<String,Work> doiLookup = new Hashtable<>();

    private void initWorkLookup(){
        for(Work w:base.getListWork()){
            if (w.getYear() == null){
                severe("Missing year "+w.getName());
            }
            String doi = properDOI(w.getDoi());
            if (doi != null) {
                doiLookup.put(doi, w);
            }
        }
    }
    private Work workLookup(String doi){
        return doiLookup.get(doi);
    }


}
