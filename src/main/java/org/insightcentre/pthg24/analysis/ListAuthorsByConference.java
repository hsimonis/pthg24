package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.analysis.ListByConcept.citation;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ListAuthorsByConference {
    public ListAuthorsByConference(Scenario base, String exportDir, String fileName){
        assert(exportDir.endsWith("/"));
        String fullName= exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            List<Author> authors = sortedAuthors(base);
            List<ConferenceSeries> conferences = sortedSeries(base);
            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{p{4cm}rrrrrr*{%d}{r}}\n",conferences.size());
            out.printf("\\rowcolor{white}\\caption{Conferences Used By Authors (Total %s Names)}\\\\ \\toprule\n",authors.size());
            out.printf("\\rowcolor{white}Author & \\shortstack{Nr\\\\Works} & " +
                    "\\shortstack{Journal\\\\Article} & \\shortstack{Conf.\\\\Paper} & \\shortstack{Book\\\\Chapter} " +
                    "& \\shortstack{Nr\\\\Book} & \\shortstack{PhD\\\\Thesis} %s\\\\ \\midrule",confLabels(conferences));
            out.printf("\\endhead\n");
            out.printf("\\bottomrule\n");
            out.printf("\\endfoot\n");
            for(Author a:authors){
                List<Work> works = base.getListAuthorship().stream().
                        filter(x->x.getAuthor()==a).
                        map(Authorship::getWork).
                        toList();
                out.printf("%s\\rowlabel{authbyconf:%s}%s & ",
                        index(a),
                        a.getKey(),safe(a.getName()));
                out.printf("%d &",a.getNrWorks());
                out.printf("%d &",articles(works));
                out.printf("%d &",papers(works));
                out.printf("%d &",chapters(works));
                out.printf("%d &",books(works));
                out.printf("%d",thesis(works));
                for(ConferenceSeries cs:conferences){
                    out.printf("& %d",inConference(works,cs));

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

    private String confLabels(List<ConferenceSeries> list){
        StringBuilder sb = new StringBuilder();
        for(ConferenceSeries cs:list){
            sb.append(" & ");sb.append(safe(cs.getName()));
        }
        return sb.toString();
    }

    private List<ConferenceSeries> sortedSeries(Scenario base){
        return base.getListConferenceSeries().stream().
//                filter(x->x.getNrPapers() > 5).
                sorted(Comparator.comparing(ConferenceSeries::getNrPapers).reversed()).
                limit(10).
                toList();
    }

    private int articles(List<Work>list){
        return  (int)list.stream().filter(x->x instanceof Article).count();
    }
    private int papers(List<Work>list){
        return  (int)list.stream().filter(x->x instanceof Paper).count();
    }
    private int inConference(List<Work>list,ConferenceSeries cs){
        return  (int)list.stream().filter(x->x instanceof Paper).filter(x->isInConference(x,cs)).count();
    }

    private boolean isInConference(Work w,ConferenceSeries cs){
        Paper p =(Paper)w;
        return p.getProceedings()!= null && p.getProceedings().getConferenceSeries()==cs;

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
