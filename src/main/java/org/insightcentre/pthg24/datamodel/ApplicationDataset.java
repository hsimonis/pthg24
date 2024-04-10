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
 *  This lists holds all items of class InBook and its subclasses
 *
*/

    List<InBook> listInBook = new ArrayList<InBook>();

/**
 *  This lists holds all items of class Book and its subclasses
 *
*/

    List<Book> listBook = new ArrayList<Book>();

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
 *  This lists holds all items of class ConferenceSeries and its subclasses
 *
*/

    List<ConferenceSeries> listConferenceSeries = new ArrayList<ConferenceSeries>();

/**
 *  This lists holds all items of class Journal and its subclasses
 *
*/

    List<Journal> listJournal = new ArrayList<Journal>();

/**
 *  This lists holds all items of class JournalAlias and its subclasses
 *
*/

    List<JournalAlias> listJournalAlias = new ArrayList<JournalAlias>();

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
 *  This lists holds all items of class Citation and its subclasses
 *
*/

    List<Citation> listCitation = new ArrayList<Citation>();

/**
 *  This lists holds all items of class Reference and its subclasses
 *
*/

    List<Reference> listReference = new ArrayList<Reference>();

/**
 *  This lists holds all items of class MissingCitingWork and its subclasses
 *
*/

    List<MissingCitingWork> listMissingCitingWork = new ArrayList<MissingCitingWork>();

/**
 *  This lists holds all items of class MissingCitedWork and its subclasses
 *
*/

    List<MissingCitedWork> listMissingCitedWork = new ArrayList<MissingCitedWork>();

/**
 *  This lists holds all items of class MissingWork and its subclasses
 *
*/

    List<MissingWork> listMissingWork = new ArrayList<MissingWork>();

/**
 *  This lists holds all items of class Coauthor and its subclasses
 *
*/

    List<Coauthor> listCoauthor = new ArrayList<Coauthor>();

/**
 *  This lists holds all items of class Similarity and its subclasses
 *
*/

    List<Similarity> listSimilarity = new ArrayList<Similarity>();

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
                             "Book",
                             "Citation",
                             "Coauthor",
                             "Collection",
                             "Concept",
                             "ConceptWork",
                             "ConferenceSeries",
                             "InBook",
                             "InCollection",
                             "Journal",
                             "JournalAlias",
                             "MissingCitedWork",
                             "MissingCitingWork",
                             "MissingWork",
                             "Paper",
                             "PhDThesis",
                             "Proceedings",
                             "Reference",
                             "Scenario",
                             "School",
                             "Similarity");
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
        resetListInBook();
        resetListBook();
        resetListAuthorship();
        resetListProceedings();
        resetListConferenceSeries();
        resetListJournal();
        resetListJournalAlias();
        resetListSchool();
        resetListCollection();
        resetListConceptWork();
        resetListCitation();
        resetListReference();
        resetListMissingCitingWork();
        resetListMissingCitedWork();
        resetListMissingWork();
        resetListCoauthor();
        resetListSimilarity();
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
        resetListInBook();
        resetListBook();
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
 *  Iterator for list of class InBook
 *
*/

    public Iterator<InBook> getIteratorInBook(){
        return listInBook.iterator();
    }

/**
 *  Getter for list of class InBook
 *
*/

    public List<InBook> getListInBook(){
        return listInBook;
    }

/**
 *  reset the list of class InBook; use with care, does not call cascades
 *
*/

    public void resetListInBook(){
        listInBook = new ArrayList<InBook>();
        List<Work> newListWork = new ArrayList<Work>();
        for(Work a:listWork){
            if (!(a instanceof InBook)){
                newListWork.add(a);
            }
        }
       listWork = newListWork;
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof InBook)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class Book
 *
*/

    public Iterator<Book> getIteratorBook(){
        return listBook.iterator();
    }

/**
 *  Getter for list of class Book
 *
*/

    public List<Book> getListBook(){
        return listBook;
    }

