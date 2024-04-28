package org.insightcentre.pthg24.clustering;

import org.insightcentre.pthg24.datamodel.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class DumpFeatures {
    Scenario base;
    public DumpFeatures(Scenario base, String dumpDir, String fileName){
        this.base = base;
        assert(dumpDir.endsWith("/"));
        String fullName = dumpDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            List<Concept> concepts =base.getListConcept().stream().
                    sorted(Comparator.comparing(Concept::getConceptType).thenComparing(Concept::getName)).
                    toList();
            header(out,concepts);
            body(out,concepts,5);
            out.close();
        } catch(IOException e){
            severe("Cannot write file: "+fullName+", exception "+e.getMessage());
        }
    }

    private void header(PrintWriter out,List<Concept> concepts){
        out.printf("\"Work\"");
        for(Concept c:concepts){
            out.printf(",\"%s\"",c.getName());
        }
        out.printf("\n");
    }

    private void body(PrintWriter out,List<Concept> concepts,int minFeatures){
        Map<Work,List<ConceptWork>> map = base.getListConceptWork().stream().collect(groupingBy(ConceptWork::getWork));
        for(Work w:base.getListWork().stream().
                filter(x->x.getNrConcepts() >= minFeatures).
                sorted(Comparator.comparing(Work::getName)).
                toList()){
            List<ConceptWork> list = map.get(w);
            if (list != null) {
                line(out, w, list, concepts);
            }
        }
    }

    private void line(PrintWriter out,Work w,List<ConceptWork> features,List<Concept> concepts){
        Hashtable<Concept,ConceptWork> hash  = new Hashtable<>();
        for(ConceptWork cw:features){
            hash.put(cw.getConcept(),cw);
        }
        out.printf("\"%s\"",w.getKey());
        for(Concept c:concepts){
            ConceptWork cw = hash.get(c);
            if (cw== null){
                out.printf(", NaN");
            } else {
                out.printf(", %5.2f",level(cw.getMatchLevel()));
            }
        }
        out.printf("\n");
    }

    private double level(MatchLevel m){
        switch(m){
            case None: return 0;
            case Weak: return 0.2;
            case Medium: return 0.7;
            case Strong: return 1.0;
            default:
                severe("Bad matchLevel "+m);
                assert(false);
                return 0.0;
        }
    }
}
