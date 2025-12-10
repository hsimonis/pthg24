package org.insightcentre.pthg24.imports;

import org.insightcentre.pthg24.datamodel.Article;
import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.datamodel.Work;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.insightcentre.pthg24.logging.LogShortcut.info;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ImportSubTypes {
    public ImportSubTypes(Scenario base, String importDir, String fileName){
        assert(importDir.endsWith("/"));
        String fullName = importDir+fileName;
        info("full file "+fullName);
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

                        Article w = findArticle(base,works.getString(j));
                        if (w != null) {
                            w.setSubType(subType);
                        }
                    }
                } else if (obj.has("linked")){
                    JSONArray works = obj.getJSONArray("linked");
                    for(int j = 0;j<works.length();j++){

                        Article w = findArticle(base,works.getString(j));
                        if (w != null) {
                            w.setLinked(true);
                        }
                    }
                } else if (obj.has("topic")){
                    JSONArray works = obj.getJSONArray("works");
                    for(int j = 0;j<works.length();j++){
                        Article w = findArticle(base,works.getString(j));
                        if (w != null) {
                            w.setInSpecialIssue(true);
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

}
