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

public  class CountryCollab extends ApplicationObject{
/**
 *  
 *
*/

    public Integer count;

/**
 *  
 *
*/

    public ScopusCountry country1;

/**
 *  
 *
*/

    public ScopusCountry country2;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public CountryCollab(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public CountryCollab(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setCount(0);
        setCountry1(null);
        setCountry2(null);
        applicationDataset.addCountryCollab(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public CountryCollab(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            Integer count,
            ScopusCountry country1,
            ScopusCountry country2){
        super(applicationDataset,
            id,
            name);
        setCount(count);
        setCountry1(country1);
        setCountry2(country2);
        applicationDataset.addCountryCollab(this);
    }

    public CountryCollab(CountryCollab other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.count,
            other.country1,
            other.country2);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        return getApplicationDataset().removeCountryCollab(this) && getApplicationDataset().removeApplicationObject(this);
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
 *  get attribute country1
 *
 * @return ScopusCountry
*/

    public ScopusCountry getCountry1(){
        return this.country1;
    }

/**
 *  get attribute country2
 *
 * @return ScopusCountry
*/

    public ScopusCountry getCountry2(){
        return this.country2;
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
 *  set attribute country1, mark dataset as dirty, mark dataset as not valid
@param country1 ScopusCountry
 *
*/

    public void setCountry1(ScopusCountry country1){
        this.country1 = country1;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute country2, mark dataset as dirty, mark dataset as not valid
@param country2 ScopusCountry
 *
*/

    public void setCountry2(ScopusCountry country2){
        this.country2 = country2;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getCount()+ " " +getCountry1().toColumnString()+ " " +getCountry2().toColumnString();
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
         out.println("<countryCollab "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " count=\""+toXMLCount()+"\""+
            " country1=\""+toXMLCountry1()+"\""+
            " country2=\""+toXMLCountry2()+"\""+" />");
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

    String toXMLCountry1(){
        return "ID_"+this.getCountry1().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCountry2(){
        return "ID_"+this.getCountry2().getId().toString();
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>CountryCollab</th>"+"<th>Name</th>"+"<th>Country1</th>"+"<th>Country2</th>"+"<th>Count</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getCountry1().toColumnString()+"</td>"+ " " +"<td>"+getCountry2().toColumnString()+"</td>"+ " " +"<td>"+getCount()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a CountryCollab item we are looking for
 * @param bList List<CountryCollab> list of items in which we are searching
 * @return CountryCollab entry of list b which is applicationSame() to a
*/

    public static CountryCollab find(CountryCollab a, List<CountryCollab> bList){
        for(CountryCollab b : bList){
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
 * @param name CountryCollab name of the object we are looking for
 * @return CountryCollab entry of the dataset with the given name; otherwise null
*/

    public static CountryCollab findByName(ApplicationDataset base, String name){
        for(CountryCollab a:base.getListCountryCollab()) {
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
 * @param name CountryCollab name of the object we are looking for
 * @return CountryCollab entry of the dataset with the given name
*/

    public static CountryCollab findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(CountryCollab a:base.getListCountryCollab()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        CountryCollab res = new CountryCollab(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return CountryCollab first entry in the dataset of this type; null if that does not exists
*/

    public static CountryCollab findFirst(ApplicationDataset base){
        if (base.getListCountryCollab().isEmpty()) {
            return null;
        }
        return base.getListCountryCollab().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return CountryCollab some entry in the dataset of this type; null if that does not exists
*/

    public static CountryCollab findAny(ApplicationDataset base){
        int size=base.getListCountryCollab().size();
        if (size > 0) {
             return base.getListCountryCollab().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return CountryCollab last entry in the dataset of this type; null if that does not exists
*/

    public static CountryCollab findLast(ApplicationDataset base){
        int size=base.getListCountryCollab().size();
        if (size > 0) {
             return base.getListCountryCollab().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b CountryCollab compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(CountryCollab b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b CountryCollab compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(CountryCollab b){
      if(!this.getCount().equals(b.getCount())){
         System.out.println("Count");
        }
      if(!this.getCountry1().applicationSame(b.getCountry1())){
         System.out.println("Country1");
        }
      if(!this.getCountry2().applicationSame(b.getCountry2())){
         System.out.println("Country2");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
        return  this.getCount().equals(b.getCount()) &&
          this.getCountry1().applicationSame(b.getCountry1()) &&
          this.getCountry2().applicationSame(b.getCountry2()) &&
          this.getName().equals(b.getName());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","CountryCollab",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getCountry1() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"country1","CountryCollab",(getCountry1()==null?"null":getCountry1().toString()),"",WarningType.NOTNULL);
        }
        if (getCountry2() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"country2","CountryCollab",(getCountry2()==null?"null":getCountry2().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class CountryCollab
    }

/**
 *  This method states if the class depends on the solver.
 *
*/

    public static Boolean isSolverDependent(){
        return false;
    }

   public List<ApplicationObjectInterface> getFeasibleValues(ApplicationDatasetInterface base,String attrName){
      if (attrName.equals("country1")){
         return (List) ((Scenario)base).getListScopusCountry();
      }
      if (attrName.equals("country2")){
         return (List) ((Scenario)base).getListScopusCountry();
      }
      return null;
   }

}