/**
 *  reset the list of class Book; use with care, does not call cascades
 *
*/

    public void resetListBook(){
        listBook = new ArrayList<Book>();
        List<Work> newListWork = new ArrayList<Work>();
        for(Work a:listWork){
            if (!(a instanceof Book)){
                newListWork.add(a);
            }
        }
       listWork = newListWork;
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof Book)){
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
 *  Iterator for list of class ConferenceSeries
 *
*/

    public Iterator<ConferenceSeries> getIteratorConferenceSeries(){
        return listConferenceSeries.iterator();
    }

/**
 *  Getter for list of class ConferenceSeries
 *
*/

    public List<ConferenceSeries> getListConferenceSeries(){
        return listConferenceSeries;
    }

/**
 *  reset the list of class ConferenceSeries; use with care, does not call cascades
 *
*/

    public void resetListConferenceSeries(){
        listConferenceSeries = new ArrayList<ConferenceSeries>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof ConferenceSeries)){
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
 *  Iterator for list of class JournalAlias
 *
*/

    public Iterator<JournalAlias> getIteratorJournalAlias(){
        return listJournalAlias.iterator();
    }

/**
 *  Getter for list of class JournalAlias
 *
*/

    public List<JournalAlias> getListJournalAlias(){
        return listJournalAlias;
    }

/**
 *  reset the list of class JournalAlias; use with care, does not call cascades
 *
*/

    public void resetListJournalAlias(){
        listJournalAlias = new ArrayList<JournalAlias>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof JournalAlias)){
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
 *  Iterator for list of class Citation
 *
*/

    public Iterator<Citation> getIteratorCitation(){
        return listCitation.iterator();
    }

/**
 *  Getter for list of class Citation
 *
*/

    public List<Citation> getListCitation(){
        return listCitation;
    }

/**
 *  reset the list of class Citation; use with care, does not call cascades
 *
*/

    public void resetListCitation(){
        listCitation = new ArrayList<Citation>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof Citation)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class Reference
 *
*/

    public Iterator<Reference> getIteratorReference(){
        return listReference.iterator();
    }

/**
 *  Getter for list of class Reference
 *
*/

    public List<Reference> getListReference(){
        return listReference;
    }

/**
 *  reset the list of class Reference; use with care, does not call cascades
 *
*/

    public void resetListReference(){
        listReference = new ArrayList<Reference>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof Reference)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class MissingCitingWork
 *
*/

    public Iterator<MissingCitingWork> getIteratorMissingCitingWork(){
        return listMissingCitingWork.iterator();
    }

/**
 *  Getter for list of class MissingCitingWork
 *
*/

    public List<MissingCitingWork> getListMissingCitingWork(){
        return listMissingCitingWork;
    }

/**
 *  reset the list of class MissingCitingWork; use with care, does not call cascades
 *
*/

    public void resetListMissingCitingWork(){
        listMissingCitingWork = new ArrayList<MissingCitingWork>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof MissingCitingWork)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class MissingCitedWork
 *
*/

    public Iterator<MissingCitedWork> getIteratorMissingCitedWork(){
        return listMissingCitedWork.iterator();
    }

/**
 *  Getter for list of class MissingCitedWork
 *
*/

    public List<MissingCitedWork> getListMissingCitedWork(){
        return listMissingCitedWork;
    }

/**
 *  reset the list of class MissingCitedWork; use with care, does not call cascades
 *
*/

    public void resetListMissingCitedWork(){
        listMissingCitedWork = new ArrayList<MissingCitedWork>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof MissingCitedWork)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class MissingWork
 *
*/

    public Iterator<MissingWork> getIteratorMissingWork(){
        return listMissingWork.iterator();
    }

/**
 *  Getter for list of class MissingWork
 *
*/

    public List<MissingWork> getListMissingWork(){
        return listMissingWork;
    }

/**
 *  reset the list of class MissingWork; use with care, does not call cascades
 *
*/

    public void resetListMissingWork(){
        listMissingWork = new ArrayList<MissingWork>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof MissingWork)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class Coauthor
 *
*/

    public Iterator<Coauthor> getIteratorCoauthor(){
        return listCoauthor.iterator();
    }

/**
 *  Getter for list of class Coauthor
 *
*/

    public List<Coauthor> getListCoauthor(){
        return listCoauthor;
    }

/**
 *  reset the list of class Coauthor; use with care, does not call cascades
 *
*/

    public void resetListCoauthor(){
        listCoauthor = new ArrayList<Coauthor>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof Coauthor)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class Similarity
 *
*/

    public Iterator<Similarity> getIteratorSimilarity(){
        return listSimilarity.iterator();
    }

/**
 *  Getter for list of class Similarity
 *
*/

    public List<Similarity> getListSimilarity(){
        return listSimilarity;
    }

/**
 *  reset the list of class Similarity; use with care, does not call cascades
 *
*/

    public void resetListSimilarity(){
        listSimilarity = new ArrayList<Similarity>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof Similarity)){
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
 *  Removing object item of class ConferenceSeries; remove all dependent objects of class Proceedings which refer to item through their attribute conferenceSeries
 *
*/

    public void cascadeProceedingsConferenceSeries(ConferenceSeries item){
        assert item != null;
        List<Proceedings> toRemove = new ArrayList<Proceedings>();
        for(Proceedings a:getListProceedings()) {
         if (a.getConferenceSeries() == item) {
            toRemove.add(a);
         }
        }
        for(Proceedings b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class Journal; remove all dependent objects of class JournalAlias which refer to item through their attribute journal
 *
*/

    public void cascadeJournalAliasJournal(Journal item){
        assert item != null;
        List<JournalAlias> toRemove = new ArrayList<JournalAlias>();
        for(JournalAlias a:getListJournalAlias()) {
         if (a.getJournal() == item) {
            toRemove.add(a);
         }
        }
        for(JournalAlias b:toRemove) {
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
 *  Removing object item of class Work; remove all dependent objects of class Citation which refer to item through their attribute citedWork
 *
*/

    public void cascadeCitationCitedWork(Work item){
        assert item != null;
        List<Citation> toRemove = new ArrayList<Citation>();
        for(Citation a:getListCitation()) {
         if (a.getCitedWork() == item) {
            toRemove.add(a);
         }
        }
        for(Citation b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class Work; remove all dependent objects of class Citation which refer to item through their attribute citingWork
 *
*/

    public void cascadeCitationCitingWork(Work item){
        assert item != null;
        List<Citation> toRemove = new ArrayList<Citation>();
        for(Citation a:getListCitation()) {
         if (a.getCitingWork() == item) {
            toRemove.add(a);
         }
        }
        for(Citation b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class Work; remove all dependent objects of class Reference which refer to item through their attribute citedWork
 *
*/

    public void cascadeReferenceCitedWork(Work item){
        assert item != null;
        List<Reference> toRemove = new ArrayList<Reference>();
        for(Reference a:getListReference()) {
         if (a.getCitedWork() == item) {
            toRemove.add(a);
         }
        }
        for(Reference b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class Work; remove all dependent objects of class Reference which refer to item through their attribute citingWork
 *
*/

    public void cascadeReferenceCitingWork(Work item){
        assert item != null;
        List<Reference> toRemove = new ArrayList<Reference>();
        for(Reference a:getListReference()) {
         if (a.getCitingWork() == item) {
            toRemove.add(a);
         }
        }
        for(Reference b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class Author; remove all dependent objects of class Coauthor which refer to item through their attribute author1
 *
*/

    public void cascadeCoauthorAuthor1(Author item){
        assert item != null;
        List<Coauthor> toRemove = new ArrayList<Coauthor>();
        for(Coauthor a:getListCoauthor()) {
         if (a.getAuthor1() == item) {
            toRemove.add(a);
         }
        }
        for(Coauthor b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class Author; remove all dependent objects of class Coauthor which refer to item through their attribute author2
 *
*/

    public void cascadeCoauthorAuthor2(Author item){
        assert item != null;
        List<Coauthor> toRemove = new ArrayList<Coauthor>();
        for(Coauthor a:getListCoauthor()) {
         if (a.getAuthor2() == item) {
            toRemove.add(a);
         }
        }
        for(Coauthor b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class Work; remove all dependent objects of class Similarity which refer to item through their attribute work1
 *
*/

    public void cascadeSimilarityWork1(Work item){
        assert item != null;
        List<Similarity> toRemove = new ArrayList<Similarity>();
        for(Similarity a:getListSimilarity()) {
         if (a.getWork1() == item) {
            toRemove.add(a);
         }
        }
        for(Similarity b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class Work; remove all dependent objects of class Similarity which refer to item through their attribute work2
 *
*/

    public void cascadeSimilarityWork2(Work item){
        assert item != null;
        List<Similarity> toRemove = new ArrayList<Similarity>();
        for(Similarity a:getListSimilarity()) {
         if (a.getWork2() == item) {
            toRemove.add(a);
         }
        }
        for(Similarity b:toRemove) {
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
 *  add an item to the list for class InBook
 *
*/

    public void addInBook(InBook inBook){
        assert inBook != null;
        this.listInBook.add(inBook);
    }

/**
 *  remove an item from the list for class InBook
 *
*/

    public Boolean removeInBook(InBook inBook){
        assert inBook != null;
        return this.listInBook.remove(inBook);
    }

/**
 *  add an item to the list for class Book
 *
*/

    public void addBook(Book book){
        assert book != null;
        this.listBook.add(book);
    }

/**
 *  remove an item from the list for class Book
 *
*/

    public Boolean removeBook(Book book){
        assert book != null;
        return this.listBook.remove(book);
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
 *  add an item to the list for class ConferenceSeries
 *
*/

    public void addConferenceSeries(ConferenceSeries conferenceSeries){
        assert conferenceSeries != null;
        this.listConferenceSeries.add(conferenceSeries);
    }

/**
 *  remove an item from the list for class ConferenceSeries
 *
*/

    public Boolean removeConferenceSeries(ConferenceSeries conferenceSeries){
        assert conferenceSeries != null;
        return this.listConferenceSeries.remove(conferenceSeries);
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
 *  add an item to the list for class JournalAlias
 *
*/

    public void addJournalAlias(JournalAlias journalAlias){
        assert journalAlias != null;
        this.listJournalAlias.add(journalAlias);
    }

/**
 *  remove an item from the list for class JournalAlias
 *
*/

    public Boolean removeJournalAlias(JournalAlias journalAlias){
        assert journalAlias != null;
        return this.listJournalAlias.remove(journalAlias);
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
 *  add an item to the list for class Citation
 *
*/

    public void addCitation(Citation citation){
        assert citation != null;
        this.listCitation.add(citation);
    }

/**
 *  remove an item from the list for class Citation
 *
*/

    public Boolean removeCitation(Citation citation){
        assert citation != null;
        return this.listCitation.remove(citation);
    }

/**
 *  add an item to the list for class Reference
 *
*/

    public void addReference(Reference reference){
        assert reference != null;
        this.listReference.add(reference);
    }

/**
 *  remove an item from the list for class Reference
 *
*/

    public Boolean removeReference(Reference reference){
        assert reference != null;
        return this.listReference.remove(reference);
    }

/**
 *  add an item to the list for class MissingCitingWork
 *
*/

    public void addMissingCitingWork(MissingCitingWork missingCitingWork){
        assert missingCitingWork != null;
        this.listMissingCitingWork.add(missingCitingWork);
    }

/**
 *  remove an item from the list for class MissingCitingWork
 *
*/

    public Boolean removeMissingCitingWork(MissingCitingWork missingCitingWork){
        assert missingCitingWork != null;
        return this.listMissingCitingWork.remove(missingCitingWork);
    }

/**
 *  add an item to the list for class MissingCitedWork
 *
*/

    public void addMissingCitedWork(MissingCitedWork missingCitedWork){
        assert missingCitedWork != null;
        this.listMissingCitedWork.add(missingCitedWork);
    }

/**
 *  remove an item from the list for class MissingCitedWork
 *
*/

    public Boolean removeMissingCitedWork(MissingCitedWork missingCitedWork){
        assert missingCitedWork != null;
        return this.listMissingCitedWork.remove(missingCitedWork);
    }

/**
 *  add an item to the list for class MissingWork
 *
*/

    public void addMissingWork(MissingWork missingWork){
        assert missingWork != null;
        this.listMissingWork.add(missingWork);
    }

/**
 *  remove an item from the list for class MissingWork
 *
*/

    public Boolean removeMissingWork(MissingWork missingWork){
        assert missingWork != null;
        return this.listMissingWork.remove(missingWork);
    }

/**
 *  add an item to the list for class Coauthor
 *
*/

    public void addCoauthor(Coauthor coauthor){
        assert coauthor != null;
        this.listCoauthor.add(coauthor);
    }

/**
 *  remove an item from the list for class Coauthor
 *
*/

    public Boolean removeCoauthor(Coauthor coauthor){
        assert coauthor != null;
        return this.listCoauthor.remove(coauthor);
    }

/**
 *  add an item to the list for class Similarity
 *
*/

    public void addSimilarity(Similarity similarity){
        assert similarity != null;
        this.listSimilarity.add(similarity);
    }

/**
 *  remove an item from the list for class Similarity
 *
*/

    public Boolean removeSimilarity(Similarity similarity){
        assert similarity != null;
        return this.listSimilarity.remove(similarity);
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
        for(Book x:getListBook()){
            System.out.println(x);
        }
        for(Citation x:getListCitation()){
            System.out.println(x);
        }
        for(Coauthor x:getListCoauthor()){
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
        for(ConferenceSeries x:getListConferenceSeries()){
            System.out.println(x);
        }
        for(InBook x:getListInBook()){
            System.out.println(x);
        }
        for(InCollection x:getListInCollection()){
            System.out.println(x);
        }
        for(Journal x:getListJournal()){
            System.out.println(x);
        }
        for(JournalAlias x:getListJournalAlias()){
            System.out.println(x);
        }
        for(MissingCitedWork x:getListMissingCitedWork()){
            System.out.println(x);
        }
        for(MissingCitingWork x:getListMissingCitingWork()){
            System.out.println(x);
        }
        for(MissingWork x:getListMissingWork()){
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
        for(Reference x:getListReference()){
            System.out.println(x);
        }
        for(Scenario x:getListScenario()){
            System.out.println(x);
        }
        for(School x:getListSchool()){
            System.out.println(x);
        }
        for(Similarity x:getListSimilarity()){
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
        for(Book x:getListBook()){
            if (x.getClass().equals(Book.class)) x.toXML(out);
        }
        for(Citation x:getListCitation()){
            if (x.getClass().equals(Citation.class)) x.toXML(out);
        }
        for(Coauthor x:getListCoauthor()){
            if (x.getClass().equals(Coauthor.class)) x.toXML(out);
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
        for(ConferenceSeries x:getListConferenceSeries()){
            if (x.getClass().equals(ConferenceSeries.class)) x.toXML(out);
        }
        for(InBook x:getListInBook()){
            if (x.getClass().equals(InBook.class)) x.toXML(out);
        }
        for(InCollection x:getListInCollection()){
            if (x.getClass().equals(InCollection.class)) x.toXML(out);
        }
        for(Journal x:getListJournal()){
            if (x.getClass().equals(Journal.class)) x.toXML(out);
        }
        for(JournalAlias x:getListJournalAlias()){
            if (x.getClass().equals(JournalAlias.class)) x.toXML(out);
        }
        for(MissingCitedWork x:getListMissingCitedWork()){
            if (x.getClass().equals(MissingCitedWork.class)) x.toXML(out);
        }
        for(MissingCitingWork x:getListMissingCitingWork()){
            if (x.getClass().equals(MissingCitingWork.class)) x.toXML(out);
        }
        for(MissingWork x:getListMissingWork()){
            if (x.getClass().equals(MissingWork.class)) x.toXML(out);
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
        for(Reference x:getListReference()){
            if (x.getClass().equals(Reference.class)) x.toXML(out);
        }
        for(School x:getListSchool()){
            if (x.getClass().equals(School.class)) x.toXML(out);
        }
        for(Similarity x:getListSimilarity()){
            if (x.getClass().equals(Similarity.class)) x.toXML(out);
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
        compareBook(this.getListBook(),compare.getListBook());
        compareCitation(this.getListCitation(),compare.getListCitation());
        compareCoauthor(this.getListCoauthor(),compare.getListCoauthor());
        compareCollection(this.getListCollection(),compare.getListCollection());
        compareConcept(this.getListConcept(),compare.getListConcept());
        compareConceptWork(this.getListConceptWork(),compare.getListConceptWork());
        compareConferenceSeries(this.getListConferenceSeries(),compare.getListConferenceSeries());
        compareInBook(this.getListInBook(),compare.getListInBook());
        compareInCollection(this.getListInCollection(),compare.getListInCollection());
        compareJournal(this.getListJournal(),compare.getListJournal());
        compareJournalAlias(this.getListJournalAlias(),compare.getListJournalAlias());
        compareMissingCitedWork(this.getListMissingCitedWork(),compare.getListMissingCitedWork());
        compareMissingCitingWork(this.getListMissingCitingWork(),compare.getListMissingCitingWork());
        compareMissingWork(this.getListMissingWork(),compare.getListMissingWork());
        comparePaper(this.getListPaper(),compare.getListPaper());
        comparePhDThesis(this.getListPhDThesis(),compare.getListPhDThesis());
        compareProceedings(this.getListProceedings(),compare.getListProceedings());
        compareReference(this.getListReference(),compare.getListReference());
        compareSchool(this.getListSchool(),compare.getListSchool());
        compareSimilarity(this.getListSimilarity(),compare.getListSimilarity());
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
 * compare two lists of types Book, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareBook(List<Book> aList,List<Book> bList){
        System.out.println("Comparing Book");
        for(Book a:aList){
            Book b= Book.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Book A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Book A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Book B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(Book b: bList){
            Book a = Book.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Book B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types Citation, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareCitation(List<Citation> aList,List<Citation> bList){
        System.out.println("Comparing Citation");
        for(Citation a:aList){
            Citation b= Citation.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Citation A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Citation A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Citation B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(Citation b: bList){
            Citation a = Citation.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Citation B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types Coauthor, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareCoauthor(List<Coauthor> aList,List<Coauthor> bList){
        System.out.println("Comparing Coauthor");
        for(Coauthor a:aList){
            Coauthor b= Coauthor.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Coauthor A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Coauthor A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Coauthor B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(Coauthor b: bList){
            Coauthor a = Coauthor.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Coauthor B",b.toString(),DifferenceType.ONLYB);
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
 * compare two lists of types ConferenceSeries, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareConferenceSeries(List<ConferenceSeries> aList,List<ConferenceSeries> bList){
        System.out.println("Comparing ConferenceSeries");
        for(ConferenceSeries a:aList){
            ConferenceSeries b= ConferenceSeries.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"ConferenceSeries A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"ConferenceSeries A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"ConferenceSeries B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(ConferenceSeries b: bList){
            ConferenceSeries a = ConferenceSeries.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"ConferenceSeries B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types InBook, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareInBook(List<InBook> aList,List<InBook> bList){
        System.out.println("Comparing InBook");
        for(InBook a:aList){
            InBook b= InBook.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"InBook A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"InBook A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"InBook B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(InBook b: bList){
            InBook a = InBook.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"InBook B",b.toString(),DifferenceType.ONLYB);
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
 * compare two lists of types JournalAlias, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareJournalAlias(List<JournalAlias> aList,List<JournalAlias> bList){
        System.out.println("Comparing JournalAlias");
        for(JournalAlias a:aList){
            JournalAlias b= JournalAlias.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"JournalAlias A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"JournalAlias A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"JournalAlias B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(JournalAlias b: bList){
            JournalAlias a = JournalAlias.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"JournalAlias B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types MissingCitedWork, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareMissingCitedWork(List<MissingCitedWork> aList,List<MissingCitedWork> bList){
        System.out.println("Comparing MissingCitedWork");
        for(MissingCitedWork a:aList){
            MissingCitedWork b= MissingCitedWork.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"MissingCitedWork A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"MissingCitedWork A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"MissingCitedWork B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(MissingCitedWork b: bList){
            MissingCitedWork a = MissingCitedWork.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"MissingCitedWork B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types MissingCitingWork, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareMissingCitingWork(List<MissingCitingWork> aList,List<MissingCitingWork> bList){
        System.out.println("Comparing MissingCitingWork");
        for(MissingCitingWork a:aList){
            MissingCitingWork b= MissingCitingWork.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"MissingCitingWork A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"MissingCitingWork A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"MissingCitingWork B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(MissingCitingWork b: bList){
            MissingCitingWork a = MissingCitingWork.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"MissingCitingWork B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types MissingWork, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareMissingWork(List<MissingWork> aList,List<MissingWork> bList){
        System.out.println("Comparing MissingWork");
        for(MissingWork a:aList){
            MissingWork b= MissingWork.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"MissingWork A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"MissingWork A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"MissingWork B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(MissingWork b: bList){
            MissingWork a = MissingWork.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"MissingWork B",b.toString(),DifferenceType.ONLYB);
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
 * compare two lists of types Reference, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareReference(List<Reference> aList,List<Reference> bList){
        System.out.println("Comparing Reference");
        for(Reference a:aList){
            Reference b= Reference.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Reference A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Reference A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Reference B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(Reference b: bList){
            Reference a = Reference.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Reference B",b.toString(),DifferenceType.ONLYB);
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
 * compare two lists of types Similarity, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareSimilarity(List<Similarity> aList,List<Similarity> bList){
        System.out.println("Comparing Similarity");
        for(Similarity a:aList){
            Similarity b= Similarity.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Similarity A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Similarity A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Similarity B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(Similarity b: bList){
            Similarity a = Similarity.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Similarity B",b.toString(),DifferenceType.ONLYB);
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
        checkBook(this.getListBook());
        checkCitation(this.getListCitation());
        checkCoauthor(this.getListCoauthor());
        checkCollection(this.getListCollection());
        checkConcept(this.getListConcept());
        checkConceptWork(this.getListConceptWork());
        checkConferenceSeries(this.getListConferenceSeries());
        checkInBook(this.getListInBook());
        checkInCollection(this.getListInCollection());
        checkJournal(this.getListJournal());
        checkJournalAlias(this.getListJournalAlias());
        checkMissingCitedWork(this.getListMissingCitedWork());
        checkMissingCitingWork(this.getListMissingCitingWork());
        checkMissingWork(this.getListMissingWork());
        checkPaper(this.getListPaper());
        checkPhDThesis(this.getListPhDThesis());
        checkProceedings(this.getListProceedings());
        checkReference(this.getListReference());
        checkScenario(this.getListScenario());
        checkSchool(this.getListSchool());
        checkSimilarity(this.getListSimilarity());
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
 * @param list List<Book> dataset list of all items of type Book
*/

    public void checkBook(List<Book> list){
        for(Book a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<Citation> dataset list of all items of type Citation
*/

    public void checkCitation(List<Citation> list){
        for(Citation a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<Coauthor> dataset list of all items of type Coauthor
*/

    public void checkCoauthor(List<Coauthor> list){
        for(Coauthor a:list){
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
 * @param list List<ConferenceSeries> dataset list of all items of type ConferenceSeries
*/

    public void checkConferenceSeries(List<ConferenceSeries> list){
        for(ConferenceSeries a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<InBook> dataset list of all items of type InBook
*/

    public void checkInBook(List<InBook> list){
        for(InBook a:list){
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
 * @param list List<JournalAlias> dataset list of all items of type JournalAlias
*/

    public void checkJournalAlias(List<JournalAlias> list){
        for(JournalAlias a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<MissingCitedWork> dataset list of all items of type MissingCitedWork
*/

    public void checkMissingCitedWork(List<MissingCitedWork> list){
        for(MissingCitedWork a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<MissingCitingWork> dataset list of all items of type MissingCitingWork
*/

    public void checkMissingCitingWork(List<MissingCitingWork> list){
        for(MissingCitingWork a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<MissingWork> dataset list of all items of type MissingWork
*/

    public void checkMissingWork(List<MissingWork> list){
        for(MissingWork a:list){
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
 * @param list List<Reference> dataset list of all items of type Reference
*/

    public void checkReference(List<Reference> list){
        for(Reference a:list){
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

/**
 * helper method for checkAll()
 * @param list List<Similarity> dataset list of all items of type Similarity
*/

    public void checkSimilarity(List<Similarity> list){
        for(Similarity a:list){
            a.check();
        }
    }

   public void generateDummies(){
        ApplicationDifference.dummy(this);
        ApplicationWarning.dummy(this);
        Article.dummy(this);
        Author.dummy(this);
        Authorship.dummy(this);
        Book.dummy(this);
        Citation.dummy(this);
        Coauthor.dummy(this);
        Collection.dummy(this);
        Concept.dummy(this);
        ConceptWork.dummy(this);
        ConferenceSeries.dummy(this);
        InBook.dummy(this);
        InCollection.dummy(this);
        Journal.dummy(this);
        JournalAlias.dummy(this);
        MissingCitedWork.dummy(this);
        MissingCitingWork.dummy(this);
        MissingWork.dummy(this);
        Paper.dummy(this);
        PhDThesis.dummy(this);
        Proceedings.dummy(this);
        Reference.dummy(this);
        Scenario.dummy(this);
        School.dummy(this);
        Similarity.dummy(this);
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
