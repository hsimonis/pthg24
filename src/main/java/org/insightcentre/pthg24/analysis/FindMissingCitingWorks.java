package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.Citation;
import org.insightcentre.pthg24.datamodel.MissingCitingWork;
import org.insightcentre.pthg24.datamodel.Scenario;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class FindMissingCitingWorks {
    public FindMissingCitingWorks(Scenario base){
        Map<String, List<Citation>> map = base.getListCitation().stream().
                filter(x->x.getCitingWork()==null).
                filter(x->x.getCitedWork() != null && !x.getCitedWork().getBackground()).
                collect(groupingBy(Citation::getCiting));
        for(String s:map.keySet()){
            List<Citation> citations = map.get(s);
            MissingCitingWork mcw = new MissingCitingWork(base);
            mcw.setName(s);
            mcw.setDoi(s);
            mcw.setNrCited(citations.size());
        }
    }
}
