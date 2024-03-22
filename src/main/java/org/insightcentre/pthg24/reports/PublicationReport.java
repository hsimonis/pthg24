package org.insightcentre.pthg24.reports;

import framework.reports.visualization.plot.barplot.BarPlot;
import framework.reports.visualization.plot.distributionplot.DistributionPlot;
import framework.reports.visualization.plot.distributionplot.DistributionPlotOrdering;
import framework.reports.visualization.plot.lineplot.LinePlot;
import framework.reports.visualization.plot.lineplot.LinePlotFunctions;
import framework.reports.visualization.tabular.table.TableDraw;
import org.insightcentre.pthg24.analysis.ListWorks;
import org.insightcentre.pthg24.datamodel.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static org.insightcentre.pthg24.logging.LogShortcut.info;

public class PublicationReport extends AbstractReport{
    public PublicationReport(Scenario base, String reportDir){
        super(base,reportDir);
    }

    public void content(){
        bySeries(base.getListPaper().stream().filter(x->!x.getBackground()).collect(Collectors.toList()));
        byJournal(base.getListArticle().stream().filter(x->!x.getBackground()).collect(Collectors.toList()));
        byYear(base.getListWork().stream().filter(x->!x.getBackground()).collect(Collectors.toList()),
                base.getListWork().stream().filter(x->!x.getBackground()).filter(x->x instanceof Paper).collect(Collectors.toList()),
                base.getListWork().stream().filter(x->!x.getBackground()).filter(x->x instanceof Article).collect(Collectors.toList()),
                base.getListWork().stream().filter(x->!x.getBackground()).filter(x->x instanceof PhDThesis).collect(Collectors.toList()));
        coAuthorDistributionPlot(base.getListWork().stream().filter(x->!x.getBackground()).collect(Collectors.toList()));
        workDistributionPlot(base.getListAuthor().stream().filter(x->x.getNrWorks() >0).collect(Collectors.toList()));
        citationDistributionPlot(base.getListWork().stream().filter(x->!x.getBackground()).toList());
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


}
