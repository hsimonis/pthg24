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
import org.insightcentre.pthg24.datamodel.Authorship;
import org.insightcentre.pthg24.datamodel.Proceedings;
import org.insightcentre.pthg24.datamodel.Journal;
import org.insightcentre.pthg24.datamodel.School;
import org.insightcentre.pthg24.datamodel.Collection;
import org.insightcentre.pthg24.datamodel.ConceptWork;
import org.insightcentre.pthg24.datamodel.DifferenceType;
import org.insightcentre.pthg24.datamodel.WarningType;
import org.insightcentre.pthg24.datamodel.MatchLevel;
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

public abstract class Work extends ApplicationObject{
/**
 *  
 *
*/

    public String author;

/**
 *  
 *
*/

    public List<Author> authors;

/**
 *  
 *
*/

    public String basedOn;

/**
 *  
 *
*/

    public String citations;

/**
 *  
 *
*/

    public String codeAvail;

/**
 *  
 *
*/

    public String constraints;

/**
 *  
 *
*/

    public String cpSystem;

/**
 *  
 *
*/

    public String dataAvail;

/**
 *  
 *
*/

    public String doi;

/**
 *  
 *
*/

    public String key;

/**
 *  
 *
*/

    public String localCopy;

/**
 *  
 *
*/

    public Integer nrPages;

/**
 *  
 *
*/

    public String pages;

/**
 *  
 *
*/

    public String solutionAvail;

/**
 *  
 *
*/

    public String title;

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

