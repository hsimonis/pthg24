package org.insightcentre.pthg24.reports;


import org.apache.commons.collections4.CollectionUtils;
import org.insightcentre.pthg24.datamodel.Author;
import org.insightcentre.pthg24.datamodel.Coauthor;
import org.insightcentre.pthg24.datamodel.Scenario;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class CoauthorGraph {
    public CoauthorGraph(Scenario base, int cutoff, String graphvizDir,String reportDir, String fileName){
        assert(graphvizDir.endsWith("/"));
        assert(reportDir.endsWith("/"));
        List<Coauthor> list = base.getListCoauthor().stream().
                filter(x->x.getAuthor1().getNrWorks()>= cutoff).
                filter(x->x.getAuthor2().getNrWorks()>= cutoff).
                toList();
        List<Author> authors1 = list.stream().map(Coauthor::getAuthor1).distinct().sorted().toList();
        List<Author> authors2 = list.stream().map(Coauthor::getAuthor2).distinct().sorted().toList();
        Collection<Author> authors = CollectionUtils.union(authors1,authors2);

        try{
            PrintWriter out = new PrintWriter(graphvizDir+"coauth.gv");
            out.printf("strict graph coauth {\n");
            for(Author a:authors){
                out.printf("%s [label=\"%s\"]\n",a.getKey(),a.getShortName().
                        replace("{\\\"{O}}","Ö").
                        replace("{\\\"{o}}","ö").
                        replace("{\\\"{U}}","Ü").
                        replace("{\\\"{u}}","ü").
                        replace("{\\'{e}}","é").
                        replace("{\\'{a}}","á").
                        replace("{\\AA}","Å").
                        replace("{\\'{i}}","í").
                        replace("{\\'{\\i}}","í").
                        replace("{-}","-"));
            }
            for(Coauthor ca:list){
                out.printf("  %s -- %s [weight=%d]\n ",
                        ca.getAuthor1().getKey(),
                        ca.getAuthor2().getKey(),
                        ca.getNrWorks());
            }
            out.printf("}\n");
            out.close();

        } catch(IOException e){
            severe("Cannot write graph file");
        }
    }
}
