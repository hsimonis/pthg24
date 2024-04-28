// licence details to be added
package org.insightcentre.pthg24.datamodel;
import org.insightcentre.pthg24.datamodel.ApplicationDataset;
import org.insightcentre.pthg24.datamodel.ApplicationObject;
import org.insightcentre.pthg24.datamodel.ApplicationDifference;
import org.insightcentre.pthg24.datamodel.ApplicationWarning;
import org.insightcentre.pthg24.datamodel.Scenario;
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

public  class Coauthor extends ApplicationObject{
/**
 *  
 *
*/

    public Author author1;

/**
 *  
 *
*/

    public Author author2;

/**
 *  
 *
*/

    public Integer earliestYear;

/**
 *  
 *
*/

    public Integer latestYear;

/**
 *  
 *
*/

    public Integer nrCites;

/**
 *  
 *
*/

    public Integer nrWorks;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public Coauthor(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public Coauthor(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setAuthor1(null);
        setAuthor2(null);
        setEarliestYear(0);
        setLatestYear(0);
        setNrCites(0);
        setNrWorks(0);
        applicationDataset.addCoauthor(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public Coauthor(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            Author author1,
            Author author2,
            Integer earliestYear,
            Integer latestYear,
            Integer nrCites,
            Integer nrWorks){
        super(applicationDataset,
            id,
            name);
        setAuthor1(author1);
        setAuthor2(author2);
        setEarliestYear(earliestYear);
        setLatestYear(latestYear);
        setNrCites(nrCites);
        setNrWorks(nrWorks);
        applicationDataset.addCoauthor(this);
    }

    public Coauthor(Coauthor other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.author1,
            other.author2,
            other.earliestYear,
            other.latestYear,
            other.nrCites,
            other.nrWorks);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        return getApplicationDataset().removeCoauthor(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute author1
 *
 * @return Author
*/

    public Author getAuthor1(){
        return this.author1;
    }

/**
 *  get attribute author2
 *
 * @return Author
*/

    public Author getAuthor2(){
        return this.author2;
    }

/**
 *  get attribute earliestYear
 *
 * @return Integer
*/

    public Integer getEarliestYear(){
        return this.earliestYear;
    }

/**
 *  get attribute latestYear
 *
 * @return Integer
*/

    public Integer getLatestYear(){
        return this.latestYear;
    }

/**
 *  get attribute nrCites
 *
 * @return Integer
*/

    public Integer getNrCites(){
        return this.nrCites;
    }

/**
 *  get attribute nrWorks
 *
 * @return Integer
*/

    public Integer getNrWorks(){
        return this.nrWorks;
    }

/**
 *  set attribute author1, mark dataset as dirty, mark dataset as not valid
@param author1 Author
 *
*/

    public void setAuthor1(Author author1){
        this.author1 = author1;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute author2, mark dataset as dirty, mark dataset as not valid
@param author2 Author
 *
*/

    public void setAuthor2(Author author2){
        this.author2 = author2;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute earliestYear, mark dataset as dirty, mark dataset as not valid
@param earliestYear Integer
 *
*/

    public void setEarliestYear(Integer earliestYear){
        this.earliestYear = earliestYear;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute latestYear, mark dataset as dirty, mark dataset as not valid
@param latestYear Integer
 *
*/

    public void setLatestYear(Integer latestYear){
        this.latestYear = latestYear;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute nrCites, mark dataset as dirty, mark dataset as not valid
@param nrCites Integer
 *
*/

    public void setNrCites(Integer nrCites){
        this.nrCites = nrCites;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute nrWorks, mark dataset as dirty, mark dataset as not valid
@param nrWorks Integer
 *
*/

    public void setNrWorks(Integer nrWorks){
        this.nrWorks = nrWorks;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute earliestYear, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incEarliestYear(){
        this.earliestYear++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute latestYear, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incLatestYear(){
        this.latestYear++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute nrCites, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrCites(){
        this.nrCites++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute nrWorks, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrWorks(){
        this.nrWorks++;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getAuthor1().toColumnString()+ " " +getAuthor2().toColumnString()+ " " +getEarliestYear()+ " " +getLatestYear()+ " " +getNrCites()+ " " +getNrWorks();
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
         out.println("<coauthor "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " author1=\""+toXMLAuthor1()+"\""+
            " author2=\""+toXMLAuthor2()+"\""+
            " earliestYear=\""+toXMLEarliestYear()+"\""+
            " latestYear=\""+toXMLLatestYear()+"\""+
            " nrCites=\""+toXMLNrCites()+"\""+
            " nrWorks=\""+toXMLNrWorks()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLAuthor1(){
        return "ID_"+this.getAuthor1().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLAuthor2(){
        return "ID_"+this.getAuthor2().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLEarliestYear(){
        return this.getEarliestYear().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLLatestYear(){
        return this.getLatestYear().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLNrCites(){
        return this.getNrCites().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLNrWorks(){
        return this.getNrWorks().toString();
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>Coauthor</th>"+"<th>Name</th>"+"<th>Author1</th>"+"<th>Author2</th>"+"<th>NrWorks</th>"+"<th>NrCites</th>"+"<th>EarliestYear</th>"+"<th>LatestYear</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getAuthor1().toColumnString()+"</td>"+ " " +"<td>"+getAuthor2().toColumnString()+"</td>"+ " " +"<td>"+getNrWorks()+"</td>"+ " " +"<td>"+getNrCites()+"</td>"+ " " +"<td>"+getEarliestYear()+"</td>"+ " " +"<td>"+getLatestYear()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a Coauthor item we are looking for
 * @param bList List<Coauthor> list of items in which we are searching
 * @return Coauthor entry of list b which is applicationSame() to a
*/

    public static Coauthor find(Coauthor a, List<Coauthor> bList){
        for(Coauthor b : bList){
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
 * @param name Coauthor name of the object we are looking for
 * @return Coauthor entry of the dataset with the given name; otherwise null
*/

    public static Coauthor findByName(ApplicationDataset base, String name){
        for(Coauthor a:base.getListCoauthor()) {
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
 * @param name Coauthor name of the object we are looking for
 * @return Coauthor entry of the dataset with the given name
*/

    public static Coauthor findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(Coauthor a:base.getListCoauthor()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        Coauthor res = new Coauthor(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Coauthor first entry in the dataset of this type; null if that does not exists
*/

    public static Coauthor findFirst(ApplicationDataset base){
        if (base.getListCoauthor().isEmpty()) {
            return null;
        }
        return base.getListCoauthor().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Coauthor some entry in the dataset of this type; null if that does not exists
*/

    public static Coauthor findAny(ApplicationDataset base){
        int size=base.getListCoauthor().size();
        if (size > 0) {
             return base.getListCoauthor().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Coauthor last entry in the dataset of this type; null if that does not exists
*/

    public static Coauthor findLast(ApplicationDataset base){
        int size=base.getListCoauthor().size();
        if (size > 0) {
             return base.getListCoauthor().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b Coauthor compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(Coauthor b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b Coauthor compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(Coauthor b){
      if(!this.getAuthor1().applicationSame(b.getAuthor1())){
         System.out.println("Author1");
        }
      if(!this.getAuthor2().applicationSame(b.getAuthor2())){
         System.out.println("Author2");
        }
      if(!this.getEarliestYear().equals(b.getEarliestYear())){
         System.out.println("EarliestYear");
        }
      if(!this.getLatestYear().equals(b.getLatestYear())){
         System.out.println("LatestYear");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getNrCites().equals(b.getNrCites())){
         System.out.println("NrCites");
        }
      if(!this.getNrWorks().equals(b.getNrWorks())){
         System.out.println("NrWorks");
        }
        return  this.getAuthor1().applicationSame(b.getAuthor1()) &&
          this.getAuthor2().applicationSame(b.getAuthor2()) &&
          this.getEarliestYear().equals(b.getEarliestYear()) &&
          this.getLatestYear().equals(b.getLatestYear()) &&
          this.getName().equals(b.getName()) &&
          this.getNrCites().equals(b.getNrCites()) &&
          this.getNrWorks().equals(b.getNrWorks());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","Coauthor",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getAuthor1() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"author1","Coauthor",(getAuthor1()==null?"null":getAuthor1().toString()),"",WarningType.NOTNULL);
        }
        if (getAuthor2() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"author2","Coauthor",(getAuthor2()==null?"null":getAuthor2().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class Coauthor
    }

/**
 *  This method states if the class depends on the solver.
 *
*/

    public static Boolean isSolverDependent(){
        return false;
    }

   public List<ApplicationObjectInterface> getFeasibleValues(ApplicationDatasetInterface base,String attrName){
      if (attrName.equals("author1")){
         return (List) ((Scenario)base).getListAuthor();
      }
      if (attrName.equals("author2")){
         return (List) ((Scenario)base).getListAuthor();
      }
      return null;
   }

}
