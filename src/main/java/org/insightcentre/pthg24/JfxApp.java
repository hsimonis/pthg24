package org.insightcentre.pthg24;

/*
Generated once, should be extended by user
*/

import framework.ApplicationDatasetInterface;
import framework.ApplicationObjectInterface;
import framework.types.IrishCalendar;
import org.insightcentre.pthg24.analysis.*;
import org.insightcentre.pthg24.clustering.DumpFeatures;
import org.insightcentre.pthg24.datamodel.*;
import org.insightcentre.pthg24.imports.*;
import org.insightcentre.pthg24.pdfgrep.RunPDFGrep;
import org.insightcentre.pthg24.pdfgrep.RunPDFInfo;
import org.insightcentre.pthg24.pdfgrep.RunPDFInfoURL;
import org.insightcentre.pthg24.reports.CoauthorGraph;
import org.insightcentre.pthg24.reports.PublicationReport;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.insightcentre.pthg24.datamodel.WorkType.*;
import static org.insightcentre.pthg24.logging.LogShortcut.info;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class JfxApp extends GeneratedJfxApp {

        // set from commandline; use it to change survey
        static String[] args;
        //the following fields are mandatory in the parameter files
        static String type; // name of the survey
        static String prefix; // directory prefix for a survey, typically type+"/"
        static String bibFile; // bibfile containing works to be used, typically type+".bib"
        static String title; // title for the survey
        static String authors; // authors for the survey
        //the following fields are optional; to change edit json parameter file, do not modify value here
        static String otherFile=""; // alternative bibliography for comparison
        static int coauthorLimit = 2; // how many works an author needs to have to be included in coauthor graph
        static int linkCountLimit = 10; // how many links are required to lookup a missing work by its DOI
        static int getLimit=200; // how many Crossref/Scopus lookups from the web are allowed in one run; does not count cache
        static double relevanceLimit = 0.8; // which raw abstract relevance limit is enough to include
        static int abstractRelevanceCutoff = 1000; // which raw body relevance value should be mapped to 1.0
        static int bodyRelevanceCutoff = 900; // which raw body relevance value should be mapped to 1.0


         public void showObject(ApplicationObjectInterface obj){
                super.showObject(obj);
        }

// callback called once at startup to create initial data in application
        @Override
        public ApplicationDatasetInterface minimalDataset() {
                Scenario base = new Scenario();
                IrishCalendar.buildCalendar();
                base.setDirty(false);
                new CreateTranslators(base);

                assert(args.length==1);
                readParameters(args[0]);
                assert(prefix.endsWith("/"));

                // derived directories where specific data are stored
                String bibDir = prefix + "imports/"; // the directory where the bib file is placed
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
                String dumpDir = prefix+"dump/"; // output directory for feature tables
                boolean dirsExist = checkDirectories(prefix,bibDir,importDir,exportDir,citationsDir,referencesDir,
                        reportDir,worksDir,graphvizDir,crossrefDir,scopusDir,missingWorkDir,dumpDir);
                assert(dirsExist);

                new ImportConcepts(base,importDir,"concepts.json");
                new ImportAlias(base,importDir,"alias.json");
                new ImportConferenceSeries(base,importDir,"conferenceseries.json");
                new ImportBib(base,bibDir,bibFile,worksDir);
                new ImportOther(base,bibDir,otherFile);
                new ImportBackground(base,importDir,"background.json");
                new ImportExtra(base,importDir,"manual.csv");
                new ImportBlocked(base,importDir,"blocked.json");
                new ImportOpenCitations(base,citationsDir);
                new ImportOpenReferences(base,referencesDir);
                new ImportCrossref(base,crossrefDir,missingWorkDir);
                new ImportScopus(base,scopusDir,missingWorkDir);
                new RangeMaxCitations(base);

                new FindMissingCitingWorks(base);
                new FindMissingCitedWorks(base);
                new FindMissingWorks(base);
                new AuthorCitations(base);

                new RunPDFInfo(base,bibDir);
                new RunPDFGrep(base,importDir);
                new RunPDFInfoURL(base,bibDir);
                new FindConnectedPapers(base);
                new FindCoauthorLinks(base);

                new SimilarityMeasure(base);
                new LookupMissingWork(base,missingWorkDir,linkCountLimit,getLimit);
                new ComputeRelevance(base,type,abstractRelevanceCutoff,bodyRelevanceCutoff);
//                new CheckAuthorDoubles(base);
                new CreateCountryCollab(base);

                info("File output starting");

                new TitleFields(exportDir,"title.tex",title,authors);
                new Biblio(exportDir,"biblio.tex",bibFile);
                new CreateMakefile(prefix,"Makefile",type);

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
                        sorted(Comparator.comparing(Work::getMaxCitations).reversed()).
                        limit(30).
                        toList(),exportDir,"mostcited.tex","Most Cited Works");
                new ListWorks(base,base.getListWork().stream().
                        filter(x->!x.getBackground()).
                        filter(x->x.getRelevanceBody() >= 1.0).
                        sorted(Comparator.comparing(Work::getMaxCitations).reversed()).
                        limit(30).
                        toList(),exportDir,"mostcitedrelevant.tex","Most Cited Relevant Works");
                new ListWorks(base,base.getListWork().stream().
                        filter(x->!x.getBackground()).
                        sorted(Comparator.comparing(Work::getRelevanceBody).reversed()).
                        limit(30).
                        toList(),exportDir,"mostrelevant.tex","Most Relevant Works");
                new ListWorks(base,base.getListWork().stream().
                        filter(x->!x.getBackground()).
                        sorted(Comparator.comparing(this::nrConnected).reversed()).
                        limit(30).
                        toList(),exportDir,"mostconnected.tex","Most Connected Works");
                new ListWorks(base,base.getListWork().stream().
                        filter(x->!x.getBackground()).
                        filter(x->x.getNrPages()!=null).
                        sorted(Comparator.comparing(Work::getNrPages).reversed()).
                        limit(30).
                        toList(),exportDir,"longest.tex","Longest Works");
                new ListWorks(base,base.getListWork().stream().
                        filter(Work::getBackground).
                        sorted(Comparator.comparing(Work::getYear).reversed().thenComparing(Work::getKey)).
                        toList(),exportDir,"background.tex","Background Works");


                new ListAuthors(base,exportDir,"authors.tex");
                new ListByConcept(base,exportDir,"concepts.tex");


                new ListMissingLocalCopy(base,ARTICLE,exportDir,"missingarticle.tex");
                new ListMissingLocalCopy(base,PAPER,exportDir,"missingpaper.tex");
                new ListMissingLocalCopy(base,INBOOK,exportDir,"missinginbook.tex");
                new ListMissingLocalCopy(base,INCOLLECTION,exportDir,"missingincollection.tex");
                new WorkWithoutConcepts(base,ARTICLE,exportDir,"conceptlessarticle.tex");
                new WorkWithoutConcepts(base,PAPER,exportDir,"conceptlesspaper.tex");
                new WorkWithoutConcepts(base,INBOOK,exportDir,"conceptlessinbook.tex");
                new WorkWithoutConcepts(base,INCOLLECTION,exportDir,"conceptlessincollection.tex");
                new UnmatchedConcepts(base,exportDir,"unmatchedconcept.tex");
                new KeyOverview(base,exportDir,"keylist.tex");
                new WorksByAuthor(base,exportDir,"worksbyauthor.tex");
                new CoauthorGraph(base,coauthorLimit,graphvizDir,reportDir,"coauthors.pdf");
                new ListSimilarity(base,exportDir,"mostsimilar.tex");

                new ListMissingWork(base,exportDir,"missingwork.tex",
                        "excludedwork.tex",
                        "connectedwork.tex",
                        relevanceLimit);
                new ListConceptsByWork(base,ARTICLE,exportDir,"conceptsarticle.tex");
                new ListConceptsByWork(base,PAPER,exportDir,"conceptspaper.tex");
                new ListConceptsByWork(base,THESIS,exportDir,"conceptsthesis.tex");
                new ListConceptsByWork(base,INBOOK,exportDir,"conceptsinbook.tex");
                new ListConceptsByWork(base,INCOLLECTION,exportDir,"conceptsincollection.tex");

                List<Work> lowNrConcepts = base.getListWork().stream().
                        filter(this::hasLocalCopy).
                        filter(x->!x.getBackground()).
                        filter(x->x.getNrPages() != null).
                        filter(x->x.getNrPages() >2).
                        filter(x->x.getNrConcepts() > 0).
                        sorted(Comparator.comparing(Work::getNrConcepts)).
                        limit(30).
                        toList();
                new ListWorks(base,lowNrConcepts,exportDir,"lownrworks.tex","Works with Low Feature Count");
                new ListConceptsByWork(base,lowNrConcepts,exportDir,"lownrconcepts.tex","Features of Works with Low Feature Count");
                List<Work> irrelevant = base.getListWork().stream().
                        filter(x->!x.getBackground()).
                        filter(this::hasLocalCopy).
                        filter(x->x.getNrPages() != null).
                        filter(x->x.getNrPages() >2).
                        sorted(Comparator.comparing(Work::getRelevanceBody)).
                        limit(30).
                        toList();
                new ListWorks(base,irrelevant,exportDir,"irrelevantworks.tex","Works that might be Irrelevant");
                new ListConceptsByWork(base,irrelevant,exportDir,"irrelevantconcepts.tex","Features of Works that might be Irrelevant");

                new ListWorks(base,
                        base.getListWork().stream().
                                filter(x->x.getDoi() == null || x.getDoi().equals("")).
                                sorted(Comparator.comparing(Work::getKey)).
                                toList(),
                        exportDir,"missingdoi.tex","Works with Missing DOI");

                List<Work> similar = similarWorks(base,20);
                new ListWorks(base,similar,exportDir,"similarworks.tex","Works Close by Euclidean Distance");
                new ListConceptsByWork(base,similar,exportDir,"similarconcepts.tex","Features of Work Close by Euclidean Distance");
                List<Work> dot = dotWorks(base,20);
                new ListWorks(base,dot,exportDir,"dotworks.tex","Works Similar by Dot Product");
                new ListConceptsByWork(base,dot,exportDir,"dotconcepts.tex","Features of Works Similar by Dot Product");
                List<Work> cosine = cosineWorks(base,20);
                new ListWorks(base,cosine,exportDir,"cosineworks.tex","Works Similar by Cosine Similarity");
                new ListConceptsByWork(base,cosine,exportDir,"cosineconcepts.tex","Features of Works Similar by Cosine Similarity");
                new ListAcronyms(base,exportDir,"acronyms.tex");



                new CreateSourceGroups(base,type);
                // only set this to true if you want to remove all currently unused files
                new OrphanFiles(base,worksDir,".pdf",false);
                new OrphanFiles(base,crossrefDir,".json",false);
                new OrphanFiles(base,scopusDir,".xml",false);
                new CreateCollabWorks(base);

                new PublicationReport(base,reportDir,coauthorLimit).
                        produce("publications",
                                "Publication Report for "+type+" Survey",
                                authors);

                //??? these require attributes set by Publication Report
                new ListPapersByConferenceSeries(base,exportDir,"byseries.tex");
                new ListArticlesByJournal(base,exportDir,"byjournal.tex");

                new ListDetails(base,exportDir,"abstracts.tex",1.0,1.0);

                new ListAbstractsMissingWork(base,exportDir,"abstractsmissingwork.tex",relevanceLimit);

                new CitationGraph(base);
                new DumpFeatures(base,dumpDir,"allconcepts.csv");
                new ExtractSelectedBib(base,dumpDir,"suggested.bib");

                new UnknownConferenceSeries(base,dumpDir,"unknown.json");

                new CheckInconsistentConcepts(base);
//                new FindOthers(base);
//                new ExtractOtherBib(base,dumpDir,"otherselected.bib");
                new ListAuthorsByConference(base,exportDir,"authorsbyconference.tex");
                new ListAuthorsByJournal(base,exportDir,"authorsbyjournal.tex");

                info("analysis finished");

                return base;
        }

