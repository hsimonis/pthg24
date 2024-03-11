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
import org.insightcentre.pthg24.datamodel.Authorship;
import org.insightcentre.pthg24.datamodel.Proceedings;
import org.insightcentre.pthg24.datamodel.Journal;
import org.insightcentre.pthg24.datamodel.School;
import org.insightcentre.pthg24.datamodel.Collection;
import org.insightcentre.pthg24.datamodel.ConceptWork;
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
 * This is an abstract base class for the dataset description. Each application should derive one class from this to describe a dataset in the application. Most of the time, we will only use one dataset at a time.
 * @author generated
*/

public abstract class ApplicationDataset implements ApplicationDatasetInterface,Comparable<ApplicationDataset>{
/**
 *  Marks the dataset as dirty, there are unsaved modifications.
 *
*/

    public Boolean dirty;

    private transient BooleanProperty dirtyWrapper;

/**
 *  Id number of the dataset, required as this item is not an ApplicationObject.
 *
*/

    public Integer id;

/**
 *  Name of the datase. This is required as the item is not an ApplicationObject.
 *
*/

    public String name;

/**
 *  Marks the dataset as valid, when the solver has been run and no other data has been changed.
 *
*/

    public Boolean valid;

    private transient BooleanProperty validWrapper;

/**
 *  This lists holds all items of class ApplicationDataset and its subclasses
 *
*/

    List<ApplicationDataset> listApplicationDataset = new ArrayList<ApplicationDataset>();

/**
 *  This lists holds all items of class ApplicationObject and its subclasses
 *
*/

    List<ApplicationObject> listApplicationObject = new ArrayList<ApplicationObject>();

/**
 *  This lists holds all items of class ApplicationDifference and its subclasses
 *
*/

    List<ApplicationDifference> listApplicationDifference = new ArrayList<ApplicationDifference>();

/**
 *  This lists holds all items of class ApplicationWarning and its subclasses
 *
*/

    List<ApplicationWarning> listApplicationWarning = new ArrayList<ApplicationWarning>();

/**
 *  This lists holds all items of class Scenario and its subclasses
 *
*/

    List<Scenario> listScenario = new ArrayList<Scenario>();

/**
 *  This lists holds all items of class Concept and its subclasses
 *
*/

    List<Concept> listConcept = new ArrayList<Concept>();

/**
 *  This lists holds all items of class Author and its subclasses
 *
*/

    List<Author> listAuthor = new ArrayList<Author>();

/**
 *  This lists holds all items of class Work and its subclasses
 *
*/

    List<Work> listWork = new ArrayList<Work>();

/**
 *  This lists holds all items of class Paper and its subclasses
 *
*/

    List<Paper> listPaper = new ArrayList<Paper>();

/**
 *  This lists holds all items of class Article and its subclasses
 *
*/

    List<Article> listArticle = new ArrayList<Article>();

/**
 *  This lists holds all items of class PhDThesis and its subclasses
 *
*/

    List<PhDThesis> listPhDThesis = new ArrayList<PhDThesis>();

/**
 *  This lists holds all items of class InCollection and its subclasses
 *
*/

    List<InCollection> listInCollection = new ArrayList<InCollection>();

/**
 *  This lists holds all items of class Authorship and its subclasses
 *
*/

    List<Authorship> listAuthorship = new ArrayList<Authorship>();

/**
 *  This lists holds all items of class Proceedings and its subclasses
 *
*/

    List<Proceedings> listProceedings = new ArrayList<Proceedings>();

/**
 *  This lists holds all items of class Journal and its subclasses
 *
*/

    List<Journal> listJournal = new ArrayList<Journal>();

/**
 *  This lists holds all items of class School and its subclasses
 *
*/

    List<School> listSchool = new ArrayList<School>();

/**
 *  This lists holds all items of class Collection and its subclasses
 *
*/

    List<Collection> listCollection = new ArrayList<Collection>();

/**
 *  This lists holds all items of class ConceptWork and its subclasses
 *
*/

    List<ConceptWork> listConceptWork = new ArrayList<ConceptWork>();

/**
 *  This is the static counter from which all id numbers are generated.It is used by all classes, so that ids are unique over all objects.
 *
*/

    private static int idNr=0;

public int compareTo(ApplicationDataset ds2){
    return id.compareTo(ds2.getId());
}

/**
 *  No-arg constructor for use in TableView
 *
*/

