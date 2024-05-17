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
import org.insightcentre.pthg24.datamodel.Translator;
import org.insightcentre.pthg24.datamodel.AuthorDouble;
import org.insightcentre.pthg24.datamodel.OtherWork;
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

public  class WorkAffiliation extends ApplicationObject{
/**
 *  
 *
*/

    public ScopusAffiliation scopusAffiliation;

/**
 *  
 *
*/

    public Work work;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public WorkAffiliation(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public WorkAffiliation(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setScopusAffiliation(null);
        setWork(null);
        applicationDataset.addWorkAffiliation(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public WorkAffiliation(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            ScopusAffiliation scopusAffiliation,
            Work work){
        super(applicationDataset,
            id,
            name);
        setScopusAffiliation(scopusAffiliation);
        setWork(work);
        applicationDataset.addWorkAffiliation(this);
    }

    public WorkAffiliation(WorkAffiliation other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.scopusAffiliation,
            other.work);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        return getApplicationDataset().removeWorkAffiliation(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute scopusAffiliation
 *
 * @return ScopusAffiliation
*/

    public ScopusAffiliation getScopusAffiliation(){
        return this.scopusAffiliation;
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
 *  set attribute scopusAffiliation, mark dataset as dirty, mark dataset as not valid
@param scopusAffiliation ScopusAffiliation
 *
*/

    public void setScopusAffiliation(ScopusAffiliation scopusAffiliation){
        this.scopusAffiliation = scopusAffiliation;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getScopusAffiliation().toColumnString()+ " " +getWork().toColumnString();
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
         out.println("<workAffiliation "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " scopusAffiliation=\""+toXMLScopusAffiliation()+"\""+
            " work=\""+toXMLWork()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLScopusAffiliation(){
        return "ID_"+this.getScopusAffiliation().getId().toString();
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
        return "<tr><th>WorkAffiliation</th>"+"<th>Name</th>"+"<th>Work</th>"+"<th>ScopusAffiliation</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getWork().toColumnString()+"</td>"+ " " +"<td>"+getScopusAffiliation().toColumnString()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a WorkAffiliation item we are looking for
 * @param bList List<WorkAffiliation> list of items in which we are searching
 * @return WorkAffiliation entry of list b which is applicationSame() to a
*/

    public static WorkAffiliation find(WorkAffiliation a, List<WorkAffiliation> bList){
        for(WorkAffiliation b : bList){
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
 * @param name WorkAffiliation name of the object we are looking for
 * @return WorkAffiliation entry of the dataset with the given name; otherwise null
*/

    public static WorkAffiliation findByName(ApplicationDataset base, String name){
        for(WorkAffiliation a:base.getListWorkAffiliation()) {
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
 * @param name WorkAffiliation name of the object we are looking for
 * @return WorkAffiliation entry of the dataset with the given name
*/

    public static WorkAffiliation findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(WorkAffiliation a:base.getListWorkAffiliation()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        WorkAffiliation res = new WorkAffiliation(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return WorkAffiliation first entry in the dataset of this type; null if that does not exists
*/

    public static WorkAffiliation findFirst(ApplicationDataset base){
        if (base.getListWorkAffiliation().isEmpty()) {
            return null;
        }
        return base.getListWorkAffiliation().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return WorkAffiliation some entry in the dataset of this type; null if that does not exists
*/

    public static WorkAffiliation findAny(ApplicationDataset base){
        int size=base.getListWorkAffiliation().size();
        if (size > 0) {
             return base.getListWorkAffiliation().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return WorkAffiliation last entry in the dataset of this type; null if that does not exists
*/

    public static WorkAffiliation findLast(ApplicationDataset base){
        int size=base.getListWorkAffiliation().size();
        if (size > 0) {
             return base.getListWorkAffiliation().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b WorkAffiliation compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(WorkAffiliation b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b WorkAffiliation compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(WorkAffiliation b){
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getScopusAffiliation().applicationSame(b.getScopusAffiliation())){
         System.out.println("ScopusAffiliation");
        }
      if(!this.getWork().applicationSame(b.getWork())){
         System.out.println("Work");
        }
        return  this.getName().equals(b.getName()) &&
          this.getScopusAffiliation().applicationSame(b.getScopusAffiliation()) &&
          this.getWork().applicationSame(b.getWork());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","WorkAffiliation",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getScopusAffiliation() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"scopusAffiliation","WorkAffiliation",(getScopusAffiliation()==null?"null":getScopusAffiliation().toString()),"",WarningType.NOTNULL);
        }
        if (getWork() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"work","WorkAffiliation",(getWork()==null?"null":getWork().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class WorkAffiliation
    }

/**
 *  This method states if the class depends on the solver.
 *
*/

    public static Boolean isSolverDependent(){
        return false;
    }

   public List<ApplicationObjectInterface> getFeasibleValues(ApplicationDatasetInterface base,String attrName){
      if (attrName.equals("scopusAffiliation")){
         return (List) ((Scenario)base).getListScopusAffiliation();
      }
      if (attrName.equals("work")){
         return (List) ((Scenario)base).getListWork();
      }
      return null;
   }

}
