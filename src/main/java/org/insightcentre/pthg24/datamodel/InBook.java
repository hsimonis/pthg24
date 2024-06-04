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

public  class InBook extends Work{
/**
 *  
 *
*/

    public String booktitle;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public InBook(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public InBook(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setBooktitle("");
        applicationDataset.addInBook(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public InBook(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            String abstractText,
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
            String doi,
            Boolean doiStatus,
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
            Publisher publisher,
            Integer rangeCitations,
            String relatedTo,
            Double relevanceAbstract,
            Double relevanceBody,
            Double relevanceTitle,
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
            String booktitle){
        super(applicationDataset,
            id,
            name,
            abstractText,
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
            doi,
            doiStatus,
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
            publisher,
            rangeCitations,
            relatedTo,
            relevanceAbstract,
            relevanceBody,
            relevanceTitle,
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
        setBooktitle(booktitle);
        applicationDataset.addInBook(this);
    }

    public InBook(InBook other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.abstractText,
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
            other.doi,
            other.doiStatus,
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
            other.publisher,
            other.rangeCitations,
            other.relatedTo,
            other.relevanceAbstract,
            other.relevanceBody,
            other.relevanceTitle,
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
            other.booktitle);
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
        return getApplicationDataset().removeInBook(this) && getApplicationDataset().removeWork(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute booktitle
 *
 * @return String
*/

    public String getBooktitle(){
        return this.booktitle;
    }

/**
 *  set attribute booktitle, mark dataset as dirty, mark dataset as not valid
@param booktitle String
 *
*/

    public void setBooktitle(String booktitle){
        this.booktitle = booktitle;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getAbstractText()+ " " +getAuthor()+ " " +getAuthors()+ " " +getBackground()+ " " +getClassification()+ " " +getCluster()+ " " +getCodeAvail()+ " " +getConcept()+ " " +getConstraints()+ " " +getCpSystem()+ " " +getCrossrefCitations()+ " " +getCrossrefReferences()+ " " +getCrossrefStatus()+ " " +getDataAvail()+ " " +getDoi()+ " " +getDoiStatus()+ " " +getIssn()+ " " +getKey()+ " " +getKeywords()+ " " +getLanguage()+ " " +getLocalCopy()+ " " +getMaxCitations()+ " " +getNr()+ " " +getNrCitations()+ " " +getNrCitationsCovered()+ " " +getNrConcepts()+ " " +getNrEdges()+ " " +getNrHyperLinks()+ " " +getNrPages()+ " " +getNrReferences()+ " " +getNrReferencesCovered()+ " " +getOpenAccess()+ " " +getOpenAccessType()+ " " +getPages()+ " " +getPercentCitationsCovered()+ " " +getPercentReferencesCovered()+ " " +getPublisher().toColumnString()+ " " +getRangeCitations()+ " " +getRelatedTo()+ " " +getRelevanceAbstract()+ " " +getRelevanceBody()+ " " +getRelevanceTitle()+ " " +getScopusCitations()+ " " +getScopusStatus()+ " " +getShortName()+ " " +getSolutionAvail()+ " " +getSourceGroup().toColumnString()+ " " +getTitle()+ " " +getUrl()+ " " +getWosCitations()+ " " +getWosReferences()+ " " +getWosStatus()+ " " +getYear()+ " " +getBooktitle();
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
         out.println("<inBook "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " abstractText=\""+toXMLAbstractText()+"\""+
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
            " doi=\""+toXMLDoi()+"\""+
            " doiStatus=\""+toXMLDoiStatus()+"\""+
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
            " publisher=\""+toXMLPublisher()+"\""+
            " rangeCitations=\""+toXMLRangeCitations()+"\""+
            " relatedTo=\""+toXMLRelatedTo()+"\""+
            " relevanceAbstract=\""+toXMLRelevanceAbstract()+"\""+
            " relevanceBody=\""+toXMLRelevanceBody()+"\""+
            " relevanceTitle=\""+toXMLRelevanceTitle()+"\""+
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
            " booktitle=\""+toXMLBooktitle()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLBooktitle(){
        return this.safeXML(getBooktitle());
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>InBook</th>"+"<th>Name</th>"+"<th>ShortName</th>"+"<th>Nr</th>"+"<th>NrEdges</th>"+"<th>Cluster</th>"+"<th>Key</th>"+"<th>Author</th>"+"<th>Authors</th>"+"<th>Title</th>"+"<th>Publisher</th>"+"<th>Url</th>"+"<th>Doi</th>"+"<th>Issn</th>"+"<th>LocalCopy</th>"+"<th>Year</th>"+"<th>Pages</th>"+"<th>NrPages</th>"+"<th>NrHyperLinks</th>"+"<th>Background</th>"+"<th>SourceGroup</th>"+"<th>DataAvail</th>"+"<th>CodeAvail</th>"+"<th>SolutionAvail</th>"+"<th>CpSystem</th>"+"<th>Classification</th>"+"<th>Constraints</th>"+"<th>RelatedTo</th>"+"<th>OpenAccess</th>"+"<th>OpenAccessType</th>"+"<th>NrConcepts</th>"+"<th>NrCitations</th>"+"<th>NrReferences</th>"+"<th>CrossrefCitations</th>"+"<th>CrossrefReferences</th>"+"<th>WosCitations</th>"+"<th>WosReferences</th>"+"<th>ScopusCitations</th>"+"<th>NrCitationsCovered</th>"+"<th>NrReferencesCovered</th>"+"<th>PercentCitationsCovered</th>"+"<th>PercentReferencesCovered</th>"+"<th>MaxCitations</th>"+"<th>RangeCitations</th>"+"<th>DoiStatus</th>"+"<th>CrossrefStatus</th>"+"<th>ScopusStatus</th>"+"<th>WosStatus</th>"+"<th>RelevanceTitle</th>"+"<th>RelevanceAbstract</th>"+"<th>RelevanceBody</th>"+"<th>Language</th>"+"<th>Keywords</th>"+"<th>AbstractText</th>"+"<th>Concept</th>"+"<th>Booktitle</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getShortName()+"</td>"+ " " +"<td>"+getNr()+"</td>"+ " " +"<td>"+getNrEdges()+"</td>"+ " " +"<td>"+getCluster()+"</td>"+ " " +"<td>"+getKey()+"</td>"+ " " +"<td>"+getAuthor()+"</td>"+ " " +"<td>"+getAuthors()+"</td>"+ " " +"<td>"+getTitle()+"</td>"+ " " +"<td>"+getPublisher().toColumnString()+"</td>"+ " " +"<td>"+getUrl()+"</td>"+ " " +"<td>"+getDoi()+"</td>"+ " " +"<td>"+getIssn()+"</td>"+ " " +"<td>"+getLocalCopy()+"</td>"+ " " +"<td>"+getYear()+"</td>"+ " " +"<td>"+getPages()+"</td>"+ " " +"<td>"+getNrPages()+"</td>"+ " " +"<td>"+getNrHyperLinks()+"</td>"+ " " +"<td>"+getBackground()+"</td>"+ " " +"<td>"+getSourceGroup().toColumnString()+"</td>"+ " " +"<td>"+getDataAvail()+"</td>"+ " " +"<td>"+getCodeAvail()+"</td>"+ " " +"<td>"+getSolutionAvail()+"</td>"+ " " +"<td>"+getCpSystem()+"</td>"+ " " +"<td>"+getClassification()+"</td>"+ " " +"<td>"+getConstraints()+"</td>"+ " " +"<td>"+getRelatedTo()+"</td>"+ " " +"<td>"+getOpenAccess()+"</td>"+ " " +"<td>"+getOpenAccessType()+"</td>"+ " " +"<td>"+getNrConcepts()+"</td>"+ " " +"<td>"+getNrCitations()+"</td>"+ " " +"<td>"+getNrReferences()+"</td>"+ " " +"<td>"+getCrossrefCitations()+"</td>"+ " " +"<td>"+getCrossrefReferences()+"</td>"+ " " +"<td>"+getWosCitations()+"</td>"+ " " +"<td>"+getWosReferences()+"</td>"+ " " +"<td>"+getScopusCitations()+"</td>"+ " " +"<td>"+getNrCitationsCovered()+"</td>"+ " " +"<td>"+getNrReferencesCovered()+"</td>"+ " " +"<td>"+getPercentCitationsCovered()+"</td>"+ " " +"<td>"+getPercentReferencesCovered()+"</td>"+ " " +"<td>"+getMaxCitations()+"</td>"+ " " +"<td>"+getRangeCitations()+"</td>"+ " " +"<td>"+getDoiStatus()+"</td>"+ " " +"<td>"+getCrossrefStatus()+"</td>"+ " " +"<td>"+getScopusStatus()+"</td>"+ " " +"<td>"+getWosStatus()+"</td>"+ " " +"<td>"+getRelevanceTitle()+"</td>"+ " " +"<td>"+getRelevanceAbstract()+"</td>"+ " " +"<td>"+getRelevanceBody()+"</td>"+ " " +"<td>"+getLanguage()+"</td>"+ " " +"<td>"+getKeywords()+"</td>"+ " " +"<td>"+getAbstractText()+"</td>"+ " " +"<td>"+getConcept()+"</td>"+ " " +"<td>"+getBooktitle()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a InBook item we are looking for
 * @param bList List<InBook> list of items in which we are searching
 * @return InBook entry of list b which is applicationSame() to a
*/

    public static InBook find(InBook a, List<InBook> bList){
        for(InBook b : bList){
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
 * @param name InBook name of the object we are looking for
 * @return InBook entry of the dataset with the given name; otherwise null
*/

    public static InBook findByName(ApplicationDataset base, String name){
        for(InBook a:base.getListInBook()) {
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
 * @param name InBook name of the object we are looking for
 * @return InBook entry of the dataset with the given name
*/

    public static InBook findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(InBook a:base.getListInBook()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        InBook res = new InBook(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return InBook first entry in the dataset of this type; null if that does not exists
*/

    public static InBook findFirst(ApplicationDataset base){
        if (base.getListInBook().isEmpty()) {
            return null;
        }
        return base.getListInBook().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return InBook some entry in the dataset of this type; null if that does not exists
*/

    public static InBook findAny(ApplicationDataset base){
        int size=base.getListInBook().size();
        if (size > 0) {
             return base.getListInBook().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return InBook last entry in the dataset of this type; null if that does not exists
*/

    public static InBook findLast(ApplicationDataset base){
        int size=base.getListInBook().size();
        if (size > 0) {
             return base.getListInBook().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b InBook compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(InBook b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b InBook compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(InBook b){
      if(!this.getAbstractText().equals(b.getAbstractText())){
         System.out.println("AbstractText");
        }
      if(!this.getAuthor().equals(b.getAuthor())){
         System.out.println("Author");
        }
      if (true) {         System.out.println("Authors");
        }
      if(!this.getBackground().equals(b.getBackground())){
         System.out.println("Background");
        }
      if(!this.getBooktitle().equals(b.getBooktitle())){
         System.out.println("Booktitle");
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
      if(!this.getDoi().equals(b.getDoi())){
         System.out.println("Doi");
        }
      if(!this.getDoiStatus().equals(b.getDoiStatus())){
         System.out.println("DoiStatus");
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
      if(!this.getPublisher().applicationSame(b.getPublisher())){
         System.out.println("Publisher");
        }
      if(!this.getRangeCitations().equals(b.getRangeCitations())){
         System.out.println("RangeCitations");
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
          this.getAuthor().equals(b.getAuthor()) &&
          true &&
          this.getBackground().equals(b.getBackground()) &&
          this.getBooktitle().equals(b.getBooktitle()) &&
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
          this.getDoi().equals(b.getDoi()) &&
          this.getDoiStatus().equals(b.getDoiStatus()) &&
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
          this.getPublisher().applicationSame(b.getPublisher()) &&
          this.getRangeCitations().equals(b.getRangeCitations()) &&
          this.getRelatedTo().equals(b.getRelatedTo()) &&
          this.getRelevanceAbstract().equals(b.getRelevanceAbstract()) &&
          this.getRelevanceBody().equals(b.getRelevanceBody()) &&
          this.getRelevanceTitle().equals(b.getRelevanceTitle()) &&
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
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","InBook",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getAuthors() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"authors","InBook",(getAuthors()==null?"null":getAuthors().toString()),"",WarningType.NOTNULL);
        }
        if (getAuthors().size() == 0){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"authors","InBook",(getAuthors()==null?"null":getAuthors().toString()),"",WarningType.NOTEMPTY);
        }
        if (getConcept() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"concept","InBook",(getConcept()==null?"null":getConcept().toString()),"",WarningType.NOTNULL);
        }
        if (getPublisher() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"publisher","InBook",(getPublisher()==null?"null":getPublisher().toString()),"",WarningType.NOTNULL);
        }
        if (getSourceGroup() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"sourceGroup","InBook",(getSourceGroup()==null?"null":getSourceGroup().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class InBook
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
      return null;
   }

}