    public ApplicationDataset(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public ApplicationDataset(ApplicationDataset applicationDataset){
        setId(ApplicationDataset.getIdNr());
        setName("");
        addApplicationDataset(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public ApplicationDataset(Boolean dirty,
            Integer id,
            String name,
            Boolean valid){
        setDirty(dirty);
        setId(id);
        setName(name);
        setValid(valid);
        addApplicationDataset(this);
    }

    public Boolean remove(){
        // ignored, you can not remove a dataset like this
        return true;
    }

/**
 *  get attribute dirty
 *
 * @return Boolean
*/

    public Boolean getDirty(){
        return this.dirty;
    }

    public BooleanProperty dirtyWrapperProperty() {
        if (dirtyWrapper == null) {
            dirtyWrapper = new SimpleBooleanProperty();
        }
        dirtyWrapper.set(dirty);
        return dirtyWrapper;
    }

/**
 *  get attribute id
 *
 * @return Integer
*/

    public Integer getId(){
        return this.id;
    }

/**
 *  get attribute name
 *
 * @return String
*/

    public String getName(){
        return this.name;
    }

/**
 *  get attribute valid
 *
 * @return Boolean
*/

    public Boolean getValid(){
        return this.valid;
    }

    public BooleanProperty validWrapperProperty() {
        if (validWrapper == null) {
            validWrapper = new SimpleBooleanProperty();
        }
        validWrapper.set(valid);
        return validWrapper;
    }

/**
 *  implement the ApplicationObjectInterface
 *
*/

    public ApplicationDataset getApplicationDataset() {
        return this;
    }

    public List<String> getListOfClassNames(){
        return Arrays.asList("ApplicationDifference",
                             "ApplicationWarning",
                             "Article",
                             "Author",
                             "Authorship",
                             "Collection",
                             "Concept",
                             "ConceptWork",
                             "InCollection",
                             "Journal",
                             "Paper",
                             "PhDThesis",
                             "Proceedings",
                             "Scenario",
                             "School");
    }

/**
 *  Iterator for list of class ApplicationDataset
 *
*/

    public Iterator<ApplicationDataset> getIteratorApplicationDataset(){
        return listApplicationDataset.iterator();
    }

/**
 *  Getter for list of class ApplicationDataset
 *
*/

    public List<ApplicationDataset> getListApplicationDataset(){
        return listApplicationDataset;
    }

/**
 *  reset the list of class ApplicationDataset; use with care, does not call cascades
 *
*/

    public void resetListApplicationDataset(){
        listApplicationDataset = new ArrayList<ApplicationDataset>();
        resetListScenario();
    }

/**
 *  Iterator for list of class ApplicationObject
 *
*/

    public Iterator<ApplicationObject> getIteratorApplicationObject(){
        return listApplicationObject.iterator();
    }

/**
 *  Getter for list of class ApplicationObject
 *
*/

    public List<ApplicationObject> getListApplicationObject(){
        return listApplicationObject;
    }

/**
 *  reset the list of class ApplicationObject; use with care, does not call cascades
 *
*/

    public void resetListApplicationObject(){
        listApplicationObject = new ArrayList<ApplicationObject>();
        resetListApplicationWarning();
        resetListApplicationDifference();
        resetListConcept();
        resetListAuthor();
        resetListWork();
        resetListPaper();
        resetListArticle();
        resetListPhDThesis();
        resetListInCollection();
        resetListAuthorship();
        resetListProceedings();
        resetListJournal();
        resetListSchool();
        resetListCollection();
        resetListConceptWork();
    }

/**
 *  Iterator for list of class ApplicationDifference
 *
*/

    public Iterator<ApplicationDifference> getIteratorApplicationDifference(){
        return listApplicationDifference.iterator();
    }

/**
 *  Getter for list of class ApplicationDifference
 *
*/

    public List<ApplicationDifference> getListApplicationDifference(){
        return listApplicationDifference;
    }

/**
 *  reset the list of class ApplicationDifference; use with care, does not call cascades
 *
*/

    public void resetListApplicationDifference(){
        listApplicationDifference = new ArrayList<ApplicationDifference>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof ApplicationDifference)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class ApplicationWarning
 *
*/

    public Iterator<ApplicationWarning> getIteratorApplicationWarning(){
        return listApplicationWarning.iterator();
    }

/**
 *  Getter for list of class ApplicationWarning
 *
*/

    public List<ApplicationWarning> getListApplicationWarning(){
        return listApplicationWarning;
    }

/**
 *  reset the list of class ApplicationWarning; use with care, does not call cascades
 *
*/

    public void resetListApplicationWarning(){
        listApplicationWarning = new ArrayList<ApplicationWarning>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof ApplicationWarning)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class Scenario
 *
*/

    public Iterator<Scenario> getIteratorScenario(){
        return listScenario.iterator();
    }

/**
 *  Getter for list of class Scenario
 *
*/

    public List<Scenario> getListScenario(){
        return listScenario;
    }

/**
 *  reset the list of class Scenario; use with care, does not call cascades
 *
*/

    public void resetListScenario(){
        listScenario = new ArrayList<Scenario>();
        List<ApplicationDataset> newListApplicationDataset = new ArrayList<ApplicationDataset>();
        for(ApplicationDataset a:listApplicationDataset){
            if (!(a instanceof Scenario)){
                newListApplicationDataset.add(a);
            }
        }
       listApplicationDataset = newListApplicationDataset;
    }

/**
 *  Iterator for list of class Concept
 *
*/

    public Iterator<Concept> getIteratorConcept(){
        return listConcept.iterator();
    }

/**
 *  Getter for list of class Concept
 *
*/

    public List<Concept> getListConcept(){
        return listConcept;
    }

/**
 *  reset the list of class Concept; use with care, does not call cascades
 *
*/

    public void resetListConcept(){
        listConcept = new ArrayList<Concept>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof Concept)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class Author
 *
*/

    public Iterator<Author> getIteratorAuthor(){
        return listAuthor.iterator();
    }

/**
 *  Getter for list of class Author
 *
*/

    public List<Author> getListAuthor(){
        return listAuthor;
    }

/**
 *  reset the list of class Author; use with care, does not call cascades
 *
*/

    public void resetListAuthor(){
        listAuthor = new ArrayList<Author>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof Author)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class Work
 *
*/

    public Iterator<Work> getIteratorWork(){
        return listWork.iterator();
    }

/**
 *  Getter for list of class Work
 *
*/

    public List<Work> getListWork(){
        return listWork;
    }

/**
 *  reset the list of class Work; use with care, does not call cascades
 *
*/

    public void resetListWork(){
        listWork = new ArrayList<Work>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof Work)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
        resetListPaper();
        resetListArticle();
        resetListPhDThesis();
        resetListInCollection();
    }

/**
 *  Iterator for list of class Paper
 *
*/

    public Iterator<Paper> getIteratorPaper(){
        return listPaper.iterator();
    }

/**
 *  Getter for list of class Paper
 *
*/

    public List<Paper> getListPaper(){
        return listPaper;
    }

/**
 *  reset the list of class Paper; use with care, does not call cascades
 *
*/

    public void resetListPaper(){
        listPaper = new ArrayList<Paper>();
        List<Work> newListWork = new ArrayList<Work>();
        for(Work a:listWork){
            if (!(a instanceof Paper)){
                newListWork.add(a);
            }
        }
       listWork = newListWork;
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof Paper)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class Article
 *
*/

    public Iterator<Article> getIteratorArticle(){
        return listArticle.iterator();
    }

/**
 *  Getter for list of class Article
 *
*/

    public List<Article> getListArticle(){
        return listArticle;
    }

/**
 *  reset the list of class Article; use with care, does not call cascades
 *
*/

    public void resetListArticle(){
        listArticle = new ArrayList<Article>();
        List<Work> newListWork = new ArrayList<Work>();
        for(Work a:listWork){
            if (!(a instanceof Article)){
                newListWork.add(a);
            }
        }
       listWork = newListWork;
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof Article)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class PhDThesis
 *
*/

    public Iterator<PhDThesis> getIteratorPhDThesis(){
        return listPhDThesis.iterator();
    }

/**
 *  Getter for list of class PhDThesis
 *
*/

    public List<PhDThesis> getListPhDThesis(){
        return listPhDThesis;
    }

/**
 *  reset the list of class PhDThesis; use with care, does not call cascades
 *
*/

    public void resetListPhDThesis(){
        listPhDThesis = new ArrayList<PhDThesis>();
        List<Work> newListWork = new ArrayList<Work>();
        for(Work a:listWork){
            if (!(a instanceof PhDThesis)){
                newListWork.add(a);
            }
        }
       listWork = newListWork;
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof PhDThesis)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class InCollection
 *
*/

    public Iterator<InCollection> getIteratorInCollection(){
        return listInCollection.iterator();
    }

/**
 *  Getter for list of class InCollection
 *
*/

    public List<InCollection> getListInCollection(){
        return listInCollection;
    }

/**
 *  reset the list of class InCollection; use with care, does not call cascades
 *
*/

    public void resetListInCollection(){
        listInCollection = new ArrayList<InCollection>();
        List<Work> newListWork = new ArrayList<Work>();
        for(Work a:listWork){
            if (!(a instanceof InCollection)){
                newListWork.add(a);
            }
        }
       listWork = newListWork;
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof InCollection)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class Authorship
 *
*/

    public Iterator<Authorship> getIteratorAuthorship(){
        return listAuthorship.iterator();
    }

/**
 *  Getter for list of class Authorship
 *
*/

    public List<Authorship> getListAuthorship(){
        return listAuthorship;
    }

/**
 *  reset the list of class Authorship; use with care, does not call cascades
 *
*/

    public void resetListAuthorship(){
        listAuthorship = new ArrayList<Authorship>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof Authorship)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class Proceedings
 *
*/

    public Iterator<Proceedings> getIteratorProceedings(){
        return listProceedings.iterator();
    }

/**
 *  Getter for list of class Proceedings
 *
*/

    public List<Proceedings> getListProceedings(){
        return listProceedings;
    }

/**
 *  reset the list of class Proceedings; use with care, does not call cascades
 *
*/

    public void resetListProceedings(){
        listProceedings = new ArrayList<Proceedings>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof Proceedings)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class Journal
 *
*/

    public Iterator<Journal> getIteratorJournal(){
        return listJournal.iterator();
    }

/**
 *  Getter for list of class Journal
 *
*/

    public List<Journal> getListJournal(){
        return listJournal;
    }

/**
 *  reset the list of class Journal; use with care, does not call cascades
 *
*/

    public void resetListJournal(){
        listJournal = new ArrayList<Journal>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof Journal)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class School
 *
*/

    public Iterator<School> getIteratorSchool(){
        return listSchool.iterator();
    }

/**
 *  Getter for list of class School
 *
*/

    public List<School> getListSchool(){
        return listSchool;
    }

/**
 *  reset the list of class School; use with care, does not call cascades
 *
*/

    public void resetListSchool(){
        listSchool = new ArrayList<School>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof School)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class Collection
 *
*/

    public Iterator<Collection> getIteratorCollection(){
        return listCollection.iterator();
    }

/**
 *  Getter for list of class Collection
 *
*/

    public List<Collection> getListCollection(){
        return listCollection;
    }

/**
 *  reset the list of class Collection; use with care, does not call cascades
 *
*/

    public void resetListCollection(){
        listCollection = new ArrayList<Collection>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof Collection)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class ConceptWork
 *
*/

    public Iterator<ConceptWork> getIteratorConceptWork(){
        return listConceptWork.iterator();
    }

/**
 *  Getter for list of class ConceptWork
 *
*/

    public List<ConceptWork> getListConceptWork(){
        return listConceptWork;
    }

/**
 *  reset the list of class ConceptWork; use with care, does not call cascades
 *
*/

    public void resetListConceptWork(){
        listConceptWork = new ArrayList<ConceptWork>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof ConceptWork)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Generate a new id number, used in constructor calls
 *
*/

    public static int getIdNr() {
        return idNr++;
    }

    public static void setIdNr(int value) {
        idNr = value;
    }

    public int lastIdNr(){
        int res = 0;
        for(ApplicationObject obj:getListApplicationObject()){
            res = Math.max(res,obj.getId());
        }
        return res;
    }

/**
 *  set attribute dirty, mark dataset as dirty, mark dataset as not valid
@param dirty Boolean
 *
*/

    public void setDirty(Boolean dirty){
        this.dirty = dirty;
    }

/**
 *  set attribute id, mark dataset as dirty, mark dataset as not valid
@param id Integer
 *
*/

    public void setId(Integer id){
        this.id = id;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute name, mark dataset as dirty, mark dataset as not valid
@param name String
 *
*/

    public void setName(String name){
        this.name = name;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute valid, mark dataset as dirty, mark dataset as not valid
@param valid Boolean
 *
*/

    public void setValid(Boolean valid){
        this.valid = valid;
    }

/**
 *  inc attribute id, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incId(){
        this.id++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  Removing object item of class ApplicationDataset; remove all dependent objects of class ApplicationObject which refer to item through their attribute applicationDataset
 *
*/

    public void cascadeApplicationObjectApplicationDataset(ApplicationDataset item){
        assert item != null;
        List<ApplicationObject> toRemove = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:getListApplicationObject()) {
         if (a.getApplicationDataset() == item) {
            toRemove.add(a);
         }
        }
        for(ApplicationObject b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class Author; remove all dependent objects of class Work which refer to item through their attribute authors
 *
*/

    public void cascadeWorkAuthors(Author item){
        assert item != null;
        List<Work> toRemove = new ArrayList<Work>();
        for(Work a:getListWork()) {
         if (a.getAuthors().contains(item)) {
            a.getAuthors().remove(item);
            if (a.getAuthors().isEmpty()) {
               toRemove.add(a);
            }
         }
        }
        for(Work b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class Journal; remove all dependent objects of class Article which refer to item through their attribute journal
 *
*/

    public void cascadeArticleJournal(Journal item){
        assert item != null;
        List<Article> toRemove = new ArrayList<Article>();
        for(Article a:getListArticle()) {
         if (a.getJournal() == item) {
            toRemove.add(a);
         }
        }
        for(Article b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class Proceedings; remove all dependent objects of class Paper which refer to item through their attribute proceedings
 *
*/

    public void cascadePaperProceedings(Proceedings item){
        assert item != null;
        List<Paper> toRemove = new ArrayList<Paper>();
        for(Paper a:getListPaper()) {
         if (a.getProceedings() == item) {
            toRemove.add(a);
         }
        }
        for(Paper b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class School; remove all dependent objects of class PhDThesis which refer to item through their attribute school
 *
*/

    public void cascadePhDThesisSchool(School item){
        assert item != null;
        List<PhDThesis> toRemove = new ArrayList<PhDThesis>();
        for(PhDThesis a:getListPhDThesis()) {
         if (a.getSchool() == item) {
            toRemove.add(a);
         }
        }
        for(PhDThesis b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class Collection; remove all dependent objects of class InCollection which refer to item through their attribute collection
 *
*/

    public void cascadeInCollectionCollection(Collection item){
        assert item != null;
        List<InCollection> toRemove = new ArrayList<InCollection>();
        for(InCollection a:getListInCollection()) {
         if (a.getCollection() == item) {
            toRemove.add(a);
         }
        }
        for(InCollection b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class Author; remove all dependent objects of class Authorship which refer to item through their attribute author
 *
*/

    public void cascadeAuthorshipAuthor(Author item){
        assert item != null;
        List<Authorship> toRemove = new ArrayList<Authorship>();
        for(Authorship a:getListAuthorship()) {
         if (a.getAuthor() == item) {
            toRemove.add(a);
         }
        }
        for(Authorship b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class Work; remove all dependent objects of class Authorship which refer to item through their attribute work
 *
*/

    public void cascadeAuthorshipWork(Work item){
        assert item != null;
        List<Authorship> toRemove = new ArrayList<Authorship>();
        for(Authorship a:getListAuthorship()) {
         if (a.getWork() == item) {
            toRemove.add(a);
         }
        }
        for(Authorship b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class Concept; remove all dependent objects of class ConceptWork which refer to item through their attribute concept
 *
*/

    public void cascadeConceptWorkConcept(Concept item){
        assert item != null;
        List<ConceptWork> toRemove = new ArrayList<ConceptWork>();
        for(ConceptWork a:getListConceptWork()) {
         if (a.getConcept() == item) {
            toRemove.add(a);
         }
        }
        for(ConceptWork b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class Work; remove all dependent objects of class ConceptWork which refer to item through their attribute work
 *
*/

    public void cascadeConceptWorkWork(Work item){
        assert item != null;
        List<ConceptWork> toRemove = new ArrayList<ConceptWork>();
        for(ConceptWork a:getListConceptWork()) {
         if (a.getWork() == item) {
            toRemove.add(a);
         }
        }
        for(ConceptWork b:toRemove) {
            b.remove();
        }
    }

/**
 *  add an item to the list for class ApplicationDataset
 *
*/

    public void addApplicationDataset(ApplicationDataset applicationDataset){
        assert applicationDataset != null;
        this.listApplicationDataset.add(applicationDataset);
    }

/**
 *  remove an item from the list for class ApplicationDataset
 *
*/

    public Boolean removeApplicationDataset(ApplicationDataset applicationDataset){
        assert applicationDataset != null;
        return this.listApplicationDataset.remove(applicationDataset);
    }

/**
 *  add an item to the list for class ApplicationObject
 *
*/

    public void addApplicationObject(ApplicationObject applicationObject){
        assert applicationObject != null;
        this.listApplicationObject.add(applicationObject);
    }

/**
 *  remove an item from the list for class ApplicationObject
 *
*/

    public Boolean removeApplicationObject(ApplicationObject applicationObject){
        assert applicationObject != null;
        return this.listApplicationObject.remove(applicationObject);
    }

/**
 *  add an item to the list for class ApplicationDifference
 *
*/

    public void addApplicationDifference(ApplicationDifference applicationDifference){
        assert applicationDifference != null;
        this.listApplicationDifference.add(applicationDifference);
    }

/**
 *  remove an item from the list for class ApplicationDifference
 *
*/

    public Boolean removeApplicationDifference(ApplicationDifference applicationDifference){
        assert applicationDifference != null;
        return this.listApplicationDifference.remove(applicationDifference);
    }

/**
 *  add an item to the list for class ApplicationWarning
 *
*/

    public void addApplicationWarning(ApplicationWarning applicationWarning){
        assert applicationWarning != null;
        this.listApplicationWarning.add(applicationWarning);
    }

/**
 *  remove an item from the list for class ApplicationWarning
 *
*/

    public Boolean removeApplicationWarning(ApplicationWarning applicationWarning){
        assert applicationWarning != null;
        return this.listApplicationWarning.remove(applicationWarning);
    }

/**
 *  add an item to the list for class Scenario
 *
*/

    public void addScenario(Scenario scenario){
        assert scenario != null;
        this.listScenario.add(scenario);
    }

/**
 *  remove an item from the list for class Scenario
 *
*/

    public Boolean removeScenario(Scenario scenario){
        assert scenario != null;
        return this.listScenario.remove(scenario);
    }

/**
 *  add an item to the list for class Concept
 *
*/

    public void addConcept(Concept concept){
        assert concept != null;
        this.listConcept.add(concept);
    }

/**
 *  remove an item from the list for class Concept
 *
*/

    public Boolean removeConcept(Concept concept){
        assert concept != null;
        return this.listConcept.remove(concept);
    }

/**
 *  add an item to the list for class Author
 *
*/

    public void addAuthor(Author author){
        assert author != null;
        this.listAuthor.add(author);
    }

/**
 *  remove an item from the list for class Author
 *
*/

    public Boolean removeAuthor(Author author){
        assert author != null;
        return this.listAuthor.remove(author);
    }

/**
 *  add an item to the list for class Work
 *
*/

    public void addWork(Work work){
        assert work != null;
        this.listWork.add(work);
    }

/**
 *  remove an item from the list for class Work
 *
*/

    public Boolean removeWork(Work work){
        assert work != null;
        return this.listWork.remove(work);
    }

/**
 *  add an item to the list for class Paper
 *
*/

    public void addPaper(Paper paper){
        assert paper != null;
        this.listPaper.add(paper);
    }

/**
 *  remove an item from the list for class Paper
 *
*/

    public Boolean removePaper(Paper paper){
        assert paper != null;
        return this.listPaper.remove(paper);
    }

/**
 *  add an item to the list for class Article
 *
*/

    public void addArticle(Article article){
        assert article != null;
        this.listArticle.add(article);
    }

/**
 *  remove an item from the list for class Article
 *
*/

    public Boolean removeArticle(Article article){
        assert article != null;
        return this.listArticle.remove(article);
    }

/**
 *  add an item to the list for class PhDThesis
 *
*/

    public void addPhDThesis(PhDThesis phDThesis){
        assert phDThesis != null;
        this.listPhDThesis.add(phDThesis);
    }

/**
 *  remove an item from the list for class PhDThesis
 *
*/

    public Boolean removePhDThesis(PhDThesis phDThesis){
        assert phDThesis != null;
        return this.listPhDThesis.remove(phDThesis);
    }

/**
 *  add an item to the list for class InCollection
 *
*/

    public void addInCollection(InCollection inCollection){
        assert inCollection != null;
        this.listInCollection.add(inCollection);
    }

/**
 *  remove an item from the list for class InCollection
 *
*/

    public Boolean removeInCollection(InCollection inCollection){
        assert inCollection != null;
        return this.listInCollection.remove(inCollection);
    }

/**
 *  add an item to the list for class Authorship
 *
*/

    public void addAuthorship(Authorship authorship){
        assert authorship != null;
        this.listAuthorship.add(authorship);
    }

/**
 *  remove an item from the list for class Authorship
 *
*/

    public Boolean removeAuthorship(Authorship authorship){
        assert authorship != null;
        return this.listAuthorship.remove(authorship);
    }

/**
 *  add an item to the list for class Proceedings
 *
*/

    public void addProceedings(Proceedings proceedings){
        assert proceedings != null;
        this.listProceedings.add(proceedings);
    }

/**
 *  remove an item from the list for class Proceedings
 *
*/

    public Boolean removeProceedings(Proceedings proceedings){
        assert proceedings != null;
        return this.listProceedings.remove(proceedings);
    }

/**
 *  add an item to the list for class Journal
 *
*/

    public void addJournal(Journal journal){
        assert journal != null;
        this.listJournal.add(journal);
    }

/**
 *  remove an item from the list for class Journal
 *
*/

    public Boolean removeJournal(Journal journal){
        assert journal != null;
        return this.listJournal.remove(journal);
    }

/**
 *  add an item to the list for class School
 *
*/

    public void addSchool(School school){
        assert school != null;
        this.listSchool.add(school);
    }

/**
 *  remove an item from the list for class School
 *
*/

    public Boolean removeSchool(School school){
        assert school != null;
        return this.listSchool.remove(school);
    }

/**
 *  add an item to the list for class Collection
 *
*/

    public void addCollection(Collection collection){
        assert collection != null;
        this.listCollection.add(collection);
    }

/**
 *  remove an item from the list for class Collection
 *
*/

    public Boolean removeCollection(Collection collection){
        assert collection != null;
        return this.listCollection.remove(collection);
    }

/**
 *  add an item to the list for class ConceptWork
 *
*/

    public void addConceptWork(ConceptWork conceptWork){
        assert conceptWork != null;
        this.listConceptWork.add(conceptWork);
    }

/**
 *  remove an item from the list for class ConceptWork
 *
*/

    public Boolean removeConceptWork(ConceptWork conceptWork){
        assert conceptWork != null;
        return this.listConceptWork.remove(conceptWork);
    }

/**
 *  dump all items on the console for debugging
 *
*/

    public void dump(){
        for(ApplicationDifference x:getListApplicationDifference()){
            System.out.println(x);
        }
        for(ApplicationWarning x:getListApplicationWarning()){
            System.out.println(x);
        }
        for(Article x:getListArticle()){
            System.out.println(x);
        }
        for(Author x:getListAuthor()){
            System.out.println(x);
        }
        for(Authorship x:getListAuthorship()){
            System.out.println(x);
        }
        for(Collection x:getListCollection()){
            System.out.println(x);
        }
        for(Concept x:getListConcept()){
            System.out.println(x);
        }
        for(ConceptWork x:getListConceptWork()){
            System.out.println(x);
        }
        for(InCollection x:getListInCollection()){
            System.out.println(x);
        }
        for(Journal x:getListJournal()){
            System.out.println(x);
        }
        for(Paper x:getListPaper()){
            System.out.println(x);
        }
        for(PhDThesis x:getListPhDThesis()){
            System.out.println(x);
        }
        for(Proceedings x:getListProceedings()){
            System.out.println(x);
        }
        for(Scenario x:getListScenario()){
            System.out.println(x);
        }
        for(School x:getListSchool()){
            System.out.println(x);
        }
    }

    public String getReport(String settings){
        StringWriter out = new StringWriter();
        out.write("<html><head><title>Report</title></head><body>");
        out.write("</body></html>");
        return out.toString();
    }

    public String safeXML(String s){
        String res=s;
        res = res.replaceAll("&","&amp;");
        res = res.replaceAll("<","&lt;");
        res = res.replaceAll(">","&gt;");
        res = res.replaceAll("\"","&quot;");
        res = res.replaceAll("'","&apos;");
        return res;
    }
/**
 *  dump all items in XML format to a file
 *
*/

    public void dumpAsXML(String fileName){
        PrintWriter out=null;
        try {
    	      File f = new File(fileName);
    	      out = new PrintWriter(new FileWriter(f));
    	  } catch (IOException e) {
    	      System.out.println("Can not create file: "+fileName);
    	  }
        out.println("<?xml version=\"1.0\" ?>");
        out.println("<body xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"test.xsd\">");
        for(Scenario x:getListScenario()){
            if (x.getClass().equals(Scenario.class)) x.toXML(out);
        }
        for(ApplicationDifference x:getListApplicationDifference()){
            if (x.getClass().equals(ApplicationDifference.class)) x.toXML(out);
        }
        for(ApplicationWarning x:getListApplicationWarning()){
            if (x.getClass().equals(ApplicationWarning.class)) x.toXML(out);
        }
        for(Article x:getListArticle()){
            if (x.getClass().equals(Article.class)) x.toXML(out);
        }
        for(Author x:getListAuthor()){
            if (x.getClass().equals(Author.class)) x.toXML(out);
        }
        for(Authorship x:getListAuthorship()){
            if (x.getClass().equals(Authorship.class)) x.toXML(out);
        }
        for(Collection x:getListCollection()){
            if (x.getClass().equals(Collection.class)) x.toXML(out);
        }
        for(Concept x:getListConcept()){
            if (x.getClass().equals(Concept.class)) x.toXML(out);
        }
        for(ConceptWork x:getListConceptWork()){
            if (x.getClass().equals(ConceptWork.class)) x.toXML(out);
        }
        for(InCollection x:getListInCollection()){
            if (x.getClass().equals(InCollection.class)) x.toXML(out);
        }
        for(Journal x:getListJournal()){
            if (x.getClass().equals(Journal.class)) x.toXML(out);
        }
        for(Paper x:getListPaper()){
            if (x.getClass().equals(Paper.class)) x.toXML(out);
        }
        for(PhDThesis x:getListPhDThesis()){
            if (x.getClass().equals(PhDThesis.class)) x.toXML(out);
        }
        for(Proceedings x:getListProceedings()){
            if (x.getClass().equals(Proceedings.class)) x.toXML(out);
        }
        for(School x:getListSchool()){
            if (x.getClass().equals(School.class)) x.toXML(out);
        }
        out.println("</body>");
        out.close();
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
        return getDirty()+ " " +getId()+ " " +getName()+ " " +getValid();
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
         out.println("<applicationDataset "+ " dirty=\""+toXMLDirty()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " valid=\""+toXMLValid()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLDirty(){
        return this.getDirty().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLId(){
        return "ID_"+this.getId();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLName(){
        return this.safeXML(getName());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLValid(){
        return this.getValid().toString();
    }

/**
 * compare object to another of the same type, create ApplicationWarnings if they differ
*/

    public void compare(ApplicationDatasetInterface c){
        ApplicationDataset compare = (ApplicationDataset) c;
        System.out.println("Comparing ApplicationDataset");
        compareApplicationWarning(this.getListApplicationWarning(),compare.getListApplicationWarning());
        compareArticle(this.getListArticle(),compare.getListArticle());
        compareAuthor(this.getListAuthor(),compare.getListAuthor());
        compareAuthorship(this.getListAuthorship(),compare.getListAuthorship());
        compareCollection(this.getListCollection(),compare.getListCollection());
        compareConcept(this.getListConcept(),compare.getListConcept());
        compareConceptWork(this.getListConceptWork(),compare.getListConceptWork());
        compareInCollection(this.getListInCollection(),compare.getListInCollection());
        compareJournal(this.getListJournal(),compare.getListJournal());
        comparePaper(this.getListPaper(),compare.getListPaper());
        comparePhDThesis(this.getListPhDThesis(),compare.getListPhDThesis());
        compareProceedings(this.getListProceedings(),compare.getListProceedings());
        compareSchool(this.getListSchool(),compare.getListSchool());
        System.out.println("Done Comparing ApplicationDataset");
    }

/**
 * compare two lists of types ApplicationWarning, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareApplicationWarning(List<ApplicationWarning> aList,List<ApplicationWarning> bList){
        System.out.println("Comparing ApplicationWarning");
        for(ApplicationWarning a:aList){
            ApplicationWarning b= ApplicationWarning.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"ApplicationWarning A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"ApplicationWarning A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"ApplicationWarning B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(ApplicationWarning b: bList){
            ApplicationWarning a = ApplicationWarning.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"ApplicationWarning B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types Article, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareArticle(List<Article> aList,List<Article> bList){
        System.out.println("Comparing Article");
        for(Article a:aList){
            Article b= Article.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Article A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Article A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Article B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(Article b: bList){
            Article a = Article.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Article B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types Author, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareAuthor(List<Author> aList,List<Author> bList){
        System.out.println("Comparing Author");
        for(Author a:aList){
            Author b= Author.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Author A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Author A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Author B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(Author b: bList){
            Author a = Author.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Author B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types Authorship, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareAuthorship(List<Authorship> aList,List<Authorship> bList){
        System.out.println("Comparing Authorship");
        for(Authorship a:aList){
            Authorship b= Authorship.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Authorship A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Authorship A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Authorship B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(Authorship b: bList){
            Authorship a = Authorship.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Authorship B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types Collection, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareCollection(List<Collection> aList,List<Collection> bList){
        System.out.println("Comparing Collection");
        for(Collection a:aList){
            Collection b= Collection.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Collection A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Collection A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Collection B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(Collection b: bList){
            Collection a = Collection.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Collection B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types Concept, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareConcept(List<Concept> aList,List<Concept> bList){
        System.out.println("Comparing Concept");
        for(Concept a:aList){
            Concept b= Concept.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Concept A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Concept A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Concept B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(Concept b: bList){
            Concept a = Concept.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Concept B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types ConceptWork, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareConceptWork(List<ConceptWork> aList,List<ConceptWork> bList){
        System.out.println("Comparing ConceptWork");
        for(ConceptWork a:aList){
            ConceptWork b= ConceptWork.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"ConceptWork A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"ConceptWork A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"ConceptWork B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(ConceptWork b: bList){
            ConceptWork a = ConceptWork.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"ConceptWork B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types InCollection, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareInCollection(List<InCollection> aList,List<InCollection> bList){
        System.out.println("Comparing InCollection");
        for(InCollection a:aList){
            InCollection b= InCollection.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"InCollection A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"InCollection A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"InCollection B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(InCollection b: bList){
            InCollection a = InCollection.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"InCollection B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types Journal, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareJournal(List<Journal> aList,List<Journal> bList){
        System.out.println("Comparing Journal");
        for(Journal a:aList){
            Journal b= Journal.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Journal A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Journal A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Journal B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(Journal b: bList){
            Journal a = Journal.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Journal B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types Paper, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void comparePaper(List<Paper> aList,List<Paper> bList){
        System.out.println("Comparing Paper");
        for(Paper a:aList){
            Paper b= Paper.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Paper A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Paper A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Paper B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(Paper b: bList){
            Paper a = Paper.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Paper B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types PhDThesis, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void comparePhDThesis(List<PhDThesis> aList,List<PhDThesis> bList){
        System.out.println("Comparing PhDThesis");
        for(PhDThesis a:aList){
            PhDThesis b= PhDThesis.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"PhDThesis A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"PhDThesis A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"PhDThesis B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(PhDThesis b: bList){
            PhDThesis a = PhDThesis.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"PhDThesis B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types Proceedings, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareProceedings(List<Proceedings> aList,List<Proceedings> bList){
        System.out.println("Comparing Proceedings");
        for(Proceedings a:aList){
            Proceedings b= Proceedings.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Proceedings A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Proceedings A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Proceedings B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(Proceedings b: bList){
            Proceedings a = Proceedings.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Proceedings B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types School, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareSchool(List<School> aList,List<School> bList){
        System.out.println("Comparing School");
        for(School a:aList){
            School b= School.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"School A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"School A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"School B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(School b: bList){
            School a = School.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"School B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * check all objects in dataset for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void checkAll(){
        checkApplicationWarning(this.getListApplicationWarning());
        checkArticle(this.getListArticle());
        checkAuthor(this.getListAuthor());
        checkAuthorship(this.getListAuthorship());
        checkCollection(this.getListCollection());
        checkConcept(this.getListConcept());
        checkConceptWork(this.getListConceptWork());
        checkInCollection(this.getListInCollection());
        checkJournal(this.getListJournal());
        checkPaper(this.getListPaper());
        checkPhDThesis(this.getListPhDThesis());
        checkProceedings(this.getListProceedings());
        checkScenario(this.getListScenario());
        checkSchool(this.getListSchool());
    }

/**
 * helper method for checkAll()
 * @param list List<ApplicationWarning> dataset list of all items of type ApplicationWarning
*/

    public void checkApplicationWarning(List<ApplicationWarning> list){
        for(ApplicationWarning a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<Article> dataset list of all items of type Article
*/

    public void checkArticle(List<Article> list){
        for(Article a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<Author> dataset list of all items of type Author
*/

    public void checkAuthor(List<Author> list){
        for(Author a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<Authorship> dataset list of all items of type Authorship
*/

    public void checkAuthorship(List<Authorship> list){
        for(Authorship a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<Collection> dataset list of all items of type Collection
*/

    public void checkCollection(List<Collection> list){
        for(Collection a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<Concept> dataset list of all items of type Concept
*/

    public void checkConcept(List<Concept> list){
        for(Concept a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<ConceptWork> dataset list of all items of type ConceptWork
*/

    public void checkConceptWork(List<ConceptWork> list){
        for(ConceptWork a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<InCollection> dataset list of all items of type InCollection
*/

    public void checkInCollection(List<InCollection> list){
        for(InCollection a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<Journal> dataset list of all items of type Journal
*/

    public void checkJournal(List<Journal> list){
        for(Journal a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<Paper> dataset list of all items of type Paper
*/

    public void checkPaper(List<Paper> list){
        for(Paper a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<PhDThesis> dataset list of all items of type PhDThesis
*/

    public void checkPhDThesis(List<PhDThesis> list){
        for(PhDThesis a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<Proceedings> dataset list of all items of type Proceedings
*/

    public void checkProceedings(List<Proceedings> list){
        for(Proceedings a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<Scenario> dataset list of all items of type Scenario
*/

    public void checkScenario(List<Scenario> list){
        for(Scenario a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<School> dataset list of all items of type School
*/

    public void checkSchool(List<School> list){
        for(School a:list){
            a.check();
        }
    }

   public void generateDummies(){
        ApplicationDifference.dummy(this);
        ApplicationWarning.dummy(this);
        Article.dummy(this);
        Author.dummy(this);
        Authorship.dummy(this);
        Collection.dummy(this);
        Concept.dummy(this);
        ConceptWork.dummy(this);
        InCollection.dummy(this);
        Journal.dummy(this);
        Paper.dummy(this);
        PhDThesis.dummy(this);
        Proceedings.dummy(this);
        Scenario.dummy(this);
        School.dummy(this);
   }

/**
 *  This method states if the class depends on the solver.
 *
*/

    public static Boolean isSolverDependent(){
        return false;
    }

   public List<ApplicationObjectInterface> getFeasibleValues(ApplicationDatasetInterface base,String attrName){
      return null;
   }

}
