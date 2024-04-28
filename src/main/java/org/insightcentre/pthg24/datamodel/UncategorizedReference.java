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

public  class UncategorizedReference extends CrossReference{
/**
 *  No-arg constructor for use in TableView
 *
*/

    public UncategorizedReference(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public UncategorizedReference(ApplicationDataset applicationDataset){
        super(applicationDataset);
        applicationDataset.addUncategorizedReference(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public UncategorizedReference(ApplicationDataset applicationDataset,
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
            name,
            author,
            key,
            missingCross,
            missingWork,
            referredWork,
            source,
            title,
            work,
            year);
        applicationDataset.addUncategorizedReference(this);
    }

    public UncategorizedReference(UncategorizedReference other){
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
        return getApplicationDataset().removeUncategorizedReference(this) && getApplicationDataset().removeCrossReference(this) && getApplicationDataset().removeApplicationObject(this);
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
         out.println("<uncategorizedReference "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
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
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>UncategorizedReference</th>"+"<th>Name</th>"+"<th>Key</th>"+"<th>Work</th>"+"<th>ReferredWork</th>"+"<th>MissingWork</th>"+"<th>MissingCross</th>"+"<th>Year</th>"+"<th>Author</th>"+"<th>Source</th>"+"<th>Title</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getKey()+"</td>"+ " " +"<td>"+getWork().toColumnString()+"</td>"+ " " +"<td>"+(getReferredWork() == null ? "" : getReferredWork().toColumnString())+"</td>"+ " " +"<td>"+(getMissingWork() == null ? "" : getMissingWork().toColumnString())+"</td>"+ " " +"<td>"+(getMissingCross() == null ? "" : getMissingCross().toColumnString())+"</td>"+ " " +"<td>"+getYear()+"</td>"+ " " +"<td>"+getAuthor()+"</td>"+ " " +"<td>"+getSource()+"</td>"+ " " +"<td>"+getTitle()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a UncategorizedReference item we are looking for
 * @param bList List<UncategorizedReference> list of items in which we are searching
 * @return UncategorizedReference entry of list b which is applicationSame() to a
*/

    public static UncategorizedReference find(UncategorizedReference a, List<UncategorizedReference> bList){
        for(UncategorizedReference b : bList){
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
 * @param name UncategorizedReference name of the object we are looking for
 * @return UncategorizedReference entry of the dataset with the given name; otherwise null
*/

    public static UncategorizedReference findByName(ApplicationDataset base, String name){
        for(UncategorizedReference a:base.getListUncategorizedReference()) {
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
 * @param name UncategorizedReference name of the object we are looking for
 * @return UncategorizedReference entry of the dataset with the given name
*/

    public static UncategorizedReference findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(UncategorizedReference a:base.getListUncategorizedReference()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        UncategorizedReference res = new UncategorizedReference(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return UncategorizedReference first entry in the dataset of this type; null if that does not exists
*/

    public static UncategorizedReference findFirst(ApplicationDataset base){
        if (base.getListUncategorizedReference().isEmpty()) {
            return null;
        }
        return base.getListUncategorizedReference().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return UncategorizedReference some entry in the dataset of this type; null if that does not exists
*/

    public static UncategorizedReference findAny(ApplicationDataset base){
        int size=base.getListUncategorizedReference().size();
        if (size > 0) {
             return base.getListUncategorizedReference().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return UncategorizedReference last entry in the dataset of this type; null if that does not exists
*/

    public static UncategorizedReference findLast(ApplicationDataset base){
        int size=base.getListUncategorizedReference().size();
        if (size > 0) {
             return base.getListUncategorizedReference().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b UncategorizedReference compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(UncategorizedReference b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b UncategorizedReference compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(UncategorizedReference b){
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
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","UncategorizedReference",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getWork() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"work","UncategorizedReference",(getWork()==null?"null":getWork().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class UncategorizedReference
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
