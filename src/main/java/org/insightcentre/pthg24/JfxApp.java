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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
                new CreateTranslators(base);

                String type = "terrorism"; // others "scheduling" "cars" "mobilehealth","terrorism"

                // these must be set for each type
                String prefix = "cars/"; // the overall directory where data for this type is kept
                String bibDir = prefix + "imports/"; // the directory where the bib file is placed
                String bibFile = "cars.bib"; // the name of hte bib file to read
                String authors = "Helmut Simonis"; // authors for this particular type
                int coauthorLimit = 2; // how many works an author needs to have to be included in coauthor graph
                int linkCountLimit = 10; // how many links are required to lookup a missing work by its DOI
                double citingSurveyWeight = 1.0;
                double citedBySurveyWeight=1.0;
                double citationCountWeight = 1e-6;
                double keywordWeight = 1.0;
                double authorWeight = 0.1;
                double ageWeight = 0.1;
                String[] wordList = new String[]{};
                String[] conceptTypes = new String[]{};

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
                        case "terrorism":
                                prefix = "terrorism/";
                                bibDir = prefix + "imports/";
                                bibFile = "terrorism.bib";
                                authors = "B. O'Sullivan and H. Simonis";
                                coauthorLimit = 2;
                                linkCountLimit = 1;
                                citingSurveyWeight = 100;
                                keywordWeight = 1;
                                ageWeight=0.0;
                                wordList = new String[]{"Terror","terror","Insurgency","insurgency","Opponent",
                                        "AI","Artificial Intelligence","Forecasting","Learn","Computational",
                                        "Predictive","Markov Model"};
                                conceptTypes=new String[]{"AIMethod","Terrorism","Group","Region","Objective","System"};
                                break;
                        case "scheduling":
                                // settings for scheduling are a bit different
                                prefix = "";
                                bibDir = "overview/";
                                bibFile = "bib.bib";
                                authors = "Helmut Simonis and Cemalettin Öztürk";
                                coauthorLimit = 5;
                                linkCountLimit = 5;
                                wordList = new String[]{"Scheduling","scheduling",
                                        "CP","CLP","CSP","COP","Constraint Programming",
                                        "Constraint Logic Programming","Constraint Satisfaction"};
                                conceptTypes = new String[]{"Scheduling","CP","Concepts","Classification","Constraints","ApplicationAreas","Industries","CPSystems","Benchmarks","Algorithms"};
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
                String dumpDir = prefix+"dump/"; // output directory for feature tables
                createConceptTypes(base,conceptTypes);


                new ImportConcepts(base,importDir,"concepts.json");
                new ImportAlias(base,importDir,"alias.json");
                new ImportBib(base,bibDir,bibFile,worksDir);
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
                        filter(Work::getBackground).
                        sorted(Comparator.comparing(Work::getYear).reversed().thenComparing(Work::getKey)).
                        toList(),exportDir,"background.tex","Background Works");


                new ListAuthors(base,exportDir,"authors.tex");
                new AnalysisByWork(base,ARTICLE,exportDir,"conceptsarticle.tex");
                new AnalysisByWork(base,PAPER,exportDir,"conceptspaper.tex");
                new AnalysisByWork(base,THESIS,exportDir,"conceptsthesis.tex");
                new AnalysisByWork(base,INCOLLECTION,exportDir,"conceptsincollection.tex");
                new AnalysisByConcept(base,exportDir,"concepts.tex");

                List<Work> lowNrConcepts = base.getListWork().stream().
                        filter(this::hasLocalCopy).
                        filter(x->!x.getBackground()).
                        filter(x->x.getNrPages() != null).
                        filter(x->x.getNrPages() >2).
                        filter(x->x.getNrConcepts() > 0).
                        sorted(Comparator.comparing(Work::getNrConcepts)).
                        limit(20).
                        toList();
                new ListWorks(base,lowNrConcepts,exportDir,"lownrworks.tex","Works with Low Feature Count");
                new AnalysisByWork(base,lowNrConcepts,exportDir,"lownrconcepts.tex","Features of Works with Low Feature Count");
                List<Work> irrelevant = base.getListWork().stream().
                        filter(x->!x.getBackground()).
                        filter(this::hasLocalCopy).
                        filter(x->x.getNrConcepts() > 0).
                        filter(x->irrelevant(x,base)).
                        sorted(Comparator.comparing(Work::getYear).reversed()).
                        toList();
                new ListWorks(base,irrelevant,exportDir,"irrelevantworks.tex","Works that might be Irrelevant");
                new AnalysisByWork(base,irrelevant,exportDir,"irrelevantconcepts.tex","Features of Works that might be Irrelevant");

                new MissingLocalCopy(base,ARTICLE,exportDir,"missingarticle.tex");
                new MissingLocalCopy(base,PAPER,exportDir,"missingpaper.tex");
                new MissingLocalCopy(base,INBOOK,exportDir,"missinginbook.tex");
                new WorkWithoutConcepts(base,ARTICLE,exportDir,"conceptlessarticle.tex");
                new WorkWithoutConcepts(base,PAPER,exportDir,"conceptlesspaper.tex");
                new WorkWithoutConcepts(base,INBOOK,exportDir,"conceptlessinbook.tex");
                new UnmatchedConcepts(base,exportDir,"unmatchedconcept.tex");
                new KeyOverview(base,exportDir,"keylist.tex");
                new WorksByAuthor(base,exportDir,"worksbyauthor.tex");
                new CoauthorGraph(base,coauthorLimit,graphvizDir,reportDir,"coauthors.pdf");
                new SimilarityMeasure(base);
                new ListSimilarity(base,exportDir,"mostsimilar.tex");
                new LookupMissingWork(base,missingWorkDir,linkCountLimit);

                new ComputeRelevance(base,type,citingSurveyWeight,citedBySurveyWeight, citationCountWeight,keywordWeight,authorWeight,ageWeight);
                new ListMissingWork(base,exportDir,"missingwork.tex",wordList);

                new ListWorks(base,
                        base.getListWork().stream().
                                filter(x->x.getDoi() == null || x.getDoi().equals("")).
                                sorted(Comparator.comparing(Work::getKey)).
                                toList(),
                        exportDir,"missingdoi.tex","Works with Missing DOI");

                List<Work> similar = similarWorks(base,20);
                new ListWorks(base,similar,exportDir,"similarworks.tex","Works Close by Euclidean Distance");
                new AnalysisByWork(base,similar,exportDir,"similarconcepts.tex","Features of Work Close by Euclidean Distance");
                List<Work> dot = dotWorks(base,20);
                new ListWorks(base,dot,exportDir,"dotworks.tex","Works Similar by Dot Product");
                new AnalysisByWork(base,dot,exportDir,"dotconcepts.tex","Features of Works Similar by Dot Product");
                List<Work> cosine = cosineWorks(base,20);
                new ListWorks(base,cosine,exportDir,"cosineworks.tex","Works Similar by Cosine Similarity");
                new AnalysisByWork(base,cosine,exportDir,"cosineconcepts.tex","Features of Works Similar by Cosine Similarity");
                new ListAcronyms(base,exportDir,"acronyms.tex");



                new CreateSourceGroups(base,type);
                new OrphanFiles(base,worksDir);
                new CreateCollabWorks(base);

                new PublicationReport(base,reportDir).
                        produce("publications",
                                "Publication Report",
                                authors);

                //??? these require attributes set by Publication Report
                new ListPapersByConferenceSeries(base,exportDir,"byseries.tex");
                new ListArticlesByJournal(base,exportDir,"byjournal.tex");

                new CitationGraph(base);
                new DumpFeatures(base,dumpDir,"allconcepts.csv");
                new ExtractSelectedBib(base,dumpDir,"suggested.bib");


                return base;
        }

// main entry point for interactive application
        public static void main(String[] args) {
                launch(args);
        }

        private boolean irrelevant(Work w,Scenario base){
                List<String> concepts = base.getListConceptWork().stream().
                        filter(x->x.getWork()==w).
                        filter(x->x.getCount() >0).
                        map(x->x.getConcept().getName()).
                        toList();
                return !concepts.contains("scheduling") ||
                        !concepts.contains("constraint programming") &&
                                !concepts.contains("constraint satisfaction") &&
                                !concepts.contains("constraint logic programming") &&
                                !concepts.contains("constraint optimization") &&
                                !concepts.contains("CP") &&
                                !concepts.contains("CLP") &&
                                !concepts.contains("CSP") &&
                                !concepts.contains("COP");
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

        private void createConceptTypes(Scenario base,String[] conceptTypes){
                for(String type:conceptTypes){
                        ConceptType ct = new ConceptType(base);
                        ct.setName(type);
                }
        }

}
