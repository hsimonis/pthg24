// licence details to be added
package org.insightcentre.pthg24.datamodel;
import org.insightcentre.pthg24.datamodel.ApplicationDataset;
import org.insightcentre.pthg24.datamodel.ApplicationObject;
import org.insightcentre.pthg24.datamodel.ApplicationDifference;
import org.insightcentre.pthg24.datamodel.ApplicationWarning;
import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.datamodel.Concept;
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
import org.insightcentre.pthg24.datamodel.DifferenceType;
import org.insightcentre.pthg24.datamodel.WarningType;
import org.insightcentre.pthg24.datamodel.MatchLevel;
import org.insightcentre.pthg24.datamodel.WorkType;
import org.insightcentre.pthg24.datamodel.ConceptType;
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

public abstract class Work extends ApplicationObject{
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

    public Boolean background;

    private transient BooleanProperty backgroundWrapper;

/**
 *  
 *
*/

    public String classification;

/**
 *  
 *
*/

    public String codeAvail;

/**
 *  
 *
*/

    public String constraints;

/**
 *  
 *
*/

    public String cpSystem;

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

    public Boolean crossrefStatus;

    private transient BooleanProperty crossrefStatusWrapper;

/**
 *  
 *
*/

    public String dataAvail;

/**
 *  
 *
*/

    public String doi;

/**
 *  
 *
*/

    public Boolean doiStatus;

    private transient BooleanProperty doiStatusWrapper;

/**
 *  
 *
*/

    public String key;

/**
 *  
 *
*/

    public String localCopy;

/**
 *  
 *
*/

    public Integer nrCitations;

/**
 *  
 *
*/

    public Integer nrCitationsCovered;

/**
 *  
 *
*/

    public Integer nrLinks;

/**
 *  
 *
*/

    public Integer nrPages;

/**
 *  
 *
*/

    public Integer nrReferences;

/**
 *  
 *
*/

    public Integer nrReferencesCovered;

/**
 *  
 *
*/

    public String pages;

/**
 *  
 *
*/

    public Double percentCitationsCovered;

/**
 *  
 *
*/

    public Double percentReferencesCovered;

/**
 *  
 *
*/

    public String relatedTo;

/**
 *  
 *
*/

    public Integer scopusCitations;

/**
 *  
 *
*/

    public Boolean scopusStatus;

    private transient BooleanProperty scopusStatusWrapper;

/**
 *  
 *
*/

    public String solutionAvail;

/**
 *  
 *
*/

    public SourceGroup sourceGroup;

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

