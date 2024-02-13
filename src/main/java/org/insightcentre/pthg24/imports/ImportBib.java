package org.insightcentre.pthg24.imports;

import org.insightcentre.pthg24.datamodel.*;
import org.jbibtex.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.insightcentre.pthg24.logging.LogShortcut.*;
import static org.jbibtex.BibTeXEntry.*;

public class ImportBib {
    Scenario base;
    public ImportBib(Scenario base, String importDir, String fileName){
        this.base = base;
        assert(importDir.endsWith("/"));
        String fullName = importDir+fileName;
        try{
            Reader reader = new FileReader(fullName);
            //??? I do not know if the following would help, it does not seem to be required with DBLP entries
//            CharacterFilterReader filterReader = new CharacterFilterReader(reader);

            BibTeXParser bibtexParser = new BibTeXParser();

            BibTeXDatabase database = bibtexParser.parse(reader);
            reader.close();
            Map<Key, BibTeXEntry> entryMap = database.getEntries();

            Collection<BibTeXEntry> entries = entryMap.values();
            for(BibTeXEntry entry : entries){
                Key workKey = entry.getKey();
                Key type = entry.getType();
                Work work=null;
                switch (type.toString()){
                    case "article":
                        Article art = new Article(base);
                        art.setName(workKey.toString());
                        art.setKey(shortKey(workKey.toString()));
                        art.setJournal(findJournal(fieldString(entry,KEY_JOURNAL)));
                        art.setLocalCopy("articles/"+art.getKey()+".pdf");
                        work = art;
                        break;
                    case "inproceedings":
                        Paper pap = new Paper(base);
                        pap.setName(workKey.toString());
                        pap.setKey(shortKey(workKey.toString()));
                        pap.setProceedings(findProceedings(fieldString(entry,KEY_BOOKTITLE),fieldInteger(entry,KEY_YEAR)));
                        pap.setLocalCopy("papers/"+pap.getKey()+".pdf");
                        work=pap;
                        break;
                    case "incollection":
                        InCollection inc = new InCollection(base);
                        inc.setName(workKey.toString());
                        inc.setCollection(findCollection(fieldString(entry,KEY_BOOKTITLE)));
                        work=inc;
                        break;
                    case "phdthesis":
                        PhDThesis phd = new PhDThesis(base);
                        phd.setName(workKey.toString());
                        phd.setSchool(findSchool(fieldString(entry,KEY_SCHOOL)));
                        work=phd;
                        break;
                    default:
                       warning("Work type "+type+" for entry "+workKey.toString()+" not implemented");
                }
                if (work != null){
                    work.setTitle(fieldString(entry,KEY_TITLE));
                    work.setAuthor(fieldString(entry,KEY_AUTHOR));
                    work.setAuthors(splitAuthors(work.getAuthor(),work));
                    work.setYear(fieldInteger(entry,KEY_YEAR));
                    work.setPages(fieldString(entry,KEY_PAGES));
                    work.setNrPages(nrPages(work.getPages()));
                    work.setDoi(fieldString(entry,KEY_DOI));
                    work.setUrl(fieldString(entry,KEY_URL));
                }
            }
        } catch(IOException e){
            severe("Cannot read file "+fullName+", exception "+e.getMessage());
        } catch(ParseException e){
            severe("Parsing error "+e.getMessage());
        }
    }

    private String shortKey(String text){
        int lastIndex = text.lastIndexOf("/");
        if (lastIndex == -1) {
            return text;
        }
        return text.substring(lastIndex+1);
    }

    //??? bibtex entries may split strings over multiple lines, we do not want to retain that
    private String singleLine(String text){
        return text.replaceAll("[\\n\\t\\r]+"," ");
    }

    private String fieldString(BibTeXEntry entry,Key field){
        Value v = entry.getField(field);
        if (v==null){
            return "";
        } else {
            return singleLine(v.toUserString());
        }
    }

    private Integer fieldInteger(BibTeXEntry entry,Key field){
        Value v = entry.getField(field);
        if (v==null){
            return null;
        } else {
            return Integer.parseInt(singleLine(v.toUserString()));
        }
    }

    //??? we assume that the bibtex entry has multiple authors separated by " and "
    private List<Author> splitAuthors(String authors,Work work){
        List<Author> res = new ArrayList<>();
        String[] split = authors.split(" and ");
        for (String s : split) {
            Author author = findAuthor(s);
            author.incNrWorks();
            Authorship ship = new Authorship(base);
            ship.setAuthor(author);
            ship.setWork(work);
            res.add(author);
        }
        return res;
    }

