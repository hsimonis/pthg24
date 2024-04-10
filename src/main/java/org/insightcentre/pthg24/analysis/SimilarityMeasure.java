package org.insightcentre.pthg24.analysis;

import org.apache.commons.collections4.CollectionUtils;
import org.insightcentre.pthg24.datamodel.*;

import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static org.insightcentre.pthg24.logging.LogShortcut.info;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class SimilarityMeasure {
    Scenario base;
    public SimilarityMeasure(Scenario base){
        this.base = base;
        Hashtable<Work, Hashtable<Concept,ConceptWork>> masterHash = new Hashtable<>();
        Map<Work,List<ConceptWork>> map = base.getListConceptWork().stream().collect(groupingBy(ConceptWork::getWork));
        for(Work w:map.keySet()){
            List<ConceptWork> list = map.get(w);
            Hashtable<Concept,ConceptWork> workHash = new Hashtable<>();
            for(ConceptWork cw:list){
                workHash.put(cw.getConcept(),cw);
            }
            masterHash.put(w,workHash);
        }
        for(Work work1:base.getListWork()){
            for(Work work2:base.getListWork()){
                if (work1.getName().compareTo(work2.getName())<0){
                    computeSimilarity(work1,work2,masterHash);
                }
            }
        }
    }

    private void computeSimilarity(Work work1,Work work2,Hashtable<Work, Hashtable<Concept,ConceptWork>> masterHash){
        List<String> ref1 = base.getListReference().stream().filter(x->x.getCitingWork()==work1).map(Reference::getCited).sorted().toList();
        List<String> ref2 = base.getListReference().stream().filter(x->x.getCitingWork()==work2).map(Reference::getCited).sorted().toList();
        Collection<String> commonRef = CollectionUtils.intersection(ref1,ref2);
//        double vRef = 1.0*commonRef.size()/Math.min(ref1.size(),ref2.size());
        double vRef = 2.0*commonRef.size()/(ref1.size()+ref2.size());
        List<String> cite1 = base.getListCitation().stream().filter(x->x.getCitedWork()==work1).map(Citation::getCiting).sorted().toList();
        List<String> cite2 = base.getListCitation().stream().filter(x->x.getCitedWork()==work2).map(Citation::getCiting).sorted().toList();
        Collection<String> commonCite = CollectionUtils.intersection(cite1,cite2);
//        double vCite = 1.0*commonCite.size()/Math.min(cite1.size(),cite2.size());
        double vCite = 2.0*commonCite.size()/(cite1.size()+cite2.size());
        Double vConcept = conceptSimilarity(work1,work2,masterHash);


        Similarity s = new Similarity(base);
        s.setWork1(work1);
        s.setWork2(work2);
        s.setRef1(ref1.size());
        s.setRef2(ref2.size());
        s.setNrSharedReferences(commonRef.size());
        s.setCite1(cite1.size());
        s.setCite2(cite2.size());
        s.setNrSharedCitations(commonCite.size());
        s.setSimilarityRef(vRef);
        s.setSimilarityCite(vCite);
        s.setSimilarityConcept(vConcept);
        s.setSimilarity(vRef+vCite);

        Similarity ss = new Similarity(base);
        ss.setWork1(work2);
        ss.setWork2(work1);
        ss.setRef1(ref2.size());
        ss.setRef2(ref1.size());
        ss.setNrSharedReferences(commonRef.size());
        ss.setCite1(cite2.size());
        ss.setCite2(cite1.size());
        ss.setNrSharedCitations(commonCite.size());
        ss.setSimilarityRef(vRef);
        ss.setSimilarityCite(vCite);
        ss.setSimilarityConcept(vConcept);
        ss.setSimilarity(vRef+vCite);

    }

    private Double conceptSimilarity(Work work1,Work work2,Hashtable<Work, Hashtable<Concept,ConceptWork>> masterHash){
        Hashtable<Concept,ConceptWork> hash1 = masterHash.get(work1);
        Hashtable<Concept,ConceptWork> hash2 = masterHash.get(work2);
        if (hash1 == null){
//            info("Problem "+work1);
            return Double.NaN;
        }
        if (hash2 == null){
//            info("Problem "+work2);
            return Double.NaN;
        }
        double dist = 0.0;
        for(Concept c:base.getListConcept()){
            ConceptWork cw1 = hash1.get(c);
            ConceptWork cw2 = hash2.get(c);
            int occ1 = occurences(cw1,c,work1);
            int occ2 = occurences(cw2,c,work2);
            dist += (occ1-occ2)*(occ1-occ2);
        }
        if (dist == 0.0) {
            info("-------------------------");
            for (Concept c : base.getListConcept()) {
                ConceptWork cw1 = hash1.get(c);
                ConceptWork cw2 = hash2.get(c);
                int occ1 = occurences(cw1, c, work1);
                int occ2 = occurences(cw2, c, work2);
                info(c+" "+occ1+" "+occ2);

            }
        }
        return Math.sqrt(dist);
    }

    private int occurences(ConceptWork cw,Concept c,Work w){
        if (cw == null){
            // this should be there
            severe("missing cw "+c+" for work "+w);
            assert(false);
            return 0;
        } else {
            return matchlevelToValue(cw.getMatchLevel());
        }
    }

    private int matchlevelToValue(MatchLevel m){
        switch(m){
            case None:return 0;
            case Weak:return 1;
            case Medium:return 2;
            case Strong:return 3;
            default:
                severe("Bad matchlevel "+m);
                assert(false);
                return 0;
        }
    }
}
