package org.insightcentre.pthg24.reports;


import org.apache.commons.collections4.CollectionUtils;
import org.insightcentre.pthg24.datamodel.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ComponentGraph {
    public ComponentGraph(Scenario base, int component,String graphvizDir){
        assert(graphvizDir.endsWith("/"));
         List<Node> list = base.getListNode().stream().
                filter(x->x.getConnectedComponentNr()==component).
                toList();
        List<Edge> edges = base.getListEdge().stream().
                filter(x->x.getFrom().getConnectedComponentNr()==component).
                toList();

        try{
            PrintWriter out = new PrintWriter(graphvizDir+"comp"+component+".gv");
            out.printf("strict digraph component {\n");
            for(Node node:list){
                out.printf("%s [label=\"%s\" style=\"filled\" fillcolor=\"%s\"]\n",
                        noDash(node.getName()),
                        noLatexName(node.getName()),
                        color(node.getNrEdges()));

            }
            for(Edge e:edges){
                out.printf("  %s -> %s [weight=1 color=\"black\"]\n ",
                        noDash(e.getFrom().getName()),
                        noDash(e.getTo().getName()));
            }
            out.printf("}\n");
            out.close();

        } catch(IOException e){
            severe("Cannot write graph file");
        }
    }

    private String noDash(String name){
        if (name.startsWith("0")){
            return noDash("x"+name);
        }
        return name.replace("-","");
    }

    private String noLatexName(String name){
        return name.replace("{\\\"{O}}","Ö").
                replace("{\\\"{o}}","ö").
                replace("{\\\"{U}}","Ü").
                replace("{\\\"{u}}","ü").
                replace("{\\'{e}}","é").
                replace("{\\'{a}}","á").
                replace("{\\AA}","Å").
                replace("{\\'{i}}","í").
                replace("{\\'{\\i}}","í").
                replace("{-}","-");
    }

    private String color(int nrWorks){
        return switch (nrWorks) {
            case 1 -> "white";
            case 2 -> "white";
            case 3 -> "white";
            case 4 -> "lightblue";
            case 5 -> "lightgreen";
            case 6 -> "lightgoldenrod";
            case 7 -> "orange";
            default -> "hotpink";
        };
    }
    private String edgeColor(int nrWorks){
        return switch (nrWorks) {
            case 1 -> "grey90";
            case 2 -> "grey70";
            case 3 -> "grey50";
            case 4 -> "blue";
            case 5 -> "green";
            case 6 -> "orange";
            default -> "red";
        };
    }
}
