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
import org.insightcentre.pthg24.imports.Importer;

import static org.insightcentre.pthg24.datamodel.ConceptType.*;

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
                int nrFiles = 369;
                new ImportConcepts(base,"imports/","concepts.json");
                new ImportBib(base,bibDir,"bib.bib");
                new ImportExtra(base,"imports/","manual.csv");
                new Importer(base,Concepts,importDir,"cfound.txt",42,nrFiles,exportDir,"cmatrix.tex");
                new Importer(base,Classification,importDir,"c1found.txt",41,nrFiles,exportDir,"c1matrix.tex");
                new Importer(base,Constraints,importDir,"c2found.txt",13,nrFiles,exportDir,"c2matrix.tex");
                new Importer(base,CPSystems,importDir,"sfound.txt",18,nrFiles,exportDir,"smatrix.tex");
                new Importer(base,ProgLanguages,importDir,"pfound.txt",7,nrFiles,exportDir,"pmatrix.tex");
                new Importer(base,ApplicationAreas,importDir,"afound.txt",45,nrFiles,exportDir,"amatrix.tex");
                new Importer(base,Industries,importDir,"ifound.txt",27,nrFiles,exportDir,"imatrix.tex");
                new Importer(base,Benchmarks,importDir,"bfound.txt",16,nrFiles,exportDir,"bmatrix.tex");
                new Importer(base,Algorithms,importDir,"a1found.txt",10,nrFiles,exportDir,"a1matrix.tex");
                new FindConnectedPapers(base);
                new ListPapers(base,exportDir,"papers.tex");
                new ListPapersManual(base,exportDir,"papersmanual.tex");
                new ListArticles(base,exportDir,"articles.tex");
                new ListArticlesManual(base,exportDir,"articlesmanual.tex");
                new ListAuthors(base,exportDir,"authors.tex");
                new AnalysisByWork(base,exportDir,"work.tex");
                new AnalysisByConcept(base,exportDir,"concept.tex");
                return base;
        }

// main entry point for interactive application
        public static void main(String[] args) {
                launch(args);
        }

}
