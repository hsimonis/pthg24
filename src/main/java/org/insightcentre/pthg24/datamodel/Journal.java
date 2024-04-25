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

public  class Journal extends ApplicationObject{
/**
 *  
 *
*/

    public Integer nrArticles;

/**
 *  
 *
*/

    public Integer nrBackgroundArticles;

/**
 *  
 *
*/

    public Integer nrBackgroundCitations;

/**
 *  
 *
*/

    public Integer nrCitations;

/**
 *  
 *
*/

    public String shortName;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public Journal(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public Journal(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setNrArticles(0);
        setNrBackgroundArticles(0);
        setNrBackgroundCitations(0);
        setNrCitations(0);
        setShortName("");
        applicationDataset.addJournal(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public Journal(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            Integer nrArticles,
            Integer nrBackgroundArticles,
            Integer nrBackgroundCitations,
            Integer nrCitations,
            String shortName){
        super(applicationDataset,
            id,
            name);
        setNrArticles(nrArticles);
        setNrBackgroundArticles(nrBackgroundArticles);
        setNrBackgroundCitations(nrBackgroundCitations);
        setNrCitations(nrCitations);
        setShortName(shortName);
        applicationDataset.addJournal(this);
    }

    public Journal(Journal other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.nrArticles,
            other.nrBackgroundArticles,
            other.nrBackgroundCitations,
            other.nrCitations,
            other.shortName);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        getApplicationDataset().cascadeJournalAliasJournal(this);
        getApplicationDataset().cascadeArticleJournal(this);
        return getApplicationDataset().removeJournal(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute nrArticles
 *
 * @return Integer
*/

    public Integer getNrArticles(){
        return this.nrArticles;
    }

/**
 *  get attribute nrBackgroundArticles
 *
 * @return Integer
*/

    public Integer getNrBackgroundArticles(){
        return this.nrBackgroundArticles;
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
 *  get attribute nrCitations
 *
 * @return Integer
*/

    public Integer getNrCitations(){
        return this.nrCitations;
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
 *  set attribute nrArticles, mark dataset as dirty, mark dataset as not valid
@param nrArticles Integer
 *
*/

    public void setNrArticles(Integer nrArticles){
        this.nrArticles = nrArticles;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute nrBackgroundArticles, mark dataset as dirty, mark dataset as not valid
@param nrBackgroundArticles Integer
 *
*/

    public void setNrBackgroundArticles(Integer nrBackgroundArticles){
        this.nrBackgroundArticles = nrBackgroundArticles;
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
 *  inc attribute nrArticles, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrArticles(){
        this.nrArticles++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute nrBackgroundArticles, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrBackgroundArticles(){
        this.nrBackgroundArticles++;
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
 *  inc attribute nrCitations, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrCitations(){
        this.nrCitations++;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getNrArticles()+ " " +getNrBackgroundArticles()+ " " +getNrBackgroundCitations()+ " " +getNrCitations()+ " " +getShortName();
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
         out.println("<journal "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " nrArticles=\""+toXMLNrArticles()+"\""+
            " nrBackgroundArticles=\""+toXMLNrBackgroundArticles()+"\""+
            " nrBackgroundCitations=\""+toXMLNrBackgroundCitations()+"\""+
            " nrCitations=\""+toXMLNrCitations()+"\""+
            " shortName=\""+toXMLShortName()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLNrArticles(){
        return this.getNrArticles().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLNrBackgroundArticles(){
        return this.getNrBackgroundArticles().toString();
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

    String toXMLNrCitations(){
        return this.getNrCitations().toString();
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
        return "<tr><th>Journal</th>"+"<th>Name</th>"+"<th>ShortName</th>"+"<th>NrArticles</th>"+"<th>NrBackgroundArticles</th>"+"<th>NrCitations</th>"+"<th>NrBackgroundCitations</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getShortName()+"</td>"+ " " +"<td>"+getNrArticles()+"</td>"+ " " +"<td>"+getNrBackgroundArticles()+"</td>"+ " " +"<td>"+getNrCitations()+"</td>"+ " " +"<td>"+getNrBackgroundCitations()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a Journal item we are looking for
 * @param bList List<Journal> list of items in which we are searching
 * @return Journal entry of list b which is applicationSame() to a
*/

    public static Journal find(Journal a, List<Journal> bList){
        for(Journal b : bList){
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
 * @param name Journal name of the object we are looking for
 * @return Journal entry of the dataset with the given name; otherwise null
*/

    public static Journal findByName(ApplicationDataset base, String name){
        for(Journal a:base.getListJournal()) {
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
 * @param name Journal name of the object we are looking for
 * @return Journal entry of the dataset with the given name
*/

    public static Journal findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(Journal a:base.getListJournal()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        Journal res = new Journal(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Journal first entry in the dataset of this type; null if that does not exists
*/

    public static Journal findFirst(ApplicationDataset base){
        if (base.getListJournal().isEmpty()) {
            return null;
        }
        return base.getListJournal().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Journal some entry in the dataset of this type; null if that does not exists
*/

    public static Journal findAny(ApplicationDataset base){
        int size=base.getListJournal().size();
        if (size > 0) {
             return base.getListJournal().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Journal last entry in the dataset of this type; null if that does not exists
*/

    public static Journal findLast(ApplicationDataset base){
        int size=base.getListJournal().size();
        if (size > 0) {
             return base.getListJournal().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b Journal compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(Journal b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b Journal compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(Journal b){
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getNrArticles().equals(b.getNrArticles())){
         System.out.println("NrArticles");
        }
      if(!this.getNrBackgroundArticles().equals(b.getNrBackgroundArticles())){
         System.out.println("NrBackgroundArticles");
        }
      if(!this.getNrBackgroundCitations().equals(b.getNrBackgroundCitations())){
         System.out.println("NrBackgroundCitations");
        }
      if(!this.getNrCitations().equals(b.getNrCitations())){
         System.out.println("NrCitations");
        }
      if(!this.getShortName().equals(b.getShortName())){
         System.out.println("ShortName");
        }
        return  this.getName().equals(b.getName()) &&
          this.getNrArticles().equals(b.getNrArticles()) &&
          this.getNrBackgroundArticles().equals(b.getNrBackgroundArticles()) &&
          this.getNrBackgroundCitations().equals(b.getNrBackgroundCitations()) &&
          this.getNrCitations().equals(b.getNrCitations()) &&
          this.getShortName().equals(b.getShortName());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","Journal",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class Journal
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
