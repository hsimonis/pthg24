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
import org.insightcentre.pthg24.datamodel.Coauthor;
import org.insightcentre.pthg24.datamodel.Similarity;
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

public  class JournalAlias extends ApplicationObject{
/**
 *  
 *
*/

    public String alias;

/**
 *  
 *
*/

    public Journal journal;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public JournalAlias(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public JournalAlias(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setAlias("");
        setJournal(null);
        applicationDataset.addJournalAlias(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public JournalAlias(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            String alias,
            Journal journal){
        super(applicationDataset,
            id,
            name);
        setAlias(alias);
        setJournal(journal);
        applicationDataset.addJournalAlias(this);
    }

    public JournalAlias(JournalAlias other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.alias,
            other.journal);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        return getApplicationDataset().removeJournalAlias(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute alias
 *
 * @return String
*/

    public String getAlias(){
        return this.alias;
    }

/**
 *  get attribute journal
 *
 * @return Journal
*/

    public Journal getJournal(){
        return this.journal;
    }

/**
 *  set attribute alias, mark dataset as dirty, mark dataset as not valid
@param alias String
 *
*/

    public void setAlias(String alias){
        this.alias = alias;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute journal, mark dataset as dirty, mark dataset as not valid
@param journal Journal
 *
*/

    public void setJournal(Journal journal){
        this.journal = journal;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getAlias()+ " " +getJournal().toColumnString();
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
         out.println("<journalAlias "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " alias=\""+toXMLAlias()+"\""+
            " journal=\""+toXMLJournal()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLAlias(){
        return this.safeXML(getAlias());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLJournal(){
        return "ID_"+this.getJournal().getId().toString();
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>JournalAlias</th>"+"<th>Name</th>"+"<th>Journal</th>"+"<th>Alias</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getJournal().toColumnString()+"</td>"+ " " +"<td>"+getAlias()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a JournalAlias item we are looking for
 * @param bList List<JournalAlias> list of items in which we are searching
 * @return JournalAlias entry of list b which is applicationSame() to a
*/

    public static JournalAlias find(JournalAlias a, List<JournalAlias> bList){
        for(JournalAlias b : bList){
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
 * @param name JournalAlias name of the object we are looking for
 * @return JournalAlias entry of the dataset with the given name; otherwise null
*/

    public static JournalAlias findByName(ApplicationDataset base, String name){
        for(JournalAlias a:base.getListJournalAlias()) {
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
 * @param name JournalAlias name of the object we are looking for
 * @return JournalAlias entry of the dataset with the given name
*/

    public static JournalAlias findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(JournalAlias a:base.getListJournalAlias()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        JournalAlias res = new JournalAlias(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return JournalAlias first entry in the dataset of this type; null if that does not exists
*/

    public static JournalAlias findFirst(ApplicationDataset base){
        if (base.getListJournalAlias().isEmpty()) {
            return null;
        }
        return base.getListJournalAlias().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return JournalAlias some entry in the dataset of this type; null if that does not exists
*/

    public static JournalAlias findAny(ApplicationDataset base){
        int size=base.getListJournalAlias().size();
        if (size > 0) {
             return base.getListJournalAlias().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return JournalAlias last entry in the dataset of this type; null if that does not exists
*/

    public static JournalAlias findLast(ApplicationDataset base){
        int size=base.getListJournalAlias().size();
        if (size > 0) {
             return base.getListJournalAlias().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b JournalAlias compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(JournalAlias b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b JournalAlias compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(JournalAlias b){
      if(!this.getAlias().equals(b.getAlias())){
         System.out.println("Alias");
        }
      if(!this.getJournal().applicationSame(b.getJournal())){
         System.out.println("Journal");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
        return  this.getAlias().equals(b.getAlias()) &&
          this.getJournal().applicationSame(b.getJournal()) &&
          this.getName().equals(b.getName());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","JournalAlias",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getJournal() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"journal","JournalAlias",(getJournal()==null?"null":getJournal().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class JournalAlias
    }

/**
 *  This method states if the class depends on the solver.
 *
*/

    public static Boolean isSolverDependent(){
        return false;
    }

   public List<ApplicationObjectInterface> getFeasibleValues(ApplicationDatasetInterface base,String attrName){
      if (attrName.equals("journal")){
         return (List) ((Scenario)base).getListJournal();
      }
      return null;
   }

}
