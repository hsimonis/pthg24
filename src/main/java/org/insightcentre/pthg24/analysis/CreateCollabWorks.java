package org.insightcentre.pthg24.analysis;

import framework.reports.visualization.heatmap.HeatMap;
import org.insightcentre.pthg24.datamodel.*;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class CreateCollabWorks {
    Scenario base;
    int caNr = 0;

    public CreateCollabWorks(Scenario base){
        this.base = base;
        Map<Work, List<WorkAffiliation>> map = base.getListWorkAffiliation().stream().
                filter(x->!x.getWork().getBackground()).
                collect(groupingBy(WorkAffiliation::getWork));
        for(Work w:map.keySet()){
            List<ScopusAffiliation> list = map.get(w).stream().map(WorkAffiliation::getScopusAffiliation).toList();
            if (list.size() > 1) {
                double fraction = 1.0 / (list.size() - 1);
                for (ScopusAffiliation sa1 : list) {
                    for (ScopusAffiliation sa2 : list) {
                        if (sa1.compareTo(sa2) < 0) {
                            CollabWork ca = new CollabWork(base);
                            ca.setName("CA" + caNr++);
                            ca.setWork(w);
                            ca.setAffiliation1(sa1);
                            ca.setAffiliation2(sa2);
                            ca.setFraction(fraction);
                        }
                    }
                }
            }
        }
        Hashtable<String,CollabCount> collabCount = new Hashtable<>();
        for(CollabWork cw:base.getListCollabWork()){
            String key = key(cw);

            CollabCount cc = collabCount.get(key);

            if (cc ==null){
                cc = new CollabCount(base);
                cc.setAffiliation1(cw.getAffiliation1());
                cc.setAffiliation2(cw.getAffiliation2());
                cc.setCount(1);
                cc.setFraction(cw.getFraction());
                collabCount.put(key,cc);

            } else {
                cc.incCount();
                cc.setFraction(cc.getFraction()+cw.getFraction());
            }
        }
        for(ScopusAffiliation sa:base.getListScopusAffiliation()){
            sa.setCollabCount(0);
            sa.setDomesticCollabCount(0);
            sa.setInternationalCollabCount(0);
            sa.setCollabFraction(0.0);
            sa.setDomesticCollabFraction(0.0);
            sa.setInternationalCollabFraction(0.0);
        }
        for(CollabCount cc:base.getListCollabCount()){
            cc.getAffiliation1().setCollabCount(cc.getAffiliation1().getCollabCount()+cc.getCount());
            cc.getAffiliation2().setCollabCount(cc.getAffiliation2().getCollabCount()+cc.getCount());
            cc.getAffiliation1().setCollabFraction(cc.getAffiliation1().getCollabFraction()+cc.getFraction());
            cc.getAffiliation2().setCollabFraction(cc.getAffiliation2().getCollabFraction()+cc.getFraction());
            assert(cc.getAffiliation1().getCollabCount() >= cc.getAffiliation1().getCollabFraction());

            if (cc.getAffiliation1().getScopusCity().getScopusCountry() == cc.getAffiliation2().getScopusCity().getScopusCountry()){
                cc.getAffiliation1().setDomesticCollabCount(cc.getAffiliation1().getDomesticCollabCount()+cc.getCount());
                cc.getAffiliation2().setDomesticCollabCount(cc.getAffiliation2().getDomesticCollabCount()+cc.getCount());
                cc.getAffiliation1().setDomesticCollabFraction(cc.getAffiliation1().getDomesticCollabFraction()+cc.getFraction());
                cc.getAffiliation2().setDomesticCollabFraction(cc.getAffiliation2().getDomesticCollabFraction()+cc.getFraction());
            } else {
                cc.getAffiliation1().setInternationalCollabCount(cc.getAffiliation1().getInternationalCollabCount()+cc.getCount());
                cc.getAffiliation2().setInternationalCollabCount(cc.getAffiliation2().getInternationalCollabCount()+cc.getCount());
                cc.getAffiliation1().setInternationalCollabFraction(cc.getAffiliation1().getInternationalCollabFraction()+cc.getFraction());
                cc.getAffiliation2().setInternationalCollabFraction(cc.getAffiliation2().getInternationalCollabFraction()+cc.getFraction());
            }
            assert(cc.getAffiliation1().getCollabCount() >= cc.getAffiliation1().getCollabFraction());
            assert(cc.getAffiliation2().getCollabCount() >= cc.getAffiliation2().getCollabFraction());
        }
        for(ScopusAffiliation sa:base.getListScopusAffiliation()){
            sa.setCollabPercentage(100.0*sa.getCollabFraction()/sa.getWorkCount());
            sa.setInternationalPercentage(100.0*sa.getInternationalCollabFraction()/sa.getWorkCount());
        }

    }

    private String key(CollabWork cw){
        return cw.getAffiliation1().getName()+"/"+cw.getAffiliation2().getName();
    }
}
