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
import static org.insightcentre.pthg24.analysis.ListWorks.openAccessHighlight;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ListMissingLocalCopy extends AbstractList{
    public ListMissingLocalCopy(Scenario base, WorkType type, String exportDir, String fileName){
        super(base);
        assert(exportDir.endsWith("/"));
        String fullName= exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{p{3cm}p{5cm}p{10cm}p{1cm}rp{2.5cm}l}\n");
            out.printf("\\rowcolor{white}\\caption{%s without Local Copy}\\\\ \\toprule\n",type);
            out.printf("\\rowcolor{white}Key/URL & Authors & Title & Relevance &Year & \\shortstack{Conference\\\\/Journal} & Cite\\\\ \\midrule\n");
            out.printf("\\endhead\n");
            out.printf("\\bottomrule\n");
            out.printf("\\endfoot\n");
            List<Work> missing  = missing(base,type);
            for(Work w:missing){
                out.printf("%s \\href{%s}{%s} & %s & %s%s & %s & %d & %s & \\cite{%s}\\\\\n",
                        safe(w.getName()),
                        w.getUrl(), safe(w.getName()),
                        authors(w),
                        openAccessHighlight(w),safe(w.getTitle()),
                        showRelevances(w),
                        w.getYear(),
                        confOrJournal(w),
                        w.getName());
            }
            out.printf("\\end{longtable}\n");
            out.printf("}\n\n");
            out.close();
        } catch(IOException e){
            severe("Cannot write file "+fullName+", exception "+e.getMessage());
        }
    }

    private List<Work> missing(Scenario base,WorkType type){
        switch(type){
            case ARTICLE:
                return base.getListArticle().stream().
                        filter(x->x.getLocalCopy().equals("")).
                        sorted(Comparator.comparing(Work::getYear).reversed().thenComparing(Work::getName)).
                        collect(Collectors.toUnmodifiableList());
            case PAPER:
                return base.getListPaper().stream().
                        filter(x->x.getLocalCopy().equals("")).
                        sorted(Comparator.comparing(Work::getYear).reversed().thenComparing(Work::getName)).
                        collect(Collectors.toUnmodifiableList());
            case INBOOK:
                return base.getListInBook().stream().
                        filter(x->x.getLocalCopy().equals("")).
                        sorted(Comparator.comparing(Work::getYear).reversed().thenComparing(Work::getName)).
                        collect(Collectors.toUnmodifiableList());
            case INCOLLECTION:
                return base.getListInCollection().stream().
                        filter(x->x.getLocalCopy().equals("")).
                        sorted(Comparator.comparing(Work::getYear).reversed().thenComparing(Work::getName)).
                        collect(Collectors.toUnmodifiableList());
            case THESIS:
                return base.getListPhDThesis().stream().
                        filter(x->x.getLocalCopy().equals("")).
                        sorted(Comparator.comparing(Work::getYear).reversed().thenComparing(Work::getName)).
                        collect(Collectors.toUnmodifiableList());
            case BOOK:
                return base.getListBook().stream().
                        filter(x->x.getLocalCopy().equals("")).
                        sorted(Comparator.comparing(Work::getYear).reversed().thenComparing(Work::getName)).
                        collect(Collectors.toUnmodifiableList());
            default:
                severe("Bad type "+type);
                assert(false);
                return new ArrayList<>();
        }
    }

    private String confOrJournal(Work w){
        if (w instanceof Paper){
            return shortProc(((Paper)w).getProceedings());
        } else if (w instanceof Article){
            Journal j = ((Article)w).getJournal();
            return (j.getIsBlocked()?"\\cellcolor{red!20}":"")+nameOf(j);
        } else if (w instanceof InCollection){
            return nameOf(((InCollection)w).getCollection());
        } else if (w instanceof InBook){
            return safe(((InBook)w).getBooktitle());
        } else if (w instanceof Book){
            return "Book";
        } else if (w instanceof PhDThesis){
            return nameOf(((PhDThesis)w).getSchool());
        } else {
            return "n/a";
        }
    }

    private String shortProc(Proceedings p){
        if (p==null){
            return "-";
        } else {
            return safe(p.getShortName());
        }
    }

    private String nameOf(ApplicationObject a){
        if (a==null){
            return "";
        } else {
            return safe(a.getName());
        }
    }

}
