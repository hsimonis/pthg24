package org.insightcentre.pthg24.imports;

import org.insightcentre.pthg24.datamodel.MissingWork;
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

import static org.insightcentre.pthg24.imports.ImportCrossref.*;
import static org.insightcentre.pthg24.imports.Keys.scopusKey;
import static org.insightcentre.pthg24.logging.LogShortcut.*;

public class LookupMissingWork {
    Scenario base;
    String missingWorkDir;

    public LookupMissingWork(Scenario base, String missingWorkDir, int linkCountLimit) {
        this.base = base;
        this.missingWorkDir = missingWorkDir;
        for (MissingWork mw : base.getListMissingWork().stream().filter(x -> x.getNrLinks() >= linkCountLimit).toList()) {
            lookup(mw);
            lookupScopus(mw);
        }
    }

    private void lookup(MissingWork mw) {
        String target = "";
        try {
            String saveFile = missingWorkDir + URLEncoder.encode(properDOI(mw.getDoi()), StandardCharsets.UTF_8.toString()) + ".json";
            if (exists(saveFile)){
                info("Reading file "+saveFile);
                interpret(mw,contents(saveFile));
            } else {
                if (mw.getDoi() != null && !mw.getDoi().equals("")) {
                    target = "https://api.crossref.org/works/" + URLEncoder.encode(properDOI(mw.getDoi()), StandardCharsets.UTF_8.toString());
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
                    interpret(mw, response.body());
                } else {
                    warning("DOI not usable for missing work doi " + mw.getDoi());
                }
            }

        } catch (Exception e) {
            severe("Cannot lookup missing work " + mw.getDoi()+", exception "+e.getMessage());
        }
    }

    public void lookupScopus(MissingWork mw){
        String target = "";
        try {
        String saveFile = missingWorkDir+URLEncoder.encode(properDOI(mw.getDoi()), StandardCharsets.UTF_8.toString()) + ".xml";
            if (exists(saveFile)){
                info("Reading file "+saveFile);
                interpretScopus(mw,contents(saveFile));
            } else {
                if (mw.getDoi() != null && !mw.getDoi().equals("")) {
                    target = "https://api.elsevier.com/content/abstract/doi/" +
                            URLEncoder.encode(properDOI(mw.getDoi()), StandardCharsets.UTF_8.toString())+
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
                    interpretScopus(mw, response.body());
                } else {
                    warning("DOI not usable for work " + mw.getName() + " doi " + mw.getDoi());

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

    private void interpretScopus(MissingWork mw, String body) {

    }

        private void interpret(MissingWork mw, String body) {
        if (body.startsWith("Resource not found.")) {
            severe(mw.getDoi() + " Resource not found");
            return;
        }
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
        JSONArray author = message.getJSONArray("author");
        String authors = extractAuthors(author);
        String source = extractSource(messageType,message);
        int year = extractYear(message);

        mw.setTitle(title1);
        mw.setType(messageType);
        mw.setCrossrefReferences(referenceCount);
        mw.setCrossrefCitations(referencedByCount);
        mw.setAuthor(authors);
        mw.setSource(source);
        mw.setYear(year);
    }

    private String extractSource(String type,JSONObject message){
        String res = "";
        if (message.has("container-title")){
            JSONArray containerTitle = message.getJSONArray("container-title");
            if (containerTitle.length() > 0) {
                res = containerTitle.getString(0);
            } else {
                warning("No first containerTitle");
            }
        } else {
            severe("no container"+message.toString(4));
        }
        return res;
    }

    private int extractYear(JSONObject message){
        if (message.has("published")) {
            JSONObject published = message.getJSONObject("published");
            if (published.has("date-parts")) {
                JSONArray dateParts = published.getJSONArray("date-parts");
                if (dateParts.length() >0) {
                    JSONArray part0 = dateParts.getJSONArray(0);
                    if (part0.length() > 0) {
                        int year = part0.getInt(0);
                        return year;
                    } else {
                        warning("No first date part");
                    }
                } else {
                    warning("No actual date parts");
                }
            } else {
                warning("no date parts " + published.toString());
            }
        } else if (message.has("created")) {
                JSONObject published = message.getJSONObject("created");
                if (published.has("date-parts")){
                    JSONArray dateParts = published.getJSONArray("date-parts");
                    if (dateParts.length()>0) {
                        JSONArray part0 = dateParts.getJSONArray(0);
                        if (part0.length() >0) {
                            int year = part0.getInt(0);
                            return year;
                        } else {
                            warning("no first date-part");
                        }
                    } else {
                        warning("no actual date-parts");
                    }
                } else {
                    warning("no date parts "+published.toString());
                }
        } else {
            warning("no published "+message.toString(4));
        }
        return 0;

    }

    private String extractAuthors(JSONArray arr){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length();i++){
            if (i > 0){
                sb.append(", ");
            }
            JSONObject author = arr.getJSONObject(i);
            String given = author.getString("given");
            String family = author.getString("family");
            sb.append(given);sb.append(" ");sb.append(family);
        }
        return sb.toString();
    }
}
