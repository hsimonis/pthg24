package org.insightcentre.pthg24.controller;

import framework.ApplicationObjectInterface;
import java.lang.Exception;
import java.lang.Number;
import java.lang.Object;
import java.lang.String;
import java.lang.SuppressWarnings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

/**
 * Generated at 08:56:10 on 2024-09-25 */
public class BarChartController extends ChartController {
	@FXML
	private BarChart<String, Number> chart;

	@FXML
	@SuppressWarnings("unchecked")
	private void initialize() {
		ObservableList<String> attributeNames = FXCollections.observableArrayList();
		attributeNames.add("weightA");
		attributeNames.add("weightB");
		attributeNames.add("weightC");
		choicesMap.put("ConceptType", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("revision");
		attributeNames.add("weight");
		attributeNames.add("nrOccurrences");
		choicesMap.put("Concept", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("revision");
		attributeNames.add("weight");
		attributeNames.add("nrOccurrences");
		choicesMap.put("Acronym", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("nrWorks");
		attributeNames.add("nrCitations");
		attributeNames.add("nrBackgroundWorks");
		attributeNames.add("nrBackgroundCitations");
		choicesMap.put("Author", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("nr");
		attributeNames.add("nrEdges");
		attributeNames.add("cluster");
		attributeNames.add("year");
		attributeNames.add("nrPages");
		attributeNames.add("nrHyperLinks");
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
		attributeNames.add("relevanceTitle");
		attributeNames.add("relevanceAbstract");
		attributeNames.add("relevanceBody");
		attributeNames.add("daysToAccept");
		attributeNames.add("daysToPublish");
		choicesMap.put("Work", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("nr");
		attributeNames.add("nrEdges");
		attributeNames.add("cluster");
		attributeNames.add("year");
		attributeNames.add("nrPages");
		attributeNames.add("nrHyperLinks");
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
		attributeNames.add("relevanceTitle");
		attributeNames.add("relevanceAbstract");
		attributeNames.add("relevanceBody");
		attributeNames.add("daysToAccept");
		attributeNames.add("daysToPublish");
		choicesMap.put("Paper", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("nr");
		attributeNames.add("nrEdges");
		attributeNames.add("cluster");
		attributeNames.add("year");
		attributeNames.add("nrPages");
		attributeNames.add("nrHyperLinks");
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
		attributeNames.add("relevanceTitle");
		attributeNames.add("relevanceAbstract");
		attributeNames.add("relevanceBody");
		attributeNames.add("daysToAccept");
		attributeNames.add("daysToPublish");
		choicesMap.put("Article", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("nr");
		attributeNames.add("nrEdges");
		attributeNames.add("cluster");
		attributeNames.add("year");
		attributeNames.add("nrPages");
		attributeNames.add("nrHyperLinks");
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
		attributeNames.add("relevanceTitle");
		attributeNames.add("relevanceAbstract");
		attributeNames.add("relevanceBody");
		attributeNames.add("daysToAccept");
		attributeNames.add("daysToPublish");
		choicesMap.put("PhDThesis", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("nr");
		attributeNames.add("nrEdges");
		attributeNames.add("cluster");
		attributeNames.add("year");
		attributeNames.add("nrPages");
		attributeNames.add("nrHyperLinks");
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
		attributeNames.add("relevanceTitle");
		attributeNames.add("relevanceAbstract");
		attributeNames.add("relevanceBody");
		attributeNames.add("daysToAccept");
		attributeNames.add("daysToPublish");
		choicesMap.put("InCollection", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("nr");
		attributeNames.add("nrEdges");
		attributeNames.add("cluster");
		attributeNames.add("year");
		attributeNames.add("nrPages");
		attributeNames.add("nrHyperLinks");
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
		attributeNames.add("relevanceTitle");
		attributeNames.add("relevanceAbstract");
		attributeNames.add("relevanceBody");
		attributeNames.add("daysToAccept");
		attributeNames.add("daysToPublish");
		choicesMap.put("InBook", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("nr");
		attributeNames.add("nrEdges");
		attributeNames.add("cluster");
		attributeNames.add("year");
		attributeNames.add("nrPages");
		attributeNames.add("nrHyperLinks");
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
		attributeNames.add("relevanceTitle");
		attributeNames.add("relevanceAbstract");
		attributeNames.add("relevanceBody");
		attributeNames.add("daysToAccept");
		attributeNames.add("daysToPublish");
		choicesMap.put("Book", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("seqNr");
		choicesMap.put("Authorship", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("nrUsed");
		choicesMap.put("Affiliation", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("nrPapers");
		attributeNames.add("nrCitations");
		attributeNames.add("nrBackgroundPapers");
		attributeNames.add("nrBackgroundCitations");
		choicesMap.put("ConferenceSeries", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("nrArticles");
		attributeNames.add("nrBackgroundArticles");
		attributeNames.add("nrCitations");
		attributeNames.add("nrBackgroundCitations");
		choicesMap.put("Journal", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("nrWorks");
		choicesMap.put("Publisher", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("count");
		choicesMap.put("ConceptWork", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("nrCited");
		choicesMap.put("MissingCitingWork", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("nrCitations");
		choicesMap.put("MissingCitedWork", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("nrCited");
		attributeNames.add("nrCitations");
		attributeNames.add("nrLinks");
		attributeNames.add("year");
		attributeNames.add("crossrefReferences");
		attributeNames.add("crossrefCitations");
		attributeNames.add("knownAuthors");
		attributeNames.add("conceptWeight");
		attributeNames.add("relevance");
		choicesMap.put("MissingWork", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("nrWorks");
		attributeNames.add("nrCites");
		attributeNames.add("earliestYear");
		attributeNames.add("latestYear");
		choicesMap.put("Coauthor", attributeNames);
		attributeNames = FXCollections.observableArrayList();
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
		attributeNames.add("year");
		choicesMap.put("CrossReference", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("year");
		choicesMap.put("UncategorizedReference", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("year");
		choicesMap.put("DoiReference", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("count");
		attributeNames.add("year");
		attributeNames.add("crossrefReferences");
		attributeNames.add("crossrefCitations");
		choicesMap.put("MissingCross", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("nrWorks");
		attributeNames.add("fromFlows");
		attributeNames.add("toFlows");
		choicesMap.put("SourceGroup", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("value");
		attributeNames.add("normalized");
		choicesMap.put("ReferenceFlow", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("workCount");
		attributeNames.add("collabCount");
		attributeNames.add("domesticCollabCount");
		attributeNames.add("internationalCollabCount");
		attributeNames.add("collabFraction");
		attributeNames.add("domesticCollabFraction");
		attributeNames.add("internationalCollabFraction");
		attributeNames.add("collabPercentage");
		attributeNames.add("internationalPercentage");
		choicesMap.put("ScopusAffiliation", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("workCount");
		choicesMap.put("ScopusCity", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("workCount");
		attributeNames.add("nrWorks");
		choicesMap.put("ScopusCountry", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("fraction");
		choicesMap.put("CollabWork", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("count");
		attributeNames.add("fraction");
		choicesMap.put("CollabCount", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("count");
		choicesMap.put("CountryCollab", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("nr");
		attributeNames.add("workCount");
		attributeNames.add("year");
		attributeNames.add("relevance");
		choicesMap.put("OtherWork", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		ObservableList<String> classes = FXCollections.observableArrayList();
		classes.addAll(choicesMap.keySet());
		classChoiceBox.getItems().addAll(classes);
		chart.setLegendVisible(false);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
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
			else if (className.equals("CountryCollab")) {
				objectList = mainApp.getCountryCollabData();
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
			else if (className.equals("Assertion")) {
				objectList = mainApp.getAssertionData();
			}
			if (objectList != null) {
				XYChart.Series series = new XYChart.Series();
				for (Object obj : objectList) {
					String name = ((ApplicationObjectInterface) obj).getName();
					obj = deref(obj,attributeName);
					if (Number.class.isAssignableFrom(obj.getClass())) {
						series.getData().add(new XYChart.Data(name, obj));
					}
				}
				chart.getData().clear();
				chart.getData().add(series);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
