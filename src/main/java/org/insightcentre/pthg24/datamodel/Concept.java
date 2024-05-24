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

public  class Concept extends ApplicationObject implements AppearInCollection{
/**
 *  
 *
*/

    public Boolean caseSensitive;

    private transient BooleanProperty caseSensitiveWrapper;

/**
 *  
 *
*/

    public ConceptType conceptType;

/**
 *  
 *
*/

    public String label;

/**
 *  
 *
*/

    public Integer nrOccurrences;

/**
 *  
 *
*/

    public String regExpr;

/**
 *  
 *
*/

    public Integer revision;

/**
 *  
 *
*/

    public String shortName;

/**
 *  
 *
*/

    public Double weight;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public Concept(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public Concept(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setCaseSensitive(false);
        setConceptType(null);
        setLabel("");
        setNrOccurrences(0);
        setRegExpr("");
        setRevision(0);
        setShortName("");
        setWeight(1.0);
        applicationDataset.addConcept(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public Concept(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            Boolean caseSensitive,
            ConceptType conceptType,
            String label,
            Integer nrOccurrences,
            String regExpr,
            Integer revision,
            String shortName,
            Double weight){
        super(applicationDataset,
            id,
            name);
        setCaseSensitive(caseSensitive);
        setConceptType(conceptType);
        setLabel(label);
        setNrOccurrences(nrOccurrences);
        setRegExpr(regExpr);
        setRevision(revision);
        setShortName(shortName);
        setWeight(weight);
        applicationDataset.addConcept(this);
    }

    public Concept(Concept other){
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
            other.weight);
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
        getApplicationDataset().cascadeOtherWorkConcept(this);
        return getApplicationDataset().removeConcept(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  (varargs) build list of items of type Concept
 *
 * @param pList multiple items of type Concept
 * @return List<Concept>
*/

    static public List<Concept> buildList(Concept... pList){
        List<Concept> l = new ArrayList<Concept>();
        l.addAll(Arrays.asList(pList));
        return l;
    }

/**
 *  get attribute caseSensitive
 *
 * @return Boolean
*/

    public Boolean getCaseSensitive(){
        return this.caseSensitive;
    }

    public BooleanProperty caseSensitiveWrapperProperty() {
        if (caseSensitiveWrapper == null) {
            caseSensitiveWrapper = new SimpleBooleanProperty();
        }
        caseSensitiveWrapper.set(caseSensitive);
        return caseSensitiveWrapper;
    }

/**
 *  get attribute conceptType
 *
 * @return ConceptType
*/

    public ConceptType getConceptType(){
        return this.conceptType;
    }

/**
 *  get attribute label
 *
 * @return String
*/

    public String getLabel(){
        return this.label;
    }

/**
 *  get attribute nrOccurrences
 *
 * @return Integer
*/

    public Integer getNrOccurrences(){
        return this.nrOccurrences;
    }

/**
 *  get attribute regExpr
 *
 * @return String
*/

    public String getRegExpr(){
        return this.regExpr;
    }

/**
 *  get attribute revision
 *
 * @return Integer
*/

    public Integer getRevision(){
        return this.revision;
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
 *  get attribute weight
 *
 * @return Double
*/

    public Double getWeight(){
        return this.weight;
    }

/**
 *  set attribute caseSensitive, mark dataset as dirty, mark dataset as not valid
@param caseSensitive Boolean
 *
*/

    public void setCaseSensitive(Boolean caseSensitive){
        this.caseSensitive = caseSensitive;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute conceptType, mark dataset as dirty, mark dataset as not valid
@param conceptType ConceptType
 *
*/

    public void setConceptType(ConceptType conceptType){
        this.conceptType = conceptType;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute label, mark dataset as dirty, mark dataset as not valid
@param label String
 *
*/

    public void setLabel(String label){
        this.label = label;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute nrOccurrences, mark dataset as dirty, mark dataset as not valid
@param nrOccurrences Integer
 *
*/

    public void setNrOccurrences(Integer nrOccurrences){
        this.nrOccurrences = nrOccurrences;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute regExpr, mark dataset as dirty, mark dataset as not valid
@param regExpr String
 *
*/

    public void setRegExpr(String regExpr){
        this.regExpr = regExpr;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute revision, mark dataset as dirty, mark dataset as not valid
@param revision Integer
 *
*/

    public void setRevision(Integer revision){
        this.revision = revision;
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
 *  set attribute weight, mark dataset as dirty, mark dataset as not valid
@param weight Double
 *
*/

    public void setWeight(Double weight){
        this.weight = weight;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute nrOccurrences, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrOccurrences(){
        this.nrOccurrences++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute revision, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incRevision(){
        this.revision++;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getCaseSensitive()+ " " +getConceptType().toColumnString()+ " " +getLabel()+ " " +getNrOccurrences()+ " " +getRegExpr()+ " " +getRevision()+ " " +getShortName()+ " " +getWeight();
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
         out.println("<concept "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " caseSensitive=\""+toXMLCaseSensitive()+"\""+
            " conceptType=\""+toXMLConceptType()+"\""+
            " label=\""+toXMLLabel()+"\""+
            " nrOccurrences=\""+toXMLNrOccurrences()+"\""+
            " regExpr=\""+toXMLRegExpr()+"\""+
            " revision=\""+toXMLRevision()+"\""+
            " shortName=\""+toXMLShortName()+"\""+
            " weight=\""+toXMLWeight()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCaseSensitive(){
        return this.getCaseSensitive().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLConceptType(){
        return "ID_"+this.getConceptType().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLLabel(){
        return this.safeXML(getLabel());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLNrOccurrences(){
        return this.getNrOccurrences().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLRegExpr(){
        return this.safeXML(getRegExpr());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLRevision(){
        return this.getRevision().toString();
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
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLWeight(){
        return this.getWeight().toString();
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>Concept</th>"+"<th>Name</th>"+"<th>ShortName</th>"+"<th>ConceptType</th>"+"<th>Label</th>"+"<th>RegExpr</th>"+"<th>CaseSensitive</th>"+"<th>Revision</th>"+"<th>Weight</th>"+"<th>NrOccurrences</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getShortName()+"</td>"+ " " +"<td>"+getConceptType().toColumnString()+"</td>"+ " " +"<td>"+getLabel()+"</td>"+ " " +"<td>"+getRegExpr()+"</td>"+ " " +"<td>"+getCaseSensitive()+"</td>"+ " " +"<td>"+getRevision()+"</td>"+ " " +"<td>"+getWeight()+"</td>"+ " " +"<td>"+getNrOccurrences()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a Concept item we are looking for
 * @param bList List<Concept> list of items in which we are searching
 * @return Concept entry of list b which is applicationSame() to a
*/

    public static Concept find(Concept a, List<Concept> bList){
        for(Concept b : bList){
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
 * @param name Concept name of the object we are looking for
 * @return Concept entry of the dataset with the given name; otherwise null
*/

    public static Concept findByName(ApplicationDataset base, String name){
        for(Concept a:base.getListConcept()) {
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
 * @param name Concept name of the object we are looking for
 * @return Concept entry of the dataset with the given name
*/

    public static Concept findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(Concept a:base.getListConcept()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        Concept res = new Concept(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Concept first entry in the dataset of this type; null if that does not exists
*/

    public static Concept findFirst(ApplicationDataset base){
        if (base.getListConcept().isEmpty()) {
            return null;
        }
        return base.getListConcept().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Concept some entry in the dataset of this type; null if that does not exists
*/

    public static Concept findAny(ApplicationDataset base){
        int size=base.getListConcept().size();
        if (size > 0) {
             return base.getListConcept().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Concept last entry in the dataset of this type; null if that does not exists
*/

    public static Concept findLast(ApplicationDataset base){
        int size=base.getListConcept().size();
        if (size > 0) {
             return base.getListConcept().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b Concept compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(Concept b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b Concept compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(Concept b){
      if(!this.getCaseSensitive().equals(b.getCaseSensitive())){
         System.out.println("CaseSensitive");
        }
      if(!this.getConceptType().applicationSame(b.getConceptType())){
         System.out.println("ConceptType");
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
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","Concept",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getConceptType() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"conceptType","Concept",(getConceptType()==null?"null":getConceptType().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class Concept
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
