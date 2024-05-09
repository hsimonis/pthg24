package org.insightcentre.pthg24.imports;

import org.insightcentre.pthg24.datamodel.ConferenceSeries;
import org.insightcentre.pthg24.datamodel.Journal;
import org.insightcentre.pthg24.datamodel.Scenario;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Hashtable;

import static org.insightcentre.pthg24.logging.LogShortcut.*;

public class ImportConferenceSeries {
    public ImportConferenceSeries(Scenario base, String importDir, String fileName){
        assert(importDir.endsWith("/"));
        String fullName = importDir+fileName;
        info("full file "+fullName);
        Hashtable<String,ConferenceSeries> hash = new Hashtable<>();
        try{
            String text = new String(Files.readAllBytes(Paths.get(fullName)));
            info("text "+text);
            JSONArray arr = new JSONArray(text);
            for(int i=0;i<arr.length();i++) {
                JSONObject obj = arr.getJSONObject(i);
                String abbrev = obj.getString("abbrev");
                String description = obj.getString("name");
                String regExpr = "";
                if (obj.has("regExpr")){
                    regExpr = obj.getString("regExpr");
                }
                if(hash.get(abbrev)!= null){
                    severe("Duplicate conference series "+abbrev+" description "+description);
                    assert(false);
                }
                ConferenceSeries cs = new ConferenceSeries(base);
                cs.setName(abbrev);
                cs.setDescription(description);
                cs.setRegExpr(regExpr);
                hash.put(abbrev,cs);
            }

        } catch(IOException e){
            severe("Cannot read file: "+fullName+", exception "+e.getMessage());
        }

    }



}
