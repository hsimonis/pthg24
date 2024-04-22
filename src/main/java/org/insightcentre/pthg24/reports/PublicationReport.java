package org.insightcentre.pthg24.reports;

import framework.reports.visualization.heatmap.HeatMapColoring;
import framework.reports.visualization.heatmap.HeatMapFunctions;
import framework.reports.visualization.heatmap.HeatMap;
import framework.reports.visualization.plot.barplot.BarPlot;
import framework.reports.visualization.plot.distributionplot.DistributionPlot;
import framework.reports.visualization.plot.distributionplot.DistributionPlotOrdering;
import framework.reports.visualization.plot.lineplot.LinePlot;
import framework.reports.visualization.plot.lineplot.LinePlotFunctions;
import framework.reports.visualization.plot.scatterplot.ScatterPlot;
import framework.reports.visualization.tabular.table.TableDraw;
import org.insightcentre.pthg24.datamodel.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static framework.reports.visualization.heatmap.ColorScheme.defineColors;
import static java.util.stream.Collectors.groupingBy;
import static org.insightcentre.pthg24.logging.LogShortcut.info;

public class PublicationReport extends AbstractReport{
    public PublicationReport(Scenario base, String reportDir){
        super(base,reportDir);
    }

    public void content(){
        tex.printf("%s\n\n",defineColors());

        section("Data Quality");
        dataQuality();

        section("Works by Location");
        byCountry();
        byInst();

        section("Collaborations");
        Map<Work,List<WorkAffiliation>> map = base.getListWorkAffiliation().stream().
                filter(x->!x.getWork().getBackground()).
                collect(groupingBy(WorkAffiliation::getWork));
        List<Work> affWorks = new ArrayList<>(map.keySet());
//        List<Work> affWorks = base.getListWorkAffiliation().stream().
//                filter(x->!x.getWork().getBackground()).
//                map(WorkAffiliation::getWork).
//                distinct().
//                toList();
        new DistributionPlot<>(affWorks,x->nrOfAffiliations(x,map)).
                title("Works with given Number of Affiliations (Total "+affWorks.size()+" Works)").
                xlabel("Nr Affiliations").ylabel("Nr Works").
                width(25).height(15).
                generate().latex(tex);


        section("Conference Papers by Most Common Conference Series");
        bySeries(base.getListPaper().stream().filter(x->!x.getBackground()).collect(Collectors.toList()));

        section("Journal Articles by Most Common Journals");
        byJournal(base.getListArticle().stream().filter(x->!x.getBackground()).collect(Collectors.toList()));

        section("Works by Year");
        byYear(base.getListWork().stream().filter(x->!x.getBackground()).collect(Collectors.toList()),
                base.getListWork().stream().filter(x->!x.getBackground()).filter(x->x instanceof Paper).collect(Collectors.toList()),
                base.getListWork().stream().filter(x->!x.getBackground()).filter(x->x instanceof Article).collect(Collectors.toList()),
                base.getListWork().stream().filter(x->!x.getBackground()).filter(x->x instanceof PhDThesis).collect(Collectors.toList()));

        section("Number of Coauthors per Work");
        coAuthorDistributionPlot(base.getListWork().stream().filter(x->!x.getBackground()).collect(Collectors.toList()));

        section("Number of Works per Author");
        workDistributionPlot(base.getListAuthor().stream().filter(x->x.getNrWorks() >0).collect(Collectors.toList()));

        section("Citation Distribution");
        citationDistributionPlot(base.getListWork().stream().filter(x->!x.getBackground()).toList());

        clearpage();
        section("Similarity Measures");

        new HeatMap<>(base.getListSimilarity().stream().filter(x->!Double.isNaN(x.getSimilarity())).toList(),
                new HeatMapFunctions<>(Similarity::getWork1,
                        Similarity::getWork2,
                        this::nameOf,
                        this::nameOf,
                        x->(int)Math.round(x.getSimilarity()*1000)),
                42,22).
                coloring(HeatMapColoring.PERCENTOFMAXIMUM).
                colorSaturation(40).
                caption("Similarity Measure (*1000) based on References and Citations (high = similar)").
                width(25).height(15).
                generate().latex(tex);
        new HeatMap<>(base.getListSimilarity().stream().filter(x->!Double.isNaN(x.getSimilarityConcept())).toList(),
                new HeatMapFunctions<>(Similarity::getWork1,
                        Similarity::getWork2,
                        this::nameOf,
                        this::nameOf,
                        x->(int)Math.round(x.getSimilarityConcept())),
                55,35).
                coloring(HeatMapColoring.PERCENTOFMAXIMUM).
                colorSaturation(40).
                caption("Similarity Measure based on Extracted Concepts (low = similar)").
                width(25).height(15).
                generate().latex(tex);

        paragraph("The following distribution plot shows the similarity values between two works based on " +
                "citations and references counts. If either work does not have citation and reference values, then " +
                "the similarity is set to NaN. The total similarity count is the sum of the similarity for " +
                "citations and for references. As value we compute the ratio of shared references (citations) to " +
                "the sum of individual references (citations), multiplied by two. So both the citation and reference " +
                "similarity range between zero and one, and the sum ranges between zero and two. High values are " +
                "exceedingly rare, as they require both works to be citing the same papers, and being cited by the " +
                "same papers.A larger values " +
                "indicates that items are more similar according to this measure. In the plot we group values " +
                "into 0.1 wide value bins, so an entry for 0.2 includes values from 0.15 to 0.25.");
        paragraph("We observe that high values of this similarity are often found for two works by the same " +
                "authors that are close in time, where we assumes that the bibliography is based on the same " +
                "literature survey.");

        new DistributionPlot<>(base.getListSimilarity().stream().filter(x->!Double.isNaN(x.getSimilarity())).toList(),this::similar).
                ordering(DistributionPlotOrdering.LABEL).
                title("Distribution Plot of Similarity Values by References and Citations (High value is similar)").
                xlabel("Similarity Value").ylabel("Count").
                width(25).height(15).
                generate().latex(tex);

        paragraph("The similarity by concept uses the Euclidean distance between the feature vectors for two " +
                "works. We translate the MatchLevel for each Concept into a linear scale, and then calculate the " +
                "distances as the square root of the sum of squared differences for each feature. The distribution " +
                "plot below rounds the distances to integer values. Similarity values of this type are only " +
                "calculated when both works have a local copy, from which we extract the features. If either " +
                "work does not have a local copy, the similarity is set to be NaN.");
        new DistributionPlot<>(base.getListSimilarity().stream().filter(x->!Double.isNaN(x.getSimilarityConcept())).toList(),this::similarConcept).
                ordering(DistributionPlotOrdering.NR).
                title("Distribution Plot of Similarity Values by Concept (Low value is similar)").
                xlabel("Similarity Value").ylabel("Count").
                width(25).height(15).
                generate().latex(tex);

        clearpage();
        section("Concept Distribution");
        paragraph("For each concept type, we count how many features are extracted by the individual works that " +
                "do have a local copy, e.g. for which we can extract features. We can compare the number of features " +
                "extracted to the number of concepts of a given type, which is stated in the title of the diagram.");
        paragraph("A high count indicates that a work covers many of the concepts of the given type, a low count " +
                "might mean that our ontology does not have relevant concepts for that work.");
        for(ConceptType type:ConceptType.values()){
            int d = (int) base.getListConcept().stream().filter(x->x.getConceptType()==type).count();
            new DistributionPlot<>(base.getListWork().stream().
                    filter(x -> !x.getLocalCopy().equals("")).
                    filter(x -> !x.getBackground()).
                    toList(),x->featureCount(x,type)).
                    ordering(DistributionPlotOrdering.NR).
                    title("Feature Count for Type "+safe(type.toString()+" with a total of "+d+" features")).
                    xlabel("Nr of Extracted Features").ylabel("Nr Works").
                    width(25).height(15).
                    generate().latex(tex);
        }
        clearpage();
        section("Coauthor graph");
        paragraph("The coauthor plot is created by graphviz, and is based on the coauthor relations extracted " +
                "from the author fields of the works. Authors with few works are not shown, to avoid a cluttered " +
                "view. Note that this analysis depends on the use of canonical forms of author names. If bib " +
                "entries come from any different sources, we will need to check this manually. DBLP seems to be " +
                "using ORCID values and typically identifies the authors of a work with a canonical " +
                "representation of their name. Accents and umlauts are other sources of having multiple forms of the " +
                "name of the same author. Note that the risk of two different authors using the same name should be " +
                "low for very specific literature surveys, but cannot be checked with the data sources currently used.");
        paragraph("The plots can be made with different layout tools in graphviz, it seems that fdp produces " +
                "the most consistent visually attractive plots for this type of display. This probably needs more " +
                "work on parameter settings to be fully automated.");
        tex.printf("\\begin{figure}[htbp]\n");
        tex.printf("\\caption{Coauthor Graph Drawn with fdp (Graphviz)}\n");
        tex.printf("\\centering\n");
        tex.printf("\\includegraphics[width=.6\\textwidth]{../graphviz/fdp.pdf}\n\n");
        tex.printf("\\end{figure}\n\n");

        clearpage();
        section("OpenCitations vs. Crossref Data");
        new ScatterPlot<>(base.getListWork(), Work::getNrCitations, Work::getCrossrefCitations, Work::getNrReferences).
                title("Comparing Citation Counts").
                xlabel("OpenCitation Citations").ylabel("Crossref Citations (Colored by OpenCitation References)").
                width(22).height(15).
                generate().latex(tex);
        new ScatterPlot<>(base.getListWork(), Work::getNrCitations, Work::getCrossrefCitations, Work::getNrReferences).
                xrange(0.0,300.0).
                yrange(0.0,300.0).
                title("Comparing Citation Counts (Clipped to 300, Colored by OpenCitation References)").
                xlabel("OpenCitation Citations").ylabel("Crossref Citations").
                width(22).height(15).
                generate().latex(tex);
        new ScatterPlot<>(base.getListWork(), Work::getNrReferences, Work::getCrossrefReferences, Work::getNrCitations).
                xrange(0.0,300.0).
                yrange(0.0,300.0).
                title("Comparing References Counts (Clipped to 300, Colored by OpenCitation Citations)").
                xlabel("OpenCitation References").ylabel("Crossref References").
                width(22).height(15).
                generate().latex(tex);

        new DistributionPlot<>(base.getListWork().stream().
                filter(x->!x.getBackground()).
                filter(x->!Double.isNaN(x.getPercentReferencesCovered())).
                toList(),
                this::referenceCoverage).
                ordering(DistributionPlotOrdering.NR).
                title("Percentage of OpenCitation References Covered by Survey (Excludes Background Works)").
                xlabel("PercentageBand").ylabel("Nr Works").
                width(25).height(15).
                generate().latex(tex);
        new DistributionPlot<>(base.getListWork().stream().
                filter(x->!x.getBackground()).
                filter(x->!Double.isNaN(x.getPercentCitationsCovered())).
                toList(),
                this::citationCoverage).
                ordering(DistributionPlotOrdering.NR).
                title("Percentage of OpenCitation Citations Covered by Survey (Excludes Background Works)").
                xlabel("PercentageBand").ylabel("Nr Works").
                width(25).height(15).
                generate().latex(tex);


        new DistributionPlot<>(base.getListMissingWork(), MissingWork::getNrLinks).
                ordering(DistributionPlotOrdering.NR).
                title("Missing Work Links with Survey").
                xlabel("Links").ylabel("Nr Missing Works").
                width(25).height(15).
                generate().latex(tex);

        clearpage();
        section("Citations by Year and Source Group");

        for(SourceGroup sg:base.getListSourceGroup().stream().filter(x->!x.getName().equals("Background")).toList()){
            List<Work> works = base.getListWork().stream().filter(x->x.getSourceGroup()==sg).toList();
            if (works.size() > 1) {
                new ScatterPlot<>(works,
                        Work::getYear, Work::getNrCitations, Work::getNrReferences).
                        title("Nr Citations of Works per Year for Source Group " + safe(sg.getName()) + " colored by Nr References").
                        xlabel("Year").ylabel("Citations").
                        width(25).height(15).
                        generate().latex(tex);
            }
        }
    }

