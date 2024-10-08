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

public  class Authorship extends ApplicationObject{
/**
 *  
 *
*/

    public List<Affiliation> affiliation;

/**
 *  
 *
*/

    public Author author;

/**
 *  
 *
*/

    public Integer seqNr;

/**
 *  
 *
*/

    public String sequence;

/**
 *  
 *
*/

    public Work work;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public Authorship(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public Authorship(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setAffiliation(new ArrayList<Affiliation>());
        setAuthor(null);
        setSeqNr(0);
        setSequence("");
        setWork(null);
        applicationDataset.addAuthorship(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public Authorship(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            List<Affiliation> affiliation,
            Author author,
            Integer seqNr,
            String sequence,
            Work work){
        super(applicationDataset,
            id,
            name);
        setAffiliation(affiliation);
        setAuthor(author);
        setSeqNr(seqNr);
        setSequence(sequence);
        setWork(work);
        applicationDataset.addAuthorship(this);
    }

    public Authorship(Authorship other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.affiliation,
            other.author,
            other.seqNr,
            other.sequence,
            other.work);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        return getApplicationDataset().removeAuthorship(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute affiliation
 *
 * @return List<Affiliation>
*/

    public List<Affiliation> getAffiliation(){
        return this.affiliation;
    }

/**
 *  get attribute author
 *
 * @return Author
*/

    public Author getAuthor(){
        return this.author;
    }

/**
 *  get attribute seqNr
 *
 * @return Integer
*/

    public Integer getSeqNr(){
        return this.seqNr;
    }

/**
 *  get attribute sequence
 *
 * @return String
*/

    public String getSequence(){
        return this.sequence;
    }

/**
 *  get attribute work
 *
 * @return Work
*/

    public Work getWork(){
        return this.work;
    }

/**
 *  set attribute affiliation, mark dataset as dirty, mark dataset as not valid
@param affiliation List<Affiliation>
 *
*/

    public void setAffiliation(List<Affiliation> affiliation){
        this.affiliation = affiliation;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute author, mark dataset as dirty, mark dataset as not valid
@param author Author
 *
*/

    public void setAuthor(Author author){
        this.author = author;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute seqNr, mark dataset as dirty, mark dataset as not valid
@param seqNr Integer
 *
*/

    public void setSeqNr(Integer seqNr){
        this.seqNr = seqNr;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute sequence, mark dataset as dirty, mark dataset as not valid
@param sequence String
 *
*/

    public void setSequence(String sequence){
        this.sequence = sequence;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute work, mark dataset as dirty, mark dataset as not valid
@param work Work
 *
*/

    public void setWork(Work work){
        this.work = work;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute seqNr, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incSeqNr(){
        this.seqNr++;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getAffiliation()+ " " +getAuthor().toColumnString()+ " " +getSeqNr()+ " " +getSequence()+ " " +getWork().toColumnString();
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
         out.println("<authorship "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " affiliation=\""+toXMLAffiliation()+"\""+
            " author=\""+toXMLAuthor()+"\""+
            " seqNr=\""+toXMLSeqNr()+"\""+
            " sequence=\""+toXMLSequence()+"\""+
            " work=\""+toXMLWork()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLAffiliation(){
        String str="";
        for(Affiliation x:getAffiliation()){
            str=str+" "+"ID_"+x.getId();
        }
        return str;
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLAuthor(){
        return "ID_"+this.getAuthor().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLSeqNr(){
        return this.getSeqNr().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLSequence(){
        return this.safeXML(getSequence());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLWork(){
        return "ID_"+this.getWork().getId().toString();
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>Authorship</th>"+"<th>Name</th>"+"<th>SeqNr</th>"+"<th>Sequence</th>"+"<th>Author</th>"+"<th>Work</th>"+"<th>Affiliation</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getSeqNr()+"</td>"+ " " +"<td>"+getSequence()+"</td>"+ " " +"<td>"+getAuthor().toColumnString()+"</td>"+ " " +"<td>"+getWork().toColumnString()+"</td>"+ " " +"<td>"+getAffiliation()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a Authorship item we are looking for
 * @param bList List<Authorship> list of items in which we are searching
 * @return Authorship entry of list b which is applicationSame() to a
*/

    public static Authorship find(Authorship a, List<Authorship> bList){
        for(Authorship b : bList){
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
 * @param name Authorship name of the object we are looking for
 * @return Authorship entry of the dataset with the given name; otherwise null
*/

    public static Authorship findByName(ApplicationDataset base, String name){
        for(Authorship a:base.getListAuthorship()) {
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
 * @param name Authorship name of the object we are looking for
 * @return Authorship entry of the dataset with the given name
*/

    public static Authorship findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(Authorship a:base.getListAuthorship()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        Authorship res = new Authorship(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Authorship first entry in the dataset of this type; null if that does not exists
*/

    public static Authorship findFirst(ApplicationDataset base){
        if (base.getListAuthorship().isEmpty()) {
            return null;
        }
        return base.getListAuthorship().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Authorship some entry in the dataset of this type; null if that does not exists
*/

    public static Authorship findAny(ApplicationDataset base){
        int size=base.getListAuthorship().size();
        if (size > 0) {
             return base.getListAuthorship().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Authorship last entry in the dataset of this type; null if that does not exists
*/

    public static Authorship findLast(ApplicationDataset base){
        int size=base.getListAuthorship().size();
        if (size > 0) {
             return base.getListAuthorship().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b Authorship compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(Authorship b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b Authorship compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(Authorship b){
      if (true) {         System.out.println("Affiliation");
        }
      if(!this.getAuthor().applicationSame(b.getAuthor())){
         System.out.println("Author");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getSeqNr().equals(b.getSeqNr())){
         System.out.println("SeqNr");
        }
      if(!this.getSequence().equals(b.getSequence())){
         System.out.println("Sequence");
        }
      if(!this.getWork().applicationSame(b.getWork())){
         System.out.println("Work");
        }
        return  true &&
          this.getAuthor().applicationSame(b.getAuthor()) &&
          this.getName().equals(b.getName()) &&
          this.getSeqNr().equals(b.getSeqNr()) &&
          this.getSequence().equals(b.getSequence()) &&
          this.getWork().applicationSame(b.getWork());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","Authorship",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getAffiliation() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"affiliation","Authorship",(getAffiliation()==null?"null":getAffiliation().toString()),"",WarningType.NOTNULL);
        }
        if (getAuthor() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"author","Authorship",(getAuthor()==null?"null":getAuthor().toString()),"",WarningType.NOTNULL);
        }
        if (getWork() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"work","Authorship",(getWork()==null?"null":getWork().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class Authorship
    }

/**
 *  This method states if the class depends on the solver.
 *
*/

    public static Boolean isSolverDependent(){
        return false;
    }

   public List<ApplicationObjectInterface> getFeasibleValues(ApplicationDatasetInterface base,String attrName){
      if (attrName.equals("affiliation")){
         return (List) ((Scenario)base).getListAffiliation();
      }
      if (attrName.equals("author")){
         return (List) ((Scenario)base).getListAuthor();
      }
      if (attrName.equals("work")){
         return (List) ((Scenario)base).getListWork();
      }
      return null;
   }

}
