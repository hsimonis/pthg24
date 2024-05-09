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

    public ListMissingWork(Scenario base, String exportDir, String fileName){
        super(base);
        assert(exportDir.endsWith("/"));
        String fullFile = exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullFile);
            List<MissingWork> all = base.getListMissingWork().stream().
                    filter(x->!x.getTitle().equals("")).
                    filter(x->!x.getType().equals("other")).
                    filter(x->!x.getType().equals("posted-content")).
                    filter(x->!x.getType().equals("report")).
                    filter(x->!x.getType().equals("dataset")).
                    filter(x->!x.getType().equals("reference-entry")).
                    sorted(Comparator.comparing(MissingWork::getRelevance).reversed()).
                    toList();
            int nrRelevant = (int) all.stream().filter(x->x.getRelevance() >= 1000).count();
            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{p{5cm}lp{11cm}rrrrrr}\n");
            out.printf("\\caption{Missing Work (Total %s Works, %d considered Relevant)}\\\\ \\toprule\n",all.size(),nrRelevant);
            out.printf("DOI & Type & Authors/Title & \\shortstack{Nr\\\\Links} & \\shortstack{Citing\\\\Survey} & " +
                    "\\shortstack{Cited by\\\\Survey} & \\shortstack{XRef\\\\Refs} & \\shortstack{XRef\\\\Cite} & Relevance\\\\ \\midrule");
            out.printf("\\endhead\n");
            out.printf("\\bottomrule\n");
            out.printf("\\endfoot\n");
            for(MissingWork mw:all) {
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
        return author+". "+title+". "+source+", "+year+"."+(abstractText.equals("")||mw.getRelevance()< 1000.0?"":" \\hyperref[mw:"+mw.getKey()+"]{Abstract}");
    }




}
