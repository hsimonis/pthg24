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
 * This type describes the different warning types used by the application.
 * @author generated
*/

public enum WarningType{
    /**
 *  The attribute value is null, but the data model forbids this.
 *
*/

NOTNULL,
    /**
 *  The attribute value is an empty collection, but the datamodel forbids this.
 *
*/

NOTEMPTY,
    /**
 *  The attribute value is negative, but the datamodel requires the attribute to be non-negative.
 *
*/

NOTNEG,
    /**
 *  The attribute value is zero or negative, but the datamodel requires the attribute to be positive.
 *
*/

POSITIVE,
    /**
 *  The attribute value is constrained to be less or equal to another value, but it is not.
 *
*/

LEQ,
    /**
 *  The attribute value is constrained to be greater or equal to another value, but it is not.
 *
*/

GEQ,
    /**
 *  The attribute timepoint should be before another, but it is not.
 *
*/

BEFORE,
    /**
 *  The attribute timepoint should be after another, but it is not.
 *
*/

AFTER;
private static WarningType[] cache = null;

public static WarningType[] cachedValues(){
    if (cache== null){
        cache = WarningType.values();
    }
    return cache;
}

public static String[] getNamesAndAll(){
    String[] res = new String[WarningType.cachedValues().length+1];
    int i=0;
    res[i++] = "All";
    for(WarningType p:WarningType.cachedValues()){
        res[i++] = p.name();
    }
    return res;
}

public static String[] getNames(){
    String[] res = new String[WarningType.cachedValues().length];
    int i=0;
    for(WarningType p:WarningType.cachedValues()){
        res[i++] = p.name();
    }
    return res;
}

public static WarningType entry(int i){
    return cachedValues()[i];
}

public static String nameOf(int i){
    return cachedValues()[i].name();
}

public static int indexOf(WarningType p){
    return p.ordinal();
}

public static int size(){
    return cachedValues().length;
}

}
