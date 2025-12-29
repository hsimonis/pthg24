package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

import static org.insightcentre.pthg24.datamodel.SubType.Regular;
import static org.insightcentre.pthg24.logging.LogShortcut.info;

public class PotentialLinkSearch {
    Scenario base;
    public PotentialLinkSearch(Scenario base){
        this.base = base;

        Hashtable<String, MissingWork> mwHash = new Hashtable<>();
        for(MissingWork mw:base.getListMissingWork().stream().filter(x->x.getDoi() != null).filter(x->x.getType().equals("journal-article")).toList()){
            mwHash.put(mw.getDoi(),mw);
        }
        for(Work w:base.getListWork().stream().filter(x->x.getSubType()==Regular || x.getSubType()== SubType.ShortPaper).toList()){
            info("work "+w.getName()+" "+w.getAuthor()+" "+w.getTitle());
            List<Citation> citing = base.getListCitation().stream().
                    filter(x->x.getCitedWork()==w).
                    filter(x->x.getCitingWork()==null).
                    toList();
            info("Nr Citing Doi "+citing.size());
            for(Citation citation:citing){
                String doi = citation.getCiting();
                MissingWork mw = mwHash.get(doi);
                if (mw != null){
                    info("Citing "+doi+" "+mw.getTitle()+" "+mw.getSource()+" "+mw.getYear()+" "+mw.getAuthor());
                    double authorMatch=authorMatch(w,mw);
                    if (authorMatch > 0) {
                        LinkCandidate lc = new LinkCandidate(base);
                        lc.setWork(w);
                        lc.setCitation(citation);
                        lc.setMissingWork(mw);
                        lc.setAuthorMatch(authorMatch);
                        lc.setTitleMatch(titleMatch(w, mw));
                        lc.setWTitle(w.getTitle());
                        lc.setMwTitle(mw.getTitle().replaceAll("\\\\",""));
                        lc.setWAuthor(w.getAuthors().stream().map(Author::getShortName).collect(Collectors.joining(",")));
                        lc.setMwAuthor(mw.getAuthor());
                        lc.setJournal(mw.getSource());
                        lc.setYear(mw.getYear());
                        lc.setLink(w.getLink()==null?"-":w.getLink().getJournal());
                    }
                }
            }

        }
    }

    public double authorMatch(Work w,MissingWork mw){
        String mwAuthors = mw.getAuthor();
        if (w.getAuthors().stream().map(Author::getShortName).collect(Collectors.joining(", ")).equals(mwAuthors)){
            return 1000.0;
        }
        int lastNameMatches = 0;

        for(Author a:w.getAuthors()){
            if (mwAuthors.contains(a.getFamilyName())) {
                lastNameMatches++;
            }
        }
        return 1.0*lastNameMatches/w.getAuthors().size();
    }

    public double titleMatch(Work w,MissingWork mw){
        String wTitle = demathify(w.getTitle().toLowerCase());
        String mwTitle = demathify(mw.getTitle().toLowerCase());
        if (wTitle.equals(mwTitle)){
            return 1000.0;
        }
        if (wTitle.contains(mwTitle) || mwTitle.contains(wTitle)){
            return 100.0;
        }
        String[] split = wTitle.split("\\s");
        int wordMatches = 0;

        for(String word:split){
            if (mwTitle.contains(word)){
                wordMatches++;
            }
        }
        return 1.0*wordMatches/split.length;
    }

    public static String demathify(String text){
        return text.replaceAll("\\{","").replaceAll("}","").replaceAll("\\\\","").replaceAll("\\^","").replaceAll("\\$","");
    }
}
