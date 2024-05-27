package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import static org.insightcentre.pthg24.logging.LogShortcut.info;

public class CheckAuthorDoubles {
    Scenario base;
    int nr = 0;
    public CheckAuthorDoubles(Scenario base){
        info("Checking for author doubles");
        this.base = base;
        List<Author> list = base.getListAuthor();
        checkOrcid(list.stream().
                filter(x->!x.getOrcid().equals("")).
                sorted(Comparator.comparing(Author::getOrcid)).
                toList());
        checkShortName(list.stream().
                filter(x->!x.getShortName().equals("")).
                sorted(Comparator.comparing(Author::getShortName)).
                toList());
        checkFamilyName(list.stream().
                filter(x->!x.getFamilyName().equals("")).
                sorted(Comparator.comparing(Author::getFamilyName)).
                toList());
    }

    private void checkOrcid(List<Author> list){
        Iterator<Author> it = list.iterator();
        Author prev = it.next();
        while(it.hasNext()){
            Author current = it.next();
            if (prev.getOrcid().equals(current.getOrcid())){
                AuthorDouble ad = new AuthorDouble(base);
                ad.setName("AD"+nr++);
                ad.setAuthor1(prev);
                ad.setAuthor2(current);
                ad.setReason("Same Orchid "+prev.getOrcid());
                ad.setWork1(works(prev));
                ad.setWork2(works(current));
            }
            prev = current;
        }
    }
    private void checkShortName(List<Author> list){
        Iterator<Author> it = list.iterator();
        Author prev = it.next();
        while(it.hasNext()){
            Author current = it.next();
            if (prev.getShortName().equals(current.getShortName()) &&
                    !prev.getOrcid().equals(current.getOrcid())){
                AuthorDouble ad = new AuthorDouble(base);
                ad.setName("AD"+nr++);
                ad.setAuthor1(prev);
                ad.setAuthor2(current);
                ad.setReason("Same ShortName "+prev.getShortName());
                ad.setWork1(works(prev));
                ad.setWork2(works(current));
            }
            prev = current;
        }
    }

    private void checkFamilyName(List<Author> list){
        Iterator<Author> it = list.iterator();
        Author prev = it.next();
        while(it.hasNext()){
            Author current = it.next();
            if (prev.getFamilyName().equals(current.getFamilyName()) &&
                    !prev.getShortName().equals(current.getShortName()) &&
                    !prev.getOrcid().equals(current.getOrcid())){
                AuthorDouble ad = new AuthorDouble(base);
                ad.setName("AD"+nr++);
                ad.setAuthor1(prev);
                ad.setAuthor2(current);
                ad.setReason("Same FamilyName "+prev.getFamilyName());
                ad.setWork1(works(prev));
                ad.setWork2(works(current));
            }
            prev = current;
        }
    }

    private List<Work> works(Author a){
        return base.getListAuthorship().stream().
                filter(x->x.getAuthor()==a).
                map(Authorship::getWork).
                sorted(Comparator.comparing(Work::getKey)).
                toList();
    }
}
