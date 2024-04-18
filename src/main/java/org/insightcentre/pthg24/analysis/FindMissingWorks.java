package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Hashtable;

import static org.insightcentre.pthg24.imports.ImportCrossref.properDOI;
import static org.insightcentre.pthg24.logging.LogShortcut.info;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class FindMissingWorks {
    public FindMissingWorks(Scenario base){
        Hashtable <String, MissingWork> hash = new Hashtable<>();
        for(MissingCitedWork mw:base.getListMissingCitedWork()){
            MissingWork m = hash.get(mw.getDoi());
            if (m==null){
                m = new MissingWork(base);
                m.setName(mw.getDoi());
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
                m.setName(mw.getDoi());
                m.setDoi(mw.getDoi());
                hash.put(mw.getDoi(),m);
            }
            assert(m.getNrCited()==0); // cannot have multiple citing entries
            m.setNrCited(mw.getNrCited());
            m.setNrLinks(m.getNrLinks()+mw.getNrCited());
        }

        updateDoiReferences(base,hash);

    }

    /*
    update the MissingWork fields in the Doi references at this time, when the MissingWork objects have been created
     */
    private void updateDoiReferences(Scenario base,Hashtable<String,MissingWork> hash){
        info("MissingWorks "+hash.keySet().size());
        info("Doi Refs "+base.getListDoiReference().size());
        int checked = 0;
        int found = 0;
        for(DoiReference ref:base.getListDoiReference()){
            if(ref.getDoi()!= null && !ref.getDoi().equals("")){
                checked++;
                MissingWork mw = hash.get(ref.getDoi().toLowerCase());
                if (mw != null) {
                    found++;
                    ref.setMissingWork(mw);
                }
            }
        }
        info("Checked "+checked+" found "+found);
        Hashtable<String,MissingCross> crossHash = new Hashtable<>();
        for(DoiReference ref:base.getListDoiReference()){
            if (ref.getReferredWork()==null && ref.getMissingWork()==null){
                String doi = ref.getDoi().toLowerCase();
                MissingCross mc = crossHash.get(doi);
                if (mc == null) {
                    mc = new MissingCross(base);
                    mc.setName(doi);
                    mc.setDoi(doi);
                    if (ref.getAuthor() != null && !ref.getAuthor().equals("")){
                        mc.setAuthor(ref.getAuthor());
                    }
                    if (ref.getSource() != null && !ref.getSource().equals("")){
                        mc.setSource(ref.getSource());
                    }
                    if (ref.getTitle() != null && !ref.getTitle().equals("")){
                        mc.setTitle(ref.getTitle());
                    }
                    if (ref.getYear()!= null){
                        mc.setYear(ref.getYear());
                    }
                    crossHash.put(doi, mc);
                }
                mc.incCount();
                ref.setMissingCross(mc);

            }
        }

//        assert(false);
    }
}
