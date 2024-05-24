// licence details to be added
package org.insightcentre.pthg24.datamodel;
import org.insightcentre.pthg24.datamodel.ApplicationDataset;
import org.insightcentre.pthg24.datamodel.ApplicationObject;
import org.insightcentre.pthg24.datamodel.ApplicationDifference;
import org.insightcentre.pthg24.datamodel.ApplicationWarning;
import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.datamodel.ConceptType;
import org.insightcentre.pthg24.datamodel.Concept;
import org.insightcentre.pthg24.datamodel.Acronym;
import org.insightcentre.pthg24.datamodel.Author;
import org.insightcentre.pthg24.datamodel.Work;
import org.insightcentre.pthg24.datamodel.Paper;
import org.insightcentre.pthg24.datamodel.Article;
import org.insightcentre.pthg24.datamodel.PhDThesis;
import org.insightcentre.pthg24.datamodel.InCollection;
import org.insightcentre.pthg24.datamodel.InBook;
import org.insightcentre.pthg24.datamodel.Book;
import org.insightcentre.pthg24.datamodel.Authorship;
import org.insightcentre.pthg24.datamodel.Affiliation;
import org.insightcentre.pthg24.datamodel.Proceedings;
import org.insightcentre.pthg24.datamodel.ConferenceSeries;
import org.insightcentre.pthg24.datamodel.Journal;
import org.insightcentre.pthg24.datamodel.JournalAlias;
import org.insightcentre.pthg24.datamodel.School;
import org.insightcentre.pthg24.datamodel.Publisher;
import org.insightcentre.pthg24.datamodel.Collection;
import org.insightcentre.pthg24.datamodel.ConceptWork;
import org.insightcentre.pthg24.datamodel.Citation;
import org.insightcentre.pthg24.datamodel.Reference;
import org.insightcentre.pthg24.datamodel.MissingCitingWork;
import org.insightcentre.pthg24.datamodel.MissingCitedWork;
import org.insightcentre.pthg24.datamodel.MissingWork;
import org.insightcentre.pthg24.datamodel.Coauthor;
import org.insightcentre.pthg24.datamodel.Similarity;
import org.insightcentre.pthg24.datamodel.CrossReference;
import org.insightcentre.pthg24.datamodel.UncategorizedReference;
import org.insightcentre.pthg24.datamodel.DoiReference;
import org.insightcentre.pthg24.datamodel.MissingCross;
import org.insightcentre.pthg24.datamodel.SourceGroup;
import org.insightcentre.pthg24.datamodel.ReferenceFlow;
import org.insightcentre.pthg24.datamodel.ScopusAffiliation;
import org.insightcentre.pthg24.datamodel.WorkAffiliation;
import org.insightcentre.pthg24.datamodel.ScopusCity;
import org.insightcentre.pthg24.datamodel.ScopusCountry;
import org.insightcentre.pthg24.datamodel.Orphan;
import org.insightcentre.pthg24.datamodel.CollabWork;
import org.insightcentre.pthg24.datamodel.CollabCount;
import org.insightcentre.pthg24.datamodel.Translator;
import org.insightcentre.pthg24.datamodel.AuthorDouble;
import org.insightcentre.pthg24.datamodel.OtherWork;
import org.insightcentre.pthg24.datamodel.DifferenceType;
import org.insightcentre.pthg24.datamodel.WarningType;
import org.insightcentre.pthg24.datamodel.MatchLevel;
import org.insightcentre.pthg24.datamodel.WorkType;
import org.insightcentre.pthg24.datamodel.OpenAccessType;
import org.insightcentre.pthg24.datamodel.XMLLoader;
import java.util.*;
import java.io.*;
import framework.types.*;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import framework.ApplicationObjectInterface;
import framework.ApplicationDatasetInterface;
import framework.AppearInCollection;

/**
 * 
 * @author generated
*/

public  class MissingWork extends ApplicationObject{
/**
 *  
 *
*/

