package org.insightcentre.pthg24.analysis;

import org.apache.commons.collections4.CollectionUtils;
import org.insightcentre.pthg24.datamodel.*;

import java.util.Collection;
import java.util.List;

public class SimilarityMeasure {
    Scenario base;
    public SimilarityMeasure(Scenario base){
        this.base = base;
        for(Work work1:base.getListWork()){
            for(Work work2:base.getListWork()){
                if (work1.getName().compareTo(work2.getName())<0){
                    computeSimilarity(work1,work2);
                }
            }
        }
    }

    private void computeSimilarity(Work work1,Work work2){
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
        ss.setSimilarity(vRef+vCite);

    }
}
