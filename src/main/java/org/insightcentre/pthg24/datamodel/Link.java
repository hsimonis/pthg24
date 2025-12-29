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

public  class Link extends ApplicationObject{
/**
 *  
 *
*/

    public Article article;

/**
 *  
 *
*/

    public String basis;

/**
 *  
 *
*/

    public String extended;

/**
 *  
 *
*/

    public String journal;

/**
 *  
 *
*/

    public Work paper;

/**
 *  
 *
*/

    public String venue;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public Link(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public Link(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setArticle(null);
        setBasis("");
        setExtended("");
        setJournal("");
        setPaper(null);
        setVenue("");
        applicationDataset.addLink(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public Link(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            Article article,
            String basis,
            String extended,
            String journal,
            Work paper,
            String venue){
        super(applicationDataset,
            id,
            name);
        setArticle(article);
        setBasis(basis);
        setExtended(extended);
        setJournal(journal);
        setPaper(paper);
        setVenue(venue);
        applicationDataset.addLink(this);
    }

    public Link(Link other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.article,
            other.basis,
            other.extended,
            other.journal,
            other.paper,
            other.venue);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        getApplicationDataset().cascadeWorkLink(this);
        return getApplicationDataset().removeLink(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute article
 *
 * @return Article
*/

    public Article getArticle(){
        return this.article;
    }

/**
 *  get attribute basis
 *
 * @return String
*/

    public String getBasis(){
        return this.basis;
    }

/**
 *  get attribute extended
 *
 * @return String
*/

    public String getExtended(){
        return this.extended;
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
 *  get attribute paper
 *
 * @return Work
*/

    public Work getPaper(){
        return this.paper;
    }

/**
 *  get attribute venue
 *
 * @return String
*/

    public String getVenue(){
        return this.venue;
    }

/**
 *  set attribute article, mark dataset as dirty, mark dataset as not valid
@param article Article
 *
*/

    public void setArticle(Article article){
        this.article = article;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute basis, mark dataset as dirty, mark dataset as not valid
@param basis String
 *
*/

    public void setBasis(String basis){
        this.basis = basis;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute extended, mark dataset as dirty, mark dataset as not valid
@param extended String
 *
*/

    public void setExtended(String extended){
        this.extended = extended;
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
 *  set attribute paper, mark dataset as dirty, mark dataset as not valid
@param paper Work
 *
*/

    public void setPaper(Work paper){
        this.paper = paper;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute venue, mark dataset as dirty, mark dataset as not valid
@param venue String
 *
*/

    public void setVenue(String venue){
        this.venue = venue;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getArticle().toColumnString()+ " " +getBasis()+ " " +getExtended()+ " " +getJournal()+ " " +getPaper().toColumnString()+ " " +getVenue();
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
         out.println("<link "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " article=\""+toXMLArticle()+"\""+
            " basis=\""+toXMLBasis()+"\""+
            " extended=\""+toXMLExtended()+"\""+
            " journal=\""+toXMLJournal()+"\""+
            " paper=\""+toXMLPaper()+"\""+
            " venue=\""+toXMLVenue()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLArticle(){
        return "ID_"+this.getArticle().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLBasis(){
        return this.safeXML(getBasis());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLExtended(){
        return this.safeXML(getExtended());
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

    String toXMLPaper(){
        return "ID_"+this.getPaper().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLVenue(){
        return this.safeXML(getVenue());
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>Link</th>"+"<th>Name</th>"+"<th>Article</th>"+"<th>Extended</th>"+"<th>Journal</th>"+"<th>Venue</th>"+"<th>Basis</th>"+"<th>Paper</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getArticle().toColumnString()+"</td>"+ " " +"<td>"+getExtended()+"</td>"+ " " +"<td>"+getJournal()+"</td>"+ " " +"<td>"+getVenue()+"</td>"+ " " +"<td>"+getBasis()+"</td>"+ " " +"<td>"+getPaper().toColumnString()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a Link item we are looking for
 * @param bList List<Link> list of items in which we are searching
 * @return Link entry of list b which is applicationSame() to a
*/

    public static Link find(Link a, List<Link> bList){
        for(Link b : bList){
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
 * @param name Link name of the object we are looking for
 * @return Link entry of the dataset with the given name; otherwise null
*/

    public static Link findByName(ApplicationDataset base, String name){
        for(Link a:base.getListLink()) {
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
 * @param name Link name of the object we are looking for
 * @return Link entry of the dataset with the given name
*/

    public static Link findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(Link a:base.getListLink()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        Link res = new Link(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Link first entry in the dataset of this type; null if that does not exists
*/

    public static Link findFirst(ApplicationDataset base){
        if (base.getListLink().isEmpty()) {
            return null;
        }
        return base.getListLink().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Link some entry in the dataset of this type; null if that does not exists
*/

    public static Link findAny(ApplicationDataset base){
        int size=base.getListLink().size();
        if (size > 0) {
             return base.getListLink().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Link last entry in the dataset of this type; null if that does not exists
*/

    public static Link findLast(ApplicationDataset base){
        int size=base.getListLink().size();
        if (size > 0) {
             return base.getListLink().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b Link compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(Link b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b Link compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(Link b){
      if(!this.getArticle().applicationSame(b.getArticle())){
         System.out.println("Article");
        }
      if(!this.getBasis().equals(b.getBasis())){
         System.out.println("Basis");
        }
      if(!this.getExtended().equals(b.getExtended())){
         System.out.println("Extended");
        }
      if(!this.getJournal().equals(b.getJournal())){
         System.out.println("Journal");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getPaper().applicationSame(b.getPaper())){
         System.out.println("Paper");
        }
      if(!this.getVenue().equals(b.getVenue())){
         System.out.println("Venue");
        }
        return  this.getArticle().applicationSame(b.getArticle()) &&
          this.getBasis().equals(b.getBasis()) &&
          this.getExtended().equals(b.getExtended()) &&
          this.getJournal().equals(b.getJournal()) &&
          this.getName().equals(b.getName()) &&
          this.getPaper().applicationSame(b.getPaper()) &&
          this.getVenue().equals(b.getVenue());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","Link",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getArticle() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"article","Link",(getArticle()==null?"null":getArticle().toString()),"",WarningType.NOTNULL);
        }
        if (getPaper() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"paper","Link",(getPaper()==null?"null":getPaper().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class Link
    }

/**
 *  This method states if the class depends on the solver.
 *
*/

    public static Boolean isSolverDependent(){
        return false;
    }

   public List<ApplicationObjectInterface> getFeasibleValues(ApplicationDatasetInterface base,String attrName){
      if (attrName.equals("article")){
         return (List) ((Scenario)base).getListArticle();
      }
      if (attrName.equals("paper")){
         return (List) ((Scenario)base).getListWork();
      }
      return null;
   }

}
