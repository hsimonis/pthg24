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

public  class ConferenceSeries extends ApplicationObject{
/**
 *  
 *
*/

    public Integer nrBackgroundCitations;

/**
 *  
 *
*/

    public Integer nrBackgroundPapers;

/**
 *  
 *
*/

    public Integer nrCitations;

/**
 *  
 *
*/

    public Integer nrPapers;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public ConferenceSeries(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public ConferenceSeries(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setNrBackgroundCitations(0);
        setNrBackgroundPapers(0);
        setNrCitations(0);
        setNrPapers(0);
        applicationDataset.addConferenceSeries(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public ConferenceSeries(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            Integer nrBackgroundCitations,
            Integer nrBackgroundPapers,
            Integer nrCitations,
            Integer nrPapers){
        super(applicationDataset,
            id,
            name);
        setNrBackgroundCitations(nrBackgroundCitations);
        setNrBackgroundPapers(nrBackgroundPapers);
        setNrCitations(nrCitations);
        setNrPapers(nrPapers);
        applicationDataset.addConferenceSeries(this);
    }

    public ConferenceSeries(ConferenceSeries other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.nrBackgroundCitations,
            other.nrBackgroundPapers,
            other.nrCitations,
            other.nrPapers);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        getApplicationDataset().cascadeProceedingsConferenceSeries(this);
        return getApplicationDataset().removeConferenceSeries(this) && getApplicationDataset().removeApplicationObject(this);
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
 *  get attribute nrBackgroundPapers
 *
 * @return Integer
*/

    public Integer getNrBackgroundPapers(){
        return this.nrBackgroundPapers;
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
 *  get attribute nrPapers
 *
 * @return Integer
*/

    public Integer getNrPapers(){
        return this.nrPapers;
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
 *  set attribute nrBackgroundPapers, mark dataset as dirty, mark dataset as not valid
@param nrBackgroundPapers Integer
 *
*/

    public void setNrBackgroundPapers(Integer nrBackgroundPapers){
        this.nrBackgroundPapers = nrBackgroundPapers;
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
 *  set attribute nrPapers, mark dataset as dirty, mark dataset as not valid
@param nrPapers Integer
 *
*/

    public void setNrPapers(Integer nrPapers){
        this.nrPapers = nrPapers;
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
 *  inc attribute nrBackgroundPapers, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrBackgroundPapers(){
        this.nrBackgroundPapers++;
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
 *  inc attribute nrPapers, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrPapers(){
        this.nrPapers++;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getNrBackgroundCitations()+ " " +getNrBackgroundPapers()+ " " +getNrCitations()+ " " +getNrPapers();
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
         out.println("<conferenceSeries "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " nrBackgroundCitations=\""+toXMLNrBackgroundCitations()+"\""+
            " nrBackgroundPapers=\""+toXMLNrBackgroundPapers()+"\""+
            " nrCitations=\""+toXMLNrCitations()+"\""+
            " nrPapers=\""+toXMLNrPapers()+"\""+" />");
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

    String toXMLNrBackgroundPapers(){
        return this.getNrBackgroundPapers().toString();
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

    String toXMLNrPapers(){
        return this.getNrPapers().toString();
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>ConferenceSeries</th>"+"<th>Name</th>"+"<th>NrPapers</th>"+"<th>NrCitations</th>"+"<th>NrBackgroundPapers</th>"+"<th>NrBackgroundCitations</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getNrPapers()+"</td>"+ " " +"<td>"+getNrCitations()+"</td>"+ " " +"<td>"+getNrBackgroundPapers()+"</td>"+ " " +"<td>"+getNrBackgroundCitations()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a ConferenceSeries item we are looking for
 * @param bList List<ConferenceSeries> list of items in which we are searching
 * @return ConferenceSeries entry of list b which is applicationSame() to a
*/

    public static ConferenceSeries find(ConferenceSeries a, List<ConferenceSeries> bList){
        for(ConferenceSeries b : bList){
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
 * @param name ConferenceSeries name of the object we are looking for
 * @return ConferenceSeries entry of the dataset with the given name; otherwise null
*/

    public static ConferenceSeries findByName(ApplicationDataset base, String name){
        for(ConferenceSeries a:base.getListConferenceSeries()) {
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
 * @param name ConferenceSeries name of the object we are looking for
 * @return ConferenceSeries entry of the dataset with the given name
*/

    public static ConferenceSeries findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(ConferenceSeries a:base.getListConferenceSeries()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        ConferenceSeries res = new ConferenceSeries(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ConferenceSeries first entry in the dataset of this type; null if that does not exists
*/

    public static ConferenceSeries findFirst(ApplicationDataset base){
        if (base.getListConferenceSeries().isEmpty()) {
            return null;
        }
        return base.getListConferenceSeries().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ConferenceSeries some entry in the dataset of this type; null if that does not exists
*/

    public static ConferenceSeries findAny(ApplicationDataset base){
        int size=base.getListConferenceSeries().size();
        if (size > 0) {
             return base.getListConferenceSeries().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ConferenceSeries last entry in the dataset of this type; null if that does not exists
*/

    public static ConferenceSeries findLast(ApplicationDataset base){
        int size=base.getListConferenceSeries().size();
        if (size > 0) {
             return base.getListConferenceSeries().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b ConferenceSeries compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(ConferenceSeries b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b ConferenceSeries compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(ConferenceSeries b){
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getNrBackgroundCitations().equals(b.getNrBackgroundCitations())){
         System.out.println("NrBackgroundCitations");
        }
      if(!this.getNrBackgroundPapers().equals(b.getNrBackgroundPapers())){
         System.out.println("NrBackgroundPapers");
        }
      if(!this.getNrCitations().equals(b.getNrCitations())){
         System.out.println("NrCitations");
        }
      if(!this.getNrPapers().equals(b.getNrPapers())){
         System.out.println("NrPapers");
        }
        return  this.getName().equals(b.getName()) &&
          this.getNrBackgroundCitations().equals(b.getNrBackgroundCitations()) &&
          this.getNrBackgroundPapers().equals(b.getNrBackgroundPapers()) &&
          this.getNrCitations().equals(b.getNrCitations()) &&
          this.getNrPapers().equals(b.getNrPapers());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","ConferenceSeries",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class ConferenceSeries
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
