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
                String bibDir = "overview/";
                String exportDir = "exports/";
                new ImportConcepts(base,"imports/","concepts.json");
                new ImportBib(base,bibDir,"bib.bib");
                new ImportExtra(base,"imports/","manual.csv");
                new ImportOpenCitations(base,"citations/");
                new ImportOpenReferences(base,"references/");
                new FindMissingCitingWorks(base);
                new FindMissingCitedWorks(base);
                new AuthorCitations(base);

                new RunPDFInfo(base);
                new RunPDFGrep(base);
                new RunPDFInfoURL(base);
                new FindConnectedPapers(base);
                new ListWorks(base,PAPER,exportDir,"papers.tex");
                new ListWorksManual(base,PAPER,exportDir,"papersmanual.tex");
                new ListWorks(base,ARTICLE,exportDir,"articles.tex");
                new ListWorksManual(base,ARTICLE,exportDir,"articlesmanual.tex");
                new ListWorks(base,BOOK,exportDir,"books.tex");
                new ListWorks(base,THESIS,exportDir,"thesis.tex");
                new ListWorks(base,INCOLLECTION,exportDir,"incollection.tex");
                new ListWorks(base,INBOOK,exportDir,"inbook.tex");

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

                return base;
        }

// main entry point for interactive application
        public static void main(String[] args) {
                launch(args);
        }

}
