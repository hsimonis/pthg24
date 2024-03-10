package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.analysis.ListPapers.localCopyExists;
import static org.insightcentre.pthg24.analysis.ListPapers.localCopyExists1;
import static org.insightcentre.pthg24.datamodel.ConceptType.*;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ListArticles {
    public ListArticles(Scenario base, String exportDir, String fileName){
        assert(exportDir.endsWith("/"));
        String fullName= exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{p{3cm}p{6cm}p{7cm}rrrp{3cm}r}\n");
            out.printf("\\caption{Articles from bibtex (Total %d)}\\\\ \\toprule\n",sortedArticles(base).size());
            out.printf("Key& Authors & Title & LC & Cite & Year & Journal & Pages \\\\ \\midrule");
            out.printf("\\endhead\n");
            out.printf("\\bottomrule\n");
            out.printf("\\endfoot\n");
            for(Article a:sortedArticles(base)){
                out.printf("%s \\href{%s}{%s} & %s & %s & %s & \\cite{%s} & %d & %s & %d",
                        a.getKey(),a.getUrl(),a.getKey(),
                        authors(a),
                        safe(a.getTitle()),
                        (localCopyExists1(a)?"\\href{"+a.getLocalCopy()+"}{Yes}":"No"),
                        a.getName(),
                        a.getYear(),
                        nameOf(a.getJournal()),
                        a.getNrPages());
                out.printf("\\\\\n");
            }
            out.printf("\\end{longtable}\n");
            out.printf("}\n\n");
            out.close();
        } catch(IOException e){
            severe("Cannot write file: "+fullName+", exception "+e.getMessage());
        }
    }

    private List<Article> sortedArticles(Scenario base){
        return base.getListArticle().stream().
                sorted(Comparator.comparing(Work::getYear).reversed().
                        thenComparing(Work::getName)).
                collect(Collectors.toUnmodifiableList());
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
