package org.insightcentre.pthg24.imports;

import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.datamodel.Work;

public class RangeMaxCitations {
    public RangeMaxCitations(Scenario base){
        for(Work w:base.getListWork()){
            int max = Math.max(w.getNrCitations(),Math.max(w.getCrossrefCitations(),w.getScopusCitations()));
            int min = Math.min(w.getNrCitations(),Math.min(w.getCrossrefCitations(),w.getScopusCitations()));
            int range = max-min;
            w.setMaxCitations(max);
            w.setRangeCitations(range);
        }
    }
}
