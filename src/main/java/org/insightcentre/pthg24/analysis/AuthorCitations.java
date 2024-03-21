package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.Author;
import org.insightcentre.pthg24.datamodel.Scenario;

public class AuthorCitations {
    public AuthorCitations(Scenario base){
        for(Author a:base.getListAuthor()){
            a.setNrWorks((int)base.getListAuthorship().stream().
                    filter(x->x.getAuthor()==a).
                    filter(x->!x.getWork().getBackground()).
                    count());
            a.setNrCitations(base.getListAuthorship().stream().
                    filter(x->x.getAuthor()==a).
                    filter(x->!x.getWork().getBackground()).
                    mapToInt(x->x.getWork().getNrCitations()).
                    sum());
        }
    }
}
