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
import org.insightcentre.pthg24.datamodel.DifferenceType;
import org.insightcentre.pthg24.datamodel.WarningType;
import org.insightcentre.pthg24.datamodel.MatchLevel;
import org.insightcentre.pthg24.datamodel.WorkType;
import org.insightcentre.pthg24.datamodel.OpenAccessType;
import org.insightcentre.pthg24.datamodel.SubType;
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

public  class SpecialIssue extends ApplicationObject{
/**
 *  
 *
*/

    public Boolean basedOnConference;

    private transient BooleanProperty basedOnConferenceWrapper;

/**
 *  
 *
*/

    public String shortName;

/**
 *  
 *
*/

    public String topic;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public SpecialIssue(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public SpecialIssue(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setBasedOnConference(false);
        setShortName("");
        setTopic("");
        applicationDataset.addSpecialIssue(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public SpecialIssue(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            Boolean basedOnConference,
            String shortName,
            String topic){
        super(applicationDataset,
            id,
            name);
        setBasedOnConference(basedOnConference);
        setShortName(shortName);
        setTopic(topic);
        applicationDataset.addSpecialIssue(this);
    }

    public SpecialIssue(SpecialIssue other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.basedOnConference,
            other.shortName,
            other.topic);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        getApplicationDataset().cascadeArticleSpecialIssue(this);
        return getApplicationDataset().removeSpecialIssue(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute basedOnConference
 *
 * @return Boolean
*/

    public Boolean getBasedOnConference(){
        return this.basedOnConference;
    }

    public BooleanProperty basedOnConferenceWrapperProperty() {
        if (basedOnConferenceWrapper == null) {
            basedOnConferenceWrapper = new SimpleBooleanProperty();
        }
        basedOnConferenceWrapper.set(basedOnConference);
        return basedOnConferenceWrapper;
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
 *  get attribute topic
 *
 * @return String
*/

    public String getTopic(){
        return this.topic;
    }

/**
 *  set attribute basedOnConference, mark dataset as dirty, mark dataset as not valid
@param basedOnConference Boolean
 *
*/

    public void setBasedOnConference(Boolean basedOnConference){
        this.basedOnConference = basedOnConference;
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
 *  set attribute topic, mark dataset as dirty, mark dataset as not valid
@param topic String
 *
*/

    public void setTopic(String topic){
        this.topic = topic;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getBasedOnConference()+ " " +getShortName()+ " " +getTopic();
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
         out.println("<specialIssue "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " basedOnConference=\""+toXMLBasedOnConference()+"\""+
            " shortName=\""+toXMLShortName()+"\""+
            " topic=\""+toXMLTopic()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLBasedOnConference(){
        return this.getBasedOnConference().toString();
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

    String toXMLTopic(){
        return this.safeXML(getTopic());
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>SpecialIssue</th>"+"<th>Name</th>"+"<th>ShortName</th>"+"<th>Topic</th>"+"<th>BasedOnConference</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getShortName()+"</td>"+ " " +"<td>"+getTopic()+"</td>"+ " " +"<td>"+getBasedOnConference()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a SpecialIssue item we are looking for
 * @param bList List<SpecialIssue> list of items in which we are searching
 * @return SpecialIssue entry of list b which is applicationSame() to a
*/

    public static SpecialIssue find(SpecialIssue a, List<SpecialIssue> bList){
        for(SpecialIssue b : bList){
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
 * @param name SpecialIssue name of the object we are looking for
 * @return SpecialIssue entry of the dataset with the given name; otherwise null
*/

    public static SpecialIssue findByName(ApplicationDataset base, String name){
        for(SpecialIssue a:base.getListSpecialIssue()) {
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
 * @param name SpecialIssue name of the object we are looking for
 * @return SpecialIssue entry of the dataset with the given name
*/

    public static SpecialIssue findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(SpecialIssue a:base.getListSpecialIssue()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        SpecialIssue res = new SpecialIssue(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return SpecialIssue first entry in the dataset of this type; null if that does not exists
*/

    public static SpecialIssue findFirst(ApplicationDataset base){
        if (base.getListSpecialIssue().isEmpty()) {
            return null;
        }
        return base.getListSpecialIssue().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return SpecialIssue some entry in the dataset of this type; null if that does not exists
*/

    public static SpecialIssue findAny(ApplicationDataset base){
        int size=base.getListSpecialIssue().size();
        if (size > 0) {
             return base.getListSpecialIssue().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return SpecialIssue last entry in the dataset of this type; null if that does not exists
*/

    public static SpecialIssue findLast(ApplicationDataset base){
        int size=base.getListSpecialIssue().size();
        if (size > 0) {
             return base.getListSpecialIssue().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b SpecialIssue compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(SpecialIssue b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b SpecialIssue compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(SpecialIssue b){
      if(!this.getBasedOnConference().equals(b.getBasedOnConference())){
         System.out.println("BasedOnConference");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getShortName().equals(b.getShortName())){
         System.out.println("ShortName");
        }
      if(!this.getTopic().equals(b.getTopic())){
         System.out.println("Topic");
        }
        return  this.getBasedOnConference().equals(b.getBasedOnConference()) &&
          this.getName().equals(b.getName()) &&
          this.getShortName().equals(b.getShortName()) &&
          this.getTopic().equals(b.getTopic());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","SpecialIssue",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class SpecialIssue
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
