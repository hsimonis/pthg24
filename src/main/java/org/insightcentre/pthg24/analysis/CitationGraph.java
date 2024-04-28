package org.insightcentre.pthg24.analysis;

import edu.princeton.cs.algs4.CC;
import edu.princeton.cs.algs4.Graph;
import org.insightcentre.pthg24.datamodel.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static org.insightcentre.pthg24.logging.LogShortcut.info;

public class CitationGraph {
    public CitationGraph(Scenario base){
        List<Citation> betweenWorks = base.getListCitation().stream().
                filter(x->x.getCitedWork()!= null).
                filter(x->!x.getCitedWork().getBackground()).
                filter(x->x.getCitingWork()!=null).
                filter(x->!x.getCitingWork().getBackground()).
                toList();
        List<Reference> refWorks = base.getListReference().stream().
                filter(x->x.getCitedWork()!= null).
                filter(x->!x.getCitedWork().getBackground()).
                filter(x->x.getCitingWork()!=null).
                filter(x->!x.getCitingWork().getBackground()).
                toList();
        List<DoiReference> crossWorks = base.getListDoiReference().stream().
                filter(x->x.getReferredWork()!= null).
                filter(x->!x.getReferredWork().getBackground()).
                filter(x->x.getWork()!=null).
                filter(x->!x.getWork().getBackground()).
                toList();
        info("Links "+betweenWorks.size()+" "+refWorks.size()+" "+crossWorks.size());
        int nrNodes = base.getListWork().size();
        int[][] incidence = new int[nrNodes][nrNodes];
        Graph g = new Graph(nrNodes);
        int citeAdded = 0;
        int citeDouble = 0;
        for(Citation cite:betweenWorks){
            if (incidence[cite.getCitingWork().getNr()][cite.getCitedWork().getNr()] == 0) {
                g.addEdge(cite.getCitingWork().getNr(), cite.getCitedWork().getNr());
                cite.getCitingWork().incNrEdges();
                cite.getCitedWork().incNrEdges();
                incidence[cite.getCitingWork().getNr()][cite.getCitedWork().getNr()] = 1;
                citeAdded++;
            } else {
                citeDouble++;
            }
        }
        info("Cite added "+citeAdded+" Double "+citeDouble);
        int refsAdded = 0;
        int refsInverse = 0;
        for(Reference ref:refWorks){
            if (incidence[ref.getCitingWork().getNr()][ref.getCitedWork().getNr()] == 0){
                g.addEdge(ref.getCitingWork().getNr(),ref.getCitedWork().getNr());
                ref.getCitingWork().incNrEdges();
                ref.getCitedWork().incNrEdges();
                incidence[ref.getCitingWork().getNr()][ref.getCitedWork().getNr()] = 1;
                refsAdded++;
            } else {
                refsInverse++;
            }
        }
        info("ref added "+refsAdded+" inverse "+refsInverse+" of "+citeAdded);
        int crossAdded = 0;
        int crossDouble = 0;
        for(DoiReference ref:crossWorks){
            if (incidence[ref.getWork().getNr()][ref.getReferredWork().getNr()] == 0){
                g.addEdge(ref.getWork().getNr(),ref.getReferredWork().getNr());
                ref.getWork().incNrEdges();
                ref.getReferredWork().incNrEdges();
                incidence[ref.getWork().getNr()][ref.getReferredWork().getNr()] = 1;
                crossAdded++;
            } else {
                crossDouble++;
            }
        }
        info("cross added "+crossAdded+" double "+crossDouble+" of "+(citeAdded+refsAdded));

        CC cc = new CC(g);
        int nrClusters = cc.count();
        info("NrClusters "+nrClusters);
        for(Work w:base.getListWork()){
            int id = cc.id(w.getNr());
//            info("Work "+w.getKey()+" "+id+" "+w.getNrEdges());
            w.setCluster(id);
        }
        Map<Integer,List<Work>> map = base.getListWork().stream().collect(groupingBy(Work::getCluster));
        for(Integer i:map.keySet()){
            int nrEntries = (int) map.get(i).stream().filter(x->x.getNrEdges() >1).count();
            int nrLeafs = (int) map.get(i).stream().filter(x->x.getNrEdges() ==1).count();
            if (nrEntries > 1){
                info("Cluster "+i+" "+nrEntries+" "+nrLeafs);
            }
        }
        List<Work> central = base.getListWork().stream().sorted(Comparator.comparing(Work::getNrEdges).reversed()).limit(50).toList();
        for(Work w:central){
//            info("Central "+w.getKey()+" "+w.getNrEdges()+" "+w.getYear()+" "+w.getTitle());
        }

    }
}
