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

public class WorksByAuthor {
    public WorksByAuthor(Scenario base, String exportDir, String fileName){
        assert(exportDir.endsWith("/"));
        String fullName= exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);

            for(Author a: sortedAuthors(base).stream().filter(x -> x.getNrWorks() >= 5).
                    toList()) {
                List<Work> works = base.getListAuthorship().stream().
                        filter(x -> x.getAuthor() == a).
                        map(Authorship::getWork).
                        filter(x->!x.getBackground()).
                        sorted(Comparator.comparing(Work::getYear).reversed().thenComparing(Work::getName)).
                        toList();
                out.printf("\\clearpage\n");
                out.printf("\\subsection{%d Works by %s}\n",works.size(),a.getName());
                out.printf("\\label{sec:%s}\n",a.getKey());
                new ListWorks(out,base,works,false);
            }
            out.close();
        } catch(IOException e){
            severe("Cannot write file: "+fullName+", exception "+e.getMessage());
        }
    }

    private List<Author> sortedAuthors(Scenario base){
        return base.getListAuthor().stream().
                sorted(Comparator.comparing(Author::getNrWorks).reversed().
                        thenComparing(Author::getFamilyName)).
                toList();
    }

    private List<Authorship> sortedAuthorship(Scenario base,Author a){
        return base.getListAuthorship().stream().
                filter(x -> x.getAuthor() == a).
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
}