    public Integer year;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public Work(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public Work(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setAuthor("");
        setAuthors(new ArrayList<Author>());
        setBackground(false);
        setClassification("");
        setCodeAvail("");
        setConstraints("");
        setCpSystem("");
        setCrossrefCitations(0);
        setCrossrefReferences(0);
        setCrossrefStatus(true);
        setDataAvail("");
        setDoi("");
        setDoiStatus(true);
        setKey("");
        setLocalCopy("");
        setNrCitations(0);
        setNrCitationsCovered(0);
        setNrLinks(0);
        setNrPages(0);
        setNrReferences(0);
        setNrReferencesCovered(0);
        setPages("");
        setPercentCitationsCovered(0.0);
        setPercentReferencesCovered(0.0);
        setRelatedTo("");
        setScopusCitations(0);
        setScopusStatus(true);
        setSolutionAvail("");
        setSourceGroup(null);
        setTitle("");
        setUrl("");
        setYear(0);
        applicationDataset.addWork(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public Work(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            String author,
            List<Author> authors,
            Boolean background,
            String classification,
            String codeAvail,
            String constraints,
            String cpSystem,
            Integer crossrefCitations,
            Integer crossrefReferences,
            Boolean crossrefStatus,
            String dataAvail,
            String doi,
            Boolean doiStatus,
            String key,
            String localCopy,
            Integer nrCitations,
            Integer nrCitationsCovered,
            Integer nrLinks,
            Integer nrPages,
            Integer nrReferences,
            Integer nrReferencesCovered,
            String pages,
            Double percentCitationsCovered,
            Double percentReferencesCovered,
            String relatedTo,
            Integer scopusCitations,
            Boolean scopusStatus,
            String solutionAvail,
            SourceGroup sourceGroup,
            String title,
            String url,
            Integer year){
        super(applicationDataset,
            id,
            name);
        setAuthor(author);
        setAuthors(authors);
        setBackground(background);
        setClassification(classification);
        setCodeAvail(codeAvail);
        setConstraints(constraints);
        setCpSystem(cpSystem);
        setCrossrefCitations(crossrefCitations);
        setCrossrefReferences(crossrefReferences);
        setCrossrefStatus(crossrefStatus);
        setDataAvail(dataAvail);
        setDoi(doi);
        setDoiStatus(doiStatus);
        setKey(key);
        setLocalCopy(localCopy);
        setNrCitations(nrCitations);
        setNrCitationsCovered(nrCitationsCovered);
        setNrLinks(nrLinks);
        setNrPages(nrPages);
        setNrReferences(nrReferences);
        setNrReferencesCovered(nrReferencesCovered);
        setPages(pages);
        setPercentCitationsCovered(percentCitationsCovered);
        setPercentReferencesCovered(percentReferencesCovered);
        setRelatedTo(relatedTo);
        setScopusCitations(scopusCitations);
        setScopusStatus(scopusStatus);
        setSolutionAvail(solutionAvail);
        setSourceGroup(sourceGroup);
        setTitle(title);
        setUrl(url);
        setYear(year);
        applicationDataset.addWork(this);
    }

    public Work(Work other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.author,
            other.authors,
            other.background,
            other.classification,
            other.codeAvail,
            other.constraints,
            other.cpSystem,
            other.crossrefCitations,
            other.crossrefReferences,
            other.crossrefStatus,
            other.dataAvail,
            other.doi,
            other.doiStatus,
            other.key,
            other.localCopy,
            other.nrCitations,
            other.nrCitationsCovered,
            other.nrLinks,
            other.nrPages,
            other.nrReferences,
            other.nrReferencesCovered,
            other.pages,
            other.percentCitationsCovered,
            other.percentReferencesCovered,
            other.relatedTo,
            other.scopusCitations,
            other.scopusStatus,
            other.solutionAvail,
            other.sourceGroup,
            other.title,
            other.url,
            other.year);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        getApplicationDataset().cascadeAuthorshipWork(this);
        getApplicationDataset().cascadeConceptWorkWork(this);
        getApplicationDataset().cascadeCitationCitedWork(this);
        getApplicationDataset().cascadeCitationCitingWork(this);
        getApplicationDataset().cascadeReferenceCitedWork(this);
        getApplicationDataset().cascadeReferenceCitingWork(this);
        getApplicationDataset().cascadeSimilarityWork1(this);
        getApplicationDataset().cascadeSimilarityWork2(this);
        getApplicationDataset().cascadeCrossReferenceWork(this);
        getApplicationDataset().cascadeCrossReferenceReferredWork(this);
        getApplicationDataset().cascadeWorkAffiliationWork(this);
        return getApplicationDataset().removeWork(this) && getApplicationDataset().removeApplicationObject(this);
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
 *  get attribute background
 *
 * @return Boolean
*/

    public Boolean getBackground(){
        return this.background;
    }

    public BooleanProperty backgroundWrapperProperty() {
        if (backgroundWrapper == null) {
            backgroundWrapper = new SimpleBooleanProperty();
        }
        backgroundWrapper.set(background);
        return backgroundWrapper;
    }

/**
 *  get attribute classification
 *
 * @return String
*/

    public String getClassification(){
        return this.classification;
    }

/**
 *  get attribute codeAvail
 *
 * @return String
*/

    public String getCodeAvail(){
        return this.codeAvail;
    }

/**
 *  get attribute constraints
 *
 * @return String
*/

    public String getConstraints(){
        return this.constraints;
    }

/**
 *  get attribute cpSystem
 *
 * @return String
*/

    public String getCpSystem(){
        return this.cpSystem;
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
 *  get attribute crossrefStatus
 *
 * @return Boolean
*/

    public Boolean getCrossrefStatus(){
        return this.crossrefStatus;
    }

    public BooleanProperty crossrefStatusWrapperProperty() {
        if (crossrefStatusWrapper == null) {
            crossrefStatusWrapper = new SimpleBooleanProperty();
        }
        crossrefStatusWrapper.set(crossrefStatus);
        return crossrefStatusWrapper;
    }

/**
 *  get attribute dataAvail
 *
 * @return String
*/

    public String getDataAvail(){
        return this.dataAvail;
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
 *  get attribute doiStatus
 *
 * @return Boolean
*/

    public Boolean getDoiStatus(){
        return this.doiStatus;
    }

    public BooleanProperty doiStatusWrapperProperty() {
        if (doiStatusWrapper == null) {
            doiStatusWrapper = new SimpleBooleanProperty();
        }
        doiStatusWrapper.set(doiStatus);
        return doiStatusWrapper;
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
 *  get attribute localCopy
 *
 * @return String
*/

    public String getLocalCopy(){
        return this.localCopy;
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
 *  get attribute nrCitationsCovered
 *
 * @return Integer
*/

    public Integer getNrCitationsCovered(){
        return this.nrCitationsCovered;
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
 *  get attribute nrPages
 *
 * @return Integer
*/

    public Integer getNrPages(){
        return this.nrPages;
    }

/**
 *  get attribute nrReferences
 *
 * @return Integer
*/

    public Integer getNrReferences(){
        return this.nrReferences;
    }

/**
 *  get attribute nrReferencesCovered
 *
 * @return Integer
*/

    public Integer getNrReferencesCovered(){
        return this.nrReferencesCovered;
    }

/**
 *  get attribute pages
 *
 * @return String
*/

    public String getPages(){
        return this.pages;
    }

/**
 *  get attribute percentCitationsCovered
 *
 * @return Double
*/

    public Double getPercentCitationsCovered(){
        return this.percentCitationsCovered;
    }

/**
 *  get attribute percentReferencesCovered
 *
 * @return Double
*/

    public Double getPercentReferencesCovered(){
        return this.percentReferencesCovered;
    }

/**
 *  get attribute relatedTo
 *
 * @return String
*/

    public String getRelatedTo(){
        return this.relatedTo;
    }

/**
 *  get attribute scopusCitations
 *
 * @return Integer
*/

    public Integer getScopusCitations(){
        return this.scopusCitations;
    }

/**
 *  get attribute scopusStatus
 *
 * @return Boolean
*/

    public Boolean getScopusStatus(){
        return this.scopusStatus;
    }

    public BooleanProperty scopusStatusWrapperProperty() {
        if (scopusStatusWrapper == null) {
            scopusStatusWrapper = new SimpleBooleanProperty();
        }
        scopusStatusWrapper.set(scopusStatus);
        return scopusStatusWrapper;
    }

/**
 *  get attribute solutionAvail
 *
 * @return String
*/

    public String getSolutionAvail(){
        return this.solutionAvail;
    }

/**
 *  get attribute sourceGroup
 *
 * @return SourceGroup
*/

    public SourceGroup getSourceGroup(){
        return this.sourceGroup;
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
 *  get attribute year
 *
 * @return Integer
*/

    public Integer getYear(){
        return this.year;
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
 *  set attribute background, mark dataset as dirty, mark dataset as not valid
@param background Boolean
 *
*/

    public void setBackground(Boolean background){
        this.background = background;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute classification, mark dataset as dirty, mark dataset as not valid
@param classification String
 *
*/

    public void setClassification(String classification){
        this.classification = classification;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute codeAvail, mark dataset as dirty, mark dataset as not valid
@param codeAvail String
 *
*/

    public void setCodeAvail(String codeAvail){
        this.codeAvail = codeAvail;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute constraints, mark dataset as dirty, mark dataset as not valid
@param constraints String
 *
*/

    public void setConstraints(String constraints){
        this.constraints = constraints;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute cpSystem, mark dataset as dirty, mark dataset as not valid
@param cpSystem String
 *
*/

    public void setCpSystem(String cpSystem){
        this.cpSystem = cpSystem;
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
 *  set attribute crossrefStatus, mark dataset as dirty, mark dataset as not valid
@param crossrefStatus Boolean
 *
*/

    public void setCrossrefStatus(Boolean crossrefStatus){
        this.crossrefStatus = crossrefStatus;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute dataAvail, mark dataset as dirty, mark dataset as not valid
@param dataAvail String
 *
*/

    public void setDataAvail(String dataAvail){
        this.dataAvail = dataAvail;
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
 *  set attribute doiStatus, mark dataset as dirty, mark dataset as not valid
@param doiStatus Boolean
 *
*/

    public void setDoiStatus(Boolean doiStatus){
        this.doiStatus = doiStatus;
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
 *  set attribute localCopy, mark dataset as dirty, mark dataset as not valid
@param localCopy String
 *
*/

    public void setLocalCopy(String localCopy){
        this.localCopy = localCopy;
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
 *  set attribute nrCitationsCovered, mark dataset as dirty, mark dataset as not valid
@param nrCitationsCovered Integer
 *
*/

    public void setNrCitationsCovered(Integer nrCitationsCovered){
        this.nrCitationsCovered = nrCitationsCovered;
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
 *  set attribute nrPages, mark dataset as dirty, mark dataset as not valid
@param nrPages Integer
 *
*/

    public void setNrPages(Integer nrPages){
        this.nrPages = nrPages;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute nrReferences, mark dataset as dirty, mark dataset as not valid
@param nrReferences Integer
 *
*/

    public void setNrReferences(Integer nrReferences){
        this.nrReferences = nrReferences;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute nrReferencesCovered, mark dataset as dirty, mark dataset as not valid
@param nrReferencesCovered Integer
 *
*/

    public void setNrReferencesCovered(Integer nrReferencesCovered){
        this.nrReferencesCovered = nrReferencesCovered;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute pages, mark dataset as dirty, mark dataset as not valid
@param pages String
 *
*/

    public void setPages(String pages){
        this.pages = pages;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute percentCitationsCovered, mark dataset as dirty, mark dataset as not valid
@param percentCitationsCovered Double
 *
*/

    public void setPercentCitationsCovered(Double percentCitationsCovered){
        this.percentCitationsCovered = percentCitationsCovered;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute percentReferencesCovered, mark dataset as dirty, mark dataset as not valid
@param percentReferencesCovered Double
 *
*/

    public void setPercentReferencesCovered(Double percentReferencesCovered){
        this.percentReferencesCovered = percentReferencesCovered;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute relatedTo, mark dataset as dirty, mark dataset as not valid
@param relatedTo String
 *
*/

    public void setRelatedTo(String relatedTo){
        this.relatedTo = relatedTo;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute scopusCitations, mark dataset as dirty, mark dataset as not valid
@param scopusCitations Integer
 *
*/

    public void setScopusCitations(Integer scopusCitations){
        this.scopusCitations = scopusCitations;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute scopusStatus, mark dataset as dirty, mark dataset as not valid
@param scopusStatus Boolean
 *
*/

    public void setScopusStatus(Boolean scopusStatus){
        this.scopusStatus = scopusStatus;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute solutionAvail, mark dataset as dirty, mark dataset as not valid
@param solutionAvail String
 *
*/

    public void setSolutionAvail(String solutionAvail){
        this.solutionAvail = solutionAvail;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute sourceGroup, mark dataset as dirty, mark dataset as not valid
@param sourceGroup SourceGroup
 *
*/

    public void setSourceGroup(SourceGroup sourceGroup){
        this.sourceGroup = sourceGroup;
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
 *  inc attribute nrCitations, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrCitations(){
        this.nrCitations++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute nrCitationsCovered, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrCitationsCovered(){
        this.nrCitationsCovered++;
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
 *  inc attribute nrPages, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrPages(){
        this.nrPages++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute nrReferences, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrReferences(){
        this.nrReferences++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute nrReferencesCovered, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrReferencesCovered(){
        this.nrReferencesCovered++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute scopusCitations, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incScopusCitations(){
        this.scopusCitations++;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getAuthor()+ " " +getAuthors()+ " " +getBackground()+ " " +getClassification()+ " " +getCodeAvail()+ " " +getConstraints()+ " " +getCpSystem()+ " " +getCrossrefCitations()+ " " +getCrossrefReferences()+ " " +getCrossrefStatus()+ " " +getDataAvail()+ " " +getDoi()+ " " +getDoiStatus()+ " " +getKey()+ " " +getLocalCopy()+ " " +getNrCitations()+ " " +getNrCitationsCovered()+ " " +getNrLinks()+ " " +getNrPages()+ " " +getNrReferences()+ " " +getNrReferencesCovered()+ " " +getPages()+ " " +getPercentCitationsCovered()+ " " +getPercentReferencesCovered()+ " " +getRelatedTo()+ " " +getScopusCitations()+ " " +getScopusStatus()+ " " +getSolutionAvail()+ " " +getSourceGroup().toColumnString()+ " " +getTitle()+ " " +getUrl()+ " " +getYear();
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
         out.println("<work "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " author=\""+toXMLAuthor()+"\""+
            " authors=\""+toXMLAuthors()+"\""+
            " background=\""+toXMLBackground()+"\""+
            " classification=\""+toXMLClassification()+"\""+
            " codeAvail=\""+toXMLCodeAvail()+"\""+
            " constraints=\""+toXMLConstraints()+"\""+
            " cpSystem=\""+toXMLCpSystem()+"\""+
            " crossrefCitations=\""+toXMLCrossrefCitations()+"\""+
            " crossrefReferences=\""+toXMLCrossrefReferences()+"\""+
            " crossrefStatus=\""+toXMLCrossrefStatus()+"\""+
            " dataAvail=\""+toXMLDataAvail()+"\""+
            " doi=\""+toXMLDoi()+"\""+
            " doiStatus=\""+toXMLDoiStatus()+"\""+
            " key=\""+toXMLKey()+"\""+
            " localCopy=\""+toXMLLocalCopy()+"\""+
            " nrCitations=\""+toXMLNrCitations()+"\""+
            " nrCitationsCovered=\""+toXMLNrCitationsCovered()+"\""+
            " nrLinks=\""+toXMLNrLinks()+"\""+
            " nrPages=\""+toXMLNrPages()+"\""+
            " nrReferences=\""+toXMLNrReferences()+"\""+
            " nrReferencesCovered=\""+toXMLNrReferencesCovered()+"\""+
            " pages=\""+toXMLPages()+"\""+
            " percentCitationsCovered=\""+toXMLPercentCitationsCovered()+"\""+
            " percentReferencesCovered=\""+toXMLPercentReferencesCovered()+"\""+
            " relatedTo=\""+toXMLRelatedTo()+"\""+
            " scopusCitations=\""+toXMLScopusCitations()+"\""+
            " scopusStatus=\""+toXMLScopusStatus()+"\""+
            " solutionAvail=\""+toXMLSolutionAvail()+"\""+
            " sourceGroup=\""+toXMLSourceGroup()+"\""+
            " title=\""+toXMLTitle()+"\""+
            " url=\""+toXMLUrl()+"\""+
            " year=\""+toXMLYear()+"\""+" />");
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

    String toXMLBackground(){
        return this.getBackground().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLClassification(){
        return this.safeXML(getClassification());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCodeAvail(){
        return this.safeXML(getCodeAvail());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLConstraints(){
        return this.safeXML(getConstraints());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCpSystem(){
        return this.safeXML(getCpSystem());
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

    String toXMLCrossrefStatus(){
        return this.getCrossrefStatus().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLDataAvail(){
        return this.safeXML(getDataAvail());
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

    String toXMLDoiStatus(){
        return this.getDoiStatus().toString();
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

    String toXMLLocalCopy(){
        return this.safeXML(getLocalCopy());
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

    String toXMLNrCitationsCovered(){
        return this.getNrCitationsCovered().toString();
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

    String toXMLNrPages(){
        return this.getNrPages().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLNrReferences(){
        return this.getNrReferences().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLNrReferencesCovered(){
        return this.getNrReferencesCovered().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLPages(){
        return this.safeXML(getPages());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLPercentCitationsCovered(){
        return this.getPercentCitationsCovered().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLPercentReferencesCovered(){
        return this.getPercentReferencesCovered().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLRelatedTo(){
        return this.safeXML(getRelatedTo());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLScopusCitations(){
        return this.getScopusCitations().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLScopusStatus(){
        return this.getScopusStatus().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLSolutionAvail(){
        return this.safeXML(getSolutionAvail());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLSourceGroup(){
        return "ID_"+this.getSourceGroup().getId().toString();
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

    String toXMLYear(){
        return this.getYear().toString();
    }

/**
 * find the same object in another dataset
 * @param a Work item we are looking for
 * @param bList List<Work> list of items in which we are searching
 * @return Work entry of list b which is applicationSame() to a
*/

    public static Work find(Work a, List<Work> bList){
        for(Work b : bList){
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
 * @param name Work name of the object we are looking for
 * @return Work entry of the dataset with the given name; otherwise null
*/

    public static Work findByName(ApplicationDataset base, String name){
        for(Work a:base.getListWork()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        return null;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Work first entry in the dataset of this type; null if that does not exists
*/

    public static Work findFirst(ApplicationDataset base){
        if (base.getListWork().isEmpty()) {
            return null;
        }
        return base.getListWork().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Work some entry in the dataset of this type; null if that does not exists
*/

    public static Work findAny(ApplicationDataset base){
        int size=base.getListWork().size();
        if (size > 0) {
             return base.getListWork().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Work last entry in the dataset of this type; null if that does not exists
*/

    public static Work findLast(ApplicationDataset base){
        int size=base.getListWork().size();
        if (size > 0) {
             return base.getListWork().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b Work compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(Work b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b Work compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(Work b){
      if(!this.getAuthor().equals(b.getAuthor())){
         System.out.println("Author");
        }
      if (true) {         System.out.println("Authors");
        }
      if(!this.getBackground().equals(b.getBackground())){
         System.out.println("Background");
        }
      if(!this.getClassification().equals(b.getClassification())){
         System.out.println("Classification");
        }
      if(!this.getCodeAvail().equals(b.getCodeAvail())){
         System.out.println("CodeAvail");
        }
      if(!this.getConstraints().equals(b.getConstraints())){
         System.out.println("Constraints");
        }
      if(!this.getCpSystem().equals(b.getCpSystem())){
         System.out.println("CpSystem");
        }
      if(!this.getCrossrefCitations().equals(b.getCrossrefCitations())){
         System.out.println("CrossrefCitations");
        }
      if(!this.getCrossrefReferences().equals(b.getCrossrefReferences())){
         System.out.println("CrossrefReferences");
        }
      if(!this.getCrossrefStatus().equals(b.getCrossrefStatus())){
         System.out.println("CrossrefStatus");
        }
      if(!this.getDataAvail().equals(b.getDataAvail())){
         System.out.println("DataAvail");
        }
      if(!this.getDoi().equals(b.getDoi())){
         System.out.println("Doi");
        }
      if(!this.getDoiStatus().equals(b.getDoiStatus())){
         System.out.println("DoiStatus");
        }
      if(!this.getKey().equals(b.getKey())){
         System.out.println("Key");
        }
      if(!this.getLocalCopy().equals(b.getLocalCopy())){
         System.out.println("LocalCopy");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getNrCitations().equals(b.getNrCitations())){
         System.out.println("NrCitations");
        }
      if(!this.getNrCitationsCovered().equals(b.getNrCitationsCovered())){
         System.out.println("NrCitationsCovered");
        }
      if(!this.getNrLinks().equals(b.getNrLinks())){
         System.out.println("NrLinks");
        }
      if(!this.getNrPages().equals(b.getNrPages())){
         System.out.println("NrPages");
        }
      if(!this.getNrReferences().equals(b.getNrReferences())){
         System.out.println("NrReferences");
        }
      if(!this.getNrReferencesCovered().equals(b.getNrReferencesCovered())){
         System.out.println("NrReferencesCovered");
        }
      if(!this.getPages().equals(b.getPages())){
         System.out.println("Pages");
        }
      if(!this.getPercentCitationsCovered().equals(b.getPercentCitationsCovered())){
         System.out.println("PercentCitationsCovered");
        }
      if(!this.getPercentReferencesCovered().equals(b.getPercentReferencesCovered())){
         System.out.println("PercentReferencesCovered");
        }
      if(!this.getRelatedTo().equals(b.getRelatedTo())){
         System.out.println("RelatedTo");
        }
      if(!this.getScopusCitations().equals(b.getScopusCitations())){
         System.out.println("ScopusCitations");
        }
      if(!this.getScopusStatus().equals(b.getScopusStatus())){
         System.out.println("ScopusStatus");
        }
      if(!this.getSolutionAvail().equals(b.getSolutionAvail())){
         System.out.println("SolutionAvail");
        }
      if(!this.getSourceGroup().applicationSame(b.getSourceGroup())){
         System.out.println("SourceGroup");
        }
      if(!this.getTitle().equals(b.getTitle())){
         System.out.println("Title");
        }
      if(!this.getUrl().equals(b.getUrl())){
         System.out.println("Url");
        }
      if(!this.getYear().equals(b.getYear())){
         System.out.println("Year");
        }
        return  this.getAuthor().equals(b.getAuthor()) &&
          true &&
          this.getBackground().equals(b.getBackground()) &&
          this.getClassification().equals(b.getClassification()) &&
          this.getCodeAvail().equals(b.getCodeAvail()) &&
          this.getConstraints().equals(b.getConstraints()) &&
          this.getCpSystem().equals(b.getCpSystem()) &&
          this.getCrossrefCitations().equals(b.getCrossrefCitations()) &&
          this.getCrossrefReferences().equals(b.getCrossrefReferences()) &&
          this.getCrossrefStatus().equals(b.getCrossrefStatus()) &&
          this.getDataAvail().equals(b.getDataAvail()) &&
          this.getDoi().equals(b.getDoi()) &&
          this.getDoiStatus().equals(b.getDoiStatus()) &&
          this.getKey().equals(b.getKey()) &&
          this.getLocalCopy().equals(b.getLocalCopy()) &&
          this.getName().equals(b.getName()) &&
          this.getNrCitations().equals(b.getNrCitations()) &&
          this.getNrCitationsCovered().equals(b.getNrCitationsCovered()) &&
          this.getNrLinks().equals(b.getNrLinks()) &&
          this.getNrPages().equals(b.getNrPages()) &&
          this.getNrReferences().equals(b.getNrReferences()) &&
          this.getNrReferencesCovered().equals(b.getNrReferencesCovered()) &&
          this.getPages().equals(b.getPages()) &&
          this.getPercentCitationsCovered().equals(b.getPercentCitationsCovered()) &&
          this.getPercentReferencesCovered().equals(b.getPercentReferencesCovered()) &&
          this.getRelatedTo().equals(b.getRelatedTo()) &&
          this.getScopusCitations().equals(b.getScopusCitations()) &&
          this.getScopusStatus().equals(b.getScopusStatus()) &&
          this.getSolutionAvail().equals(b.getSolutionAvail()) &&
          this.getSourceGroup().applicationSame(b.getSourceGroup()) &&
          this.getTitle().equals(b.getTitle()) &&
          this.getUrl().equals(b.getUrl()) &&
          this.getYear().equals(b.getYear());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","Work",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getAuthors() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"authors","Work",(getAuthors()==null?"null":getAuthors().toString()),"",WarningType.NOTNULL);
        }
        if (getAuthors().size() == 0){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"authors","Work",(getAuthors()==null?"null":getAuthors().toString()),"",WarningType.NOTEMPTY);
        }
        if (getSourceGroup() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"sourceGroup","Work",(getSourceGroup()==null?"null":getSourceGroup().toString()),"",WarningType.NOTNULL);
        }
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
      if (attrName.equals("sourceGroup")){
         return (List) ((Scenario)base).getListSourceGroup();
      }
      return null;
   }

}
