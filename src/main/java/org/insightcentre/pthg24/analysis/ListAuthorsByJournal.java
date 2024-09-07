package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ListAuthorsByJournal {
    public ListAuthorsByJournal(Scenario base, String exportDir, String fileName){
        assert(exportDir.endsWith("/"));
        String fullName= exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            List<Author> authors = sortedAuthors(base);
            List<Journal> journals = sortedJournals(base);
            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{p{4cm}rr*{%d}{r}}\n",journals.size());
            out.printf("\\rowcolor{white}\\caption{Journals Used By Authors (Total %s Names)}\\\\ \\toprule\n",authors.size());
            out.printf("\\rowcolor{white}Author & \\shortstack{Nr\\\\Works} & " +
                    "\\shortstack{Journal\\\\Article} %s\\\\ \\midrule",journalLabels(journals));
            out.printf("\\endhead\n");
            out.printf("\\bottomrule\n");
            out.printf("\\endfoot\n");
            for(Author a:authors){
                List<Work> works = base.getListAuthorship().stream().
                        filter(x->x.getAuthor()==a).
                        map(Authorship::getWork).
                        toList();
                out.printf("%s\\rowlabel{authbyjournal:%s}%s & ",
                        index(a),
                        a.getKey(),safe(a.getName()));
                out.printf("%d &",a.getNrWorks());
                out.printf("%d ",articles(works));
                for(Journal j:journals){
                    out.printf("& %d",inJournal(works,j));

                }
                out.printf("\\\\\n");
            }
            out.printf("\\end{longtable}\n");
            out.printf("}\n\n");
            out.close();
        } catch(IOException e){
            severe("Cannot write file: "+fullName+", exception "+e.getMessage());
        }
    }

    private String journalLabels(List<Journal> list){
        StringBuilder sb = new StringBuilder();
        for(Journal cs:list){
            sb.append(" & \\rotatebox{90}{");sb.append(safe(cs.getShortName()));sb.append("}");
        }
        return sb.toString();
    }

    private List<Journal> sortedJournals(Scenario base){
        return base.getListJournal().stream().
//                filter(x->x.getNrPapers() > 5).
                sorted(Comparator.comparing(Journal::getNrArticles).reversed()).
                limit(20).
                toList();
    }

    private int articles(List<Work>list){
        return  (int)list.stream().filter(x->x instanceof Article).count();
    }
    private int papers(List<Work>list){
        return  (int)list.stream().filter(x->x instanceof Paper).count();
    }


    private int inJournal(List<Work>list,Journal cs){
        return  (int)list.stream().filter(x->x instanceof Article).filter(x->isInJournal(x,cs)).count();
    }

    private boolean isInJournal(Work w,Journal cs){
        Article p =(Article)w;
        return p.getJournal()==cs;

    }
    private int chapters(List<Work>list){
        return  (int)list.stream().filter(x->x instanceof InBook).count();
    }

    private int books(List<Work>list){
        return  (int)list.stream().filter(x->x instanceof Book).count();
    }

    private int thesis(List<Work>list){
        return  (int)list.stream().filter(x->x instanceof PhDThesis).count();
    }





    private List<Author> sortedAuthors(Scenario base){
        return base.getListAuthor().stream().
                filter(x->x.getNrWorks() > 0).
                filter(x->x.getNrWorks() >= 5).
                sorted(Comparator.comparing(Author::getNrWorks).reversed().
                        thenComparing(Author::getFamilyName)).
                toList();
    }



    public static String index(Author a){
        if (a.getCrossFamily() != null && !a.getCrossFamily().equals("")){
            return String.format("\\index{%s, %s}",a.getCrossFamily(),a.getCrossGiven());
        }
        return "";
    }
}
