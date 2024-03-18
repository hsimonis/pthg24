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
import org.insightcentre.pthg24.datamodel.Proceedings;
import org.insightcentre.pthg24.datamodel.Journal;
import org.insightcentre.pthg24.datamodel.School;
import org.insightcentre.pthg24.datamodel.Collection;
import org.insightcentre.pthg24.datamodel.ConceptWork;
import org.insightcentre.pthg24.datamodel.Citation;
import org.insightcentre.pthg24.datamodel.Reference;
import org.insightcentre.pthg24.datamodel.MissingCitingWork;
import org.insightcentre.pthg24.datamodel.MissingCitedWork;
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

public  class School extends ApplicationObject{
/**
 *  No-arg constructor for use in TableView
 *
*/

    public School(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public School(ApplicationDataset applicationDataset){
        super(applicationDataset);
        applicationDataset.addSchool(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public School(ApplicationDataset applicationDataset,
            Integer id,
            String name){
        super(applicationDataset,
            id,
            name);
        applicationDataset.addSchool(this);
    }

    public School(School other){
        this(other.applicationDataset,
            other.id,
            other.name);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        getApplicationDataset().cascadePhDThesisSchool(this);
        return getApplicationDataset().removeSchool(this) && getApplicationDataset().removeApplicationObject(this);
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
        return ""+ " " +getId()+ " " +getName();
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
         out.println("<school "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+" />");
     }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>School</th>"+"<th>Name</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a School item we are looking for
 * @param bList List<School> list of items in which we are searching
 * @return School entry of list b which is applicationSame() to a
*/

    public static School find(School a, List<School> bList){
        for(School b : bList){
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
 * @param name School name of the object we are looking for
 * @return School entry of the dataset with the given name; otherwise null
*/

    public static School findByName(ApplicationDataset base, String name){
        for(School a:base.getListSchool()) {
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
 * @param name School name of the object we are looking for
 * @return School entry of the dataset with the given name
*/

    public static School findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(School a:base.getListSchool()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        School res = new School(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return School first entry in the dataset of this type; null if that does not exists
*/

    public static School findFirst(ApplicationDataset base){
        if (base.getListSchool().isEmpty()) {
            return null;
        }
        return base.getListSchool().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return School some entry in the dataset of this type; null if that does not exists
*/

    public static School findAny(ApplicationDataset base){
        int size=base.getListSchool().size();
        if (size > 0) {
             return base.getListSchool().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return School last entry in the dataset of this type; null if that does not exists
*/

    public static School findLast(ApplicationDataset base){
        int size=base.getListSchool().size();
        if (size > 0) {
             return base.getListSchool().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b School compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(School b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b School compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(School b){
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
        return  this.getName().equals(b.getName());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","School",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class School
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
