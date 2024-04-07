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
 * 
 * @author generated
*/

public  class InCollection extends Work{
/**
 *  
 *
*/

    public Collection collection;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public InCollection(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public InCollection(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setCollection(null);
        applicationDataset.addInCollection(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public InCollection(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            String author,
            List<Author> authors,
            Boolean background,
            String classification,
            String codeAvail,
            String constraints,
            String cpSystem,
            String dataAvail,
            String doi,
            String key,
            String localCopy,
            Integer nrCitations,
            Integer nrLinks,
            Integer nrPages,
            Integer nrReferences,
            String pages,
            String relatedTo,
            String solutionAvail,
            String title,
            String url,
            Integer year,
            Collection collection){
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
            dataAvail,
            doi,
            key,
            localCopy,
            nrCitations,
            nrLinks,
            nrPages,
            nrReferences,
            pages,
            relatedTo,
            solutionAvail,
            title,
            url,
            year);
        setCollection(collection);
        applicationDataset.addInCollection(this);
    }

    public InCollection(InCollection other){
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
            other.dataAvail,
            other.doi,
            other.key,
            other.localCopy,
            other.nrCitations,
            other.nrLinks,
            other.nrPages,
            other.nrReferences,
            other.pages,
            other.relatedTo,
            other.solutionAvail,
            other.title,
            other.url,
            other.year,
            other.collection);
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
        return getApplicationDataset().removeInCollection(this) && getApplicationDataset().removeWork(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute collection
 *
 * @return Collection
*/

    public Collection getCollection(){
        return this.collection;
    }

/**
 *  set attribute collection, mark dataset as dirty, mark dataset as not valid
@param collection Collection
 *
*/

    public void setCollection(Collection collection){
        this.collection = collection;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getAuthor()+ " " +getAuthors()+ " " +getBackground()+ " " +getClassification()+ " " +getCodeAvail()+ " " +getConstraints()+ " " +getCpSystem()+ " " +getDataAvail()+ " " +getDoi()+ " " +getKey()+ " " +getLocalCopy()+ " " +getNrCitations()+ " " +getNrLinks()+ " " +getNrPages()+ " " +getNrReferences()+ " " +getPages()+ " " +getRelatedTo()+ " " +getSolutionAvail()+ " " +getTitle()+ " " +getUrl()+ " " +getYear()+ " " +getCollection().toColumnString();
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
         out.println("<inCollection "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " author=\""+toXMLAuthor()+"\""+
            " authors=\""+toXMLAuthors()+"\""+
            " background=\""+toXMLBackground()+"\""+
            " classification=\""+toXMLClassification()+"\""+
            " codeAvail=\""+toXMLCodeAvail()+"\""+
            " constraints=\""+toXMLConstraints()+"\""+
            " cpSystem=\""+toXMLCpSystem()+"\""+
            " dataAvail=\""+toXMLDataAvail()+"\""+
            " doi=\""+toXMLDoi()+"\""+
            " key=\""+toXMLKey()+"\""+
            " localCopy=\""+toXMLLocalCopy()+"\""+
            " nrCitations=\""+toXMLNrCitations()+"\""+
            " nrLinks=\""+toXMLNrLinks()+"\""+
            " nrPages=\""+toXMLNrPages()+"\""+
            " nrReferences=\""+toXMLNrReferences()+"\""+
            " pages=\""+toXMLPages()+"\""+
            " relatedTo=\""+toXMLRelatedTo()+"\""+
            " solutionAvail=\""+toXMLSolutionAvail()+"\""+
            " title=\""+toXMLTitle()+"\""+
            " url=\""+toXMLUrl()+"\""+
            " year=\""+toXMLYear()+"\""+
            " collection=\""+toXMLCollection()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCollection(){
        return "ID_"+this.getCollection().getId().toString();
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>InCollection</th>"+"<th>Name</th>"+"<th>Key</th>"+"<th>Author</th>"+"<th>Authors</th>"+"<th>Title</th>"+"<th>Url</th>"+"<th>Doi</th>"+"<th>LocalCopy</th>"+"<th>Year</th>"+"<th>Pages</th>"+"<th>NrPages</th>"+"<th>NrLinks</th>"+"<th>Background</th>"+"<th>DataAvail</th>"+"<th>CodeAvail</th>"+"<th>SolutionAvail</th>"+"<th>CpSystem</th>"+"<th>Classification</th>"+"<th>Constraints</th>"+"<th>RelatedTo</th>"+"<th>NrCitations</th>"+"<th>NrReferences</th>"+"<th>Collection</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getKey()+"</td>"+ " " +"<td>"+getAuthor()+"</td>"+ " " +"<td>"+getAuthors()+"</td>"+ " " +"<td>"+getTitle()+"</td>"+ " " +"<td>"+getUrl()+"</td>"+ " " +"<td>"+getDoi()+"</td>"+ " " +"<td>"+getLocalCopy()+"</td>"+ " " +"<td>"+getYear()+"</td>"+ " " +"<td>"+getPages()+"</td>"+ " " +"<td>"+getNrPages()+"</td>"+ " " +"<td>"+getNrLinks()+"</td>"+ " " +"<td>"+getBackground()+"</td>"+ " " +"<td>"+getDataAvail()+"</td>"+ " " +"<td>"+getCodeAvail()+"</td>"+ " " +"<td>"+getSolutionAvail()+"</td>"+ " " +"<td>"+getCpSystem()+"</td>"+ " " +"<td>"+getClassification()+"</td>"+ " " +"<td>"+getConstraints()+"</td>"+ " " +"<td>"+getRelatedTo()+"</td>"+ " " +"<td>"+getNrCitations()+"</td>"+ " " +"<td>"+getNrReferences()+"</td>"+ " " +"<td>"+getCollection().toColumnString()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a InCollection item we are looking for
 * @param bList List<InCollection> list of items in which we are searching
 * @return InCollection entry of list b which is applicationSame() to a
*/

    public static InCollection find(InCollection a, List<InCollection> bList){
        for(InCollection b : bList){
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
 * @param name InCollection name of the object we are looking for
 * @return InCollection entry of the dataset with the given name; otherwise null
*/

    public static InCollection findByName(ApplicationDataset base, String name){
        for(InCollection a:base.getListInCollection()) {
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
 * @param name InCollection name of the object we are looking for
 * @return InCollection entry of the dataset with the given name
*/

    public static InCollection findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(InCollection a:base.getListInCollection()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        InCollection res = new InCollection(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return InCollection first entry in the dataset of this type; null if that does not exists
*/

    public static InCollection findFirst(ApplicationDataset base){
        if (base.getListInCollection().isEmpty()) {
            return null;
        }
        return base.getListInCollection().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return InCollection some entry in the dataset of this type; null if that does not exists
*/

    public static InCollection findAny(ApplicationDataset base){
        int size=base.getListInCollection().size();
        if (size > 0) {
             return base.getListInCollection().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return InCollection last entry in the dataset of this type; null if that does not exists
*/

    public static InCollection findLast(ApplicationDataset base){
        int size=base.getListInCollection().size();
        if (size > 0) {
             return base.getListInCollection().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b InCollection compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(InCollection b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b InCollection compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(InCollection b){
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
      if(!this.getCollection().applicationSame(b.getCollection())){
         System.out.println("Collection");
        }
      if(!this.getConstraints().equals(b.getConstraints())){
         System.out.println("Constraints");
        }
      if(!this.getCpSystem().equals(b.getCpSystem())){
         System.out.println("CpSystem");
        }
      if(!this.getDataAvail().equals(b.getDataAvail())){
         System.out.println("DataAvail");
        }
      if(!this.getDoi().equals(b.getDoi())){
         System.out.println("Doi");
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
      if(!this.getNrLinks().equals(b.getNrLinks())){
         System.out.println("NrLinks");
        }
      if(!this.getNrPages().equals(b.getNrPages())){
         System.out.println("NrPages");
        }
      if(!this.getNrReferences().equals(b.getNrReferences())){
         System.out.println("NrReferences");
        }
      if(!this.getPages().equals(b.getPages())){
         System.out.println("Pages");
        }
      if(!this.getRelatedTo().equals(b.getRelatedTo())){
         System.out.println("RelatedTo");
        }
      if(!this.getSolutionAvail().equals(b.getSolutionAvail())){
         System.out.println("SolutionAvail");
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
          this.getCollection().applicationSame(b.getCollection()) &&
          this.getConstraints().equals(b.getConstraints()) &&
          this.getCpSystem().equals(b.getCpSystem()) &&
          this.getDataAvail().equals(b.getDataAvail()) &&
          this.getDoi().equals(b.getDoi()) &&
          this.getKey().equals(b.getKey()) &&
          this.getLocalCopy().equals(b.getLocalCopy()) &&
          this.getName().equals(b.getName()) &&
          this.getNrCitations().equals(b.getNrCitations()) &&
          this.getNrLinks().equals(b.getNrLinks()) &&
          this.getNrPages().equals(b.getNrPages()) &&
          this.getNrReferences().equals(b.getNrReferences()) &&
          this.getPages().equals(b.getPages()) &&
          this.getRelatedTo().equals(b.getRelatedTo()) &&
          this.getSolutionAvail().equals(b.getSolutionAvail()) &&
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
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","InCollection",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getAuthors() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"authors","InCollection",(getAuthors()==null?"null":getAuthors().toString()),"",WarningType.NOTNULL);
        }
        if (getAuthors().size() == 0){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"authors","InCollection",(getAuthors()==null?"null":getAuthors().toString()),"",WarningType.NOTEMPTY);
        }
        if (getCollection() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"collection","InCollection",(getCollection()==null?"null":getCollection().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class InCollection
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
      if (attrName.equals("collection")){
         return (List) ((Scenario)base).getListCollection();
      }
      return null;
   }

}
