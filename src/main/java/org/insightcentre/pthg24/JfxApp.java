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
import org.insightcentre.pthg24.reports.PublicationReport;

import java.util.Comparator;

import static org.insightcentre.pthg24.datamodel.WorkType.*;

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
//                String prefix ="cars/";
//                String bibFile = "cars.bib";

                String prefix ="";
                String bibFile = "bib.bib";

                String bibDir = "overview/";
                String importDir = prefix+"imports/";
                String exportDir = prefix+"exports/";
                String citationsDir = prefix+"citations/";
                String referencesDir = prefix+"references/";
                String reportDir = prefix+"reports/";
                String worksDir = prefix+"works/";


                new ImportConcepts(base,importDir,"concepts.json");
                new ImportAlias(base,importDir,"alias.json");
                new ImportBib(base,bibDir,bibFile,worksDir);
                new ImportBackground(base,importDir,"background.json");
                new ImportExtra(base,importDir,"manual.csv");
                new ImportOpenCitations(base,citationsDir);
                new ImportOpenReferences(base,referencesDir);
                new FindMissingCitingWorks(base);
                new FindMissingCitedWorks(base);
                new AuthorCitations(base);

                new RunPDFInfo(base,bibDir);
                new RunPDFGrep(base,importDir);
                new RunPDFInfoURL(base,bibDir);
                new FindConnectedPapers(base);
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

                new PublicationReport(base,reportDir).
                        produce("publications",
                                "Publication Report",
                                "H. Simonis and Cemalettin Öztürk");

                return base;
        }

// main entry point for interactive application
        public static void main(String[] args) {
                launch(args);
        }

}
