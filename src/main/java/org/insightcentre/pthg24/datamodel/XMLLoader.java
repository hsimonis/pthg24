package org.insightcentre.pthg24.datamodel;

import framework.AbstractXMLLoader;
import framework.ApplicationDatasetInterface;
import framework.ApplicationObjectInterface;
import framework.gui.StatusException;
import framework.types.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.*;

public class XMLLoader extends AbstractXMLLoader {
    Scenario base = null;

    public XMLLoader() {
    }
    public ApplicationDatasetInterface loadXML(File filename) {
        try {
            SAXParserFactory configFactory = SAXParserFactory.newInstance();
            SAXParser configParser = configFactory.newSAXParser();
            ConfigHandler configHandler = new ConfigHandler();
            Phase2Handler phase2Handler = new Phase2Handler();
            configParser.parse(filename, configHandler);
            configParser.parse(filename, phase2Handler);
            base = configHandler.getScenario();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        base.setIdNr(base.lastIdNr()+1);
        return base;
    }

public DifferenceType getDifferenceType(String attributeName,
                               Attributes attributes) {
        String e = attributes.getValue(attributeName);
        if (e == null) {
            System.out.println("DifferenceType"+": "+attributeName);
            return null;
        } else {
            return DifferenceType.valueOf(e);
        }
    }
public WarningType getWarningType(String attributeName,
                               Attributes attributes) {
        String e = attributes.getValue(attributeName);
        if (e == null) {
            System.out.println("WarningType"+": "+attributeName);
            return null;
        } else {
            return WarningType.valueOf(e);
        }
    }
public MatchLevel getMatchLevel(String attributeName,
                               Attributes attributes) {
        String e = attributes.getValue(attributeName);
        if (e == null) {
            System.out.println("MatchLevel"+": "+attributeName);
            return null;
        } else {
            return MatchLevel.valueOf(e);
        }
    }
public ConceptType getConceptType(String attributeName,
                               Attributes attributes) {
        String e = attributes.getValue(attributeName);
        if (e == null) {
            System.out.println("ConceptType"+": "+attributeName);
            return null;
        } else {
            return ConceptType.valueOf(e);
        }
    }
    public ApplicationDataset getApplicationDataset(String attributeName,
                               Attributes attributes) {
        return (ApplicationDataset) find(getId(attributeName,attributes));
    }

    public List<ApplicationDataset> getApplicationDatasetCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<ApplicationDataset> res = new ArrayList<ApplicationDataset>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((ApplicationDataset) find(id));
            }
        }
        return res;
    }

    public ApplicationDifference getApplicationDifference(String attributeName,
                               Attributes attributes) {
        return (ApplicationDifference) find(getId(attributeName,attributes));
    }

    public List<ApplicationDifference> getApplicationDifferenceCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<ApplicationDifference> res = new ArrayList<ApplicationDifference>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((ApplicationDifference) find(id));
            }
        }
        return res;
    }

    public ApplicationObject getApplicationObject(String attributeName,
                               Attributes attributes) {
        return (ApplicationObject) find(getId(attributeName,attributes));
    }

    public List<ApplicationObject> getApplicationObjectCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<ApplicationObject> res = new ArrayList<ApplicationObject>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((ApplicationObject) find(id));
            }
        }
        return res;
    }

    public ApplicationWarning getApplicationWarning(String attributeName,
                               Attributes attributes) {
        return (ApplicationWarning) find(getId(attributeName,attributes));
    }

    public List<ApplicationWarning> getApplicationWarningCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<ApplicationWarning> res = new ArrayList<ApplicationWarning>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((ApplicationWarning) find(id));
            }
        }
        return res;
    }

    public Article getArticle(String attributeName,
                               Attributes attributes) {
        return (Article) find(getId(attributeName,attributes));
    }

    public List<Article> getArticleCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<Article> res = new ArrayList<Article>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((Article) find(id));
            }
        }
        return res;
    }

    public Author getAuthor(String attributeName,
                               Attributes attributes) {
        return (Author) find(getId(attributeName,attributes));
    }

    public List<Author> getAuthorCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<Author> res = new ArrayList<Author>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((Author) find(id));
            }
        }
        return res;
    }

    public Authorship getAuthorship(String attributeName,
                               Attributes attributes) {
        return (Authorship) find(getId(attributeName,attributes));
    }

    public List<Authorship> getAuthorshipCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<Authorship> res = new ArrayList<Authorship>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((Authorship) find(id));
            }
        }
        return res;
    }

    public Collection getCollection(String attributeName,
                               Attributes attributes) {
        return (Collection) find(getId(attributeName,attributes));
    }

    public List<Collection> getCollectionCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<Collection> res = new ArrayList<Collection>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((Collection) find(id));
            }
        }
        return res;
    }

    public Concept getConcept(String attributeName,
                               Attributes attributes) {
        return (Concept) find(getId(attributeName,attributes));
    }

    public List<Concept> getConceptCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<Concept> res = new ArrayList<Concept>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((Concept) find(id));
            }
        }
        return res;
    }

    public ConceptWork getConceptWork(String attributeName,
                               Attributes attributes) {
        return (ConceptWork) find(getId(attributeName,attributes));
    }

    public List<ConceptWork> getConceptWorkCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<ConceptWork> res = new ArrayList<ConceptWork>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((ConceptWork) find(id));
            }
        }
        return res;
    }

    public InCollection getInCollection(String attributeName,
                               Attributes attributes) {
        return (InCollection) find(getId(attributeName,attributes));
    }

    public List<InCollection> getInCollectionCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<InCollection> res = new ArrayList<InCollection>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((InCollection) find(id));
            }
        }
        return res;
    }

    public Journal getJournal(String attributeName,
                               Attributes attributes) {
        return (Journal) find(getId(attributeName,attributes));
    }

    public List<Journal> getJournalCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<Journal> res = new ArrayList<Journal>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((Journal) find(id));
            }
        }
        return res;
    }

    public Paper getPaper(String attributeName,
                               Attributes attributes) {
        return (Paper) find(getId(attributeName,attributes));
    }

    public List<Paper> getPaperCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<Paper> res = new ArrayList<Paper>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((Paper) find(id));
            }
        }
        return res;
    }

    public PhDThesis getPhDThesis(String attributeName,
                               Attributes attributes) {
        return (PhDThesis) find(getId(attributeName,attributes));
    }

    public List<PhDThesis> getPhDThesisCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<PhDThesis> res = new ArrayList<PhDThesis>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((PhDThesis) find(id));
            }
        }
        return res;
    }

    public Proceedings getProceedings(String attributeName,
                               Attributes attributes) {
        return (Proceedings) find(getId(attributeName,attributes));
    }

    public List<Proceedings> getProceedingsCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<Proceedings> res = new ArrayList<Proceedings>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((Proceedings) find(id));
            }
        }
        return res;
    }

    public Scenario getScenario(String attributeName,
                               Attributes attributes) {
        return (Scenario) find(getId(attributeName,attributes));
    }

    public List<Scenario> getScenarioCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<Scenario> res = new ArrayList<Scenario>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((Scenario) find(id));
            }
        }
        return res;
    }

    public School getSchool(String attributeName,
                               Attributes attributes) {
        return (School) find(getId(attributeName,attributes));
    }

    public List<School> getSchoolCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<School> res = new ArrayList<School>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((School) find(id));
            }
        }
        return res;
    }

    public Work getWork(String attributeName,
                               Attributes attributes) {
        return (Work) find(getId(attributeName,attributes));
    }

    public List<Work> getWorkCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<Work> res = new ArrayList<Work>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((Work) find(id));
            }
        }
        return res;
    }

    private class ConfigHandler extends DefaultHandler {
        private int numNodes = 0;
        public Scenario getScenario() {
            return base;
        }

        public void startDocument() {
            System.out.println("Reading XML Document, Pass 1");
        }

        public void endDocument() {
            System.out.println("Pass 1 complete");
        }

        public void processingInstruction(String target, String data) {
            System.out.println("AssignableProcess target" + target + " data " + data);
        }
        public void startElement(String uri,
                                 String localname, String qname,
                                 Attributes attributes) {
            if (qname.equals("body")) {
            } else if (qname.equals("scenario")) {
                base = new Scenario(false,
                        getId("id", attributes),
                        getString("name", attributes, "dummy"),
                        getBoolean("valid",attributes,false)
                              );
            } else if (qname.equals("applicationDifference")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new ApplicationDifference(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getString("item",attributes,""),
                        null
                        ));
            } else if (qname.equals("applicationWarning")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new ApplicationWarning(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getString("attrString",attributes,""),
                        getString("classString",attributes,""),
                        getString("item",attributes,""),
                        getString("limit",attributes,""),
                        null
                        ));
            } else if (qname.equals("article")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new Article(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getString("author",attributes,""),
                        null,
                        getString("basedOn",attributes,""),
                        getString("citations",attributes,""),
                        getString("classification",attributes,""),
                        getString("codeAvail",attributes,""),
                        getString("constraints",attributes,""),
                        getString("cpSystem",attributes,""),
                        getString("dataAvail",attributes,""),
                        getString("doi",attributes,""),
                        getString("key",attributes,""),
                        getString("localCopy",attributes,""),
                        getInteger("nrLinks",attributes,0),
                        getInteger("nrPages",attributes,0),
                        getString("pages",attributes,""),
                        getString("solutionAvail",attributes,""),
                        getString("title",attributes,""),
                        getString("url",attributes,""),
                        getInteger("year",attributes,0),
                        null
                        ));
            } else if (qname.equals("author")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new Author(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getString("familyName",attributes,""),
                        getInteger("nrWorks",attributes,0),
                        getString("shortName",attributes,"")
                        ));
            } else if (qname.equals("authorship")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new Authorship(base,
                        id,
                        getString("name", attributes, "dummy"),
                        null,
                        null
                        ));
            } else if (qname.equals("collection")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new Collection(base,
                        id,
                        getString("name", attributes, "dummy")
                        ));
            } else if (qname.equals("concept")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new Concept(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getBoolean("caseSensitive",attributes,false),
                        null,
                        getString("label",attributes,""),
                        getString("regExpr",attributes,""),
                        getInteger("revision",attributes,0)
                        ));
            } else if (qname.equals("conceptWork")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new ConceptWork(base,
                        id,
                        getString("name", attributes, "dummy"),
                        null,
                        getInteger("count",attributes,0),
                        null,
                        null
                        ));
            } else if (qname.equals("inCollection")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new InCollection(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getString("author",attributes,""),
                        null,
                        getString("basedOn",attributes,""),
                        getString("citations",attributes,""),
                        getString("classification",attributes,""),
                        getString("codeAvail",attributes,""),
                        getString("constraints",attributes,""),
                        getString("cpSystem",attributes,""),
                        getString("dataAvail",attributes,""),
                        getString("doi",attributes,""),
                        getString("key",attributes,""),
                        getString("localCopy",attributes,""),
                        getInteger("nrLinks",attributes,0),
                        getInteger("nrPages",attributes,0),
                        getString("pages",attributes,""),
                        getString("solutionAvail",attributes,""),
                        getString("title",attributes,""),
                        getString("url",attributes,""),
                        getInteger("year",attributes,0),
                        null
                        ));
            } else if (qname.equals("journal")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new Journal(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getString("shortName",attributes,"")
                        ));
            } else if (qname.equals("paper")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new Paper(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getString("author",attributes,""),
                        null,
                        getString("basedOn",attributes,""),
                        getString("citations",attributes,""),
                        getString("classification",attributes,""),
                        getString("codeAvail",attributes,""),
                        getString("constraints",attributes,""),
                        getString("cpSystem",attributes,""),
                        getString("dataAvail",attributes,""),
                        getString("doi",attributes,""),
                        getString("key",attributes,""),
                        getString("localCopy",attributes,""),
                        getInteger("nrLinks",attributes,0),
                        getInteger("nrPages",attributes,0),
                        getString("pages",attributes,""),
                        getString("solutionAvail",attributes,""),
                        getString("title",attributes,""),
                        getString("url",attributes,""),
                        getInteger("year",attributes,0),
                        null
                        ));
            } else if (qname.equals("phDThesis")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new PhDThesis(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getString("author",attributes,""),
                        null,
                        getString("basedOn",attributes,""),
                        getString("citations",attributes,""),
                        getString("classification",attributes,""),
                        getString("codeAvail",attributes,""),
                        getString("constraints",attributes,""),
                        getString("cpSystem",attributes,""),
                        getString("dataAvail",attributes,""),
                        getString("doi",attributes,""),
                        getString("key",attributes,""),
                        getString("localCopy",attributes,""),
                        getInteger("nrLinks",attributes,0),
                        getInteger("nrPages",attributes,0),
                        getString("pages",attributes,""),
                        getString("solutionAvail",attributes,""),
                        getString("title",attributes,""),
                        getString("url",attributes,""),
                        getInteger("year",attributes,0),
                        null
                        ));
            } else if (qname.equals("proceedings")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new Proceedings(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getString("series",attributes,""),
                        getString("shortName",attributes,"")
                        ));
            } else if (qname.equals("school")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new School(base,
                        id,
                        getString("name", attributes, "dummy")
                        ));
            } else {
                System.out.println("Element Structure " + qname);
                numNodes++;
            }
        }
    }
    private class Phase2Handler extends DefaultHandler {
        private int numNodes = 0;
        public Scenario getScenario() {
            return base;
        }

        public void startDocument() {
            System.out.println("Reading XML Document, Pass 2");
        }

        public void endDocument() {
            System.out.println("Pass 2 complete");
        }

        public void processingInstruction(String target, String data) {
            System.out.println("AssignableProcess target" + target + " data " + data);
        }
        public void startElement(String uri,
                                 String localname, String qname,
                                 Attributes attributes) {
            if (qname.equals("body")) {
            } else if (qname.equals("scenario")) {
                assert (base != null);
                int id = getId("id", attributes);
                Scenario item = (Scenario) base;
            } else if (qname.equals("applicationDifference")) {
                assert (base != null);
                int id = getId("id", attributes);
                ApplicationDifference item = (ApplicationDifference) find(id);
                 item.setType(getDifferenceType("type",attributes));
            } else if (qname.equals("applicationWarning")) {
                assert (base != null);
                int id = getId("id", attributes);
                ApplicationWarning item = (ApplicationWarning) find(id);
                 item.setType(getWarningType("type",attributes));
            } else if (qname.equals("article")) {
                assert (base != null);
                int id = getId("id", attributes);
                Article item = (Article) find(id);
                 item.setAuthors(getAuthorCollectionFromIds("authors",attributes));
                 item.setJournal(getJournal("journal",attributes));
            } else if (qname.equals("author")) {
                assert (base != null);
                int id = getId("id", attributes);
                Author item = (Author) find(id);
            } else if (qname.equals("authorship")) {
                assert (base != null);
                int id = getId("id", attributes);
                Authorship item = (Authorship) find(id);
                 item.setAuthor(getAuthor("author",attributes));
                 item.setWork(getWork("work",attributes));
            } else if (qname.equals("collection")) {
                assert (base != null);
                int id = getId("id", attributes);
                Collection item = (Collection) find(id);
            } else if (qname.equals("concept")) {
                assert (base != null);
                int id = getId("id", attributes);
                Concept item = (Concept) find(id);
                 item.setConceptType(getConceptType("conceptType",attributes));
            } else if (qname.equals("conceptWork")) {
                assert (base != null);
                int id = getId("id", attributes);
                ConceptWork item = (ConceptWork) find(id);
                 item.setConcept(getConcept("concept",attributes));
                 item.setMatchLevel(getMatchLevel("matchLevel",attributes));
                 item.setWork(getWork("work",attributes));
            } else if (qname.equals("inCollection")) {
                assert (base != null);
                int id = getId("id", attributes);
                InCollection item = (InCollection) find(id);
                 item.setAuthors(getAuthorCollectionFromIds("authors",attributes));
                 item.setCollection(getCollection("collection",attributes));
            } else if (qname.equals("journal")) {
                assert (base != null);
                int id = getId("id", attributes);
                Journal item = (Journal) find(id);
            } else if (qname.equals("paper")) {
                assert (base != null);
                int id = getId("id", attributes);
                Paper item = (Paper) find(id);
                 item.setAuthors(getAuthorCollectionFromIds("authors",attributes));
                 item.setProceedings(getProceedings("proceedings",attributes));
            } else if (qname.equals("phDThesis")) {
                assert (base != null);
                int id = getId("id", attributes);
                PhDThesis item = (PhDThesis) find(id);
                 item.setAuthors(getAuthorCollectionFromIds("authors",attributes));
                 item.setSchool(getSchool("school",attributes));
            } else if (qname.equals("proceedings")) {
                assert (base != null);
                int id = getId("id", attributes);
                Proceedings item = (Proceedings) find(id);
            } else if (qname.equals("school")) {
                assert (base != null);
                int id = getId("id", attributes);
                School item = (School) find(id);
            } else {
                System.out.println("Element Structure " + qname);
                numNodes++;
            }
        }
    }


}
