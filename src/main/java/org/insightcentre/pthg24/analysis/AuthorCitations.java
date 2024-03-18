package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.Author;
import org.insightcentre.pthg24.datamodel.Scenario;

public class AuthorCitations {
    public AuthorCitations(Scenario base){
        for(Author a:base.getListAuthor()){
            a.setNrCitations(base.getListAuthorship().stream().
                    filter(x->x.getAuthor()==a).
                    mapToInt(x->x.getWork().getNrCitations()).
                    sum());
        }
    }
}
