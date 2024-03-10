package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class UnmatchedConcepts {
    public UnmatchedConcepts(Scenario base, String exportDir, String fileName){
        assert(exportDir.endsWith("/"));
        String fullName= exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{lp{10cm}rr}\n");
            out.printf("\\caption{Unmatched Concepts}\\\\ \\toprule\n");
            out.printf("Type & Name & CaseSensitive & Revision\\\\ \\midrule\n");
            out.printf("\\endhead\n");
            out.printf("\\bottomrule\n");
            out.printf("\\endfoot\n");
            List<Concept> unmatched  = unmatchedConcept(base);
            for(Concept c:unmatched){
                out.printf("%s & %s & %s & %d\\\\",
                        safe(c.getConceptType().toString()),
                        safe(c.getName()),
                        (c.getCaseSensitive()?"Y":""),
                        c.getRevision());
            }
            out.printf("\\end{longtable}\n");
            out.printf("}\n\n");
            out.close();
        } catch(IOException e){
            severe("Cannot write file "+fullName+", exception "+e.getMessage());
        }
    }



    private List<Concept> unmatchedConcept(Scenario base){
                return base.getListConcept().stream().
                        filter(x->!hasWork(base,x)).
                        sorted(Comparator.comparing(Concept::getConceptType).reversed().thenComparing(Concept::getName)).
                        collect(Collectors.toUnmodifiableList());
    }

    private boolean hasWork(Scenario base,Concept c){
        return base.getListConceptWork().stream().
                filter(x->x.getCount() > 0).
                anyMatch(x->x.getConcept()==c);
    }
}
