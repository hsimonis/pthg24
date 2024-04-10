package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.datamodel.Similarity;
import org.insightcentre.pthg24.datamodel.Work;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static framework.reports.AbstractCommon.safe;
import static java.util.stream.Collectors.groupingBy;
import static org.insightcentre.pthg24.analysis.ListWorks.local;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ListSimilarity {
    public ListSimilarity(Scenario base, String exportDir, String fileName){
        assert(exportDir.endsWith("/"));
        String fullFile = exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullFile);
            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{llllll}\n");
            out.printf("\\caption{Most Similar Works}\\\\ \\toprule\n");
            out.printf("Work & 1 & 2 & 3 & 4 & 5 \\\\ \\midrule");
            out.printf("\\endhead\n");
            out.printf("\\bottomrule\n");
            out.printf("\\endfoot\n");
            Map<Work, List<Similarity>> map = base.getListSimilarity().stream().
                    collect(groupingBy(Similarity::getWork1));
            for(Work w:map.keySet().stream().sorted(Comparator.comparing(Work::getName)).toList()){
                List<Similarity> mostSimilar = map.get(w).stream().
                        filter(x->!Double.isNaN(x.getSimilarity())).
                        filter(x->x.getSimilarity() > 0.0).
                        sorted(Comparator.comparing(Similarity::getSimilarity).reversed()).
                        limit(5).
                        toList();
                out.printf("%s",keyLink(w));
                for(Similarity s:mostSimilar){
                    out.printf("& %s (%.2f)",keyLink(s.getWork2()),s.getSimilarity());
                }
                out.printf("\\\\\n");
                List<Similarity> mostConcept = map.get(w).stream().
                        filter(x->!Double.isNaN(x.getSimilarityConcept())).
                        sorted(Comparator.comparing(Similarity::getSimilarityConcept)).
                        limit(5).
                        toList();
                for(Similarity s:mostConcept){
                    out.printf("& %s (%.2f)",keyLink(s.getWork2()),s.getSimilarityConcept());
                }
                out.printf("\\\\\n");

            }
            out.printf("\\end{longtable}\n");
            out.printf("}\n\n");
            out.close();
        } catch(IOException e){
            severe("Cannot write file "+fullFile+", exception "+e.getMessage());
        }
    }

    private String keyLink(Work w){
        if (w.getLocalCopy()==null ||w.getLocalCopy().equals("")){
            return safe(w.getKey());
        } else {
            return "\\href{"+local(w.getLocalCopy())+"}{"+safe(w.getKey())+"}";
        }
    }
}
