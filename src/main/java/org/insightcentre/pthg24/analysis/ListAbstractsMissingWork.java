package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ListAbstractsMissingWork extends AbstractList{

    public ListAbstractsMissingWork(Scenario base, String exportDir, String fileName){
        super(base);
        assert(exportDir.endsWith("/"));
        String fullName = exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            List<MissingWork> works = base.getListMissingWork().stream().
                    filter(x->!x.getAbstractText().equals("")).
                    filter(x->x.getRelevance() >= 1000.0).
                    sorted(Comparator.comparing(MissingWork::getRelevance).reversed()).
                    toList();
            for(MissingWork w:works){
                String key = w.getKey();
                out.printf("\\subsection{%s}\n",key);
                out.printf("\\label{mw:%s}\n\n",key);
//                out.printf("\\index{%s}\n\n",key);

                out.printf("Authors: %s\n\n",showAuthor(w.getAuthor()));
                out.printf("Title: %s\n\n",showTitle(w.getTitle()));
                out.printf("Relevance: %5.2f\n\n",w.getRelevance());
                out.printf("%s\n\n",showAbstract(w.getAbstractText()));
                String concepts = highlighter(w.getTitle()+" "+w.getAbstractText());
                out.printf("%s\n\n",concepts);
            }
            out.close();
        } catch(IOException e){
            severe("Cannot write file "+fullName+", exception "+e.getMessage());
        }
    }


    private String highlighter(String t){
        String lower = t.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(ConceptType type:base.getListConceptType()){
            sb.append(type.getName());sb.append(":");
            for(Concept c:base.getListConcept().stream().filter(x->x.getConceptType()==type).toList()){
                Pattern pattern = Pattern.compile(c.getRegExpr());
                Matcher matcher = pattern.matcher(c.getCaseSensitive()?t:lower);
                if (matcher.find()){
                    sb.append(" ");sb.append(c.getName());
                }
            }
            sb.append("\n\n");
        }
        return sb.toString();
    }
}
