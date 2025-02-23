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
import static java.util.stream.Collectors.joining;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ListAbstractsMissingWork extends AbstractMissingWorkList{

    public ListAbstractsMissingWork(Scenario base, String exportDir, String fileName,double relevanceLimit){
        super(base);
        assert(exportDir.endsWith("/"));
        String fullName = exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);

            List<MissingWork> included = included(relevanceLimit);
            List<MissingWork> highlyConnected = highlyConnected(relevanceLimit);
            List<MissingWork> excluded = excluded(relevanceLimit);


            listAbstracts(out,included,"Missing Works");
            listAbstracts(out,highlyConnected,"Highly Connected Missing Works");
            listAbstracts(out,excluded,"Excluded Missing Works");

            out.close();
        } catch(IOException e){
            severe("Cannot write file "+fullName+", exception "+e.getMessage());
        }
    }

    public void listAbstracts(PrintWriter out,List<MissingWork> list,String heading){
        out.printf("\\subsection{%s}\n\n",safe(heading));
        for(MissingWork w:list) {
            String key = w.getKey();
            out.printf("\\subsubsection{%s}\n", key);
            out.printf("\\label{mw:%s}\n\n", key);
//                out.printf("\\index{%s}\n\n",key);

            out.printf("Authors: %s\n\n", showAuthor(w.getAuthor()));
            out.printf("Title: %s\n\n", showTitle(w.getTitle()));
            out.printf("Relevance: %5.2f\n\n", w.getRelevance());

            listConcepts(base, out, w.getConcept());

            out.printf("%s\n\n", showAbstract(w.getAbstractText()));
        }
    }

    public static void listConcepts(Scenario base,PrintWriter out,List<Concept> concepts) {
        out.printf("{\\scriptsize\n");
        out.printf("\\begin{longtable}{p{2cm}p{20cm}}\n");
        out.printf("\\caption{Extracted Features from Title and Abstract}\\\\ \\toprule\n");
        out.printf("Type & Concepts Found\\\\ \\midrule\n");
        out.printf("\\endhead\n");
        out.printf("\\bottomrule\n");
        out.printf("\\endfoot\n");
        for (ConceptType type : base.getListConceptType()) {
            out.printf("%s & %s\\\\ \n", type.getName(), conceptString(type, concepts));
        }
        out.printf("\\end{longtable}\n}\n\n");
    }


    public static String conceptString(ConceptType type,List<Concept> list){
        return list.stream().filter(x->x.getConceptType()==type).map(ApplicationObject::getName).collect(joining(", "));
    }


}
