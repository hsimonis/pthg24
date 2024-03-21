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

public  class Author extends ApplicationObject implements AppearInCollection{
/**
 *  
 *
*/

    public String familyName;

/**
 *  
 *
*/

    public String key;

/**
 *  
 *
*/

    public Integer nrBackgroundCitations;

/**
 *  
 *
*/

    public Integer nrBackgroundWorks;

/**
 *  
 *
*/

    public Integer nrCitations;

/**
 *  
 *
*/

    public Integer nrWorks;

/**
 *  
 *
*/

    public String shortName;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public Author(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public Author(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setFamilyName("");
        setKey("");
        setNrBackgroundCitations(0);
        setNrBackgroundWorks(0);
        setNrCitations(0);
        setNrWorks(0);
        setShortName("");
        applicationDataset.addAuthor(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public Author(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            String familyName,
            String key,
            Integer nrBackgroundCitations,
            Integer nrBackgroundWorks,
            Integer nrCitations,
            Integer nrWorks,
            String shortName){
        super(applicationDataset,
            id,
            name);
        setFamilyName(familyName);
        setKey(key);
        setNrBackgroundCitations(nrBackgroundCitations);
        setNrBackgroundWorks(nrBackgroundWorks);
        setNrCitations(nrCitations);
        setNrWorks(nrWorks);
        setShortName(shortName);
        applicationDataset.addAuthor(this);
    }

    public Author(Author other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.familyName,
            other.key,
            other.nrBackgroundCitations,
            other.nrBackgroundWorks,
            other.nrCitations,
            other.nrWorks,
            other.shortName);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        getApplicationDataset().cascadeWorkAuthors(this);
        getApplicationDataset().cascadeAuthorshipAuthor(this);
        return getApplicationDataset().removeAuthor(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  (varargs) build list of items of type Author
 *
 * @param pList multiple items of type Author
 * @return List<Author>
*/

    static public List<Author> buildList(Author... pList){
        List<Author> l = new ArrayList<Author>();
        l.addAll(Arrays.asList(pList));
        return l;
    }

/**
 *  get attribute familyName
 *
 * @return String
*/

    public String getFamilyName(){
        return this.familyName;
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
 *  get attribute nrBackgroundCitations
 *
 * @return Integer
*/

    public Integer getNrBackgroundCitations(){
        return this.nrBackgroundCitations;
    }

/**
 *  get attribute nrBackgroundWorks
 *
 * @return Integer
*/

    public Integer getNrBackgroundWorks(){
        return this.nrBackgroundWorks;
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
 *  get attribute nrWorks
 *
 * @return Integer
*/

    public Integer getNrWorks(){
        return this.nrWorks;
    }

/**
 *  get attribute shortName
 *
 * @return String
*/

    public String getShortName(){
        return this.shortName;
    }

/**
 *  set attribute familyName, mark dataset as dirty, mark dataset as not valid
@param familyName String
 *
*/

    public void setFamilyName(String familyName){
        this.familyName = familyName;
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
 *  set attribute nrBackgroundCitations, mark dataset as dirty, mark dataset as not valid
@param nrBackgroundCitations Integer
 *
*/

    public void setNrBackgroundCitations(Integer nrBackgroundCitations){
        this.nrBackgroundCitations = nrBackgroundCitations;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute nrBackgroundWorks, mark dataset as dirty, mark dataset as not valid
@param nrBackgroundWorks Integer
 *
*/

    public void setNrBackgroundWorks(Integer nrBackgroundWorks){
        this.nrBackgroundWorks = nrBackgroundWorks;
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
 *  set attribute shortName, mark dataset as dirty, mark dataset as not valid
@param shortName String
 *
*/

    public void setShortName(String shortName){
        this.shortName = shortName;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute nrBackgroundCitations, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrBackgroundCitations(){
        this.nrBackgroundCitations++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute nrBackgroundWorks, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrBackgroundWorks(){
        this.nrBackgroundWorks++;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getFamilyName()+ " " +getKey()+ " " +getNrBackgroundCitations()+ " " +getNrBackgroundWorks()+ " " +getNrCitations()+ " " +getNrWorks()+ " " +getShortName();
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
         out.println("<author "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " familyName=\""+toXMLFamilyName()+"\""+
            " key=\""+toXMLKey()+"\""+
            " nrBackgroundCitations=\""+toXMLNrBackgroundCitations()+"\""+
            " nrBackgroundWorks=\""+toXMLNrBackgroundWorks()+"\""+
            " nrCitations=\""+toXMLNrCitations()+"\""+
            " nrWorks=\""+toXMLNrWorks()+"\""+
            " shortName=\""+toXMLShortName()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLFamilyName(){
        return this.safeXML(getFamilyName());
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

    String toXMLNrBackgroundCitations(){
        return this.getNrBackgroundCitations().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLNrBackgroundWorks(){
        return this.getNrBackgroundWorks().toString();
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

    String toXMLNrWorks(){
        return this.getNrWorks().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLShortName(){
        return this.safeXML(getShortName());
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>Author</th>"+"<th>Name</th>"+"<th>ShortName</th>"+"<th>FamilyName</th>"+"<th>Key</th>"+"<th>NrWorks</th>"+"<th>NrCitations</th>"+"<th>NrBackgroundWorks</th>"+"<th>NrBackgroundCitations</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getShortName()+"</td>"+ " " +"<td>"+getFamilyName()+"</td>"+ " " +"<td>"+getKey()+"</td>"+ " " +"<td>"+getNrWorks()+"</td>"+ " " +"<td>"+getNrCitations()+"</td>"+ " " +"<td>"+getNrBackgroundWorks()+"</td>"+ " " +"<td>"+getNrBackgroundCitations()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a Author item we are looking for
 * @param bList List<Author> list of items in which we are searching
 * @return Author entry of list b which is applicationSame() to a
*/

    public static Author find(Author a, List<Author> bList){
        for(Author b : bList){
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
 * @param name Author name of the object we are looking for
 * @return Author entry of the dataset with the given name; otherwise null
*/

    public static Author findByName(ApplicationDataset base, String name){
        for(Author a:base.getListAuthor()) {
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
 * @param name Author name of the object we are looking for
 * @return Author entry of the dataset with the given name
*/

    public static Author findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(Author a:base.getListAuthor()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        Author res = new Author(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Author first entry in the dataset of this type; null if that does not exists
*/

    public static Author findFirst(ApplicationDataset base){
        if (base.getListAuthor().isEmpty()) {
            return null;
        }
        return base.getListAuthor().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Author some entry in the dataset of this type; null if that does not exists
*/

    public static Author findAny(ApplicationDataset base){
        int size=base.getListAuthor().size();
        if (size > 0) {
             return base.getListAuthor().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Author last entry in the dataset of this type; null if that does not exists
*/

    public static Author findLast(ApplicationDataset base){
        int size=base.getListAuthor().size();
        if (size > 0) {
             return base.getListAuthor().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b Author compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(Author b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b Author compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(Author b){
      if(!this.getFamilyName().equals(b.getFamilyName())){
         System.out.println("FamilyName");
        }
      if(!this.getKey().equals(b.getKey())){
         System.out.println("Key");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getNrBackgroundCitations().equals(b.getNrBackgroundCitations())){
         System.out.println("NrBackgroundCitations");
        }
      if(!this.getNrBackgroundWorks().equals(b.getNrBackgroundWorks())){
         System.out.println("NrBackgroundWorks");
        }
      if(!this.getNrCitations().equals(b.getNrCitations())){
         System.out.println("NrCitations");
        }
      if(!this.getNrWorks().equals(b.getNrWorks())){
         System.out.println("NrWorks");
        }
      if(!this.getShortName().equals(b.getShortName())){
         System.out.println("ShortName");
        }
        return  this.getFamilyName().equals(b.getFamilyName()) &&
          this.getKey().equals(b.getKey()) &&
          this.getName().equals(b.getName()) &&
          this.getNrBackgroundCitations().equals(b.getNrBackgroundCitations()) &&
          this.getNrBackgroundWorks().equals(b.getNrBackgroundWorks()) &&
          this.getNrCitations().equals(b.getNrCitations()) &&
          this.getNrWorks().equals(b.getNrWorks()) &&
          this.getShortName().equals(b.getShortName());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","Author",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class Author
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
