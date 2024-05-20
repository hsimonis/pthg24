package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.datamodel.Work;

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

    public String showRelevances(Work w){
        if (w.getLocalCopy() != null && !w.getLocalCopy().equals("")) {
            return String.format("\\noindent{}%s %s %s", highlighted(w.getRelevanceTitle()), highlighted(w.getRelevanceAbstract()), highlighted(w.getRelevanceBody()));
        } else {
            return String.format("\\noindent{}%s %s n/a", highlighted(w.getRelevanceTitle()), highlighted(w.getRelevanceAbstract()));
        }
    }

    private String highlighted(double x){
        if (x >= 1.0){
            return String.format("\\textbf{%.2f}",x);
        } else if (x <= 0.2){
            return String.format("\\textcolor{black!50}{%.2f}",x);
        } else {
            return String.format("%.2f",x);
        }
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