    private Integer nrOfAffiliations(Work w,Map<Work,List<WorkAffiliation>> map){
        List<WorkAffiliation> affs= map.get(w);
        return (affs==null?0:map.get(w).size());
    }
    private int referenceCoverage(Work w){
        return ((int) Math.round(w.getPercentReferencesCovered()/5.0))*5;
    }
    private int citationCoverage(Work w){
        return ((int) Math.round(w.getPercentCitationsCovered()/5.0))*5;
    }

    private int featureCount(Work w,ConceptType type){
        return (int) base.getListConceptWork().stream().
                filter(x->x.getWork()==w).
                filter(x->x.getConcept().getConceptType()==type).
                filter(x->x.getCount() > 0).
                count();
    }

    private String similar(Similarity s){
        return String.format("%.2f",Math.round(s.getSimilarity()*10.0)/10.0);
//        return (int) Math.round(s.getSimilarity()*10.0);
    }
    private int similarConcept(Similarity s){
//        return String.format("%.2f",Math.round(s.getSimilarity()*10.0)/10.0);
        return (int) Math.round(s.getSimilarityConcept());
    }

    private void bySeries(List<Paper> work){
        Map<ConferenceSeries,List<Paper>> map = work.stream().
                collect(groupingBy(x->x.getProceedings().getConferenceSeries()));
        for(ConferenceSeries series:map.keySet()){
            series.setNrPapers(map.get(series).size());
            series.setNrCitations(map.get(series).stream().mapToInt(Work::getNrCitations).sum());
        }
        new BarPlot<>(base.getListConferenceSeries().stream().filter(x -> x.getNrPapers() > 1).toList(),
                this::nameOf,
                ConferenceSeries::getNrPapers).
                width(20).height(10).
                title("Conference Paper Count by Conference Series (Count > 1)").
                xlabel("Conference Series").ylabel("Paper Count").
                generate().latex(tex);
        new BarPlot<>(base.getListConferenceSeries().stream().filter(x -> x.getNrPapers() > 1).toList(),
                this::nameOf,
                ConferenceSeries::getNrCitations).
                width(20).height(10).
                title("Citation Count by Conference Series (Paper Count > 1)").
                xlabel("Conference Series").ylabel("Citation Count").
                generate().latex(tex);
        new BarPlot<>(base.getListConferenceSeries().stream().filter(x -> x.getNrPapers() > 1).toList(),
                this::nameOf,
                x->1.0*x.getNrCitations()/x.getNrPapers()).
                width(20).height(10).
                title("Average Citation Count per Paper by Conference Series (Paper Count > 1)").
                xlabel("Conference Series").ylabel("Average Citation Count").
                generate().latex(tex);

    }
    private void byJournal(List<Article> work){
        Map<Journal,List<Article>> map = work.stream().collect(groupingBy(Article::getJournal));
        for(Journal j:map.keySet()){
            j.setNrArticles(map.get(j).size());
            j.setNrCitations(map.get(j).stream().mapToInt(Work::getNrCitations).sum());
        }
        new BarPlot<>(base.getListJournal().stream().filter(x -> x.getNrArticles() > 1).toList(),
                this::nameOf,
                Journal::getNrArticles).
                width(22).height(10).
                title("Article Count by Journal (Count > 1)").
                xlabel("Journal").ylabel("Article Count").
                generate().latex(tex);
        new BarPlot<>(base.getListJournal().stream().filter(x -> x.getNrArticles() > 1).toList(),
                this::nameOf,
                Journal::getNrCitations).
                width(22).height(10).
                title("Citation Count by Journal (Article Count > 1)").
                xlabel("Journal").ylabel("Citation Count").
                generate().latex(tex);
        new BarPlot<>(base.getListJournal().stream().filter(x -> x.getNrArticles() > 1).toList(),
                this::nameOf,
                x->1.0*x.getNrCitations()/x.getNrArticles()).
                width(22).height(10).
                title("Average Citation Count per Article by Journal (Article Count > 1)").
                xlabel("Journal").ylabel("Average Citation Count").
                generate().latex(tex);

    }

