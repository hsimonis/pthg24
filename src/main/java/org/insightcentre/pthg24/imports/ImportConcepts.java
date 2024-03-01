package org.insightcentre.pthg24.imports;

import org.insightcentre.pthg24.datamodel.Concept;
import org.insightcentre.pthg24.datamodel.ConceptType;
import org.insightcentre.pthg24.datamodel.Scenario;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.insightcentre.pthg24.datamodel.ConceptType.*;
import static org.insightcentre.pthg24.logging.LogShortcut.info;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ImportConcepts {
    public ImportConcepts(Scenario base, String importDir, String fileName){
        assert(importDir.endsWith("/"));
        String fullName = importDir+fileName;
        try{
            String text = new String(Files.readAllBytes(Paths.get(fullName)));
//            info("text "+text);
            JSONObject ref = new JSONObject(text);
            JSONArray arr = ref.getJSONArray("arr");
            for(int i=0;i<arr.length();i++){
                JSONObject c = arr.getJSONObject(i);
                String type = c.getString("type");
                String label = c.getString("label");
                String regExpr = c.getString("regExpr");
                Concept con = new Concept(base);
                con.setName(label);
                con.setLabel(label);
                con.setRegExpr(regExpr);
                con.setConceptType(stringToConceptType(type));
            }

        } catch(IOException e){
            severe("Cannot read file: "+fullName+", exception "+e.getMessage());
        }

    }

    private ConceptType stringToConceptType(String text){
        switch(text){
            case "Concepts":return Concepts;
            case "Classification":return Classification;
            case "Constraints":return Constraints;
            case "ApplicationAreas":return ApplicationAreas;
            case "Industries":return Industries;
            case "ProgLanguages":return ProgLanguages;
            case "CPSystems":return CPSystems;
            case "Benchmarks":return Benchmarks;
            case "Algorithms":return Algorithms;
           default: return null;
        }
    }

}
