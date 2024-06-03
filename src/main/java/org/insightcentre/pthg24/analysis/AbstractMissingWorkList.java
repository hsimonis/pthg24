package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.MissingWork;
import org.insightcentre.pthg24.datamodel.Scenario;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractMissingWorkList extends AbstractList{

    public AbstractMissingWorkList(Scenario base){
        super(base);
    }

    protected List<MissingWork> included(double relevanceLimit){
        return base.getListMissingWork().stream().
                filter(this::included).
                filter(x->x.getRelevance()>= relevanceLimit).
                sorted(Comparator.comparing(MissingWork::getRelevance).reversed()).
                toList();
    }

    protected List<MissingWork> highlyConnected(double relevanceLimit) {
        return base.getListMissingWork().stream().
                filter(this::included).
                filter(x -> x.getRelevance() < relevanceLimit).
                sorted(Comparator.comparing(MissingWork::getNrLinks).reversed()).
                limit(50).
                toList();
    }

    protected List<MissingWork> excluded(double relevanceLimit) {
        return base.getListMissingWork().stream().
                filter(x -> !included(x)).
                filter(x -> x.getRelevance() >= relevanceLimit).
                sorted(Comparator.comparing(MissingWork::getRelevance).reversed()).
                toList();
    }


    protected boolean included(MissingWork x){
        return !x.getTitle().equals("") &&
                !x.getType().equals("other") &&
                !x.getType().equals("posted-content") &&
                !x.getType().equals("report") &&
                !x.getType().equals("dataset") &&
                !x.getType().equals("reference-entry");

    }



}
