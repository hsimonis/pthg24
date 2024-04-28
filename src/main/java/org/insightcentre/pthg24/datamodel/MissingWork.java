// licence details to be added
package org.insightcentre.pthg24.datamodel;
import org.insightcentre.pthg24.datamodel.ApplicationDataset;
import org.insightcentre.pthg24.datamodel.ApplicationObject;
import org.insightcentre.pthg24.datamodel.ApplicationDifference;
import org.insightcentre.pthg24.datamodel.ApplicationWarning;
import org.insightcentre.pthg24.datamodel.Scenario;
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
import org.insightcentre.pthg24.datamodel.DifferenceType;
import org.insightcentre.pthg24.datamodel.WarningType;
import org.insightcentre.pthg24.datamodel.MatchLevel;
import org.insightcentre.pthg24.datamodel.WorkType;
import org.insightcentre.pthg24.datamodel.ConceptType;
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

public  class MissingWork extends ApplicationObject{
/**
 *  
 *
*/

    public String author;

/**
 *  
 *
*/

    public Integer crossrefCitations;

/**
 *  
 *
*/

    public Integer crossrefReferences;

/**
 *  
 *
*/

    public String doi;

/**
 *  
 *
*/

    public String encoded;

/**
 *  
 *
*/

    public Integer nrCitations;

/**
 *  
 *
*/

    public Integer nrCited;

/**
 *  
 *
*/

    public Integer nrLinks;

/**
 *  
 *
*/

    public String title;

/**
 *  
 *
*/

    public String type;

/**
 *  
 *
*/

    public String url;

/**
 *  
 *
*/

