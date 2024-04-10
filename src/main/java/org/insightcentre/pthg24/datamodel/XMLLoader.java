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
public WorkType getWorkType(String attributeName,
                               Attributes attributes) {
        String e = attributes.getValue(attributeName);
        if (e == null) {
            System.out.println("WorkType"+": "+attributeName);
            return null;
        } else {
            return WorkType.valueOf(e);
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

    public Book getBook(String attributeName,
                               Attributes attributes) {
        return (Book) find(getId(attributeName,attributes));
    }

    public List<Book> getBookCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<Book> res = new ArrayList<Book>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((Book) find(id));
            }
        }
        return res;
    }

    public Citation getCitation(String attributeName,
                               Attributes attributes) {
        return (Citation) find(getId(attributeName,attributes));
    }

    public List<Citation> getCitationCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<Citation> res = new ArrayList<Citation>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((Citation) find(id));
            }
        }
        return res;
    }

    public Coauthor getCoauthor(String attributeName,
                               Attributes attributes) {
        return (Coauthor) find(getId(attributeName,attributes));
    }

    public List<Coauthor> getCoauthorCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<Coauthor> res = new ArrayList<Coauthor>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((Coauthor) find(id));
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

    public ConferenceSeries getConferenceSeries(String attributeName,
                               Attributes attributes) {
        return (ConferenceSeries) find(getId(attributeName,attributes));
    }

    public List<ConferenceSeries> getConferenceSeriesCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<ConferenceSeries> res = new ArrayList<ConferenceSeries>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((ConferenceSeries) find(id));
            }
        }
        return res;
    }

    public InBook getInBook(String attributeName,
                               Attributes attributes) {
        return (InBook) find(getId(attributeName,attributes));
    }

    public List<InBook> getInBookCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<InBook> res = new ArrayList<InBook>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((InBook) find(id));
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

    public JournalAlias getJournalAlias(String attributeName,
                               Attributes attributes) {
        return (JournalAlias) find(getId(attributeName,attributes));
    }

    public List<JournalAlias> getJournalAliasCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<JournalAlias> res = new ArrayList<JournalAlias>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((JournalAlias) find(id));
            }
        }
        return res;
    }

    public MissingCitedWork getMissingCitedWork(String attributeName,
                               Attributes attributes) {
        return (MissingCitedWork) find(getId(attributeName,attributes));
    }

    public List<MissingCitedWork> getMissingCitedWorkCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<MissingCitedWork> res = new ArrayList<MissingCitedWork>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((MissingCitedWork) find(id));
            }
        }
        return res;
    }

    public MissingCitingWork getMissingCitingWork(String attributeName,
                               Attributes attributes) {
        return (MissingCitingWork) find(getId(attributeName,attributes));
    }

    public List<MissingCitingWork> getMissingCitingWorkCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<MissingCitingWork> res = new ArrayList<MissingCitingWork>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((MissingCitingWork) find(id));
            }
        }
        return res;
    }

    public MissingWork getMissingWork(String attributeName,
                               Attributes attributes) {
        return (MissingWork) find(getId(attributeName,attributes));
    }

    public List<MissingWork> getMissingWorkCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<MissingWork> res = new ArrayList<MissingWork>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((MissingWork) find(id));
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

    public Reference getReference(String attributeName,
                               Attributes attributes) {
        return (Reference) find(getId(attributeName,attributes));
    }

    public List<Reference> getReferenceCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<Reference> res = new ArrayList<Reference>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((Reference) find(id));
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

    public Similarity getSimilarity(String attributeName,
                               Attributes attributes) {
        return (Similarity) find(getId(attributeName,attributes));
    }

    public List<Similarity> getSimilarityCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<Similarity> res = new ArrayList<Similarity>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((Similarity) find(id));
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
                        getBoolean("background",attributes,false),
                        getString("classification",attributes,""),
                        getString("codeAvail",attributes,""),
                        getString("constraints",attributes,""),
                        getString("cpSystem",attributes,""),
                        getString("dataAvail",attributes,""),
                        getString("doi",attributes,""),
                        getString("key",attributes,""),
                        getString("localCopy",attributes,""),
                        getInteger("nrCitations",attributes,0),
                        getInteger("nrLinks",attributes,0),
                        getInteger("nrPages",attributes,0),
                        getInteger("nrReferences",attributes,0),
                        getString("pages",attributes,""),
                        getString("relatedTo",attributes,""),
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
                        getString("key",attributes,""),
                        getInteger("nrBackgroundCitations",attributes,0),
                        getInteger("nrBackgroundWorks",attributes,0),
                        getInteger("nrCitations",attributes,0),
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
            } else if (qname.equals("book")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new Book(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getString("author",attributes,""),
                        null,
                        getBoolean("background",attributes,false),
                        getString("classification",attributes,""),
                        getString("codeAvail",attributes,""),
                        getString("constraints",attributes,""),
                        getString("cpSystem",attributes,""),
                        getString("dataAvail",attributes,""),
                        getString("doi",attributes,""),
                        getString("key",attributes,""),
                        getString("localCopy",attributes,""),
                        getInteger("nrCitations",attributes,0),
                        getInteger("nrLinks",attributes,0),
                        getInteger("nrPages",attributes,0),
                        getInteger("nrReferences",attributes,0),
                        getString("pages",attributes,""),
                        getString("relatedTo",attributes,""),
                        getString("solutionAvail",attributes,""),
                        getString("title",attributes,""),
                        getString("url",attributes,""),
                        getInteger("year",attributes,0)
                        ));
            } else if (qname.equals("citation")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new Citation(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getString("authorSC",attributes,""),
                        getString("cited",attributes,""),
                        null,
                        getString("citing",attributes,""),
                        null,
                        getString("creation",attributes,""),
                        getString("journalSC",attributes,""),
                        getString("oci",attributes,""),
                        getString("timespan",attributes,"")
                        ));
            } else if (qname.equals("coauthor")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new Coauthor(base,
                        id,
                        getString("name", attributes, "dummy"),
                        null,
                        null,
                        getInteger("earliestYear",attributes,0),
                        getInteger("latestYear",attributes,0),
                        getInteger("nrCites",attributes,0),
                        getInteger("nrWorks",attributes,0)
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
                        getInteger("nrOccurrences",attributes,0),
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
            } else if (qname.equals("conferenceSeries")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new ConferenceSeries(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getInteger("nrBackgroundCitations",attributes,0),
                        getInteger("nrBackgroundPapers",attributes,0),
                        getInteger("nrCitations",attributes,0),
                        getInteger("nrPapers",attributes,0)
                        ));
            } else if (qname.equals("inBook")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new InBook(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getString("author",attributes,""),
                        null,
                        getBoolean("background",attributes,false),
                        getString("classification",attributes,""),
                        getString("codeAvail",attributes,""),
                        getString("constraints",attributes,""),
                        getString("cpSystem",attributes,""),
                        getString("dataAvail",attributes,""),
                        getString("doi",attributes,""),
                        getString("key",attributes,""),
                        getString("localCopy",attributes,""),
                        getInteger("nrCitations",attributes,0),
                        getInteger("nrLinks",attributes,0),
                        getInteger("nrPages",attributes,0),
                        getInteger("nrReferences",attributes,0),
                        getString("pages",attributes,""),
                        getString("relatedTo",attributes,""),
                        getString("solutionAvail",attributes,""),
                        getString("title",attributes,""),
                        getString("url",attributes,""),
                        getInteger("year",attributes,0),
                        getString("booktitle",attributes,"")
                        ));
            } else if (qname.equals("inCollection")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new InCollection(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getString("author",attributes,""),
                        null,
                        getBoolean("background",attributes,false),
                        getString("classification",attributes,""),
                        getString("codeAvail",attributes,""),
                        getString("constraints",attributes,""),
                        getString("cpSystem",attributes,""),
                        getString("dataAvail",attributes,""),
                        getString("doi",attributes,""),
                        getString("key",attributes,""),
                        getString("localCopy",attributes,""),
                        getInteger("nrCitations",attributes,0),
                        getInteger("nrLinks",attributes,0),
                        getInteger("nrPages",attributes,0),
                        getInteger("nrReferences",attributes,0),
                        getString("pages",attributes,""),
                        getString("relatedTo",attributes,""),
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
                        getInteger("nrArticles",attributes,0),
                        getInteger("nrBackgroundArticles",attributes,0),
                        getInteger("nrBackgroundCitations",attributes,0),
                        getInteger("nrCitations",attributes,0),
                        getString("shortName",attributes,"")
                        ));
            } else if (qname.equals("journalAlias")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new JournalAlias(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getString("alias",attributes,""),
                        null
                        ));
            } else if (qname.equals("missingCitedWork")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new MissingCitedWork(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getString("doi",attributes,""),
                        getInteger("nrCitations",attributes,0)
                        ));
            } else if (qname.equals("missingCitingWork")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new MissingCitingWork(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getString("doi",attributes,""),
                        getInteger("nrCited",attributes,0)
                        ));
            } else if (qname.equals("missingWork")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new MissingWork(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getString("doi",attributes,""),
                        getInteger("nrCitations",attributes,0),
                        getInteger("nrCited",attributes,0),
                        getInteger("nrLinks",attributes,0)
                        ));
            } else if (qname.equals("paper")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new Paper(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getString("author",attributes,""),
                        null,
                        getBoolean("background",attributes,false),
                        getString("classification",attributes,""),
                        getString("codeAvail",attributes,""),
                        getString("constraints",attributes,""),
                        getString("cpSystem",attributes,""),
                        getString("dataAvail",attributes,""),
                        getString("doi",attributes,""),
                        getString("key",attributes,""),
                        getString("localCopy",attributes,""),
                        getInteger("nrCitations",attributes,0),
                        getInteger("nrLinks",attributes,0),
                        getInteger("nrPages",attributes,0),
                        getInteger("nrReferences",attributes,0),
                        getString("pages",attributes,""),
                        getString("relatedTo",attributes,""),
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
                        getBoolean("background",attributes,false),
                        getString("classification",attributes,""),
                        getString("codeAvail",attributes,""),
                        getString("constraints",attributes,""),
                        getString("cpSystem",attributes,""),
                        getString("dataAvail",attributes,""),
                        getString("doi",attributes,""),
                        getString("key",attributes,""),
                        getString("localCopy",attributes,""),
                        getInteger("nrCitations",attributes,0),
                        getInteger("nrLinks",attributes,0),
                        getInteger("nrPages",attributes,0),
                        getInteger("nrReferences",attributes,0),
                        getString("pages",attributes,""),
                        getString("relatedTo",attributes,""),
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
                        null,
                        getString("shortName",attributes,"")
                        ));
            } else if (qname.equals("reference")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new Reference(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getString("authorSC",attributes,""),
                        getString("cited",attributes,""),
                        null,
                        getString("citing",attributes,""),
                        null,
                        getString("creation",attributes,""),
                        getString("journalSC",attributes,""),
                        getString("oci",attributes,""),
                        getString("timespan",attributes,"")
                        ));
            } else if (qname.equals("school")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new School(base,
                        id,
                        getString("name", attributes, "dummy")
                        ));
            } else if (qname.equals("similarity")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new Similarity(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getInteger("cite1",attributes,0),
                        getInteger("cite2",attributes,0),
                        getInteger("nrSharedCitations",attributes,0),
                        getInteger("nrSharedReferences",attributes,0),
                        getInteger("ref1",attributes,0),
                        getInteger("ref2",attributes,0),
                        getDouble("similarity",attributes,0.0),
                        getDouble("similarityCite",attributes,0.0),
                        getDouble("similarityConcept",attributes,0.0),
                        getDouble("similarityRef",attributes,0.0),
                        null,
                        null
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
            } else if (qname.equals("book")) {
                assert (base != null);
                int id = getId("id", attributes);
                Book item = (Book) find(id);
                 item.setAuthors(getAuthorCollectionFromIds("authors",attributes));
            } else if (qname.equals("citation")) {
                assert (base != null);
                int id = getId("id", attributes);
                Citation item = (Citation) find(id);
                 item.setCitedWork(getWork("citedWork",attributes));
                 item.setCitingWork(getWork("citingWork",attributes));
            } else if (qname.equals("coauthor")) {
                assert (base != null);
                int id = getId("id", attributes);
                Coauthor item = (Coauthor) find(id);
                 item.setAuthor1(getAuthor("author1",attributes));
                 item.setAuthor2(getAuthor("author2",attributes));
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
            } else if (qname.equals("conferenceSeries")) {
                assert (base != null);
                int id = getId("id", attributes);
                ConferenceSeries item = (ConferenceSeries) find(id);
            } else if (qname.equals("inBook")) {
                assert (base != null);
                int id = getId("id", attributes);
                InBook item = (InBook) find(id);
                 item.setAuthors(getAuthorCollectionFromIds("authors",attributes));
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
            } else if (qname.equals("journalAlias")) {
                assert (base != null);
                int id = getId("id", attributes);
                JournalAlias item = (JournalAlias) find(id);
                 item.setJournal(getJournal("journal",attributes));
            } else if (qname.equals("missingCitedWork")) {
                assert (base != null);
                int id = getId("id", attributes);
                MissingCitedWork item = (MissingCitedWork) find(id);
            } else if (qname.equals("missingCitingWork")) {
                assert (base != null);
                int id = getId("id", attributes);
                MissingCitingWork item = (MissingCitingWork) find(id);
            } else if (qname.equals("missingWork")) {
                assert (base != null);
                int id = getId("id", attributes);
                MissingWork item = (MissingWork) find(id);
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
                 item.setConferenceSeries(getConferenceSeries("conferenceSeries",attributes));
            } else if (qname.equals("reference")) {
                assert (base != null);
                int id = getId("id", attributes);
                Reference item = (Reference) find(id);
                 item.setCitedWork(getWork("citedWork",attributes));
                 item.setCitingWork(getWork("citingWork",attributes));
            } else if (qname.equals("school")) {
                assert (base != null);
                int id = getId("id", attributes);
                School item = (School) find(id);
            } else if (qname.equals("similarity")) {
                assert (base != null);
                int id = getId("id", attributes);
                Similarity item = (Similarity) find(id);
                 item.setWork1(getWork("work1",attributes));
                 item.setWork2(getWork("work2",attributes));
            } else {
                System.out.println("Element Structure " + qname);
                numNodes++;
            }
        }
    }


}
