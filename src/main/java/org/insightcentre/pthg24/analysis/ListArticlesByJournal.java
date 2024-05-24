package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.imports.Importer.safer;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ListArticlesByJournal {


    public ListArticlesByJournal(Scenario base, String exportDir, String fileName) {
        assert (exportDir.endsWith("/"));
        String fullFile = exportDir + fileName;
        try {
            PrintWriter out = new PrintWriter(fullFile);
            for (Journal s : base.getListJournal().stream().
                    filter(x->x.getNrArticles() > 0).
                    sorted(Comparator.comparing(ApplicationObject::getName)).toList()) {
                out.printf("\\subsection{%s}\n\n", s.getName());
//                out.printf("\\label{journal:%s}\n",safe(s.getName()));
                out.printf("\\index{%s}\n",s.getName());
                List<Work> works = base.getListArticle().stream().
                        filter(x -> x.getJournal() == s).
                        filter(x -> !x.getBackground()).
                        sorted(Comparator.comparing(Work::getYear).reversed().thenComparing(Work::getKey)).
                        collect(Collectors.toList());
                new ListWorks(out, base, works, false, "Articles in Journal " + s.getName());
            }
            out.close();
        } catch (IOException e) {
            severe("Cannot write file " + fullFile + ", exception " + e.getMessage());
        }
    }

}
