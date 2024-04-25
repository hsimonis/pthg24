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
import org.insightcentre.pthg24.datamodel.Orphan;
import org.insightcentre.pthg24.datamodel.CollabWork;
import org.insightcentre.pthg24.datamodel.CollabCount;
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
            Integer maxCitations,
            Integer nrCitations,
            Integer nrCitationsCovered,
            Integer nrConcepts,
            Integer nrLinks,
            Integer nrPages,
            Integer nrReferences,
            Integer nrReferencesCovered,
            String pages,
            Double percentCitationsCovered,
            Double percentReferencesCovered,
            Integer rangeCitations,
            String relatedTo,
            Integer scopusCitations,
            Boolean scopusStatus,
            String solutionAvail,
            SourceGroup sourceGroup,
            String title,
            String url,
            Integer year,
            Proceedings proceedings){
        super(applicationDataset,
            id,
            name,
            author,
            authors,
            background,
            classification,
            codeAvail,
            constraints,
            cpSystem,
            crossrefCitations,
            crossrefReferences,
            crossrefStatus,
            dataAvail,
            doi,
            doiStatus,
            key,
            localCopy,
            maxCitations,
            nrCitations,
            nrCitationsCovered,
            nrConcepts,
            nrLinks,
            nrPages,
            nrReferences,
            nrReferencesCovered,
            pages,
            percentCitationsCovered,
            percentReferencesCovered,
            rangeCitations,
            relatedTo,
            scopusCitations,
            scopusStatus,
            solutionAvail,
            sourceGroup,
            title,
            url,
            year);
        setProceedings(proceedings);
        applicationDataset.addPaper(this);
    }

    public Paper(Paper other){
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
            other.maxCitations,
            other.nrCitations,
            other.nrCitationsCovered,
            other.nrConcepts,
            other.nrLinks,
            other.nrPages,
            other.nrReferences,
            other.nrReferencesCovered,
            other.pages,
            other.percentCitationsCovered,
            other.percentReferencesCovered,
            other.rangeCitations,
            other.relatedTo,
            other.scopusCitations,
            other.scopusStatus,
            other.solutionAvail,
            other.sourceGroup,
            other.title,
            other.url,
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
        return ""+ " " +getId()+ " " +getName()+ " " +getAuthor()+ " " +getAuthors()+ " " +getBackground()+ " " +getClassification()+ " " +getCodeAvail()+ " " +getConstraints()+ " " +getCpSystem()+ " " +getCrossrefCitations()+ " " +getCrossrefReferences()+ " " +getCrossrefStatus()+ " " +getDataAvail()+ " " +getDoi()+ " " +getDoiStatus()+ " " +getKey()+ " " +getLocalCopy()+ " " +getMaxCitations()+ " " +getNrCitations()+ " " +getNrCitationsCovered()+ " " +getNrConcepts()+ " " +getNrLinks()+ " " +getNrPages()+ " " +getNrReferences()+ " " +getNrReferencesCovered()+ " " +getPages()+ " " +getPercentCitationsCovered()+ " " +getPercentReferencesCovered()+ " " +getRangeCitations()+ " " +getRelatedTo()+ " " +getScopusCitations()+ " " +getScopusStatus()+ " " +getSolutionAvail()+ " " +getSourceGroup().toColumnString()+ " " +getTitle()+ " " +getUrl()+ " " +getYear()+ " " +getProceedings().toColumnString();
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
            " maxCitations=\""+toXMLMaxCitations()+"\""+
            " nrCitations=\""+toXMLNrCitations()+"\""+
            " nrCitationsCovered=\""+toXMLNrCitationsCovered()+"\""+
            " nrConcepts=\""+toXMLNrConcepts()+"\""+
            " nrLinks=\""+toXMLNrLinks()+"\""+
            " nrPages=\""+toXMLNrPages()+"\""+
            " nrReferences=\""+toXMLNrReferences()+"\""+
            " nrReferencesCovered=\""+toXMLNrReferencesCovered()+"\""+
            " pages=\""+toXMLPages()+"\""+
            " percentCitationsCovered=\""+toXMLPercentCitationsCovered()+"\""+
            " percentReferencesCovered=\""+toXMLPercentReferencesCovered()+"\""+
            " rangeCitations=\""+toXMLRangeCitations()+"\""+
            " relatedTo=\""+toXMLRelatedTo()+"\""+
            " scopusCitations=\""+toXMLScopusCitations()+"\""+
            " scopusStatus=\""+toXMLScopusStatus()+"\""+
            " solutionAvail=\""+toXMLSolutionAvail()+"\""+
            " sourceGroup=\""+toXMLSourceGroup()+"\""+
            " title=\""+toXMLTitle()+"\""+
            " url=\""+toXMLUrl()+"\""+
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
        return "<tr><th>Paper</th>"+"<th>Name</th>"+"<th>Key</th>"+"<th>Author</th>"+"<th>Authors</th>"+"<th>Title</th>"+"<th>Url</th>"+"<th>Doi</th>"+"<th>LocalCopy</th>"+"<th>Year</th>"+"<th>Pages</th>"+"<th>NrPages</th>"+"<th>NrLinks</th>"+"<th>Background</th>"+"<th>SourceGroup</th>"+"<th>DataAvail</th>"+"<th>CodeAvail</th>"+"<th>SolutionAvail</th>"+"<th>CpSystem</th>"+"<th>Classification</th>"+"<th>Constraints</th>"+"<th>RelatedTo</th>"+"<th>NrConcepts</th>"+"<th>NrCitations</th>"+"<th>NrReferences</th>"+"<th>CrossrefCitations</th>"+"<th>CrossrefReferences</th>"+"<th>ScopusCitations</th>"+"<th>NrCitationsCovered</th>"+"<th>NrReferencesCovered</th>"+"<th>PercentCitationsCovered</th>"+"<th>PercentReferencesCovered</th>"+"<th>MaxCitations</th>"+"<th>RangeCitations</th>"+"<th>DoiStatus</th>"+"<th>CrossrefStatus</th>"+"<th>ScopusStatus</th>"+"<th>Proceedings</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getKey()+"</td>"+ " " +"<td>"+getAuthor()+"</td>"+ " " +"<td>"+getAuthors()+"</td>"+ " " +"<td>"+getTitle()+"</td>"+ " " +"<td>"+getUrl()+"</td>"+ " " +"<td>"+getDoi()+"</td>"+ " " +"<td>"+getLocalCopy()+"</td>"+ " " +"<td>"+getYear()+"</td>"+ " " +"<td>"+getPages()+"</td>"+ " " +"<td>"+getNrPages()+"</td>"+ " " +"<td>"+getNrLinks()+"</td>"+ " " +"<td>"+getBackground()+"</td>"+ " " +"<td>"+getSourceGroup().toColumnString()+"</td>"+ " " +"<td>"+getDataAvail()+"</td>"+ " " +"<td>"+getCodeAvail()+"</td>"+ " " +"<td>"+getSolutionAvail()+"</td>"+ " " +"<td>"+getCpSystem()+"</td>"+ " " +"<td>"+getClassification()+"</td>"+ " " +"<td>"+getConstraints()+"</td>"+ " " +"<td>"+getRelatedTo()+"</td>"+ " " +"<td>"+getNrConcepts()+"</td>"+ " " +"<td>"+getNrCitations()+"</td>"+ " " +"<td>"+getNrReferences()+"</td>"+ " " +"<td>"+getCrossrefCitations()+"</td>"+ " " +"<td>"+getCrossrefReferences()+"</td>"+ " " +"<td>"+getScopusCitations()+"</td>"+ " " +"<td>"+getNrCitationsCovered()+"</td>"+ " " +"<td>"+getNrReferencesCovered()+"</td>"+ " " +"<td>"+getPercentCitationsCovered()+"</td>"+ " " +"<td>"+getPercentReferencesCovered()+"</td>"+ " " +"<td>"+getMaxCitations()+"</td>"+ " " +"<td>"+getRangeCitations()+"</td>"+ " " +"<td>"+getDoiStatus()+"</td>"+ " " +"<td>"+getCrossrefStatus()+"</td>"+ " " +"<td>"+getScopusStatus()+"</td>"+ " " +"<td>"+getProceedings().toColumnString()+"</td>"+"</tr>";
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
      if(!this.getMaxCitations().equals(b.getMaxCitations())){
         System.out.println("MaxCitations");
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
      if(!this.getNrConcepts().equals(b.getNrConcepts())){
         System.out.println("NrConcepts");
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
      if(!this.getProceedings().applicationSame(b.getProceedings())){
         System.out.println("Proceedings");
        }
      if(!this.getRangeCitations().equals(b.getRangeCitations())){
         System.out.println("RangeCitations");
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
          this.getMaxCitations().equals(b.getMaxCitations()) &&
          this.getName().equals(b.getName()) &&
          this.getNrCitations().equals(b.getNrCitations()) &&
          this.getNrCitationsCovered().equals(b.getNrCitationsCovered()) &&
          this.getNrConcepts().equals(b.getNrConcepts()) &&
          this.getNrLinks().equals(b.getNrLinks()) &&
          this.getNrPages().equals(b.getNrPages()) &&
          this.getNrReferences().equals(b.getNrReferences()) &&
          this.getNrReferencesCovered().equals(b.getNrReferencesCovered()) &&
          this.getPages().equals(b.getPages()) &&
          this.getPercentCitationsCovered().equals(b.getPercentCitationsCovered()) &&
          this.getPercentReferencesCovered().equals(b.getPercentReferencesCovered()) &&
          this.getProceedings().applicationSame(b.getProceedings()) &&
          this.getRangeCitations().equals(b.getRangeCitations()) &&
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
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","Paper",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getAuthors() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"authors","Paper",(getAuthors()==null?"null":getAuthors().toString()),"",WarningType.NOTNULL);
        }
        if (getAuthors().size() == 0){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"authors","Paper",(getAuthors()==null?"null":getAuthors().toString()),"",WarningType.NOTEMPTY);
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
      if (attrName.equals("sourceGroup")){
         return (List) ((Scenario)base).getListSourceGroup();
      }
      if (attrName.equals("proceedings")){
         return (List) ((Scenario)base).getListProceedings();
      }
      return null;
   }

}