    private void byYear(List<Work> works,List<Work> papers,List<Work> articles,List<Work> theses){
        Map<Integer,List<Work>> mapWorks= works.stream().collect(groupingBy(Work::getYear));
        Map<Integer,List<Work>> mapPapers= papers.stream().collect(groupingBy(Work::getYear));
        Map<Integer,List<Work>> mapArticles= articles.stream().collect(groupingBy(Work::getYear));
        Map<Integer,List<Work>> mapThesis= theses.stream().collect(groupingBy(Work::getYear));
        List<Integer> years = mapWorks.keySet().stream().filter(x->x > 1985).sorted().toList();
        LinePlot<Integer> lp = new LinePlot<>();
        lp.addPlot("All",years,new LinePlotFunctions<>(x->x, x->count(x,mapWorks)));
        lp.addPlot("Papers",years,new LinePlotFunctions<>(x->x, x->count(x,mapPapers)));
        lp.addPlot("Articles",years,new LinePlotFunctions<>(x->x, x->count(x,mapArticles)));
        lp.addPlot("Thesis",years,new LinePlotFunctions<>(x->x, x->count(x,mapThesis)));

        lp.legendPos("north west").
                width(25).height(12).
                title("Works by Year").
                xlabel("Year").ylabel("Count").
                generate().latex(tex);
        LinePlot<Integer> lp1 = new LinePlot<>();
        lp1.addPlot("All",years,new LinePlotFunctions<>(x->x, x->cite(x,mapWorks)));
        lp1.addPlot("Papers",years,new LinePlotFunctions<>(x->x, x->cite(x,mapPapers)));
        lp1.addPlot("Articles",years,new LinePlotFunctions<>(x->x, x->cite(x,mapArticles)));
//        lp1.addPlot("Thesis",years,new LinePlotFunctions<>(x->x, x->cite(x,mapThesis)));

        lp1.legendPos("north west").
                width(25).height(12).
                title("Citations by Year").
                xlabel("Year").ylabel("Citations").
                generate().latex(tex);
        LinePlot<Integer> lp2 = new LinePlot<>();
        lp2.addPlot("All",years,new LinePlotFunctions<>(x->x, x->avgCite(x,mapWorks)));
        lp2.addPlot("Papers",years,new LinePlotFunctions<>(x->x, x->avgCite(x,mapPapers)));
        lp2.addPlot("Articles",years,new LinePlotFunctions<>(x->x, x->avgCite(x,mapArticles)));
//        lp2.addPlot("Thesis",years,new LinePlotFunctions<>(x->x, x->avgCite(x,mapThesis)));

        lp2.legendPos("north west").
                width(25).height(12).
                title("Citations Per Work by Year").
                xlabel("Year").ylabel("Avg Citations").
                generate().latex(tex);
    }