// main entry point for interactive application
        public static void main(String[] args) {
                JfxApp.args = args;
                launch(args);
        }


        private int nrConnected(Work w){
                return w.getNrCitationsCovered()+w.getNrCitationsCovered();
        }

        private boolean hasLocalCopy(Work w){
                return w.getLocalCopy() != null && !w.getLocalCopy().equals("");
        }

        private List<Work> similarWorks(Scenario base,int limit){
                List<Work> res = new ArrayList<>();
                for(Similarity s:base.getListSimilarity().stream().
                        filter(x->!x.getWork1().getBackground() && !x.getWork2().getBackground()).
                        filter(x->!Double.isNaN(x.getSimilarityConcept())).
                        filter(x->!Double.isInfinite(x.getSimilarityConcept())).
                        sorted(Comparator.comparing(Similarity::getSimilarityConcept)).
                        limit(limit).
                        toList()){
                        res.add(s.getWork1());
                        res.add(s.getWork2());
                }
                return res;

        }
        private List<Work> dotWorks(Scenario base,int limit){
                List<Work> res = new ArrayList<>();
                for(Similarity s:base.getListSimilarity().stream().
                        filter(x->!x.getWork1().getBackground() && !x.getWork2().getBackground()).
                        filter(x->!Double.isNaN(x.getDotProduct())).
                        filter(x->!Double.isInfinite(x.getDotProduct())).
                        filter(x->x.getDotProduct() > 0).
                        sorted(Comparator.comparing(Similarity::getDotProduct).reversed()).
                        limit(limit).
                        toList()){
                        res.add(s.getWork1());
                        res.add(s.getWork2());
                }
                return res;

        }
        private List<Work> cosineWorks(Scenario base,int limit){
                List<Work> res = new ArrayList<>();
                for(Similarity s:base.getListSimilarity().stream().
                        filter(x->!x.getWork1().getBackground() && !x.getWork2().getBackground()).
                        filter(x->!Double.isNaN(x.getCosine())).
                        filter(x->!Double.isInfinite(x.getCosine())).
                        filter(x->x.getCosine() > 0).
                        sorted(Comparator.comparing(Similarity::getCosine).reversed()).
                        limit(limit).
                        toList()){
                        res.add(s.getWork1());
                        res.add(s.getWork2());
                }
                return res;

        }


        private boolean checkDirectories(String prefix,String bibDir,String importDir,String exportDir,
                                      String citationsDir,String referencesDir,String reportDir,String worksDir,
                                      String graphvizDir,String crossrefDir,String scopusDir,String missingWorkDir,String dumpDir) {
                boolean res = true;
                res &= existsOrCreate(prefix);
                res &= existsOrCreate(bibDir);
                res &= existsOrCreate(importDir);
                res &= existsOrCreate(exportDir);
                res &= existsOrCreate(citationsDir);
                res &= existsOrCreate(referencesDir);
                res &= existsOrCreate(reportDir);
                res &= existsOrCreate(worksDir);
                res &= existsOrCreate(graphvizDir);
                res &= existsOrCreate(crossrefDir);
                res &= existsOrCreate(scopusDir);
                res &= existsOrCreate(missingWorkDir);
                res &= existsOrCreate(dumpDir);
                return res;
        }

        private boolean existsOrCreate(String dir){
                Path path = Paths.get(dir);
                try {
                        if (!Files.exists(path)){
                                Files.createDirectory(path);
                                return false;
                        }
                } catch (IOException e){
                        severe("Cannot create directory "+dir+", exception "+e.getMessage());
                        assert(false);
                        return false;
                }
                return true;
        }

        private void readParameters(String parameterFile) {
                try {
                        String text = new String(Files.readAllBytes(Paths.get(parameterFile)));
                        JSONObject obj = new JSONObject(text);
                        type = obj.getString("type");
                        prefix = obj.getString("prefix");
                        bibFile = obj.getString("bibFile");
                        title = obj.getString("title");
                        authors = obj.getString("authors");
                        if (obj.has("otherFile")) {
                                otherFile = obj.getString("otherFile");
                        }
                        if (obj.has("coauthorLimit")) {
                                coauthorLimit = obj.getInt("coauthorLimit");
                        }
                        if (obj.has("linkCountLimit")) {
                                linkCountLimit = obj.getInt("linkCountLimit");
                        }
                        if (obj.has("getLimit")) {
                                getLimit = obj.getInt("getLimit");
                        }
                        if (obj.has("abstractRelevanceCutoff")) {
                                abstractRelevanceCutoff = obj.getInt("abstractRelevanceCutoff");
                        }
                        if (obj.has("bodyRelevanceCutoff")) {
                                bodyRelevanceCutoff = obj.getInt("bodyRelevanceCutoff");
                        }
                        if (obj.has("relevanceLimit")) {
                                relevanceLimit = obj.getDouble("relevanceLimit");
                        }
                } catch (IOException e) {
                        severe("Cannot read parameter file " + parameterFile + ", exception " + e.getMessage());
                        assert (false);
                }
        }


}
