package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static framework.reports.AbstractCommon.safe;
import static java.util.stream.Collectors.joining;
import static org.insightcentre.pthg24.analysis.PotentialLinkSearch.demathify;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ListLinkCandidates extends AbstractList{

    public ListLinkCandidates(Scenario base, List<LinkCandidate> list, String exportDir, String fileName, String caption){
        super(base);
        assert(exportDir.endsWith("/"));
        String fullName= exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            showTable(out,base,list,false,caption);
            out.close();
        } catch(IOException e){
            severe("Cannot write file: "+fullName+", exception "+e.getMessage());
        }
    }

    private void showTable(PrintWriter out,Scenario base,List<LinkCandidate> list,boolean showLabel,String caption){
        out.printf("{%s\n",textSize(base.getUseLargerText()));
        out.printf("\\begin{longtable}{>{\\raggedright\\arraybackslash}p{3cm}rrr>{\\raggedright\\arraybackslash}p{20cm}}\n");
        out.printf("\\rowcolor{white}\\caption{%s (Total %d)}\\\\ \\toprule\n",safe(caption),list.size());
        out.printf("\\rowcolor{white}Name & \\shortstack{Author\\\\Match} & \\shortstack{Title\\\\Match} & Year & Authors/Title/Journal\\\\ \\midrule\n");
        out.printf("\\endhead\n");
        out.printf("\\bottomrule\n");
        out.printf("\\endfoot\n");
        for(LinkCandidate lc:list){
            out.printf("\\shortstack[l]{%s\\\\%s\\\\%s} & %5.2f & %5.2f & \\shortstack[r]{%d\\\\%d} & \\shortstack[l]{%s\\\\%s\\\\%s\\\\\\href{http://dx.doi.org/%s}{%s}\\\\%s}",
                    safe(lc.getWork().getName()),linkJournal(lc.getWork()),linkExtended(lc.getWork()),
                    lc.getAuthorMatch(),lc.getTitleMatch(),
                    lc.getWork().getYear(),lc.getYear(),
                    safe(lc.getWork().getAuthors().stream().map(Author::getShortName).collect(joining(", "))),safe(lc.getMissingWork().getAuthor()),
                    safe(lc.getWork().getTitle()),lc.getMissingWork().getDoi(),
                    safe(demathify(lc.getMissingWork().getTitle())),
                    safe(lc.getJournal()));
            out.printf("\\\\\\midrule\n");
        }
        out.printf("\\end{longtable}\n\n");
        out.printf("}\n\n");

    }

    private String linkJournal(Work w){
        if (w.getLink()==null){
            return "-";
        } else {
            return w.getLink().getJournal();
        }
    }
    private String linkExtended(Work w){
        if (w.getLink()==null){
            return "-";
        } else {
            if (!w.getLink().getExtended().isEmpty()) {
                return w.getLink().getExtended();
            } else {
                return "-";
            }
        }
    }


}
