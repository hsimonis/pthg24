package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.analysis.ListWorks.*;
import static org.insightcentre.pthg24.datamodel.ConceptType.*;
import static org.insightcentre.pthg24.datamodel.MatchLevel.None;
import static org.insightcentre.pthg24.datamodel.WorkType.*;
import static org.insightcentre.pthg24.imports.Importer.safer;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class AnalysisByWork {
    public AnalysisByWork(Scenario base, List<Work> works,String exportDir, String fileName){
        analyze(base,null,works,exportDir,fileName,false);
    }
    public AnalysisByWork(Scenario base, WorkType type,String exportDir, String fileName) {
        List<Work> works = sortedWorks(base, type);
        analyze(base, type,works, exportDir, fileName,true);
    }

    private void analyze(Scenario base,WorkType type,List<Work> works,String exportDir, String fileName,boolean rowLabels){
        assert(exportDir.endsWith("/"));
        String fullName = exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{>{\\raggedright\\arraybackslash}p{3cm}r" +
                    ">{\\raggedright\\arraybackslash}p{4cm}p{1.5cm}p{2cm}p{1.5cm}p{1.5cm}p{1.5cm}p{1.5cm}p{2cm}p{1.5cm}rr}\n");
            out.printf("\\rowcolor{white}\\caption{Automatically Extracted %s Properties (Requires Local Copy)}\\\\ \\toprule\n",(type==null?"":type));
            out.printf("\\rowcolor{white}Work & Pages & Concepts & Classification & Constraints & \\shortstack{Prog\\\\Languages} & " +
                    "\\shortstack{CP\\\\Systems} & Areas & " +
                    "Industries & Benchmarks & Algorithm & a & c\\\\ \\midrule");
            out.printf("\\endhead\n");
            out.printf("\\bottomrule\n");
            out.printf("\\endfoot\n");
            for(Work w:works){
                out.printf("%s\\href{%s}{%s}~\\cite{%s}",
                        rowLabel("b:"+w.getName(),rowLabels),
                        local(w.getLocalCopy()),safe(w.getName()),
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
                out.printf(" & %s & %s",aLabelRef(w),cLabelRef(base,w));
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

    private String rowLabel(String label,boolean rowLabels){
        if (rowLabels){
            return String.format("\\rowlabel{%s}",label);
        }
        return "";
    }


    private List<Work> sortedWorks(Scenario base,WorkType type){
        return base.getListWork().stream().
                filter(x -> workType(x, type)).
                filter(x -> !x.getLocalCopy().equals("")).
                filter(x -> !x.getBackground()).
                sorted(Comparator.comparing(Work::getName)).
                toList();
    }

    private boolean workType(Work w,WorkType type){
        return (w instanceof Article && type == ARTICLE) ||
                (w instanceof Paper && type == PAPER)||
                (w instanceof PhDThesis && type == THESIS)||
                (w instanceof InCollection && type == INCOLLECTION);
    }

    public static String concepts(Scenario base,Work w,ConceptType type){
        List<String> concepts = base.getListConceptWork().stream().
                filter(x -> x.getWork() == w).
                filter(x -> x.getMatchLevel() != None).
                filter(x -> x.getConcept().getConceptType() == type).
                map(x -> safer(safe(x.getConcept().getName()))).
                toList();
        return String.join(", ",concepts);
    }


}
