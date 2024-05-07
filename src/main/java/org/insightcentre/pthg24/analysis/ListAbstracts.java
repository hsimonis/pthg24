package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.Concept;
import org.insightcentre.pthg24.datamodel.ConceptType;
import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.datamodel.Work;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ListAbstracts {
    Scenario base;
    public ListAbstracts(Scenario base, String exportDir, String fileName){
        this.base = base;
        assert(exportDir.endsWith("/"));
        String fullName = exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            List<Work> works = base.getListWork().stream().
                    filter(x->!x.getAbstractText().equals("")).
                    sorted(Comparator.comparing(Work::getKey)).
                    toList();
            for(Work w:works){
                out.printf("\\subsection{%s}\n",w.getKey());
                out.printf("\\label{abs:%s}\n\n",w.getKey());
                out.printf("Authors: %s\n\n",safe(w.getAuthor()));
                out.printf("Title: %s\n\n",safe(w.getTitle()));
                out.printf("Relevance: %5.2f\n\n",w.getRelevance());
                String text = specials(w.getAbstractText());
                out.printf("%s\n\n",text);
                String concepts = highlighter(w.getTitle()+" "+text);
                out.printf("%s\n\n",concepts);
            }
            out.close();
        } catch(IOException e){
            severe("Cannot write file "+fullName+", exception "+e.getMessage());
        }
    }

    private String specials(String t){
        return t.replaceAll("<p>","").replaceAll("</p>","").
                replaceAll("\\$","USD").replaceAll("%","\\\\%").
                replaceAll("&amp;","\\&").replaceAll("&gt;"," gt ").replaceAll("&lt;"," lt ");
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
