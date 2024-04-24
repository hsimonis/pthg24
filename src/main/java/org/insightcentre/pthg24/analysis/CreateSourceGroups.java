package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class CreateSourceGroups {
    Scenario base;
    Hashtable<String,SourceGroup> sourceHash = new Hashtable<>();
    Hashtable<String,ReferenceFlow> flowHash = new Hashtable<>();
    public CreateSourceGroups(Scenario base,String type){

        this.base = base;
        if (type.equals("scheduling")) {
            SourceGroup background = createSG("Background");
            SourceGroup cp = createSG("CP");
            SourceGroup cpaior = createSG("CPAIOR");
            SourceGroup icaps = createSG("ICAPS");
            SourceGroup aaai = createSG("AAAI");
            SourceGroup ijcai = createSG("IJCAI");
            SourceGroup ecai = createSG("ECAI");
            SourceGroup otherConf = createSG("OtherConf");
            SourceGroup constraints = createSG("Constraints");
            SourceGroup ejor = createSG("EJOR");
            SourceGroup informsJC = createSG("InformsJC");
            SourceGroup aiJournal = createSG("AIJournal");
            SourceGroup orJournal = createSG("ORJournal");
            SourceGroup preprint = createSG("Preprint");
            SourceGroup otherJournal = createSG("OtherJournal");
            SourceGroup book = createSG("Book");
            SourceGroup inbook = createSG("Inbook");
            SourceGroup incollection = createSG("Incoll");
            SourceGroup thesis = createSG("Thesis");
            SourceGroup other = createSG("Other");

            for (Work w : base.getListWork()) {
                SourceGroup sg = classifyWork(w);
                w.setSourceGroup(sg);
                sg.incNrWorks();
            }
        } else {
            SourceGroup background = createSG("Background");
            SourceGroup otherConf = createSG("OtherConf");
            SourceGroup otherJournal = createSG("OtherJournal");
            SourceGroup book = createSG("Book");
            SourceGroup inbook = createSG("Inbook");
            SourceGroup incollection = createSG("Incoll");
            SourceGroup thesis = createSG("Thesis");
            SourceGroup other = createSG("Other");
            for(Work w:base.getListWork()){
                if (w.getBackground()){
                    w.setSourceGroup(background);
                } else if (w instanceof Book){
                    w.setSourceGroup(book);
                } else if (w instanceof Paper){
                    w.setSourceGroup(otherConf);
                } else if (w instanceof Article){
                    w.setSourceGroup(otherJournal);
                } else if (w instanceof PhDThesis){
                    w.setSourceGroup(thesis);
                } else if (w instanceof InCollection){
                    w.setSourceGroup(incollection);
                } else if (w instanceof InBook){
                    w.setSourceGroup(inbook);
                } else {
                    w.setSourceGroup(other);
                }
            }

        }
        analyzeFlows();
        updateSourceGroupCounts();

    }

    private void analyzeFlows(){
        for (SourceGroup from : base.getListSourceGroup()) {
            for (SourceGroup to : base.getListSourceGroup()) {
                String key = key(from, to);
                ReferenceFlow rf = new ReferenceFlow(base);
                rf.setName(key);
                rf.setFrom(from);
                rf.setTo(to);
                flowHash.put(key, rf);
            }
        }
        for (Reference ref : base.getListReference().stream().
                filter(x -> x.getCitingWork() != null && x.getCitedWork() != null).
                toList()) {
            ReferenceFlow rf = flowHash.get(key(ref.getCitingWork().getSourceGroup(), ref.getCitedWork().getSourceGroup()));
            rf.incValue();
        }
        for (ReferenceFlow rf : base.getListReferenceFlow()) {
            double normalized = 100.0 * rf.getValue() / (rf.getFrom().getNrWorks() * rf.getTo().getNrWorks());
            rf.setNormalized(normalized);
        }

    }

    private String key(SourceGroup from,SourceGroup to){
        return from.getName()+"->"+to.getName();
    }


    private SourceGroup classifyWork(Work w){
        if (w.getBackground()){
            return findSourceGroup("Background");
        }
        if (w instanceof Paper && ((Paper)w).getProceedings().getConferenceSeries().getName().equals("CP")){
            return findSourceGroup("CP");
        }
        if (w instanceof Paper && ((Paper)w).getProceedings().getConferenceSeries().getName().equals("CPAIOR")){
            return findSourceGroup("CPAIOR");
        }
        if (w instanceof Paper && ((Paper)w).getProceedings().getConferenceSeries().getName().equals("ICAPS")){
            return findSourceGroup("ICAPS");
        }
        if (w instanceof Paper && ((Paper)w).getProceedings().getConferenceSeries().getName().equals("ECAI")){
            return findSourceGroup("ECAI");
        }
        if (w instanceof Paper && ((Paper)w).getProceedings().getConferenceSeries().getName().equals("AAAI")){
            return findSourceGroup("AAAI");
        }
        if (w instanceof Paper && ((Paper)w).getProceedings().getConferenceSeries().getName().equals("IJCAI")){
            return findSourceGroup("IJCAI");
        }
        if (w instanceof Paper){
            return findSourceGroup("OtherConf");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("Constraints An Int. J.")){
            return findSourceGroup("Constraints");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("European Journal of Operational Research")){
            return findSourceGroup("EJOR");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("INFORMS Journal on Computing")){
            return findSourceGroup("InformsJC");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("Artificial Intelligence")){
            return findSourceGroup("AIJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("J. Artif. Intell. Res.")){
            return findSourceGroup("AIJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("Eng. Appl. Artif. Intell.")){
            return findSourceGroup("AIJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("Int. J. Artif. Intell. Tools")){
            return findSourceGroup("AIJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("{AI} Commun.")){
            return findSourceGroup("AIJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("Intelligenza Artificiale")){
            return findSourceGroup("AIJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("Inteligencia Artif.")){
            return findSourceGroup("AIJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("Artif. Intell. Eng.")){
            return findSourceGroup("AIJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("{AI} Mag.")){
            return findSourceGroup("AIJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("Artif. Intell. Rev.")){
            return findSourceGroup("AIJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("Annals of Operations Research")){
            return findSourceGroup("ORJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("Computers \\& Operations Research")){
            return findSourceGroup("ORJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("Journal of the Operational Research Society")){
            return findSourceGroup("ORJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("Oper. Res. Forum")){
            return findSourceGroup("ORJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("{OR} Spectr.")){
            return findSourceGroup("ORJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("Operations Research Perspectives")){
            return findSourceGroup("ORJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("Central Eur. J. Oper. Res.")){
            return findSourceGroup("ORJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("{EURO} J. Comput. Optim.")){
            return findSourceGroup("ORJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("Operations research for health care")){
            return findSourceGroup("ORJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("Operations Research")){
            return findSourceGroup("ORJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("OR Spectrum")){
            return findSourceGroup("ORJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("INFORMS Journal on Optimization")){
            return findSourceGroup("ORJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("Operational Research")){
            return findSourceGroup("ORJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("Computers  \\& Operations Research")){
            return findSourceGroup("ORJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("Discrete Optimization")){
            return findSourceGroup("ORJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("Management Science")){
            return findSourceGroup("ORJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("SN Operations Research Forum")){
            return findSourceGroup("ORJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("Journal of Optimization Theory and Applications")){
            return findSourceGroup("ORJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("Mathematics of Operations Research")){
            return findSourceGroup("ORJournal");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("CoRR")){
            return findSourceGroup("Preprint");
        }
        if (w instanceof Article && ((Article)w).getJournal().getName().equals("SSRN Electronic Journal")){
            return findSourceGroup("Preprint");
        }
        if (w instanceof Article){
            return findSourceGroup("OtherJournal");
        }
        if (w instanceof Book){
            return findSourceGroup("Book");
        }
        if (w instanceof PhDThesis){
            return findSourceGroup("Thesis");
        }
        if (w instanceof InCollection){
            return findSourceGroup("Incoll");
        }
        if (w instanceof InBook){
            return findSourceGroup("Inbook");
        }
         return findSourceGroup("Other");
    }

    private SourceGroup createSG(String name){
        SourceGroup res = new SourceGroup(base);
        res.setName(name);
        sourceHash.put(name,res);
        return res;
    }

    private SourceGroup findSourceGroup(String name){
        return sourceHash.get(name);
    }

    private void updateSourceGroupCounts(){
        Map<SourceGroup, List<ReferenceFlow>> mapFrom = base.getListReferenceFlow().stream().collect(groupingBy(ReferenceFlow::getFrom));
        for(SourceGroup from:mapFrom.keySet()){
            from.setFromFlows(mapFrom.get(from).stream().mapToInt(ReferenceFlow::getValue).sum());
        }
        Map<SourceGroup, List<ReferenceFlow>> mapTo = base.getListReferenceFlow().stream().collect(groupingBy(ReferenceFlow::getTo));
        for(SourceGroup to:mapTo.keySet()){
            to.setToFlows(mapTo.get(to).stream().mapToInt(ReferenceFlow::getValue).sum());
        }
    }
}