    public String abstractText;

/**
 *  
 *
*/

    public String author;

/**
 *  
 *
*/

    public String chapter;

/**
 *  
 *
*/

    public List<Concept> concept;

/**
 *  
 *
*/

    public Double conceptWeight;

/**
 *  
 *
*/

    public Integer crossrefCitations;

/**
 *  
 *
*/

    public Integer crossrefReferences;

/**
 *  
 *
*/

    public String doi;

/**
 *  
 *
*/

    public String editor;

/**
 *  
 *
*/

    public String encoded;

/**
 *  
 *
*/

    public Boolean isSelected;

    private transient BooleanProperty isSelectedWrapper;

/**
 *  
 *
*/

    public String issue;

/**
 *  
 *
*/

    public String key;

/**
 *  
 *
*/

    public String keywords;

/**
 *  
 *
*/

    public Integer knownAuthors;

/**
 *  
 *
*/

    public Integer nrCitations;

/**
 *  
 *
*/

    public Integer nrCited;

/**
 *  
 *
*/

    public Integer nrLinks;

/**
 *  
 *
*/

    public String page;

/**
 *  
 *
*/

    public String publisher;

/**
 *  
 *
*/

    public Double relevance;

/**
 *  
 *
*/

    public String source;

/**
 *  
 *
*/

    public String title;

/**
 *  
 *
*/

    public String type;

/**
 *  
 *
*/

    public String url;

/**
 *  
 *
*/

    public String volume;

/**
 *  
 *
*/

