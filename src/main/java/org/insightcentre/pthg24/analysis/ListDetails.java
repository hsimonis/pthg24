package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.datamodel.Similarity;
import org.insightcentre.pthg24.datamodel.Work;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static org.insightcentre.pthg24.analysis.ListAbstractsMissingWork.listConcepts;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ListDetails extends AbstractList{

    public ListDetails(Scenario base, String exportDir, String fileName, double bodyLimit, double abstractLimit){
        super(base);
        assert(exportDir.endsWith("/"));
        String fullName = exportDir+fileName;
        ListSimilarity ls = new ListSimilarity(base);

        try{
            PrintWriter out = new PrintWriter(fullName);
            List<Work> relevantBody = base.getListWork().stream().
                    filter(x->!x.getBackground()).
                    filter(x->x.getRelevanceBody() >= bodyLimit).
                    sorted(Comparator.comparing(Work::getRelevanceBody).thenComparing(Work::getRelevanceAbstract).reversed()).
                    toList();
            List<Work> irrelevantBody = base.getListWork().stream().
                    filter(x->!x.getBackground()).
                    filter(x->!x.getLocalCopy().equals("")).
                    filter(x->x.getRelevanceBody() < bodyLimit).
                    sorted(Comparator.comparing(Work::getRelevanceBody).thenComparing(Work::getRelevanceAbstract).reversed()).
                    toList();
            List<Work> relevantAbstract = base.getListWork().stream().
                    filter(x->!x.getBackground()).
                    filter(x->x.getLocalCopy().equals("")).
                    filter(x->x.getRelevanceAbstract() >= abstractLimit).
                    sorted(Comparator.comparing(Work::getRelevanceBody).thenComparing(Work::getRelevanceAbstract).reversed()).
                    toList();
            List<Work> notRelevant = base.getListWork().stream().
                    filter(x->!x.getBackground()).
                    filter(x->x.getLocalCopy().equals("")).
                    filter(x->x.getRelevanceAbstract() < abstractLimit).
                    sorted(Comparator.comparing(Work::getRelevanceBody).thenComparing(Work::getRelevanceAbstract).reversed()).
                    toList();
            List<Work> background = base.getListWork().stream().
                    filter(Work::getBackground).
                    sorted(Comparator.comparing(Work::getRelevanceBody).thenComparing(Work::getRelevanceAbstract).reversed()).
                    toList();
            out.printf("\\subsection{Relevant Body (Total %d)}\n\n",relevantBody.size());
            listAbstracts(out,relevantBody,ls);
            out.printf("\\clearpage\n");
            out.printf("\\subsection{Non Relevant Body (Total %d)}\n\n",irrelevantBody.size());
            listAbstracts(out,irrelevantBody,ls);
            out.printf("\\clearpage\n");
            out.printf("\\subsection{Relevant Abstract (Total %d)}\n\n",relevantAbstract.size());
            listAbstracts(out,relevantAbstract,ls);
            out.printf("\\clearpage\n");
            out.printf("\\subsection{Non Relevant Abstract (Total %d)}\n\n",notRelevant.size());
            listAbstracts(out,notRelevant,ls);
            out.printf("\\clearpage\n");
            out.printf("\\subsection{Background (Total %d)}\n\n",background.size());
            listAbstracts(out,background,ls);

            out.close();
        } catch(IOException e){
            severe("Cannot write file "+fullName+", exception "+e.getMessage());
        }
    }

    private void listAbstracts(PrintWriter out,List<Work> works,ListSimilarity ls){
        for(Work w:works){
            List<Work> listW = new ArrayList<>();
            listW.add(w);
            out.printf("\\clearpage\n");
            out.printf("\\subsubsection{%s}\n",w.getKey());
            out.printf("\\label{detail:%s}\n\n",w.getKey());
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

            ls.listSimilarity(out,w);
        }

    }



}
