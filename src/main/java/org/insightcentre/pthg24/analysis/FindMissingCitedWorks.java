package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class FindMissingCitedWorks {
    public FindMissingCitedWorks(Scenario base){
        Map<String, List<Reference>> map = base.getListReference().stream().
                filter(x->x.getCitedWork()==null).
                filter(x->x.getCitingWork() != null && !x.citingWork.getBackground()).
                collect(groupingBy(Reference::getCited));
        for(String s:map.keySet()){
            List<Reference> citations = map.get(s);
            MissingCitedWork mcw = new MissingCitedWork(base);
            mcw.setName(s);
            mcw.setDoi(s);
            mcw.setNrCitations(citations.size());
        }
    }
}
