package org.insightcentre.pthg24.controller;

import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;

/**
 * Generated at 06:53:46 on 2024-05-24 */
public class PieChartController extends ChartController {
	public static final Double MIN_SLICE_PERCENTAGE = 1.0d;

	@FXML
	private PieChart chart;

	@FXML
	@SuppressWarnings("unchecked")
	private void initialize() {
		ObservableList<String> attributeNames = null;
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("dirty");
		attributeNames.add("valid");
		choicesMap.put("Scenario", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("type");
		attributeNames.add("item");
		choicesMap.put("ApplicationDifference", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("classString");
		attributeNames.add("name");
		attributeNames.add("attrString");
		attributeNames.add("item");
		attributeNames.add("type");
		attributeNames.add("limit");
		choicesMap.put("ApplicationWarning", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		choicesMap.put("ConceptType", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("shortName");
		attributeNames.add("conceptType");
		attributeNames.add("label");
		attributeNames.add("regExpr");
		attributeNames.add("caseSensitive");
		attributeNames.add("revision");
		attributeNames.add("weight");
		attributeNames.add("nrOccurrences");
		choicesMap.put("Concept", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("shortName");
		attributeNames.add("conceptType");
		attributeNames.add("label");
		attributeNames.add("regExpr");
		attributeNames.add("caseSensitive");
		attributeNames.add("revision");
		attributeNames.add("weight");
		attributeNames.add("nrOccurrences");
		attributeNames.add("description");
		choicesMap.put("Acronym", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("shortName");
		attributeNames.add("familyName");
		attributeNames.add("crossFamily");
		attributeNames.add("crossGiven");
		attributeNames.add("orcid");
		attributeNames.add("key");
		attributeNames.add("nrWorks");
		attributeNames.add("nrCitations");
		attributeNames.add("nrBackgroundWorks");
		attributeNames.add("nrBackgroundCitations");
		choicesMap.put("Author", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("shortName");
		attributeNames.add("nr");
		attributeNames.add("nrEdges");
		attributeNames.add("cluster");
		attributeNames.add("key");
		attributeNames.add("author");
		attributeNames.add("authors");
		attributeNames.add("title");
		attributeNames.add("publisher");
		attributeNames.add("url");
		attributeNames.add("doi");
		attributeNames.add("issn");
		attributeNames.add("localCopy");
		attributeNames.add("year");
		attributeNames.add("pages");
		attributeNames.add("nrPages");
		attributeNames.add("nrHyperLinks");
		attributeNames.add("background");
		attributeNames.add("sourceGroup");
		attributeNames.add("dataAvail");
		attributeNames.add("codeAvail");
		attributeNames.add("solutionAvail");
		attributeNames.add("cpSystem");
		attributeNames.add("classification");
		attributeNames.add("constraints");
		attributeNames.add("relatedTo");
		attributeNames.add("openAccess");
		attributeNames.add("openAccessType");
		attributeNames.add("nrConcepts");
		attributeNames.add("nrCitations");
		attributeNames.add("nrReferences");
		attributeNames.add("crossrefCitations");
		attributeNames.add("crossrefReferences");
		attributeNames.add("wosCitations");
		attributeNames.add("wosReferences");
		attributeNames.add("scopusCitations");
		attributeNames.add("nrCitationsCovered");
		attributeNames.add("nrReferencesCovered");
		attributeNames.add("percentCitationsCovered");
		attributeNames.add("percentReferencesCovered");
		attributeNames.add("maxCitations");
		attributeNames.add("rangeCitations");
		attributeNames.add("doiStatus");
		attributeNames.add("crossrefStatus");
		attributeNames.add("scopusStatus");
		attributeNames.add("wosStatus");
		attributeNames.add("relevanceTitle");
		attributeNames.add("relevanceAbstract");
		attributeNames.add("relevanceBody");
		attributeNames.add("language");
		attributeNames.add("abstractText");
		attributeNames.add("concept");
		choicesMap.put("Work", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("shortName");
		attributeNames.add("nr");
		attributeNames.add("nrEdges");
		attributeNames.add("cluster");
		attributeNames.add("key");
		attributeNames.add("author");
		attributeNames.add("authors");
		attributeNames.add("title");
		attributeNames.add("publisher");
		attributeNames.add("url");
		attributeNames.add("doi");
		attributeNames.add("issn");
		attributeNames.add("localCopy");
		attributeNames.add("year");
		attributeNames.add("pages");
		attributeNames.add("nrPages");
		attributeNames.add("nrHyperLinks");
		attributeNames.add("background");
		attributeNames.add("sourceGroup");
		attributeNames.add("dataAvail");
		attributeNames.add("codeAvail");
		attributeNames.add("solutionAvail");
		attributeNames.add("cpSystem");
		attributeNames.add("classification");
		attributeNames.add("constraints");
		attributeNames.add("relatedTo");
		attributeNames.add("openAccess");
		attributeNames.add("openAccessType");
		attributeNames.add("nrConcepts");
		attributeNames.add("nrCitations");
		attributeNames.add("nrReferences");
		attributeNames.add("crossrefCitations");
		attributeNames.add("crossrefReferences");
		attributeNames.add("wosCitations");
		attributeNames.add("wosReferences");
		attributeNames.add("scopusCitations");
		attributeNames.add("nrCitationsCovered");
		attributeNames.add("nrReferencesCovered");
		attributeNames.add("percentCitationsCovered");
		attributeNames.add("percentReferencesCovered");
		attributeNames.add("maxCitations");
		attributeNames.add("rangeCitations");
		attributeNames.add("doiStatus");
		attributeNames.add("crossrefStatus");
		attributeNames.add("scopusStatus");
		attributeNames.add("wosStatus");
		attributeNames.add("relevanceTitle");
		attributeNames.add("relevanceAbstract");
		attributeNames.add("relevanceBody");
		attributeNames.add("language");
		attributeNames.add("abstractText");
		attributeNames.add("concept");
		attributeNames.add("proceedings");
		choicesMap.put("Paper", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("shortName");
		attributeNames.add("nr");
		attributeNames.add("nrEdges");
		attributeNames.add("cluster");
		attributeNames.add("key");
		attributeNames.add("author");
		attributeNames.add("authors");
		attributeNames.add("title");
		attributeNames.add("publisher");
		attributeNames.add("url");
		attributeNames.add("doi");
		attributeNames.add("issn");
		attributeNames.add("localCopy");
		attributeNames.add("year");
		attributeNames.add("pages");
		attributeNames.add("nrPages");
		attributeNames.add("nrHyperLinks");
		attributeNames.add("background");
		attributeNames.add("sourceGroup");
		attributeNames.add("dataAvail");
		attributeNames.add("codeAvail");
		attributeNames.add("solutionAvail");
		attributeNames.add("cpSystem");
		attributeNames.add("classification");
		attributeNames.add("constraints");
		attributeNames.add("relatedTo");
		attributeNames.add("openAccess");
		attributeNames.add("openAccessType");
		attributeNames.add("nrConcepts");
		attributeNames.add("nrCitations");
		attributeNames.add("nrReferences");
		attributeNames.add("crossrefCitations");
		attributeNames.add("crossrefReferences");
		attributeNames.add("wosCitations");
		attributeNames.add("wosReferences");
		attributeNames.add("scopusCitations");
		attributeNames.add("nrCitationsCovered");
		attributeNames.add("nrReferencesCovered");
		attributeNames.add("percentCitationsCovered");
		attributeNames.add("percentReferencesCovered");
		attributeNames.add("maxCitations");
		attributeNames.add("rangeCitations");
		attributeNames.add("doiStatus");
		attributeNames.add("crossrefStatus");
		attributeNames.add("scopusStatus");
		attributeNames.add("wosStatus");
		attributeNames.add("relevanceTitle");
		attributeNames.add("relevanceAbstract");
		attributeNames.add("relevanceBody");
		attributeNames.add("language");
		attributeNames.add("abstractText");
		attributeNames.add("concept");
		attributeNames.add("journal");
		choicesMap.put("Article", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("shortName");
		attributeNames.add("nr");
		attributeNames.add("nrEdges");
		attributeNames.add("cluster");
		attributeNames.add("key");
		attributeNames.add("author");
		attributeNames.add("authors");
		attributeNames.add("title");
		attributeNames.add("publisher");
		attributeNames.add("url");
		attributeNames.add("doi");
		attributeNames.add("issn");
		attributeNames.add("localCopy");
		attributeNames.add("year");
		attributeNames.add("pages");
		attributeNames.add("nrPages");
		attributeNames.add("nrHyperLinks");
		attributeNames.add("background");
		attributeNames.add("sourceGroup");
		attributeNames.add("dataAvail");
		attributeNames.add("codeAvail");
		attributeNames.add("solutionAvail");
		attributeNames.add("cpSystem");
		attributeNames.add("classification");
		attributeNames.add("constraints");
		attributeNames.add("relatedTo");
		attributeNames.add("openAccess");
		attributeNames.add("openAccessType");
		attributeNames.add("nrConcepts");
		attributeNames.add("nrCitations");
		attributeNames.add("nrReferences");
		attributeNames.add("crossrefCitations");
		attributeNames.add("crossrefReferences");
		attributeNames.add("wosCitations");
		attributeNames.add("wosReferences");
		attributeNames.add("scopusCitations");
		attributeNames.add("nrCitationsCovered");
		attributeNames.add("nrReferencesCovered");
		attributeNames.add("percentCitationsCovered");
		attributeNames.add("percentReferencesCovered");
		attributeNames.add("maxCitations");
		attributeNames.add("rangeCitations");
		attributeNames.add("doiStatus");
		attributeNames.add("crossrefStatus");
		attributeNames.add("scopusStatus");
		attributeNames.add("wosStatus");
		attributeNames.add("relevanceTitle");
		attributeNames.add("relevanceAbstract");
		attributeNames.add("relevanceBody");
		attributeNames.add("language");
		attributeNames.add("abstractText");
		attributeNames.add("concept");
		attributeNames.add("school");
		choicesMap.put("PhDThesis", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("shortName");
		attributeNames.add("nr");
		attributeNames.add("nrEdges");
		attributeNames.add("cluster");
		attributeNames.add("key");
		attributeNames.add("author");
		attributeNames.add("authors");
		attributeNames.add("title");
		attributeNames.add("publisher");
		attributeNames.add("url");
		attributeNames.add("doi");
		attributeNames.add("issn");
		attributeNames.add("localCopy");
		attributeNames.add("year");
		attributeNames.add("pages");
		attributeNames.add("nrPages");
		attributeNames.add("nrHyperLinks");
		attributeNames.add("background");
		attributeNames.add("sourceGroup");
		attributeNames.add("dataAvail");
		attributeNames.add("codeAvail");
		attributeNames.add("solutionAvail");
		attributeNames.add("cpSystem");
		attributeNames.add("classification");
		attributeNames.add("constraints");
		attributeNames.add("relatedTo");
		attributeNames.add("openAccess");
		attributeNames.add("openAccessType");
		attributeNames.add("nrConcepts");
		attributeNames.add("nrCitations");
		attributeNames.add("nrReferences");
		attributeNames.add("crossrefCitations");
		attributeNames.add("crossrefReferences");
		attributeNames.add("wosCitations");
		attributeNames.add("wosReferences");
		attributeNames.add("scopusCitations");
		attributeNames.add("nrCitationsCovered");
		attributeNames.add("nrReferencesCovered");
		attributeNames.add("percentCitationsCovered");
		attributeNames.add("percentReferencesCovered");
		attributeNames.add("maxCitations");
		attributeNames.add("rangeCitations");
		attributeNames.add("doiStatus");
		attributeNames.add("crossrefStatus");
		attributeNames.add("scopusStatus");
		attributeNames.add("wosStatus");
		attributeNames.add("relevanceTitle");
		attributeNames.add("relevanceAbstract");
		attributeNames.add("relevanceBody");
		attributeNames.add("language");
		attributeNames.add("abstractText");
		attributeNames.add("concept");
		attributeNames.add("collection");
		choicesMap.put("InCollection", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("shortName");
		attributeNames.add("nr");
		attributeNames.add("nrEdges");
		attributeNames.add("cluster");
		attributeNames.add("key");
		attributeNames.add("author");
		attributeNames.add("authors");
		attributeNames.add("title");
		attributeNames.add("publisher");
		attributeNames.add("url");
		attributeNames.add("doi");
		attributeNames.add("issn");
		attributeNames.add("localCopy");
		attributeNames.add("year");
		attributeNames.add("pages");
		attributeNames.add("nrPages");
		attributeNames.add("nrHyperLinks");
		attributeNames.add("background");
		attributeNames.add("sourceGroup");
		attributeNames.add("dataAvail");
		attributeNames.add("codeAvail");
		attributeNames.add("solutionAvail");
		attributeNames.add("cpSystem");
		attributeNames.add("classification");
		attributeNames.add("constraints");
		attributeNames.add("relatedTo");
		attributeNames.add("openAccess");
		attributeNames.add("openAccessType");
		attributeNames.add("nrConcepts");
		attributeNames.add("nrCitations");
		attributeNames.add("nrReferences");
		attributeNames.add("crossrefCitations");
		attributeNames.add("crossrefReferences");
		attributeNames.add("wosCitations");
		attributeNames.add("wosReferences");
		attributeNames.add("scopusCitations");
		attributeNames.add("nrCitationsCovered");
		attributeNames.add("nrReferencesCovered");
		attributeNames.add("percentCitationsCovered");
		attributeNames.add("percentReferencesCovered");
		attributeNames.add("maxCitations");
		attributeNames.add("rangeCitations");
		attributeNames.add("doiStatus");
		attributeNames.add("crossrefStatus");
		attributeNames.add("scopusStatus");
		attributeNames.add("wosStatus");
		attributeNames.add("relevanceTitle");
		attributeNames.add("relevanceAbstract");
		attributeNames.add("relevanceBody");
		attributeNames.add("language");
		attributeNames.add("abstractText");
		attributeNames.add("concept");
		attributeNames.add("booktitle");
		choicesMap.put("InBook", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("shortName");
		attributeNames.add("nr");
		attributeNames.add("nrEdges");
		attributeNames.add("cluster");
		attributeNames.add("key");
		attributeNames.add("author");
		attributeNames.add("authors");
		attributeNames.add("title");
		attributeNames.add("publisher");
		attributeNames.add("url");
		attributeNames.add("doi");
		attributeNames.add("issn");
		attributeNames.add("localCopy");
		attributeNames.add("year");
		attributeNames.add("pages");
		attributeNames.add("nrPages");
		attributeNames.add("nrHyperLinks");
		attributeNames.add("background");
		attributeNames.add("sourceGroup");
		attributeNames.add("dataAvail");
		attributeNames.add("codeAvail");
		attributeNames.add("solutionAvail");
		attributeNames.add("cpSystem");
		attributeNames.add("classification");
		attributeNames.add("constraints");
		attributeNames.add("relatedTo");
		attributeNames.add("openAccess");
		attributeNames.add("openAccessType");
		attributeNames.add("nrConcepts");
		attributeNames.add("nrCitations");
		attributeNames.add("nrReferences");
		attributeNames.add("crossrefCitations");
		attributeNames.add("crossrefReferences");
		attributeNames.add("wosCitations");
		attributeNames.add("wosReferences");
		attributeNames.add("scopusCitations");
		attributeNames.add("nrCitationsCovered");
		attributeNames.add("nrReferencesCovered");
		attributeNames.add("percentCitationsCovered");
		attributeNames.add("percentReferencesCovered");
		attributeNames.add("maxCitations");
		attributeNames.add("rangeCitations");
		attributeNames.add("doiStatus");
		attributeNames.add("crossrefStatus");
		attributeNames.add("scopusStatus");
		attributeNames.add("wosStatus");
		attributeNames.add("relevanceTitle");
		attributeNames.add("relevanceAbstract");
		attributeNames.add("relevanceBody");
		attributeNames.add("language");
		attributeNames.add("abstractText");
		attributeNames.add("concept");
		choicesMap.put("Book", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("seqNr");
		attributeNames.add("sequence");
		attributeNames.add("author");
		attributeNames.add("work");
		attributeNames.add("affiliation");
		choicesMap.put("Authorship", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("shortName");
		attributeNames.add("nrUsed");
		choicesMap.put("Affiliation", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("shortName");
		attributeNames.add("conferenceSeries");
		choicesMap.put("Proceedings", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("description");
		attributeNames.add("regExpr");
		attributeNames.add("nrPapers");
		attributeNames.add("nrCitations");
		attributeNames.add("nrBackgroundPapers");
		attributeNames.add("nrBackgroundCitations");
		choicesMap.put("ConferenceSeries", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("shortName");
		attributeNames.add("publisher");
		attributeNames.add("issn");
		attributeNames.add("nrArticles");
		attributeNames.add("nrBackgroundArticles");
		attributeNames.add("nrCitations");
		attributeNames.add("nrBackgroundCitations");
		attributeNames.add("isBlocked");
		choicesMap.put("Journal", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("journal");
		attributeNames.add("alias");
		choicesMap.put("JournalAlias", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		choicesMap.put("School", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		choicesMap.put("Publisher", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		choicesMap.put("Collection", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("concept");
		attributeNames.add("work");
		attributeNames.add("count");
		attributeNames.add("matchLevel");
		choicesMap.put("ConceptWork", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("oci");
		attributeNames.add("citedWork");
		attributeNames.add("citingWork");
		attributeNames.add("cited");
		attributeNames.add("citing");
		attributeNames.add("creation");
		attributeNames.add("timespan");
		attributeNames.add("authorSC");
		attributeNames.add("journalSC");
		choicesMap.put("Citation", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("oci");
		attributeNames.add("citedWork");
		attributeNames.add("citingWork");
		attributeNames.add("cited");
		attributeNames.add("citing");
		attributeNames.add("creation");
		attributeNames.add("timespan");
		attributeNames.add("authorSC");
		attributeNames.add("journalSC");
		choicesMap.put("Reference", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("doi");
		attributeNames.add("nrCited");
		choicesMap.put("MissingCitingWork", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("doi");
		attributeNames.add("nrCitations");
		choicesMap.put("MissingCitedWork", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("key");
		attributeNames.add("doi");
		attributeNames.add("encoded");
		attributeNames.add("nrCited");
		attributeNames.add("nrCitations");
		attributeNames.add("nrLinks");
		attributeNames.add("year");
		attributeNames.add("author");
		attributeNames.add("editor");
		attributeNames.add("title");
		attributeNames.add("publisher");
		attributeNames.add("volume");
		attributeNames.add("issue");
		attributeNames.add("page");
		attributeNames.add("chapter");
		attributeNames.add("source");
		attributeNames.add("abstractText");
		attributeNames.add("keywords");
		attributeNames.add("url");
		attributeNames.add("type");
		attributeNames.add("crossrefReferences");
		attributeNames.add("crossrefCitations");
		attributeNames.add("knownAuthors");
		attributeNames.add("conceptWeight");
		attributeNames.add("relevance");
		attributeNames.add("isSelected");
		attributeNames.add("concept");
		choicesMap.put("MissingWork", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("author1");
		attributeNames.add("author2");
		attributeNames.add("nrWorks");
		attributeNames.add("nrCites");
		attributeNames.add("earliestYear");
		attributeNames.add("latestYear");
		choicesMap.put("Coauthor", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("work1");
		attributeNames.add("work2");
		attributeNames.add("ref1");
		attributeNames.add("ref2");
		attributeNames.add("nrSharedReferences");
		attributeNames.add("cite1");
		attributeNames.add("cite2");
		attributeNames.add("nrSharedCitations");
		attributeNames.add("similarityRef");
		attributeNames.add("similarityCite");
		attributeNames.add("similarityConcept");
		attributeNames.add("similarity");
		attributeNames.add("dotProduct");
		attributeNames.add("cosine");
		choicesMap.put("Similarity", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("key");
		attributeNames.add("work");
		attributeNames.add("referredWork");
		attributeNames.add("missingWork");
		attributeNames.add("missingCross");
		attributeNames.add("year");
		attributeNames.add("author");
		attributeNames.add("source");
		attributeNames.add("title");
		choicesMap.put("CrossReference", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("key");
		attributeNames.add("work");
		attributeNames.add("referredWork");
		attributeNames.add("missingWork");
		attributeNames.add("missingCross");
		attributeNames.add("year");
		attributeNames.add("author");
		attributeNames.add("source");
		attributeNames.add("title");
		choicesMap.put("UncategorizedReference", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("key");
		attributeNames.add("work");
		attributeNames.add("referredWork");
		attributeNames.add("missingWork");
		attributeNames.add("missingCross");
		attributeNames.add("year");
		attributeNames.add("author");
		attributeNames.add("source");
		attributeNames.add("title");
		attributeNames.add("doi");
		choicesMap.put("DoiReference", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("doi");
		attributeNames.add("count");
		attributeNames.add("year");
		attributeNames.add("author");
		attributeNames.add("source");
		attributeNames.add("title");
		attributeNames.add("url");
		attributeNames.add("type");
		attributeNames.add("crossrefReferences");
		attributeNames.add("crossrefCitations");
		choicesMap.put("MissingCross", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("description");
		attributeNames.add("nrWorks");
		attributeNames.add("fromFlows");
		attributeNames.add("toFlows");
		choicesMap.put("SourceGroup", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("from");
		attributeNames.add("to");
		attributeNames.add("value");
		attributeNames.add("normalized");
		choicesMap.put("ReferenceFlow", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("inst");
		attributeNames.add("scopusCity");
		attributeNames.add("workCount");
		attributeNames.add("collabCount");
		attributeNames.add("domesticCollabCount");
		attributeNames.add("internationalCollabCount");
		attributeNames.add("collabFraction");
		attributeNames.add("domesticCollabFraction");
		attributeNames.add("internationalCollabFraction");
		attributeNames.add("collabPercentage");
		attributeNames.add("internationalPercentage");
		attributeNames.add("scopusCity.scopusCountry");
		choicesMap.put("ScopusAffiliation", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("work");
		attributeNames.add("scopusAffiliation");
		attributeNames.add("scopusAffiliation.scopusCity");
		attributeNames.add("scopusAffiliation.scopusCity.scopusCountry");
		choicesMap.put("WorkAffiliation", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("scopusCountry");
		attributeNames.add("workCount");
		choicesMap.put("ScopusCity", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("workCount");
		attributeNames.add("nrWorks");
		choicesMap.put("ScopusCountry", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("fileName");
		choicesMap.put("Orphan", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("affiliation1");
		attributeNames.add("affiliation2");
		attributeNames.add("work");
		attributeNames.add("fraction");
		choicesMap.put("CollabWork", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("affiliation1");
		attributeNames.add("affiliation2");
		attributeNames.add("count");
		attributeNames.add("fraction");
		choicesMap.put("CollabCount", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("unicode");
		attributeNames.add("latex");
		choicesMap.put("Translator", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("reason");
		attributeNames.add("author1");
		attributeNames.add("author2");
		attributeNames.add("work1");
		attributeNames.add("work2");
		choicesMap.put("AuthorDouble", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("shortName");
		attributeNames.add("nr");
		attributeNames.add("key");
		attributeNames.add("workType");
		attributeNames.add("editor");
		attributeNames.add("author");
		attributeNames.add("authors");
		attributeNames.add("workCount");
		attributeNames.add("title");
		attributeNames.add("source");
		attributeNames.add("url");
		attributeNames.add("doi");
		attributeNames.add("year");
		attributeNames.add("relevance");
		attributeNames.add("isFound");
		attributeNames.add("isSelected");
		attributeNames.add("concept");
		attributeNames.add("keywords");
		attributeNames.add("abstractText");
		attributeNames.add("volume");
		attributeNames.add("issue");
		attributeNames.add("page");
		attributeNames.add("chapter");
		attributeNames.add("publisher");
		choicesMap.put("OtherWork", attributeNames);
		ObservableList<String> classes = FXCollections.observableArrayList();
		classes.addAll(choicesMap.keySet());
		classChoiceBox.getItems().addAll(classes);
		chart.setLegendSide(Side.LEFT);
	}

	@SuppressWarnings("rawtypes")
	public void drawChart() {
		String className = classChoiceBox.getSelectionModel().getSelectedItem();
		String attributeName = attributeChoiceBox.getSelectionModel().getSelectedItem();
		if (className == null || attributeName == null) {
			return;
		}
		try {
			ObservableList objectList = null;
			if (className.equals("Scenario")) {
				objectList = mainApp.getScenarioData();
			}
			else if (className.equals("ApplicationDifference")) {
				objectList = mainApp.getApplicationDifferenceData();
			}
			else if (className.equals("ApplicationWarning")) {
				objectList = mainApp.getApplicationWarningData();
			}
			else if (className.equals("ConceptType")) {
				objectList = mainApp.getConceptTypeData();
			}
			else if (className.equals("Concept")) {
				objectList = mainApp.getConceptData();
			}
			else if (className.equals("Acronym")) {
				objectList = mainApp.getAcronymData();
			}
			else if (className.equals("Author")) {
				objectList = mainApp.getAuthorData();
			}
			else if (className.equals("Work")) {
				objectList = mainApp.getWorkData();
			}
			else if (className.equals("Paper")) {
				objectList = mainApp.getPaperData();
			}
			else if (className.equals("Article")) {
				objectList = mainApp.getArticleData();
			}
			else if (className.equals("PhDThesis")) {
				objectList = mainApp.getPhDThesisData();
			}
			else if (className.equals("InCollection")) {
				objectList = mainApp.getInCollectionData();
			}
			else if (className.equals("InBook")) {
				objectList = mainApp.getInBookData();
			}
			else if (className.equals("Book")) {
				objectList = mainApp.getBookData();
			}
			else if (className.equals("Authorship")) {
				objectList = mainApp.getAuthorshipData();
			}
			else if (className.equals("Affiliation")) {
				objectList = mainApp.getAffiliationData();
			}
			else if (className.equals("Proceedings")) {
				objectList = mainApp.getProceedingsData();
			}
			else if (className.equals("ConferenceSeries")) {
				objectList = mainApp.getConferenceSeriesData();
			}
			else if (className.equals("Journal")) {
				objectList = mainApp.getJournalData();
			}
			else if (className.equals("JournalAlias")) {
				objectList = mainApp.getJournalAliasData();
			}
			else if (className.equals("School")) {
				objectList = mainApp.getSchoolData();
			}
			else if (className.equals("Publisher")) {
				objectList = mainApp.getPublisherData();
			}
			else if (className.equals("Collection")) {
				objectList = mainApp.getCollectionData();
			}
			else if (className.equals("ConceptWork")) {
				objectList = mainApp.getConceptWorkData();
			}
			else if (className.equals("Citation")) {
				objectList = mainApp.getCitationData();
			}
			else if (className.equals("Reference")) {
				objectList = mainApp.getReferenceData();
			}
			else if (className.equals("MissingCitingWork")) {
				objectList = mainApp.getMissingCitingWorkData();
			}
			else if (className.equals("MissingCitedWork")) {
				objectList = mainApp.getMissingCitedWorkData();
			}
			else if (className.equals("MissingWork")) {
				objectList = mainApp.getMissingWorkData();
			}
			else if (className.equals("Coauthor")) {
				objectList = mainApp.getCoauthorData();
			}
			else if (className.equals("Similarity")) {
				objectList = mainApp.getSimilarityData();
			}
			else if (className.equals("CrossReference")) {
				objectList = mainApp.getCrossReferenceData();
			}
			else if (className.equals("UncategorizedReference")) {
				objectList = mainApp.getUncategorizedReferenceData();
			}
			else if (className.equals("DoiReference")) {
				objectList = mainApp.getDoiReferenceData();
			}
			else if (className.equals("MissingCross")) {
				objectList = mainApp.getMissingCrossData();
			}
			else if (className.equals("SourceGroup")) {
				objectList = mainApp.getSourceGroupData();
			}
			else if (className.equals("ReferenceFlow")) {
				objectList = mainApp.getReferenceFlowData();
			}
			else if (className.equals("ScopusAffiliation")) {
				objectList = mainApp.getScopusAffiliationData();
			}
			else if (className.equals("WorkAffiliation")) {
				objectList = mainApp.getWorkAffiliationData();
			}
			else if (className.equals("ScopusCity")) {
				objectList = mainApp.getScopusCityData();
			}
			else if (className.equals("ScopusCountry")) {
				objectList = mainApp.getScopusCountryData();
			}
			else if (className.equals("Orphan")) {
				objectList = mainApp.getOrphanData();
			}
			else if (className.equals("CollabWork")) {
				objectList = mainApp.getCollabWorkData();
			}
			else if (className.equals("CollabCount")) {
				objectList = mainApp.getCollabCountData();
			}
			else if (className.equals("Translator")) {
				objectList = mainApp.getTranslatorData();
			}
			else if (className.equals("AuthorDouble")) {
				objectList = mainApp.getAuthorDoubleData();
			}
			else if (className.equals("OtherWork")) {
				objectList = mainApp.getOtherWorkData();
			}
			if (objectList != null) {
				Map<String, Integer> countMap = new HashMap<String, Integer>();
				for (Object obj : objectList) {
					obj = deref(obj,attributeName);
					String attributeValue = obj == null ? "" : obj.toString();
					if (countMap.containsKey(attributeValue)) {
						countMap.put(attributeValue, countMap.get(attributeValue) + 1);
					}
					else {
						countMap.put(attributeValue, 1);
					}
				}
				ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
				Integer others = 0;
				for (String name: countMap.keySet()) {
					Integer count = countMap.get(name);
					Double percentage = ((double) count / objectList.size()) * 100;
					if (percentage < MIN_SLICE_PERCENTAGE) {
						others += count;
					}
					else {
						String label = String.format("%s (%.1f%%)", name, percentage);
						data.add(new PieChart.Data(label, count));
					}
				}
				if (others > 0) {
					Double percentage = ((double) others / objectList.size()) * 100;
					String label = String.format("Others (%.1f%%)", percentage);
					data.add(new PieChart.Data(label, others));
				}
				chart.setData(data);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
