package org.insightcentre.pthg24;

/*
Generated once, should be extended by user
*/

import framework.ApplicationDatasetInterface;
import framework.ApplicationObjectInterface;
import framework.types.IrishCalendar;
import org.insightcentre.pthg24.analysis.*;
import org.insightcentre.pthg24.datamodel.*;
import org.insightcentre.pthg24.imports.ImportBib;
import org.insightcentre.pthg24.imports.ImportConcepts;
import org.insightcentre.pthg24.imports.ImportExtra;
import org.insightcentre.pthg24.pdfgrep.RunPDFGrep;
import org.insightcentre.pthg24.pdfgrep.RunPDFInfo;
import org.insightcentre.pthg24.pdfgrep.RunPDFInfoURL;

import static org.insightcentre.pthg24.datamodel.WorkType.ARTICLE;
import static org.insightcentre.pthg24.datamodel.WorkType.PAPER;

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
                String importDir = "overview/grepresult/";
                String exportDir = "exports/";
                new ImportConcepts(base,"imports/","concepts.json");
                new ImportBib(base,bibDir,"bib.bib");
                new ImportExtra(base,"imports/","manual.csv");
//                int nrFiles = 369;
//                new Importer(base,Concepts,importDir,"cfound.txt",42,nrFiles,exportDir,"cmatrix.tex");
//                new Importer(base,Classification,importDir,"c1found.txt",41,nrFiles,exportDir,"c1matrix.tex");
//                new Importer(base,Constraints,importDir,"c2found.txt",13,nrFiles,exportDir,"c2matrix.tex");
//                new Importer(base,CPSystems,importDir,"sfound.txt",18,nrFiles,exportDir,"smatrix.tex");
//                new Importer(base,ProgLanguages,importDir,"pfound.txt",7,nrFiles,exportDir,"pmatrix.tex");
//                new Importer(base,ApplicationAreas,importDir,"afound.txt",45,nrFiles,exportDir,"amatrix.tex");
//                new Importer(base,Industries,importDir,"ifound.txt",27,nrFiles,exportDir,"imatrix.tex");
//                new Importer(base,Benchmarks,importDir,"bfound.txt",16,nrFiles,exportDir,"bmatrix.tex");
//                new Importer(base,Algorithms,importDir,"a1found.txt",10,nrFiles,exportDir,"a1matrix.tex");
                new RunPDFInfo(base);
                new RunPDFGrep(base);
                new RunPDFInfoURL(base);
                new FindConnectedPapers(base);
                new ListWorks(base,PAPER,exportDir,"papers.tex");
                new ListWorksManual(base,PAPER,exportDir,"papersmanual.tex");
                new ListWorks(base,ARTICLE,exportDir,"articles.tex");
                new ListWorksManual(base,ARTICLE,exportDir,"articlesmanual.tex");
                new ListAuthors(base,exportDir,"authors.tex");
                new AnalysisByWork(base,ARTICLE,exportDir,"conceptsarticle.tex");
                new AnalysisByWork(base,PAPER,exportDir,"conceptspaper.tex");
                new AnalysisByConcept(base,exportDir,"concept");

                new MissingLocalCopy(base,ARTICLE,exportDir,"missingarticle.tex");
                new MissingLocalCopy(base,PAPER,exportDir,"missingpaper.tex");
                new WorkWithoutConcepts(base,ARTICLE,exportDir,"conceptlessarticle.tex");
                new WorkWithoutConcepts(base,PAPER,exportDir,"conceptlesspaper.tex");
                new UnmatchedConcepts(base,exportDir,"unmatchedconcept.tex");
                new KeyOverview(base,exportDir,"keylist.tex");
                return base;
        }

// main entry point for interactive application
        public static void main(String[] args) {
                launch(args);
        }

}
