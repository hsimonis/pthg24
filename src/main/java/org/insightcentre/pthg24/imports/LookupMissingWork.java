package org.insightcentre.pthg24.imports;

import org.apache.commons.lang3.StringUtils;
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
import java.util.Comparator;
import java.util.Locale;

import static org.insightcentre.pthg24.imports.ImportCrossref.*;
import static org.insightcentre.pthg24.imports.Keys.scopusKey;
import static org.insightcentre.pthg24.logging.LogShortcut.*;

public class LookupMissingWork {
    Scenario base;
    String missingWorkDir;
    int nrGets = 0;
    int getLimit = 0;
    int discoverable = 0;

    public LookupMissingWork(Scenario base, String missingWorkDir, int linkCountLimit,int getLimit) {
        this.base = base;
        this.getLimit = getLimit;
        this.missingWorkDir = missingWorkDir;
        for (MissingWork mw : base.getListMissingWork().stream().
                filter(x -> x.getNrLinks() >= linkCountLimit).
                sorted(Comparator.comparing(MissingWork::getNrLinks).reversed()).
                toList()) {
            lookup(mw);
//            lookupScopus(mw);
        }
        info("ToDo: "+discoverable+" works to be checked");
    }

    private void lookup(MissingWork mw) {
        String target = "";
        try {
            String saveFile = missingWorkDir + URLEncoder.encode(properDOI(mw.getDoi()), StandardCharsets.UTF_8.toString()) + ".json";
            if (exists(saveFile)){
                info("Reading file "+saveFile);
                interpret(mw,contents(saveFile));
            } else {
                if (mw.getDoi() != null && !mw.getDoi().equals("") && nrGets++ < getLimit) {
                    target = "https://api.crossref.org/works/" + URLEncoder.encode(properDOI(mw.getDoi()), StandardCharsets.UTF_8.toString());
                    URI targetURI = new URI(target);
                    HttpRequest httpRequest = HttpRequest.newBuilder()
                            .uri(targetURI)
//                            .header("authorization",token)
                            .GET()
                            .build();
                    HttpClient httpClient = HttpClient.newHttpClient();
                    HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                    info("Result " + nrGets+" links "+mw.getNrLinks()+" reponse "+response );
//                    info("Result " + response + " body " + response.body());
                    PrintWriter out = new PrintWriter(saveFile);
                    out.print(response.body());
                    out.close();
                    interpret(mw, response.body());
                } else {
                    if (nrGets < getLimit){
                        warning("DOI not usable for missing work doi " + mw.getDoi());
                    } else {
                        discoverable++;
//                        warning("To be discovered doi "+mw.getDoi());
                   }
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
                if (mw.getDoi() != null && !mw.getDoi().equals("") && nrGets<getLimit) {
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
                    info("Result " + response);
//                    info("Result " + response + " body " + response.body());
                    PrintWriter out = new PrintWriter(saveFile);
                    out.print(response.body());
                    out.close();
                    interpretScopus(mw, response.body());
                } else {
                    if (nrGets < getLimit) {
                        warning("DOI not usable for work " + mw.getName() + " doi " + mw.getDoi());
                    }

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
        String titleText = "";
        if (title.length() > 0) {
            titleText = title.getString(0);
            if (!StringUtils.isMixedCase(titleText)){
                info("Capitalize "+titleText);
                titleText = StringUtils.capitalize(titleText.toLowerCase());
            }
            titleText = removeEntity(titleText.replaceAll("<[^>]*>","").replaceAll("</[^>]*>",""));
        } else {
            warning("No titleText "/*+message.toString(4)*/);
        }
        String authors = "";
        if (message.has("author")) {
            JSONArray author = message.getJSONArray("author");
            authors = extractAuthors(author);
        }
        String editors = "";
        if (message.has("editor")) {
            JSONArray editor = message.getJSONArray("editor");
            editors = extractAuthors(editor);
        }
        if (authors.equals("") && editors.equals("")){
            warning("Neither author nor editors "/*+message.toString(4)*/);
        }
        String publisher="";
        if (message.has("publisher")){
            publisher = message.getString("publisher");
        }
        String volume="";
        if (message.has("volume")){
            volume = message.getString("volume");
        }
        String issue="";
        if (message.has("issue")){
            issue = message.getString("issue");
        }
        String page="";
        if (message.has("page")){
            page = message.getString("page");
        }
        String chapter="";
        if (message.has("chapter")){
            chapter = message.getString("chapter");
        }
        String url="";
        if (message.has("URL")){
            url = message.getString("URL");
        }
        String abstractText="";
        if (message.has("abstract")){
            abstractText = removeMarkup(message.getString("abstract"));
        }
        String source = extractSource(messageType,message);
        int year = extractYear(message);

        mw.setTitle(titleText);
        mw.setType(messageType);
        mw.setCrossrefReferences(referenceCount);
        mw.setCrossrefCitations(referencedByCount);
        mw.setAuthor(authors);
        mw.setEditor(editors);
        mw.setSource(source);
        mw.setYear(year);
        mw.setPublisher(publisher);
        mw.setVolume(volume);
        mw.setIssue(issue);
        mw.setPage(page);
        mw.setChapter(chapter);
        mw.setUrl(url);
        mw.setAbstractText(abstractText);
    }

    public static String removeMarkup(String t){
        return t.replaceAll("<jats:[^>]*>"," ").replaceAll("</jats:[^>]*>"," ").
                //??? if you remove this xml, then the rest of the abstract it contains has more problems
//                replaceAll("<mml:[^>]*>"," ").replaceAll("</mml:[^>]*>"," ").
                replaceAll("<\\w*>","").replaceAll("</\\w*>","").
                replace("&#x0D;"," ").replace("&\\#x0D;"," ").replaceAll("#","\\\\#");
    }

    private String extractSource(String type,JSONObject message){
        String res = "";
        if (message.has("container-title")){
            JSONArray containerTitle = message.getJSONArray("container-title");
            if (containerTitle.length() > 0) {
                res = removeEntity(containerTitle.getString(0));
            } else {
                if (!type.equals("book") && !type.equals("monograph")&& !type.equals("edited-book")&&
                        !type.equals("report")&& !type.equals("reference-book")&& !type.equals("posted-content")) {
                    warning("No first containerTitle"/* + message.toString(4)*/);
                }
            }
        } else {
            severe("no container"+message.toString(4));
        }
        return res;
    }

    private String removeEntity(String text){
        return text.replace("&amp;","\\&").replaceAll("&\\w*;","");
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
            String given = "";
            if (author.has("given")) {
                given = removeAllCaps(author.getString("given"));
            } else {
//                warning("No given name "+author.toString(4));
            }

            String family = "";
            if (author.has("family")) {
                family = removeAllCaps(author.getString("family"));
            } else {
                warning("No family name "+author.toString(4));
            }
            sb.append(given);sb.append(" ");sb.append(family);
        }
        //??? special hack to eliminate some non unicode characters that create problems for lualatex
        return sb.toString().replace("�","").replace("�","");
    }

    private String removeAllCaps(String name){
        if (name.matches("[A-Z]")){
//            info("solo "+name);
            return name+".";
        }
        if (name.matches("[A-Z]\\.")){
//            info("abbrev "+name);
            return name;
        }
        if (name.matches("[A-Z]\\.[A-Z]\\.")){
//            info("double abbrev "+name);
            return name.charAt(0)+". "+name.charAt(2)+".";
        }
        if (name.matches("[A-Z]\\.[A-Z]\\.[A-Z]\\.")){
//            info("triple abbrev "+name);
            return name.charAt(0)+". "+name.charAt(2)+". "+name.charAt(4)+".";
        }
        if (name.contains(" ")) {
            String[] split = name.split(" ");
            for (int i = 0; i < split.length; i++) {
                split[i] = removeAllCaps(split[i]);
            }
            return String.join(" ", split);
        } else if (name.contains("-")) {
            String[] split = name.split("-");
            for (int i = 0; i < split.length; i++) {
                split[i] = removeAllCaps(split[i]);
            }
            return String.join("-", split);
        } else {
            if (StringUtils.isMixedCase(name) ||StringUtils.isAllLowerCase(name)) {
                return name;
            }
//            info("capit "+name);
            return StringUtils.capitalize(name.toLowerCase());
        }
    }
}
