package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.insightcentre.pthg24.logging.LogShortcut.info;
import static org.insightcentre.pthg24.logging.LogShortcut.warning;

public class ComputeRelevance {
    Scenario base;
    String type;
    double citingSurveyWeight;
    double citedBySurveyWeight;
    double citationCountWeight;
    double keywordWeight;
    double authorWeight;
    double ageWeight;

    public ComputeRelevance(Scenario base, String type,
                            double citingSurveyWeight, double citedBySurveyWeight,
                            double citationCountWeight, double keywordWeight,
                            double authorWeight,double ageWeight){
        this.base = base;
        this.type = type;
        this.citingSurveyWeight = citingSurveyWeight;
        this.citedBySurveyWeight = citedBySurveyWeight;
        this.citationCountWeight = citationCountWeight;
        this.keywordWeight = keywordWeight;
        this.authorWeight = authorWeight;
        this.ageWeight = ageWeight;

        for(MissingWork mw:base.getListMissingWork()){
            mw.setRelevance(relevance(type,mw));
            if (mw.getRelevance() >= 1000.0){
                mw.setIsSelected(true);
            }
        }
        for(Work w:base.getListWork()){
            w.setRelevanceTitle(relevance(type,w,w.getTitle() ));
            w.setRelevanceAbstract(relevance(type,w,w.getTitle() + " " + w.getAbstractText()));
        }
    }

    public double relevance(String type,Work w,String text){
        double res =citingSurveyWeight * w.getNrReferences() +
                    citedBySurveyWeight * w.getNrCitations() +
                    authorWeight * knownAuthors(w) +
                    keywordWeight * keywords(type,w.getTitle() + " " + w.getAbstractText()) +
                    ageWeight * age(w) +
                    citationCountWeight * w.getCrossrefCitations();
        return res;
    }


    public double relevance(String type,MissingWork mw){
        double res = citingSurveyWeight*mw.getNrCited()+
                citedBySurveyWeight*mw.getNrCitations()+
                authorWeight*knownAuthors(mw)+
                keywordWeight*keywords(type,mw.getTitle()+" "+mw.getAbstractText())+
                ageWeight*age(mw)+
                citationCountWeight*mw.getCrossrefCitations();
        return res;
    }

    private int knownAuthors(Work mw) {
        return 0;
    }
    private int knownAuthors(MissingWork mw) {
        return 0;
    }

    private double keywords(String type,String title){
        String lower = title.toLowerCase();
        double res = 0.0;
        if (type.equals("terrorism")) {
            ConceptType a = ConceptType.findByName(base, "AIMethod");
            ConceptType b = ConceptType.findByName(base, "Terrorism");
            ConceptType c = ConceptType.findByName(base, "Objective");
            ConceptType d = ConceptType.findByName(base, "Group");
            ConceptType e = ConceptType.findByName(base, "Region");
            ConceptType f = ConceptType.findByName(base, "System");
            int cntA = 0;
            int cntB = 0;
            int cntC = 0;
            int cntD = 0;
            int cntE = 0;
            int cntF = 0;
            List<String> matches = new ArrayList<>();
            for (Concept con : base.getListConcept()) {
                if (con.getConceptType() == a &&
                        occurs(con,title,lower)) {
                    cntA++;
                    matches.add(con.getLabel());
                } else if (con.getConceptType() == b &&
                        occurs(con,title,lower)) {
                    cntB++;
                    matches.add(con.getLabel());
                } else if (con.getConceptType() == c &&
                        occurs(con,title,lower)) {
                    cntC++;
                    matches.add(con.getLabel());
                } else if (con.getConceptType() == d &&
                        occurs(con,title,lower)) {
                    cntD++;
                    matches.add(con.getLabel());
                } else if (con.getConceptType() == e &&
                        occurs(con,title,lower)) {
                    cntE++;
                    matches.add(con.getLabel());
                } else if (con.getConceptType() == f &&
                        occurs(con,title,lower)) {
                    cntF++;
                    matches.add(con.getLabel());
                }
            }
            res = 1000.0 * (cntA * (cntB + cntD + cntE) + cntF) + cntA + cntB + cntD + cntE;
//            res = 1000.0 * ((cntA + cntC) * (cntB + cntD + cntE) + cntF) + cntA + cntB + cntC + cntD + cntE;
            if (res > 0) {
//                info("terrorism keywords " + res + " " + cntA + " " + cntB + " " + cntC + " " + cntD + " " + cntE + " " + cntF + " " + matches + " title " + title);
            }
        } else if (type.equals("scheduling")){
            ConceptType a = ConceptType.findByName(base, "Scheduling");
            ConceptType b = ConceptType.findByName(base, "CP");
            int cntA = 0;
            int cntB = 0;
            List<String> matches = new ArrayList<>();
            for (Concept con : base.getListConcept()) {
                if (con.getConceptType() == a &&
                        occurs(con,title,lower)) {
                    cntA++;
                    matches.add(con.getLabel());
                } else if (con.getConceptType() == b &&
                        occurs(con,title,lower)) {
                    cntB++;
                    matches.add(con.getLabel());
                }
            }
            res = 1000.0 * (cntA * cntB)  + cntA + cntB ;
            if (res > 0) {
//                info("scheduling keywords " + res + " " + cntA + " " + cntB + " "  + matches + " title " + title);
            }

        } else {
            warning("No keyword match setup for type "+type);
        }
        return res;
    }

    private boolean occurs(Concept c,String t,String lower){
        Pattern pattern = Pattern.compile(c.getRegExpr());
        Matcher matcher = pattern.matcher(c.getCaseSensitive()?t:lower);
        return matcher.find();
    }

    private double age(Work w){
        return w.getYear()-2000;

    }
    private double age(MissingWork mw){
        return mw.getYear()-2000;

    }
}
