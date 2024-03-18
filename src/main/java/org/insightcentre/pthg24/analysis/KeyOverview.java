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
            int nrColumns = 6;
            PrintWriter out = new PrintWriter(fullName);
            List<Work> sorted  = sortedWorks(base);
//            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{*{%d}{l}}\n",nrColumns);
            out.printf("\\rowcolor{white}\\caption{Key Overview (Total: %d)}\\\\ \\toprule\n",sorted.size());
            out.printf("\\rowcolor{white}1 & 2 & 3 & 4 & 5 & 6\\\\ \\midrule\n");
            out.printf("\\endhead\n");
            out.printf("\\bottomrule\n");
            out.printf("\\endfoot\n");
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
//            out.printf("}\n\n");
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
