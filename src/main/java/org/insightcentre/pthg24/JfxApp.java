package org.insightcentre.pthg24;

/*
Generated once, should be extended by user
*/

import framework.ApplicationDatasetInterface;
import framework.ApplicationObjectInterface;
import framework.types.IrishCalendar;
import org.insightcentre.pthg24.analysis.*;
import org.insightcentre.pthg24.datamodel.*;
import org.insightcentre.pthg24.imports.*;
import org.insightcentre.pthg24.pdfgrep.RunPDFGrep;
import org.insightcentre.pthg24.pdfgrep.RunPDFInfo;
import org.insightcentre.pthg24.pdfgrep.RunPDFInfoURL;
import org.insightcentre.pthg24.reports.CoauthorGraph;
import org.insightcentre.pthg24.reports.PublicationReport;

import java.util.Comparator;

import static org.insightcentre.pthg24.datamodel.WorkType.*;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class JfxApp extends GeneratedJfxApp {

// callbacks to add for user interaction that is not generated
// use stubs in GeneratedJFxApp as basis
// callback for ctrl+selection in list
        public void showObject(ApplicationObjectInterface obj){
                super.showObject(obj);
        }

// callback called once at startup to create initial data in application
        @Override
        public ApplicationDatasetInterface minimalDataset() {
                Scenario base = new Scenario();
                IrishCalendar.buildCalendar();
                base.setDirty(false);

                String type = "scheduling"; // others "scheduling" "cars" "mobilehealth"

                // these must be set for each type
                String prefix = "cars/"; // the overall directory where data for this type is kept
                String bibDir = prefix + "imports/"; // the directory where the bib file is placed
                String bibFile = "cars.bib"; // the name of hte bib file to read
                String authors = "Helmut Simonis"; // authors for this particular type
                int coauthorLimit = 2; // how many works an author needs to have to be included in coauthor graph
                int linkCountLimit = 10; // how many links are required to lookup a missing work by its DOI

                switch(type) {
                        case "cars":
                                prefix = "cars/";
                                bibDir = prefix + "imports/";
                                bibFile = "cars.bib";
                                authors = "Helmut Simonis";
                                coauthorLimit = 2;
                                linkCountLimit = 10;
                                break;
                        case "mobilehealth":
                                prefix = "mobilehealth/";
                                bibDir = prefix + "imports/";
                                bibFile = "mobilehealth.bib";
                                authors = "G. Tacadao and B. O'Sullivan and L. Quesada and H. Simonis";
                                coauthorLimit = 2;
                                linkCountLimit = 10;
                                break;
                        case "scheduling":
                                // settings for scheduling are a bit different
                                prefix = "";
                                bibDir = "overview/";
                                bibFile = "bib.bib";
                                authors = "Helmut Simonis and Cemalettin Öztürk";
                                coauthorLimit = 5;
                                linkCountLimit = 5;
                                break;
                        default:
                                severe("Bad type " + type);
                                assert (false);
                }

                // other directories where specific data are stored
                String importDir = prefix+"imports/"; // input dir where input data is kept and work concepts are cached
                String exportDir = prefix+"exports/"; // output dir where latex fragments are created
                String citationsDir = prefix+"citations/"; // input/output dir where citations of works are cached
                String referencesDir = prefix+"references/"; // input/output dir where references for works are cached
                String reportDir = prefix+"reports/"; // output dir where reports are generated
                String worksDir = prefix+"works/"; // input dir containing local copies of works
                String graphvizDir = prefix+"graphviz/"; // output dir for graphviz graphs
                String crossrefDir = prefix+"crossref/"; // input/output dir for crossref records
                String scopusDir = prefix+"scopus/"; // input/output dir for scopus records
                String missingWorkDir = prefix+"missing/"; // input/output dir for missing work crossref records


                new ImportConcepts(base,importDir,"concepts.json");
                new ImportAlias(base,importDir,"alias.json");
                new ImportBib(base,bibDir,bibFile,worksDir);
                new ImportBackground(base,importDir,"background.json");
                new ImportExtra(base,importDir,"manual.csv");
                new ImportOpenCitations(base,citationsDir);
                new ImportOpenReferences(base,referencesDir);
                new ImportCrossref(base,crossrefDir);
                new ImportScopus(base,scopusDir);

                new FindMissingCitingWorks(base);
                new FindMissingCitedWorks(base);
                new FindMissingWorks(base);
                new AuthorCitations(base);

                new RunPDFInfo(base,bibDir);
                new RunPDFGrep(base,importDir);
                new RunPDFInfoURL(base,bibDir);
                new FindConnectedPapers(base);
                new FindCoauthorLinks(base);
                new ListWorks(base,PAPER,exportDir,"papers.tex");
                new ListWorksManual(base,PAPER,exportDir,"papersmanual.tex");
                new ListWorks(base,ARTICLE,exportDir,"articles.tex");
                new ListWorksManual(base,ARTICLE,exportDir,"articlesmanual.tex");
                new ListWorks(base,BOOK,exportDir,"books.tex");
                new ListWorks(base,THESIS,exportDir,"thesis.tex");
                new ListWorks(base,INCOLLECTION,exportDir,"incollection.tex");
                new ListWorks(base,INBOOK,exportDir,"inbook.tex");
                new ListWorks(base,base.getListWork().stream().
                        filter(x->!x.getBackground()).
                        sorted(Comparator.comparing(Work::getNrCitations).reversed()).
                        limit(30).
                        toList(),exportDir,"mostcited.tex");
                new ListWorks(base,base.getListWork().stream().
                        filter(Work::getBackground).
                        sorted(Comparator.comparing(Work::getYear).reversed().thenComparing(Work::getKey)).
                        toList(),exportDir,"background.tex");

                new ListAuthors(base,exportDir,"authors.tex");
                new AnalysisByWork(base,ARTICLE,exportDir,"conceptsarticle.tex");
                new AnalysisByWork(base,PAPER,exportDir,"conceptspaper.tex");
                new AnalysisByWork(base,THESIS,exportDir,"conceptsthesis.tex");
                new AnalysisByWork(base,INCOLLECTION,exportDir,"conceptsincollection.tex");
                new AnalysisByConcept(base,exportDir,"concept");

                new MissingLocalCopy(base,ARTICLE,exportDir,"missingarticle.tex");
                new MissingLocalCopy(base,PAPER,exportDir,"missingpaper.tex");
                new WorkWithoutConcepts(base,ARTICLE,exportDir,"conceptlessarticle.tex");
                new WorkWithoutConcepts(base,PAPER,exportDir,"conceptlesspaper.tex");
                new UnmatchedConcepts(base,exportDir,"unmatchedconcept.tex");
                new KeyOverview(base,exportDir,"keylist.tex");
                new WorksByAuthor(base,exportDir,"worksbyauthor.tex");
                new CoauthorGraph(base,coauthorLimit,graphvizDir,reportDir,"coauthors.pdf");
                new SimilarityMeasure(base);
                new ListSimilarity(base,exportDir,"mostsimilar.tex");
                new LookupMissingWork(base,missingWorkDir,linkCountLimit);
                new ListMissingWork(base,exportDir,"missingwork.tex");
                new ListWorks(base,
                        base.getListWork().stream().
                                filter(x->x.getDoi() == null || x.getDoi().equals("")).
                                sorted(Comparator.comparing(Work::getKey)).
                                toList(),
                        exportDir,"missingdoi.tex");

                if(type.equals("scheduling")){
                        new CreateSourceGroups(base);
                }

                new PublicationReport(base,reportDir).
                        produce("publications",
                                "Publication Report",
                                authors);

                return base;
        }

// main entry point for interactive application
        public static void main(String[] args) {
                launch(args);
        }

}
