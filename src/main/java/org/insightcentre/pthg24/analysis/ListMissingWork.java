package org.insightcentre.pthg24.analysis;

import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import org.insightcentre.pthg24.datamodel.*;

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

public class ListMissingWork extends AbstractList{
    double relevanceLimit;

    public ListMissingWork(Scenario base, String exportDir, String fileName,String fileName2,String fileName3,double relevanceLimit) {
        super(base);
        this.relevanceLimit = relevanceLimit;
        assert (exportDir.endsWith("/"));
        String fullFile = exportDir + fileName;
        String fullFile2 = exportDir + fileName2;
        String fullFile3= exportDir+ fileName3;
        List<MissingWork> included = base.getListMissingWork().stream().
                filter(this::included).
                filter(x->x.getRelevance()>= relevanceLimit).
                sorted(Comparator.comparing(MissingWork::getRelevance).reversed()).
                toList();
        List<MissingWork> highlyConnected = base.getListMissingWork().stream().
                filter(this::included).
                filter(x->x.getRelevance()< relevanceLimit).
                sorted(Comparator.comparing(MissingWork::getNrLinks).reversed()).
                limit(50).
                toList();
        List<MissingWork> excluded = base.getListMissingWork().stream().
                filter(x -> !included(x)).
                filter(x->x.getRelevance()>= relevanceLimit).
                sorted(Comparator.comparing(MissingWork::getRelevance).reversed()).
                toList();
        table("Missing Work Considered Relevant",included, fullFile);
        table("Highly Connected Missing Work Not Considered Relevant",highlyConnected, fullFile3);
        table("Excluded Work",excluded, fullFile2);
    }

    private void table(String caption,List<MissingWork> list,String fullFile){
        try{
            PrintWriter out = new PrintWriter(fullFile);

            int nrRelevant = (int) list.stream().filter(x->x.getRelevance() >= relevanceLimit).count();
            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{p{5cm}lp{11cm}rrrrrr}\n");
            out.printf("\\caption{%s (Total %s Works, %d considered Relevant)}\\\\ \\toprule\n",caption,list.size(),nrRelevant);
            out.printf("DOI & Type & Authors/Title & \\shortstack{Nr\\\\Links} & \\shortstack{Citing\\\\Survey} & " +
                    "\\shortstack{Cited by\\\\Survey} & \\shortstack{XRef\\\\Refs} & \\shortstack{XRef\\\\Cite} & Relevance\\\\ \\midrule");
            out.printf("\\endhead\n");
            out.printf("\\bottomrule\n");
            out.printf("\\endfoot\n");
            for(MissingWork mw:list) {
                out.printf("\\href{http://dx.doi.org/%s}{%s} \\href{https://www.doi2bib.org/bib/%s}{(bib)} & %s & %s & %d & %d & %d & %d & %d & %5.2f",
                        mw.getDoi(),safe(mw.getDoi()),mw.getDoi(),
                        safe(mw.getType()),
                        authorsTitle(showAuthor(mw.getAuthor()),showTitle(mw.getTitle()),
                                showSource(mw.getSource()),mw.getYear(),mw.getAbstractText(),mw),
                        mw.getNrLinks(),
                        mw.getNrCited(),
                        mw.getNrCitations(),
                        mw.getCrossrefReferences(),
                        mw.getCrossrefCitations(),
                        mw.getRelevance())
                ;
                out.printf("\\\\\n");

            }
            out.printf("\\end{longtable}\n");
            out.printf("}\n\n");
            out.close();
        } catch(IOException e){
            severe("Cannot write file "+fullFile+", exception "+e.getMessage());
        }
    }

    private boolean included(MissingWork x){
        return !x.getTitle().equals("") &&
                !x.getType().equals("other") &&
                !x.getType().equals("posted-content") &&
                !x.getType().equals("report") &&
                !x.getType().equals("dataset") &&
                !x.getType().equals("reference-entry");

    }


    private String authorsTitle(String author,String title,String source,int year,String abstractText,MissingWork mw){
        return author+". "+title+". "+source+", "+year+"."+(abstractText.equals("")||mw.getRelevance()< relevanceLimit?"":" \\hyperref[mw:"+mw.getKey()+"]{Abstract}");
    }




}
