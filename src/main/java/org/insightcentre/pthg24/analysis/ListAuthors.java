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

public class ListAuthors {
    public ListAuthors(Scenario base, String exportDir, String fileName){
        assert(exportDir.endsWith("/"));
        String fullName= exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            List<Author> authors = sortedAuthors(base);
            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{p{4cm}rrp{18cm}}\n");
            out.printf("\\rowcolor{white}\\caption{Co-Authors of Articles/Papers (Total %s Names)}\\\\ \\toprule\n",authors.size());
            out.printf("\\rowcolor{white}Author & \\shortstack{Nr\\\\Works} & \\shortstack{Nr\\\\Cites} & Entries \\\\ \\midrule");
            out.printf("\\endhead\n");
            out.printf("\\bottomrule\n");
            out.printf("\\endfoot\n");
            for(Author a:authors){
                out.printf("%s\\rowlabel{auth:%s}%s & ",
                        index(a),
                        a.getKey(),safe(a.getName()));
                out.printf("%d &",a.getNrWorks());
                out.printf("%d &",a.getNrCitations());
                out.printf(sortedAuthorship(base,a).stream().
                        map(x->citation(x.getWork())).
                        collect(Collectors.joining(", ")));
//                for(Authorship as:sortedAuthorship(base,a)){
//                    out.printf("%s ",citation(as.getWork()));
//                }

                out.printf("\\\\\n");
            }
            out.printf("\\end{longtable}\n");
            out.printf("}\n\n");
            out.close();
        } catch(IOException e){
            severe("Cannot write file: "+fullName+", exception "+e.getMessage());
        }
    }

    private List<Author> sortedAuthors(Scenario base){
        return base.getListAuthor().stream().
                filter(x->x.getNrWorks() > 0).
//                filter(x->x.getNrWorks() >= 5).
                sorted(Comparator.comparing(Author::getNrWorks).reversed().
                        thenComparing(Author::getFamilyName)).
                toList();
    }

    private List<Authorship> sortedAuthorship(Scenario base,Author a){
        return base.getListAuthorship().stream().
                filter(x -> x.getAuthor() == a).
                filter(x -> !x.getWork().getBackground()).
                sorted(Comparator.comparing(this::year).reversed()).
                toList();
    }

    private int year(Authorship as){
        return as.getWork().getYear();
    }

    private String authors(Work a){
        return a.getAuthors().stream().
                map(Author::getShortName).
                collect(Collectors.joining(", "));
    }

    private String nameOf(ApplicationObject a){
        if (a==null){
            return "";
        } else {
            return safe(a.getName());
        }
    }

    public static String index(Author a){
        if (a.getCrossFamily() != null && !a.getCrossFamily().equals("")){
            return String.format("\\index{%s, %s}",a.getCrossFamily(),a.getCrossGiven());
        }
        return "";
    }
}
