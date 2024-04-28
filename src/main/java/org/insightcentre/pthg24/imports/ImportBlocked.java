package org.insightcentre.pthg24.imports;

import org.insightcentre.pthg24.datamodel.Journal;
import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.datamodel.Work;
import org.json.JSONArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.insightcentre.pthg24.logging.LogShortcut.*;

public class ImportBlocked {
    public ImportBlocked(Scenario base, String importDir, String fileName){
        assert(importDir.endsWith("/"));
        String fullName = importDir+fileName;
        info("full file "+fullName);
        try{
            String text = new String(Files.readAllBytes(Paths.get(fullName)));
            info("text "+text);
            JSONArray arr = new JSONArray(text);
            for(int i=0;i<arr.length();i++){
                Journal j = findJournal(base,arr.getString(i));
                if (j != null) {
                    j.setIsBlocked(true);
                } else {
                    warning("Blocked, Unknown journal in line "+i+" "+arr.getString(i));
                }
            }

        } catch(IOException e){
            severe("Cannot read file: "+fullName+", exception "+e.getMessage());
        }

    }

    private Journal findJournal(Scenario base, String name){
        Journal res = Journal.findByName(base,name);
//        assert(res != null);
        return res;
    }

}
