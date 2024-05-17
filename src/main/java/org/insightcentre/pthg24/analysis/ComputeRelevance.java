package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.groupingBy;
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
    List<Concept> conceptList=new ArrayList<>();

    public ComputeRelevance(Scenario base, String type,
                            double citingSurveyWeight, double citedBySurveyWeight,
                            double citationCountWeight, double keywordWeight,
                            double authorWeight,double ageWeight,double abstractRelevanceCutoff,double bodyRelevanceCutoff){
        this.base = base;
        this.type = type;
        this.citingSurveyWeight = citingSurveyWeight;
        this.citedBySurveyWeight = citedBySurveyWeight;
        this.citationCountWeight = citationCountWeight;
        this.keywordWeight = keywordWeight;
        this.authorWeight = authorWeight;
        this.ageWeight = ageWeight;

        for(MissingWork mw:base.getListMissingWork()){
            mw.setRelevance(relevance(type,mw,abstractRelevanceCutoff));
            mw.setConcept(conceptList);
            if (mw.getRelevance() >= 1.0){
                mw.setIsSelected(true);
            }
        }
        for(OtherWork ow:base.getListOtherWork()){
            ow.setRelevance(relevance(type,ow,abstractRelevanceCutoff));
            ow.setConcept(conceptList);
            if (ow.getRelevance() >= 1.0){
                ow.setIsSelected(true);
            }
        }
        for(Work w:base.getListWork()){
            w.setRelevanceTitle(relevance(type,w,w.getTitle(),abstractRelevanceCutoff ));
            w.setRelevanceAbstract(relevance(type,w,w.getTitle() + " " + w.getAbstractText(),abstractRelevanceCutoff));
            w.setConcept(conceptList);
        }
        relevanceBody(base,type,bodyRelevanceCutoff);
    }

    public double relevance(String type,Work w,String text,double abstractRelevanceCutoff){
        double res =citingSurveyWeight * w.getNrReferences() +
                    citedBySurveyWeight * w.getNrCitations() +
                    authorWeight * knownAuthors(w) +
                    keywordWeight * keywords(type,text,abstractRelevanceCutoff) +
                    ageWeight * age(w) +
                    citationCountWeight * w.getCrossrefCitations();
        return res;
    }


    public double relevance(String type,MissingWork mw,double abstractRelevanceCutoff){
        double res = citingSurveyWeight*mw.getNrCited()+
                citedBySurveyWeight*mw.getNrCitations()+
                authorWeight*knownAuthors(mw)+
                keywordWeight*keywords(type,mw.getTitle()+" "+mw.getAbstractText(),abstractRelevanceCutoff)+
                ageWeight*age(mw)+
                citationCountWeight*mw.getCrossrefCitations();
        return res;
    }
    public double relevance(String type,OtherWork ow,double abstractRelevanceCutoff){
        return keywordWeight*keywords(type,ow.getTitle()+" "+ow.getAbstractText()+" "+ow.getKeywords(),abstractRelevanceCutoff);
    }

    private int knownAuthors(Work mw) {
        return 0;
    }
    private int knownAuthors(MissingWork mw) {
        return 0;
    }

    private double keywords(String type,String title,double abstractRelevanceCutoff){
        String lower = title.toLowerCase();
        double res = 0.0;
        if (type.equals("terrorism")) {
            ConceptType aimethod = ConceptType.findByName(base, "AIMethod");
            ConceptType terror = ConceptType.findByName(base, "Terrorism");
            ConceptType group = ConceptType.findByName(base, "Group");
            ConceptType region = ConceptType.findByName(base, "Region");
            ConceptType system = ConceptType.findByName(base, "System");
            ConceptType objective = ConceptType.findByName(base, "Objective");
            ConceptType other = ConceptType.findByName(base, "Other");
            double cntAiMethod = 0;
            double cntTerror = 0;
            double cntGroup = 0;
            double cntRegion = 0;
            double cntSystem = 0;
            double cntObjective = 0;
            double cntOther = 0;

            conceptList = new ArrayList<>();
            for (Concept con : base.getListConcept()) {
                if (con.getConceptType() == aimethod &&
                        occurs(con,title,lower)) {
                    cntAiMethod += con.getWeight();
                    conceptList.add(con);
                } else if (con.getConceptType() == terror &&
                        occurs(con,title,lower)) {
                    cntTerror+= con.getWeight();
                    conceptList.add(con);
                 } else if (con.getConceptType() == group &&
                        occurs(con,title,lower)) {
                    cntGroup+= con.getWeight();
                    conceptList.add(con);
                } else if (con.getConceptType() == region &&
                        occurs(con,title,lower)) {
                    cntRegion+= con.getWeight();
                    conceptList.add(con);
                } else if (con.getConceptType() == system &&
                        occurs(con,title,lower)) {
                    cntSystem+= con.getWeight();
                    conceptList.add(con);
                } else if (con.getConceptType() == objective &&
                        occurs(con,title,lower)) {
                    cntObjective+= con.getWeight();
                    conceptList.add(con);
                } else if (con.getConceptType() == other &&
                        occurs(con,title,lower)) {
                    cntOther+= con.getWeight();
                    conceptList.add(con);
                }
            }
            res = (1000.0 * (cntAiMethod * (cntTerror + cntGroup + cntRegion + cntSystem)) + cntAiMethod + cntTerror + cntGroup + cntRegion+cntSystem)/abstractRelevanceCutoff;
            if (res > 0) {
//                info("terrorism keywords " + res + " " + cntA + " " + cntB + " " + cntC + " " + cntD + " " + cntE + " " + cntF + " " + matches + " title " + title);
            }
        } else if (type.equals("scheduling")){
            ConceptType scheduling = ConceptType.findByName(base, "Scheduling");
            ConceptType cp = ConceptType.findByName(base, "CP");
            double cntScheduling = 0.0;
            double cntCP = 0.0;
            conceptList = new ArrayList<>();
            for (Concept con : base.getListConcept()) {
                if (con.getConceptType() == scheduling &&
                        occurs(con,title,lower)) {
                    cntScheduling+= con.getWeight();
                    conceptList.add(con);
                } else if (con.getConceptType() == cp &&
                        occurs(con,title,lower)) {
                    cntCP+= con.getWeight();
                    conceptList.add(con);
                }
            }
            res = (1000.0 * (cntScheduling * cntCP)  + cntScheduling + cntCP)/abstractRelevanceCutoff ;
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

    private void relevanceBody(Scenario base,String type,double bodyRelevanceCutoff){
        double max = 0.0;
        if(type.equals("terrorism")) {
            ConceptType aimethod = ConceptType.findByName(base, "AIMethod");
            ConceptType terror = ConceptType.findByName(base, "Terrorism");
            ConceptType group = ConceptType.findByName(base, "Group");
            ConceptType region = ConceptType.findByName(base, "Region");
            ConceptType system = ConceptType.findByName(base, "System");
            Map<Work, List<ConceptWork>> map = base.getListConceptWork().stream().
                    filter(x->x.getCount() > 0).
                    collect(groupingBy(ConceptWork::getWork));
            for (Work w : map.keySet()) {
                List<ConceptWork> list = map.get(w);
                double weightAI = addWeights(list, aimethod);
                double weightTerror = addWeights(list, terror);
                double weightGroup = addWeights(list, group);
                double weightRegion = addWeights(list, region);
                double weightSystem = addWeights(list, system);
                double total = weightAI * (weightTerror + weightGroup + weightRegion + weightSystem);
                max = Math.max(max,total);
                w.setRelevanceBody(total);
            }
            info("Max raw relevance "+max);
            for (Work w : map.keySet()) {
                //??? have to decide how to compute this
//                w.setRelevanceBody(w.getRelevanceBody()/max);
//                w.setRelevanceBody(Math.min(1.0,w.getRelevanceBody()/bodyRelevanceCutoff));
                w.setRelevanceBody(w.getRelevanceBody()/bodyRelevanceCutoff);
            }
        }

    }

    private double addWeights(List<ConceptWork> list,ConceptType type){
        return list.stream().
                filter(x->x.getConcept().getConceptType()==type).
                mapToDouble(this::weightedCount).
                sum();
    }

    private double weightedCount(ConceptWork cw){
        return cw.getCount()*cw.getConcept().getWeight();
    }
}
