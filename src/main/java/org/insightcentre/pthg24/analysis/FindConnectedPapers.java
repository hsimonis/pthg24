package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.Article;
import org.insightcentre.pthg24.datamodel.Paper;
import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.datamodel.Work;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.insightcentre.pthg24.logging.LogShortcut.info;

public class FindConnectedPapers {
    public FindConnectedPapers(Scenario base){
        List<Work> works = base.getListWork().stream().
                sorted(Comparator.comparing(Work::getName)).
                collect(Collectors.toUnmodifiableList());
        Iterator<Work> it = works.iterator();
        Work prev = it.next();
        while(it.hasNext()){
            Work next = it.next();
            compareWorks(prev,next);
            prev = next;

        }
    }

    private void compareWorks(Work prev,Work next){
        if (prev.getAuthor().equals(next.getAuthor()) &&
                prev.getYear() <= next.getYear() &&
                prev instanceof Paper &&
                next instanceof Article){
            info("check connected "+prev+" "+((Paper) prev).getProceedings().getShortName()+" "+next+" "+((Article) next).getJournal());
        }
    }
}
