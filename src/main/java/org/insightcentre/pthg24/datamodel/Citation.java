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

public  class Citation extends ApplicationObject{
/**
 *  
 *
*/

    public String authorSC;

/**
 *  
 *
*/

    public String cited;

/**
 *  
 *
*/

    public Work citedWork;

/**
 *  
 *
*/

    public String citing;

/**
 *  
 *
*/

    public Work citingWork;

/**
 *  
 *
*/

    public String creation;

/**
 *  
 *
*/

    public String journalSC;

/**
 *  
 *
*/

    public String oci;

/**
 *  
 *
*/

    public String timespan;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public Citation(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public Citation(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setAuthorSC("");
        setCited("");
        setCitedWork(null);
        setCiting("");
        setCitingWork(null);
        setCreation("");
        setJournalSC("");
        setOci("");
        setTimespan("");
        applicationDataset.addCitation(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public Citation(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            String authorSC,
            String cited,
            Work citedWork,
            String citing,
            Work citingWork,
            String creation,
            String journalSC,
            String oci,
            String timespan){
        super(applicationDataset,
            id,
            name);
        setAuthorSC(authorSC);
        setCited(cited);
        setCitedWork(citedWork);
        setCiting(citing);
        setCitingWork(citingWork);
        setCreation(creation);
        setJournalSC(journalSC);
        setOci(oci);
        setTimespan(timespan);
        applicationDataset.addCitation(this);
    }

    public Citation(Citation other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.authorSC,
            other.cited,
            other.citedWork,
            other.citing,
            other.citingWork,
            other.creation,
            other.journalSC,
            other.oci,
            other.timespan);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        return getApplicationDataset().removeCitation(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute authorSC
 *
 * @return String
*/

    public String getAuthorSC(){
        return this.authorSC;
    }

/**
 *  get attribute cited
 *
 * @return String
*/

    public String getCited(){
        return this.cited;
    }

/**
 *  get attribute citedWork
 *
 * @return Work
*/

    public Work getCitedWork(){
        return this.citedWork;
    }

/**
 *  get attribute citing
 *
 * @return String
*/

    public String getCiting(){
        return this.citing;
    }

/**
 *  get attribute citingWork
 *
 * @return Work
*/

    public Work getCitingWork(){
        return this.citingWork;
    }

/**
 *  get attribute creation
 *
 * @return String
*/

    public String getCreation(){
        return this.creation;
    }

/**
 *  get attribute journalSC
 *
 * @return String
*/

    public String getJournalSC(){
        return this.journalSC;
    }

/**
 *  get attribute oci
 *
 * @return String
*/

    public String getOci(){
        return this.oci;
    }

/**
 *  get attribute timespan
 *
 * @return String
*/

    public String getTimespan(){
        return this.timespan;
    }

/**
 *  set attribute authorSC, mark dataset as dirty, mark dataset as not valid
@param authorSC String
 *
*/

    public void setAuthorSC(String authorSC){
        this.authorSC = authorSC;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute cited, mark dataset as dirty, mark dataset as not valid
@param cited String
 *
*/

    public void setCited(String cited){
        this.cited = cited;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute citedWork, mark dataset as dirty, mark dataset as not valid
@param citedWork Work
 *
*/

    public void setCitedWork(Work citedWork){
        this.citedWork = citedWork;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute citing, mark dataset as dirty, mark dataset as not valid
@param citing String
 *
*/

    public void setCiting(String citing){
        this.citing = citing;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute citingWork, mark dataset as dirty, mark dataset as not valid
@param citingWork Work
 *
*/

    public void setCitingWork(Work citingWork){
        this.citingWork = citingWork;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute creation, mark dataset as dirty, mark dataset as not valid
@param creation String
 *
*/

    public void setCreation(String creation){
        this.creation = creation;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute journalSC, mark dataset as dirty, mark dataset as not valid
@param journalSC String
 *
*/

    public void setJournalSC(String journalSC){
        this.journalSC = journalSC;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute oci, mark dataset as dirty, mark dataset as not valid
@param oci String
 *
*/

    public void setOci(String oci){
        this.oci = oci;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute timespan, mark dataset as dirty, mark dataset as not valid
@param timespan String
 *
*/

    public void setTimespan(String timespan){
        this.timespan = timespan;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getAuthorSC()+ " " +getCited()+ " " +getCitedWork().toColumnString()+ " " +getCiting()+ " " +getCitingWork().toColumnString()+ " " +getCreation()+ " " +getJournalSC()+ " " +getOci()+ " " +getTimespan();
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
         out.println("<citation "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " authorSC=\""+toXMLAuthorSC()+"\""+
            " cited=\""+toXMLCited()+"\""+
            " citedWork=\""+toXMLCitedWork()+"\""+
            " citing=\""+toXMLCiting()+"\""+
            " citingWork=\""+toXMLCitingWork()+"\""+
            " creation=\""+toXMLCreation()+"\""+
            " journalSC=\""+toXMLJournalSC()+"\""+
            " oci=\""+toXMLOci()+"\""+
            " timespan=\""+toXMLTimespan()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLAuthorSC(){
        return this.safeXML(getAuthorSC());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCited(){
        return this.safeXML(getCited());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCitedWork(){
        return "ID_"+this.getCitedWork().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCiting(){
        return this.safeXML(getCiting());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCitingWork(){
        return "ID_"+this.getCitingWork().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCreation(){
        return this.safeXML(getCreation());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLJournalSC(){
        return this.safeXML(getJournalSC());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLOci(){
        return this.safeXML(getOci());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLTimespan(){
        return this.safeXML(getTimespan());
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>Citation</th>"+"<th>Name</th>"+"<th>Oci</th>"+"<th>CitedWork</th>"+"<th>CitingWork</th>"+"<th>Cited</th>"+"<th>Citing</th>"+"<th>Creation</th>"+"<th>Timespan</th>"+"<th>AuthorSC</th>"+"<th>JournalSC</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getOci()+"</td>"+ " " +"<td>"+getCitedWork().toColumnString()+"</td>"+ " " +"<td>"+getCitingWork().toColumnString()+"</td>"+ " " +"<td>"+getCited()+"</td>"+ " " +"<td>"+getCiting()+"</td>"+ " " +"<td>"+getCreation()+"</td>"+ " " +"<td>"+getTimespan()+"</td>"+ " " +"<td>"+getAuthorSC()+"</td>"+ " " +"<td>"+getJournalSC()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a Citation item we are looking for
 * @param bList List<Citation> list of items in which we are searching
 * @return Citation entry of list b which is applicationSame() to a
*/

    public static Citation find(Citation a, List<Citation> bList){
        for(Citation b : bList){
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
 * @param name Citation name of the object we are looking for
 * @return Citation entry of the dataset with the given name; otherwise null
*/

    public static Citation findByName(ApplicationDataset base, String name){
        for(Citation a:base.getListCitation()) {
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
 * @param name Citation name of the object we are looking for
 * @return Citation entry of the dataset with the given name
*/

    public static Citation findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(Citation a:base.getListCitation()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        Citation res = new Citation(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Citation first entry in the dataset of this type; null if that does not exists
*/

    public static Citation findFirst(ApplicationDataset base){
        if (base.getListCitation().isEmpty()) {
            return null;
        }
        return base.getListCitation().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Citation some entry in the dataset of this type; null if that does not exists
*/

    public static Citation findAny(ApplicationDataset base){
        int size=base.getListCitation().size();
        if (size > 0) {
             return base.getListCitation().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Citation last entry in the dataset of this type; null if that does not exists
*/

    public static Citation findLast(ApplicationDataset base){
        int size=base.getListCitation().size();
        if (size > 0) {
             return base.getListCitation().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b Citation compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(Citation b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b Citation compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(Citation b){
      if(!this.getAuthorSC().equals(b.getAuthorSC())){
         System.out.println("AuthorSC");
        }
      if(!this.getCited().equals(b.getCited())){
         System.out.println("Cited");
        }
      if(!this.getCitedWork().applicationSame(b.getCitedWork())){
         System.out.println("CitedWork");
        }
      if(!this.getCiting().equals(b.getCiting())){
         System.out.println("Citing");
        }
      if(!this.getCitingWork().applicationSame(b.getCitingWork())){
         System.out.println("CitingWork");
        }
      if(!this.getCreation().equals(b.getCreation())){
         System.out.println("Creation");
        }
      if(!this.getJournalSC().equals(b.getJournalSC())){
         System.out.println("JournalSC");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getOci().equals(b.getOci())){
         System.out.println("Oci");
        }
      if(!this.getTimespan().equals(b.getTimespan())){
         System.out.println("Timespan");
        }
        return  this.getAuthorSC().equals(b.getAuthorSC()) &&
          this.getCited().equals(b.getCited()) &&
          this.getCitedWork().applicationSame(b.getCitedWork()) &&
          this.getCiting().equals(b.getCiting()) &&
          this.getCitingWork().applicationSame(b.getCitingWork()) &&
          this.getCreation().equals(b.getCreation()) &&
          this.getJournalSC().equals(b.getJournalSC()) &&
          this.getName().equals(b.getName()) &&
          this.getOci().equals(b.getOci()) &&
          this.getTimespan().equals(b.getTimespan());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","Citation",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getCitedWork() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"citedWork","Citation",(getCitedWork()==null?"null":getCitedWork().toString()),"",WarningType.NOTNULL);
        }
        if (getCitingWork() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"citingWork","Citation",(getCitingWork()==null?"null":getCitingWork().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class Citation
    }

/**
 *  This method states if the class depends on the solver.
 *
*/

    public static Boolean isSolverDependent(){
        return false;
    }

   public List<ApplicationObjectInterface> getFeasibleValues(ApplicationDatasetInterface base,String attrName){
      if (attrName.equals("citedWork")){
         return (List) ((Scenario)base).getListWork();
      }
      if (attrName.equals("citingWork")){
         return (List) ((Scenario)base).getListWork();
      }
      return null;
   }

}
