package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.datamodel.Work;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.analysis.WorkWithoutConcepts.source;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class MissingLocalCopy {
    public MissingLocalCopy(Scenario base, String type, String exportDir, String fileName){
        assert(exportDir.endsWith("/"));
        String fullName= exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{llp{5cm}p{10cm}rp{3cm}l}\n");
            out.printf("\\caption{%s without Local Copy}\\\\ \\toprule\n",type);
            out.printf("Key & URL & Authors & Title & Year & \\shortstack{Conference\\\\/Journal} & Cite\\\\ \\midrule\n");
            out.printf("\\endhead\n");
            out.printf("\\bottomrule\n");
            out.printf("\\endfoot\n");
            List<Work> missing  = missing(base,type);
            for(Work w:missing){
                out.printf("%s & \\href{%s}{%s} & %s & %s & %d & %s & \\cite{%s}\\\\",
                        safe(w.getName()),
                        w.getUrl(),
                        safe(w.getName()),
                        safe(w.getAuthor()),safe(w.getTitle()),
                        w.getYear(),
                        safe(source(w)),
                        w.getName());
            }
            out.printf("\\end{longtable}\n");
            out.printf("}\n\n");
            out.close();
        } catch(IOException e){
            severe("Cannot write file "+fullName+", exception "+e.getMessage());
        }
    }

    private List<Work> missing(Scenario base,String type){
        switch(type){
            case "Article":
                return base.getListArticle().stream().
                        filter(x->x.getLocalCopy().equals("")).
                        sorted(Comparator.comparing(Work::getYear).reversed().thenComparing(Work::getName)).
                        collect(Collectors.toUnmodifiableList());
            case "Paper":
                return base.getListPaper().stream().
                        filter(x->x.getLocalCopy().equals("")).
                        sorted(Comparator.comparing(Work::getYear).reversed().thenComparing(Work::getName)).
                        collect(Collectors.toUnmodifiableList());
            default:
                severe("Bad type "+type);
                assert(false);
                return new ArrayList<>();
        }
    }
}
