package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.datamodel.ConceptType.*;
import static org.insightcentre.pthg24.datamodel.MatchLevel.*;
import static org.insightcentre.pthg24.imports.Importer.safer;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class AnalysisByConcept {
    public AnalysisByConcept(Scenario base, String exportDir, String fileName){
        assert(exportDir.endsWith("/"));
        String fullName = exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{llp{6cm}p{6cm}p{6cm}}\n");
            out.printf("\\caption{Papers by Domain and Keyword}\\\\ \\toprule\n");
            out.printf("Domain & Keyword & High & Medium & Low\\\\ \\midrule");
            out.printf("\\endhead\n");
            out.printf("\\bottomrule\n");
            out.printf("\\endfoot\n");
            for(ConceptType type:new ConceptType[]{Concepts,Classification,Constraints,ProgLanguages,CPSystems,ApplicationAreas,Industries,Benchmarks,Algorithms}){
                for(Concept c:sortedConcepts(base,type)) {
                    out.printf("%s & %s", safe(type.toString()),safer(safe(c.getName())));
                    out.printf(" & %s", concepts(base, c,Strong));
                    out.printf(" & %s", concepts(base, c,Medium));
                    out.printf(" & %s", concepts(base, c,Weak));
                    out.printf("\\\\\n");
                }
            }
            out.printf("\\end{longtable}\n");
            out.printf("}\n\n");
            out.close();
        } catch(IOException e){
            severe("Cannot write file "+fullName);
            assert(false);
        }
    }

    private List<Concept> sortedConcepts(Scenario base,ConceptType type){
        return base.getListConcept().stream().
                filter(x->x.getConceptType()==type).
                sorted(Comparator.comparing(Concept::getName)).collect(Collectors.toUnmodifiableList());
    }

    private String dirName(Work w){
        if (w instanceof Paper){
            return "papers";
        } else {
            return "articles";
        }
    }

    private List<Work> sortedWorks(Scenario base){
        return base.getListWork().stream().
                sorted(Comparator.comparing(Work::getName)).
                collect(Collectors.toUnmodifiableList());
    }

    private String concepts(Scenario base, Concept c, MatchLevel level){
        List<String> citations = base.getListConceptWork().stream().
                filter(x->x.getConcept()==c).
                filter(x->x.getMatchLevel()==level).
                sorted(Comparator.comparing(this::getYear).reversed()).
                map(x->citation(x.getWork())).
                collect(Collectors.toUnmodifiableList());
        return String.join(", ",citations);
    }

    private int getYear(ConceptWork cw){
        return cw.getWork().getYear();
    }

    private String citation(Work w){
        return "\\href{"+w.getLocalCopy()+"}{"+w.getName()+"}\\cite{"+safer(w.getName())+"}";
    }


}