    private Author findAuthor(String name){
        Author res = Author.findByName(base,name);
        if (res==null){
            res = new Author(base);
            res.setName(name);
            res.setShortName(shortName(name));
        }
        return res;
    }

    private Integer nrPages(String pages){
        String[] split = pages.split("--");
        if (split.length==1){
            Integer page = extractInt(pages);
            if (page == null){
                return null;
            } else {
                return 1;
            }
        } else if (split.length==2){
            Integer from = extractInt(split[0]);
            Integer to = extractInt(split[1]);
            if (from==null || to == null){
                return null;
            }
            return to-from+1;
        }
        return null;
    }

    //??? LIPICS uses xxx:yy for page references, xxx is the paper, yy is the page number starting from 1
    private Integer extractInt(String text){
        if (text.contains(":")){
            String[] split = text.split(":");
            return extractInt(split[1]);
        }
        try {
            return Integer.parseInt(text);
        } catch(NumberFormatException e){
            warning("Pages format not handled "+text);
            return null;
        }
    }

    private Journal findJournal(String name){
        if (name == null){
            return null;
        }
        Journal res = Journal.findByName(base,name);
        if (res == null){
            res = new Journal(base);
            res.setName(name);
        }
        return res;
    }

    private Proceedings findProceedings(String name,Integer year){
        if (name == null){
            return null;
        }
        Proceedings res = Proceedings.findByName(base,name);
        if (res == null){
            res = new Proceedings(base);
            res.setName(name);
            res.setSeries(extractSeries(name));
            res.setShortName(res.getSeries()+" "+year);
        }
        return res;
    }


    //???hacky version to extract the conference series name in a simple form, extend cases as required
    private String extractSeries(String text){
        if (text.contains("Principles and Practice of Constraint Programming")){
            return "CP";
        }
        if (text.contains("International Conference on Automated Planning and Scheduling")){
            return "ICAPS";
        }
        String[] series = new String[]{"CPAIOR","ECAI","AAAI","IJCAI","ICTAI","ICAPS","GECCO","CoDIT","ICAART",
                "ICNSC","ICCL","Fog-IoT","EUROCAST","FUZZ-IEEE","ICRA","IDC","RAAD","ACIIDS","AICCC","AIAI",
                "PATAT","PLILP","PACT","EUROMICRO","DIMACS","FPGA","ECC","CIT","INAP","ISCA","DSD","KES","CAiSE",
                "ERCIM/CologNet","APMS","JFPL","ICPADS","ATMOS",
                "TENCON","FSKD","GOR","ICPC","ICNC","PRICAI","CANDAR","SCAM","GreenCom","CSE","SoC","ANT","HM","SEA"};
        for(String cand:series) {
            if (text.contains(cand)) {
                return cand;
            }
        }
        if (text.contains("Logic Programming") && text.contains("Symposium")) {
            return "ILPS";
        }
        if (text.contains("International Conference on Robotics and Automation")){
            return "ICRA";
        }
        return null;
    }

    /*
    this is a bit of a hack, we do not deal with more complex name pattern
    //???should extend this to handle multiple initials
    //???should extend this to deal with compound first names "Jean-Francois" is currently shortened to "J." not J.-F.
    fallback is to use the full name instead
     */
    private String shortName(String text){
        String[] split = text.split(" ");
        if (split.length==2 && startsWithAZ(split[0])){
            return shortForm(split[0])+". "+split[1];
        }
        return text;
    }

    //???We do not mess with names that start with latex special characters
    private boolean startsWithAZ(String name){
        return name.matches("[A-Z].*");
    }
    private String shortForm(String name){
        return name.substring(0,1);
    }

    private org.insightcentre.pthg24.datamodel.Collection findCollection(String name){
        if (name == null){
            return null;
        }
        org.insightcentre.pthg24.datamodel.Collection res = org.insightcentre.pthg24.datamodel.Collection.findByName(base,name);
        if (res == null){
            res = new org.insightcentre.pthg24.datamodel.Collection(base);
            res.setName(name);
        }
        return res;
    }
    private School findSchool(String name){
        if (name == null){
            return null;
        }
        School res = School.findByName(base,name);
        if (res == null){
            res = new School(base);
            res.setName(name);
        }
        return res;
    }

}
