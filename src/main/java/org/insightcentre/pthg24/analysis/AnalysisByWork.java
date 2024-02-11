package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.datamodel.ConceptType.*;
import static org.insightcentre.pthg24.imports.Importer.safer;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class AnalysisByWork {
    public AnalysisByWork(Scenario base, String exportDir, String fileName){
        assert(exportDir.endsWith("/"));
        String fullName = exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{p{3cm}p{4cm}p{2cm}p{2cm}p{2cm}p{2cm}p{2cm}p{2cm}p{2cm}p{2cm}}\n");
            out.printf("\\caption{Keywords by Work and Domains}\\\\ \\toprule\n");
            out.printf("Work & Concepts & Classification & Constraints & ProgLanguages & CPSystems & Areas & " +
                    "Industries & Benchmarks & Algorithm\\\\ \\midrule");
            out.printf("\\endhead\n");
            out.printf("\\bottomrule\n");
            out.printf("\\endfoot\n");
            for(Work w:sortedWorks(base)){
                out.printf("\\href{%s}{%s}~\\cite{%s}",w.getLocalCopy(),safe(w.getName()),w.getName());
                out.printf(" & %s",concepts(base,w,Concepts));
                out.printf(" & %s",concepts(base,w,Classification));
                out.printf(" & %s",concepts(base,w, Constraints));
                out.printf(" & %s",concepts(base,w,ProgLanguages));
                out.printf(" & %s",concepts(base,w,CPSystems));
                out.printf(" & %s",concepts(base,w,ApplicationAreas));
                out.printf(" & %s",concepts(base,w,Industries));
                out.printf(" & %s",concepts(base,w,Benchmarks));
                out.printf(" & %s",concepts(base,w,Algorithms));
                out.printf("\\\\\n");
            }
            out.printf("\\end{longtable}\n");
            out.printf("}\n\n");
            out.close();
        } catch(IOException e){
            severe("Cannot write file "+fullName);
            assert(false);
        }
    }

    private String dirName(Work w){
        if (w instanceof Paper){
            return "papers";
        } else {
            return "articles";
        }
    }

    private List<Work> sortedWorks(Scenario base){
        return base.getListWork().stream().sorted(Comparator.comparing(Work::getName)).collect(Collectors.toUnmodifiableList());
    }

    private String concepts(Scenario base,Work w,ConceptType type){
        List<String> concepts = base.getListConceptWork().stream().
                filter(x->x.getWork()==w).
                filter(x->x.getConcept().getConceptType()==type).
                map(x->safer(safe(x.getConcept().getName()))).
                collect(Collectors.toUnmodifiableList());
        return String.join(", ",concepts);
    }


}
