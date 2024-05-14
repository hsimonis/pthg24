package org.insightcentre.pthg24.pdfgrep;

import org.insightcentre.pthg24.datamodel.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Hashtable;

import static org.insightcentre.pthg24.datamodel.MatchLevel.*;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;
import static org.insightcentre.pthg24.logging.LogShortcut.warning;

public class ConceptWorkHash {
    Scenario base;
    Hashtable<String, ConceptWork> conceptWorkHash;

    public ConceptWorkHash(Scenario base,String file){
        this.base = base;
        load(file);
        conceptWorkHash = new Hashtable<>();
        for(ConceptWork cw:base.getListConceptWork()){
            conceptWorkHash.put(key(cw.getConcept(),cw.getWork()),cw);
        }
    }


    public boolean present(Concept c, Work w){
        return conceptWorkHash.get(key(c,w)) != null;
    }

    private String key(Concept c, Work w){
        return c.getName()+"/"+w.getName();
    }

    public void add(ConceptWork cw){
        conceptWorkHash.put(key(cw.getConcept(),cw.getWork()),cw);
    }

    public void save(String file){
        JSONArray arr = new JSONArray();
        for(String key:conceptWorkHash.keySet()){
            ConceptWork cw = conceptWorkHash.get(key);
            JSONObject obj = new JSONObject();
            obj.put("concept",cw.getConcept().getName());
            obj.put("work",cw.getWork().getName());
            obj.put("count",cw.getCount());
            obj.put("matchLevel",cw.getMatchLevel().toString());
            if (cw.getConcept().getRevision() > 0){
                obj.put("revision",cw.getConcept().getRevision());
            }
            arr.put(obj);
        }
        try {
            PrintWriter out = new PrintWriter(file);
            arr.write(out,1,4);
            out.close();
        } catch(IOException e){
            severe("Cannot write file "+file+", exception "+e.getMessage());
        }
    }

    private void load(String file){
        try {
            String text = new String(Files.readAllBytes(Paths.get(file)));
            JSONArray arr = new JSONArray(text);
            for(int i=0;i<arr.length();i++) {
                JSONObject obj = arr.getJSONObject(i);
                String c = obj.getString("concept");
                String w = obj.getString("work");
                int count = obj.getInt("count");
                String ml = obj.getString("matchLevel");
                Concept concept = Concept.findByName(base,c);
                Work work = Work.findByName(base,w);
                MatchLevel matchLevel = findMatchLevel(ml);
                int revision =0;
                if (obj.has("revision")){
                    revision = obj.getInt("revision");
                }
                if (concept != null &&
                        work != null &&
                        work.getLocalCopy() != null &&
                        !work.getLocalCopy().equals("") &&
                        revision >= concept.getRevision()){
                    ConceptWork cw = new ConceptWork(base);
                    cw.setConcept(concept);
                    cw.setWork(work);
                    cw.setCount(count);
                    cw.setMatchLevel(matchLevel);

                } else {
                    warning("Inconsistent saved ConceptWork "+c+" "+w+" "+revision);
                }

            }
        } catch(IOException e){
            severe("Cannot read file "+file+", exception "+e.getMessage());
        }

    }

    private MatchLevel findMatchLevel(String ml){
        switch(ml){
            case "None": return None;
            case "Weak": return Weak;
            case "Medium": return Medium;
            case "Strong": return Strong;
            default:
                severe("Bad matchlevel "+ml);
                return null;
        }
    }

}
