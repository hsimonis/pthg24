package org.insightcentre.pthg24.analysis;

import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import org.insightcentre.pthg24.datamodel.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static framework.reports.AbstractCommon.safe;
import static java.util.stream.Collectors.groupingBy;
import static org.insightcentre.pthg24.analysis.ListWorks.local;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ListPapersByConferenceSeries {


    public ListPapersByConferenceSeries(Scenario base, String exportDir, String fileName) {
        assert (exportDir.endsWith("/"));
        String fullFile = exportDir + fileName;
        try {
            PrintWriter out = new PrintWriter(fullFile);
            for (ConferenceSeries s : base.getListConferenceSeries().stream().
                    //??? this attribute is set by PublicationReport, this must run after report generation
                    filter(x->x.getNrPapers() > 0).
                    sorted(Comparator.comparing(ApplicationObject::getName)).toList()) {
                out.printf("\\subsection{%s}\n\n", s.getName());
//                out.printf("\\label{series:%s}\n",safe(s.getName()));
                out.printf("\\index{%s}\n",s.getName());
                List<Work> works = base.getListPaper().stream().
                        filter(x -> x.getProceedings().getConferenceSeries() == s).
                        filter(x -> !x.getBackground()).
                        sorted(Comparator.comparing(Work::getYear).reversed().thenComparing(Work::getKey)).
                        collect(Collectors.toList());
                new ListWorks(out, base, works, false, "Papers in Conference Series " + s.getName() + " (Total " + works.size() + ")");
            }
            out.close();
        } catch (IOException e) {
            severe("Cannot write file " + fullFile + ", exception " + e.getMessage());
        }
    }

}
