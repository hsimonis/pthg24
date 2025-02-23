package org.insightcentre.pthg24.imports;

import org.insightcentre.pthg24.datamodel.Acronym;
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
    Scenario base;
    public ImportConcepts(Scenario base, String importDir, String fileName){
        this.base = base;
        assert(importDir.endsWith("/"));
        String fullName = importDir+fileName;
        try{
            String text = new String(Files.readAllBytes(Paths.get(fullName)));
//            info("text "+text);
            JSONArray arr = new JSONArray(text);
            for(int i=0;i<arr.length();i++){

                JSONObject conceptType = arr.getJSONObject(i);
                String name = conceptType.getString("conceptType");
                assert(ConceptType.findByName(base,name)== null);
                ConceptType ct = new ConceptType(base);
                ct.setName(name);
                if (conceptType.has("weightA")){
                    ct.setWeightA(conceptType.getDouble("weightA"));
                }
                if (conceptType.has("weightB")){
                    ct.setWeightB(conceptType.getDouble("weightB"));
                }
                if (conceptType.has("weightC")){
                    ct.setWeightC(conceptType.getDouble("weightC"));
                }
                JSONArray concepts = conceptType.getJSONArray("concepts");
                for(int j=0;j<concepts.length();j++) {
                    JSONObject c = concepts.getJSONObject(j);
                    String label = c.getString("label");
                    String regExpr = "";
                    if (c.has("regExpr")) {
                        regExpr = c.getString("regExpr");
                    }
                    boolean caseSensitive = false;
                    if (c.has("caseSensitive")) {
                        caseSensitive = c.getBoolean("caseSensitive");
                    }
                    int revision = 0;
                    if (c.has("revision")) {
                        revision = c.getInt("revision");
                    }
                    double weight = 1.0;
                    if (c.has("weight")) {
                        weight = c.getDouble("weight");
                    }
                    Concept con;
                    if (c.has("description")) {
                        String description = c.getString("description");
                        con = new Acronym(base);
                        ((Acronym) con).setDescription(description);
                    } else {
                        con = new Concept(base);
                    }
                    con.setName(label);
                    con.setShortName(label);
                    con.setLabel(label);
                    con.setRevision(revision);
                    con.setConceptType(ct);
                    con.setCaseSensitive(caseSensitive);
                    con.setWeight(weight);
                    if (!regExpr.equals("")) {
                        con.setRegExpr(regExpr);
                    } else if (con instanceof Acronym) {
                        // we only want to match the acronym itself, not any longer word containing it
                        con.setRegExpr("[^a-zA-Z]" + label + "[^a-zA-Z]");
                        //??? temporary fix to force recalculation
                        con.setRevision(2);
                    } else {
                        con.setRegExpr(label);
                    }
                }
            }

        } catch(IOException e){
            severe("Cannot read file: "+fullName+", exception "+e.getMessage());
        }
    }
}
