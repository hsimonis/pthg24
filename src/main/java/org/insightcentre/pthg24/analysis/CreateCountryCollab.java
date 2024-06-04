package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class CreateCountryCollab {
    Scenario base;
    Hashtable<String,CountryCollab> hash = new Hashtable<>();
    public CreateCountryCollab(Scenario base){
        this.base = base;
        Map<Work, List<WorkAffiliation>> map = base.getListWorkAffiliation().stream().collect(groupingBy(WorkAffiliation::getWork));
        for(Work w:map.keySet()){
            List<WorkAffiliation> affs = map.get(w);
            List<ScopusCountry> countries = affs.stream().
                    map(x->x.getScopusAffiliation().getScopusCity().getScopusCountry()).
                    distinct().
                    sorted().
                    toList();
            if (countries.size() > 1){
                for(ScopusCountry c1:countries){
                    for(ScopusCountry c2:countries){
                        if (c1 != c2){
                            inc(c1,c2);
                        }
                    }
                }
            }
        }
    }

    private void inc(ScopusCountry c1,ScopusCountry c2){
        String key = key(c1,c2);
        CountryCollab cc = hash.get(key);
        if (cc == null){
            cc = new CountryCollab(base);
            cc.setName(key);
            cc.setCountry1(c1);
            cc.setCountry2(c2);
            hash.put(key,cc);
        }
        cc.incCount();
    }

    private String key(ScopusCountry c1,ScopusCountry c2){
        return c1.getName()+"/"+c2.getName();
    }
}
