package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.analysis.ListConceptsByWork.concepts;
import static org.insightcentre.pthg24.analysis.ListWorks.*;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ListWorksManual {
    Scenario base;
    public ListWorksManual(Scenario base, WorkType type, String exportDir, String fileName){
        this.base = base;
        assert(exportDir.endsWith("/"));
        String fullName= exportDir+fileName;
        ConceptType benchmark = ConceptType.findByName(base,"Benchmark");
        try{
            PrintWriter out = new PrintWriter(fullName);
            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{>{\\raggedright\\arraybackslash}p{3cm}" +
                    ">{\\raggedright\\arraybackslash}p{6cm}p{2cm}rrrrlrr}\n");
            out.printf("\\rowcolor{white}\\caption{Manually Defined %s Properties}\\\\ \\toprule\n",type);
            out.printf("\\rowcolor{white}Key & Title (Local Copy)  & Bench & Links & \\shortstack{Data\\\\Avail} & " +
                    "\\shortstack{Sol\\\\Avail} & \\shortstack{Code\\\\Avail} & \\shortstack{Related\\\\To} & " +
                    "a & b\\\\ \\midrule");
            out.printf("\\endhead\n");
            out.printf("\\bottomrule\n");
            out.printf("\\endfoot\n");
            for(Work a:manualInterest(sortedWorks(base,type))){
                out.printf("\\index{%s}\\rowlabel{%s}%s \\href{%s}{%s}~\\cite{%s} & \\href{%s}{%s} & %s & %d & %s & %s & %s & %s & %s & %s",
                        a.getKey(),"c:"+a.getName(),
                        a.getName(),
                        a.getUrl(),safe(a.getName()),
                        a.getName(),
                        local(a.getLocalCopy()), safe(a.getTitle()),
//                        a.getCpSystem(),
                        concepts(base,a,benchmark),
                        a.getNrLinks(),
                        a.getDataAvail(),
                        a.getSolutionAvail(),
                        a.getCodeAvail(),
                        a.getRelatedTo(),
//                        a.getClassification(),
//                        a.getConstraints(),
                        aLabelRef(a),
                        bLabelRef(a));
                out.printf("\\\\\n");
            }
            out.printf("\\end{longtable}\n");
            out.printf("}\n\n");
            out.close();
        } catch(IOException e){
            severe("Cannot write file: "+fullName+", exception "+e.getMessage());
        }
    }

    private List<Work> manualInterest(List<Work> list){
        List<Work> res = new ArrayList<>();
        for(Work w:list){
            if (manualInterest(base,w)){
                res.add(w);
            }
        }
        return res;
    }

    public static boolean manualInterest(Scenario base,Work w){
        if (w.getCodeAvail()!= null && !w.getCodeAvail().equals("")) {
            return true;
        }
        if (w.getDataAvail()!= null && !w.getDataAvail().equals("")) {
            return true;
        }
        if (w.getSolutionAvail()!= null && !w.getSolutionAvail().equals("")) {
            return true;
        }
//        if (w.getNrLinks() > 0){
//            return true;
//        }
        if (w.getRelatedTo() != null && !w.getRelatedTo().equals("")){
            return true;
        }
        List<String> keys = base.getListConceptWork().stream().
                filter(x->x.getWork()==w).
                filter(x->x.getMatchLevel() != MatchLevel.None).
                map(x->x.getConcept().getName()).
                toList();
        return keys.contains("github") ||
                keys.contains("gitlab") ||
                keys.contains("zenodo") ||
                keys.contains("bitbucket") ||
                keys.contains("supplementary material");
    }
}
