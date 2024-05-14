package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.Concept;
import org.insightcentre.pthg24.datamodel.ConceptWork;
import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.datamodel.Work;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static org.insightcentre.pthg24.logging.LogShortcut.warning;

public class CheckInconsistentConcepts {
    Scenario base;
    public CheckInconsistentConcepts(Scenario base){
        this.base = base;
        Map<Work, List<ConceptWork>> map = base.getListConceptWork().stream().filter(x->x.getCount() >0).collect(groupingBy(ConceptWork::getWork));
        for(Work w:map.keySet()){
            List<Concept> concepts = map.get(w).stream().map(ConceptWork::getConcept).toList();
            List<Concept> missing = new ArrayList<>();
            for(Concept c:w.getConcept()){
                if (!concepts.contains(c)){
                    missing.add(c);
                }
            }
            if (w.getLocalCopy() != null && !w.getLocalCopy().equals("") && missing.size() >0){
                warning("Inconsistent "+w.getKey()+" "+missing.size()+" "+missing.stream().map(Concept::getName).collect(joining(", ")));
            }
        }

    }
}
