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
import framework.reports.visualization.tabular.TableStyle;
import framework.reports.visualization.tabular.matrix.MatrixDraw;
import framework.reports.visualization.tabular.matrix.MatrixFunctions;
import framework.reports.visualization.tabular.table.TableDraw;
import org.insightcentre.pthg24.datamodel.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static framework.reports.visualization.heatmap.ColorScheme.defineColors;
import static framework.reports.visualization.plot.distributionplot.DistributionPlotOrdering.LABEL;
import static framework.reports.visualization.plot.distributionplot.DistributionPlotOrdering.NR;
import static java.util.stream.Collectors.groupingBy;

public class PublicationReport extends AbstractReport{
    public PublicationReport(Scenario base, String reportDir){
        super(base,reportDir);
    }

    public void content(){
        tex.printf("%s\n\n",defineColors());
        double relevanceLimit = 0.8;

        section("Introduction");

        paragraph("This report is a companion document to the main report generated for the extracted " +
                "information used in the survey of CP and Scheduling. This document is concerned with some of the " +
                "summary statistics, and with data quality issues that nre highlighted for correction by the authors.");

        section("Data Quality");
        dataQuality();

        clearpage();
        section("Works by Location");

        location();

        clearpage();
        section("Collaborations");

        collaborations();


        clearpage();
        section("Conference Papers by Most Common Conference Series");
        bySeries(base.getListPaper(),1);

        clearpage();
        section("Journal Articles by Most Common Journals");
        byJournal("Relevant Articles",base.getListArticle(),2,relevanceLimit);
        byJournal("All Articles",base.getListArticle(),2,0.0);

        clearpage();
        section("Works by Year");
        subsection("Relevant Works");
        byYear(base.getListWork().stream().filter(x->isRelevant(x,relevanceLimit)).filter(x->!x.getBackground()).collect(Collectors.toList()),
                base.getListWork().stream().filter(x->isRelevant(x,relevanceLimit)).filter(x->!x.getBackground()).filter(x->x instanceof Paper).collect(Collectors.toList()),
                base.getListWork().stream().filter(x->isRelevant(x,relevanceLimit)).filter(x->!x.getBackground()).filter(x->x instanceof Article).collect(Collectors.toList()),
                base.getListWork().stream().filter(x->isRelevant(x,relevanceLimit)).filter(x->!x.getBackground()).filter(x->x instanceof PhDThesis).collect(Collectors.toList()));

        subsection("All Works");
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

        similarity();


        clearpage();
        section("Concept Distribution");

        paragraph("For each concept type, we count how many features are extracted by the individual works that " +
                "do have a local copy, e.g. for which we can extract features. We can compare the number of features " +
                "extracted to the number of concepts of a given type, which is stated in the title of the diagram.");
        paragraph("A high count indicates that a work covers many of the concepts of the given type, a low count " +
                "might mean that our ontology does not have relevant concepts for that work.");
        for(ConceptType type:base.getListConceptType()){
            int d = (int) base.getListConcept().stream().filter(x->x.getConceptType()==type).count();
            new DistributionPlot<>(base.getListWork().stream().
                    filter(x -> !x.getLocalCopy().equals("")).
                    filter(x -> !x.getBackground()).
                    toList(),x->featureCount(x,type)).
                    ordering(NR).
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
        tex.printf("\\includegraphics[height=15cm]{../graphviz/fdp.pdf}\n\n");
        tex.printf("\\end{figure}\n\n");



        clearpage();
        section("OpenCitations vs. Crossref Data vs. Scopus Data");

        subsection("Citation Comparison");
        new ScatterPlot<>(base.getListWork(), Work::getNrCitations, Work::getCrossrefCitations, Work::getNrReferences).
                title("Comparing Citation Counts (Open Citations vs. Crossref)").
                xlabel("OpenCitation Citations").ylabel("Crossref Citations (Colored by OpenCitation References)").
                width(22).height(15).
                generate().latex(tex);
        new ScatterPlot<>(base.getListWork(), Work::getNrCitations, Work::getScopusCitations, Work::getNrReferences).
                title("Comparing Citation Counts (Open Citations vs. Scopus)").
                xlabel("OpenCitation Citations").ylabel("Scopus Citations (Colored by OpenCitation References)").
                width(22).height(15).
                generate().latex(tex);
        new ScatterPlot<>(base.getListWork(), Work::getCrossrefCitations, Work::getScopusCitations, Work::getNrReferences).
                title("Comparing Citation Counts (Crossref vs. Scopus)").
                xlabel("Crossref Citations").ylabel("Scopus Citations (Colored by OpenCitation References)").
                width(22).height(15).
                generate().latex(tex);
        new ScatterPlot<>(base.getListWork(), Work::getNrCitations, Work::getCrossrefCitations, Work::getNrReferences).
                xrange(0.0,300.0).
                yrange(0.0,300.0).
                title("Comparing Citation Counts (Clipped to 300, Colored by OpenCitation References)").
                xlabel("OpenCitation Citations").ylabel("Crossref Citations").
                width(22).height(15).
                generate().latex(tex);
        new ScatterPlot<>(base.getListWork(), Work::getNrCitations, Work::getScopusCitations, Work::getNrReferences).
                xrange(0.0,300.0).
                yrange(0.0,300.0).
                title("Comparing Citation Counts (Clipped to 300, Colored by OpenCitation References)").
                xlabel("OpenCitation Citations").ylabel("Scopus Citations").
                width(22).height(15).
                generate().latex(tex);
        new ScatterPlot<>(base.getListWork(), Work::getCrossrefCitations, Work::getScopusCitations, Work::getNrReferences).
                xrange(0.0,300.0).
                yrange(0.0,300.0).
                title("Comparing Citation Counts (Clipped to 300, Colored by OpenCitation References)").
                xlabel("Crossref Citations").ylabel("Scopus Citations").
                width(22).height(15).
                generate().latex(tex);
        subsection("References Comparison");
        new ScatterPlot<>(base.getListWork(), Work::getNrReferences, Work::getCrossrefReferences, Work::getNrCitations).
                xrange(0.0,300.0).
                yrange(0.0,300.0).
                title("Comparing References Counts (Clipped to 300, Colored by OpenCitation Citations)").
                xlabel("OpenCitation References").ylabel("Crossref References").
                width(22).height(15).
                generate().latex(tex);

        subsection("Percentage Cover");
        new DistributionPlot<>(base.getListWork().stream().
                filter(x->!x.getBackground()).
                filter(x->!Double.isNaN(x.getPercentReferencesCovered())).
                toList(),
                this::referenceCoverage).
                ordering(NR).
                title("Percentage of OpenCitation References Covered by Survey (Excludes Background Works)").
                xlabel("PercentageBand").ylabel("Nr Works").
                width(25).height(15).
                generate().latex(tex);
        new DistributionPlot<>(base.getListWork().stream().
                filter(x->!x.getBackground()).
                filter(x->!Double.isNaN(x.getPercentCitationsCovered())).
                toList(),
                this::citationCoverage).
                ordering(NR).
                title("Percentage of OpenCitation Citations Covered by Survey (Excludes Background Works)").
                xlabel("PercentageBand").ylabel("Nr Works").
                width(25).height(15).
                generate().latex(tex);


        new DistributionPlot<>(base.getListMissingWork(), MissingWork::getNrLinks).
                ordering(NR).
                title("Missing Work Links with Survey").
                xlabel("Links").ylabel("Nr Missing Works").
                width(25).height(15).
                generate().latex(tex);

        sourceGroups();

        pageLength();

        relevanceDistribution();
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


    private void bySeries(List<Paper> work,int limit){
        Map<ConferenceSeries,List<Paper>> map = work.stream().
                collect(groupingBy(x->x.getProceedings().getConferenceSeries()));
        for(ConferenceSeries series:map.keySet()){
            //??? should we be doing this here, move to earlier stage of processing
            series.setNrPapers((int) map.get(series).stream().filter(x->!x.getBackground()).count());
            series.setNrCitations((int) map.get(series).stream().filter(x->!x.getBackground()).mapToInt(Work::getNrCitations).sum());
            series.setNrBackgroundPapers((int) map.get(series).stream().filter(Work::getBackground).count());
            series.setNrBackgroundCitations(map.get(series).stream().filter(Work::getBackground).mapToInt(Work::getNrCitations).sum());
        }
        new DistributionPlot<>(base.getListConferenceSeries().stream().filter(x->x.getNrPapers() >0).toList(), ConferenceSeries::getNrPapers).
                ordering(NR).
                width(22).height(10).
                xlabel("Number of Papers in ConferenceSeries").ylabel("Nr ConferenceSeries").
                title("Distribution of ConferenceSeries with a given Number of Papers in Survey").
                generate().latex(tex);

        new BarPlot<>(base.getListConferenceSeries().stream().filter(x -> x.getNrPapers() > limit).toList(),
                this::nameOf,
                ConferenceSeries::getNrPapers).
                width(20).height(10).
                title("Conference Paper Count by Conference Series (Count > "+limit+")").
                xlabel("Conference Series").ylabel("Paper Count").
                generate().latex(tex);
        new BarPlot<>(base.getListConferenceSeries().stream().filter(x -> x.getNrPapers() > limit).toList(),
                this::nameOf,
                ConferenceSeries::getNrCitations).
                width(20).height(10).
                title("Citation Count by Conference Series (Paper Count > "+limit+")").
                xlabel("Conference Series").ylabel("Citation Count").
                generate().latex(tex);
        new BarPlot<>(base.getListConferenceSeries().stream().filter(x -> x.getNrPapers() > limit).toList(),
                this::nameOf,
                x->1.0*x.getNrCitations()/x.getNrPapers()).
                width(20).height(10).
                title("Average Citation Count per Paper by Conference Series (Paper Count > "+limit+")").
                xlabel("Conference Series").ylabel("Average Citation Count").
                generate().latex(tex);

    }
    private void byJournal(String caption,List<Article> work,int limit,double relevanceLimit){
        subsection(caption);
        Map<Journal,List<Article>> map = work.stream().filter(x->isRelevant(x,relevanceLimit)).collect(groupingBy(Article::getJournal));
        for(Journal j:map.keySet()){
            j.setNrArticles((int) map.get(j).stream().filter(x->!x.getBackground()).count());
            j.setNrCitations(map.get(j).stream().filter(x->!x.getBackground()).mapToInt(Work::getNrCitations).sum());
            j.setNrBackgroundArticles((int) map.get(j).stream().filter(Work::getBackground).count());
            j.setNrBackgroundCitations(map.get(j).stream().filter(Work::getBackground).mapToInt(Work::getNrCitations).sum());
        }
        new DistributionPlot<>(base.getListJournal().stream().filter(x->x.getNrArticles() >0).toList(), Journal::getNrArticles).
                ordering(NR).
                width(22).height(10).
                xlabel("Number of Articles in Journal").ylabel("Nr Journals").
                title("Distribution of Journals with a given Number of Articles in Survey ("+caption+")").
                generate().latex(tex);
        new BarPlot<>(base.getListJournal().stream().
                filter(x -> x.getNrArticles() > limit).
                sorted(Comparator.comparing(Journal::getNrArticles).reversed()).
                limit(30).
                toList(),
                x->safe(x.getName()).replaceAll(",",""),
                Journal::getNrArticles).
                width(22).height(10).
                title(caption +" Count by Journal (Count > "+limit+")").
                xlabel("Journal").ylabel("Article Count").
                generate().latex(tex);
        new BarPlot<>(base.getListJournal().stream().
                filter(x -> x.getNrArticles() > limit).
                sorted(Comparator.comparing(Journal::getNrArticles).reversed()).
                limit(30).toList(),
                x->safe(x.getName()).replaceAll(",",""),
                Journal::getNrCitations).
                width(22).height(10).
                title("Citation Count by Journal (Article Count > "+limit+")").
                xlabel("Journal").ylabel("Citation Count").
                generate().latex(tex);
        new BarPlot<>(base.getListJournal().stream().
                filter(x -> x.getNrArticles() > limit).
                sorted(Comparator.comparing(Journal::getNrArticles).reversed()).
                limit(30).toList(),
                x->safe(x.getName()).replaceAll(",",""),
                x->1.0*x.getNrCitations()/x.getNrArticles()).
                width(22).height(10).
                title("Average Citation Count per Article by Journal (Article Count > "+limit+")").
                xlabel("Journal").ylabel("Average Citation Count").
                generate().latex(tex);

    }

    private boolean isRelevant(Work w,double relevanceLimit){
        return w.getRelevanceBody() >= relevanceLimit || (w.getRelevanceBody()==0.0 && w.getRelevanceAbstract() >= relevanceLimit);
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
                ordering(NR).
                width(20).height(10).
                title("Number of Co-Authors per Work").
                xlabel("Nr Co-Authors").ylabel("Count").
                generate().latex(tex);
    }
    private void workDistributionPlot(List<Author> authors){
        new DistributionPlot<>(authors, Author::getNrWorks).
                ordering(NR).
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

        paragraph("This section gives an overall overview of the works covered by the survey. We first look at " +
                "all works, and consider which entries cannot be full analyzed. We consider the following status " +
                "outcomes: no DOI, the bib entry does not give a DOI, this typically means that we cannot find the " +
                "citation and reference counts for the work. A special case is the Thesis type, which typically do not have a " +
                "DOI assigned by the university. Even entries with a DOI may not be covered, we distinguish entries " +
                "that are covered by neither Crossref nor Scopus, or entries which are covered by one, but not " +
                "the other. The OK status indicates that we can find the entry in all our sources.");
        paragraph("Note that OpenCitations does not distinguish between a DOI that is not covered, and a DOI for " +
                "which there are no references or citations. In both cases, an empty list is returned by the query.");
        paragraph("We may be able to repair some of the entries by finding a DOI for entries which miss them, " +
                "or by correcting a mistake in a DOI, where neither Crossref nor Scopus recognizes the entry. Note " +
                "that the system responses are cached, and missing entries are not repeatedly queried by the system. " +
                "This means that additions or corrections in the databases that occur after we first queried them for " +
                "a specific entry are not automatically taken into account. It may be good practice to re-run all " +
                "queries from time to time to reflect updates in the databases.");

        int d = base.getListWork().size();
        new DistributionPlot<>(base.getListWork().stream().filter(x -> !x.getBackground()).toList(), this::workStatus).
                includeZero(true).
                title("Data Quality (Total " + d + " Works)").
                xlabel("Status").ylabel("Nr Works").
                width(15).height(12).
                generate().latex(tex);

        List<Work> neither = base.getListWork().stream().
                filter(x -> x.getDoiStatus() && !x.getCrossrefStatus() && !x.getScopusStatus()).
                sorted(Comparator.comparing(Work::getYear).reversed()).
                toList();

        listWorks("Works Unknown to Crossref and Scopus", neither);

        List<Work> noCrossref = base.getListWork().stream().
                filter(x -> x.getDoiStatus() && !x.getCrossrefStatus() && x.getScopusStatus()).
                sorted(Comparator.comparing(Work::getYear).reversed()).
                toList();
        listWorks("Works Unknown to Crossref", noCrossref);

        List<Work> noScopus = base.getListWork().stream().
                filter(x -> x.getDoiStatus() && x.getCrossrefStatus() && !x.getScopusStatus()).
//                limit(20).
                sorted(Comparator.comparing(Work::getYear).reversed()).
                toList();
        listWorks("Works Unknown to Scopus", noScopus);

        subsection("Range of Citation Counts");

        paragraph("We get citation counts for the works included in the survey from different sources. " +
                "OpenCitations provides the set of papers citing a reference, but only if both have DOIs. " +
                "Crossref gives a count of how many papers cite a reference, they include some papers without DOI. " +
                "Scopus gives a citation count, but does not give access to the actual citations. In this table we " +
                "show the works with the largest range of citation count, excluding all background works. A typical " +
                "issue is that one source does not cover the work, and has a zero count. An alternative is where " +
                "papers with many citations give a slightly different count depending on which links are included in " +
                "their database.");
        paragraph("The results seem to indicate the using multiple sources is required, to avoid leaving out " +
                "works that are not covered by one specific source. Note that the WoS numbers are only present for a " +
                "few works, we show them, but do not include them in computing range.");

        List<Work> maxRangeList = base.getListWork().stream().
                filter(x->!x.getBackground()).
                sorted(Comparator.comparing(Work::getRangeCitations).reversed()).
                limit(50).
                toList();
        listWorks("Works with largest Range of Citation Counts",maxRangeList);

        paragraph("We only have Web of Science data in a few bibtex entries, we here try to evaluate their citation numbers on those bib entries which are from WoS.");
        List<Work> wosList = base.getListWork().stream().
                filter(x->!x.getBackground()).
                filter(Work::getWosStatus).
                sorted(Comparator.comparing(Work::getMaxCitations).reversed()).
                limit(50).
                toList();
        listWorks("Works with WoS Citation Counts",wosList);


        subsection("Local Copies");

        paragraph("The tool relies on local pdf copies of works to perform a detailed analysis of the content " +
                "of the work. We have collected our own private copies of works for that purpose. The following plot " +
                "shows how many entries do not have a local copy, or which do not extract any concepts from the local " +
                "copy. A detailed list of all missing entries is given in " +
                "the main report. Note that in some cases we use an open access version of the work, which might " +
                "differ slightly from the published version. ");

        new DistributionPlot<>(base.getListWork(),this::hasLocalCopy).
                includeZero(true).
                title("Work has Local Copy (Total "+base.getListWork().size()+" Works)").
                xlabel("Status").ylabel("Nr Works").
                width(8).height(12).generate().latex(tex);

        subsection("Presence of Abstracts");

        new DistributionPlot<>(base.getListWork(),this::hasAbstract).
                includeZero(true).
                title("Work has Abstract (Total "+base.getListWork().size()+" Works)").
                xlabel("Status").ylabel("Nr Works").
                width(8).height(12).generate().latex(tex);

        subsection("Orphan Files");

        paragraph("The following list shows entries for which we have a pdf file in the works directory, but " +
                "the name of hte file does not match any key in the bibliography. These orphans should be resolved, " +
                "either by correcting the name, or adding a bib entry for the work, or by removing the file, " +
                "if it is not required.");
        paragraph("If there are no files listed, then all pdf files in the works directory correspond to a " +
                "bib entry, and no clean-up is required.");

        new TableDraw<>("Orphan Files",base.getListOrphan()).
                addStringColumn("Key", this::nameOf).
                addStringColumn("File",x->safe(x.getFileName())).
                tableStyle(TableStyle.LONGTABLE).
                generate().latex(tex);

    }

    private String hasAbstract(Work w){
        if (w.getAbstractText() != null && !w.getAbstractText().equals("")) {
            return "Yes";
        }
        return "No";
    }

    private String hasLocalCopy(Work w){
        if (w.getLocalCopy() != null && !w.getLocalCopy().equals("") && w.getNrConcepts() >0){
            return "Yes";
        }
        if (w.getLocalCopy() != null && !w.getLocalCopy().equals("") && w.getNrConcepts() ==0){
            return "No Concepts";
        }
        return "No";
    }

    private void listWorks(String caption,List<Work> list){
        new TableDraw<>(caption,list).
                addStringColumn("Key",Work::getKey).
                addStringColumn("DOI",this::safeDoi).
                addStringColumn("Source Group",x->nameOf(x.getSourceGroup())).
                addIntegerColumn("Year",Work::getYear).
                addIntegerColumn(st("Nr","Citations"),Work::getNrCitations).
                addIntegerColumn(st("Crossref","Citations"),Work::getCrossrefCitations).
                addIntegerColumn(st("Scopus","Citations"),Work::getScopusCitations).
                addIntegerColumn(st("WoS","Citations"),Work::getWosCitations).
                addIntegerColumn(st("Range","Citations"),Work::getRangeCitations).
                addDoubleColumn(st("Range","Percentage"),this::rangePercentage,"%5.2f").
                tableStyle(TableStyle.LONGTABLE).
                textSize("\\scriptsize").
                generate().
                latex(tex);

    }


    private double rangePercentage(Work w){
        return 100.0*w.getRangeCitations()/w.getMaxCitations();
    }

    private String safeDoi(Work w){
        if (w.getDoi() == null) {
            return "n/a";
        }
        return w.getDoi().replace("_","\\_");
    }
    private String workStatus(Work w){
        if (w.getSourceGroup().getName().equals("Thesis") && !w.getDoiStatus()) {
            return "Thesis No DOI";
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

    private void location() {
        countryOverview();
        paragraph("This section analyzes papers by affiliation, which is given by the Scopus data only. Only works " +
                "which are covered by Scopus are included. We first present the number of papers by country. A paper " +
                "is counted in this analysis (once), if at least one of the affiliations is from the country. Multiple " +
                "affiliations from the same country only count once. The 30 countries with the largest counts are shown.");
        paragraph("Note that one work will be counted for multiple countries, if the affiliations are from " +
                "different countries. So the sum of the bar heights typically exceeds the total number of works considered.");
        byCountry();

        institutionOverview();
        paragraph("The next plot shows the number of papers associated to institutions, as stated in the Scopus " +
                "affiliation. A work is counted, if at least one of the affiliations is from a given institution. " +
                "Due to the format of the Scopus data, we cannot fractionally assign a paper based on the author " +
                "affiliations, each paper is counted one for every institution for which an affiliation is given. If " +
                "some author has multiple affiliations listed, we (mis)count the work for each of them.");
        byInst();
        paragraph("The following plots show for the top 30 countries when the works included were published, " +
                "and how many citations (OpenCitation count) each paper had. The scatter plots are colored by the " +
                "number of references (OpenCitation count), this help to identify surveys more easily. " +
                "The plot gives an indication in which period the work " +
                "from the country falls, and how influential the published works are. The x and y ranges of all " +
                "plots are uniform to allow comparison between plots.");
        paragraph("It would be nice to have tooltips on the plots, so identify specific works in the plots. " +
                "This is currently not supported by the framework library used.");
        byCountryYear();
    }

    private void institutionOverview(){
        new DistributionPlot<>(base.getListScopusAffiliation(),ScopusAffiliation::getWorkCount).
                ordering(NR).
                width(25).height(12).
                title("Number of Institutions with Given Number of Works (Total "+base.getListScopusAffiliation().size()+" Institutions)").
                xlabel("Nr of Works").ylabel("Number of Institutions").
                generate().latex(tex);
    }
    private void countryOverview(){
        new DistributionPlot<>(base.getListScopusCountry(),ScopusCountry::getNrWorks).
                ordering(NR).
                width(25).height(12).
                title("Number of Countries with Given number of Works (Total "+base.getListScopusCountry().size()+" Countries)").
                xlabel("Nr of Works").ylabel("Number of Countries").
                generate().latex(tex);
    }
    private void byCountry(){
        int d = (int) base.getListWorkAffiliation().stream().map(WorkAffiliation::getWork).distinct().count();
        new BarPlot<>(base.getListScopusCountry().stream().
                sorted(Comparator.comparing(ScopusCountry::getNrWorks).reversed()).
                limit(30).
                toList(), ApplicationObject::getName, ScopusCountry::getNrWorks).
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

    private void byCountryYear(){
        List<Work> allWorks = base.getListWorkAffiliation().stream().
                map(WorkAffiliation::getWork).
                distinct().
                filter(x->!x.getBackground()).
                toList();
        int firstYear = allWorks.stream().mapToInt(Work::getYear).min().orElse(0);
        int lastYear = allWorks.stream().mapToInt(Work::getYear).max().orElse(0);
        int maxCitations = allWorks.stream().mapToInt(Work::getNrCitations).max().orElse(0);

        List<ScopusCountry> countries = base.getListScopusCountry().stream().
                filter(x->x.getWorkCount() >= 20).
                sorted(Comparator.comparing(ScopusCountry::getWorkCount).reversed()).
                toList();
        for(ScopusCountry sc:countries){
            List<Work> works = base.getListWorkAffiliation().stream().
                    filter(x->x.getScopusAffiliation().getScopusCity().getScopusCountry()==sc).
                    map(WorkAffiliation::getWork).
                    distinct().
                    filter(x->!x.getBackground()).
                    toList();
            if (works.size() > 1) {
                new ScatterPlot<>(works,
                        Work::getYear, Work::getNrCitations, Work::getNrReferences).
                        xrange(firstYear,lastYear).
                        yrange(0,maxCitations).
                        title("Nr Citations of Works per Year for Country " + safe(sc.getName()) + " colored by Nr References").
                        xlabel("Year").ylabel("Citations").
                        width(23).height(15).
                        generate().latex(tex);
            }
        }
        List<Work> works = base.getListWorkAffiliation().stream().
                filter(x->!countries.contains(x.getScopusAffiliation().getScopusCity().getScopusCountry())).
                map(WorkAffiliation::getWork).
                distinct().
                filter(x->!x.getBackground()).
                toList();
        if (works.size() > 1) {
            new ScatterPlot<>(works,
                    Work::getYear, Work::getNrCitations, Work::getNrReferences).
                    xrange(firstYear,lastYear).
                    yrange(0,maxCitations).
                    title("Nr Citations of Works per Year for Other Countries colored by Nr References").
                    xlabel("Year").ylabel("Citations").
                    width(25).height(15).
                    generate().latex(tex);
        }


    }

    private String instName(ScopusAffiliation x){
        return safe(x.getInst().replaceAll("\\,",""));
    }

    private void collaborations(){
        paragraph("This section shows data about collaborations between multiple affiliations for the same work. " +
                "This is based on Scopus data, which associates the affiliation with the work, not with each author " +
                "of the work. The analysis excludes background work.");
        Map<Work,List<WorkAffiliation>> map = base.getListWorkAffiliation().stream().
                filter(x->!x.getWork().getBackground()).
                collect(groupingBy(WorkAffiliation::getWork));
        List<Work> affWorks = new ArrayList<>(map.keySet());
        new DistributionPlot<>(affWorks,x->nrOfAffiliations(x,map)).
                ordering(NR).
                title("Works with given Number of Affiliations (Total "+affWorks.size()+" Works)").
                xlabel("Nr Affiliations").ylabel("Nr Works").
                width(25).height(15).
                generate().latex(tex);

        int instNr = 45;
        new TableDraw<>("Collaboration Data (Top "+instNr+" Inst by Decreasing Collab Fraction)",base.getListScopusAffiliation().stream().
                sorted(Comparator.comparing(ScopusAffiliation::getCollabFraction).reversed()).
                limit(instNr).
                toList()).
                addStringColumn("Inst",this::nameOf).
                addIntegerColumn(st("Nr","Works"),ScopusAffiliation::getWorkCount).
                addIntegerColumn(st("Collab","Count"),ScopusAffiliation::getCollabCount).
                addIntegerColumn(st("Domestic","Collab"),ScopusAffiliation::getDomesticCollabCount).
                addIntegerColumn(st("International","Collab"),ScopusAffiliation::getInternationalCollabCount).
                addDoubleColumn(st("Collab","Fraction"),ScopusAffiliation::getCollabFraction,"%5.2f").
                addDoubleColumn(st("Domestic","Fraction"),ScopusAffiliation::getDomesticCollabFraction,"%5.2f").
                addDoubleColumn(st("International","Fraction"),ScopusAffiliation::getInternationalCollabFraction,"%5.2f").
                addDoubleColumn(st("Collab","Percentage"),ScopusAffiliation::getCollabPercentage,"%5.2f").
                addDoubleColumn(st("International","Percentage"),ScopusAffiliation::getInternationalPercentage,"%5.2f").
                textSize("\\scriptsize").
                generate().latex(tex);

        paragraph("The following heatmap is not complete. It needs a symmetric option to count a collaboration for both A-B and B-A.");
        new HeatMap<>(base.getListCollabWork(),
                new HeatMapFunctions<>(x->x.getAffiliation1().getScopusCity().getScopusCountry(),
                        x->x.getAffiliation2().getScopusCity().getScopusCountry(),
                        this::nameOf,
                        this::nameOf),45,50).
                coloring(HeatMapColoring.PERCENTOFMAXIMUM).
                colorSaturation(22).
                caption("Heat Map based on Collaboration between Institutions (Integer Count)").
                generate().latex(tex);

    }

    private void sourceGroups() {

        clearpage();
        section("Citations by Year and Source Group");

        paragraph("We have defined a number of source groups to group publications of a given type together, " +
                "without using the full conference series and journal distinctions for grouping. The following table " +
                "lists all defined source groups for this survey. Adding groups requires updates to the source code.");

        new TableDraw<>("Source Groups",base.getListSourceGroup()).
                addStringColumn("Name",this::nameOf).
                addStringColumn("Description",x->safe(x.getDescription())).
                generate().latex(tex);

        paragraph("The first plot in this section shows how many works in each source group have been published. " +
                "This considers the complete time period of the survey.");

        int d = base.getListWork().size();

        new DistributionPlot<>(base.getListWork(), Work::getSourceGroup).
                title("Works by Source Group (Total " + d + " Works)").
                xlabel("Source Group").ylabel("Nr Works").
                width(25).height(15).
                generate().latex(tex);

        subsection("Source Group Citations by Year");


        paragraph("We plot for each source group the number of citations obtained by papers published in a " +
                "given year. This plot gives both an indication in which period the source group was active, and " +
                "how significant the works in the source are. It is of course natural that more recent papers have " +
                "fewer citations than papers published many tears ago.");

        for (SourceGroup sg : base.getListSourceGroup()) {
            List<Work> works = base.getListWork().stream().filter(x -> x.getSourceGroup() == sg).toList();
            if (works.size() > 1) {
                new ScatterPlot<>(works,
                        Work::getYear, Work::getNrCitations, Work::getNrReferences).
                        title("Nr Citations of Works per Year for Source Group " + safe(sg.getName()) + " colored by Nr References").
                        xlabel("Year").ylabel("Citations").
                        width(25).height(15).
                        generate().latex(tex);
            }
        }

        subsection("Reference Flows");

        paragraph("The following table looks at references between source groups that are contained in the " +
                "survey, i.e. where bot the citing and the cited work is included in the survey. We show how many " +
                "papers referred to in the group on the left belong to the group in the column.");

        new MatrixDraw<>("Reference Flows","referenceflow",
                base.getListSourceGroup().stream().filter(x->x.getFromFlows() >0).toList(),
                base.getListSourceGroup().stream().filter(x->x.getToFlows()>0).toList(),
                base.getListReferenceFlow().stream().filter(x->x.getValue() >0).toList(),
                new MatrixFunctions<>(this::nameOf,this::nameOf,x->x.getValue().toString(), ReferenceFlow::getFrom, ReferenceFlow::getTo)).
                setEmptyCellContent("").
                textSize("\\scriptsize").
                generate().latex(tex);

        paragraph("The entries in the previous table are not directly comparable, without knowing how many " +
                "works are in group. The next table presents a normalized view, where we divide the flow count by the " +
                "product of the group sizes. This produces a likelihood of a paper in the source group citing a paper " +
                "in the target group, given as a percentage from 0 to 100. We can see that the likelihood does not " +
                "depend on the prestige of the target, e.g. papers at AAAI are cited much less than papers in CP.");
        paragraph("Note that the numbers are derived from the flows contained in the survey, which are based on " +
                "the OpenCitation reference links. If such links are missing, or we are missing works in some group, " +
                "then the results will be affected.");
        new MatrixDraw<>("Reference Flows Normalized","referenceflownormalized",
                base.getListSourceGroup().stream().filter(x->x.getFromFlows() >0).toList(),
                base.getListSourceGroup().stream().filter(x->x.getToFlows()>0).toList(),
                base.getListReferenceFlow().stream().filter(x->x.getNormalized() >0).toList(),
                new MatrixFunctions<>(this::nameOf,this::nameOf,x->String.format("%5.2f",x.getNormalized()), ReferenceFlow::getFrom, ReferenceFlow::getTo)).
                setEmptyCellContent("").
                textSize("\\scriptsize").
                generate().latex(tex);

        clearpage();
        section("Contribution of Source Group to Total Works per Year");

        paragraph("The following plots show the percentage of works published in a year belonging to a specific " +
                "source group. This plot helps to understand how important that group is to the field over time");

        List<Integer> years = years(base.getListWork().stream().filter(x->!x.getBackground()).mapToInt(Work::getYear).min().orElse(0),
                base.getListWork().stream().filter(x->!x.getBackground()).mapToInt(Work::getYear).max().orElse(0));
        for (SourceGroup sg : base.getListSourceGroup()) {
            List<Work> works = base.getListWork().stream().filter(x->!x.getBackground()).filter(x -> x.getSourceGroup() == sg).toList();
            if (works.size() > 1) {
                new ScatterPlot<>(years,
                        x->x, x->contribution(x,sg),x->perGroup(x,sg)).
                        title("Percentage Contribution of Source Group " + safe(sg.getName()) + " to all published Work in Year (Colored by number in group)").
                        xlabel("Year").ylabel("Percentage").
                        width(25).height(15).
                        generate().latex(tex);
            }
        }

    }

    private List<Integer> years(int from,int to){
        List<Integer> res = new ArrayList<>();
        for(int i = from; i<=to; i++){
            res.add(i);
        }
        return res;
    }

    private double contribution(int year,SourceGroup sg){
        int total = (int) base.getListWork().stream().
                filter(x->!x.getBackground()).
                filter(x->x.getYear()==year).
                count();
        int perGroup = (int) base.getListWork().stream().
                filter(x->!x.getBackground()).
                filter(x->x.getYear()==year).
                filter(x->x.getSourceGroup()==sg).
                count();
        return (total==0?0:100.0*perGroup/total);
    }
    private int perGroup(int year,SourceGroup sg){
        return (int) base.getListWork().stream().
                filter(x->!x.getBackground()).
                filter(x->x.getYear()==year).
                filter(x->x.getSourceGroup()==sg).
                count();

    }

    private void similarity(){
        //        new HeatMap<>(base.getListSimilarity().stream().filter(x->!Double.isNaN(x.getSimilarity())).toList(),
//                new HeatMapFunctions<>(Similarity::getWork1,
//                        Similarity::getWork2,
//                        this::nameOf,
//                        this::nameOf,
//                        x->(int)Math.round(x.getSimilarity()*1000)),
//                42,22).
//                coloring(HeatMapColoring.PERCENTOFMAXIMUM).
//                colorSaturation(40).
//                caption("Similarity Measure (*1000) based on References and Citations (low = similar)").
//                width(25).height(15).
//                generate().latex(tex);
//        new HeatMap<>(base.getListSimilarity().stream().filter(x->!Double.isNaN(x.getSimilarityConcept())).toList(),
//                new HeatMapFunctions<>(Similarity::getWork1,
//                        Similarity::getWork2,
//                        this::nameOf,
//                        this::nameOf,
//                        x->(int)Math.round(x.getSimilarityConcept())),
//                55,35).
//                coloring(HeatMapColoring.PERCENTOFMAXIMUM).
//                colorSaturation(40).
//                caption("Similarity Measure based on Extracted Concepts (low = similar)").
//                width(25).height(15).
//                generate().latex(tex);

        new HeatMap<>(base.getListSimilarity().stream().
                filter(x->!x.getWork1().getBackground() && !x.getWork2().getBackground()).
                filter(x->!Double.isNaN(x.getDotProduct())).
                filter(x->!Double.isInfinite(x.getDotProduct())).
                toList(),
                new HeatMapFunctions<>(Similarity::getWork1,
                        Similarity::getWork2,
                        this::nameOf,
                        this::nameOf,
                        x->(int)Math.round(x.getDotProduct())),
                42,22).
                coloring(HeatMapColoring.PERCENTOFMAXIMUM).
                colorSaturation(22).
                caption("Heat Map based on rounded DotProduct Similarity of Concepts (high = similar)").
                width(25).height(15).
                generate().latex(tex);

        new HeatMap<>(base.getListSimilarity().stream().
                filter(x->!x.getWork1().getBackground() && !x.getWork2().getBackground()).
                filter(x->!Double.isNaN(x.getCosine())).
                filter(x->!Double.isInfinite(x.getCosine())).
                toList(),
                new HeatMapFunctions<>(Similarity::getWork1,
                        Similarity::getWork2,
                        this::nameOf,
                        this::nameOf,
                        x->(int)Math.round(100.0*x.getCosine())),
                42,22).
                coloring(HeatMapColoring.PERCENTOFMAXIMUM).
                colorSaturation(40).
                caption("Heat Map based on 100*Cosine Similarity of Concepts (high = similar)").
                width(25).height(15).
                generate().latex(tex);

        paragraph("The following distribution plot shows the similarity values between two works based on " +
                "citations and references counts. If either work does not have citation and reference values, then " +
                "the similarity is set to NaN. The total similarity count is the average of the similarity for " +
                "citations and for references. As value we compute the ratio of non-shared references (citations) to " +
                "the sum of individual references (citations). So both the citation and reference " +
                "similarity range between zero and one, and the average ranges between zero and one. Low values are " +
                "very rare, as they require both works to be citing the same papers, and being cited by the " +
                "same papers. A larger value " +
                "indicates that items are less similar according to this measure. In the plot we group values " +
                "into 0.1 wide value bins, so an entry for 0.2 includes values from 0.15 to 0.25.");
        paragraph("We observe that low values of this similarity are often found for two works by the same " +
                "authors that are close in time, where we assumes that the bibliographies in both papers is based on the same " +
                "literature survey. If neither paper is widely cited, the similarity value is low.");
        paragraph("The vast majority of paper pairs has a distance close to one, as their references and citations do not overlap much.");

        new DistributionPlot<>(base.getListSimilarity().stream().
                filter(x->!x.getWork1().getBackground() && !x.getWork2().getBackground()).
                filter(x->!Double.isNaN(x.getSimilarityRef())).
                filter(x->!Double.isInfinite(x.getSimilarityRef())).
                toList(),this::similarRef).
                ordering(LABEL).
                title("Distribution Plot of Distance Values by References (Low value is similar)").
                xlabel("Distance").ylabel("Count").
                width(25).height(15).
                generate().latex(tex);
        new DistributionPlot<>(base.getListSimilarity().stream().
                filter(x->!x.getWork1().getBackground() && !x.getWork2().getBackground()).
                filter(x->!Double.isNaN(x.getSimilarityCite())).
                filter(x->!Double.isInfinite(x.getSimilarityCite())).
                toList(),this::similarCite).
                ordering(LABEL).
                title("Distribution Plot of Distance Values by Citations (Low value is similar)").
                xlabel("Distance").ylabel("Count").
                width(25).height(15).
                generate().latex(tex);
        new DistributionPlot<>(base.getListSimilarity().stream().
                filter(x->!x.getWork1().getBackground() && !x.getWork2().getBackground()).
                filter(x->!Double.isNaN(x.getSimilarity())).
                filter(x->!Double.isInfinite(x.getSimilarity())).
                toList(),this::similar).
                ordering(LABEL).
                title("Distribution Plot of Distance Values by References and Citations (Low value is similar)").
                xlabel("Distance").ylabel("Count").
                width(25).height(15).
                generate().latex(tex);

        paragraph("The similarity by concept uses the Euclidean distance between the feature vectors for two " +
                "works. We translate the MatchLevel for each Concept into a linear scale, and then calculate the " +
                "distances as the square root of the sum of squared differences for each feature. The distribution " +
                "plot below rounds the distances to integer values. Similarity values of this type are only " +
                "calculated when both works have a local copy, from which we extract the features. If either " +
                "work does not have a local copy, the similarity is set to be NaN.");
        new DistributionPlot<>(base.getListSimilarity().stream().
                filter(x->!x.getWork1().getBackground() && !x.getWork2().getBackground()).
                filter(x->!Double.isNaN(x.getSimilarityConcept())).
                filter(x->!Double.isInfinite(x.getSimilarityConcept())).
                toList(),this::similarConcept).
                ordering(LABEL).
                title("Distribution Plot of Euclidean Distance Values by Concept (Low value is similar)").
                xlabel("Distance").ylabel("Count").
                width(25).height(15).
                generate().latex(tex);

        new DistributionPlot<>(base.getListSimilarity().stream().
                filter(x->!x.getWork1().getBackground() && !x.getWork2().getBackground()).
                filter(x->!Double.isNaN(x.getCosine())).
                filter(x->!Double.isInfinite(x.getCosine())).
                toList(),this::similarCosine).
                ordering(LABEL).
                title("Distribution Plot of Cosine Similarity Values by Concept (High value is similar)").
                xlabel("Cosine Similarity Value").ylabel("Count").
                width(25).height(15).
                generate().latex(tex);

        new DistributionPlot<>(base.getListSimilarity().stream().
                filter(x->!x.getWork1().getBackground() && !x.getWork2().getBackground()).
                filter(x->!Double.isNaN(x.getDotProduct())).
                filter(x->!Double.isInfinite(x.getDotProduct())).
                toList(),this::similarDotProduct).
                ordering(DistributionPlotOrdering.NR).
                title("Distribution Plot of Dot Product Similarity Values by Concept (High value is similar)").
                xlabel("DotProduct Similarity Value").ylabel("Count").
                width(25).height(15).
                generate().latex(tex);

    }

    private String similar(Similarity s){
        return similarAsString(s.getSimilarity());
    }
    private String similarRef(Similarity s){
        return similarAsString(s.getSimilarityRef());
    }
    private String similarCite(Similarity s){
        return similarAsString(s.getSimilarityCite());
    }
    private String similarConcept(Similarity s){
        return similarAsString(s.getSimilarityConcept());
    }
    private String similarCosine(Similarity s){
        return similarAsString(s.getCosine());
    }
    private int similarDotProduct(Similarity s){
        return (int) Math.round(s.getDotProduct()/10.0)*10;
    }

    private String similarAsString(double s){
        return String.format("%.2f",Math.round(s*20.0)/20.0);
    }


    private void pageLength(){
        clearpage();
        section("Page Length Distribution");
        List<Work> works = base.getListWork().stream().
                filter(x->!x.getBackground()).
                filter(x->x.getNrPages()!=null).
                toList();
        new DistributionPlot<>(works, Work::getNrPages).
                ordering(NR).
                title("Nr of Works with Given Number of Pages (Total "+works.size()+" entries)").
                xlabel("Number of Pages").ylabel("Nr Works").
                width(24).height(12).
                generate().latex(tex);
    }

    private void relevanceDistribution(){
        clearpage();
        section("Relevance Distribution");
        List<Work> works = base.getListWork().stream().
                filter(x->!x.getBackground()).
                filter(x->x.getRelevanceBody() > 0.0).
                toList();

        new ScatterPlot<>(works, this::cappedBodyRelevance, Work::getRelevanceAbstract, Work::getRelevanceTitle).
                width(22).height(15).
                title("Link between Body and Abstract Relevance (Colored by Title Relevance cutoff at 20.0)").
                xlabel("Body Relevance").ylabel("Abstract Relevance").
                generate().latex(tex);
        new ScatterPlot<>(works.stream().filter(x->x.getRelevanceAbstract() > x.getRelevanceTitle()).toList(),
                this::cappedBodyRelevance, Work::getRelevanceAbstract, Work::getRelevanceTitle).
                width(22).height(15).
                title("Link between Body and Abstract Relevance (Only where Abstract is present)").
                xlabel("Body Relevance").ylabel("Abstract Relevance").
                generate().latex(tex);
        new ScatterPlot<>(works, Work::getRelevanceTitle, Work::getRelevanceAbstract, this::cappedBodyRelevance).
                width(22).height(15).
                title("Link between Title and Abstract Relevance (Colored by Body Relevance)").
                xlabel("Title Relevance").ylabel("Abstract Relevance").
                generate().latex(tex);

        new DistributionPlot<>(works, this::relevanceBodyAsInt).
                ordering(NR).
                title("Nr of Works with Given Body Relevance (Nonzero relevance only Total "+works.size()+" entries cutoff at 20.0)").
                xlabel("Body Relevance").ylabel("Nr Works").
                width(24).height(12).
                generate().latex(tex);


        List<Work> abstracts = base.getListWork().stream().
                filter(x->!x.getBackground()).
                filter(x->x.getRelevanceAbstract() > 0.0).
                toList();

        new DistributionPlot<>(abstracts, this::relevanceAbstractAsInt).
                ordering(NR).
                title("Nr of Works with Given Abstract Relevance (Nonzero relevance only Total "+abstracts.size()+" entries)").
                xlabel("Abstract Relevance").ylabel("Nr Works").
                width(24).height(12).
                generate().latex(tex);

        List<MissingWork> missing = base.getListMissingWork();

        new DistributionPlot<>(missing, this::relevanceAsInt).
                ordering(NR).
                title("Nr of Missing Works with Given Abstract Relevance (Total "+missing.size()+" entries)").
                xlabel("Abstract Relevance").ylabel("Nr Missing Works").
                width(24).height(12).
                generate().latex(tex);

        new ScatterPlot<>(works, this::nrLinks, this::cappedBodyRelevance,Work::getRelevanceAbstract).
                width(22).height(15).
                title("Connection Between Number of Links Inside Survey and Body Relevance (Colored by Abstract Relevance)").
                xlabel("Nr Links").ylabel("Body Relevance").
                generate().latex(tex);

    }

    private int nrLinks(Work w){
        return w.getNrCitationsCovered()+w.getNrReferencesCovered();
    }

    private double cappedBodyRelevance(Work w){
        return Math.min(20.0,w.getRelevanceBody());
    }

    private int relevanceBodyAsInt(Work w){
        int raw = (int) Math.floor(w.getRelevanceBody());
        return Math.min(raw, 20);
    }
    private int relevanceAbstractAsInt(Work w){
        int raw = (int) Math.floor(w.getRelevanceAbstract());
        return Math.min(raw, 20);
    }

    private int relevanceAsInt(MissingWork w){
        int raw = (int) Math.floor(w.getRelevance());
        return Math.min(raw, 20);
    }

}
