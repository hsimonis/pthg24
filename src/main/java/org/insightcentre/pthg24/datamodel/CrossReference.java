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

public abstract class CrossReference extends ApplicationObject{
/**
 *  
 *
*/

    public String author;

/**
 *  
 *
*/

    public String key;

/**
 *  
 *
*/

    public MissingCross missingCross;

/**
 *  
 *
*/

    public MissingWork missingWork;

/**
 *  
 *
*/

    public Work referredWork;

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

    public Work work;

/**
 *  
 *
*/

    public Integer year;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public CrossReference(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public CrossReference(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setAuthor("");
        setKey("");
        setMissingCross(null);
        setMissingWork(null);
        setReferredWork(null);
        setSource("");
        setTitle("");
        setWork(null);
        setYear(0);
        applicationDataset.addCrossReference(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public CrossReference(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            String author,
            String key,
            MissingCross missingCross,
            MissingWork missingWork,
            Work referredWork,
            String source,
            String title,
            Work work,
            Integer year){
        super(applicationDataset,
            id,
            name);
        setAuthor(author);
        setKey(key);
        setMissingCross(missingCross);
        setMissingWork(missingWork);
        setReferredWork(referredWork);
        setSource(source);
        setTitle(title);
        setWork(work);
        setYear(year);
        applicationDataset.addCrossReference(this);
    }

    public CrossReference(CrossReference other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.author,
            other.key,
            other.missingCross,
            other.missingWork,
            other.referredWork,
            other.source,
            other.title,
            other.work,
            other.year);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        return getApplicationDataset().removeCrossReference(this) && getApplicationDataset().removeApplicationObject(this);
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
 *  get attribute key
 *
 * @return String
*/

    public String getKey(){
        return this.key;
    }

/**
 *  get attribute missingCross
 *
 * @return MissingCross
*/

    public MissingCross getMissingCross(){
        return this.missingCross;
    }

/**
 *  get attribute missingWork
 *
 * @return MissingWork
*/

    public MissingWork getMissingWork(){
        return this.missingWork;
    }

/**
 *  get attribute referredWork
 *
 * @return Work
*/

    public Work getReferredWork(){
        return this.referredWork;
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
 *  get attribute work
 *
 * @return Work
*/

    public Work getWork(){
        return this.work;
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
 *  set attribute missingCross, mark dataset as dirty, mark dataset as not valid
@param missingCross MissingCross
 *
*/

    public void setMissingCross(MissingCross missingCross){
        this.missingCross = missingCross;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute missingWork, mark dataset as dirty, mark dataset as not valid
@param missingWork MissingWork
 *
*/

    public void setMissingWork(MissingWork missingWork){
        this.missingWork = missingWork;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute referredWork, mark dataset as dirty, mark dataset as not valid
@param referredWork Work
 *
*/

    public void setReferredWork(Work referredWork){
        this.referredWork = referredWork;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getAuthor()+ " " +getKey()+ " " +(getMissingCross() == null ? "" : getMissingCross().toColumnString())+ " " +(getMissingWork() == null ? "" : getMissingWork().toColumnString())+ " " +(getReferredWork() == null ? "" : getReferredWork().toColumnString())+ " " +getSource()+ " " +getTitle()+ " " +getWork().toColumnString()+ " " +getYear();
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
         out.println("<crossReference "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " author=\""+toXMLAuthor()+"\""+
            " key=\""+toXMLKey()+"\""+
            " missingCross=\""+toXMLMissingCross()+"\""+
            " missingWork=\""+toXMLMissingWork()+"\""+
            " referredWork=\""+toXMLReferredWork()+"\""+
            " source=\""+toXMLSource()+"\""+
            " title=\""+toXMLTitle()+"\""+
            " work=\""+toXMLWork()+"\""+
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

    String toXMLKey(){
        return this.safeXML(getKey());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLMissingCross(){
        if (getMissingCross() == null){
             return "";
        }
        return "ID_"+this.getMissingCross().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLMissingWork(){
        if (getMissingWork() == null){
             return "";
        }
        return "ID_"+this.getMissingWork().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLReferredWork(){
        if (getReferredWork() == null){
             return "";
        }
        return "ID_"+this.getReferredWork().getId().toString();
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

    String toXMLWork(){
        return "ID_"+this.getWork().getId().toString();
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
 * find the same object in another dataset
 * @param a CrossReference item we are looking for
 * @param bList List<CrossReference> list of items in which we are searching
 * @return CrossReference entry of list b which is applicationSame() to a
*/

    public static CrossReference find(CrossReference a, List<CrossReference> bList){
        for(CrossReference b : bList){
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
 * @param name CrossReference name of the object we are looking for
 * @return CrossReference entry of the dataset with the given name; otherwise null
*/

    public static CrossReference findByName(ApplicationDataset base, String name){
        for(CrossReference a:base.getListCrossReference()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        return null;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return CrossReference first entry in the dataset of this type; null if that does not exists
*/

    public static CrossReference findFirst(ApplicationDataset base){
        if (base.getListCrossReference().isEmpty()) {
            return null;
        }
        return base.getListCrossReference().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return CrossReference some entry in the dataset of this type; null if that does not exists
*/

    public static CrossReference findAny(ApplicationDataset base){
        int size=base.getListCrossReference().size();
        if (size > 0) {
             return base.getListCrossReference().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return CrossReference last entry in the dataset of this type; null if that does not exists
*/

    public static CrossReference findLast(ApplicationDataset base){
        int size=base.getListCrossReference().size();
        if (size > 0) {
             return base.getListCrossReference().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b CrossReference compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(CrossReference b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b CrossReference compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(CrossReference b){
      if(!this.getAuthor().equals(b.getAuthor())){
         System.out.println("Author");
        }
      if(!this.getKey().equals(b.getKey())){
         System.out.println("Key");
        }
      if(!(getMissingCross() == null ? b.getMissingCross() == null:this.getMissingCross().applicationSame(b.getMissingCross()))){
         System.out.println("MissingCross");
        }
      if(!(getMissingWork() == null ? b.getMissingWork() == null:this.getMissingWork().applicationSame(b.getMissingWork()))){
         System.out.println("MissingWork");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!(getReferredWork() == null ? b.getReferredWork() == null:this.getReferredWork().applicationSame(b.getReferredWork()))){
         System.out.println("ReferredWork");
        }
      if(!this.getSource().equals(b.getSource())){
         System.out.println("Source");
        }
      if(!this.getTitle().equals(b.getTitle())){
         System.out.println("Title");
        }
      if(!this.getWork().applicationSame(b.getWork())){
         System.out.println("Work");
        }
      if(!this.getYear().equals(b.getYear())){
         System.out.println("Year");
        }
        return  this.getAuthor().equals(b.getAuthor()) &&
          this.getKey().equals(b.getKey()) &&
          (this.getMissingCross() == null ? b.getMissingCross() == null : this.getMissingCross().applicationSame(b.getMissingCross())) &&
          (this.getMissingWork() == null ? b.getMissingWork() == null : this.getMissingWork().applicationSame(b.getMissingWork())) &&
          this.getName().equals(b.getName()) &&
          (this.getReferredWork() == null ? b.getReferredWork() == null : this.getReferredWork().applicationSame(b.getReferredWork())) &&
          this.getSource().equals(b.getSource()) &&
          this.getTitle().equals(b.getTitle()) &&
          this.getWork().applicationSame(b.getWork()) &&
          this.getYear().equals(b.getYear());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","CrossReference",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getWork() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"work","CrossReference",(getWork()==null?"null":getWork().toString()),"",WarningType.NOTNULL);
        }
    }

/**
 *  This method states if the class depends on the solver.
 *
*/

    public static Boolean isSolverDependent(){
        return false;
    }

   public List<ApplicationObjectInterface> getFeasibleValues(ApplicationDatasetInterface base,String attrName){
      if (attrName.equals("missingCross")){
         return (List) ((Scenario)base).getListMissingCross();
      }
      if (attrName.equals("missingWork")){
         return (List) ((Scenario)base).getListMissingWork();
      }
      if (attrName.equals("referredWork")){
         return (List) ((Scenario)base).getListWork();
      }
      if (attrName.equals("work")){
         return (List) ((Scenario)base).getListWork();
      }
      return null;
   }

}
