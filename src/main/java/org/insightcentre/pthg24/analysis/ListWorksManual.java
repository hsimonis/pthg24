package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.analysis.AnalysisByWork.concepts;
import static org.insightcentre.pthg24.analysis.ListWorks.*;
import static org.insightcentre.pthg24.datamodel.ConceptType.Benchmarks;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ListWorksManual {
    public ListWorksManual(Scenario base, WorkType type, String exportDir, String fileName){
        assert(exportDir.endsWith("/"));
        String fullName= exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{>{\\raggedright\\arraybackslash}p{3cm}>{\\raggedright\\arraybackslash}p{6cm}lp{2cm}rrrrlp{2cm}p{2cm}rr}\n");
            out.printf("\\rowcolor{white}\\caption{Manually Defined %s Properties}\\\\ \\toprule\n",type);
            out.printf("\\rowcolor{white}Key & Title (Local Copy) & \\shortstack{CP\\\\System} & Bench & Links & \\shortstack{Data\\\\Avail} & " +
                    "\\shortstack{Sol\\\\Avail} & \\shortstack{Code\\\\Avail} & \\shortstack{Related\\\\To} & " +
                    "Classification & Constraints & a & b\\\\ \\midrule");
            out.printf("\\endhead\n");
            out.printf("\\bottomrule\n");
            out.printf("\\endfoot\n");
            for(Work a:sortedWorks(base,type)){
                out.printf("\\rowlabel{%s}%s \\href{%s}{%s}~\\cite{%s} & \\href{%s}{%s} & %s & %s & %d & %s & %s & %s & %s & %s & %s & %s & %s",
                        "c:"+a.getName(),
                        a.getName(),
                        a.getUrl(),safe(a.getName()),
                        a.getName(),
                        local(a.getLocalCopy()), safe(a.getTitle()),
                        a.getCpSystem(),
                        concepts(base,a,Benchmarks),
                        a.getNrLinks(),
                        a.getDataAvail(),
                        a.getSolutionAvail(),
                        a.getCodeAvail(),
                        a.getRelatedTo(),
                        a.getClassification(),
                        a.getConstraints(),
                        aLabelRef(a),
                        bLabelRef(a));
                out.printf("\\\\\n");
            }
            out.printf("\\end{longtable}\n");
            out.printf("}\n\n");
            out.close();
        } catch(IOException e){
            severe("Cannot write file: "+fullName+", exception "+e.getMessage());
        }
    }
}
