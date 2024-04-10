package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.MissingCitedWork;
import org.insightcentre.pthg24.datamodel.MissingCitingWork;
import org.insightcentre.pthg24.datamodel.MissingWork;
import org.insightcentre.pthg24.datamodel.Scenario;

import java.util.Hashtable;

import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class FindMissingWorks {
    public FindMissingWorks(Scenario base){
        Hashtable <String, MissingWork> hash = new Hashtable<>();
        for(MissingCitedWork mw:base.getListMissingCitedWork()){
            MissingWork m = hash.get(mw.getDoi());
            if (m==null){
                m = new MissingWork(base);
                m.setDoi(mw.getDoi());
                hash.put(mw.getDoi(),m);
            } else {
                severe("Duplicate entry "+mw.getDoi());
                assert(false);
            }
            m.setNrCitations(mw.getNrCitations());
            m.setNrLinks(mw.getNrCitations());
        }
        for(MissingCitingWork mw:base.getListMissingCitingWork()){
            MissingWork m = hash.get(mw.getDoi());
            if (m==null){
                m = new MissingWork(base);
                m.setDoi(mw.getDoi());
                hash.put(mw.getDoi(),m);
            }
            assert(m.getNrCited()==0); // cannot have multiple citing entries
            m.setNrCited(mw.getNrCited());
            m.setNrLinks(m.getNrLinks()+mw.getNrCited());
        }

    }
}
