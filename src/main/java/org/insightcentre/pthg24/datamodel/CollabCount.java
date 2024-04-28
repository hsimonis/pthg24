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

public  class CollabCount extends ApplicationObject{
/**
 *  
 *
*/

    public ScopusAffiliation affiliation1;

/**
 *  
 *
*/

    public ScopusAffiliation affiliation2;

/**
 *  
 *
*/

    public Integer count;

/**
 *  
 *
*/

    public Double fraction;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public CollabCount(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public CollabCount(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setAffiliation1(null);
        setAffiliation2(null);
        setCount(0);
        setFraction(0.0);
        applicationDataset.addCollabCount(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public CollabCount(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            ScopusAffiliation affiliation1,
            ScopusAffiliation affiliation2,
            Integer count,
            Double fraction){
        super(applicationDataset,
            id,
            name);
        setAffiliation1(affiliation1);
        setAffiliation2(affiliation2);
        setCount(count);
        setFraction(fraction);
        applicationDataset.addCollabCount(this);
    }

    public CollabCount(CollabCount other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.affiliation1,
            other.affiliation2,
            other.count,
            other.fraction);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        return getApplicationDataset().removeCollabCount(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute affiliation1
 *
 * @return ScopusAffiliation
*/

    public ScopusAffiliation getAffiliation1(){
        return this.affiliation1;
    }

/**
 *  get attribute affiliation2
 *
 * @return ScopusAffiliation
*/

    public ScopusAffiliation getAffiliation2(){
        return this.affiliation2;
    }

/**
 *  get attribute count
 *
 * @return Integer
*/

    public Integer getCount(){
        return this.count;
    }

/**
 *  get attribute fraction
 *
 * @return Double
*/

    public Double getFraction(){
        return this.fraction;
    }

/**
 *  set attribute affiliation1, mark dataset as dirty, mark dataset as not valid
@param affiliation1 ScopusAffiliation
 *
*/

    public void setAffiliation1(ScopusAffiliation affiliation1){
        this.affiliation1 = affiliation1;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute affiliation2, mark dataset as dirty, mark dataset as not valid
@param affiliation2 ScopusAffiliation
 *
*/

    public void setAffiliation2(ScopusAffiliation affiliation2){
        this.affiliation2 = affiliation2;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute count, mark dataset as dirty, mark dataset as not valid
@param count Integer
 *
*/

    public void setCount(Integer count){
        this.count = count;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute fraction, mark dataset as dirty, mark dataset as not valid
@param fraction Double
 *
*/

    public void setFraction(Double fraction){
        this.fraction = fraction;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute count, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incCount(){
        this.count++;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getAffiliation1().toColumnString()+ " " +getAffiliation2().toColumnString()+ " " +getCount()+ " " +getFraction();
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
         out.println("<collabCount "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " affiliation1=\""+toXMLAffiliation1()+"\""+
            " affiliation2=\""+toXMLAffiliation2()+"\""+
            " count=\""+toXMLCount()+"\""+
            " fraction=\""+toXMLFraction()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLAffiliation1(){
        return "ID_"+this.getAffiliation1().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLAffiliation2(){
        return "ID_"+this.getAffiliation2().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCount(){
        return this.getCount().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLFraction(){
        return this.getFraction().toString();
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>CollabCount</th>"+"<th>Name</th>"+"<th>Affiliation1</th>"+"<th>Affiliation2</th>"+"<th>Count</th>"+"<th>Fraction</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getAffiliation1().toColumnString()+"</td>"+ " " +"<td>"+getAffiliation2().toColumnString()+"</td>"+ " " +"<td>"+getCount()+"</td>"+ " " +"<td>"+getFraction()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a CollabCount item we are looking for
 * @param bList List<CollabCount> list of items in which we are searching
 * @return CollabCount entry of list b which is applicationSame() to a
*/

    public static CollabCount find(CollabCount a, List<CollabCount> bList){
        for(CollabCount b : bList){
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
 * @param name CollabCount name of the object we are looking for
 * @return CollabCount entry of the dataset with the given name; otherwise null
*/

    public static CollabCount findByName(ApplicationDataset base, String name){
        for(CollabCount a:base.getListCollabCount()) {
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
 * @param name CollabCount name of the object we are looking for
 * @return CollabCount entry of the dataset with the given name
*/

    public static CollabCount findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(CollabCount a:base.getListCollabCount()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        CollabCount res = new CollabCount(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return CollabCount first entry in the dataset of this type; null if that does not exists
*/

    public static CollabCount findFirst(ApplicationDataset base){
        if (base.getListCollabCount().isEmpty()) {
            return null;
        }
        return base.getListCollabCount().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return CollabCount some entry in the dataset of this type; null if that does not exists
*/

    public static CollabCount findAny(ApplicationDataset base){
        int size=base.getListCollabCount().size();
        if (size > 0) {
             return base.getListCollabCount().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return CollabCount last entry in the dataset of this type; null if that does not exists
*/

    public static CollabCount findLast(ApplicationDataset base){
        int size=base.getListCollabCount().size();
        if (size > 0) {
             return base.getListCollabCount().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b CollabCount compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(CollabCount b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b CollabCount compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(CollabCount b){
      if(!this.getAffiliation1().applicationSame(b.getAffiliation1())){
         System.out.println("Affiliation1");
        }
      if(!this.getAffiliation2().applicationSame(b.getAffiliation2())){
         System.out.println("Affiliation2");
        }
      if(!this.getCount().equals(b.getCount())){
         System.out.println("Count");
        }
      if(!this.getFraction().equals(b.getFraction())){
         System.out.println("Fraction");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
        return  this.getAffiliation1().applicationSame(b.getAffiliation1()) &&
          this.getAffiliation2().applicationSame(b.getAffiliation2()) &&
          this.getCount().equals(b.getCount()) &&
          this.getFraction().equals(b.getFraction()) &&
          this.getName().equals(b.getName());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","CollabCount",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getAffiliation1() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"affiliation1","CollabCount",(getAffiliation1()==null?"null":getAffiliation1().toString()),"",WarningType.NOTNULL);
        }
        if (getAffiliation2() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"affiliation2","CollabCount",(getAffiliation2()==null?"null":getAffiliation2().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class CollabCount
    }

/**
 *  This method states if the class depends on the solver.
 *
*/

    public static Boolean isSolverDependent(){
        return false;
    }

   public List<ApplicationObjectInterface> getFeasibleValues(ApplicationDatasetInterface base,String attrName){
      if (attrName.equals("affiliation1")){
         return (List) ((Scenario)base).getListScopusAffiliation();
      }
      if (attrName.equals("affiliation2")){
         return (List) ((Scenario)base).getListScopusAffiliation();
      }
      return null;
   }

}
