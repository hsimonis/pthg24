package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.datamodel.SubType.Application;
import static org.insightcentre.pthg24.datamodel.SubType.Regular;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ListSpecialIssues extends AbstractList{

    public ListSpecialIssues(Scenario base, List<SpecialIssue> issues, String exportDir, String fileName, String caption){
        super(base);
        assert(exportDir.endsWith("/"));
        String fullName= exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            showTable(out,base,issues,false,caption);
            out.close();
        } catch(IOException e){
            severe("Cannot write file: "+fullName+", exception "+e.getMessage());
        }
    }

    private void showTable(PrintWriter out,Scenario base,List<SpecialIssue> issues,boolean showLabel,String caption){
//        out.printf("{\\scriptsize\n");
        out.printf("\\begin{longtable}{>{\\raggedright\\arraybackslash}p{2cm}>{\\raggedright\\arraybackslash}p{3cm}" +
                ">{\\raggedright\\arraybackslash}p{12.0cm}p{2.0cm}r}\n");
        out.printf("\\rowcolor{white}\\caption{%s (Total %d)}\\\\ \\toprule\n",safe(caption),issues.size());
        out.printf("\\rowcolor{white}Name & Short Name & Topic & \\shortstack{Based\\\\on\\\\Conference}& \\shortstack{Nr\\\\Articles}\\\\ \\midrule");
        out.printf("\\endhead\n");
        out.printf("\\bottomrule\n");
        out.printf("\\endfoot\n");
        for(SpecialIssue i:issues){
            out.printf("%s & %s & %s & %b & %d",
                    safe(i.getName()),
                    safe(i.getShortName()),
                    safe(i.getTopic()),
                    i.getBasedOnConference(),
                    articlesInIssue(i));
            out.printf("\\\\\n");
        }
        out.printf("\\end{longtable}\n\n");
 //       out.printf("}\n\n");

    }

    private int articlesInIssue(SpecialIssue issue){
        return (int) base.getListArticle().stream().
                filter(x->x.getSpecialIssue()!= null).
                filter(x->x.getSpecialIssue()==issue).count();
    }

}