    private Integer count(Integer year,Map<Integer,List<Work>> map){
        List<Work> works = map.get(year);
        if (works ==null){
            return 0;
        }
        return works.size();
    }
    private Integer cite(Integer year,Map<Integer,List<Work>> map){
        List<Work> works = map.get(year);
        if (works ==null){
            return 0;
        }
        return works.stream().mapToInt(Work::getNrCitations).sum();
    }
    private Double avgCite(Integer year,Map<Integer,List<Work>> map){
        List<Work> works = map.get(year);
        if (works ==null){
            return 0.0;
        }
        return 1.0*works.stream().mapToInt(Work::getNrCitations).sum()/works.size();
    }

    private void coAuthorDistributionPlot(List<Work> works){
        new DistributionPlot<>(works,x->x.getAuthors().size()).
                ordering(DistributionPlotOrdering.NR).
                width(20).height(10).
                title("Number of Co-Authors per Work").
                xlabel("Nr Co-Authors").ylabel("Count").
                generate().latex(tex);
    }
    private void workDistributionPlot(List<Author> authors){
        new DistributionPlot<>(authors, Author::getNrWorks).
                ordering(DistributionPlotOrdering.NR).
                width(20).height(10).
                title("Number of Works per Co-Author").
                xlabel("Nr Works").ylabel("Co-Author Count").
                generate().latex(tex);
    }

