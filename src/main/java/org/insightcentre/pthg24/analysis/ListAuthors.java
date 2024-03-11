package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.analysis.AnalysisByConcept.citation;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ListAuthors {
    public ListAuthors(Scenario base, String exportDir, String fileName){
        assert(exportDir.endsWith("/"));
        String fullName= exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{p{4cm}p{20cm}}\n");
            out.printf("\\rowcolor{white}\\caption{Co-Authors of Articles/Papers}\\\\ \\toprule\n");
            out.printf("\\rowcolor{white}Author & Entries \\\\ \\midrule");
            out.printf("\\endhead\n");
            out.printf("\\bottomrule\n");
            out.printf("\\endfoot\n");
            for(Author a:sortedAuthors(base)){
                out.printf("%s & ",safe(a.getName()));
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
                sorted(Comparator.comparing(Author::getNrWorks).reversed().
                        thenComparing(Author::getFamilyName)).
                collect(Collectors.toUnmodifiableList());
    }

    private List<Authorship> sortedAuthorship(Scenario base,Author a){
        return base.getListAuthorship().stream().
                filter(x->x.getAuthor()==a).
                sorted(Comparator.comparing(this::year).reversed()).
                collect(Collectors.toUnmodifiableList());
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
}
