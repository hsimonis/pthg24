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
    public AnalysisByWork(Scenario base, List<Work> works,String exportDir, String fileName,String caption){
        analyze(base,null,works,exportDir,fileName,false,caption);
    }
    public AnalysisByWork(Scenario base, WorkType type,String exportDir, String fileName) {
        List<Work> works = sortedWorks(base, type);
        analyze(base, type,works, exportDir, fileName,true,"Automatically Extracted "+type+" Features (Requires Local Copy)");
    }

    private void analyze(Scenario base,WorkType type,List<Work> works,String exportDir, String fileName,boolean rowLabels,String caption){
        assert(exportDir.endsWith("/"));
        String fullName = exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{>{\\raggedright\\arraybackslash}p{3cm}r%srr}\n",conceptTypeWidths(base));
            out.printf("\\rowcolor{white}\\caption{%s}\\\\ \\toprule\n",caption);
            out.printf("\\rowcolor{white}Work & Pages %s & a & c\\\\ \\midrule",conceptTypeLabels(base));
            out.printf("\\endhead\n");
            out.printf("\\bottomrule\n");
            out.printf("\\endfoot\n");
            for(Work w:works){
                out.printf("%s\\href{%s}{%s}~\\cite{%s}",
                        rowLabel(w,"b:"+w.getName(),rowLabels),
                        local(w.getLocalCopy()),safe(w.getName()),
                        w.getName());
                out.printf(" & %d",w.getNrPages());
                for(ConceptType ct:conceptTypes(base)) {
                    out.printf(" & %s", concepts(base, w, ct));
                }
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

    private List<ConceptType> conceptTypes(Scenario base){
        return base.getListConceptType().stream().sorted(Comparator.comparing(ConceptType::getName)).toList();
    }

    private String conceptTypeLabels(Scenario base){
        StringBuilder sb = new StringBuilder();
        for(ConceptType ct:conceptTypes(base)){
            sb.append("& ");sb.append(ct.getName());
        }
        return sb.toString();
    }
    private String conceptTypeWidths(Scenario base){
        StringBuilder sb = new StringBuilder();
        for(ConceptType ct:conceptTypes(base)){
            sb.append(">{\\raggedright\\arraybackslash}p{1.5cm}");
        }
        return sb.toString();
    }

    private String rowLabel(Work w,String label,boolean rowLabels){
        if (rowLabels){
            return String.format("\\index{%s}\\rowlabel{%s}",w.getKey(),label);
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
