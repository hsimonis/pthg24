package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.MissingWork;
import org.insightcentre.pthg24.datamodel.OtherWork;
import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.datamodel.Work;

import java.util.Hashtable;

import static org.insightcentre.pthg24.logging.LogShortcut.info;
import static org.insightcentre.pthg24.logging.LogShortcut.warning;

public class FindOthers {
    public FindOthers(Scenario base){
        Hashtable<String, Work> workHash = new Hashtable<>();
        Hashtable<String, Work> keyHash = new Hashtable<>();
        for(Work w:base.getListWork()){
            keyHash.put(w.getKey(),w);
            if (w.getDoi()!= null && !w.getDoi().equals("")){
                workHash.put(w.getDoi(),w);
            }
        }
        Hashtable<String, MissingWork> missingHash = new Hashtable<>();
        for(MissingWork w:base.getListMissingWork()){
            if (w.getDoi()!= null && !w.getDoi().equals("")){
                missingHash.put(w.getDoi(),w);
            }
        }
        int workMatches = 0;
        int keyMatches = 0;
        int missingMatches = 0;
        int unMatched = 0;
        int noDoi = 0;

        for(OtherWork ow:base.getListOtherWork()){
            Work ww = keyHash.get(ow.getKey());
            if (ow.getDoi()!=null && !ow.getDoi().equals("")){
                Work w = workHash.get(ow.getDoi());
                MissingWork mw = missingHash.get(ow.getDoi());
                if (w != null){
                    ow.setIsFound(true);
                    info("other match "+ow.getKey()+" "+w.getKey());
                    workMatches++;
                } else if (mw != null){
                    ow.setIsFound(true);
                    info("other match "+ow.getKey()+" "+mw.getName());
                    missingMatches++;
                } else if (ww != null && sameTitle(ow,ww)){
                    ow.setIsFound(true);
                    info("key match "+ow.getKey()+" "+ww.getKey()+" titles "+ow.getTitle()+" "+ww.getTitle());
                    keyMatches++;
                } else {
                    ow.setIsFound(false);
                    warning("unmatched Doi "+ow.getDoi()+" "+ow.getTitle());
                    unMatched++;

                }
            } else if (ww != null && sameTitle(ow,ww)){
                ow.setIsFound(true);
                info("key match2 "+ow.getKey()+" "+ww.getKey()+" titles "+ow.getTitle()+" "+ww.getTitle());
                keyMatches++;
            } else {
                ow.setIsFound(false);
                warning("No doi "+ow.getTitle());
                noDoi++;
            }

        }
        info("Work Matches "+workMatches+
                " MissingWork Matches "+missingMatches+
                " Key Matches "+keyMatches+
                " Unmatched "+unMatched+
                " No doi "+noDoi+
                " Total "+base.getListOtherWork().size());
        info("Selected "+base.getListOtherWork().stream().filter(OtherWork::getIsSelected).count());
        info("Found "+base.getListOtherWork().stream().filter(OtherWork::getIsFound).count());
        info("Found and Selected "+base.getListOtherWork().stream().filter(x->x.getIsFound() && x.getIsSelected()).count());
        info("NonZero Work Count "+base.getListOtherWork().stream().filter(x->x.getWorkCount()>0).count());

    }

    private boolean sameTitle(OtherWork ow,Work w){
        return ow.getTitle().equalsIgnoreCase(w.getTitle());
    }
}