    private void citationDistributionPlot(List<Work> works){
        Map<Integer,List<Work>> map = works.stream().collect(groupingBy(Work::getNrCitations));
        new LinePlot<>(map.keySet().stream().
                filter(x->x>0).
                filter(x->x<200).
                sorted().
                toList(),new LinePlotFunctions<>(x->x,x->citationCount(map,x))).
//                grid().
                width(25).height(15).
                title("Nr Citation Distribution Plot ").
                xlabel("Nr Citations").ylabel("Nr Works").
                generate().latex(tex);
    }

    private int citationCount(Map<Integer,List<Work>> map,Integer x){
        List<Work> list = map.get(x);
        if (list==null){
            return 0;
        }
        return list.size();
    }


    private void dataQuality() {
        int d = base.getListWork().size();
        new DistributionPlot<>(base.getListWork().stream().filter(x -> !x.getBackground()).toList(), this::workStatus).
                title("Data Quality (Total " + d + " Works)").
                xlabel("Status").ylabel("Nr Works").
                width(15).height(12).
                generate().latex(tex);

        List<Work> neither = base.getListWork().stream().
                filter(x -> x.getDoiStatus() && !x.getCrossrefStatus() && !x.getScopusStatus()).
                toList();

        listWorks("Works Unknown to Crossref and Scopus", neither);

        List<Work> noCrossref = base.getListWork().stream().
                filter(x -> x.getDoiStatus() && !x.getCrossrefStatus() && x.getScopusStatus()).
                toList();
        listWorks("Works Unknown to Crossref", noCrossref);

        List<Work> noScopus = base.getListWork().stream().
                filter(x -> x.getDoiStatus() && x.getCrossrefStatus() && !x.getScopusStatus()).
//                limit(20).
                toList();
        listWorks("Works Unknown to Scopus", noScopus);

    }

