package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.analysis.ListWorks.authors;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class WorkWithoutConcepts {
    public WorkWithoutConcepts(Scenario base, WorkType type, String exportDir, String fileName){
        assert(exportDir.endsWith("/"));
        String fullName= exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{llp{5cm}p{10cm}rp{3cm}lr}\n");
            out.printf("\\rowcolor{white}\\caption{%s without Concepts}\\\\ \\toprule\n",type);
            out.printf("\\rowcolor{white}Key & \\shortstack{Local\\\\Copy} & Authors & Title & Year & \\shortstack{Conference\\\\/Journal} & Cite & Pages\\\\ \\midrule\n");
            out.printf("\\endhead\n");
            out.printf("\\bottomrule\n");
            out.printf("\\endfoot\n");
            List<Work> missing  = conceptLess(base,type);
            for(Work w:missing){
                out.printf("%s & \\href{%s}{%s} & %s & %s & %d & %s & \\cite{%s} & %d\\\\",
                        safe(w.getName()),
                        w.getLocalCopy(),"Yes",//safe(w.getName()),
                        authors(w),
                        safe(w.getTitle()),
                        w.getYear(),
                        safe(source(w)),
                        w.getName(),
                        w.getNrPages());
            }
            out.printf("\\end{longtable}\n");
            out.printf("}\n\n");
            out.close();
        } catch(IOException e){
            severe("Cannot write file "+fullName+", exception "+e.getMessage());
        }
    }

    public static String source(Work w){
        if (w instanceof Paper){
            return ((Paper)w).getProceedings().getShortName();
        } else if (w instanceof Article){
            return ((Article)w).getJournal().getName();
        }
        return "";
    }

    private List<Work> conceptLess(Scenario base,WorkType type){
        switch(type){
            case ARTICLE:
                return base.getListArticle().stream().
                        filter(x->!x.getLocalCopy().equals("")).
                        filter(x->!hasConcept(base,x)).
                        sorted(Comparator.comparing(Work::getYear).reversed().thenComparing(Work::getName)).
                        collect(Collectors.toUnmodifiableList());
            case PAPER:
                return base.getListPaper().stream().
                        filter(x->!x.getLocalCopy().equals("")).
                        filter(x->!hasConcept(base,x)).
                        sorted(Comparator.comparing(Work::getYear).reversed().thenComparing(Work::getName)).
                        collect(Collectors.toUnmodifiableList());
            default:
                severe("Bad type "+type);
                assert(false);
                return new ArrayList<>();
        }
    }

    private boolean hasConcept(Scenario base,Work w){
        return base.getListConceptWork().stream().
                filter(x->x.getCount() > 0).
                anyMatch(x->x.getWork()==w);
    }
}
