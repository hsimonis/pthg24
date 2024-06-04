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
import org.insightcentre.pthg24.datamodel.CountryCollab;
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

public  class OtherWork extends ApplicationObject{
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

    public List<Author> authors;

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

    public Boolean isFound;

    private transient BooleanProperty isFoundWrapper;

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

    public Integer nr;

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

    public String shortName;

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

    public Integer workCount;

/**
 *  
 *
*/

    public WorkType workType;

/**
 *  
 *
*/

    public Integer year;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public OtherWork(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public OtherWork(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setAbstractText("");
        setAuthor("");
        setAuthors(new ArrayList<Author>());
        setChapter("");
        setConcept(new ArrayList<Concept>());
        setDoi("");
        setEditor("");
        setIsFound(false);
        setIsSelected(false);
        setIssue("");
        setKey("");
        setKeywords("");
        setNr(0);
        setPage("");
        setPublisher("");
        setRelevance(0.0);
        setShortName("");
        setSource("");
        setTitle("");
        setUrl("");
        setVolume("");
        setWorkCount(0);
        setWorkType(null);
        setYear(0);
        applicationDataset.addOtherWork(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public OtherWork(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            String abstractText,
            String author,
            List<Author> authors,
            String chapter,
            List<Concept> concept,
            String doi,
            String editor,
            Boolean isFound,
            Boolean isSelected,
            String issue,
            String key,
            String keywords,
            Integer nr,
            String page,
            String publisher,
            Double relevance,
            String shortName,
            String source,
            String title,
            String url,
            String volume,
            Integer workCount,
            WorkType workType,
            Integer year){
        super(applicationDataset,
            id,
            name);
        setAbstractText(abstractText);
        setAuthor(author);
        setAuthors(authors);
        setChapter(chapter);
        setConcept(concept);
        setDoi(doi);
        setEditor(editor);
        setIsFound(isFound);
        setIsSelected(isSelected);
        setIssue(issue);
        setKey(key);
        setKeywords(keywords);
        setNr(nr);
        setPage(page);
        setPublisher(publisher);
        setRelevance(relevance);
        setShortName(shortName);
        setSource(source);
        setTitle(title);
        setUrl(url);
        setVolume(volume);
        setWorkCount(workCount);
        setWorkType(workType);
        setYear(year);
        applicationDataset.addOtherWork(this);
    }

    public OtherWork(OtherWork other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.abstractText,
            other.author,
            other.authors,
            other.chapter,
            other.concept,
            other.doi,
            other.editor,
            other.isFound,
            other.isSelected,
            other.issue,
            other.key,
            other.keywords,
            other.nr,
            other.page,
            other.publisher,
            other.relevance,
            other.shortName,
            other.source,
            other.title,
            other.url,
            other.volume,
            other.workCount,
            other.workType,
            other.year);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        return getApplicationDataset().removeOtherWork(this) && getApplicationDataset().removeApplicationObject(this);
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
 *  get attribute authors
 *
 * @return List<Author>
*/

    public List<Author> getAuthors(){
        return this.authors;
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
 *  get attribute isFound
 *
 * @return Boolean
*/

    public Boolean getIsFound(){
        return this.isFound;
    }

    public BooleanProperty isFoundWrapperProperty() {
        if (isFoundWrapper == null) {
            isFoundWrapper = new SimpleBooleanProperty();
        }
        isFoundWrapper.set(isFound);
        return isFoundWrapper;
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
 *  get attribute nr
 *
 * @return Integer
*/

    public Integer getNr(){
        return this.nr;
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
 *  get attribute shortName
 *
 * @return String
*/

    public String getShortName(){
        return this.shortName;
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
 *  get attribute workCount
 *
 * @return Integer
*/

    public Integer getWorkCount(){
        return this.workCount;
    }

/**
 *  get attribute workType
 *
 * @return WorkType
*/

    public WorkType getWorkType(){
        return this.workType;
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
 *  set attribute authors, mark dataset as dirty, mark dataset as not valid
@param authors List<Author>
 *
*/

    public void setAuthors(List<Author> authors){
        this.authors = authors;
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
 *  set attribute isFound, mark dataset as dirty, mark dataset as not valid
@param isFound Boolean
 *
*/

    public void setIsFound(Boolean isFound){
        this.isFound = isFound;
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
 *  set attribute nr, mark dataset as dirty, mark dataset as not valid
@param nr Integer
 *
*/

    public void setNr(Integer nr){
        this.nr = nr;
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
 *  set attribute shortName, mark dataset as dirty, mark dataset as not valid
@param shortName String
 *
*/

    public void setShortName(String shortName){
        this.shortName = shortName;
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
 *  set attribute workCount, mark dataset as dirty, mark dataset as not valid
@param workCount Integer
 *
*/

    public void setWorkCount(Integer workCount){
        this.workCount = workCount;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute workType, mark dataset as dirty, mark dataset as not valid
@param workType WorkType
 *
*/

    public void setWorkType(WorkType workType){
        this.workType = workType;
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
 *  inc attribute nr, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNr(){
        this.nr++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute workCount, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incWorkCount(){
        this.workCount++;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getAbstractText()+ " " +getAuthor()+ " " +getAuthors()+ " " +getChapter()+ " " +getConcept()+ " " +getDoi()+ " " +getEditor()+ " " +getIsFound()+ " " +getIsSelected()+ " " +getIssue()+ " " +getKey()+ " " +getKeywords()+ " " +getNr()+ " " +getPage()+ " " +getPublisher()+ " " +getRelevance()+ " " +getShortName()+ " " +getSource()+ " " +getTitle()+ " " +getUrl()+ " " +getVolume()+ " " +getWorkCount()+ " " +getWorkType()+ " " +getYear();
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
         out.println("<otherWork "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " abstractText=\""+toXMLAbstractText()+"\""+
            " author=\""+toXMLAuthor()+"\""+
            " authors=\""+toXMLAuthors()+"\""+
            " chapter=\""+toXMLChapter()+"\""+
            " concept=\""+toXMLConcept()+"\""+
            " doi=\""+toXMLDoi()+"\""+
            " editor=\""+toXMLEditor()+"\""+
            " isFound=\""+toXMLIsFound()+"\""+
            " isSelected=\""+toXMLIsSelected()+"\""+
            " issue=\""+toXMLIssue()+"\""+
            " key=\""+toXMLKey()+"\""+
            " keywords=\""+toXMLKeywords()+"\""+
            " nr=\""+toXMLNr()+"\""+
            " page=\""+toXMLPage()+"\""+
            " publisher=\""+toXMLPublisher()+"\""+
            " relevance=\""+toXMLRelevance()+"\""+
            " shortName=\""+toXMLShortName()+"\""+
            " source=\""+toXMLSource()+"\""+
            " title=\""+toXMLTitle()+"\""+
            " url=\""+toXMLUrl()+"\""+
            " volume=\""+toXMLVolume()+"\""+
            " workCount=\""+toXMLWorkCount()+"\""+
            " workType=\""+toXMLWorkType()+"\""+
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

    String toXMLAuthors(){
        String str="";
        for(Author x:getAuthors()){
            str=str+" "+"ID_"+x.getId();
        }
        return str;
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

    String toXMLIsFound(){
        return this.getIsFound().toString();
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

    String toXMLNr(){
        return this.getNr().toString();
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

    String toXMLShortName(){
        return this.safeXML(getShortName());
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

    String toXMLWorkCount(){
        return this.getWorkCount().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLWorkType(){
        return this.getWorkType().toString();
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
        return "<tr><th>OtherWork</th>"+"<th>Name</th>"+"<th>ShortName</th>"+"<th>Nr</th>"+"<th>Key</th>"+"<th>WorkType</th>"+"<th>Editor</th>"+"<th>Author</th>"+"<th>Authors</th>"+"<th>WorkCount</th>"+"<th>Title</th>"+"<th>Source</th>"+"<th>Url</th>"+"<th>Doi</th>"+"<th>Year</th>"+"<th>Relevance</th>"+"<th>IsFound</th>"+"<th>IsSelected</th>"+"<th>Concept</th>"+"<th>Keywords</th>"+"<th>AbstractText</th>"+"<th>Volume</th>"+"<th>Issue</th>"+"<th>Page</th>"+"<th>Chapter</th>"+"<th>Publisher</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getShortName()+"</td>"+ " " +"<td>"+getNr()+"</td>"+ " " +"<td>"+getKey()+"</td>"+ " " +"<td>"+getWorkType()+"</td>"+ " " +"<td>"+getEditor()+"</td>"+ " " +"<td>"+getAuthor()+"</td>"+ " " +"<td>"+getAuthors()+"</td>"+ " " +"<td>"+getWorkCount()+"</td>"+ " " +"<td>"+getTitle()+"</td>"+ " " +"<td>"+getSource()+"</td>"+ " " +"<td>"+getUrl()+"</td>"+ " " +"<td>"+getDoi()+"</td>"+ " " +"<td>"+getYear()+"</td>"+ " " +"<td>"+getRelevance()+"</td>"+ " " +"<td>"+getIsFound()+"</td>"+ " " +"<td>"+getIsSelected()+"</td>"+ " " +"<td>"+getConcept()+"</td>"+ " " +"<td>"+getKeywords()+"</td>"+ " " +"<td>"+getAbstractText()+"</td>"+ " " +"<td>"+getVolume()+"</td>"+ " " +"<td>"+getIssue()+"</td>"+ " " +"<td>"+getPage()+"</td>"+ " " +"<td>"+getChapter()+"</td>"+ " " +"<td>"+getPublisher()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a OtherWork item we are looking for
 * @param bList List<OtherWork> list of items in which we are searching
 * @return OtherWork entry of list b which is applicationSame() to a
*/

    public static OtherWork find(OtherWork a, List<OtherWork> bList){
        for(OtherWork b : bList){
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
 * @param name OtherWork name of the object we are looking for
 * @return OtherWork entry of the dataset with the given name; otherwise null
*/

    public static OtherWork findByName(ApplicationDataset base, String name){
        for(OtherWork a:base.getListOtherWork()) {
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
 * @param name OtherWork name of the object we are looking for
 * @return OtherWork entry of the dataset with the given name
*/

    public static OtherWork findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(OtherWork a:base.getListOtherWork()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        OtherWork res = new OtherWork(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return OtherWork first entry in the dataset of this type; null if that does not exists
*/

    public static OtherWork findFirst(ApplicationDataset base){
        if (base.getListOtherWork().isEmpty()) {
            return null;
        }
        return base.getListOtherWork().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return OtherWork some entry in the dataset of this type; null if that does not exists
*/

    public static OtherWork findAny(ApplicationDataset base){
        int size=base.getListOtherWork().size();
        if (size > 0) {
             return base.getListOtherWork().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return OtherWork last entry in the dataset of this type; null if that does not exists
*/

    public static OtherWork findLast(ApplicationDataset base){
        int size=base.getListOtherWork().size();
        if (size > 0) {
             return base.getListOtherWork().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b OtherWork compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(OtherWork b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b OtherWork compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(OtherWork b){
      if(!this.getAbstractText().equals(b.getAbstractText())){
         System.out.println("AbstractText");
        }
      if(!this.getAuthor().equals(b.getAuthor())){
         System.out.println("Author");
        }
      if (true) {         System.out.println("Authors");
        }
      if(!this.getChapter().equals(b.getChapter())){
         System.out.println("Chapter");
        }
      if (true) {         System.out.println("Concept");
        }
      if(!this.getDoi().equals(b.getDoi())){
         System.out.println("Doi");
        }
      if(!this.getEditor().equals(b.getEditor())){
         System.out.println("Editor");
        }
      if(!this.getIsFound().equals(b.getIsFound())){
         System.out.println("IsFound");
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
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getNr().equals(b.getNr())){
         System.out.println("Nr");
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
      if(!this.getShortName().equals(b.getShortName())){
         System.out.println("ShortName");
        }
      if(!this.getSource().equals(b.getSource())){
         System.out.println("Source");
        }
      if(!this.getTitle().equals(b.getTitle())){
         System.out.println("Title");
        }
      if(!this.getUrl().equals(b.getUrl())){
         System.out.println("Url");
        }
      if(!this.getVolume().equals(b.getVolume())){
         System.out.println("Volume");
        }
      if(!this.getWorkCount().equals(b.getWorkCount())){
         System.out.println("WorkCount");
        }
      if(!this.getWorkType().equals(b.getWorkType())){
         System.out.println("WorkType");
        }
      if(!this.getYear().equals(b.getYear())){
         System.out.println("Year");
        }
        return  this.getAbstractText().equals(b.getAbstractText()) &&
          this.getAuthor().equals(b.getAuthor()) &&
          true &&
          this.getChapter().equals(b.getChapter()) &&
          true &&
          this.getDoi().equals(b.getDoi()) &&
          this.getEditor().equals(b.getEditor()) &&
          this.getIsFound().equals(b.getIsFound()) &&
          this.getIsSelected().equals(b.getIsSelected()) &&
          this.getIssue().equals(b.getIssue()) &&
          this.getKey().equals(b.getKey()) &&
          this.getKeywords().equals(b.getKeywords()) &&
          this.getName().equals(b.getName()) &&
          this.getNr().equals(b.getNr()) &&
          this.getPage().equals(b.getPage()) &&
          this.getPublisher().equals(b.getPublisher()) &&
          this.getRelevance().equals(b.getRelevance()) &&
          this.getShortName().equals(b.getShortName()) &&
          this.getSource().equals(b.getSource()) &&
          this.getTitle().equals(b.getTitle()) &&
          this.getUrl().equals(b.getUrl()) &&
          this.getVolume().equals(b.getVolume()) &&
          this.getWorkCount().equals(b.getWorkCount()) &&
          this.getWorkType().equals(b.getWorkType()) &&
          this.getYear().equals(b.getYear());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","OtherWork",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getAuthors() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"authors","OtherWork",(getAuthors()==null?"null":getAuthors().toString()),"",WarningType.NOTNULL);
        }
        if (getAuthors().size() == 0){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"authors","OtherWork",(getAuthors()==null?"null":getAuthors().toString()),"",WarningType.NOTEMPTY);
        }
        if (getConcept() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"concept","OtherWork",(getConcept()==null?"null":getConcept().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class OtherWork
    }

/**
 *  This method states if the class depends on the solver.
 *
*/

    public static Boolean isSolverDependent(){
        return false;
    }

   public List<ApplicationObjectInterface> getFeasibleValues(ApplicationDatasetInterface base,String attrName){
      if (attrName.equals("authors")){
         return (List) ((Scenario)base).getListAuthor();
      }
      if (attrName.equals("concept")){
         return (List) ((Scenario)base).getListConcept();
      }
      return null;
   }

}
