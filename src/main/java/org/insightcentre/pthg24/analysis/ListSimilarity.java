package org.insightcentre.pthg24.analysis;

import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.datamodel.Similarity;
import org.insightcentre.pthg24.datamodel.Work;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static framework.reports.AbstractCommon.safe;
import static java.util.stream.Collectors.groupingBy;
import static org.insightcentre.pthg24.analysis.ListWorks.local;
import static org.insightcentre.pthg24.logging.LogShortcut.info;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ListSimilarity {
    double percentile80; //gray
    double percentile90; //green
    double percentile95; //blue
    double percentile98; //yellow
    double percentile99; //red
    double percentile995; //red

    double percentile20; //gray
    double percentile10; //green
    double percentile5; //blue
    double percentile2; //yellow
    double percentile1; //red
    double percentile05; //red

    public ListSimilarity(Scenario base, String exportDir, String fileName){
        assert(exportDir.endsWith("/"));
        setPercentiles(base);
        info("Percentiles "+percentile80+" "+percentile90+" "+percentile95+" "+percentile98+" "+percentile99+" "+percentile995);
        String fullFile = exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullFile);
            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{llllll}\n");
            out.printf("\\caption{Most Similar Works}\\\\ \\toprule\n");
            out.printf("Work & 1 & 2 & 3 & 4 & 5 \\\\ \\midrule");
            out.printf("\\endhead\n");
            out.printf("\\bottomrule\n");
            out.printf("\\endfoot\n");
            Map<Work, List<Similarity>> map = base.getListSimilarity().stream().
                    collect(groupingBy(Similarity::getWork1));
            for(Work w:map.keySet().stream().sorted(Comparator.comparing(Work::getName)).toList()){
                List<Similarity> mostSimilar = map.get(w).stream().
                        filter(x->!Double.isNaN(x.getSimilarity())).
                        filter(x->x.getSimilarity() > 0.0).
                        sorted(Comparator.comparing(Similarity::getSimilarity).reversed()).
                        limit(5).
                        toList();
                out.printf("%s",keyLink(w));
                for(Similarity s:mostSimilar){
                    out.printf("& %s%s (%.2f)",colorSimilarity(s.getSimilarity()),keyLink(s.getWork2()),s.getSimilarity());
                }
                out.printf("\\\\\n");
                List<Similarity> mostConcept = map.get(w).stream().
                        filter(x->!Double.isNaN(x.getSimilarityConcept())).
                        sorted(Comparator.comparing(Similarity::getSimilarityConcept)).
                        limit(5).
                        toList();
                for(Similarity s:mostConcept){
                    out.printf("& %s%s (%.2f)",colorSimilarityConcept(s.getSimilarityConcept()),keyLink(s.getWork2()),s.getSimilarityConcept());
                }
                out.printf("\\\\\n");

            }
            out.printf("\\end{longtable}\n");
            out.printf("}\n\n");
            out.close();
        } catch(IOException e){
            severe("Cannot write file "+fullFile+", exception "+e.getMessage());
        }
    }

    private String colorSimilarity(Double s){
        if (s==null || Double.isNaN(s)|| s <= percentile80){
            return "";
        }
        if(s<= percentile90){
            return "\\cellcolor{black!20}";
        }
        if(s<= percentile95){
            return "\\cellcolor{blue!20}";
        }
        if(s<= percentile98){
            return "\\cellcolor{green!20}";
        }
        if(s<= percentile99){
            return "\\cellcolor{yellow!20}";
        }
        if(s<= percentile995){
            return "\\cellcolor{red!20}";
        }

        return "\\cellcolor{red!40}";

    }
    private String colorSimilarityConcept(Double s){
        if (s==null || Double.isNaN(s)|| s > percentile20){
            return "";
        }
        if(s>= percentile10){
            return "\\cellcolor{black!20}";
        }
        if(s>= percentile5){
            return "\\cellcolor{blue!20}";
        }
        if(s>= percentile2){
            return "\\cellcolor{green!20}";
        }
        if(s>= percentile1){
            return "\\cellcolor{yellow!20}";
        }
        if(s>= percentile05){
            return "\\cellcolor{red!20}";
        }

        return "\\cellcolor{red!40}";

    }

    private String keyLink(Work w){
        if (w.getLocalCopy()==null ||w.getLocalCopy().equals("")){
            return safe(w.getKey());
        } else {
            return "\\href{"+local(w.getLocalCopy())+"}{"+safe(w.getKey())+"}";
        }
    }

    private void setPercentiles(Scenario base){
        double[] similarity = base.getListSimilarity().stream().
                filter(x->!Double.isNaN(x.getSimilarity())).
                mapToDouble(Similarity::getSimilarity).toArray();
        Percentile p1 = new Percentile();
        p1.setData(similarity);
        percentile80=p1.evaluate(80.0);
        percentile90=p1.evaluate(90.0);
        percentile95=p1.evaluate(95.0);
        percentile98=p1.evaluate(98.0);
        percentile99=p1.evaluate(99.0);
        percentile995=p1.evaluate(99.5);

        double[] concept = base.getListSimilarity().stream().
                filter(x->!Double.isNaN(x.getSimilarityConcept())).
                mapToDouble(Similarity::getSimilarityConcept).toArray();
        Percentile p2 = new Percentile();
        p2.setData(concept);
        percentile20=p2.evaluate(20.0);
        percentile10=p2.evaluate(10.0);
        percentile5=p2.evaluate(5.0);
        percentile2=p2.evaluate(2.0);
        percentile1=p2.evaluate(1.0);
        percentile05=p2.evaluate(0.5);

     }
}
