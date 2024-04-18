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

public  class Similarity extends ApplicationObject{
/**
 *  
 *
*/

    public Integer cite1;

/**
 *  
 *
*/

    public Integer cite2;

/**
 *  
 *
*/

    public Integer nrSharedCitations;

/**
 *  
 *
*/

    public Integer nrSharedReferences;

/**
 *  
 *
*/

    public Integer ref1;

/**
 *  
 *
*/

    public Integer ref2;

/**
 *  
 *
*/

    public Double similarity;

/**
 *  
 *
*/

    public Double similarityCite;

/**
 *  
 *
*/

    public Double similarityConcept;

/**
 *  
 *
*/

    public Double similarityRef;

/**
 *  
 *
*/

    public Work work1;

/**
 *  
 *
*/

    public Work work2;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public Similarity(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public Similarity(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setCite1(0);
        setCite2(0);
        setNrSharedCitations(0);
        setNrSharedReferences(0);
        setRef1(0);
        setRef2(0);
        setSimilarity(0.0);
        setSimilarityCite(0.0);
        setSimilarityConcept(0.0);
        setSimilarityRef(0.0);
        setWork1(null);
        setWork2(null);
        applicationDataset.addSimilarity(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public Similarity(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            Integer cite1,
            Integer cite2,
            Integer nrSharedCitations,
            Integer nrSharedReferences,
            Integer ref1,
            Integer ref2,
            Double similarity,
            Double similarityCite,
            Double similarityConcept,
            Double similarityRef,
            Work work1,
            Work work2){
        super(applicationDataset,
            id,
            name);
        setCite1(cite1);
        setCite2(cite2);
        setNrSharedCitations(nrSharedCitations);
        setNrSharedReferences(nrSharedReferences);
        setRef1(ref1);
        setRef2(ref2);
        setSimilarity(similarity);
        setSimilarityCite(similarityCite);
        setSimilarityConcept(similarityConcept);
        setSimilarityRef(similarityRef);
        setWork1(work1);
        setWork2(work2);
        applicationDataset.addSimilarity(this);
    }

    public Similarity(Similarity other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.cite1,
            other.cite2,
            other.nrSharedCitations,
            other.nrSharedReferences,
            other.ref1,
            other.ref2,
            other.similarity,
            other.similarityCite,
            other.similarityConcept,
            other.similarityRef,
            other.work1,
            other.work2);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        return getApplicationDataset().removeSimilarity(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute cite1
 *
 * @return Integer
*/

    public Integer getCite1(){
        return this.cite1;
    }

/**
 *  get attribute cite2
 *
 * @return Integer
*/

    public Integer getCite2(){
        return this.cite2;
    }

/**
 *  get attribute nrSharedCitations
 *
 * @return Integer
*/

    public Integer getNrSharedCitations(){
        return this.nrSharedCitations;
    }

/**
 *  get attribute nrSharedReferences
 *
 * @return Integer
*/

    public Integer getNrSharedReferences(){
        return this.nrSharedReferences;
    }

/**
 *  get attribute ref1
 *
 * @return Integer
*/

    public Integer getRef1(){
        return this.ref1;
    }

/**
 *  get attribute ref2
 *
 * @return Integer
*/

    public Integer getRef2(){
        return this.ref2;
    }

/**
 *  get attribute similarity
 *
 * @return Double
*/

    public Double getSimilarity(){
        return this.similarity;
    }

/**
 *  get attribute similarityCite
 *
 * @return Double
*/

    public Double getSimilarityCite(){
        return this.similarityCite;
    }

/**
 *  get attribute similarityConcept
 *
 * @return Double
*/

    public Double getSimilarityConcept(){
        return this.similarityConcept;
    }

/**
 *  get attribute similarityRef
 *
 * @return Double
*/

    public Double getSimilarityRef(){
        return this.similarityRef;
    }

/**
 *  get attribute work1
 *
 * @return Work
*/

    public Work getWork1(){
        return this.work1;
    }

/**
 *  get attribute work2
 *
 * @return Work
*/

    public Work getWork2(){
        return this.work2;
    }

/**
 *  set attribute cite1, mark dataset as dirty, mark dataset as not valid
@param cite1 Integer
 *
*/

    public void setCite1(Integer cite1){
        this.cite1 = cite1;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute cite2, mark dataset as dirty, mark dataset as not valid
@param cite2 Integer
 *
*/

    public void setCite2(Integer cite2){
        this.cite2 = cite2;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute nrSharedCitations, mark dataset as dirty, mark dataset as not valid
@param nrSharedCitations Integer
 *
*/

    public void setNrSharedCitations(Integer nrSharedCitations){
        this.nrSharedCitations = nrSharedCitations;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute nrSharedReferences, mark dataset as dirty, mark dataset as not valid
@param nrSharedReferences Integer
 *
*/

    public void setNrSharedReferences(Integer nrSharedReferences){
        this.nrSharedReferences = nrSharedReferences;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute ref1, mark dataset as dirty, mark dataset as not valid
@param ref1 Integer
 *
*/

    public void setRef1(Integer ref1){
        this.ref1 = ref1;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute ref2, mark dataset as dirty, mark dataset as not valid
@param ref2 Integer
 *
*/

    public void setRef2(Integer ref2){
        this.ref2 = ref2;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute similarity, mark dataset as dirty, mark dataset as not valid
@param similarity Double
 *
*/

    public void setSimilarity(Double similarity){
        this.similarity = similarity;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute similarityCite, mark dataset as dirty, mark dataset as not valid
@param similarityCite Double
 *
*/

    public void setSimilarityCite(Double similarityCite){
        this.similarityCite = similarityCite;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute similarityConcept, mark dataset as dirty, mark dataset as not valid
@param similarityConcept Double
 *
*/

    public void setSimilarityConcept(Double similarityConcept){
        this.similarityConcept = similarityConcept;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute similarityRef, mark dataset as dirty, mark dataset as not valid
@param similarityRef Double
 *
*/

    public void setSimilarityRef(Double similarityRef){
        this.similarityRef = similarityRef;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute work1, mark dataset as dirty, mark dataset as not valid
@param work1 Work
 *
*/

    public void setWork1(Work work1){
        this.work1 = work1;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute work2, mark dataset as dirty, mark dataset as not valid
@param work2 Work
 *
*/

    public void setWork2(Work work2){
        this.work2 = work2;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute cite1, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incCite1(){
        this.cite1++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute cite2, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incCite2(){
        this.cite2++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute nrSharedCitations, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrSharedCitations(){
        this.nrSharedCitations++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute nrSharedReferences, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrSharedReferences(){
        this.nrSharedReferences++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute ref1, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incRef1(){
        this.ref1++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute ref2, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incRef2(){
        this.ref2++;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getCite1()+ " " +getCite2()+ " " +getNrSharedCitations()+ " " +getNrSharedReferences()+ " " +getRef1()+ " " +getRef2()+ " " +getSimilarity()+ " " +getSimilarityCite()+ " " +getSimilarityConcept()+ " " +getSimilarityRef()+ " " +getWork1().toColumnString()+ " " +getWork2().toColumnString();
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
         out.println("<similarity "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " cite1=\""+toXMLCite1()+"\""+
            " cite2=\""+toXMLCite2()+"\""+
            " nrSharedCitations=\""+toXMLNrSharedCitations()+"\""+
            " nrSharedReferences=\""+toXMLNrSharedReferences()+"\""+
            " ref1=\""+toXMLRef1()+"\""+
            " ref2=\""+toXMLRef2()+"\""+
            " similarity=\""+toXMLSimilarity()+"\""+
            " similarityCite=\""+toXMLSimilarityCite()+"\""+
            " similarityConcept=\""+toXMLSimilarityConcept()+"\""+
            " similarityRef=\""+toXMLSimilarityRef()+"\""+
            " work1=\""+toXMLWork1()+"\""+
            " work2=\""+toXMLWork2()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCite1(){
        return this.getCite1().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCite2(){
        return this.getCite2().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLNrSharedCitations(){
        return this.getNrSharedCitations().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLNrSharedReferences(){
        return this.getNrSharedReferences().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLRef1(){
        return this.getRef1().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLRef2(){
        return this.getRef2().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLSimilarity(){
        return this.getSimilarity().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLSimilarityCite(){
        return this.getSimilarityCite().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLSimilarityConcept(){
        return this.getSimilarityConcept().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLSimilarityRef(){
        return this.getSimilarityRef().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLWork1(){
        return "ID_"+this.getWork1().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLWork2(){
        return "ID_"+this.getWork2().getId().toString();
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>Similarity</th>"+"<th>Name</th>"+"<th>Work1</th>"+"<th>Work2</th>"+"<th>Ref1</th>"+"<th>Ref2</th>"+"<th>NrSharedReferences</th>"+"<th>Cite1</th>"+"<th>Cite2</th>"+"<th>NrSharedCitations</th>"+"<th>SimilarityRef</th>"+"<th>SimilarityCite</th>"+"<th>SimilarityConcept</th>"+"<th>Similarity</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getWork1().toColumnString()+"</td>"+ " " +"<td>"+getWork2().toColumnString()+"</td>"+ " " +"<td>"+getRef1()+"</td>"+ " " +"<td>"+getRef2()+"</td>"+ " " +"<td>"+getNrSharedReferences()+"</td>"+ " " +"<td>"+getCite1()+"</td>"+ " " +"<td>"+getCite2()+"</td>"+ " " +"<td>"+getNrSharedCitations()+"</td>"+ " " +"<td>"+getSimilarityRef()+"</td>"+ " " +"<td>"+getSimilarityCite()+"</td>"+ " " +"<td>"+getSimilarityConcept()+"</td>"+ " " +"<td>"+getSimilarity()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a Similarity item we are looking for
 * @param bList List<Similarity> list of items in which we are searching
 * @return Similarity entry of list b which is applicationSame() to a
*/

    public static Similarity find(Similarity a, List<Similarity> bList){
        for(Similarity b : bList){
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
 * @param name Similarity name of the object we are looking for
 * @return Similarity entry of the dataset with the given name; otherwise null
*/

    public static Similarity findByName(ApplicationDataset base, String name){
        for(Similarity a:base.getListSimilarity()) {
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
 * @param name Similarity name of the object we are looking for
 * @return Similarity entry of the dataset with the given name
*/

    public static Similarity findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(Similarity a:base.getListSimilarity()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        Similarity res = new Similarity(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Similarity first entry in the dataset of this type; null if that does not exists
*/

    public static Similarity findFirst(ApplicationDataset base){
        if (base.getListSimilarity().isEmpty()) {
            return null;
        }
        return base.getListSimilarity().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Similarity some entry in the dataset of this type; null if that does not exists
*/

    public static Similarity findAny(ApplicationDataset base){
        int size=base.getListSimilarity().size();
        if (size > 0) {
             return base.getListSimilarity().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Similarity last entry in the dataset of this type; null if that does not exists
*/

    public static Similarity findLast(ApplicationDataset base){
        int size=base.getListSimilarity().size();
        if (size > 0) {
             return base.getListSimilarity().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b Similarity compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(Similarity b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b Similarity compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(Similarity b){
      if(!this.getCite1().equals(b.getCite1())){
         System.out.println("Cite1");
        }
      if(!this.getCite2().equals(b.getCite2())){
         System.out.println("Cite2");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getNrSharedCitations().equals(b.getNrSharedCitations())){
         System.out.println("NrSharedCitations");
        }
      if(!this.getNrSharedReferences().equals(b.getNrSharedReferences())){
         System.out.println("NrSharedReferences");
        }
      if(!this.getRef1().equals(b.getRef1())){
         System.out.println("Ref1");
        }
      if(!this.getRef2().equals(b.getRef2())){
         System.out.println("Ref2");
        }
      if(!this.getSimilarity().equals(b.getSimilarity())){
         System.out.println("Similarity");
        }
      if(!this.getSimilarityCite().equals(b.getSimilarityCite())){
         System.out.println("SimilarityCite");
        }
      if(!this.getSimilarityConcept().equals(b.getSimilarityConcept())){
         System.out.println("SimilarityConcept");
        }
      if(!this.getSimilarityRef().equals(b.getSimilarityRef())){
         System.out.println("SimilarityRef");
        }
      if(!this.getWork1().applicationSame(b.getWork1())){
         System.out.println("Work1");
        }
      if(!this.getWork2().applicationSame(b.getWork2())){
         System.out.println("Work2");
        }
        return  this.getCite1().equals(b.getCite1()) &&
          this.getCite2().equals(b.getCite2()) &&
          this.getName().equals(b.getName()) &&
          this.getNrSharedCitations().equals(b.getNrSharedCitations()) &&
          this.getNrSharedReferences().equals(b.getNrSharedReferences()) &&
          this.getRef1().equals(b.getRef1()) &&
          this.getRef2().equals(b.getRef2()) &&
          this.getSimilarity().equals(b.getSimilarity()) &&
          this.getSimilarityCite().equals(b.getSimilarityCite()) &&
          this.getSimilarityConcept().equals(b.getSimilarityConcept()) &&
          this.getSimilarityRef().equals(b.getSimilarityRef()) &&
          this.getWork1().applicationSame(b.getWork1()) &&
          this.getWork2().applicationSame(b.getWork2());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","Similarity",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getWork1() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"work1","Similarity",(getWork1()==null?"null":getWork1().toString()),"",WarningType.NOTNULL);
        }
        if (getWork2() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"work2","Similarity",(getWork2()==null?"null":getWork2().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class Similarity
    }

/**
 *  This method states if the class depends on the solver.
 *
*/

    public static Boolean isSolverDependent(){
        return false;
    }

   public List<ApplicationObjectInterface> getFeasibleValues(ApplicationDatasetInterface base,String attrName){
      if (attrName.equals("work1")){
         return (List) ((Scenario)base).getListWork();
      }
      if (attrName.equals("work2")){
         return (List) ((Scenario)base).getListWork();
      }
      return null;
   }

}
