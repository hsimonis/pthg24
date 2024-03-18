package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.analysis.ListWorks.aLabelRef;
import static org.insightcentre.pthg24.analysis.ListWorks.cLabelRef;
import static org.insightcentre.pthg24.datamodel.ConceptType.*;
import static org.insightcentre.pthg24.datamodel.MatchLevel.None;
import static org.insightcentre.pthg24.datamodel.WorkType.*;
import static org.insightcentre.pthg24.imports.Importer.safer;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class AnalysisByWork {
    public AnalysisByWork(Scenario base, WorkType type,String exportDir, String fileName){
        assert(exportDir.endsWith("/"));
        String fullName = exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{>{\\raggedright\\arraybackslash}p{3cm}r" +
                    ">{\\raggedright\\arraybackslash}p{4cm}p{1.5cm}p{2cm}p{1.5cm}p{1.5cm}p{1.5cm}p{1.5cm}p{2cm}p{1.5cm}rr}\n");
            out.printf("\\rowcolor{white}\\caption{Automatically Extracted %s Properties (Requires Local Copy)}\\\\ \\toprule\n",type);
            out.printf("\\rowcolor{white}Work & Pages & Concepts & Classification & Constraints & \\shortstack{Prog\\\\Languages} & " +
                    "\\shortstack{CP\\\\Systems} & Areas & " +
                    "Industries & Benchmarks & Algorithm & a & c\\\\ \\midrule");
            out.printf("\\endhead\n");
            out.printf("\\bottomrule\n");
            out.printf("\\endfoot\n");
            for(Work w:sortedWorks(base,type)){
                out.printf("\\rowlabel{%s}\\href{%s}{%s}~\\cite{%s}",
                        "b:"+w.getName(),
                        w.getLocalCopy(),safe(w.getName()),
                        w.getName());
                out.printf(" & %d",w.getNrPages());
                out.printf(" & %s",concepts(base,w,Concepts));
                out.printf(" & %s",concepts(base,w,Classification));
                out.printf(" & %s",concepts(base,w, Constraints));
                out.printf(" & %s",concepts(base,w,ProgLanguages));
                out.printf(" & %s",concepts(base,w,CPSystems));
                out.printf(" & %s",concepts(base,w,ApplicationAreas));
                out.printf(" & %s",concepts(base,w,Industries));
                out.printf(" & %s",concepts(base,w,Benchmarks));
                out.printf(" & %s",concepts(base,w,Algorithms));
                out.printf(" & %s & %s",aLabelRef(w),cLabelRef(w));
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


    private List<Work> sortedWorks(Scenario base,WorkType type){
        return base.getListWork().stream().
                filter(x->workType(x,type)).
                filter(x->!x.getLocalCopy().equals("")).
                sorted(Comparator.comparing(Work::getName)).
                collect(Collectors.toUnmodifiableList());
    }

    private boolean workType(Work w,WorkType type){
        return (w instanceof Article && type == ARTICLE) || (w instanceof Paper && type == PAPER)|| (w instanceof PhDThesis && type == THESIS);
    }

    public static String concepts(Scenario base,Work w,ConceptType type){
        List<String> concepts = base.getListConceptWork().stream().
                filter(x->x.getWork()==w).
                filter(x->x.getMatchLevel() != None).
                filter(x->x.getConcept().getConceptType()==type).
                map(x->safer(safe(x.getConcept().getName()))).
                collect(Collectors.toUnmodifiableList());
        return String.join(", ",concepts);
    }


}
