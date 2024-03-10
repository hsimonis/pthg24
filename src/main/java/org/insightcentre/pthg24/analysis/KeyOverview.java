package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.Article;
import org.insightcentre.pthg24.datamodel.Paper;
import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.datamodel.Work;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class KeyOverview {
    public KeyOverview(Scenario base, String exportDir, String fileName){
        assert(exportDir.endsWith("/"));
        String fullName= exportDir+fileName;
        try{
            int nrColumns = 7;
            PrintWriter out = new PrintWriter(fullName);
            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{*{%d}{l}}\n",nrColumns);
            out.printf("\\caption{Key Overview}\\\\ \\toprule\n");
            out.printf("1 & 2 & 3 & 4 & 5 & 6 & 7\\\\ \\midrule\n");
            out.printf("\\endhead\n");
            out.printf("\\bottomrule\n");
            out.printf("\\endfoot\n");
            List<Work> sorted  = sortedWorks(base);
            int i = 0;
            for(Work w:sorted){
                out.printf("\\href{%s}{%s}~\\cite{%s}",
                        w.getLocalCopy(),safe(w.getName()),
                        w.getName());
                if (++i % nrColumns == 0){
                    out.printf("\\\\ \n");
                } else {
                    out.printf(" & ");
                }
            }
            out.printf("\\end{longtable}\n");
            out.printf("}\n\n");
            out.close();
        } catch(IOException e){
            severe("Cannot write file "+fullName+", exception "+e.getMessage());
        }
    }

    private List<Work> sortedWorks(Scenario base){
        return base.getListWork().stream().
                sorted(Comparator.comparing(Work::getName)).
                collect(Collectors.toUnmodifiableList());
    }


}
