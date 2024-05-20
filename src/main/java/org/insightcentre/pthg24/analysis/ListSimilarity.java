package org.insightcentre.pthg24.analysis;

import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.datamodel.Similarity;
import org.insightcentre.pthg24.datamodel.Work;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static framework.reports.AbstractCommon.safe;
import static java.util.stream.Collectors.groupingBy;
import static org.insightcentre.pthg24.analysis.ListWorks.local;
import static org.insightcentre.pthg24.logging.LogShortcut.info;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ListSimilarity {

    double percentile20; //gray
    double percentile10; //green
    double percentile5; //blue
    double percentile2; //yellow
    double percentile1; //red
    double percentile05; //red
    double percentile20c; //gray
    double percentile10c; //green
    double percentile5c; //blue
    double percentile2c; //yellow
    double percentile1c; //red
    double percentile05c; //red

    double percentile80c; //gray
    double percentile90c; //green
    double percentile95c; //blue
    double percentile98c; //yellow
    double percentile99c; //red
    double percentile995c; //red

    double percentile80d; //gray
    double percentile90d; //green
    double percentile95d; //blue
    double percentile98d; //yellow
    double percentile99d; //red
    double percentile995d; //red

    Map<Work, List<Similarity>> map1;
    Map<Work, List<Similarity>> map2;

    public ListSimilarity(Scenario base, String exportDir, String fileName){
        assert(exportDir.endsWith("/"));
        setPercentiles(base);
        String fullFile = exportDir+fileName;
        map1 = base.getListSimilarity().stream().
                collect(groupingBy(Similarity::getWork1));
        map2 = base.getListSimilarity().stream().
                collect(groupingBy(Similarity::getWork2));
        try{
            PrintWriter out = new PrintWriter(fullFile);
            List<Work> works = base.getListWork().stream().
                    filter(x->!x.getBackground()).
                    filter(x->map1.get(x) != null || map2.get(x) != null).
                    sorted(Comparator.comparing(Work::getName)).toList();
            similarityTable(out,works);
            out.close();
        } catch(IOException e){
            severe("Cannot write file "+fullFile+", exception "+e.getMessage());
        }
    }
    public ListSimilarity(Scenario base){
        setPercentiles(base);
        map1 = base.getListSimilarity().stream().
                collect(groupingBy(Similarity::getWork1));
        map2 = base.getListSimilarity().stream().
                collect(groupingBy(Similarity::getWork2));

    }

    public void listSimilarity(PrintWriter out,Work w){
        if (!w.getBackground() && (map1.get(w) != null || map2.get(w) != null)) {
            List<Work> works = new ArrayList<>();
            works.add(w);
            similarityTable(out, works);
        }
    }

    private void similarityTable(PrintWriter out,List<Work> works){
        out.printf("{\\scriptsize\n");
        out.printf("\\begin{longtable}{rlllll}\n");
        out.printf("\\caption{Most Similar Works}\\\\ \\toprule\n");
        out.printf("Work & 1 & 2 & 3 & 4 & 5 \\\\ \\midrule");
        out.printf("\\endhead\n");
        out.printf("\\bottomrule\n");
        out.printf("\\endfoot\n");
        for(Work w:works){
            similarityList(out,w);

        }
        out.printf("\\end{longtable}\n");
        out.printf("}\n\n");
    }

    private void similarityList(PrintWriter out,Work w){
        List<Similarity> simil = selectSimilarity(w);
        List<Similarity> mostSimilar = simil.stream().
                filter(x->!x.getWork1().getBackground() && !x.getWork2().getBackground()).
                filter(x->!Double.isNaN(x.getSimilarity())).
                filter(x->!Double.isInfinite(x.getSimilarity())).
                filter(x->x.getSimilarity() < 1.0).
                sorted(Comparator.comparing(Similarity::getSimilarity)).
                limit(5).
                toList();
        out.printf("\\index{%s}%s R\\&C",w.getKey(),keyLink(w));
        for(Similarity s:mostSimilar){
            out.printf("& %s%s (%.2f)",colorSimilarity(s.getSimilarity()),keyLink(selectOther(s,w)),s.getSimilarity());
        }
        out.printf("\\\\\n");
        out.printf("Euclid");
        List<Similarity> mostConcept = simil.stream().
                filter(x->!x.getWork1().getBackground() && !x.getWork2().getBackground()).
                filter(x->!Double.isNaN(x.getSimilarityConcept())).
                filter(x->!Double.isInfinite(x.getSimilarityConcept())).
                filter(x->x.getSimilarityConcept() < 1.0).
                sorted(Comparator.comparing(Similarity::getSimilarityConcept)).
                limit(5).
                toList();
        for(Similarity s:mostConcept){
            out.printf("& %s%s (%.2f)",colorSimilarityConcept(s.getSimilarityConcept()),keyLink(selectOther(s,w)),s.getSimilarityConcept());
        }
        out.printf("\\\\\n");
        out.printf("Dot");
        List<Similarity> dot = simil.stream().
                filter(x->!x.getWork1().getBackground() && !x.getWork2().getBackground()).
                filter(x->!Double.isNaN(x.getDotProduct())).
                filter(x->!Double.isInfinite(x.getDotProduct())).
                filter(x->x.getDotProduct() > 0.0).
                sorted(Comparator.comparing(Similarity::getDotProduct).reversed()).
                limit(5).
                toList();
        for(Similarity s:dot){
            out.printf("& %s%s (%.2f)",colorDotProduct(s.getDotProduct()),keyLink(selectOther(s,w)),s.getDotProduct());
        }
        out.printf("\\\\\n");
        out.printf("Cosine");
        List<Similarity> cosine = simil.stream().
                filter(x->!x.getWork1().getBackground() && !x.getWork2().getBackground()).
                filter(x->!Double.isNaN(x.getCosine())).
                filter(x->!Double.isInfinite(x.getCosine())).
                filter(x->x.getCosine() > 0.0).
                sorted(Comparator.comparing(Similarity::getCosine).reversed()).
                limit(5).
                toList();
        for(Similarity s:cosine){
            out.printf("& %s%s (%.2f)",colorCosine(s.getCosine()),keyLink(selectOther(s,w)),s.getCosine());
        }
        out.printf("\\\\\n");

    }


    private List<Similarity> selectSimilarity(Work w){
        List<Similarity> list1 = map1.get(w);
        List<Similarity> list2 = map2.get(w);
        if (list1 ==null) {
            return list2;
        }
        if(list2 ==null){
            return list1;
        }
        // list1 and list2 are disjoint by construction
        List<Similarity> res = new ArrayList<>(list1);
        res.addAll(list2);
        return res;
    }

    private Work selectOther(Similarity s,Work w){
        if (s.getWork1()==w){
            return s.getWork2();
        }
        assert(s.getWork2()==w);
        return s.getWork1();
    }

    private String colorSimilarity(Double s){
        if (s==null || Double.isNaN(s)|| Double.isInfinite(s)|| s > percentile20){
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

    private String colorSimilarityConcept(Double s){
        if (s==null || Double.isNaN(s)|| Double.isInfinite(s)|| s > percentile20c){
            return "";
        }
        if(s>= percentile10c){
            return "\\cellcolor{black!20}";
        }
        if(s>= percentile5c){
            return "\\cellcolor{blue!20}";
        }
        if(s>= percentile2c){
            return "\\cellcolor{green!20}";
        }
        if(s>= percentile1c){
            return "\\cellcolor{yellow!20}";
        }
        if(s>= percentile05c){
            return "\\cellcolor{red!20}";
        }

        return "\\cellcolor{red!40}";

    }
    private String colorDotProduct(Double s){
        if (s==null || Double.isNaN(s)|| Double.isInfinite(s)|| s < percentile80d){
            return "";
        }
        if(s<= percentile90d){
            return "\\cellcolor{black!20}";
        }
        if(s<= percentile95d){
            return "\\cellcolor{blue!20}";
        }
        if(s<= percentile98d){
            return "\\cellcolor{green!20}";
        }
        if(s<= percentile99d){
            return "\\cellcolor{yellow!20}";
        }
        if(s<= percentile995d){
            return "\\cellcolor{red!20}";
        }

        return "\\cellcolor{red!40}";

    }
    private String colorCosine(Double s){
        if (s==null || Double.isNaN(s)|| Double.isInfinite(s)|| s < percentile80c){
            return "";
        }
        if(s<= percentile90c){
            return "\\cellcolor{black!20}";
        }
        if(s<= percentile95c){
            return "\\cellcolor{blue!20}";
        }
        if(s<= percentile98c){
            return "\\cellcolor{green!20}";
        }
        if(s<= percentile99c){
            return "\\cellcolor{yellow!20}";
        }
        if(s<= percentile995c){
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
                filter(x->!Double.isInfinite(x.getSimilarity())).
                mapToDouble(Similarity::getSimilarity).toArray();
        Percentile p1 = new Percentile();
        p1.setData(similarity);
        percentile20=p1.evaluate(20.0);
        percentile10=p1.evaluate(10.0);
        percentile5=p1.evaluate(5.0);
        percentile2=p1.evaluate(2.0);
        percentile1=p1.evaluate(1.0);
        percentile05=p1.evaluate(0.5);

        double[] concept = base.getListSimilarity().stream().
                filter(x->!Double.isNaN(x.getSimilarityConcept())).
                filter(x->!Double.isInfinite(x.getSimilarityConcept())).
                mapToDouble(Similarity::getSimilarityConcept).toArray();
        Percentile p2 = new Percentile();
        p2.setData(concept);
        percentile20c=p2.evaluate(20.0);
        percentile10c=p2.evaluate(10.0);
        percentile5c=p2.evaluate(5.0);
        percentile2c=p2.evaluate(2.0);
        percentile1c=p2.evaluate(1.0);
        percentile05c=p2.evaluate(0.5);

        double[] dot = base.getListSimilarity().stream().
                filter(x->!Double.isNaN(x.getDotProduct())).
                filter(x->!Double.isInfinite(x.getDotProduct())).
                mapToDouble(Similarity::getDotProduct).toArray();
        Percentile p3 = new Percentile();
        p3.setData(dot);
        percentile80d=p3.evaluate(80.0);
        percentile90d=p3.evaluate(90.0);
        percentile95d=p3.evaluate(95.0);
        percentile98d=p3.evaluate(98.0);
        percentile99d=p3.evaluate(99.0);
        percentile995d=p3.evaluate(99.5);

        double[] cosine = base.getListSimilarity().stream().
                filter(x->!Double.isNaN(x.getCosine())).
                filter(x->!Double.isInfinite(x.getCosine())).
                mapToDouble(Similarity::getCosine).toArray();
        Percentile p4 = new Percentile();
        p4.setData(cosine);
        percentile80d=p4.evaluate(80.0);
        percentile90d=p4.evaluate(90.0);
        percentile95d=p4.evaluate(95.0);
        percentile98d=p4.evaluate(98.0);
        percentile99d=p4.evaluate(99.0);
        percentile995d=p4.evaluate(99.5);

    }
}
