package org.insightcentre.pthg24.imports;

import javafx.application.Application;
import org.insightcentre.pthg24.datamodel.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.insightcentre.pthg24.datamodel.SubType.*;
import static org.insightcentre.pthg24.logging.LogShortcut.info;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ImportSubTypes {
    public ImportSubTypes(Scenario base, String importDir, String fileName){
        assert(importDir.endsWith("/"));
        String fullName = importDir+fileName;
        info("full file "+fullName);
        int specialId = 1;
        int linkId = 1;
        try{
            String text = new String(Files.readAllBytes(Paths.get(fullName)));
            info("text "+text);
            JSONArray arr = new JSONArray(text);
            for(int i=0;i<arr.length();i++){
                JSONObject obj = arr.getJSONObject(i);
                if (obj.has("subType")){
                    String subType = obj.getString("subType");
                    JSONArray works = obj.getJSONArray("works");
                    for(int j = 0;j<works.length();j++){

                        Work w = findWork(base,works.getString(j));
                        if (w != null) {
                            w.setSubType(asSubType(subType));
                        }
                    }
                } else if (obj.has("link")){
                    String article = obj.getString("link");
                    String journal = obj.getString("journal");
                    String venue = obj.getString("venue");
                    String basis = obj.getString("basis");
                    Article w = findArticle(base,article);
                    if (w != null) {
                        Link link = new Link(base);
                        link.setName("Link" + linkId++);
                        link.setName("Link" + linkId++);
                        link.setJournal(journal);
                        link.setVenue(venue);
                        link.setBasis(basis);
                        w.setLink(link);
                    }
                    Work p = findWork(base,basis);
                    if(p != null){
                        Link link = new Link(base);
                        link.setName("Link" + linkId++);
                        link.setExtended(article);
                        link.setJournal(journal);
                        link.setVenue(venue);
                        link.setBasis(basis);
                        link.setPaper(p);
                        p.setLink(link);
                    }

                } else if (obj.has("topic")){
                    String topic = obj.getString("topic");
                    String shortName = obj.getString("short");
                    boolean basedOnConference = false;
                    if (obj.has("basedOnConference")){
                        basedOnConference = obj.getBoolean("basedOnConference");
                    }
                    SpecialIssue special = new SpecialIssue(base);
                    special.setName("Special"+specialId++);
                    special.setShortName(shortName);
                    special.setTopic(topic);
                    special.setBasedOnConference(basedOnConference);
                    JSONArray works = obj.getJSONArray("works");
                    for(int j = 0;j<works.length();j++){
                        Article w = findArticle(base,works.getString(j));
                        if (w != null) {
                            w.setSpecialIssue(special);
                        }
                    }

                } else if (obj.has("original")){
                    JSONArray works = obj.getJSONArray("original");
                    for(int j = 0;j<works.length();j++){
                        Article w = findArticle(base,works.getString(j));
                        if (w != null) {
                            w.setIsOriginal(true);
                        }
                    }

                } else if (obj.has("award")){
                    String award = obj.getString("award");
                    JSONArray works = obj.getJSONArray("works");
                    for(int j = 0;j<works.length();j++){
                        Work w = findWork(base,works.getString(j));
                        if (w != null) {
                            w.setAward(award);
                        }
                    }

                }

            }

        } catch(IOException e){
            severe("Cannot read file: "+fullName+", exception "+e.getMessage());
        }

    }

    private Article findArticle(Scenario base, String name){
        Article res = Article.findByName(base,name);
        return res;
    }
    private Work findWork(Scenario base, String name){
        Work res = Work.findByName(base,name);
        return res;
    }

    private SubType asSubType(String v){
        return switch(v){
            case "Regular" -> Regular;
            case "Application" -> SubType.Application;
            case "PhDA" -> PhDA;
            case "Editorial" -> Editorial;
            case "Viewpoint" -> Viewpoint;
            case "Letter" -> Letter;
            case "Benchmarks" -> Benchmarks;
            case "Errata" -> Errata;
            case "Survey" -> Survey;
            case "InvitedTalk" -> InvitedTalk;
            case "ShortPaper" -> ShortPaper;
            case "ExtendedAbstract" -> ExtendedAbstract;
            case "StudentPaper" -> StudentPaper;
            default -> Regular;
        };
    }

}
