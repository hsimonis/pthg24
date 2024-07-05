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
import org.insightcentre.pthg24.datamodel.Assertion;
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

public  class Paper extends Work{
/**
 *  
 *
*/

    public Proceedings proceedings;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public Paper(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public Paper(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setProceedings(null);
        applicationDataset.addPaper(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public Paper(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            String abstractText,
            String accepted,
            String author,
            List<Author> authors,
            Boolean background,
            String classification,
            Integer cluster,
            String codeAvail,
            List<Concept> concept,
            String constraints,
            String cpSystem,
            Integer crossrefCitations,
            Integer crossrefReferences,
            Boolean crossrefStatus,
            String dataAvail,
            Integer daysToAccept,
            Integer daysToPublish,
            String doi,
            Boolean doiStatus,
            String firstOnline,
            String issn,
            String key,
            String keywords,
            String language,
            String localCopy,
            Integer maxCitations,
            Integer nr,
            Integer nrCitations,
            Integer nrCitationsCovered,
            Integer nrConcepts,
            Integer nrEdges,
            Integer nrHyperLinks,
            Integer nrPages,
            Integer nrReferences,
            Integer nrReferencesCovered,
            String openAccess,
            OpenAccessType openAccessType,
            String pages,
            Double percentCitationsCovered,
            Double percentReferencesCovered,
            String published,
            Publisher publisher,
            Integer rangeCitations,
            String received,
            String relatedTo,
            Double relevanceAbstract,
            Double relevanceBody,
            Double relevanceTitle,
            String revised,
            Integer scopusCitations,
            Boolean scopusStatus,
            String shortName,
            String solutionAvail,
            SourceGroup sourceGroup,
            String title,
            String url,
            Integer wosCitations,
            Integer wosReferences,
            Boolean wosStatus,
            Integer year,
            Proceedings proceedings){
        super(applicationDataset,
            id,
            name,
            abstractText,
            accepted,
            author,
            authors,
            background,
            classification,
            cluster,
            codeAvail,
            concept,
            constraints,
            cpSystem,
            crossrefCitations,
            crossrefReferences,
            crossrefStatus,
            dataAvail,
            daysToAccept,
            daysToPublish,
            doi,
            doiStatus,
            firstOnline,
            issn,
            key,
            keywords,
            language,
            localCopy,
            maxCitations,
            nr,
            nrCitations,
            nrCitationsCovered,
            nrConcepts,
            nrEdges,
            nrHyperLinks,
            nrPages,
            nrReferences,
            nrReferencesCovered,
            openAccess,
            openAccessType,
            pages,
            percentCitationsCovered,
            percentReferencesCovered,
            published,
            publisher,
            rangeCitations,
            received,
            relatedTo,
            relevanceAbstract,
            relevanceBody,
            relevanceTitle,
            revised,
            scopusCitations,
            scopusStatus,
            shortName,
            solutionAvail,
            sourceGroup,
            title,
            url,
            wosCitations,
            wosReferences,
            wosStatus,
            year);
        setProceedings(proceedings);
        applicationDataset.addPaper(this);
    }

    public Paper(Paper other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.abstractText,
            other.accepted,
            other.author,
            other.authors,
            other.background,
            other.classification,
            other.cluster,
            other.codeAvail,
            other.concept,
            other.constraints,
            other.cpSystem,
            other.crossrefCitations,
            other.crossrefReferences,
            other.crossrefStatus,
            other.dataAvail,
            other.daysToAccept,
            other.daysToPublish,
            other.doi,
            other.doiStatus,
            other.firstOnline,
            other.issn,
            other.key,
            other.keywords,
            other.language,
            other.localCopy,
            other.maxCitations,
            other.nr,
            other.nrCitations,
            other.nrCitationsCovered,
            other.nrConcepts,
            other.nrEdges,
            other.nrHyperLinks,
            other.nrPages,
            other.nrReferences,
            other.nrReferencesCovered,
            other.openAccess,
            other.openAccessType,
            other.pages,
            other.percentCitationsCovered,
            other.percentReferencesCovered,
            other.published,
            other.publisher,
            other.rangeCitations,
            other.received,
            other.relatedTo,
            other.relevanceAbstract,
            other.relevanceBody,
            other.relevanceTitle,
            other.revised,
            other.scopusCitations,
            other.scopusStatus,
            other.shortName,
            other.solutionAvail,
            other.sourceGroup,
            other.title,
            other.url,
            other.wosCitations,
            other.wosReferences,
            other.wosStatus,
            other.year,
            other.proceedings);
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
        getApplicationDataset().cascadeCollabWorkWork(this);
        getApplicationDataset().cascadeAuthorDoubleWork1(this);
        getApplicationDataset().cascadeAuthorDoubleWork2(this);
        getApplicationDataset().cascadeAssertionWork(this);
        return getApplicationDataset().removePaper(this) && getApplicationDataset().removeWork(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute proceedings
 *
 * @return Proceedings
*/

    public Proceedings getProceedings(){
        return this.proceedings;
    }

/**
 *  set attribute proceedings, mark dataset as dirty, mark dataset as not valid
@param proceedings Proceedings
 *
*/

    public void setProceedings(Proceedings proceedings){
        this.proceedings = proceedings;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getAbstractText()+ " " +getAccepted()+ " " +getAuthor()+ " " +getAuthors()+ " " +getBackground()+ " " +getClassification()+ " " +getCluster()+ " " +getCodeAvail()+ " " +getConcept()+ " " +getConstraints()+ " " +getCpSystem()+ " " +getCrossrefCitations()+ " " +getCrossrefReferences()+ " " +getCrossrefStatus()+ " " +getDataAvail()+ " " +getDaysToAccept()+ " " +getDaysToPublish()+ " " +getDoi()+ " " +getDoiStatus()+ " " +getFirstOnline()+ " " +getIssn()+ " " +getKey()+ " " +getKeywords()+ " " +getLanguage()+ " " +getLocalCopy()+ " " +getMaxCitations()+ " " +getNr()+ " " +getNrCitations()+ " " +getNrCitationsCovered()+ " " +getNrConcepts()+ " " +getNrEdges()+ " " +getNrHyperLinks()+ " " +getNrPages()+ " " +getNrReferences()+ " " +getNrReferencesCovered()+ " " +getOpenAccess()+ " " +getOpenAccessType()+ " " +getPages()+ " " +getPercentCitationsCovered()+ " " +getPercentReferencesCovered()+ " " +getPublished()+ " " +getPublisher().toColumnString()+ " " +getRangeCitations()+ " " +getReceived()+ " " +getRelatedTo()+ " " +getRelevanceAbstract()+ " " +getRelevanceBody()+ " " +getRelevanceTitle()+ " " +getRevised()+ " " +getScopusCitations()+ " " +getScopusStatus()+ " " +getShortName()+ " " +getSolutionAvail()+ " " +getSourceGroup().toColumnString()+ " " +getTitle()+ " " +getUrl()+ " " +getWosCitations()+ " " +getWosReferences()+ " " +getWosStatus()+ " " +getYear()+ " " +getProceedings().toColumnString();
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
         out.println("<paper "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " abstractText=\""+toXMLAbstractText()+"\""+
            " accepted=\""+toXMLAccepted()+"\""+
            " author=\""+toXMLAuthor()+"\""+
            " authors=\""+toXMLAuthors()+"\""+
            " background=\""+toXMLBackground()+"\""+
            " classification=\""+toXMLClassification()+"\""+
            " cluster=\""+toXMLCluster()+"\""+
            " codeAvail=\""+toXMLCodeAvail()+"\""+
            " concept=\""+toXMLConcept()+"\""+
            " constraints=\""+toXMLConstraints()+"\""+
            " cpSystem=\""+toXMLCpSystem()+"\""+
            " crossrefCitations=\""+toXMLCrossrefCitations()+"\""+
            " crossrefReferences=\""+toXMLCrossrefReferences()+"\""+
            " crossrefStatus=\""+toXMLCrossrefStatus()+"\""+
            " dataAvail=\""+toXMLDataAvail()+"\""+
            " daysToAccept=\""+toXMLDaysToAccept()+"\""+
            " daysToPublish=\""+toXMLDaysToPublish()+"\""+
            " doi=\""+toXMLDoi()+"\""+
            " doiStatus=\""+toXMLDoiStatus()+"\""+
            " firstOnline=\""+toXMLFirstOnline()+"\""+
            " issn=\""+toXMLIssn()+"\""+
            " key=\""+toXMLKey()+"\""+
            " keywords=\""+toXMLKeywords()+"\""+
            " language=\""+toXMLLanguage()+"\""+
            " localCopy=\""+toXMLLocalCopy()+"\""+
            " maxCitations=\""+toXMLMaxCitations()+"\""+
            " nr=\""+toXMLNr()+"\""+
            " nrCitations=\""+toXMLNrCitations()+"\""+
            " nrCitationsCovered=\""+toXMLNrCitationsCovered()+"\""+
            " nrConcepts=\""+toXMLNrConcepts()+"\""+
            " nrEdges=\""+toXMLNrEdges()+"\""+
            " nrHyperLinks=\""+toXMLNrHyperLinks()+"\""+
            " nrPages=\""+toXMLNrPages()+"\""+
            " nrReferences=\""+toXMLNrReferences()+"\""+
            " nrReferencesCovered=\""+toXMLNrReferencesCovered()+"\""+
            " openAccess=\""+toXMLOpenAccess()+"\""+
            " openAccessType=\""+toXMLOpenAccessType()+"\""+
            " pages=\""+toXMLPages()+"\""+
            " percentCitationsCovered=\""+toXMLPercentCitationsCovered()+"\""+
            " percentReferencesCovered=\""+toXMLPercentReferencesCovered()+"\""+
            " published=\""+toXMLPublished()+"\""+
            " publisher=\""+toXMLPublisher()+"\""+
            " rangeCitations=\""+toXMLRangeCitations()+"\""+
            " received=\""+toXMLReceived()+"\""+
            " relatedTo=\""+toXMLRelatedTo()+"\""+
            " relevanceAbstract=\""+toXMLRelevanceAbstract()+"\""+
            " relevanceBody=\""+toXMLRelevanceBody()+"\""+
            " relevanceTitle=\""+toXMLRelevanceTitle()+"\""+
            " revised=\""+toXMLRevised()+"\""+
            " scopusCitations=\""+toXMLScopusCitations()+"\""+
            " scopusStatus=\""+toXMLScopusStatus()+"\""+
            " shortName=\""+toXMLShortName()+"\""+
            " solutionAvail=\""+toXMLSolutionAvail()+"\""+
            " sourceGroup=\""+toXMLSourceGroup()+"\""+
            " title=\""+toXMLTitle()+"\""+
            " url=\""+toXMLUrl()+"\""+
            " wosCitations=\""+toXMLWosCitations()+"\""+
            " wosReferences=\""+toXMLWosReferences()+"\""+
            " wosStatus=\""+toXMLWosStatus()+"\""+
            " year=\""+toXMLYear()+"\""+
            " proceedings=\""+toXMLProceedings()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLProceedings(){
        return "ID_"+this.getProceedings().getId().toString();
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>Paper</th>"+"<th>Name</th>"+"<th>ShortName</th>"+"<th>Nr</th>"+"<th>NrEdges</th>"+"<th>Cluster</th>"+"<th>Key</th>"+"<th>Author</th>"+"<th>Authors</th>"+"<th>Title</th>"+"<th>Publisher</th>"+"<th>Url</th>"+"<th>Doi</th>"+"<th>Issn</th>"+"<th>LocalCopy</th>"+"<th>Year</th>"+"<th>Pages</th>"+"<th>NrPages</th>"+"<th>NrHyperLinks</th>"+"<th>Background</th>"+"<th>SourceGroup</th>"+"<th>DataAvail</th>"+"<th>CodeAvail</th>"+"<th>SolutionAvail</th>"+"<th>CpSystem</th>"+"<th>Classification</th>"+"<th>Constraints</th>"+"<th>RelatedTo</th>"+"<th>OpenAccess</th>"+"<th>OpenAccessType</th>"+"<th>NrConcepts</th>"+"<th>NrCitations</th>"+"<th>NrReferences</th>"+"<th>CrossrefCitations</th>"+"<th>CrossrefReferences</th>"+"<th>WosCitations</th>"+"<th>WosReferences</th>"+"<th>ScopusCitations</th>"+"<th>NrCitationsCovered</th>"+"<th>NrReferencesCovered</th>"+"<th>PercentCitationsCovered</th>"+"<th>PercentReferencesCovered</th>"+"<th>MaxCitations</th>"+"<th>RangeCitations</th>"+"<th>DoiStatus</th>"+"<th>CrossrefStatus</th>"+"<th>ScopusStatus</th>"+"<th>WosStatus</th>"+"<th>RelevanceTitle</th>"+"<th>RelevanceAbstract</th>"+"<th>RelevanceBody</th>"+"<th>Language</th>"+"<th>Keywords</th>"+"<th>AbstractText</th>"+"<th>Concept</th>"+"<th>Received</th>"+"<th>Accepted</th>"+"<th>Revised</th>"+"<th>FirstOnline</th>"+"<th>Published</th>"+"<th>DaysToAccept</th>"+"<th>DaysToPublish</th>"+"<th>Proceedings</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getShortName()+"</td>"+ " " +"<td>"+getNr()+"</td>"+ " " +"<td>"+getNrEdges()+"</td>"+ " " +"<td>"+getCluster()+"</td>"+ " " +"<td>"+getKey()+"</td>"+ " " +"<td>"+getAuthor()+"</td>"+ " " +"<td>"+getAuthors()+"</td>"+ " " +"<td>"+getTitle()+"</td>"+ " " +"<td>"+getPublisher().toColumnString()+"</td>"+ " " +"<td>"+getUrl()+"</td>"+ " " +"<td>"+getDoi()+"</td>"+ " " +"<td>"+getIssn()+"</td>"+ " " +"<td>"+getLocalCopy()+"</td>"+ " " +"<td>"+getYear()+"</td>"+ " " +"<td>"+getPages()+"</td>"+ " " +"<td>"+getNrPages()+"</td>"+ " " +"<td>"+getNrHyperLinks()+"</td>"+ " " +"<td>"+getBackground()+"</td>"+ " " +"<td>"+getSourceGroup().toColumnString()+"</td>"+ " " +"<td>"+getDataAvail()+"</td>"+ " " +"<td>"+getCodeAvail()+"</td>"+ " " +"<td>"+getSolutionAvail()+"</td>"+ " " +"<td>"+getCpSystem()+"</td>"+ " " +"<td>"+getClassification()+"</td>"+ " " +"<td>"+getConstraints()+"</td>"+ " " +"<td>"+getRelatedTo()+"</td>"+ " " +"<td>"+getOpenAccess()+"</td>"+ " " +"<td>"+getOpenAccessType()+"</td>"+ " " +"<td>"+getNrConcepts()+"</td>"+ " " +"<td>"+getNrCitations()+"</td>"+ " " +"<td>"+getNrReferences()+"</td>"+ " " +"<td>"+getCrossrefCitations()+"</td>"+ " " +"<td>"+getCrossrefReferences()+"</td>"+ " " +"<td>"+getWosCitations()+"</td>"+ " " +"<td>"+getWosReferences()+"</td>"+ " " +"<td>"+getScopusCitations()+"</td>"+ " " +"<td>"+getNrCitationsCovered()+"</td>"+ " " +"<td>"+getNrReferencesCovered()+"</td>"+ " " +"<td>"+getPercentCitationsCovered()+"</td>"+ " " +"<td>"+getPercentReferencesCovered()+"</td>"+ " " +"<td>"+getMaxCitations()+"</td>"+ " " +"<td>"+getRangeCitations()+"</td>"+ " " +"<td>"+getDoiStatus()+"</td>"+ " " +"<td>"+getCrossrefStatus()+"</td>"+ " " +"<td>"+getScopusStatus()+"</td>"+ " " +"<td>"+getWosStatus()+"</td>"+ " " +"<td>"+getRelevanceTitle()+"</td>"+ " " +"<td>"+getRelevanceAbstract()+"</td>"+ " " +"<td>"+getRelevanceBody()+"</td>"+ " " +"<td>"+getLanguage()+"</td>"+ " " +"<td>"+getKeywords()+"</td>"+ " " +"<td>"+getAbstractText()+"</td>"+ " " +"<td>"+getConcept()+"</td>"+ " " +"<td>"+getReceived()+"</td>"+ " " +"<td>"+getAccepted()+"</td>"+ " " +"<td>"+getRevised()+"</td>"+ " " +"<td>"+getFirstOnline()+"</td>"+ " " +"<td>"+getPublished()+"</td>"+ " " +"<td>"+getDaysToAccept()+"</td>"+ " " +"<td>"+getDaysToPublish()+"</td>"+ " " +"<td>"+getProceedings().toColumnString()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a Paper item we are looking for
 * @param bList List<Paper> list of items in which we are searching
 * @return Paper entry of list b which is applicationSame() to a
*/

    public static Paper find(Paper a, List<Paper> bList){
        for(Paper b : bList){
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
 * @param name Paper name of the object we are looking for
 * @return Paper entry of the dataset with the given name; otherwise null
*/

    public static Paper findByName(ApplicationDataset base, String name){
        for(Paper a:base.getListPaper()) {
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
 * @param name Paper name of the object we are looking for
 * @return Paper entry of the dataset with the given name
*/

    public static Paper findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(Paper a:base.getListPaper()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        Paper res = new Paper(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Paper first entry in the dataset of this type; null if that does not exists
*/

    public static Paper findFirst(ApplicationDataset base){
        if (base.getListPaper().isEmpty()) {
            return null;
        }
        return base.getListPaper().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Paper some entry in the dataset of this type; null if that does not exists
*/

    public static Paper findAny(ApplicationDataset base){
        int size=base.getListPaper().size();
        if (size > 0) {
             return base.getListPaper().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Paper last entry in the dataset of this type; null if that does not exists
*/

    public static Paper findLast(ApplicationDataset base){
        int size=base.getListPaper().size();
        if (size > 0) {
             return base.getListPaper().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b Paper compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(Paper b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b Paper compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(Paper b){
      if(!this.getAbstractText().equals(b.getAbstractText())){
         System.out.println("AbstractText");
        }
      if(!this.getAccepted().equals(b.getAccepted())){
         System.out.println("Accepted");
        }
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
      if(!this.getCluster().equals(b.getCluster())){
         System.out.println("Cluster");
        }
      if(!this.getCodeAvail().equals(b.getCodeAvail())){
         System.out.println("CodeAvail");
        }
      if (true) {         System.out.println("Concept");
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
      if(!this.getDaysToAccept().equals(b.getDaysToAccept())){
         System.out.println("DaysToAccept");
        }
      if(!this.getDaysToPublish().equals(b.getDaysToPublish())){
         System.out.println("DaysToPublish");
        }
      if(!this.getDoi().equals(b.getDoi())){
         System.out.println("Doi");
        }
      if(!this.getDoiStatus().equals(b.getDoiStatus())){
         System.out.println("DoiStatus");
        }
      if(!this.getFirstOnline().equals(b.getFirstOnline())){
         System.out.println("FirstOnline");
        }
      if(!this.getIssn().equals(b.getIssn())){
         System.out.println("Issn");
        }
      if(!this.getKey().equals(b.getKey())){
         System.out.println("Key");
        }
      if(!this.getKeywords().equals(b.getKeywords())){
         System.out.println("Keywords");
        }
      if(!this.getLanguage().equals(b.getLanguage())){
         System.out.println("Language");
        }
      if(!this.getLocalCopy().equals(b.getLocalCopy())){
         System.out.println("LocalCopy");
        }
      if(!this.getMaxCitations().equals(b.getMaxCitations())){
         System.out.println("MaxCitations");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getNr().equals(b.getNr())){
         System.out.println("Nr");
        }
      if(!this.getNrCitations().equals(b.getNrCitations())){
         System.out.println("NrCitations");
        }
      if(!this.getNrCitationsCovered().equals(b.getNrCitationsCovered())){
         System.out.println("NrCitationsCovered");
        }
      if(!this.getNrConcepts().equals(b.getNrConcepts())){
         System.out.println("NrConcepts");
        }
      if(!this.getNrEdges().equals(b.getNrEdges())){
         System.out.println("NrEdges");
        }
      if(!this.getNrHyperLinks().equals(b.getNrHyperLinks())){
         System.out.println("NrHyperLinks");
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
      if(!this.getOpenAccess().equals(b.getOpenAccess())){
         System.out.println("OpenAccess");
        }
      if(!this.getOpenAccessType().equals(b.getOpenAccessType())){
         System.out.println("OpenAccessType");
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
      if(!this.getProceedings().applicationSame(b.getProceedings())){
         System.out.println("Proceedings");
        }
      if(!this.getPublished().equals(b.getPublished())){
         System.out.println("Published");
        }
      if(!this.getPublisher().applicationSame(b.getPublisher())){
         System.out.println("Publisher");
        }
      if(!this.getRangeCitations().equals(b.getRangeCitations())){
         System.out.println("RangeCitations");
        }
      if(!this.getReceived().equals(b.getReceived())){
         System.out.println("Received");
        }
      if(!this.getRelatedTo().equals(b.getRelatedTo())){
         System.out.println("RelatedTo");
        }
      if(!this.getRelevanceAbstract().equals(b.getRelevanceAbstract())){
         System.out.println("RelevanceAbstract");
        }
      if(!this.getRelevanceBody().equals(b.getRelevanceBody())){
         System.out.println("RelevanceBody");
        }
      if(!this.getRelevanceTitle().equals(b.getRelevanceTitle())){
         System.out.println("RelevanceTitle");
        }
      if(!this.getRevised().equals(b.getRevised())){
         System.out.println("Revised");
        }
      if(!this.getScopusCitations().equals(b.getScopusCitations())){
         System.out.println("ScopusCitations");
        }
      if(!this.getScopusStatus().equals(b.getScopusStatus())){
         System.out.println("ScopusStatus");
        }
      if(!this.getShortName().equals(b.getShortName())){
         System.out.println("ShortName");
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
      if(!this.getWosCitations().equals(b.getWosCitations())){
         System.out.println("WosCitations");
        }
      if(!this.getWosReferences().equals(b.getWosReferences())){
         System.out.println("WosReferences");
        }
      if(!this.getWosStatus().equals(b.getWosStatus())){
         System.out.println("WosStatus");
        }
      if(!this.getYear().equals(b.getYear())){
         System.out.println("Year");
        }
        return  this.getAbstractText().equals(b.getAbstractText()) &&
          this.getAccepted().equals(b.getAccepted()) &&
          this.getAuthor().equals(b.getAuthor()) &&
          true &&
          this.getBackground().equals(b.getBackground()) &&
          this.getClassification().equals(b.getClassification()) &&
          this.getCluster().equals(b.getCluster()) &&
          this.getCodeAvail().equals(b.getCodeAvail()) &&
          true &&
          this.getConstraints().equals(b.getConstraints()) &&
          this.getCpSystem().equals(b.getCpSystem()) &&
          this.getCrossrefCitations().equals(b.getCrossrefCitations()) &&
          this.getCrossrefReferences().equals(b.getCrossrefReferences()) &&
          this.getCrossrefStatus().equals(b.getCrossrefStatus()) &&
          this.getDataAvail().equals(b.getDataAvail()) &&
          this.getDaysToAccept().equals(b.getDaysToAccept()) &&
          this.getDaysToPublish().equals(b.getDaysToPublish()) &&
          this.getDoi().equals(b.getDoi()) &&
          this.getDoiStatus().equals(b.getDoiStatus()) &&
          this.getFirstOnline().equals(b.getFirstOnline()) &&
          this.getIssn().equals(b.getIssn()) &&
          this.getKey().equals(b.getKey()) &&
          this.getKeywords().equals(b.getKeywords()) &&
          this.getLanguage().equals(b.getLanguage()) &&
          this.getLocalCopy().equals(b.getLocalCopy()) &&
          this.getMaxCitations().equals(b.getMaxCitations()) &&
          this.getName().equals(b.getName()) &&
          this.getNr().equals(b.getNr()) &&
          this.getNrCitations().equals(b.getNrCitations()) &&
          this.getNrCitationsCovered().equals(b.getNrCitationsCovered()) &&
          this.getNrConcepts().equals(b.getNrConcepts()) &&
          this.getNrEdges().equals(b.getNrEdges()) &&
          this.getNrHyperLinks().equals(b.getNrHyperLinks()) &&
          this.getNrPages().equals(b.getNrPages()) &&
          this.getNrReferences().equals(b.getNrReferences()) &&
          this.getNrReferencesCovered().equals(b.getNrReferencesCovered()) &&
          this.getOpenAccess().equals(b.getOpenAccess()) &&
          this.getOpenAccessType().equals(b.getOpenAccessType()) &&
          this.getPages().equals(b.getPages()) &&
          this.getPercentCitationsCovered().equals(b.getPercentCitationsCovered()) &&
          this.getPercentReferencesCovered().equals(b.getPercentReferencesCovered()) &&
          this.getProceedings().applicationSame(b.getProceedings()) &&
          this.getPublished().equals(b.getPublished()) &&
          this.getPublisher().applicationSame(b.getPublisher()) &&
          this.getRangeCitations().equals(b.getRangeCitations()) &&
          this.getReceived().equals(b.getReceived()) &&
          this.getRelatedTo().equals(b.getRelatedTo()) &&
          this.getRelevanceAbstract().equals(b.getRelevanceAbstract()) &&
          this.getRelevanceBody().equals(b.getRelevanceBody()) &&
          this.getRelevanceTitle().equals(b.getRelevanceTitle()) &&
          this.getRevised().equals(b.getRevised()) &&
          this.getScopusCitations().equals(b.getScopusCitations()) &&
          this.getScopusStatus().equals(b.getScopusStatus()) &&
          this.getShortName().equals(b.getShortName()) &&
          this.getSolutionAvail().equals(b.getSolutionAvail()) &&
          this.getSourceGroup().applicationSame(b.getSourceGroup()) &&
          this.getTitle().equals(b.getTitle()) &&
          this.getUrl().equals(b.getUrl()) &&
          this.getWosCitations().equals(b.getWosCitations()) &&
          this.getWosReferences().equals(b.getWosReferences()) &&
          this.getWosStatus().equals(b.getWosStatus()) &&
          this.getYear().equals(b.getYear());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","Paper",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getAuthors() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"authors","Paper",(getAuthors()==null?"null":getAuthors().toString()),"",WarningType.NOTNULL);
        }
        if (getAuthors().size() == 0){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"authors","Paper",(getAuthors()==null?"null":getAuthors().toString()),"",WarningType.NOTEMPTY);
        }
        if (getConcept() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"concept","Paper",(getConcept()==null?"null":getConcept().toString()),"",WarningType.NOTNULL);
        }
        if (getPublisher() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"publisher","Paper",(getPublisher()==null?"null":getPublisher().toString()),"",WarningType.NOTNULL);
        }
        if (getSourceGroup() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"sourceGroup","Paper",(getSourceGroup()==null?"null":getSourceGroup().toString()),"",WarningType.NOTNULL);
        }
        if (getProceedings() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"proceedings","Paper",(getProceedings()==null?"null":getProceedings().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class Paper
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
      if (attrName.equals("publisher")){
         return (List) ((Scenario)base).getListPublisher();
      }
      if (attrName.equals("sourceGroup")){
         return (List) ((Scenario)base).getListSourceGroup();
      }
      if (attrName.equals("proceedings")){
         return (List) ((Scenario)base).getListProceedings();
      }
      return null;
   }

}
