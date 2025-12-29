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

public  class LinkCandidate extends ApplicationObject{
/**
 *  
 *
*/

    public Double authorMatch;

/**
 *  
 *
*/

    public Citation citation;

/**
 *  
 *
*/

    public String journal;

/**
 *  
 *
*/

    public String link;

/**
 *  
 *
*/

    public MissingWork missingWork;

/**
 *  
 *
*/

    public String mwAuthor;

/**
 *  
 *
*/

    public String mwTitle;

/**
 *  
 *
*/

    public Double titleMatch;

/**
 *  
 *
*/

    public String wAuthor;

/**
 *  
 *
*/

    public String wTitle;

/**
 *  
 *
*/

    public Work work;

/**
 *  
 *
*/

    public Integer year;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public LinkCandidate(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public LinkCandidate(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setAuthorMatch(0.0);
        setCitation(null);
        setJournal("");
        setLink("");
        setMissingWork(null);
        setMwAuthor("");
        setMwTitle("");
        setTitleMatch(0.0);
        setWAuthor("");
        setWTitle("");
        setWork(null);
        setYear(0);
        applicationDataset.addLinkCandidate(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public LinkCandidate(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            Double authorMatch,
            Citation citation,
            String journal,
            String link,
            MissingWork missingWork,
            String mwAuthor,
            String mwTitle,
            Double titleMatch,
            String wAuthor,
            String wTitle,
            Work work,
            Integer year){
        super(applicationDataset,
            id,
            name);
        setAuthorMatch(authorMatch);
        setCitation(citation);
        setJournal(journal);
        setLink(link);
        setMissingWork(missingWork);
        setMwAuthor(mwAuthor);
        setMwTitle(mwTitle);
        setTitleMatch(titleMatch);
        setWAuthor(wAuthor);
        setWTitle(wTitle);
        setWork(work);
        setYear(year);
        applicationDataset.addLinkCandidate(this);
    }

    public LinkCandidate(LinkCandidate other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.authorMatch,
            other.citation,
            other.journal,
            other.link,
            other.missingWork,
            other.mwAuthor,
            other.mwTitle,
            other.titleMatch,
            other.wAuthor,
            other.wTitle,
            other.work,
            other.year);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        return getApplicationDataset().removeLinkCandidate(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute authorMatch
 *
 * @return Double
*/

    public Double getAuthorMatch(){
        return this.authorMatch;
    }

/**
 *  get attribute citation
 *
 * @return Citation
*/

    public Citation getCitation(){
        return this.citation;
    }

/**
 *  get attribute journal
 *
 * @return String
*/

    public String getJournal(){
        return this.journal;
    }

/**
 *  get attribute link
 *
 * @return String
*/

    public String getLink(){
        return this.link;
    }

/**
 *  get attribute missingWork
 *
 * @return MissingWork
*/

    public MissingWork getMissingWork(){
        return this.missingWork;
    }

/**
 *  get attribute mwAuthor
 *
 * @return String
*/

    public String getMwAuthor(){
        return this.mwAuthor;
    }

/**
 *  get attribute mwTitle
 *
 * @return String
*/

    public String getMwTitle(){
        return this.mwTitle;
    }

/**
 *  get attribute titleMatch
 *
 * @return Double
*/

    public Double getTitleMatch(){
        return this.titleMatch;
    }

/**
 *  get attribute wAuthor
 *
 * @return String
*/

    public String getWAuthor(){
        return this.wAuthor;
    }

/**
 *  get attribute wTitle
 *
 * @return String
*/

    public String getWTitle(){
        return this.wTitle;
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
 *  get attribute year
 *
 * @return Integer
*/

    public Integer getYear(){
        return this.year;
    }

/**
 *  set attribute authorMatch, mark dataset as dirty, mark dataset as not valid
@param authorMatch Double
 *
*/

    public void setAuthorMatch(Double authorMatch){
        this.authorMatch = authorMatch;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute citation, mark dataset as dirty, mark dataset as not valid
@param citation Citation
 *
*/

    public void setCitation(Citation citation){
        this.citation = citation;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute journal, mark dataset as dirty, mark dataset as not valid
@param journal String
 *
*/

    public void setJournal(String journal){
        this.journal = journal;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute link, mark dataset as dirty, mark dataset as not valid
@param link String
 *
*/

    public void setLink(String link){
        this.link = link;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute missingWork, mark dataset as dirty, mark dataset as not valid
@param missingWork MissingWork
 *
*/

    public void setMissingWork(MissingWork missingWork){
        this.missingWork = missingWork;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute mwAuthor, mark dataset as dirty, mark dataset as not valid
@param mwAuthor String
 *
*/

    public void setMwAuthor(String mwAuthor){
        this.mwAuthor = mwAuthor;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute mwTitle, mark dataset as dirty, mark dataset as not valid
@param mwTitle String
 *
*/

    public void setMwTitle(String mwTitle){
        this.mwTitle = mwTitle;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute titleMatch, mark dataset as dirty, mark dataset as not valid
@param titleMatch Double
 *
*/

    public void setTitleMatch(Double titleMatch){
        this.titleMatch = titleMatch;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute wAuthor, mark dataset as dirty, mark dataset as not valid
@param wAuthor String
 *
*/

    public void setWAuthor(String wAuthor){
        this.wAuthor = wAuthor;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute wTitle, mark dataset as dirty, mark dataset as not valid
@param wTitle String
 *
*/

    public void setWTitle(String wTitle){
        this.wTitle = wTitle;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getAuthorMatch()+ " " +getCitation().toColumnString()+ " " +getJournal()+ " " +getLink()+ " " +getMissingWork().toColumnString()+ " " +getMwAuthor()+ " " +getMwTitle()+ " " +getTitleMatch()+ " " +getWAuthor()+ " " +getWTitle()+ " " +getWork().toColumnString()+ " " +getYear();
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
         out.println("<linkCandidate "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " authorMatch=\""+toXMLAuthorMatch()+"\""+
            " citation=\""+toXMLCitation()+"\""+
            " journal=\""+toXMLJournal()+"\""+
            " link=\""+toXMLLink()+"\""+
            " missingWork=\""+toXMLMissingWork()+"\""+
            " mwAuthor=\""+toXMLMwAuthor()+"\""+
            " mwTitle=\""+toXMLMwTitle()+"\""+
            " titleMatch=\""+toXMLTitleMatch()+"\""+
            " wAuthor=\""+toXMLWAuthor()+"\""+
            " wTitle=\""+toXMLWTitle()+"\""+
            " work=\""+toXMLWork()+"\""+
            " year=\""+toXMLYear()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLAuthorMatch(){
        return this.getAuthorMatch().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCitation(){
        return "ID_"+this.getCitation().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLJournal(){
        return this.safeXML(getJournal());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLLink(){
        return this.safeXML(getLink());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLMissingWork(){
        return "ID_"+this.getMissingWork().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLMwAuthor(){
        return this.safeXML(getMwAuthor());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLMwTitle(){
        return this.safeXML(getMwTitle());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLTitleMatch(){
        return this.getTitleMatch().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLWAuthor(){
        return this.safeXML(getWAuthor());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLWTitle(){
        return this.safeXML(getWTitle());
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
        return "<tr><th>LinkCandidate</th>"+"<th>Name</th>"+"<th>Work</th>"+"<th>MissingWork</th>"+"<th>Citation</th>"+"<th>AuthorMatch</th>"+"<th>TitleMatch</th>"+"<th>Link</th>"+"<th>Journal</th>"+"<th>Year</th>"+"<th>WAuthor</th>"+"<th>MwAuthor</th>"+"<th>WTitle</th>"+"<th>MwTitle</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getWork().toColumnString()+"</td>"+ " " +"<td>"+getMissingWork().toColumnString()+"</td>"+ " " +"<td>"+getCitation().toColumnString()+"</td>"+ " " +"<td>"+getAuthorMatch()+"</td>"+ " " +"<td>"+getTitleMatch()+"</td>"+ " " +"<td>"+getLink()+"</td>"+ " " +"<td>"+getJournal()+"</td>"+ " " +"<td>"+getYear()+"</td>"+ " " +"<td>"+getWAuthor()+"</td>"+ " " +"<td>"+getMwAuthor()+"</td>"+ " " +"<td>"+getWTitle()+"</td>"+ " " +"<td>"+getMwTitle()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a LinkCandidate item we are looking for
 * @param bList List<LinkCandidate> list of items in which we are searching
 * @return LinkCandidate entry of list b which is applicationSame() to a
*/

    public static LinkCandidate find(LinkCandidate a, List<LinkCandidate> bList){
        for(LinkCandidate b : bList){
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
 * @param name LinkCandidate name of the object we are looking for
 * @return LinkCandidate entry of the dataset with the given name; otherwise null
*/

    public static LinkCandidate findByName(ApplicationDataset base, String name){
        for(LinkCandidate a:base.getListLinkCandidate()) {
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
 * @param name LinkCandidate name of the object we are looking for
 * @return LinkCandidate entry of the dataset with the given name
*/

    public static LinkCandidate findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(LinkCandidate a:base.getListLinkCandidate()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        LinkCandidate res = new LinkCandidate(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return LinkCandidate first entry in the dataset of this type; null if that does not exists
*/

    public static LinkCandidate findFirst(ApplicationDataset base){
        if (base.getListLinkCandidate().isEmpty()) {
            return null;
        }
        return base.getListLinkCandidate().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return LinkCandidate some entry in the dataset of this type; null if that does not exists
*/

    public static LinkCandidate findAny(ApplicationDataset base){
        int size=base.getListLinkCandidate().size();
        if (size > 0) {
             return base.getListLinkCandidate().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return LinkCandidate last entry in the dataset of this type; null if that does not exists
*/

    public static LinkCandidate findLast(ApplicationDataset base){
        int size=base.getListLinkCandidate().size();
        if (size > 0) {
             return base.getListLinkCandidate().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b LinkCandidate compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(LinkCandidate b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b LinkCandidate compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(LinkCandidate b){
      if(!this.getAuthorMatch().equals(b.getAuthorMatch())){
         System.out.println("AuthorMatch");
        }
      if(!this.getCitation().applicationSame(b.getCitation())){
         System.out.println("Citation");
        }
      if(!this.getJournal().equals(b.getJournal())){
         System.out.println("Journal");
        }
      if(!this.getLink().equals(b.getLink())){
         System.out.println("Link");
        }
      if(!this.getMissingWork().applicationSame(b.getMissingWork())){
         System.out.println("MissingWork");
        }
      if(!this.getMwAuthor().equals(b.getMwAuthor())){
         System.out.println("MwAuthor");
        }
      if(!this.getMwTitle().equals(b.getMwTitle())){
         System.out.println("MwTitle");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getTitleMatch().equals(b.getTitleMatch())){
         System.out.println("TitleMatch");
        }
      if(!this.getWAuthor().equals(b.getWAuthor())){
         System.out.println("WAuthor");
        }
      if(!this.getWTitle().equals(b.getWTitle())){
         System.out.println("WTitle");
        }
      if(!this.getWork().applicationSame(b.getWork())){
         System.out.println("Work");
        }
      if(!this.getYear().equals(b.getYear())){
         System.out.println("Year");
        }
        return  this.getAuthorMatch().equals(b.getAuthorMatch()) &&
          this.getCitation().applicationSame(b.getCitation()) &&
          this.getJournal().equals(b.getJournal()) &&
          this.getLink().equals(b.getLink()) &&
          this.getMissingWork().applicationSame(b.getMissingWork()) &&
          this.getMwAuthor().equals(b.getMwAuthor()) &&
          this.getMwTitle().equals(b.getMwTitle()) &&
          this.getName().equals(b.getName()) &&
          this.getTitleMatch().equals(b.getTitleMatch()) &&
          this.getWAuthor().equals(b.getWAuthor()) &&
          this.getWTitle().equals(b.getWTitle()) &&
          this.getWork().applicationSame(b.getWork()) &&
          this.getYear().equals(b.getYear());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","LinkCandidate",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getCitation() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"citation","LinkCandidate",(getCitation()==null?"null":getCitation().toString()),"",WarningType.NOTNULL);
        }
        if (getMissingWork() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"missingWork","LinkCandidate",(getMissingWork()==null?"null":getMissingWork().toString()),"",WarningType.NOTNULL);
        }
        if (getWork() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"work","LinkCandidate",(getWork()==null?"null":getWork().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class LinkCandidate
    }

/**
 *  This method states if the class depends on the solver.
 *
*/

    public static Boolean isSolverDependent(){
        return false;
    }

   public List<ApplicationObjectInterface> getFeasibleValues(ApplicationDatasetInterface base,String attrName){
      if (attrName.equals("citation")){
         return (List) ((Scenario)base).getListCitation();
      }
      if (attrName.equals("missingWork")){
         return (List) ((Scenario)base).getListMissingWork();
      }
      if (attrName.equals("work")){
         return (List) ((Scenario)base).getListWork();
      }
      return null;
   }

}
