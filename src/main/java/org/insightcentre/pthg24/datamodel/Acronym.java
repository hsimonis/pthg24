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

public  class Acronym extends Concept{
/**
 *  
 *
*/

    public String description;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public Acronym(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public Acronym(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setDescription("");
        applicationDataset.addAcronym(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public Acronym(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            Boolean caseSensitive,
            ConceptType conceptType,
            String label,
            Integer nrOccurrences,
            String regExpr,
            Integer revision,
            String shortName,
            Double weight,
            String description){
        super(applicationDataset,
            id,
            name,
            caseSensitive,
            conceptType,
            label,
            nrOccurrences,
            regExpr,
            revision,
            shortName,
            weight);
        setDescription(description);
        applicationDataset.addAcronym(this);
    }

    public Acronym(Acronym other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.caseSensitive,
            other.conceptType,
            other.label,
            other.nrOccurrences,
            other.regExpr,
            other.revision,
            other.shortName,
            other.weight,
            other.description);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        getApplicationDataset().cascadeWorkConcept(this);
        getApplicationDataset().cascadeConceptWorkConcept(this);
        getApplicationDataset().cascadeMissingWorkConcept(this);
        return getApplicationDataset().removeAcronym(this) && getApplicationDataset().removeConcept(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute description
 *
 * @return String
*/

    public String getDescription(){
        return this.description;
    }

/**
 *  set attribute description, mark dataset as dirty, mark dataset as not valid
@param description String
 *
*/

    public void setDescription(String description){
        this.description = description;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getCaseSensitive()+ " " +getConceptType().toColumnString()+ " " +getLabel()+ " " +getNrOccurrences()+ " " +getRegExpr()+ " " +getRevision()+ " " +getShortName()+ " " +getWeight()+ " " +getDescription();
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
         out.println("<acronym "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " caseSensitive=\""+toXMLCaseSensitive()+"\""+
            " conceptType=\""+toXMLConceptType()+"\""+
            " label=\""+toXMLLabel()+"\""+
            " nrOccurrences=\""+toXMLNrOccurrences()+"\""+
            " regExpr=\""+toXMLRegExpr()+"\""+
            " revision=\""+toXMLRevision()+"\""+
            " shortName=\""+toXMLShortName()+"\""+
            " weight=\""+toXMLWeight()+"\""+
            " description=\""+toXMLDescription()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLDescription(){
        return this.safeXML(getDescription());
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>Acronym</th>"+"<th>Name</th>"+"<th>ShortName</th>"+"<th>ConceptType</th>"+"<th>Label</th>"+"<th>RegExpr</th>"+"<th>CaseSensitive</th>"+"<th>Revision</th>"+"<th>Weight</th>"+"<th>NrOccurrences</th>"+"<th>Description</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getShortName()+"</td>"+ " " +"<td>"+getConceptType().toColumnString()+"</td>"+ " " +"<td>"+getLabel()+"</td>"+ " " +"<td>"+getRegExpr()+"</td>"+ " " +"<td>"+getCaseSensitive()+"</td>"+ " " +"<td>"+getRevision()+"</td>"+ " " +"<td>"+getWeight()+"</td>"+ " " +"<td>"+getNrOccurrences()+"</td>"+ " " +"<td>"+getDescription()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a Acronym item we are looking for
 * @param bList List<Acronym> list of items in which we are searching
 * @return Acronym entry of list b which is applicationSame() to a
*/

    public static Acronym find(Acronym a, List<Acronym> bList){
        for(Acronym b : bList){
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
 * @param name Acronym name of the object we are looking for
 * @return Acronym entry of the dataset with the given name; otherwise null
*/

    public static Acronym findByName(ApplicationDataset base, String name){
        for(Acronym a:base.getListAcronym()) {
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
 * @param name Acronym name of the object we are looking for
 * @return Acronym entry of the dataset with the given name
*/

    public static Acronym findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(Acronym a:base.getListAcronym()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        Acronym res = new Acronym(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Acronym first entry in the dataset of this type; null if that does not exists
*/

    public static Acronym findFirst(ApplicationDataset base){
        if (base.getListAcronym().isEmpty()) {
            return null;
        }
        return base.getListAcronym().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Acronym some entry in the dataset of this type; null if that does not exists
*/

    public static Acronym findAny(ApplicationDataset base){
        int size=base.getListAcronym().size();
        if (size > 0) {
             return base.getListAcronym().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Acronym last entry in the dataset of this type; null if that does not exists
*/

    public static Acronym findLast(ApplicationDataset base){
        int size=base.getListAcronym().size();
        if (size > 0) {
             return base.getListAcronym().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b Acronym compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(Acronym b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b Acronym compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(Acronym b){
      if(!this.getCaseSensitive().equals(b.getCaseSensitive())){
         System.out.println("CaseSensitive");
        }
      if(!this.getConceptType().applicationSame(b.getConceptType())){
         System.out.println("ConceptType");
        }
      if(!this.getDescription().equals(b.getDescription())){
         System.out.println("Description");
        }
      if(!this.getLabel().equals(b.getLabel())){
         System.out.println("Label");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getNrOccurrences().equals(b.getNrOccurrences())){
         System.out.println("NrOccurrences");
        }
      if(!this.getRegExpr().equals(b.getRegExpr())){
         System.out.println("RegExpr");
        }
      if(!this.getRevision().equals(b.getRevision())){
         System.out.println("Revision");
        }
      if(!this.getShortName().equals(b.getShortName())){
         System.out.println("ShortName");
        }
      if(!this.getWeight().equals(b.getWeight())){
         System.out.println("Weight");
        }
        return  this.getCaseSensitive().equals(b.getCaseSensitive()) &&
          this.getConceptType().applicationSame(b.getConceptType()) &&
          this.getDescription().equals(b.getDescription()) &&
          this.getLabel().equals(b.getLabel()) &&
          this.getName().equals(b.getName()) &&
          this.getNrOccurrences().equals(b.getNrOccurrences()) &&
          this.getRegExpr().equals(b.getRegExpr()) &&
          this.getRevision().equals(b.getRevision()) &&
          this.getShortName().equals(b.getShortName()) &&
          this.getWeight().equals(b.getWeight());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","Acronym",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getConceptType() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"conceptType","Acronym",(getConceptType()==null?"null":getConceptType().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class Acronym
    }

/**
 *  This method states if the class depends on the solver.
 *
*/

    public static Boolean isSolverDependent(){
        return false;
    }

   public List<ApplicationObjectInterface> getFeasibleValues(ApplicationDatasetInterface base,String attrName){
      if (attrName.equals("conceptType")){
         return (List) ((Scenario)base).getListConceptType();
      }
      return null;
   }

}
