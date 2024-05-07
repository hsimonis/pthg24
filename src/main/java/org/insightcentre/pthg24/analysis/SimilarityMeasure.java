package org.insightcentre.pthg24.analysis;

import org.apache.commons.collections4.CollectionUtils;
import org.insightcentre.pthg24.datamodel.*;

import java.util.*;
import java.util.Collection;

import static java.lang.Math.sqrt;
import static java.util.stream.Collectors.groupingBy;
import static org.insightcentre.pthg24.logging.LogShortcut.info;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class SimilarityMeasure {
    Scenario base;
    int sNr = 0;
    double maxConceptDistance = 0.0;
    public SimilarityMeasure(Scenario base){
        this.base = base;
        info("Computing similarity");
        Hashtable<Work, Hashtable<Concept,ConceptWork>> masterHash = new Hashtable<>();
        Map<Work,List<ConceptWork>> map = base.getListConceptWork().stream().collect(groupingBy(ConceptWork::getWork));
        Map<Work,List<Citation>> citationMap = base.getListCitation().stream().collect(groupingBy(Citation::getCitedWork));
        Map<Work,List<Reference>> referenceMap = base.getListReference().stream().collect(groupingBy(Reference::getCitingWork));
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
                    computeSimilarity(work1,work2,masterHash,citationMap,referenceMap);
                }
            }
        }
        scaleConceptDistance(maxConceptDistance);
        info("Similarity done");
    }

    private void computeSimilarity(Work work1,Work work2,Hashtable<Work,
            Hashtable<Concept,ConceptWork>> masterHash,
                                   Map<Work,List<Citation>> citationMap,
                                   Map<Work,List<Reference>> referenceMap){
        double vRef;
        double vCite;
        Collection<String> commonRef = new ArrayList<>();
        Collection<String> commonCite = new ArrayList<>();
        if (notInCatalog(work1) || notInCatalog(work2)){
            vRef = Double.NaN;
            vCite = Double.NaN;
        } else {
            List<String>ref1 = listOrEmptyReferences(referenceMap.get(work1)).stream().map(Reference::getCited).sorted().toList();
            List<String>ref2 = listOrEmptyReferences(referenceMap.get(work2)).stream().map(Reference::getCited).sorted().toList();
            commonRef = CollectionUtils.intersection(ref1, ref2);
//        double vRef = 1.0*commonRef.size()/Math.min(ref1.size(),ref2.size());
            vRef = (ref1.size() + ref2.size()-2.0 * commonRef.size()) / (ref1.size() + ref2.size());
            List<String>cite1 = listOrEmptyCitations(citationMap.get(work1)).stream().map(Citation::getCiting).sorted().toList();
            List<String>cite2 = listOrEmptyCitations(citationMap.get(work2)).stream().map(Citation::getCiting).sorted().toList();
            commonCite = CollectionUtils.intersection(cite1, cite2);
//        double vCite = 1.0*commonCite.size()/Math.min(cite1.size(),cite2.size());
            vCite = (cite1.size() + cite2.size()-2.0 * commonCite.size()) / (cite1.size() + cite2.size());
        }

        Double vConcept = conceptSimilarity(work1, work2, masterHash);
        double dotProduct = dotProduct(work1,work2,masterHash);
        double cosine = cosine(work1,work2,masterHash);

        Similarity s = new Similarity(base);
        s.setName("S"+sNr++);
        s.setWork1(work1);
        s.setWork2(work2);
        s.setRef1(work1.getNrReferences());
        s.setRef2(work2.getNrReferences());
        s.setNrSharedReferences(commonRef.size());
        s.setCite1(work1.getNrCitations());
        s.setCite2(work2.getNrCitations());
        s.setNrSharedCitations(commonCite.size());
        s.setSimilarityRef(vRef);
        s.setSimilarityCite(vCite);
        s.setSimilarityConcept(vConcept);
        s.setSimilarity((vRef + vCite)/2.0);
        s.setDotProduct(dotProduct);
        s.setCosine(cosine);

        if (!Double.isNaN(vConcept) && !Double.isInfinite(vConcept) && vConcept > maxConceptDistance){
            maxConceptDistance = vConcept;
        }

//        Similarity ss = new Similarity(base);
//        s.setName("S"+sNr++);
//        ss.setWork1(work2);
//        ss.setWork2(work1);
//        ss.setRef1(work2.getNrReferences());
//        ss.setRef2(work1.getNrReferences());
//        ss.setNrSharedReferences(commonRef.size());
//        ss.setCite1(work2.getNrCitations());
//        ss.setCite2(work1.getNrCitations());
//        ss.setNrSharedCitations(commonCite.size());
//        ss.setSimilarityRef(vRef);
//        ss.setSimilarityCite(vCite);
//        ss.setSimilarityConcept(vConcept);
//        ss.setSimilarity((vRef + vCite)/2.0);
    }


    private List<Citation> listOrEmptyCitations(List<Citation> list){
        if (list == null){
            return new ArrayList<>();
        }
        return list;
    }
    private List<Reference> listOrEmptyReferences(List<Reference> list){
        if (list == null){
            return new ArrayList<>();
        }
        return list;
    }

    private boolean notInCatalog(Work w){
        return w.getNrCitations() == 0 && w.getNrReferences() == 0;
    }

    private Double conceptSimilarity(Work work1,Work work2,Hashtable<Work, Hashtable<Concept,ConceptWork>> masterHash){
        if (work1.getNrConcepts()==0 || work2.getNrConcepts()==0){
            return Double.POSITIVE_INFINITY;
        }
        Hashtable<Concept,ConceptWork> hash1 = masterHash.get(work1);
        Hashtable<Concept,ConceptWork> hash2 = masterHash.get(work2);
        if (hash1 == null){
//            info("Problem "+work1);
            //??? not reached as all ConceptWork considered, even those with None level
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
         return sqrt(dist);
    }

    private int occurences(ConceptWork cw,Concept c,Work w){
        if (cw == null){
            // this should be there
            severe("missing cw "+c+" for work "+w);
//            assert(false);
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

    private void scaleConceptDistance(double maxConceptDistance){
        for(Similarity s:base.getListSimilarity().stream().
                filter(x->!Double.isNaN(x.getSimilarityConcept()) && !Double.isInfinite(x.getSimilarityConcept())).
                toList()){
            s.setSimilarityConcept(s.getSimilarityConcept()/maxConceptDistance);
        }
    }

    private Double dotProduct(Work work1,Work work2,Hashtable<Work, Hashtable<Concept,ConceptWork>> masterHash){
        if (work1.getNrConcepts()==0 || work2.getNrConcepts()==0){
            return Double.POSITIVE_INFINITY;
        }
        Hashtable<Concept,ConceptWork> hash1 = masterHash.get(work1);
        Hashtable<Concept,ConceptWork> hash2 = masterHash.get(work2);
        if (hash1 == null){
            return Double.NaN;
        }
        if (hash2 == null){
            return Double.NaN;
        }
        double dot = 0.0;
        for(Concept c:base.getListConcept()){
            ConceptWork cw1 = hash1.get(c);
            ConceptWork cw2 = hash2.get(c);
            int occ1 = occurences(cw1,c,work1);
            int occ2 = occurences(cw2,c,work2);
            dot += occ1*occ2;
        }
        return dot;
    }
    private Double cosine(Work work1,Work work2,Hashtable<Work, Hashtable<Concept,ConceptWork>> masterHash){
        if (work1.getNrConcepts()==0 || work2.getNrConcepts()==0){
            return Double.POSITIVE_INFINITY;
        }
        Hashtable<Concept,ConceptWork> hash1 = masterHash.get(work1);
        Hashtable<Concept,ConceptWork> hash2 = masterHash.get(work2);
        if (hash1 == null){
            return Double.NaN;
        }
        if (hash2 == null){
            return Double.NaN;
        }
        double dot = 0.0;
        double length1 = 0.0;
        double length2 = 0.0;
        for(Concept c:base.getListConcept()){
            ConceptWork cw1 = hash1.get(c);
            ConceptWork cw2 = hash2.get(c);
            int occ1 = occurences(cw1,c,work1);
            int occ2 = occurences(cw2,c,work2);
            dot += occ1*occ2;
            length1 += occ1*occ1;
            length2 += occ2*occ2;
        }
        return dot/(sqrt(length1)*sqrt(length2));
    }


}
