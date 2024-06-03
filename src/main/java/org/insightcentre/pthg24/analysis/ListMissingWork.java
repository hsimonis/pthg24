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

public class ListMissingWork extends AbstractMissingWorkList{
    double relevanceLimit;

    public ListMissingWork(Scenario base, String exportDir, String fileName,String fileName2,String fileName3,double relevanceLimit) {
        super(base);
        this.relevanceLimit = relevanceLimit;
        assert (exportDir.endsWith("/"));
        String fullFile = exportDir + fileName;
        String fullFile2 = exportDir + fileName2;
        String fullFile3= exportDir+ fileName3;

        List<MissingWork> included = included(relevanceLimit);
        List<MissingWork> highlyConnected = highlyConnected(relevanceLimit);
        List<MissingWork> excluded = excluded(relevanceLimit);

        int total = base.getListMissingWork().size();
        table("Missing Work Considered Relevant",included, total,fullFile);
        table("Highly Connected Missing Work Not Considered Relevant",highlyConnected, total,fullFile3);
        table("Excluded Work",excluded, total,fullFile2);
    }

    private void table(String caption,List<MissingWork> list,int total,String fullFile){
        try{
            PrintWriter out = new PrintWriter(fullFile);

            int nrShown = list.size();
            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{p{5cm}lp{11cm}rrrrrr}\n");
            out.printf("\\caption{%s (Total %s Works Checked, %d Selected)}\\\\ \\toprule\n",caption,total,nrShown);
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



    private String authorsTitle(String author,String title,String source,int year,String abstractText,MissingWork mw){
        return author+". "+title+". "+source+", "+year+"."+(abstractText.equals("")||mw.getRelevance()< relevanceLimit?"":" \\hyperref[mw:"+mw.getKey()+"]{Abstract}");
    }




}