    public Integer year;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public MissingWork(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public MissingWork(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setAbstractText("");
        setAuthor("");
        setChapter("");
        setConcept(new ArrayList<Concept>());
        setConceptWeight(0.0);
        setCrossrefCitations(0);
        setCrossrefReferences(0);
        setDoi("");
        setEditor("");
        setEncoded("");
        setIsSelected(false);
        setIssue("");
        setKey("");
        setKeywords("");
        setKnownAuthors(0);
        setNrCitations(0);
        setNrCited(0);
        setNrLinks(0);
        setPage("");
        setPublisher("");
        setRelevance(0.0);
        setSource("");
        setTitle("");
        setType("");
        setUrl("");
        setVolume("");
        setYear(0);
        applicationDataset.addMissingWork(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public MissingWork(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            String abstractText,
            String author,
            String chapter,
            List<Concept> concept,
            Double conceptWeight,
            Integer crossrefCitations,
            Integer crossrefReferences,
            String doi,
            String editor,
            String encoded,
            Boolean isSelected,
            String issue,
            String key,
            String keywords,
            Integer knownAuthors,
            Integer nrCitations,
            Integer nrCited,
            Integer nrLinks,
            String page,
            String publisher,
            Double relevance,
            String source,
            String title,
            String type,
            String url,
            String volume,
            Integer year){
        super(applicationDataset,
            id,
            name);
        setAbstractText(abstractText);
        setAuthor(author);
        setChapter(chapter);
        setConcept(concept);
        setConceptWeight(conceptWeight);
        setCrossrefCitations(crossrefCitations);
        setCrossrefReferences(crossrefReferences);
        setDoi(doi);
        setEditor(editor);
        setEncoded(encoded);
        setIsSelected(isSelected);
        setIssue(issue);
        setKey(key);
        setKeywords(keywords);
        setKnownAuthors(knownAuthors);
        setNrCitations(nrCitations);
        setNrCited(nrCited);
        setNrLinks(nrLinks);
        setPage(page);
        setPublisher(publisher);
        setRelevance(relevance);
        setSource(source);
        setTitle(title);
        setType(type);
        setUrl(url);
        setVolume(volume);
        setYear(year);
        applicationDataset.addMissingWork(this);
    }

    public MissingWork(MissingWork other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.abstractText,
            other.author,
            other.chapter,
            other.concept,
            other.conceptWeight,
            other.crossrefCitations,
            other.crossrefReferences,
            other.doi,
            other.editor,
            other.encoded,
            other.isSelected,
            other.issue,
            other.key,
            other.keywords,
            other.knownAuthors,
            other.nrCitations,
            other.nrCited,
            other.nrLinks,
            other.page,
            other.publisher,
            other.relevance,
            other.source,
            other.title,
            other.type,
            other.url,
            other.volume,
            other.year);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        getApplicationDataset().cascadeCrossReferenceMissingWork(this);
        return getApplicationDataset().removeMissingWork(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute abstractText
 *
 * @return String
*/

    public String getAbstractText(){
        return this.abstractText;
    }

/**
 *  get attribute author
 *
 * @return String
*/

    public String getAuthor(){
        return this.author;
    }

/**
 *  get attribute chapter
 *
 * @return String
*/

    public String getChapter(){
        return this.chapter;
    }

/**
 *  get attribute concept
 *
 * @return List<Concept>
*/

    public List<Concept> getConcept(){
        return this.concept;
    }

/**
 *  get attribute conceptWeight
 *
 * @return Double
*/

    public Double getConceptWeight(){
        return this.conceptWeight;
    }

/**
 *  get attribute crossrefCitations
 *
 * @return Integer
*/

    public Integer getCrossrefCitations(){
        return this.crossrefCitations;
    }

/**
 *  get attribute crossrefReferences
 *
 * @return Integer
*/

    public Integer getCrossrefReferences(){
        return this.crossrefReferences;
    }

/**
 *  get attribute doi
 *
 * @return String
*/

    public String getDoi(){
        return this.doi;
    }

/**
 *  get attribute editor
 *
 * @return String
*/

    public String getEditor(){
        return this.editor;
    }

/**
 *  get attribute encoded
 *
 * @return String
*/

    public String getEncoded(){
        return this.encoded;
    }

/**
 *  get attribute isSelected
 *
 * @return Boolean
*/

    public Boolean getIsSelected(){
        return this.isSelected;
    }

    public BooleanProperty isSelectedWrapperProperty() {
        if (isSelectedWrapper == null) {
            isSelectedWrapper = new SimpleBooleanProperty();
        }
        isSelectedWrapper.set(isSelected);
        return isSelectedWrapper;
    }

/**
 *  get attribute issue
 *
 * @return String
*/

    public String getIssue(){
        return this.issue;
    }

/**
 *  get attribute key
 *
 * @return String
*/

    public String getKey(){
        return this.key;
    }

/**
 *  get attribute keywords
 *
 * @return String
*/

    public String getKeywords(){
        return this.keywords;
    }

/**
 *  get attribute knownAuthors
 *
 * @return Integer
*/

    public Integer getKnownAuthors(){
        return this.knownAuthors;
    }

/**
 *  get attribute nrCitations
 *
 * @return Integer
*/

    public Integer getNrCitations(){
        return this.nrCitations;
    }

/**
 *  get attribute nrCited
 *
 * @return Integer
*/

    public Integer getNrCited(){
        return this.nrCited;
    }

/**
 *  get attribute nrLinks
 *
 * @return Integer
*/

    public Integer getNrLinks(){
        return this.nrLinks;
    }

/**
 *  get attribute page
 *
 * @return String
*/

    public String getPage(){
        return this.page;
    }

/**
 *  get attribute publisher
 *
 * @return String
*/

    public String getPublisher(){
        return this.publisher;
    }

/**
 *  get attribute relevance
 *
 * @return Double
*/

    public Double getRelevance(){
        return this.relevance;
    }

/**
 *  get attribute source
 *
 * @return String
*/

    public String getSource(){
        return this.source;
    }

/**
 *  get attribute title
 *
 * @return String
*/

    public String getTitle(){
        return this.title;
    }

/**
 *  get attribute type
 *
 * @return String
*/

    public String getType(){
        return this.type;
    }

/**
 *  get attribute url
 *
 * @return String
*/

    public String getUrl(){
        return this.url;
    }

/**
 *  get attribute volume
 *
 * @return String
*/

    public String getVolume(){
        return this.volume;
    }

/**
 *  get attribute year
 *
 * @return Integer
*/

    public Integer getYear(){
        return this.year;
    }

/**
 *  set attribute abstractText, mark dataset as dirty, mark dataset as not valid
@param abstractText String
 *
*/

    public void setAbstractText(String abstractText){
        this.abstractText = abstractText;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute author, mark dataset as dirty, mark dataset as not valid
@param author String
 *
*/

    public void setAuthor(String author){
        this.author = author;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute chapter, mark dataset as dirty, mark dataset as not valid
@param chapter String
 *
*/

    public void setChapter(String chapter){
        this.chapter = chapter;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute concept, mark dataset as dirty, mark dataset as not valid
@param concept List<Concept>
 *
*/

    public void setConcept(List<Concept> concept){
        this.concept = concept;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute conceptWeight, mark dataset as dirty, mark dataset as not valid
@param conceptWeight Double
 *
*/

    public void setConceptWeight(Double conceptWeight){
        this.conceptWeight = conceptWeight;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute crossrefCitations, mark dataset as dirty, mark dataset as not valid
@param crossrefCitations Integer
 *
*/

    public void setCrossrefCitations(Integer crossrefCitations){
        this.crossrefCitations = crossrefCitations;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute crossrefReferences, mark dataset as dirty, mark dataset as not valid
@param crossrefReferences Integer
 *
*/

    public void setCrossrefReferences(Integer crossrefReferences){
        this.crossrefReferences = crossrefReferences;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute doi, mark dataset as dirty, mark dataset as not valid
@param doi String
 *
*/

    public void setDoi(String doi){
        this.doi = doi;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute editor, mark dataset as dirty, mark dataset as not valid
@param editor String
 *
*/

    public void setEditor(String editor){
        this.editor = editor;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute encoded, mark dataset as dirty, mark dataset as not valid
@param encoded String
 *
*/

    public void setEncoded(String encoded){
        this.encoded = encoded;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute isSelected, mark dataset as dirty, mark dataset as not valid
@param isSelected Boolean
 *
*/

    public void setIsSelected(Boolean isSelected){
        this.isSelected = isSelected;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute issue, mark dataset as dirty, mark dataset as not valid
@param issue String
 *
*/

    public void setIssue(String issue){
        this.issue = issue;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute key, mark dataset as dirty, mark dataset as not valid
@param key String
 *
*/

    public void setKey(String key){
        this.key = key;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute keywords, mark dataset as dirty, mark dataset as not valid
@param keywords String
 *
*/

    public void setKeywords(String keywords){
        this.keywords = keywords;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute knownAuthors, mark dataset as dirty, mark dataset as not valid
@param knownAuthors Integer
 *
*/

    public void setKnownAuthors(Integer knownAuthors){
        this.knownAuthors = knownAuthors;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute nrCitations, mark dataset as dirty, mark dataset as not valid
@param nrCitations Integer
 *
*/

    public void setNrCitations(Integer nrCitations){
        this.nrCitations = nrCitations;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute nrCited, mark dataset as dirty, mark dataset as not valid
@param nrCited Integer
 *
*/

    public void setNrCited(Integer nrCited){
        this.nrCited = nrCited;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute nrLinks, mark dataset as dirty, mark dataset as not valid
@param nrLinks Integer
 *
*/

    public void setNrLinks(Integer nrLinks){
        this.nrLinks = nrLinks;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute page, mark dataset as dirty, mark dataset as not valid
@param page String
 *
*/

    public void setPage(String page){
        this.page = page;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute publisher, mark dataset as dirty, mark dataset as not valid
@param publisher String
 *
*/

    public void setPublisher(String publisher){
        this.publisher = publisher;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute relevance, mark dataset as dirty, mark dataset as not valid
@param relevance Double
 *
*/

    public void setRelevance(Double relevance){
        this.relevance = relevance;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute source, mark dataset as dirty, mark dataset as not valid
@param source String
 *
*/

    public void setSource(String source){
        this.source = source;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute title, mark dataset as dirty, mark dataset as not valid
@param title String
 *
*/

    public void setTitle(String title){
        this.title = title;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute type, mark dataset as dirty, mark dataset as not valid
@param type String
 *
*/

    public void setType(String type){
        this.type = type;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute url, mark dataset as dirty, mark dataset as not valid
@param url String
 *
*/

    public void setUrl(String url){
        this.url = url;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute volume, mark dataset as dirty, mark dataset as not valid
@param volume String
 *
*/

    public void setVolume(String volume){
        this.volume = volume;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute year, mark dataset as dirty, mark dataset as not valid
@param year Integer
 *
*/

    public void setYear(Integer year){
        this.year = year;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute crossrefCitations, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incCrossrefCitations(){
        this.crossrefCitations++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute crossrefReferences, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incCrossrefReferences(){
        this.crossrefReferences++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute knownAuthors, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incKnownAuthors(){
        this.knownAuthors++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute nrCitations, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrCitations(){
        this.nrCitations++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute nrCited, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrCited(){
        this.nrCited++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute nrLinks, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrLinks(){
        this.nrLinks++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute year, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incYear(){
        this.year++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  override generic toString() method, show all attributes in human readable form
 * @return String details of the format are not clearly defined at the moment
*/

    @Override
    public String toString(){
        return toColumnString();
    }

/**
 *  alternative to the toString() method, experimental at this point
 *  This should be easier to read than toString(), but contain more information than toColumnString()
 * @return String human readable
*/

    public String prettyString(){
        return ""+ " " +getId()+ " " +getName()+ " " +getAbstractText()+ " " +getAuthor()+ " " +getChapter()+ " " +getConcept()+ " " +getConceptWeight()+ " " +getCrossrefCitations()+ " " +getCrossrefReferences()+ " " +getDoi()+ " " +getEditor()+ " " +getEncoded()+ " " +getIsSelected()+ " " +getIssue()+ " " +getKey()+ " " +getKeywords()+ " " +getKnownAuthors()+ " " +getNrCitations()+ " " +getNrCited()+ " " +getNrLinks()+ " " +getPage()+ " " +getPublisher()+ " " +getRelevance()+ " " +getSource()+ " " +getTitle()+ " " +getType()+ " " +getUrl()+ " " +getVolume()+ " " +getYear();
    }

/**
 *  alternative to the toString() method, used in the table views
 *  this only shows enough fields to identify the object
 *  Normally this is the name attribute, but this can be changed by the display_key fields
 * @return String normally name or other fields defned in display_key
*/

    public String toColumnString(){
        return getName();
    }

/**
 * show object as one element in XML format
 * side effect of writing to file
 * @param out PrintWriter
*/

     public void toXML(PrintWriter out){
         out.println("<missingWork "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " abstractText=\""+toXMLAbstractText()+"\""+
            " author=\""+toXMLAuthor()+"\""+
            " chapter=\""+toXMLChapter()+"\""+
            " concept=\""+toXMLConcept()+"\""+
            " conceptWeight=\""+toXMLConceptWeight()+"\""+
            " crossrefCitations=\""+toXMLCrossrefCitations()+"\""+
            " crossrefReferences=\""+toXMLCrossrefReferences()+"\""+
            " doi=\""+toXMLDoi()+"\""+
            " editor=\""+toXMLEditor()+"\""+
            " encoded=\""+toXMLEncoded()+"\""+
            " isSelected=\""+toXMLIsSelected()+"\""+
            " issue=\""+toXMLIssue()+"\""+
            " key=\""+toXMLKey()+"\""+
            " keywords=\""+toXMLKeywords()+"\""+
            " knownAuthors=\""+toXMLKnownAuthors()+"\""+
            " nrCitations=\""+toXMLNrCitations()+"\""+
            " nrCited=\""+toXMLNrCited()+"\""+
            " nrLinks=\""+toXMLNrLinks()+"\""+
            " page=\""+toXMLPage()+"\""+
            " publisher=\""+toXMLPublisher()+"\""+
            " relevance=\""+toXMLRelevance()+"\""+
            " source=\""+toXMLSource()+"\""+
            " title=\""+toXMLTitle()+"\""+
            " type=\""+toXMLType()+"\""+
            " url=\""+toXMLUrl()+"\""+
            " volume=\""+toXMLVolume()+"\""+
            " year=\""+toXMLYear()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLAbstractText(){
        return this.safeXML(getAbstractText());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLAuthor(){
        return this.safeXML(getAuthor());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLChapter(){
        return this.safeXML(getChapter());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLConcept(){
        String str="";
        for(Concept x:getConcept()){
            str=str+" "+"ID_"+x.getId();
        }
        return str;
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLConceptWeight(){
        return this.getConceptWeight().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCrossrefCitations(){
        return this.getCrossrefCitations().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCrossrefReferences(){
        return this.getCrossrefReferences().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLDoi(){
        return this.safeXML(getDoi());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLEditor(){
        return this.safeXML(getEditor());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLEncoded(){
        return this.safeXML(getEncoded());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLIsSelected(){
        return this.getIsSelected().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLIssue(){
        return this.safeXML(getIssue());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLKey(){
        return this.safeXML(getKey());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLKeywords(){
        return this.safeXML(getKeywords());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLKnownAuthors(){
        return this.getKnownAuthors().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLNrCitations(){
        return this.getNrCitations().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLNrCited(){
        return this.getNrCited().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLNrLinks(){
        return this.getNrLinks().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLPage(){
        return this.safeXML(getPage());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLPublisher(){
        return this.safeXML(getPublisher());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLRelevance(){
        return this.getRelevance().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLSource(){
        return this.safeXML(getSource());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLTitle(){
        return this.safeXML(getTitle());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLType(){
        return this.safeXML(getType());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLUrl(){
        return this.safeXML(getUrl());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLVolume(){
        return this.safeXML(getVolume());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLYear(){
        return this.getYear().toString();
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>MissingWork</th>"+"<th>Name</th>"+"<th>Key</th>"+"<th>Doi</th>"+"<th>Encoded</th>"+"<th>NrCited</th>"+"<th>NrCitations</th>"+"<th>NrLinks</th>"+"<th>Year</th>"+"<th>Author</th>"+"<th>Editor</th>"+"<th>Title</th>"+"<th>Publisher</th>"+"<th>Volume</th>"+"<th>Issue</th>"+"<th>Page</th>"+"<th>Chapter</th>"+"<th>Source</th>"+"<th>AbstractText</th>"+"<th>Keywords</th>"+"<th>Url</th>"+"<th>Type</th>"+"<th>CrossrefReferences</th>"+"<th>CrossrefCitations</th>"+"<th>KnownAuthors</th>"+"<th>ConceptWeight</th>"+"<th>Relevance</th>"+"<th>IsSelected</th>"+"<th>Concept</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getKey()+"</td>"+ " " +"<td>"+getDoi()+"</td>"+ " " +"<td>"+getEncoded()+"</td>"+ " " +"<td>"+getNrCited()+"</td>"+ " " +"<td>"+getNrCitations()+"</td>"+ " " +"<td>"+getNrLinks()+"</td>"+ " " +"<td>"+getYear()+"</td>"+ " " +"<td>"+getAuthor()+"</td>"+ " " +"<td>"+getEditor()+"</td>"+ " " +"<td>"+getTitle()+"</td>"+ " " +"<td>"+getPublisher()+"</td>"+ " " +"<td>"+getVolume()+"</td>"+ " " +"<td>"+getIssue()+"</td>"+ " " +"<td>"+getPage()+"</td>"+ " " +"<td>"+getChapter()+"</td>"+ " " +"<td>"+getSource()+"</td>"+ " " +"<td>"+getAbstractText()+"</td>"+ " " +"<td>"+getKeywords()+"</td>"+ " " +"<td>"+getUrl()+"</td>"+ " " +"<td>"+getType()+"</td>"+ " " +"<td>"+getCrossrefReferences()+"</td>"+ " " +"<td>"+getCrossrefCitations()+"</td>"+ " " +"<td>"+getKnownAuthors()+"</td>"+ " " +"<td>"+getConceptWeight()+"</td>"+ " " +"<td>"+getRelevance()+"</td>"+ " " +"<td>"+getIsSelected()+"</td>"+ " " +"<td>"+getConcept()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a MissingWork item we are looking for
 * @param bList List<MissingWork> list of items in which we are searching
 * @return MissingWork entry of list b which is applicationSame() to a
*/

    public static MissingWork find(MissingWork a, List<MissingWork> bList){
        for(MissingWork b : bList){
            if (b.applicationSame(a)){
                return b;
            }
        }
        return null;
    }

/**
 * find an object from its name; returns null if no such item exists
 * it is not defined which object is returned if multiple have the same name
 * @param base  dataset in which we are searching
 * @param name MissingWork name of the object we are looking for
 * @return MissingWork entry of the dataset with the given name; otherwise null
*/

    public static MissingWork findByName(ApplicationDataset base, String name){
        for(MissingWork a:base.getListMissingWork()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        return null;
    }

/**
 * find an object from its name; create new instance if no such item exists
 * it is not defined which object is returned if multiple have the same name
 * @param base  dataset in which we are searching
 * @param name MissingWork name of the object we are looking for
 * @return MissingWork entry of the dataset with the given name
*/

    public static MissingWork findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(MissingWork a:base.getListMissingWork()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        MissingWork res = new MissingWork(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return MissingWork first entry in the dataset of this type; null if that does not exists
*/

    public static MissingWork findFirst(ApplicationDataset base){
        if (base.getListMissingWork().isEmpty()) {
            return null;
        }
        return base.getListMissingWork().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return MissingWork some entry in the dataset of this type; null if that does not exists
*/

    public static MissingWork findAny(ApplicationDataset base){
        int size=base.getListMissingWork().size();
        if (size > 0) {
             return base.getListMissingWork().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return MissingWork last entry in the dataset of this type; null if that does not exists
*/

    public static MissingWork findLast(ApplicationDataset base){
        int size=base.getListMissingWork().size();
        if (size > 0) {
             return base.getListMissingWork().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b MissingWork compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(MissingWork b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b MissingWork compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(MissingWork b){
      if(!this.getAbstractText().equals(b.getAbstractText())){
         System.out.println("AbstractText");
        }
      if(!this.getAuthor().equals(b.getAuthor())){
         System.out.println("Author");
        }
      if(!this.getChapter().equals(b.getChapter())){
         System.out.println("Chapter");
        }
      if (true) {         System.out.println("Concept");
        }
      if(!this.getConceptWeight().equals(b.getConceptWeight())){
         System.out.println("ConceptWeight");
        }
      if(!this.getCrossrefCitations().equals(b.getCrossrefCitations())){
         System.out.println("CrossrefCitations");
        }
      if(!this.getCrossrefReferences().equals(b.getCrossrefReferences())){
         System.out.println("CrossrefReferences");
        }
      if(!this.getDoi().equals(b.getDoi())){
         System.out.println("Doi");
        }
      if(!this.getEditor().equals(b.getEditor())){
         System.out.println("Editor");
        }
      if(!this.getEncoded().equals(b.getEncoded())){
         System.out.println("Encoded");
        }
      if(!this.getIsSelected().equals(b.getIsSelected())){
         System.out.println("IsSelected");
        }
      if(!this.getIssue().equals(b.getIssue())){
         System.out.println("Issue");
        }
      if(!this.getKey().equals(b.getKey())){
         System.out.println("Key");
        }
      if(!this.getKeywords().equals(b.getKeywords())){
         System.out.println("Keywords");
        }
      if(!this.getKnownAuthors().equals(b.getKnownAuthors())){
         System.out.println("KnownAuthors");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getNrCitations().equals(b.getNrCitations())){
         System.out.println("NrCitations");
        }
      if(!this.getNrCited().equals(b.getNrCited())){
         System.out.println("NrCited");
        }
      if(!this.getNrLinks().equals(b.getNrLinks())){
         System.out.println("NrLinks");
        }
      if(!this.getPage().equals(b.getPage())){
         System.out.println("Page");
        }
      if(!this.getPublisher().equals(b.getPublisher())){
         System.out.println("Publisher");
        }
      if(!this.getRelevance().equals(b.getRelevance())){
         System.out.println("Relevance");
        }
      if(!this.getSource().equals(b.getSource())){
         System.out.println("Source");
        }
      if(!this.getTitle().equals(b.getTitle())){
         System.out.println("Title");
        }
      if(!this.getType().equals(b.getType())){
         System.out.println("Type");
        }
      if(!this.getUrl().equals(b.getUrl())){
         System.out.println("Url");
        }
      if(!this.getVolume().equals(b.getVolume())){
         System.out.println("Volume");
        }
      if(!this.getYear().equals(b.getYear())){
         System.out.println("Year");
        }
        return  this.getAbstractText().equals(b.getAbstractText()) &&
          this.getAuthor().equals(b.getAuthor()) &&
          this.getChapter().equals(b.getChapter()) &&
          true &&
          this.getConceptWeight().equals(b.getConceptWeight()) &&
          this.getCrossrefCitations().equals(b.getCrossrefCitations()) &&
          this.getCrossrefReferences().equals(b.getCrossrefReferences()) &&
          this.getDoi().equals(b.getDoi()) &&
          this.getEditor().equals(b.getEditor()) &&
          this.getEncoded().equals(b.getEncoded()) &&
          this.getIsSelected().equals(b.getIsSelected()) &&
          this.getIssue().equals(b.getIssue()) &&
          this.getKey().equals(b.getKey()) &&
          this.getKeywords().equals(b.getKeywords()) &&
          this.getKnownAuthors().equals(b.getKnownAuthors()) &&
          this.getName().equals(b.getName()) &&
          this.getNrCitations().equals(b.getNrCitations()) &&
          this.getNrCited().equals(b.getNrCited()) &&
          this.getNrLinks().equals(b.getNrLinks()) &&
          this.getPage().equals(b.getPage()) &&
          this.getPublisher().equals(b.getPublisher()) &&
          this.getRelevance().equals(b.getRelevance()) &&
          this.getSource().equals(b.getSource()) &&
          this.getTitle().equals(b.getTitle()) &&
          this.getType().equals(b.getType()) &&
          this.getUrl().equals(b.getUrl()) &&
          this.getVolume().equals(b.getVolume()) &&
          this.getYear().equals(b.getYear());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","MissingWork",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getConcept() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"concept","MissingWork",(getConcept()==null?"null":getConcept().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class MissingWork
    }

/**
 *  This method states if the class depends on the solver.
 *
*/

    public static Boolean isSolverDependent(){
        return false;
    }

   public List<ApplicationObjectInterface> getFeasibleValues(ApplicationDatasetInterface base,String attrName){
      if (attrName.equals("concept")){
         return (List) ((Scenario)base).getListConcept();
      }
      return null;
   }

}
