package org.insightcentre.pthg24.imports;

import org.apache.commons.lang3.StringUtils;
import org.insightcentre.pthg24.datamodel.*;
import org.insightcentre.pthg24.datamodel.Collection;
import org.jbibtex.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.insightcentre.pthg24.analysis.ListWorks.localCopyExists;
import static org.insightcentre.pthg24.imports.ImportCrossref.properDOI;
import static org.insightcentre.pthg24.imports.LookupMissingWork.removeMarkup;
import static org.insightcentre.pthg24.logging.LogShortcut.*;
import static org.jbibtex.BibTeXEntry.*;

public class ImportBib {
    Scenario base;
    int workNr = 0;
    public ImportBib(Scenario base, String importDir, String fileName,String worksDir){
        this.base = base;
        assert(importDir.endsWith("/"));
        String fullName = importDir+fileName;
        initAlias(base);
        Hashtable<String,Work> keyHash = new Hashtable<>();
        try{
            Reader reader = new FileReader(fullName);
            //??? I do not know if the following would help, it does not seem to be required with DBLP entries
//            CharacterFilterReader filterReader = new CharacterFilterReader(reader);

            BibTeXParser bibtexParser = new BibTeXParser();
            Key timesCited = new Key("Times-Cited");
            Key numberOfCitedReferences = new Key("Number-of-Cited-References");
            Key issn = new Key("ISSN");
            Key journalISO = new Key("Journal-ISO");
            Key orcidNumbers = new Key("ORCID-Numbers");
            Key uniqueId = new Key("Unique-ID");
            Key abstractKey = new Key("abstract");

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
                        art.setShortName(workKey.toString());
                        art.setKey(shortKey(workKey.toString()));
                        art.setIssn(fieldString(entry,issn));
                        art.setJournal(findJournal(fieldString(entry,KEY_JOURNAL),fieldString(entry,journalISO),fieldString(entry,issn)));
                        art.setLocalCopy(worksDir+art.getKey()+".pdf");
                        work = art;
                        break;
                    case "inproceedings":
                        Paper pap = new Paper(base);
                        pap.setName(workKey.toString());
                        pap.setShortName(workKey.toString());
                        pap.setKey(shortKey(workKey.toString()));
                        pap.setProceedings(findProceedings(fieldString(entry,KEY_BOOKTITLE),fieldInteger(entry,KEY_YEAR)));
                        pap.setLocalCopy(worksDir+pap.getKey()+".pdf");
                        work=pap;
                        break;
                    case "incollection":
                        InCollection inc = new InCollection(base);
                        inc.setName(workKey.toString());
                        inc.setShortName(workKey.toString());
                        inc.setKey(shortKey(workKey.toString()));
                        inc.setCollection(findCollection(fieldString(entry,KEY_BOOKTITLE)));
                        inc.setLocalCopy(worksDir+inc.getKey()+".pdf");
                        work=inc;
                        break;
                    case "inbook":
                        InBook inb = new InBook(base);
                        inb.setName(workKey.toString());
                        inb.setShortName(workKey.toString());
                        inb.setKey(shortKey(workKey.toString()));
                        inb.setBooktitle(fieldString(entry,KEY_BOOKTITLE));
                        inb.setLocalCopy(worksDir+inb.getKey()+".pdf");
                        work=inb;
                        break;
                    case "phdthesis":
                        PhDThesis phd = new PhDThesis(base);
                        phd.setName(workKey.toString());
                        phd.setShortName(workKey.toString());
                        phd.setKey(shortKey(workKey.toString()));
                        phd.setSchool(findSchool(fieldString(entry,KEY_SCHOOL)));
                        phd.setLocalCopy(worksDir+phd.getKey()+".pdf");
                        work=phd;
                        break;
                    case "book":
                        Book b = new Book(base);
                        b.setName(workKey.toString());
                        b.setShortName(workKey.toString());
                        b.setKey(shortKey(workKey.toString()));
                        work=b;
                        break;
                    default:
                       warning("Work type "+type+" for entry "+workKey.toString()+" not implemented");
                }
                if (work != null){
                    work.setNr(workNr++);
                    work.setTitle(fieldString(entry,KEY_TITLE).replaceAll("<\\w*>","").replaceAll("</\\w*>",""));
                    work.setAuthor(fieldString(entry,KEY_AUTHOR));
                    work.setAuthors(splitAuthors(work.getAuthor(),work));
                    work.setYear(fieldInteger(entry,KEY_YEAR));
                    work.setPages(fieldString(entry,KEY_PAGES));
                    work.setNrPages(nrPages(work.getPages()));
                    work.setDoi(properDOI(fieldString(entry,KEY_DOI)));
                    work.setUrl(fieldString(entry,KEY_URL));
                    if ((work.getUrl() == null || work.getUrl().equals("")) && work.getDoi() != null && !work.getDoi().equals("")){
                        work.setUrl(constructUrl(work.getDoi()));
                    }
                    if (!localCopyExists(work)){
                        work.setLocalCopy("");
                    }
                    work.setWosReferences(fieldInteger(entry,numberOfCitedReferences));
                    work.setWosCitations(fieldInteger(entry,timesCited));
                    if (!fieldString(entry,orcidNumbers).equals("")){
                        matchOrcids(work.getAuthors(),entry.getField(orcidNumbers).toUserString());
                    }
                    if (!fieldString(entry,uniqueId).equals("")){
                        work.setWosStatus(true);
                    }
                    if (!fieldString(entry,abstractKey).equals("")){
                        work.setAbstractText(removeMarkup(fieldString(entry,abstractKey)));
                    }
                    Work previous = keyHash.get(work.getKey());
                    if (previous != null){
                        severe("Previous "+previous.getAuthor()+" "+previous.getTitle()+" "+previous.getYear()+" "+previous.getDoi());
                        severe("Current "+work.getAuthor()+" "+work.getTitle()+" "+work.getYear()+" "+work.getDoi());
                        severe("Duplicate Key "+work.getKey()+" Get this sorted!");
                        assert(false);
                    } else {
                        keyHash.put(work.getKey(),work);
                    }
                }
            }
        } catch(IOException e){
            severe("Cannot read file "+fullName+", exception "+e.getMessage());
        } catch(ParseException e){
            severe("Parsing error "+e.getMessage());
        }
    }

    private void matchOrcids(List<Author> authors,String text){
        for(Author a:authors){
//            info("author "+a.getName()+" "+a.getFamilyName()+" "+a.getOrcid());
        }
//        info("matching "+text);
        String[] split = text.split("\n");
        for(String line:split){
//            info("line "+line);
            String[] parts = line.split("/");
//            info("candidate "+parts[0]+" ORCID "+parts[1]);
            String[] pieces = parts[0].split(",");
            for(Author a:authors){
                if (a.getFamilyName().equals(pieces[0]) && a.getName().startsWith(pieces[1].trim()) && a.getOrcid().equals("")) {
                    a.setOrcid(parts[1]);
                    info("Set orcid " + a.getName() + " " + a.getOrcid());
                    break;
                } else if (a.getFamilyName().equals(pieces[0]) && a.getName().charAt(0) == pieces[1].trim().charAt(0) && a.getOrcid().equals("")){
                        a.setOrcid(parts[1]);
                        info("Likely orcid "+a.getName()+" "+pieces[0]+" "+pieces[1].trim()+" "+a.getOrcid());
                        break;
                } else if (a.getFamilyName().equals(pieces[0]) && a.getName().startsWith(pieces[1]) && !a.getOrcid().equals("")){
                    info("Check Equal "+a.getOrcid()+" "+parts[1]);
                    if(!a.getOrcid().equals(parts[1])) {
                        severe("mismatch "+a.getOrcid()+" "+parts[1]+" "+a.getOrcid().length()+" "+parts[1].length());
                        break;
                    }
                } else {
//                    warning("case "+a.getFamilyName()+" "+pieces[0]+" "+a.getOrcid()+" "+parts[1]+" "+a.getOrcid().length()+" "+parts[1].length());
                }
            }
        }
    }

    private String constructUrl(String doi){
//        info("ConstructUrl "+doi);
        return String.format("http://dx.doi.org/%s",properDOI(doi));
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
        int i=0;
        for (String s : split) {
            s = s.trim();
            if(!s.equals("")) {
                Author author = findAuthor(s);
                author.incNrWorks();
                Authorship ship = new Authorship(base);
                ship.setAuthor(author);
                ship.setWork(work);
                ship.setSeqNr(i++);
                ship.setAffiliation(new ArrayList<>());
                res.add(author);
            } else {
                warning("Empty author in "+authors+ " for work "+work.getKey());
            }
        }
        return res;
    }

    private String capitalizeAllCaps(String t){
        if (StringUtils.isAllUpperCase(t)) {
            return StringUtils.capitalize(t);
        }
        return t;
    }

    /*
    if name contains a comma, then it is lastName, firstName, result should be firstName+lastName
     */

    private int authorNr=0;
    private Author findAuthor(String name){
        name = name.trim();
        name = name.replace("{-}","-");
        String fullName = name;
        String firstName;
        String familyName=familyName(name);

        if (name.contains(",")){
            String[] split = name.split(",");
            if (split.length != 2) {
                severe("Name has too many commas "+name);
            }
            assert(split.length == 2);
            familyName=capitalizeAllCaps(split[0].trim());
            firstName=capitalizeAllCaps(split[1].trim());
            fullName = firstName+" "+familyName;
        } else if(StringUtils.isAllUpperCase(name)){
            String[] split = name.split(" ");
            for(int i=0;i<split.length;i++){
                split[i] = capitalizeAllCaps(split[i]);
            }
            fullName = String.join(" ",split);
        }
        Author res = Author.findByName(base,fullName);
        if (res==null){
            res = new Author(base);
            res.setName(fullName);
            res.setShortName(shortName(fullName));
            res.setFamilyName(familyName);
            res.setKey("a"+authorNr++);
        }
        return res;
    }

    /*
 this is a bit of a hack, we do not deal with more complex name pattern
 //???should extend this to handle multiple initials
 //???should extend this to deal with compound first names "Jean-Francois" is currently shortened to "J." not J.-F.
 fallback is to use the full name instead
  */
    private String shortName(String text){
        String[] split = text.split(" ");
        if (split.length==2){
            return shortForm(split[0])+" "+split[1];
        }
        if (split.length==3){
            return shortForm(split[0])+" "+shortForm(split[1])+" "+split[2];
        }
        if (split.length==4){
            return shortForm(split[0])+" "+shortForm(split[1])+" "+shortForm(split[2])+" "+split[3];
        }
        return text;
    }

    private String familyName(String text) {
        String[] split = text.split(" ");
        if (split.length >= 2){
            return split[split.length-1];
        } else {
            return text;
        }
    }

    private String shortForm(String name){
        if (name.contains("-")){
            String[] split = name.split("-");
            if (split.length==2) {
                return shortForm(split[0]) + "-" + shortForm(split[1]);
            } else {
                return name.charAt(0)+".";
            }
        }
        if (startsWithAZ(name)) {
            return name.charAt(0)+".";
        }
        return name;
    }

    //???We do not mess with names that start with latex special characters
    //We also do not deal with lower-case names
    private boolean startsWithAZ(String name){
        return name.matches("[A-Z].*");
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
            //??? the following is not a minus sign, but a dash
        } else if (pages.contains("–")){
            String[] split = pages.split("–");
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
//            warning("Pages format not handled "+text);
            return null;
        }
    }

    // hash names of issn of some journals;
    Hashtable<String,Journal> aliasHash = new Hashtable<>();

    private void initAlias(Scenario base){
        for(JournalAlias ja:base.getListJournalAlias()){
            aliasHash.put(ja.getAlias(),ja.getJournal());
            aliasHash.put(ja.getJournal().getName(),ja.getJournal());
            aliasHash.put(ja.getJournal().getIssn(),ja.getJournal());
        }
    }

    private Journal findJournal(String name,String nameISO,String issn){
        if (name == null){
            return null;
        }
        if (issn != null && !issn.equals("") && aliasHash.get(issn)!= null){
            return aliasHash.get(issn);
        }
        if (nameISO != null && !nameISO.equals("") && aliasHash.get(nameISO)!= null){
            return aliasHash.get(nameISO);
        }
        // get rid of xml ampersand entity in journal names
        name = name.replace("&amp;","\\&");
        if (aliasHash.get(name) != null){
            return aliasHash.get(name);
        }
        Journal res = Journal.findByName(base,name);
        if (res == null){
            res = new Journal(base);
            res.setName(name);
            res.setIssn(issn);
            if (issn!= null && !issn.equals("")){
                aliasHash.put(issn,res);
            }
            if (nameISO!= null && !nameISO.equals("")){
                aliasHash.put(nameISO,res);
            }
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
//            info("Conf "+name);
            res.setConferenceSeries(extractSeries(name));
            res.setShortName(res.getConferenceSeries().getName()+" "+year);
        }
        return res;
    }

    private ConferenceSeries extractSeries(String text) {
        String lower = text.toLowerCase();
        for (ConferenceSeries cs : base.getListConferenceSeries()) {
            if (!cs.getRegExpr().equals("")) {
                Pattern pattern = Pattern.compile(cs.getRegExpr());
                Matcher matcher = pattern.matcher(text);
                if (matcher.find()){
//                    info("series regex");
                    return cs;
                }
            }
        }
        for (ConferenceSeries cs : base.getListConferenceSeries().stream().sorted(Comparator.comparing(this::nameLength).reversed()).toList()) {
            if (text.contains("("+cs.getName()+")")) {
//                info("series ()");
                return cs;
            }
        }
        for (ConferenceSeries cs : base.getListConferenceSeries()) {
            if (!cs.getDescription().equals("") && lower.contains(cs.getDescription().toLowerCase())) {
//                info("series desc");
                return cs;
            }
        }
        for (ConferenceSeries cs : base.getListConferenceSeries().stream().sorted(Comparator.comparing(this::nameLength).reversed()).toList()) {
            if (text.contains(cs.getName())) {
                //??? possible mis-classification
//                info("series name");
                return cs;
            }
        }
        info("series unknown "+text);
        return ConferenceSeries.findOrCreate(base, "unknown");
    }

    private int nameLength(ConferenceSeries cs){
        return cs.getName().length();
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
