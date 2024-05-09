package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.Scenario;

public abstract class AbstractList {
    Scenario base;

    public AbstractList(Scenario base){
        this.base = base;
    }

    public String showSource(String t){
        return t.replaceAll("_","");
    }

    public String showAuthor(String t){
        return alphaSafe(t);
    }

    public String showTitle(String t){
        return alphaSafe(t);
    }

    public String showAbstract(String t){
        return specials(t);
    }


    private String alphaSafe(String s){
        return s.replaceAll("&"," and ").
                replaceAll("_","-").
                replace("%","percent").
                replace("\\","/").
                replace("$","USD").
                replace("^","").replaceAll("#","sharp");
    }

    private String specials(String t){
        if (t.contains("\\documentclass")){
            return "*** LATEX Code detected ***";
        }
        if (t.contains("<mml:math")){
            return "*** XML detected ***";
        }
        return t.replaceAll("<p>","").replaceAll("</p>","").
                replaceAll("\\$","USD").replaceAll("%","\\\\%").
                replaceAll("&amp;", "\\&").
                replaceAll("&gt;"," gt ").
                replaceAll("_","-").
                replaceAll("&lt;"," lt ").replaceAll("&\\w*;","").replaceAll("&\\\\#x0D;","").replaceAll("&"," and ");
    }





}
