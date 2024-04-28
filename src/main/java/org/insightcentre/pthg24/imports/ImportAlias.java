package org.insightcentre.pthg24.imports;

import org.insightcentre.pthg24.datamodel.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.insightcentre.pthg24.datamodel.ConceptType.*;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ImportAlias {
    public ImportAlias(Scenario base, String importDir, String fileName){
        assert(importDir.endsWith("/"));
        String fullName = importDir+fileName;
        try{
            String text = new String(Files.readAllBytes(Paths.get(fullName)));
//            info("text "+text);
            JSONArray arr = new JSONArray(text);
            for(int i=0;i<arr.length();i++){
                JSONObject c = arr.getJSONObject(i);
                String journal = c.getString("journal");
                String alias = c.getString("alias");
                String issn = c.getString("issn");

                JournalAlias ja = new JournalAlias(base);
                ja.setJournal(findJournal(base,journal));
                ja.setAlias(alias);
                ja.getJournal().setIssn(issn);
            }

        } catch(IOException e){
            severe("Cannot read file: "+fullName+", exception "+e.getMessage());
        }

    }

    private Journal findJournal(Scenario base, String name){
        Journal res = Journal.findByName(base,name);
        if (res == null){
            res = new Journal(base);
            res.setName(name);
        }
        return res;
    }

}
