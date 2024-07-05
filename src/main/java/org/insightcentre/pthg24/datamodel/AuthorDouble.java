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

public  class AuthorDouble extends ApplicationObject{
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

    public String reason;

/**
 *  
 *
*/

    public List<Work> work1;

/**
 *  
 *
*/

    public List<Work> work2;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public AuthorDouble(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public AuthorDouble(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setAuthor1(null);
        setAuthor2(null);
        setReason("");
        setWork1(new ArrayList<Work>());
        setWork2(new ArrayList<Work>());
        applicationDataset.addAuthorDouble(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public AuthorDouble(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            Author author1,
            Author author2,
            String reason,
            List<Work> work1,
            List<Work> work2){
        super(applicationDataset,
            id,
            name);
        setAuthor1(author1);
        setAuthor2(author2);
        setReason(reason);
        setWork1(work1);
        setWork2(work2);
        applicationDataset.addAuthorDouble(this);
    }

    public AuthorDouble(AuthorDouble other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.author1,
            other.author2,
            other.reason,
            other.work1,
            other.work2);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        return getApplicationDataset().removeAuthorDouble(this) && getApplicationDataset().removeApplicationObject(this);
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
 *  get attribute reason
 *
 * @return String
*/

    public String getReason(){
        return this.reason;
    }

/**
 *  get attribute work1
 *
 * @return List<Work>
*/

    public List<Work> getWork1(){
        return this.work1;
    }

/**
 *  get attribute work2
 *
 * @return List<Work>
*/

    public List<Work> getWork2(){
        return this.work2;
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
 *  set attribute reason, mark dataset as dirty, mark dataset as not valid
@param reason String
 *
*/

    public void setReason(String reason){
        this.reason = reason;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute work1, mark dataset as dirty, mark dataset as not valid
@param work1 List<Work>
 *
*/

    public void setWork1(List<Work> work1){
        this.work1 = work1;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute work2, mark dataset as dirty, mark dataset as not valid
@param work2 List<Work>
 *
*/

    public void setWork2(List<Work> work2){
        this.work2 = work2;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getAuthor1().toColumnString()+ " " +getAuthor2().toColumnString()+ " " +getReason()+ " " +getWork1()+ " " +getWork2();
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
         out.println("<authorDouble "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " author1=\""+toXMLAuthor1()+"\""+
            " author2=\""+toXMLAuthor2()+"\""+
            " reason=\""+toXMLReason()+"\""+
            " work1=\""+toXMLWork1()+"\""+
            " work2=\""+toXMLWork2()+"\""+" />");
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

    String toXMLReason(){
        return this.safeXML(getReason());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLWork1(){
        String str="";
        for(Work x:getWork1()){
            str=str+" "+"ID_"+x.getId();
        }
        return str;
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLWork2(){
        String str="";
        for(Work x:getWork2()){
            str=str+" "+"ID_"+x.getId();
        }
        return str;
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>AuthorDouble</th>"+"<th>Name</th>"+"<th>Reason</th>"+"<th>Author1</th>"+"<th>Author2</th>"+"<th>Work1</th>"+"<th>Work2</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getReason()+"</td>"+ " " +"<td>"+getAuthor1().toColumnString()+"</td>"+ " " +"<td>"+getAuthor2().toColumnString()+"</td>"+ " " +"<td>"+getWork1()+"</td>"+ " " +"<td>"+getWork2()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a AuthorDouble item we are looking for
 * @param bList List<AuthorDouble> list of items in which we are searching
 * @return AuthorDouble entry of list b which is applicationSame() to a
*/

    public static AuthorDouble find(AuthorDouble a, List<AuthorDouble> bList){
        for(AuthorDouble b : bList){
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
 * @param name AuthorDouble name of the object we are looking for
 * @return AuthorDouble entry of the dataset with the given name; otherwise null
*/

    public static AuthorDouble findByName(ApplicationDataset base, String name){
        for(AuthorDouble a:base.getListAuthorDouble()) {
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
 * @param name AuthorDouble name of the object we are looking for
 * @return AuthorDouble entry of the dataset with the given name
*/

    public static AuthorDouble findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(AuthorDouble a:base.getListAuthorDouble()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        AuthorDouble res = new AuthorDouble(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return AuthorDouble first entry in the dataset of this type; null if that does not exists
*/

    public static AuthorDouble findFirst(ApplicationDataset base){
        if (base.getListAuthorDouble().isEmpty()) {
            return null;
        }
        return base.getListAuthorDouble().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return AuthorDouble some entry in the dataset of this type; null if that does not exists
*/

    public static AuthorDouble findAny(ApplicationDataset base){
        int size=base.getListAuthorDouble().size();
        if (size > 0) {
             return base.getListAuthorDouble().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return AuthorDouble last entry in the dataset of this type; null if that does not exists
*/

    public static AuthorDouble findLast(ApplicationDataset base){
        int size=base.getListAuthorDouble().size();
        if (size > 0) {
             return base.getListAuthorDouble().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b AuthorDouble compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(AuthorDouble b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b AuthorDouble compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(AuthorDouble b){
      if(!this.getAuthor1().applicationSame(b.getAuthor1())){
         System.out.println("Author1");
        }
      if(!this.getAuthor2().applicationSame(b.getAuthor2())){
         System.out.println("Author2");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getReason().equals(b.getReason())){
         System.out.println("Reason");
        }
      if (true) {         System.out.println("Work1");
        }
      if (true) {         System.out.println("Work2");
        }
        return  this.getAuthor1().applicationSame(b.getAuthor1()) &&
          this.getAuthor2().applicationSame(b.getAuthor2()) &&
          this.getName().equals(b.getName()) &&
          this.getReason().equals(b.getReason()) &&
          true &&
          true;
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","AuthorDouble",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getAuthor1() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"author1","AuthorDouble",(getAuthor1()==null?"null":getAuthor1().toString()),"",WarningType.NOTNULL);
        }
        if (getAuthor2() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"author2","AuthorDouble",(getAuthor2()==null?"null":getAuthor2().toString()),"",WarningType.NOTNULL);
        }
        if (getWork1() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"work1","AuthorDouble",(getWork1()==null?"null":getWork1().toString()),"",WarningType.NOTNULL);
        }
        if (getWork1().size() == 0){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"work1","AuthorDouble",(getWork1()==null?"null":getWork1().toString()),"",WarningType.NOTEMPTY);
        }
        if (getWork2() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"work2","AuthorDouble",(getWork2()==null?"null":getWork2().toString()),"",WarningType.NOTNULL);
        }
        if (getWork2().size() == 0){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"work2","AuthorDouble",(getWork2()==null?"null":getWork2().toString()),"",WarningType.NOTEMPTY);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class AuthorDouble
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
      if (attrName.equals("work1")){
         return (List) ((Scenario)base).getListWork();
      }
      if (attrName.equals("work2")){
         return (List) ((Scenario)base).getListWork();
      }
      return null;
   }

}
