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

public  class MissingCross extends ApplicationObject{
/**
 *  
 *
*/

    public String author;

/**
 *  
 *
*/

    public Integer count;

/**
 *  
 *
*/

    public Integer crossrefCitations;

/**
 *  
 *
*/

    public Integer crossrefReferences;

/**
 *  
 *
*/

    public String doi;

/**
 *  
 *
*/

    public String source;

/**
 *  
 *
*/

    public String title;

/**
 *  
 *
*/

    public String type;

/**
 *  
 *
*/

    public String url;

/**
 *  
 *
*/

    public Integer year;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public MissingCross(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public MissingCross(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setAuthor("");
        setCount(0);
        setCrossrefCitations(0);
        setCrossrefReferences(0);
        setDoi("");
        setSource("");
        setTitle("");
        setType("");
        setUrl("");
        setYear(0);
        applicationDataset.addMissingCross(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public MissingCross(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            String author,
            Integer count,
            Integer crossrefCitations,
            Integer crossrefReferences,
            String doi,
            String source,
            String title,
            String type,
            String url,
            Integer year){
        super(applicationDataset,
            id,
            name);
        setAuthor(author);
        setCount(count);
        setCrossrefCitations(crossrefCitations);
        setCrossrefReferences(crossrefReferences);
        setDoi(doi);
        setSource(source);
        setTitle(title);
        setType(type);
        setUrl(url);
        setYear(year);
        applicationDataset.addMissingCross(this);
    }

    public MissingCross(MissingCross other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.author,
            other.count,
            other.crossrefCitations,
            other.crossrefReferences,
            other.doi,
            other.source,
            other.title,
            other.type,
            other.url,
            other.year);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        getApplicationDataset().cascadeCrossReferenceMissingCross(this);
        return getApplicationDataset().removeMissingCross(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute author
 *
 * @return String
*/

    public String getAuthor(){
        return this.author;
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
 *  get attribute crossrefCitations
 *
 * @return Integer
*/

    public Integer getCrossrefCitations(){
        return this.crossrefCitations;
    }

/**
 *  get attribute crossrefReferences
 *
 * @return Integer
*/

    public Integer getCrossrefReferences(){
        return this.crossrefReferences;
    }

/**
 *  get attribute doi
 *
 * @return String
*/

    public String getDoi(){
        return this.doi;
    }

/**
 *  get attribute source
 *
 * @return String
*/

    public String getSource(){
        return this.source;
    }

/**
 *  get attribute title
 *
 * @return String
*/

    public String getTitle(){
        return this.title;
    }

/**
 *  get attribute type
 *
 * @return String
*/

    public String getType(){
        return this.type;
    }

/**
 *  get attribute url
 *
 * @return String
*/

    public String getUrl(){
        return this.url;
    }

/**
 *  get attribute year
 *
 * @return Integer
*/

    public Integer getYear(){
        return this.year;
    }

/**
 *  set attribute author, mark dataset as dirty, mark dataset as not valid
@param author String
 *
*/

    public void setAuthor(String author){
        this.author = author;
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
 *  set attribute crossrefCitations, mark dataset as dirty, mark dataset as not valid
@param crossrefCitations Integer
 *
*/

    public void setCrossrefCitations(Integer crossrefCitations){
        this.crossrefCitations = crossrefCitations;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute crossrefReferences, mark dataset as dirty, mark dataset as not valid
@param crossrefReferences Integer
 *
*/

    public void setCrossrefReferences(Integer crossrefReferences){
        this.crossrefReferences = crossrefReferences;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute doi, mark dataset as dirty, mark dataset as not valid
@param doi String
 *
*/

    public void setDoi(String doi){
        this.doi = doi;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute source, mark dataset as dirty, mark dataset as not valid
@param source String
 *
*/

    public void setSource(String source){
        this.source = source;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute title, mark dataset as dirty, mark dataset as not valid
@param title String
 *
*/

    public void setTitle(String title){
        this.title = title;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute type, mark dataset as dirty, mark dataset as not valid
@param type String
 *
*/

    public void setType(String type){
        this.type = type;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute url, mark dataset as dirty, mark dataset as not valid
@param url String
 *
*/

    public void setUrl(String url){
        this.url = url;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute year, mark dataset as dirty, mark dataset as not valid
@param year Integer
 *
*/

    public void setYear(Integer year){
        this.year = year;
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
 *  inc attribute crossrefCitations, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incCrossrefCitations(){
        this.crossrefCitations++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute crossrefReferences, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incCrossrefReferences(){
        this.crossrefReferences++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute year, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incYear(){
        this.year++;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getAuthor()+ " " +getCount()+ " " +getCrossrefCitations()+ " " +getCrossrefReferences()+ " " +getDoi()+ " " +getSource()+ " " +getTitle()+ " " +getType()+ " " +getUrl()+ " " +getYear();
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
         out.println("<missingCross "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " author=\""+toXMLAuthor()+"\""+
            " count=\""+toXMLCount()+"\""+
            " crossrefCitations=\""+toXMLCrossrefCitations()+"\""+
            " crossrefReferences=\""+toXMLCrossrefReferences()+"\""+
            " doi=\""+toXMLDoi()+"\""+
            " source=\""+toXMLSource()+"\""+
            " title=\""+toXMLTitle()+"\""+
            " type=\""+toXMLType()+"\""+
            " url=\""+toXMLUrl()+"\""+
            " year=\""+toXMLYear()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLAuthor(){
        return this.safeXML(getAuthor());
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

    String toXMLCrossrefCitations(){
        return this.getCrossrefCitations().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCrossrefReferences(){
        return this.getCrossrefReferences().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLDoi(){
        return this.safeXML(getDoi());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLSource(){
        return this.safeXML(getSource());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLTitle(){
        return this.safeXML(getTitle());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLType(){
        return this.safeXML(getType());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLUrl(){
        return this.safeXML(getUrl());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLYear(){
        return this.getYear().toString();
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>MissingCross</th>"+"<th>Name</th>"+"<th>Doi</th>"+"<th>Count</th>"+"<th>Year</th>"+"<th>Author</th>"+"<th>Source</th>"+"<th>Title</th>"+"<th>Url</th>"+"<th>Type</th>"+"<th>CrossrefReferences</th>"+"<th>CrossrefCitations</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getDoi()+"</td>"+ " " +"<td>"+getCount()+"</td>"+ " " +"<td>"+getYear()+"</td>"+ " " +"<td>"+getAuthor()+"</td>"+ " " +"<td>"+getSource()+"</td>"+ " " +"<td>"+getTitle()+"</td>"+ " " +"<td>"+getUrl()+"</td>"+ " " +"<td>"+getType()+"</td>"+ " " +"<td>"+getCrossrefReferences()+"</td>"+ " " +"<td>"+getCrossrefCitations()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a MissingCross item we are looking for
 * @param bList List<MissingCross> list of items in which we are searching
 * @return MissingCross entry of list b which is applicationSame() to a
*/

    public static MissingCross find(MissingCross a, List<MissingCross> bList){
        for(MissingCross b : bList){
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
 * @param name MissingCross name of the object we are looking for
 * @return MissingCross entry of the dataset with the given name; otherwise null
*/

    public static MissingCross findByName(ApplicationDataset base, String name){
        for(MissingCross a:base.getListMissingCross()) {
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
 * @param name MissingCross name of the object we are looking for
 * @return MissingCross entry of the dataset with the given name
*/

    public static MissingCross findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(MissingCross a:base.getListMissingCross()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        MissingCross res = new MissingCross(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return MissingCross first entry in the dataset of this type; null if that does not exists
*/

    public static MissingCross findFirst(ApplicationDataset base){
        if (base.getListMissingCross().isEmpty()) {
            return null;
        }
        return base.getListMissingCross().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return MissingCross some entry in the dataset of this type; null if that does not exists
*/

    public static MissingCross findAny(ApplicationDataset base){
        int size=base.getListMissingCross().size();
        if (size > 0) {
             return base.getListMissingCross().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return MissingCross last entry in the dataset of this type; null if that does not exists
*/

    public static MissingCross findLast(ApplicationDataset base){
        int size=base.getListMissingCross().size();
        if (size > 0) {
             return base.getListMissingCross().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b MissingCross compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(MissingCross b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b MissingCross compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(MissingCross b){
      if(!this.getAuthor().equals(b.getAuthor())){
         System.out.println("Author");
        }
      if(!this.getCount().equals(b.getCount())){
         System.out.println("Count");
        }
      if(!this.getCrossrefCitations().equals(b.getCrossrefCitations())){
         System.out.println("CrossrefCitations");
        }
      if(!this.getCrossrefReferences().equals(b.getCrossrefReferences())){
         System.out.println("CrossrefReferences");
        }
      if(!this.getDoi().equals(b.getDoi())){
         System.out.println("Doi");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getSource().equals(b.getSource())){
         System.out.println("Source");
        }
      if(!this.getTitle().equals(b.getTitle())){
         System.out.println("Title");
        }
      if(!this.getType().equals(b.getType())){
         System.out.println("Type");
        }
      if(!this.getUrl().equals(b.getUrl())){
         System.out.println("Url");
        }
      if(!this.getYear().equals(b.getYear())){
         System.out.println("Year");
        }
        return  this.getAuthor().equals(b.getAuthor()) &&
          this.getCount().equals(b.getCount()) &&
          this.getCrossrefCitations().equals(b.getCrossrefCitations()) &&
          this.getCrossrefReferences().equals(b.getCrossrefReferences()) &&
          this.getDoi().equals(b.getDoi()) &&
          this.getName().equals(b.getName()) &&
          this.getSource().equals(b.getSource()) &&
          this.getTitle().equals(b.getTitle()) &&
          this.getType().equals(b.getType()) &&
          this.getUrl().equals(b.getUrl()) &&
          this.getYear().equals(b.getYear());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","MissingCross",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class MissingCross
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
