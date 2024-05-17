package org.insightcentre.pthg24.imports;

import org.apache.commons.lang3.StringUtils;
import org.insightcentre.pthg24.datamodel.Collection;
import org.insightcentre.pthg24.datamodel.*;
import org.jbibtex.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.insightcentre.pthg24.analysis.ExtractSelectedBib.keySafe;
import static org.insightcentre.pthg24.imports.ImportCrossref.properDOI;
import static org.insightcentre.pthg24.imports.LookupMissingWork.removeMarkup;
import static org.insightcentre.pthg24.logging.LogShortcut.*;
import static org.jbibtex.BibTeXEntry.*;

public class ImportOther {
    Scenario base;
    int workNr = 0;
    public ImportOther(Scenario base, String importDir, String fileName){
        this.base = base;
        assert(importDir.endsWith("/"));
        if (fileName.equals("")){
            return;
        }
        String fullName = importDir+fileName;
        try{
            info("Reading otherbib "+fileName);
            Reader reader = new FileReader(fullName);
            //??? I do not know if the following would help, it does not seem to be required with DBLP entries
//            CharacterFilterReader filterReader = new CharacterFilterReader(reader);

            BibTeXParser bibtexParser = new BibTeXParser();
            Key orcidNumbers = new Key("ORCID-Numbers");
            Key uniqueId = new Key("Unique-ID");
            Key issue = new Key("issue");
            Key abstractKey = new Key("abstract");
            Key keywordsKey = new Key("Keywords");

            BibTeXDatabase database = bibtexParser.parse(reader);
            reader.close();
            Map<Key, BibTeXEntry> entryMap = database.getEntries();

            for(BibTeXEntry entry : entryMap.values()){
                Key workKey = entry.getKey();
                Key type = entry.getType();
                OtherWork work= new OtherWork(base);
                work.setName(workKey.toString());
                work.setShortName(workKey.toString());
                switch (type.toString().toLowerCase()) {
                    case "article" -> {
                        work.setWorkType(WorkType.ARTICLE);
                        work.setSource(fieldString(entry, KEY_JOURNAL));
                    }
                    case "inproceedings" -> {
                        work.setWorkType(WorkType.PAPER);
                        work.setSource(fieldString(entry, KEY_BOOKTITLE));
                    }
                    case "incollection" -> {
                        work.setWorkType(WorkType.INCOLLECTION);
                        work.setSource(fieldString(entry, KEY_BOOKTITLE));
                    }
                    case "inbook" -> {
                        work.setWorkType(WorkType.INBOOK);
                        work.setSource(fieldString(entry, KEY_BOOKTITLE));
                    }
                    case "phdthesis" -> {
                        work.setWorkType(WorkType.THESIS);
                        work.setSource(fieldString(entry, KEY_SCHOOL));
                    }
                    case "book" -> {
                        work.setWorkType(WorkType.BOOK);
                        work.setSource(fieldString(entry, KEY_PUBLISHER));
                    }
                    default -> warning("Work type " + type + " for entry " + workKey.toString() + " not implemented");
                }
                work.setNr(workNr++);
                work.setTitle(fieldString(entry,KEY_TITLE).replaceAll("<\\w*>","").replaceAll("</\\w*>",""));
                work.setAuthor(fieldString(entry,KEY_AUTHOR));
                work.setEditor(fieldString(entry,KEY_EDITOR));
                work.setVolume(fieldString(entry,KEY_VOLUME));
                work.setIssue(fieldString(entry,issue));
                work.setPage(fieldString(entry,KEY_PAGES));
                work.setChapter(fieldString(entry,KEY_CHAPTER));
                work.setPublisher(fieldString(entry,KEY_PUBLISHER));
                work.setAuthors(splitAuthors(work.getAuthor()));
                work.setYear(fieldInteger(entry,KEY_YEAR));
                work.setKey(makeKey(work,work.getYear()));
                work.setDoi(properDOI(fieldString(entry,KEY_DOI)));
                work.setUrl(fieldString(entry,KEY_URL));
                if ((work.getUrl() == null || work.getUrl().equals("")) && work.getDoi() != null && !work.getDoi().equals("")){
                    work.setUrl(constructUrl(work.getDoi()));
                }
                if (!fieldString(entry,abstractKey).equals("")){
                    work.setAbstractText(removeMarkup(fieldString(entry,abstractKey)));
                }
                if (!fieldString(entry,keywordsKey).equals("")){
                    work.setKeywords(fieldString(entry,keywordsKey));
                }
                work.setWorkCount(work.getAuthors().stream().mapToInt(Author::getNrWorks).sum());
            }
        } catch(IOException e){
            severe("Cannot read file "+fullName+", exception "+e.getMessage());
        } catch(ParseException e){
            severe("Parsing error "+e.getMessage());
        }
    }

    private String makeKey(OtherWork ow,int year){
        if (ow.getAuthors() != null && ow.getAuthors().size() >= 1) {
            String firstAuthor = ow.getAuthors().get(0).getFamilyName();
            return keySafe(firstAuthor) + year;
        } else {
            return "unknown"+year;
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

    private List<Author> splitAuthors(String authors){
        List<Author> res = new ArrayList<>();
        String[] split = authors.split(" and ");
        int i=0;
        for (String s : split) {
            s = s.trim();
            if(!s.equals("")) {
                Author author = findAuthor(s);
                res.add(author);
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


}