    public Integer year;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public MissingWork(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public MissingWork(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setAuthor("");
        setCrossrefCitations(0);
        setCrossrefReferences(0);
        setDoi("");
        setEncoded("");
        setNrCitations(0);
        setNrCited(0);
        setNrLinks(0);
        setTitle("");
        setType("");
        setUrl("");
        setYear(0);
        applicationDataset.addMissingWork(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public MissingWork(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            String author,
            Integer crossrefCitations,
            Integer crossrefReferences,
            String doi,
            String encoded,
            Integer nrCitations,
            Integer nrCited,
            Integer nrLinks,
            String title,
            String type,
            String url,
            Integer year){
        super(applicationDataset,
            id,
            name);
        setAuthor(author);
        setCrossrefCitations(crossrefCitations);
        setCrossrefReferences(crossrefReferences);
        setDoi(doi);
        setEncoded(encoded);
        setNrCitations(nrCitations);
        setNrCited(nrCited);
        setNrLinks(nrLinks);
        setTitle(title);
        setType(type);
        setUrl(url);
        setYear(year);
        applicationDataset.addMissingWork(this);
    }

    public MissingWork(MissingWork other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.author,
            other.crossrefCitations,
            other.crossrefReferences,
            other.doi,
            other.encoded,
            other.nrCitations,
            other.nrCited,
            other.nrLinks,
            other.title,
            other.type,
            other.url,
            other.year);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        getApplicationDataset().cascadeCrossReferenceMissingWork(this);
        return getApplicationDataset().removeMissingWork(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute author
 *
 * @return String
*/

    public String getAuthor(){
        return this.author;
    }

/**
 *  get attribute crossrefCitations
 *
 * @return Integer
*/

    public Integer getCrossrefCitations(){
        return this.crossrefCitations;
    }

/**
 *  get attribute crossrefReferences
 *
 * @return Integer
*/

    public Integer getCrossrefReferences(){
        return this.crossrefReferences;
    }

/**
 *  get attribute doi
 *
 * @return String
*/

    public String getDoi(){
        return this.doi;
    }

/**
 *  get attribute encoded
 *
 * @return String
*/

    public String getEncoded(){
        return this.encoded;
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
 *  get attribute nrCited
 *
 * @return Integer
*/

    public Integer getNrCited(){
        return this.nrCited;
    }

/**
 *  get attribute nrLinks
 *
 * @return Integer
*/

    public Integer getNrLinks(){
        return this.nrLinks;
    }

/**
 *  get attribute title
 *
 * @return String
*/

    public String getTitle(){
        return this.title;
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
 *  get attribute url
 *
 * @return String
*/

    public String getUrl(){
        return this.url;
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
 *  set attribute author, mark dataset as dirty, mark dataset as not valid
@param author String
 *
*/

    public void setAuthor(String author){
        this.author = author;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute crossrefCitations, mark dataset as dirty, mark dataset as not valid
@param crossrefCitations Integer
 *
*/

    public void setCrossrefCitations(Integer crossrefCitations){
        this.crossrefCitations = crossrefCitations;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute crossrefReferences, mark dataset as dirty, mark dataset as not valid
@param crossrefReferences Integer
 *
*/

    public void setCrossrefReferences(Integer crossrefReferences){
        this.crossrefReferences = crossrefReferences;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute doi, mark dataset as dirty, mark dataset as not valid
@param doi String
 *
*/

    public void setDoi(String doi){
        this.doi = doi;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute encoded, mark dataset as dirty, mark dataset as not valid
@param encoded String
 *
*/

    public void setEncoded(String encoded){
        this.encoded = encoded;
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
 *  set attribute nrCited, mark dataset as dirty, mark dataset as not valid
@param nrCited Integer
 *
*/

    public void setNrCited(Integer nrCited){
        this.nrCited = nrCited;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute nrLinks, mark dataset as dirty, mark dataset as not valid
@param nrLinks Integer
 *
*/

    public void setNrLinks(Integer nrLinks){
        this.nrLinks = nrLinks;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute title, mark dataset as dirty, mark dataset as not valid
@param title String
 *
*/

    public void setTitle(String title){
        this.title = title;
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
 *  set attribute url, mark dataset as dirty, mark dataset as not valid
@param url String
 *
*/

    public void setUrl(String url){
        this.url = url;
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
 *  inc attribute crossrefCitations, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incCrossrefCitations(){
        this.crossrefCitations++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute crossrefReferences, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incCrossrefReferences(){
        this.crossrefReferences++;
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
 *  inc attribute nrCited, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrCited(){
        this.nrCited++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute nrLinks, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrLinks(){
        this.nrLinks++;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getAuthor()+ " " +getCrossrefCitations()+ " " +getCrossrefReferences()+ " " +getDoi()+ " " +getEncoded()+ " " +getNrCitations()+ " " +getNrCited()+ " " +getNrLinks()+ " " +getTitle()+ " " +getType()+ " " +getUrl()+ " " +getYear();
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
         out.println("<missingWork "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " author=\""+toXMLAuthor()+"\""+
            " crossrefCitations=\""+toXMLCrossrefCitations()+"\""+
            " crossrefReferences=\""+toXMLCrossrefReferences()+"\""+
            " doi=\""+toXMLDoi()+"\""+
            " encoded=\""+toXMLEncoded()+"\""+
            " nrCitations=\""+toXMLNrCitations()+"\""+
            " nrCited=\""+toXMLNrCited()+"\""+
            " nrLinks=\""+toXMLNrLinks()+"\""+
            " title=\""+toXMLTitle()+"\""+
            " type=\""+toXMLType()+"\""+
            " url=\""+toXMLUrl()+"\""+
            " year=\""+toXMLYear()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLAuthor(){
        return this.safeXML(getAuthor());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCrossrefCitations(){
        return this.getCrossrefCitations().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCrossrefReferences(){
        return this.getCrossrefReferences().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLDoi(){
        return this.safeXML(getDoi());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLEncoded(){
        return this.safeXML(getEncoded());
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

    String toXMLNrCited(){
        return this.getNrCited().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLNrLinks(){
        return this.getNrLinks().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLTitle(){
        return this.safeXML(getTitle());
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

    String toXMLUrl(){
        return this.safeXML(getUrl());
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
        return "<tr><th>MissingWork</th>"+"<th>Name</th>"+"<th>Doi</th>"+"<th>Encoded</th>"+"<th>NrCited</th>"+"<th>NrCitations</th>"+"<th>NrLinks</th>"+"<th>Year</th>"+"<th>Author</th>"+"<th>Title</th>"+"<th>Url</th>"+"<th>Type</th>"+"<th>CrossrefReferences</th>"+"<th>CrossrefCitations</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getDoi()+"</td>"+ " " +"<td>"+getEncoded()+"</td>"+ " " +"<td>"+getNrCited()+"</td>"+ " " +"<td>"+getNrCitations()+"</td>"+ " " +"<td>"+getNrLinks()+"</td>"+ " " +"<td>"+getYear()+"</td>"+ " " +"<td>"+getAuthor()+"</td>"+ " " +"<td>"+getTitle()+"</td>"+ " " +"<td>"+getUrl()+"</td>"+ " " +"<td>"+getType()+"</td>"+ " " +"<td>"+getCrossrefReferences()+"</td>"+ " " +"<td>"+getCrossrefCitations()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a MissingWork item we are looking for
 * @param bList List<MissingWork> list of items in which we are searching
 * @return MissingWork entry of list b which is applicationSame() to a
*/

    public static MissingWork find(MissingWork a, List<MissingWork> bList){
        for(MissingWork b : bList){
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
 * @param name MissingWork name of the object we are looking for
 * @return MissingWork entry of the dataset with the given name; otherwise null
*/

    public static MissingWork findByName(ApplicationDataset base, String name){
        for(MissingWork a:base.getListMissingWork()) {
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
 * @param name MissingWork name of the object we are looking for
 * @return MissingWork entry of the dataset with the given name
*/

    public static MissingWork findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(MissingWork a:base.getListMissingWork()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        MissingWork res = new MissingWork(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return MissingWork first entry in the dataset of this type; null if that does not exists
*/

    public static MissingWork findFirst(ApplicationDataset base){
        if (base.getListMissingWork().isEmpty()) {
            return null;
        }
        return base.getListMissingWork().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return MissingWork some entry in the dataset of this type; null if that does not exists
*/

    public static MissingWork findAny(ApplicationDataset base){
        int size=base.getListMissingWork().size();
        if (size > 0) {
             return base.getListMissingWork().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return MissingWork last entry in the dataset of this type; null if that does not exists
*/

    public static MissingWork findLast(ApplicationDataset base){
        int size=base.getListMissingWork().size();
        if (size > 0) {
             return base.getListMissingWork().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b MissingWork compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(MissingWork b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b MissingWork compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(MissingWork b){
      if(!this.getAuthor().equals(b.getAuthor())){
         System.out.println("Author");
        }
      if(!this.getCrossrefCitations().equals(b.getCrossrefCitations())){
         System.out.println("CrossrefCitations");
        }
      if(!this.getCrossrefReferences().equals(b.getCrossrefReferences())){
         System.out.println("CrossrefReferences");
        }
      if(!this.getDoi().equals(b.getDoi())){
         System.out.println("Doi");
        }
      if(!this.getEncoded().equals(b.getEncoded())){
         System.out.println("Encoded");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getNrCitations().equals(b.getNrCitations())){
         System.out.println("NrCitations");
        }
      if(!this.getNrCited().equals(b.getNrCited())){
         System.out.println("NrCited");
        }
      if(!this.getNrLinks().equals(b.getNrLinks())){
         System.out.println("NrLinks");
        }
      if(!this.getTitle().equals(b.getTitle())){
         System.out.println("Title");
        }
      if(!this.getType().equals(b.getType())){
         System.out.println("Type");
        }
      if(!this.getUrl().equals(b.getUrl())){
         System.out.println("Url");
        }
      if(!this.getYear().equals(b.getYear())){
         System.out.println("Year");
        }
        return  this.getAuthor().equals(b.getAuthor()) &&
          this.getCrossrefCitations().equals(b.getCrossrefCitations()) &&
          this.getCrossrefReferences().equals(b.getCrossrefReferences()) &&
          this.getDoi().equals(b.getDoi()) &&
          this.getEncoded().equals(b.getEncoded()) &&
          this.getName().equals(b.getName()) &&
          this.getNrCitations().equals(b.getNrCitations()) &&
          this.getNrCited().equals(b.getNrCited()) &&
          this.getNrLinks().equals(b.getNrLinks()) &&
          this.getTitle().equals(b.getTitle()) &&
          this.getType().equals(b.getType()) &&
          this.getUrl().equals(b.getUrl()) &&
          this.getYear().equals(b.getYear());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","MissingWork",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class MissingWork
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
