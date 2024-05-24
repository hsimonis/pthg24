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

public  class ReferenceFlow extends ApplicationObject{
/**
 *  
 *
*/

    public SourceGroup from;

/**
 *  
 *
*/

    public Double normalized;

/**
 *  
 *
*/

    public SourceGroup to;

/**
 *  
 *
*/

    public Integer value;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public ReferenceFlow(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public ReferenceFlow(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setFrom(null);
        setNormalized(0.0);
        setTo(null);
        setValue(0);
        applicationDataset.addReferenceFlow(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public ReferenceFlow(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            SourceGroup from,
            Double normalized,
            SourceGroup to,
            Integer value){
        super(applicationDataset,
            id,
            name);
        setFrom(from);
        setNormalized(normalized);
        setTo(to);
        setValue(value);
        applicationDataset.addReferenceFlow(this);
    }

    public ReferenceFlow(ReferenceFlow other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.from,
            other.normalized,
            other.to,
            other.value);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        return getApplicationDataset().removeReferenceFlow(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute from
 *
 * @return SourceGroup
*/

    public SourceGroup getFrom(){
        return this.from;
    }

/**
 *  get attribute normalized
 *
 * @return Double
*/

    public Double getNormalized(){
        return this.normalized;
    }

/**
 *  get attribute to
 *
 * @return SourceGroup
*/

    public SourceGroup getTo(){
        return this.to;
    }

/**
 *  get attribute value
 *
 * @return Integer
*/

    public Integer getValue(){
        return this.value;
    }

/**
 *  set attribute from, mark dataset as dirty, mark dataset as not valid
@param from SourceGroup
 *
*/

    public void setFrom(SourceGroup from){
        this.from = from;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute normalized, mark dataset as dirty, mark dataset as not valid
@param normalized Double
 *
*/

    public void setNormalized(Double normalized){
        this.normalized = normalized;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute to, mark dataset as dirty, mark dataset as not valid
@param to SourceGroup
 *
*/

    public void setTo(SourceGroup to){
        this.to = to;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute value, mark dataset as dirty, mark dataset as not valid
@param value Integer
 *
*/

    public void setValue(Integer value){
        this.value = value;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute value, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incValue(){
        this.value++;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getFrom().toColumnString()+ " " +getNormalized()+ " " +getTo().toColumnString()+ " " +getValue();
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
         out.println("<referenceFlow "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " from=\""+toXMLFrom()+"\""+
            " normalized=\""+toXMLNormalized()+"\""+
            " to=\""+toXMLTo()+"\""+
            " value=\""+toXMLValue()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLFrom(){
        return "ID_"+this.getFrom().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLNormalized(){
        return this.getNormalized().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLTo(){
        return "ID_"+this.getTo().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLValue(){
        return this.getValue().toString();
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>ReferenceFlow</th>"+"<th>Name</th>"+"<th>From</th>"+"<th>To</th>"+"<th>Value</th>"+"<th>Normalized</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getFrom().toColumnString()+"</td>"+ " " +"<td>"+getTo().toColumnString()+"</td>"+ " " +"<td>"+getValue()+"</td>"+ " " +"<td>"+getNormalized()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a ReferenceFlow item we are looking for
 * @param bList List<ReferenceFlow> list of items in which we are searching
 * @return ReferenceFlow entry of list b which is applicationSame() to a
*/

    public static ReferenceFlow find(ReferenceFlow a, List<ReferenceFlow> bList){
        for(ReferenceFlow b : bList){
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
 * @param name ReferenceFlow name of the object we are looking for
 * @return ReferenceFlow entry of the dataset with the given name; otherwise null
*/

    public static ReferenceFlow findByName(ApplicationDataset base, String name){
        for(ReferenceFlow a:base.getListReferenceFlow()) {
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
 * @param name ReferenceFlow name of the object we are looking for
 * @return ReferenceFlow entry of the dataset with the given name
*/

    public static ReferenceFlow findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(ReferenceFlow a:base.getListReferenceFlow()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        ReferenceFlow res = new ReferenceFlow(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ReferenceFlow first entry in the dataset of this type; null if that does not exists
*/

    public static ReferenceFlow findFirst(ApplicationDataset base){
        if (base.getListReferenceFlow().isEmpty()) {
            return null;
        }
        return base.getListReferenceFlow().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ReferenceFlow some entry in the dataset of this type; null if that does not exists
*/

    public static ReferenceFlow findAny(ApplicationDataset base){
        int size=base.getListReferenceFlow().size();
        if (size > 0) {
             return base.getListReferenceFlow().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ReferenceFlow last entry in the dataset of this type; null if that does not exists
*/

    public static ReferenceFlow findLast(ApplicationDataset base){
        int size=base.getListReferenceFlow().size();
        if (size > 0) {
             return base.getListReferenceFlow().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b ReferenceFlow compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(ReferenceFlow b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b ReferenceFlow compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(ReferenceFlow b){
      if(!this.getFrom().applicationSame(b.getFrom())){
         System.out.println("From");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getNormalized().equals(b.getNormalized())){
         System.out.println("Normalized");
        }
      if(!this.getTo().applicationSame(b.getTo())){
         System.out.println("To");
        }
      if(!this.getValue().equals(b.getValue())){
         System.out.println("Value");
        }
        return  this.getFrom().applicationSame(b.getFrom()) &&
          this.getName().equals(b.getName()) &&
          this.getNormalized().equals(b.getNormalized()) &&
          this.getTo().applicationSame(b.getTo()) &&
          this.getValue().equals(b.getValue());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","ReferenceFlow",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getFrom() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"from","ReferenceFlow",(getFrom()==null?"null":getFrom().toString()),"",WarningType.NOTNULL);
        }
        if (getTo() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"to","ReferenceFlow",(getTo()==null?"null":getTo().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class ReferenceFlow
    }

/**
 *  This method states if the class depends on the solver.
 *
*/

    public static Boolean isSolverDependent(){
        return false;
    }

   public List<ApplicationObjectInterface> getFeasibleValues(ApplicationDatasetInterface base,String attrName){
      if (attrName.equals("from")){
         return (List) ((Scenario)base).getListSourceGroup();
      }
      if (attrName.equals("to")){
         return (List) ((Scenario)base).getListSourceGroup();
      }
      return null;
   }

}