    private void listWorks(String caption,List<Work> list){
        new TableDraw<>(caption,list).
                addStringColumn("Key",Work::getKey).
                addStringColumn("DOI",this::safeDoi).
                addStringColumn("Source Group",x->nameOf(x.getSourceGroup())).
                addIntegerColumn("Year",Work::getYear).
                generate().
                latex(tex);

    }

    private String safeDoi(Work w){
        return w.getDoi().replace("_","\\_");
    }
    private String workStatus(Work w){
        if (w.getSourceGroup().getName().equals("Thesis") && !w.getDoiStatus()) {
            return "Thesis";
        } else if (!w.getDoiStatus()){
            assert(!w.getCrossrefStatus());
            assert(!w.getScopusStatus());
            return "No DOI";
        } else if (!w.getCrossrefStatus() && !w.getScopusStatus()){
            return "Unknown Scopus and Crossref";
        } else if (w.getCrossrefStatus() && !w.getScopusStatus()){
            return "Unknown Scopus";
        } else if (!w.getCrossrefStatus() && w.getScopusStatus()){
            return "Unknown Crossref";
        } else {
            return "OK";
        }
    }

    private void byCountry(){
        int d = (int) base.getListWorkAffiliation().stream().map(WorkAffiliation::getWork).distinct().count();
        new BarPlot<>(base.getListScopusCountry().stream().
                sorted(Comparator.comparing(ScopusCountry::getWorkCount).reversed()).
                limit(30).
                toList(), ApplicationObject::getName, ScopusCountry::getWorkCount).
                width(25).height(15).
                title("Countries with Largest Number of Works (Total "+d+" Works)").
                xlabel("Country").ylabel("Nr Works").
                generate().latex(tex);
    }
    private void byInst(){
        int d = (int) base.getListWorkAffiliation().stream().map(WorkAffiliation::getWork).distinct().count();
        new BarPlot<>(base.getListScopusAffiliation().stream().
                sorted(Comparator.comparing(ScopusAffiliation::getWorkCount).reversed()).
                limit(25).
                toList(), this::instName, ScopusAffiliation::getWorkCount).
                width(22).height(11).
                title("Institutions with Largest Number of Works (Total "+d+" Works)").
                xlabel("Institutions").ylabel("Nr Works").
                generate().latex(tex);
    }

    private String instName(ScopusAffiliation x){
        return safe(x.getInst().replaceAll("\\,",""));
    }
}
