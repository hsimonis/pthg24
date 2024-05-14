package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.analysis.ListWorks.local;
import static org.insightcentre.pthg24.datamodel.MatchLevel.*;
import static org.insightcentre.pthg24.imports.Importer.safer;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ListByConcept {
    public ListByConcept(Scenario base, String exportDir, String fileName){
        assert(exportDir.endsWith("/"));
        String fullName=exportDir+fileName;
        try {
            PrintWriter out = new PrintWriter(fullName);
            for(ConceptType type:base.getListConceptType()){
                out.printf("\\clearpage\n");
                out.printf("\\subsection{Concept Type %s}\n",safe(type.toString()));
                out.printf("\\label{sec:%s}\n",safe(type.toString()));
                out.printf("\\label{%s}\n",safe(type.toString()));
                out.printf("{\\scriptsize\n");
                List<Concept> list = sortedConcepts(base, type);
                int nrConcepts = (int) base.getListConcept().stream().filter(x->x.getConceptType()==type).count();
                int usedConcepts = list.size();
                out.printf("\\begin{longtable}{p{3cm}r>{\\raggedright\\arraybackslash}p{6cm}>{\\raggedright\\arraybackslash}p{6cm}>{\\raggedright\\arraybackslash}p{8cm}}\n");
                out.printf("\\rowcolor{white}\\caption{Works for Concepts of Type %s (Total %d Concepts, %d Used)}\\\\ \\toprule\n",safe(type.toString()),nrConcepts,usedConcepts);
                out.printf("\\rowcolor{white}Keyword & Weight & High & Medium & Low\\\\ \\midrule");
                out.printf("\\endhead\n");
                out.printf("\\bottomrule\n");
                out.printf("\\endfoot\n");
                for (Concept c : list) {
                    out.printf("\\index{%s}",safer(safe(c.getName())));
                    out.printf("\\index{%s!%s}",safe(type.toString()), safer(safe(c.getName())));
                    out.printf("%s", safer(safe(c.getName())));
                    out.printf(" & %5.2f",c.getWeight());
                    out.printf(" & %s", concepts(base, c, Strong));
                    out.printf(" & %s", concepts(base, c, Medium));
                    out.printf(" & %s", concepts(base, c, Weak));
                    out.printf("\\\\\n");
                }
                out.printf("\\end{longtable}\n");
                out.printf("}\n\n");
            }
            out.close();
        } catch(IOException e){
            severe("Cannot write file "+fullName+", exception "+e.getMessage());
            assert(false);
        }
    }

    private List<Concept> sortedConcepts(Scenario base,ConceptType type){
        return base.getListConcept().stream().
                filter(x -> x.getConceptType() == type).
                filter(x->x.getNrOccurrences() > 0).
                sorted(Comparator.comparing(Concept::getName)).
                toList();
    }

    private String concepts(Scenario base, Concept c, MatchLevel level){
        int limit = 30;
        int limitTail=10;
        List<String> citations = base.getListConceptWork().stream().
                filter(x -> x.getConcept() == c).
                filter(x -> x.getMatchLevel() == level).
                filter(x -> !x.getWork().getBackground()).
                sorted(Comparator.comparing(this::getYear).reversed()).
                map(x -> citation(x.getWork())).
                toList();
        int size = citations.size();
        if (size > limit){
            return String.join(", ", citations.subList(0,limit-(limitTail+1)))+
                    "..."+
                    String.join(", ",citations.subList(size-(limitTail+1),size-1))+
                    " (Total: "+citations.size()+")";
        } else {
            return String.join(", ", citations);
        }
    }

    private int getYear(ConceptWork cw){
        return cw.getWork().getYear();
    }

    public static String citation(Work w){
        return "\\href{"+local(w.getLocalCopy())+"}{"+w.getName()+"}~\\cite{"+safer(w.getName())+"}";
    }


}
