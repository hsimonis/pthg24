package org.insightcentre.pthg24.imports;

import org.insightcentre.pthg24.datamodel.*;
import org.insightcentre.pthg24.datamodel.Collection;
import org.jbibtex.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

import static org.insightcentre.pthg24.analysis.ListWorks.localCopyExists;
import static org.insightcentre.pthg24.logging.LogShortcut.*;
import static org.jbibtex.BibTeXEntry.*;

public class ImportBib {
    Scenario base;
    public ImportBib(Scenario base, String importDir, String fileName,String worksDir){
        this.base = base;
        assert(importDir.endsWith("/"));
        String fullName = importDir+fileName;
        initAlias(base);
        try{
            Reader reader = new FileReader(fullName);
            //??? I do not know if the following would help, it does not seem to be required with DBLP entries
//            CharacterFilterReader filterReader = new CharacterFilterReader(reader);

            BibTeXParser bibtexParser = new BibTeXParser();

            BibTeXDatabase database = bibtexParser.parse(reader);
            reader.close();
            Map<Key, BibTeXEntry> entryMap = database.getEntries();

            for(BibTeXEntry entry : entryMap.values()){
                Key workKey = entry.getKey();
                Key type = entry.getType();
                Work work=null;
                switch (type.toString().toLowerCase()){
                    case "article":
                        Article art = new Article(base);
                        art.setName(workKey.toString());
                        art.setKey(shortKey(workKey.toString()));
                        art.setJournal(findJournal(fieldString(entry,KEY_JOURNAL)));
                        art.setLocalCopy(worksDir+art.getKey()+".pdf");
                        work = art;
                        break;
                    case "inproceedings":
                        Paper pap = new Paper(base);
                        pap.setName(workKey.toString());
                        pap.setKey(shortKey(workKey.toString()));
                        pap.setProceedings(findProceedings(fieldString(entry,KEY_BOOKTITLE),fieldInteger(entry,KEY_YEAR)));
                        pap.setLocalCopy(worksDir+pap.getKey()+".pdf");
                        work=pap;
                        break;
                    case "incollection":
                        InCollection inc = new InCollection(base);
                        inc.setName(workKey.toString());
                        inc.setKey(shortKey(workKey.toString()));
                        inc.setCollection(findCollection(fieldString(entry,KEY_BOOKTITLE)));
                        inc.setLocalCopy(worksDir+inc.getKey()+".pdf");
                        work=inc;
                        break;
                    case "inbook":
                        InBook inb = new InBook(base);
                        inb.setName(workKey.toString());
                        inb.setKey(shortKey(workKey.toString()));
                        inb.setBooktitle(fieldString(entry,KEY_BOOKTITLE));
                        inb.setLocalCopy(worksDir+inb.getKey()+".pdf");
                        work=inb;
                        break;
                    case "phdthesis":
                        PhDThesis phd = new PhDThesis(base);
                        phd.setName(workKey.toString());
                        phd.setKey(shortKey(workKey.toString()));
                        phd.setSchool(findSchool(fieldString(entry,KEY_SCHOOL)));
                        phd.setLocalCopy(worksDir+phd.getKey()+".pdf");
                        work=phd;
                        break;
                    case "book":
                        Book b = new Book(base);
                        b.setName(workKey.toString());
                        b.setKey(shortKey(workKey.toString()));
                        work=b;
                        break;
//                    case "collection":
//                        Collection c = new Collection(base);
//                        c.setName(workKey.toString());
//                        c.setKey(shortKey(workKey.toString()));
//                        work=c;
//                        break;
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
                    if (!localCopyExists(work)){
                        work.setLocalCopy("");
                    }
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
            s = normalize(s);
            Author author = findAuthor(s);
            author.incNrWorks();
            Authorship ship = new Authorship(base);
            ship.setAuthor(author);
            ship.setWork(work);
            res.add(author);
        }
        return res;
    }

    /*
    replace "Name, FirstName" with "FirstName Name"
     */
    private String normalize(String name){
        if (name.contains(",")){
            String[] split = name.split(",");
            if (split.length != 2) {
                severe("Name has too many commas "+name);
            }
            assert(split.length == 2);
            return split[1].trim()+" "+split[0].trim();
        }
        return name;
    }

    private int authorNr=0;
    private Author findAuthor(String name){
        Author res = Author.findByName(base,name);
        if (res==null){
            res = new Author(base);
            res.setName(name);
            res.setShortName(shortName(name));
            res.setFamilyName(familyName(name));
            res.setKey("a"+authorNr++);
        }
        return res;
    }

    private Integer nrPages(String pages){
        if (pages.contains("--")) {
            String[] split = pages.split("--");
            if (split.length == 2) {
                Integer from = extractInt(split[0]);
                Integer to = extractInt(split[1]);
                if (from == null || to == null) {
                    return null;
                }
                return to - from + 1;
            }
        } else if (pages.contains("-")){
            String[] split = pages.split("-");
            if (split.length == 2) {
                Integer from = extractInt(split[0]);
                Integer to = extractInt(split[1]);
                if (from == null || to == null) {
                    return null;
                }
                return to - from + 1;
            }

        } else {
            Integer page = extractInt(pages);
            if (page == null) {
                return null;
            } else {
                return 1;
            }
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

    Hashtable<String,Journal> aliasHash = new Hashtable<>();

    private void initAlias(Scenario base){
        for(JournalAlias ja:base.getListJournalAlias()){
            aliasHash.put(ja.getAlias(),ja.getJournal());
            aliasHash.put(ja.getJournal().getName(),ja.getJournal());
        }
    }

    private Journal findJournal(String name){
        if (name == null){
            return null;
        }
        if (aliasHash.get(name) != null){
            return aliasHash.get(name);
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
            info("Conf "+name);
            res.setConferenceSeries(findSeries(extractSeries(name)));
            res.setShortName(res.getConferenceSeries().getName()+" "+year);
        }
        return res;
    }

    private ConferenceSeries findSeries(String name){
        info("series "+name);
        ConferenceSeries res = ConferenceSeries.findByName(base,name);
        if (res == null){
            res = new ConferenceSeries(base);
            res.setName(name);
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
                "ICNSC","ICCL","Fog-IoT","EUROCAST","FUZZ-IEEE","ICRA","IDC","RAAD","ACIIDS","AICCC","AIAI","CONTESSA",
                "PATAT","PLILP","PACT","EUROMICRO","DIMACS","FPGA","ECC","CIT","INAP","ISCA","DSD","KES","CAiSE","CCL'99",
                "ERCIM/CologNet","APMS","JFPL","ICPADS","ATMOS","ISMIS","IPDPS","RAST","PADL","ICORES","SOCS","SAT",
                "TENCON","FSKD","GOR","ICPC","ICNC","PRICAI","CANDAR","SCAM","GreenCom","CSE","SoC","ANT","HM","SEA",
                "Canadian AI","CSCLP","LION","FGCS","EvoWorkshop","Conf AI","ICOA"
        };
        for(String cand:series) {
            if (text.contains(cand)) {
                return cand;
            }
        }
        if (text.contains("Doctoral Consortium") && text.contains("Symposium of the Italian Association for Artificial Intelligence")){
            return "DC SIAAI";
        }
        if (text.contains("Symposium of the Italian Association for Artificial Intelligence")){
            return "SIAAI";
        }
        if (text.contains("Logic Programming") && text.contains("Symposium")) {
            return "ILPS";
        }
        if (text.contains("International Conference on Robotics and Automation")){
            return "ICRA";
        }
        if (text.contains("National Conference on Artificial Intelligence")){
            return "AAAI";
        }
        if (text.contains("International Conference on Artificial Intelligence Planning Systems")){
            return "AIPS";
        }
        if (text.contains("European Conference on Artificial Intelligence")){
            return "ECAI";
        }
        if (text.contains("Principles of Knowledge Representation and Reasoning")){
            return "KR";
        }
        if (text.equals("Constraint Programming")){
            return "Constraint Programming";
        }
        if (text.contains("Operations Research Proceedings")){
            return "Operations Research Proceedings";
        }
        if (text.toLowerCase().contains("international joint conference on artificial intelligence")){
            return "IJCAI";
        }
        if (text.toLowerCase().contains("genetic and evolutionary computation")){
            return "GECCO";
        }
        if (text.contains("Australian Joint Conference on Artificial Intelligence")){
            return "Australian Joint Conference on Artificial Intelligence";
        }
        if (text.contains("Railway Operations Modelling and Analysis")){
            return "Railway Operations Modelling and Analysis";
        }
        return "unknown";
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

    private String familyName(String text) {
        String[] split = text.split(" ");
        if (split.length >= 2){
            return split[1];
        } else {
            return text;
        }
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
