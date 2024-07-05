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

public  class ConceptWork extends ApplicationObject{
/**
 *  
 *
*/

    public Concept concept;

/**
 *  
 *
*/

    public Integer count;

/**
 *  
 *
*/

    public MatchLevel matchLevel;

/**
 *  
 *
*/

    public Work work;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public ConceptWork(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public ConceptWork(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setConcept(null);
        setCount(0);
        setMatchLevel(null);
        setWork(null);
        applicationDataset.addConceptWork(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public ConceptWork(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            Concept concept,
            Integer count,
            MatchLevel matchLevel,
            Work work){
        super(applicationDataset,
            id,
            name);
        setConcept(concept);
        setCount(count);
        setMatchLevel(matchLevel);
        setWork(work);
        applicationDataset.addConceptWork(this);
    }

    public ConceptWork(ConceptWork other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.concept,
            other.count,
            other.matchLevel,
            other.work);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        return getApplicationDataset().removeConceptWork(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute concept
 *
 * @return Concept
*/

    public Concept getConcept(){
        return this.concept;
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
 *  get attribute matchLevel
 *
 * @return MatchLevel
*/

    public MatchLevel getMatchLevel(){
        return this.matchLevel;
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
 *  set attribute concept, mark dataset as dirty, mark dataset as not valid
@param concept Concept
 *
*/

    public void setConcept(Concept concept){
        this.concept = concept;
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
 *  set attribute matchLevel, mark dataset as dirty, mark dataset as not valid
@param matchLevel MatchLevel
 *
*/

    public void setMatchLevel(MatchLevel matchLevel){
        this.matchLevel = matchLevel;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getConcept().toColumnString()+ " " +getCount()+ " " +getMatchLevel()+ " " +getWork().toColumnString();
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
         out.println("<conceptWork "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " concept=\""+toXMLConcept()+"\""+
            " count=\""+toXMLCount()+"\""+
            " matchLevel=\""+toXMLMatchLevel()+"\""+
            " work=\""+toXMLWork()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLConcept(){
        return "ID_"+this.getConcept().getId().toString();
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

    String toXMLMatchLevel(){
        return this.getMatchLevel().toString();
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
        return "<tr><th>ConceptWork</th>"+"<th>Name</th>"+"<th>Concept</th>"+"<th>Work</th>"+"<th>Count</th>"+"<th>MatchLevel</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getConcept().toColumnString()+"</td>"+ " " +"<td>"+getWork().toColumnString()+"</td>"+ " " +"<td>"+getCount()+"</td>"+ " " +"<td>"+getMatchLevel()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a ConceptWork item we are looking for
 * @param bList List<ConceptWork> list of items in which we are searching
 * @return ConceptWork entry of list b which is applicationSame() to a
*/

    public static ConceptWork find(ConceptWork a, List<ConceptWork> bList){
        for(ConceptWork b : bList){
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
 * @param name ConceptWork name of the object we are looking for
 * @return ConceptWork entry of the dataset with the given name; otherwise null
*/

    public static ConceptWork findByName(ApplicationDataset base, String name){
        for(ConceptWork a:base.getListConceptWork()) {
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
 * @param name ConceptWork name of the object we are looking for
 * @return ConceptWork entry of the dataset with the given name
*/

    public static ConceptWork findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(ConceptWork a:base.getListConceptWork()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        ConceptWork res = new ConceptWork(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ConceptWork first entry in the dataset of this type; null if that does not exists
*/

    public static ConceptWork findFirst(ApplicationDataset base){
        if (base.getListConceptWork().isEmpty()) {
            return null;
        }
        return base.getListConceptWork().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ConceptWork some entry in the dataset of this type; null if that does not exists
*/

    public static ConceptWork findAny(ApplicationDataset base){
        int size=base.getListConceptWork().size();
        if (size > 0) {
             return base.getListConceptWork().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ConceptWork last entry in the dataset of this type; null if that does not exists
*/

    public static ConceptWork findLast(ApplicationDataset base){
        int size=base.getListConceptWork().size();
        if (size > 0) {
             return base.getListConceptWork().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b ConceptWork compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(ConceptWork b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b ConceptWork compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(ConceptWork b){
      if(!this.getConcept().applicationSame(b.getConcept())){
         System.out.println("Concept");
        }
      if(!this.getCount().equals(b.getCount())){
         System.out.println("Count");
        }
      if(!this.getMatchLevel().equals(b.getMatchLevel())){
         System.out.println("MatchLevel");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getWork().applicationSame(b.getWork())){
         System.out.println("Work");
        }
        return  this.getConcept().applicationSame(b.getConcept()) &&
          this.getCount().equals(b.getCount()) &&
          this.getMatchLevel().equals(b.getMatchLevel()) &&
          this.getName().equals(b.getName()) &&
          this.getWork().applicationSame(b.getWork());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","ConceptWork",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getConcept() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"concept","ConceptWork",(getConcept()==null?"null":getConcept().toString()),"",WarningType.NOTNULL);
        }
        if (getWork() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"work","ConceptWork",(getWork()==null?"null":getWork().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class ConceptWork
    }

/**
 *  This method states if the class depends on the solver.
 *
*/

    public static Boolean isSolverDependent(){
        return false;
    }

   public List<ApplicationObjectInterface> getFeasibleValues(ApplicationDatasetInterface base,String attrName){
      if (attrName.equals("concept")){
         return (List) ((Scenario)base).getListConcept();
      }
      if (attrName.equals("work")){
         return (List) ((Scenario)base).getListWork();
      }
      return null;
   }

}
