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
 * This type decribes the annotation used when comparing two datasets to indicate the differences between datasets A and B.
 * @author generated
*/

public enum DifferenceType{
    /**
 *  The item only occurs in dataset A.
 *
*/

ONLYA,
    /**
 *  The item only occurs in dataset B.
 *
*/

ONLYB,
    /**
 *  The item occurs in both datasets, but is different. This is the version of dataset A.
 *
*/

DIFFERA,
    /**
 *  The item occurs in both datasets, but is different. This is the version of dataset B.
 *
*/

DIFFERB;
private static DifferenceType[] cache = null;

public static DifferenceType[] cachedValues(){
    if (cache== null){
        cache = DifferenceType.values();
    }
    return cache;
}

public static String[] getNamesAndAll(){
    String[] res = new String[DifferenceType.cachedValues().length+1];
    int i=0;
    res[i++] = "All";
    for(DifferenceType p:DifferenceType.cachedValues()){
        res[i++] = p.name();
    }
    return res;
}

public static String[] getNames(){
    String[] res = new String[DifferenceType.cachedValues().length];
    int i=0;
    for(DifferenceType p:DifferenceType.cachedValues()){
        res[i++] = p.name();
    }
    return res;
}

public static DifferenceType entry(int i){
    return cachedValues()[i];
}

public static String nameOf(int i){
    return cachedValues()[i].name();
}

public static int indexOf(DifferenceType p){
    return p.ordinal();
}

public static int size(){
    return cachedValues().length;
}

}