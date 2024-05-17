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

public  class ScopusAffiliation extends ApplicationObject{
/**
 *  
 *
*/

    public Integer collabCount;

/**
 *  
 *
*/

    public Double collabFraction;

/**
 *  
 *
*/

    public Double collabPercentage;

/**
 *  
 *
*/

    public Integer domesticCollabCount;

/**
 *  
 *
*/

    public Double domesticCollabFraction;

/**
 *  
 *
*/

    public String inst;

/**
 *  
 *
*/

    public Integer internationalCollabCount;

/**
 *  
 *
*/

    public Double internationalCollabFraction;

/**
 *  
 *
*/

    public Double internationalPercentage;

/**
 *  
 *
*/

    public ScopusCity scopusCity;

/**
 *  
 *
*/

    public Integer workCount;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public ScopusAffiliation(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public ScopusAffiliation(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setCollabCount(0);
        setCollabFraction(0.0);
        setCollabPercentage(0.0);
        setDomesticCollabCount(0);
        setDomesticCollabFraction(0.0);
        setInst("");
        setInternationalCollabCount(0);
        setInternationalCollabFraction(0.0);
        setInternationalPercentage(0.0);
        setScopusCity(null);
        setWorkCount(0);
        applicationDataset.addScopusAffiliation(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public ScopusAffiliation(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            Integer collabCount,
            Double collabFraction,
            Double collabPercentage,
            Integer domesticCollabCount,
            Double domesticCollabFraction,
            String inst,
            Integer internationalCollabCount,
            Double internationalCollabFraction,
            Double internationalPercentage,
            ScopusCity scopusCity,
            Integer workCount){
        super(applicationDataset,
            id,
            name);
        setCollabCount(collabCount);
        setCollabFraction(collabFraction);
        setCollabPercentage(collabPercentage);
        setDomesticCollabCount(domesticCollabCount);
        setDomesticCollabFraction(domesticCollabFraction);
        setInst(inst);
        setInternationalCollabCount(internationalCollabCount);
        setInternationalCollabFraction(internationalCollabFraction);
        setInternationalPercentage(internationalPercentage);
        setScopusCity(scopusCity);
        setWorkCount(workCount);
        applicationDataset.addScopusAffiliation(this);
    }

    public ScopusAffiliation(ScopusAffiliation other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.collabCount,
            other.collabFraction,
            other.collabPercentage,
            other.domesticCollabCount,
            other.domesticCollabFraction,
            other.inst,
            other.internationalCollabCount,
            other.internationalCollabFraction,
            other.internationalPercentage,
            other.scopusCity,
            other.workCount);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        getApplicationDataset().cascadeWorkAffiliationScopusAffiliation(this);
        getApplicationDataset().cascadeCollabWorkAffiliation1(this);
        getApplicationDataset().cascadeCollabWorkAffiliation2(this);
        getApplicationDataset().cascadeCollabCountAffiliation1(this);
        getApplicationDataset().cascadeCollabCountAffiliation2(this);
        return getApplicationDataset().removeScopusAffiliation(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute collabCount
 *
 * @return Integer
*/

    public Integer getCollabCount(){
        return this.collabCount;
    }

/**
 *  get attribute collabFraction
 *
 * @return Double
*/

    public Double getCollabFraction(){
        return this.collabFraction;
    }

/**
 *  get attribute collabPercentage
 *
 * @return Double
*/

    public Double getCollabPercentage(){
        return this.collabPercentage;
    }

/**
 *  get attribute domesticCollabCount
 *
 * @return Integer
*/

    public Integer getDomesticCollabCount(){
        return this.domesticCollabCount;
    }

/**
 *  get attribute domesticCollabFraction
 *
 * @return Double
*/

    public Double getDomesticCollabFraction(){
        return this.domesticCollabFraction;
    }

/**
 *  get attribute inst
 *
 * @return String
*/

    public String getInst(){
        return this.inst;
    }

/**
 *  get attribute internationalCollabCount
 *
 * @return Integer
*/

    public Integer getInternationalCollabCount(){
        return this.internationalCollabCount;
    }

/**
 *  get attribute internationalCollabFraction
 *
 * @return Double
*/

    public Double getInternationalCollabFraction(){
        return this.internationalCollabFraction;
    }

/**
 *  get attribute internationalPercentage
 *
 * @return Double
*/

    public Double getInternationalPercentage(){
        return this.internationalPercentage;
    }

/**
 *  get attribute scopusCity
 *
 * @return ScopusCity
*/

    public ScopusCity getScopusCity(){
        return this.scopusCity;
    }

/**
 *  get attribute workCount
 *
 * @return Integer
*/

    public Integer getWorkCount(){
        return this.workCount;
    }

/**
 *  set attribute collabCount, mark dataset as dirty, mark dataset as not valid
@param collabCount Integer
 *
*/

    public void setCollabCount(Integer collabCount){
        this.collabCount = collabCount;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute collabFraction, mark dataset as dirty, mark dataset as not valid
@param collabFraction Double
 *
*/

    public void setCollabFraction(Double collabFraction){
        this.collabFraction = collabFraction;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute collabPercentage, mark dataset as dirty, mark dataset as not valid
@param collabPercentage Double
 *
*/

    public void setCollabPercentage(Double collabPercentage){
        this.collabPercentage = collabPercentage;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute domesticCollabCount, mark dataset as dirty, mark dataset as not valid
@param domesticCollabCount Integer
 *
*/

    public void setDomesticCollabCount(Integer domesticCollabCount){
        this.domesticCollabCount = domesticCollabCount;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute domesticCollabFraction, mark dataset as dirty, mark dataset as not valid
@param domesticCollabFraction Double
 *
*/

    public void setDomesticCollabFraction(Double domesticCollabFraction){
        this.domesticCollabFraction = domesticCollabFraction;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute inst, mark dataset as dirty, mark dataset as not valid
@param inst String
 *
*/

    public void setInst(String inst){
        this.inst = inst;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute internationalCollabCount, mark dataset as dirty, mark dataset as not valid
@param internationalCollabCount Integer
 *
*/

    public void setInternationalCollabCount(Integer internationalCollabCount){
        this.internationalCollabCount = internationalCollabCount;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute internationalCollabFraction, mark dataset as dirty, mark dataset as not valid
@param internationalCollabFraction Double
 *
*/

    public void setInternationalCollabFraction(Double internationalCollabFraction){
        this.internationalCollabFraction = internationalCollabFraction;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute internationalPercentage, mark dataset as dirty, mark dataset as not valid
@param internationalPercentage Double
 *
*/

    public void setInternationalPercentage(Double internationalPercentage){
        this.internationalPercentage = internationalPercentage;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute scopusCity, mark dataset as dirty, mark dataset as not valid
@param scopusCity ScopusCity
 *
*/

    public void setScopusCity(ScopusCity scopusCity){
        this.scopusCity = scopusCity;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute workCount, mark dataset as dirty, mark dataset as not valid
@param workCount Integer
 *
*/

    public void setWorkCount(Integer workCount){
        this.workCount = workCount;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute collabCount, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incCollabCount(){
        this.collabCount++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute domesticCollabCount, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incDomesticCollabCount(){
        this.domesticCollabCount++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute internationalCollabCount, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incInternationalCollabCount(){
        this.internationalCollabCount++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute workCount, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incWorkCount(){
        this.workCount++;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getCollabCount()+ " " +getCollabFraction()+ " " +getCollabPercentage()+ " " +getDomesticCollabCount()+ " " +getDomesticCollabFraction()+ " " +getInst()+ " " +getInternationalCollabCount()+ " " +getInternationalCollabFraction()+ " " +getInternationalPercentage()+ " " +getScopusCity().toColumnString()+ " " +getWorkCount();
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
         out.println("<scopusAffiliation "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " collabCount=\""+toXMLCollabCount()+"\""+
            " collabFraction=\""+toXMLCollabFraction()+"\""+
            " collabPercentage=\""+toXMLCollabPercentage()+"\""+
            " domesticCollabCount=\""+toXMLDomesticCollabCount()+"\""+
            " domesticCollabFraction=\""+toXMLDomesticCollabFraction()+"\""+
            " inst=\""+toXMLInst()+"\""+
            " internationalCollabCount=\""+toXMLInternationalCollabCount()+"\""+
            " internationalCollabFraction=\""+toXMLInternationalCollabFraction()+"\""+
            " internationalPercentage=\""+toXMLInternationalPercentage()+"\""+
            " scopusCity=\""+toXMLScopusCity()+"\""+
            " workCount=\""+toXMLWorkCount()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCollabCount(){
        return this.getCollabCount().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCollabFraction(){
        return this.getCollabFraction().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCollabPercentage(){
        return this.getCollabPercentage().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLDomesticCollabCount(){
        return this.getDomesticCollabCount().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLDomesticCollabFraction(){
        return this.getDomesticCollabFraction().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLInst(){
        return this.safeXML(getInst());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLInternationalCollabCount(){
        return this.getInternationalCollabCount().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLInternationalCollabFraction(){
        return this.getInternationalCollabFraction().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLInternationalPercentage(){
        return this.getInternationalPercentage().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLScopusCity(){
        return "ID_"+this.getScopusCity().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLWorkCount(){
        return this.getWorkCount().toString();
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>ScopusAffiliation</th>"+"<th>Name</th>"+"<th>Inst</th>"+"<th>ScopusCity</th>"+"<th>WorkCount</th>"+"<th>CollabCount</th>"+"<th>DomesticCollabCount</th>"+"<th>InternationalCollabCount</th>"+"<th>CollabFraction</th>"+"<th>DomesticCollabFraction</th>"+"<th>InternationalCollabFraction</th>"+"<th>CollabPercentage</th>"+"<th>InternationalPercentage</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getInst()+"</td>"+ " " +"<td>"+getScopusCity().toColumnString()+"</td>"+ " " +"<td>"+getWorkCount()+"</td>"+ " " +"<td>"+getCollabCount()+"</td>"+ " " +"<td>"+getDomesticCollabCount()+"</td>"+ " " +"<td>"+getInternationalCollabCount()+"</td>"+ " " +"<td>"+getCollabFraction()+"</td>"+ " " +"<td>"+getDomesticCollabFraction()+"</td>"+ " " +"<td>"+getInternationalCollabFraction()+"</td>"+ " " +"<td>"+getCollabPercentage()+"</td>"+ " " +"<td>"+getInternationalPercentage()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a ScopusAffiliation item we are looking for
 * @param bList List<ScopusAffiliation> list of items in which we are searching
 * @return ScopusAffiliation entry of list b which is applicationSame() to a
*/

    public static ScopusAffiliation find(ScopusAffiliation a, List<ScopusAffiliation> bList){
        for(ScopusAffiliation b : bList){
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
 * @param name ScopusAffiliation name of the object we are looking for
 * @return ScopusAffiliation entry of the dataset with the given name; otherwise null
*/

    public static ScopusAffiliation findByName(ApplicationDataset base, String name){
        for(ScopusAffiliation a:base.getListScopusAffiliation()) {
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
 * @param name ScopusAffiliation name of the object we are looking for
 * @return ScopusAffiliation entry of the dataset with the given name
*/

    public static ScopusAffiliation findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(ScopusAffiliation a:base.getListScopusAffiliation()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        ScopusAffiliation res = new ScopusAffiliation(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ScopusAffiliation first entry in the dataset of this type; null if that does not exists
*/

    public static ScopusAffiliation findFirst(ApplicationDataset base){
        if (base.getListScopusAffiliation().isEmpty()) {
            return null;
        }
        return base.getListScopusAffiliation().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ScopusAffiliation some entry in the dataset of this type; null if that does not exists
*/

    public static ScopusAffiliation findAny(ApplicationDataset base){
        int size=base.getListScopusAffiliation().size();
        if (size > 0) {
             return base.getListScopusAffiliation().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ScopusAffiliation last entry in the dataset of this type; null if that does not exists
*/

    public static ScopusAffiliation findLast(ApplicationDataset base){
        int size=base.getListScopusAffiliation().size();
        if (size > 0) {
             return base.getListScopusAffiliation().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b ScopusAffiliation compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(ScopusAffiliation b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b ScopusAffiliation compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(ScopusAffiliation b){
      if(!this.getCollabCount().equals(b.getCollabCount())){
         System.out.println("CollabCount");
        }
      if(!this.getCollabFraction().equals(b.getCollabFraction())){
         System.out.println("CollabFraction");
        }
      if(!this.getCollabPercentage().equals(b.getCollabPercentage())){
         System.out.println("CollabPercentage");
        }
      if(!this.getDomesticCollabCount().equals(b.getDomesticCollabCount())){
         System.out.println("DomesticCollabCount");
        }
      if(!this.getDomesticCollabFraction().equals(b.getDomesticCollabFraction())){
         System.out.println("DomesticCollabFraction");
        }
      if(!this.getInst().equals(b.getInst())){
         System.out.println("Inst");
        }
      if(!this.getInternationalCollabCount().equals(b.getInternationalCollabCount())){
         System.out.println("InternationalCollabCount");
        }
      if(!this.getInternationalCollabFraction().equals(b.getInternationalCollabFraction())){
         System.out.println("InternationalCollabFraction");
        }
      if(!this.getInternationalPercentage().equals(b.getInternationalPercentage())){
         System.out.println("InternationalPercentage");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getScopusCity().applicationSame(b.getScopusCity())){
         System.out.println("ScopusCity");
        }
      if(!this.getWorkCount().equals(b.getWorkCount())){
         System.out.println("WorkCount");
        }
        return  this.getCollabCount().equals(b.getCollabCount()) &&
          this.getCollabFraction().equals(b.getCollabFraction()) &&
          this.getCollabPercentage().equals(b.getCollabPercentage()) &&
          this.getDomesticCollabCount().equals(b.getDomesticCollabCount()) &&
          this.getDomesticCollabFraction().equals(b.getDomesticCollabFraction()) &&
          this.getInst().equals(b.getInst()) &&
          this.getInternationalCollabCount().equals(b.getInternationalCollabCount()) &&
          this.getInternationalCollabFraction().equals(b.getInternationalCollabFraction()) &&
          this.getInternationalPercentage().equals(b.getInternationalPercentage()) &&
          this.getName().equals(b.getName()) &&
          this.getScopusCity().applicationSame(b.getScopusCity()) &&
          this.getWorkCount().equals(b.getWorkCount());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","ScopusAffiliation",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getScopusCity() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"scopusCity","ScopusAffiliation",(getScopusCity()==null?"null":getScopusCity().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class ScopusAffiliation
    }

/**
 *  This method states if the class depends on the solver.
 *
*/

    public static Boolean isSolverDependent(){
        return false;
    }

   public List<ApplicationObjectInterface> getFeasibleValues(ApplicationDatasetInterface base,String attrName){
      if (attrName.equals("scopusCity")){
         return (List) ((Scenario)base).getListScopusCity();
      }
      return null;
   }

}
