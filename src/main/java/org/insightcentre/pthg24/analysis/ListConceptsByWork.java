package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.analysis.ListWorks.*;
import static org.insightcentre.pthg24.datamodel.MatchLevel.None;
import static org.insightcentre.pthg24.datamodel.WorkType.*;
import static org.insightcentre.pthg24.imports.Importer.safer;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ListConceptsByWork extends AbstractList{
    public ListConceptsByWork(PrintWriter out,Scenario base, List<Work> works, String caption){
        super(base);
        analyze(out,base,works,false,caption);
    }
    public ListConceptsByWork(Scenario base, List<Work> works, String exportDir, String fileName, String caption){
        super(base);
        analyze(base,null,works,exportDir,fileName,false,caption);
    }
    public ListConceptsByWork(Scenario base, WorkType type, String exportDir, String fileName) {
        super(base);
        List<Work> works = sortedWorks(base, type);
        analyze(base, type,works, exportDir, fileName,true,"Extracted Features for "+type+" (Total "+works.size()+")");
    }

    private void analyze(Scenario base,WorkType type,List<Work> works,String exportDir, String fileName,boolean rowLabels,String caption){
        assert(exportDir.endsWith("/"));
        String fullName = exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            analyze(out,base,works,rowLabels,caption);
            out.close();
        } catch(IOException e){
            severe("Cannot write file "+fullName);
            assert(false);
        }
    }

    private void analyze(PrintWriter out,Scenario base,List<Work> works,boolean rowLabels,String caption){
        out.printf("{\\scriptsize\n");
        out.printf("\\begin{longtable}{>{\\raggedright\\arraybackslash}p{3cm}r>{\\raggedright\\arraybackslash}p{1.5cm}%srr}\n",conceptTypeWidths(base));
        out.printf("\\rowcolor{white}\\caption{%s}\\\\ \\toprule\n",caption);
        out.printf("\\rowcolor{white}Work/Title & Pages & Relevance %s & a & c\\\\ \\midrule",conceptTypeLabels(base));
        out.printf("\\endhead\n");
        out.printf("\\bottomrule\n");
        out.printf("\\endfoot\n");
        for(Work w:works){
            out.printf("%s\\href{%s}{%s}~\\cite{%s} %s",
                    rowLabel(w,"b:"+w.getName(),rowLabels),
                    local(w.getLocalCopy()),safe(w.getName()),
                    w.getName(),showTitle(w.getTitle()));
            out.printf(" & %d",w.getNrPages());
            out.printf(" & %s",showRelevances(w));
            for(ConceptType ct:conceptTypes(base)) {
                out.printf(" & %s", concepts(base, w, ct));
            }
            out.printf(" & %s & %s",aLabelRef(w),cLabelRef(base,w));
            out.printf("\\\\\n");
        }
        out.printf("\\end{longtable}\n");
        out.printf("}\n\n");

    }

    // this control in order the concept types are listed, prefer the order given in the input data or alphabetical
    private List<ConceptType> conceptTypes(Scenario base){
        return base.getListConceptType();
//        return base.getListConceptType().stream().sorted(Comparator.comparing(ConceptType::getName)).toList();
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
        //??? how much space to allocate for each column in the report
        double width=15.0/conceptTypes(base).size();
        for(ConceptType ct:conceptTypes(base)){
            sb.append(String.format(">{\\raggedright\\arraybackslash}p{%5.2fcm}",width));
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
                filter(x->x.getLocalCopy() != null).
                filter(x -> !x.getLocalCopy().equals("")).
                filter(x -> !x.getBackground()).
                sorted(Comparator.comparing(Work::getName)).
                toList();
    }

    private boolean workType(Work w,WorkType type){
        return (w instanceof Article && type == ARTICLE) ||
                (w instanceof Paper && type == PAPER)||
                (w instanceof PhDThesis && type == THESIS)||
                (w instanceof InCollection && type == INCOLLECTION)||
                (w instanceof InBook && type == INBOOK)||
                (w instanceof Book && type == BOOK);
    }

    public static String concepts(Scenario base,Work w,ConceptType type){
        List<String> concepts = base.getListConceptWork().stream().
                filter(x -> x.getWork() == w).
                filter(x -> x.getMatchLevel() != None).
                filter(x -> x.getConcept().getConceptType() == type).
                sorted(Comparator.comparing(ConceptWork::getCount).reversed()).
                map(ListConceptsByWork::highlightedConcept).
                toList();
        return String.join(", ",concepts);
    }

    private static String highlightedConcept(ConceptWork x){
        String res=safe(x.getConcept().getName());
        return switch (x.getMatchLevel()) {
            case Strong -> "\\textcolor{blue}{" + res + "}";
            case Medium -> "\\textcolor{black}{" + res + "}";
            case Weak -> "\\textcolor{black!40}{" + res + "}";
            default -> res;
        };

    }



}
