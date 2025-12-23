package org.insightcentre.pthg24.pdfgrep;

import org.insightcentre.pthg24.datamodel.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.groupingBy;
import static org.insightcentre.pthg24.datamodel.MatchLevel.*;
import static org.insightcentre.pthg24.logging.LogShortcut.info;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;
import static org.insightcentre.pthg24.pdfgrep.RunPDFInfoURL.deleteExistingResultFile;

public class RunMemoryGrep {
    public RunMemoryGrep(Scenario base, String importDir, String textDir,boolean performConceptMatching){
        info("Starting grep");
        String savedFile = importDir+"savedConceptWork.json";
        String tmpFile = importDir+"tmpConceptWork.json";
        ConceptWorkHash cwh = new ConceptWorkHash(base,savedFile);
        if (performConceptMatching) {
            for (Work a : base.getListWork().stream().
                    filter(x -> x.getLocalCopy() != null).
                    filter(x -> !x.getLocalCopy().equals("")).
                    sorted(Comparator.comparing(Work::getName)).
                    toList()) {
                String fullName = textDir+a.getName()+".txt";
                try {
                    boolean loaded = false;
                    String text=null;
                    String lowerText = null;
                    info("Work "+a.getName());

                    for (ConceptType ct : base.getListConceptType()) {
                        for (Concept c : base.getListConcept().stream().
                                filter(x -> x.getConceptType() == ct).
                                sorted(Comparator.comparing(Concept::getLabel)).
                                toList()) {
//                            info("Type " + c.getConceptType() + " Concept " + c.getName());
                            if (!cwh.present(c, a)) {
                                // only load text from file on demand
                                if (!loaded){
                                    loaded = true;
                                    text = new String(Files.readAllBytes(Paths.get(fullName)));
                                    lowerText = text.toLowerCase();
                                }
                                int v = performGrep(c,text,lowerText);

                                if (v > 0) {
                                    info("    "+c.getName()+": " + v);
                                }
                                ConceptWork cw = new ConceptWork(base);
                                cw.setConcept(c);
                                cw.setWork(a);
                                cw.setCount(v);
                                cw.setMatchLevel(matchLevel(v));
                                cwh.add(cw);
                            }
                        }
                    }
                    if (loaded) {
                        //??? do we need to save to a temporary file
//                        cwh.save(tmpFile);
                    }
                } catch(IOException e){
                    severe("Cannot read text file for matching "+fullName+", exception "+e.getMessage());
                    assert(false);
                }

            }
            cwh.save(savedFile);
        }
        info("greps done");
        updateNrOccurences(base);
    }

    private int performGrep(Concept c,String text,String lowerText){
        Pattern pattern = Pattern.compile(c.getRegExpr());
        Matcher matcher = pattern.matcher(c.getCaseSensitive()?text:lowerText);
        return (int) matcher.results().count();
    }



    private MatchLevel matchLevel(int count){
        if (count ==0) {
            return None;
        } else if (count <= 2){
            return Weak;
        } else if (count <= 5){
            return Medium;
        } else {
            return Strong;
        }
    }

    private void updateNrOccurences(Scenario base){
        Map<Concept, List<ConceptWork>> map = base.getListConceptWork().stream().filter(x->x.getCount() > 0).collect(groupingBy(ConceptWork::getConcept));
        for(Concept c:map.keySet()){
            int nrOccurs = map.get(c).stream().mapToInt(ConceptWork::getCount).sum();
            c.setNrOccurrences(nrOccurs);
        }
        Map<Work,List<ConceptWork>> mapWork = base.getListConceptWork().stream().filter(x->x.getCount() > 0).collect(groupingBy(ConceptWork::getWork));
        for(Work w:mapWork.keySet()){
            int cnt = mapWork.get(w).size();
            w.setNrConcepts(cnt);
        }
    }
}

