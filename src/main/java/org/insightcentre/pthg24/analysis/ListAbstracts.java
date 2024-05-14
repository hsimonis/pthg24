package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.Concept;
import org.insightcentre.pthg24.datamodel.ConceptType;
import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.datamodel.Work;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.analysis.ListAbstractsMissingWork.conceptString;
import static org.insightcentre.pthg24.analysis.ListAbstractsMissingWork.listConcepts;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ListAbstracts extends AbstractList{

    public ListAbstracts(Scenario base, String exportDir, String fileName){
        super(base);
        assert(exportDir.endsWith("/"));
        String fullName = exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            List<Work> works = base.getListWork().stream().
//                    filter(x->!x.getAbstractText().equals("")).
//                    sorted(Comparator.comparing(Work::getKey)).
                    sorted(Comparator.comparing(Work::getRelevanceBody).thenComparing(Work::getRelevanceAbstract).reversed()).
                    toList();
            for(Work w:works){
                List<Work> listW = new ArrayList<>();
                listW.add(w);
                out.printf("\\clearpage\n");
                out.printf("\\subsection{%s}\n",w.getKey());
                out.printf("\\label{abs:%s}\n\n",w.getKey());
                out.printf("\\index{%s}\n\n",w.getKey());
                new ListWorks(out,base,listW,false,"Work "+w.getKey());

                if(w.getLocalCopy()!= null && !w.getLocalCopy().equals("")){
                    new ListConceptsByWork(out,base,listW,"Extracted Features from PDF of "+w.getKey());
                }

//                out.printf("Authors: %s\n\n",showAuthor(w.getAuthor()));
//                out.printf("Title: %s\n\n",showTitle(w.getTitle()));
                out.printf("Relevance: Title only %5.2f, Title and Abstract %5.2f, Body %5.2f\n\n",
                        w.getRelevanceTitle(),w.getRelevanceAbstract(),w.getRelevanceBody());

                listConcepts(base,out,w.getConcept());

                out.printf("%s\n\n",showAbstract(w.getAbstractText()));
            }
            out.close();
        } catch(IOException e){
            severe("Cannot write file "+fullName+", exception "+e.getMessage());
        }
    }



}
