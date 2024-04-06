package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class FindCoauthorLinks {
    Scenario base;
    Hashtable<String, Coauthor> hash = new Hashtable<>();
    int nr = 1;
    public FindCoauthorLinks(Scenario base){
        this.base = base;
        Map<Work, List<Authorship>> map = base.getListAuthorship().stream().collect(groupingBy(Authorship::getWork));
        for(Work w:map.keySet()){
            List<Authorship> list = map.get(w);
            processCoauthors(w,list);
        }
    }

    private void processCoauthors(Work w,List<Authorship> list){
        for(Author a1: list.stream().map(Authorship::getAuthor).sorted().toList()){
            for(Author a2: list.stream().map(Authorship::getAuthor).sorted().toList()){
                if (a1.getKey().compareTo(a2.getKey())<0) {
                    addCoauthor(a1,a2,w);
                }
            }
        }
    }

    private void addCoauthor(Author a1,Author a2,Work w){
        String key = key(a1,a2);
        Coauthor ca = hash.get(key);
        if (ca == null){
            ca  = new Coauthor(base);
            ca.setName("ca"+nr++);
            ca.setAuthor1(a1);
            ca.setAuthor2(a2);
            ca.setEarliestYear(w.getYear());
            ca.setLatestYear(w.getYear());
            hash.put(key,ca);
        }
        ca.incNrWorks();
        ca.setNrCites(ca.getNrCites()+w.getNrCitations());
        ca.setEarliestYear(Math.min(ca.getEarliestYear(),w.getYear()));
        ca.setLatestYear(Math.max(ca.getLatestYear(),w.getYear()));
    }

    private String key(Author a1,Author a2){
        return a1.getKey()+"/"+a2.getKey();
    }
}
