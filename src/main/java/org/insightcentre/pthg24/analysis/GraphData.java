package org.insightcentre.pthg24.analysis;

import edu.princeton.cs.algorithms.CC;
import edu.princeton.cs.algorithms.Graph;
import org.insightcentre.pthg24.datamodel.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;

import static org.insightcentre.pthg24.logging.LogShortcut.info;

public class GraphData {
    Scenario base;
    int nodeNr = 0;

    public GraphData(Scenario base){
        this.base = base;
        Hashtable<Work, Node> workHash = new Hashtable<>();
        Hashtable<String,Edge> edgeHash = new Hashtable<>();
        for(Work w:base.getListWork()) {
            List<Work> references = new ArrayList<>();
            references.addAll(base.getListCrossReference().stream().
                    filter(x -> x.getWork() == w).
                    filter(x -> x.getReferredWork() != null).
                    map(CrossReference::getReferredWork).
                    toList());
            references.addAll(base.getListReference().stream().
                    filter(x -> x.getCitingWork() == w).
                    filter(x -> x.getCitedWork() != null).
                    map(Reference::getCitedWork).toList());
            references = references.stream().
                    distinct().
                    sorted(Comparator.comparing(Work::getName)).
                    toList();
            List<Work> citing = new ArrayList<>();
            citing.addAll(base.getListCrossReference().stream().
                    filter(x -> x.getReferredWork() == w).
                    filter(x -> x.getWork() != null).
                    map(CrossReference::getWork).
                    toList());
            citing.addAll(base.getListReference().stream().
                    filter(x -> x.getCitedWork() == w).
                    filter(x -> x.getCitingWork() != null).
                    map(Reference::getCitingWork).
                    toList());
            citing = citing.stream().distinct().
                    sorted(Comparator.comparing(Work::getName)).
                    toList();
            for(Work ref:references){
                String edgeKey = edgeKey(w,ref);
                Edge e = edgeHash.get(edgeKey);
                if (e == null){
                    e = new Edge(base);
                    e.setName(edgeKey);
                    e.setFrom(findNode(w,workHash));
                    e.setTo(findNode(ref,workHash));
                    edgeHash.put(edgeKey,e);
                    e.getFrom().incNrEdges();
                    e.getTo().incNrEdges();
                }
            }
            for(Work cite:citing){
                String edgeKey = edgeKey(cite,w);
                Edge e = edgeHash.get(edgeKey);
                if (e == null){
                    e = new Edge(base);
                    e.setName(edgeKey);
                    e.setFrom(findNode(cite,workHash));
                    e.setTo(findNode(w,workHash));
                    edgeHash.put(edgeKey,e);
                    e.getFrom().incNrEdges();
                    e.getTo().incNrEdges();
                }
            }
        }

        Graph g = new Graph(nodeNr);
        for(Edge e:base.getListEdge()){
            g.addEdge(e.getFrom().getNr(),e.getTo().getNr());
        }
        CC cc = new CC(g);
        info("Connected Components "+cc.count());
        for(Node node:base.getListNode()){
            int comp = cc.id(node.getNr());
            node.setConnectedComponentNr(comp);

        }

    }

    private Node findNode(Work w,Hashtable<Work,Node> workHash){
        Node res = workHash.get(w);
        if (res == null){
            res = new Node(base);
            res.setName(w.getName());
            res.setNr(nodeNr++);
            res.setWork(w);
            workHash.put(w,res);
        }
        return res;
    }

    private String edgeKey(Work from,Work to){
        return from.getName()+"/"+to.getName();
    }
}
