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
import org.insightcentre.pthg24.datamodel.SpecialIssue;
import org.insightcentre.pthg24.datamodel.Link;
import org.insightcentre.pthg24.datamodel.Node;
import org.insightcentre.pthg24.datamodel.Edge;
import org.insightcentre.pthg24.datamodel.ConnectedComponent;
import org.insightcentre.pthg24.datamodel.Award;
import org.insightcentre.pthg24.datamodel.Track;
import org.insightcentre.pthg24.datamodel.LinkCandidate;
import org.insightcentre.pthg24.datamodel.DifferenceType;
import org.insightcentre.pthg24.datamodel.WarningType;
import org.insightcentre.pthg24.datamodel.MatchLevel;
import org.insightcentre.pthg24.datamodel.WorkType;
import org.insightcentre.pthg24.datamodel.OpenAccessType;
import org.insightcentre.pthg24.datamodel.SubType;
import org.insightcentre.pthg24.datamodel.AwardLevel;
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

public  class Award extends ApplicationObject implements AppearInCollection{
/**
 *  
 *
*/

    public AwardLevel awardLevel;

/**
 *  
 *
*/

    public String shortName;

/**
 *  
 *
*/

    public String type;

/**
 *  
 *
*/

    public Integer year;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public Award(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public Award(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setAwardLevel(null);
        setShortName("");
        setType("");
        setYear(0);
        applicationDataset.addAward(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public Award(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            AwardLevel awardLevel,
            String shortName,
            String type,
            Integer year){
        super(applicationDataset,
            id,
            name);
        setAwardLevel(awardLevel);
        setShortName(shortName);
        setType(type);
        setYear(year);
        applicationDataset.addAward(this);
    }

    public Award(Award other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.awardLevel,
            other.shortName,
            other.type,
            other.year);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        getApplicationDataset().cascadeWorkAwards(this);
        return getApplicationDataset().removeAward(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  (varargs) build list of items of type Award
 *
 * @param pList multiple items of type Award
 * @return List<Award>
*/

    static public List<Award> buildList(Award... pList){
        List<Award> l = new ArrayList<Award>();
        l.addAll(Arrays.asList(pList));
        return l;
    }

/**
 *  get attribute awardLevel
 *
 * @return AwardLevel
*/

    public AwardLevel getAwardLevel(){
        return this.awardLevel;
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
 *  get attribute type
 *
 * @return String
*/

    public String getType(){
        return this.type;
    }

/**
 *  get attribute year
 *
 * @return Integer
*/

    public Integer getYear(){
        return this.year;
    }

/**
 *  set attribute awardLevel, mark dataset as dirty, mark dataset as not valid
@param awardLevel AwardLevel
 *
*/

    public void setAwardLevel(AwardLevel awardLevel){
        this.awardLevel = awardLevel;
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
 *  set attribute type, mark dataset as dirty, mark dataset as not valid
@param type String
 *
*/

    public void setType(String type){
        this.type = type;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute year, mark dataset as dirty, mark dataset as not valid
@param year Integer
 *
*/

    public void setYear(Integer year){
        this.year = year;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute year, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incYear(){
        this.year++;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getAwardLevel()+ " " +getShortName()+ " " +getType()+ " " +getYear();
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
         out.println("<award "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " awardLevel=\""+toXMLAwardLevel()+"\""+
            " shortName=\""+toXMLShortName()+"\""+
            " type=\""+toXMLType()+"\""+
            " year=\""+toXMLYear()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLAwardLevel(){
        return this.getAwardLevel().toString();
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

    String toXMLType(){
        return this.safeXML(getType());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLYear(){
        return this.getYear().toString();
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>Award</th>"+"<th>Name</th>"+"<th>ShortName</th>"+"<th>Year</th>"+"<th>AwardLevel</th>"+"<th>Type</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getShortName()+"</td>"+ " " +"<td>"+getYear()+"</td>"+ " " +"<td>"+getAwardLevel()+"</td>"+ " " +"<td>"+getType()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a Award item we are looking for
 * @param bList List<Award> list of items in which we are searching
 * @return Award entry of list b which is applicationSame() to a
*/

    public static Award find(Award a, List<Award> bList){
        for(Award b : bList){
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
 * @param name Award name of the object we are looking for
 * @return Award entry of the dataset with the given name; otherwise null
*/

    public static Award findByName(ApplicationDataset base, String name){
        for(Award a:base.getListAward()) {
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
 * @param name Award name of the object we are looking for
 * @return Award entry of the dataset with the given name
*/

    public static Award findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(Award a:base.getListAward()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        Award res = new Award(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Award first entry in the dataset of this type; null if that does not exists
*/

    public static Award findFirst(ApplicationDataset base){
        if (base.getListAward().isEmpty()) {
            return null;
        }
        return base.getListAward().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Award some entry in the dataset of this type; null if that does not exists
*/

    public static Award findAny(ApplicationDataset base){
        int size=base.getListAward().size();
        if (size > 0) {
             return base.getListAward().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Award last entry in the dataset of this type; null if that does not exists
*/

    public static Award findLast(ApplicationDataset base){
        int size=base.getListAward().size();
        if (size > 0) {
             return base.getListAward().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b Award compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(Award b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b Award compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(Award b){
      if(!this.getAwardLevel().equals(b.getAwardLevel())){
         System.out.println("AwardLevel");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getShortName().equals(b.getShortName())){
         System.out.println("ShortName");
        }
      if(!this.getType().equals(b.getType())){
         System.out.println("Type");
        }
      if(!this.getYear().equals(b.getYear())){
         System.out.println("Year");
        }
        return  this.getAwardLevel().equals(b.getAwardLevel()) &&
          this.getName().equals(b.getName()) &&
          this.getShortName().equals(b.getShortName()) &&
          this.getType().equals(b.getType()) &&
          this.getYear().equals(b.getYear());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","Award",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class Award
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