    public Work(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public Work(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setAuthor("");
        setAuthors(new ArrayList<Author>());
        setBasedOn("");
        setCitations("");
        setCodeAvail("");
        setConstraints("");
        setCpSystem("");
        setDataAvail("");
        setDoi("");
        setKey("");
        setLocalCopy("");
        setNrPages(0);
        setPages("");
        setSolutionAvail("");
        setTitle("");
        setUrl("");
        setYear(0);
        applicationDataset.addWork(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public Work(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            String author,
            List<Author> authors,
            String basedOn,
            String citations,
            String codeAvail,
            String constraints,
            String cpSystem,
            String dataAvail,
            String doi,
            String key,
            String localCopy,
            Integer nrPages,
            String pages,
            String solutionAvail,
            String title,
            String url,
            Integer year){
        super(applicationDataset,
            id,
            name);
        setAuthor(author);
        setAuthors(authors);
        setBasedOn(basedOn);
        setCitations(citations);
        setCodeAvail(codeAvail);
        setConstraints(constraints);
        setCpSystem(cpSystem);
        setDataAvail(dataAvail);
        setDoi(doi);
        setKey(key);
        setLocalCopy(localCopy);
        setNrPages(nrPages);
        setPages(pages);
        setSolutionAvail(solutionAvail);
        setTitle(title);
        setUrl(url);
        setYear(year);
        applicationDataset.addWork(this);
    }

    public Work(Work other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.author,
            other.authors,
            other.basedOn,
            other.citations,
            other.codeAvail,
            other.constraints,
            other.cpSystem,
            other.dataAvail,
            other.doi,
            other.key,
            other.localCopy,
            other.nrPages,
            other.pages,
            other.solutionAvail,
            other.title,
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
        getApplicationDataset().cascadeAuthorshipWork(this);
        getApplicationDataset().cascadeConceptWorkWork(this);
        return getApplicationDataset().removeWork(this) && getApplicationDataset().removeApplicationObject(this);
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
 *  get attribute authors
 *
 * @return List<Author>
*/

    public List<Author> getAuthors(){
        return this.authors;
    }

/**
 *  get attribute basedOn
 *
 * @return String
*/

    public String getBasedOn(){
        return this.basedOn;
    }

/**
 *  get attribute citations
 *
 * @return String
*/

    public String getCitations(){
        return this.citations;
    }

/**
 *  get attribute codeAvail
 *
 * @return String
*/

    public String getCodeAvail(){
        return this.codeAvail;
    }

/**
 *  get attribute constraints
 *
 * @return String
*/

    public String getConstraints(){
        return this.constraints;
    }

/**
 *  get attribute cpSystem
 *
 * @return String
*/

    public String getCpSystem(){
        return this.cpSystem;
    }

/**
 *  get attribute dataAvail
 *
 * @return String
*/

    public String getDataAvail(){
        return this.dataAvail;
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
 *  get attribute key
 *
 * @return String
*/

    public String getKey(){
        return this.key;
    }

/**
 *  get attribute localCopy
 *
 * @return String
*/

    public String getLocalCopy(){
        return this.localCopy;
    }

/**
 *  get attribute nrPages
 *
 * @return Integer
*/

    public Integer getNrPages(){
        return this.nrPages;
    }

/**
 *  get attribute pages
 *
 * @return String
*/

    public String getPages(){
        return this.pages;
    }

/**
 *  get attribute solutionAvail
 *
 * @return String
*/

    public String getSolutionAvail(){
        return this.solutionAvail;
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
 *  set attribute authors, mark dataset as dirty, mark dataset as not valid
@param authors List<Author>
 *
*/

    public void setAuthors(List<Author> authors){
        this.authors = authors;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute basedOn, mark dataset as dirty, mark dataset as not valid
@param basedOn String
 *
*/

    public void setBasedOn(String basedOn){
        this.basedOn = basedOn;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute citations, mark dataset as dirty, mark dataset as not valid
@param citations String
 *
*/

    public void setCitations(String citations){
        this.citations = citations;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute codeAvail, mark dataset as dirty, mark dataset as not valid
@param codeAvail String
 *
*/

    public void setCodeAvail(String codeAvail){
        this.codeAvail = codeAvail;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute constraints, mark dataset as dirty, mark dataset as not valid
@param constraints String
 *
*/

    public void setConstraints(String constraints){
        this.constraints = constraints;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute cpSystem, mark dataset as dirty, mark dataset as not valid
@param cpSystem String
 *
*/

    public void setCpSystem(String cpSystem){
        this.cpSystem = cpSystem;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute dataAvail, mark dataset as dirty, mark dataset as not valid
@param dataAvail String
 *
*/

    public void setDataAvail(String dataAvail){
        this.dataAvail = dataAvail;
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
 *  set attribute key, mark dataset as dirty, mark dataset as not valid
@param key String
 *
*/

    public void setKey(String key){
        this.key = key;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute localCopy, mark dataset as dirty, mark dataset as not valid
@param localCopy String
 *
*/

    public void setLocalCopy(String localCopy){
        this.localCopy = localCopy;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute nrPages, mark dataset as dirty, mark dataset as not valid
@param nrPages Integer
 *
*/

    public void setNrPages(Integer nrPages){
        this.nrPages = nrPages;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute pages, mark dataset as dirty, mark dataset as not valid
@param pages String
 *
*/

    public void setPages(String pages){
        this.pages = pages;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute solutionAvail, mark dataset as dirty, mark dataset as not valid
@param solutionAvail String
 *
*/

    public void setSolutionAvail(String solutionAvail){
        this.solutionAvail = solutionAvail;
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
 *  inc attribute nrPages, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrPages(){
        this.nrPages++;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getAuthor()+ " " +getAuthors()+ " " +getBasedOn()+ " " +getCitations()+ " " +getCodeAvail()+ " " +getConstraints()+ " " +getCpSystem()+ " " +getDataAvail()+ " " +getDoi()+ " " +getKey()+ " " +getLocalCopy()+ " " +getNrPages()+ " " +getPages()+ " " +getSolutionAvail()+ " " +getTitle()+ " " +getUrl()+ " " +getYear();
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
         out.println("<work "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " author=\""+toXMLAuthor()+"\""+
            " authors=\""+toXMLAuthors()+"\""+
            " basedOn=\""+toXMLBasedOn()+"\""+
            " citations=\""+toXMLCitations()+"\""+
            " codeAvail=\""+toXMLCodeAvail()+"\""+
            " constraints=\""+toXMLConstraints()+"\""+
            " cpSystem=\""+toXMLCpSystem()+"\""+
            " dataAvail=\""+toXMLDataAvail()+"\""+
            " doi=\""+toXMLDoi()+"\""+
            " key=\""+toXMLKey()+"\""+
            " localCopy=\""+toXMLLocalCopy()+"\""+
            " nrPages=\""+toXMLNrPages()+"\""+
            " pages=\""+toXMLPages()+"\""+
            " solutionAvail=\""+toXMLSolutionAvail()+"\""+
            " title=\""+toXMLTitle()+"\""+
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

    String toXMLAuthors(){
        String str="";
        for(Author x:getAuthors()){
            str=str+" "+"ID_"+x.getId();
        }
        return str;
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLBasedOn(){
        return this.safeXML(getBasedOn());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCitations(){
        return this.safeXML(getCitations());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCodeAvail(){
        return this.safeXML(getCodeAvail());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLConstraints(){
        return this.safeXML(getConstraints());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCpSystem(){
        return this.safeXML(getCpSystem());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLDataAvail(){
        return this.safeXML(getDataAvail());
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

    String toXMLKey(){
        return this.safeXML(getKey());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLLocalCopy(){
        return this.safeXML(getLocalCopy());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLNrPages(){
        return this.getNrPages().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLPages(){
        return this.safeXML(getPages());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLSolutionAvail(){
        return this.safeXML(getSolutionAvail());
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
 * find the same object in another dataset
 * @param a Work item we are looking for
 * @param bList List<Work> list of items in which we are searching
 * @return Work entry of list b which is applicationSame() to a
*/

    public static Work find(Work a, List<Work> bList){
        for(Work b : bList){
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
 * @param name Work name of the object we are looking for
 * @return Work entry of the dataset with the given name; otherwise null
*/

    public static Work findByName(ApplicationDataset base, String name){
        for(Work a:base.getListWork()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        return null;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Work first entry in the dataset of this type; null if that does not exists
*/

    public static Work findFirst(ApplicationDataset base){
        if (base.getListWork().isEmpty()) {
            return null;
        }
        return base.getListWork().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Work some entry in the dataset of this type; null if that does not exists
*/

    public static Work findAny(ApplicationDataset base){
        int size=base.getListWork().size();
        if (size > 0) {
             return base.getListWork().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Work last entry in the dataset of this type; null if that does not exists
*/

    public static Work findLast(ApplicationDataset base){
        int size=base.getListWork().size();
        if (size > 0) {
             return base.getListWork().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b Work compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(Work b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b Work compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(Work b){
      if(!this.getAuthor().equals(b.getAuthor())){
         System.out.println("Author");
        }
      if (true) {         System.out.println("Authors");
        }
      if(!this.getBasedOn().equals(b.getBasedOn())){
         System.out.println("BasedOn");
        }
      if(!this.getCitations().equals(b.getCitations())){
         System.out.println("Citations");
        }
      if(!this.getCodeAvail().equals(b.getCodeAvail())){
         System.out.println("CodeAvail");
        }
      if(!this.getConstraints().equals(b.getConstraints())){
         System.out.println("Constraints");
        }
      if(!this.getCpSystem().equals(b.getCpSystem())){
         System.out.println("CpSystem");
        }
      if(!this.getDataAvail().equals(b.getDataAvail())){
         System.out.println("DataAvail");
        }
      if(!this.getDoi().equals(b.getDoi())){
         System.out.println("Doi");
        }
      if(!this.getKey().equals(b.getKey())){
         System.out.println("Key");
        }
      if(!this.getLocalCopy().equals(b.getLocalCopy())){
         System.out.println("LocalCopy");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getNrPages().equals(b.getNrPages())){
         System.out.println("NrPages");
        }
      if(!this.getPages().equals(b.getPages())){
         System.out.println("Pages");
        }
      if(!this.getSolutionAvail().equals(b.getSolutionAvail())){
         System.out.println("SolutionAvail");
        }
      if(!this.getTitle().equals(b.getTitle())){
         System.out.println("Title");
        }
      if(!this.getUrl().equals(b.getUrl())){
         System.out.println("Url");
        }
      if(!this.getYear().equals(b.getYear())){
         System.out.println("Year");
        }
        return  this.getAuthor().equals(b.getAuthor()) &&
          true &&
          this.getBasedOn().equals(b.getBasedOn()) &&
          this.getCitations().equals(b.getCitations()) &&
          this.getCodeAvail().equals(b.getCodeAvail()) &&
          this.getConstraints().equals(b.getConstraints()) &&
          this.getCpSystem().equals(b.getCpSystem()) &&
          this.getDataAvail().equals(b.getDataAvail()) &&
          this.getDoi().equals(b.getDoi()) &&
          this.getKey().equals(b.getKey()) &&
          this.getLocalCopy().equals(b.getLocalCopy()) &&
          this.getName().equals(b.getName()) &&
          this.getNrPages().equals(b.getNrPages()) &&
          this.getPages().equals(b.getPages()) &&
          this.getSolutionAvail().equals(b.getSolutionAvail()) &&
          this.getTitle().equals(b.getTitle()) &&
          this.getUrl().equals(b.getUrl()) &&
          this.getYear().equals(b.getYear());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","Work",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getAuthors() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"authors","Work",(getAuthors()==null?"null":getAuthors().toString()),"",WarningType.NOTNULL);
        }
        if (getAuthors().size() == 0){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"authors","Work",(getAuthors()==null?"null":getAuthors().toString()),"",WarningType.NOTEMPTY);
        }
    }

/**
 *  This method states if the class depends on the solver.
 *
*/

    public static Boolean isSolverDependent(){
        return false;
    }

   public List<ApplicationObjectInterface> getFeasibleValues(ApplicationDatasetInterface base,String attrName){
      if (attrName.equals("authors")){
         return (List) ((Scenario)base).getListAuthor();
      }
      return null;
   }

}
