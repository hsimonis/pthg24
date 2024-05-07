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

public class ListMissingWork {
    Scenario base;

    public ListMissingWork(Scenario base, String exportDir, String fileName,String[] wordList){
        this.base = base;
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
                        authorsTitle(alphaSafe(mw.getAuthor()),highlightWords(alphaSafe(safe(mw.getTitle())),wordList),removeEntity(mw.getSource()),mw.getYear(),mw.getAbstractText()),
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

    private String removeEntity(String s){
        return s.replace("&amp;","\\&");
    }

    private String authorsTitle(String author,String title,String source,int year,String abstractText){
        return author+". "+title+". "+source+", "+year+"."+(abstractText.equals("")?"":"(Abstract)");
    }

    private String alphaSafe(String s){
        String res = s;
        for(Translator tl:base.getListTranslator()){
            res = res.replace(tl.getUnicode(),tl.getLatex());
        }
        //??? temporary hack, get rid of unicode characters alltogether, replace with ?
        return s.replaceAll("&","").replace("%","\\%");
//        return s.replaceAll("&","").replaceAll("[^\\x00-\\x7F]","?").replace("α","$\\alpha$");
    }

    private String highlightWords(String text,String[] words){
        String res = text;
        for(String word:words){
            res = res.replaceAll(word,String.format("\\\\textcolor{red}{%s}",word));
        }
//        info("replaced "+res);
        return res;
    }


}
