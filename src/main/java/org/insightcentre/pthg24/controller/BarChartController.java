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
 * Generated at 11:56:49 on 2024-04-18 */
public class BarChartController extends ChartController {
	@FXML
	private BarChart<String, Number> chart;

	@FXML
	@SuppressWarnings("unchecked")
	private void initialize() {
		ObservableList<String> attributeNames = FXCollections.observableArrayList();
		attributeNames.add("revision");
		attributeNames.add("nrOccurrences");
		choicesMap.put("Concept", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("nrWorks");
		attributeNames.add("nrCitations");
		attributeNames.add("nrBackgroundWorks");
		attributeNames.add("nrBackgroundCitations");
		choicesMap.put("Author", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("year");
		attributeNames.add("nrPages");
		attributeNames.add("nrLinks");
		attributeNames.add("nrCitations");
		attributeNames.add("nrReferences");
		attributeNames.add("crossrefCitations");
		attributeNames.add("crossrefReferences");
		attributeNames.add("nrCitationsCovered");
		attributeNames.add("nrReferencesCovered");
		attributeNames.add("percentCitationsCovered");
		attributeNames.add("percentReferencesCovered");
		choicesMap.put("Work", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("year");
		attributeNames.add("nrPages");
		attributeNames.add("nrLinks");
		attributeNames.add("nrCitations");
		attributeNames.add("nrReferences");
		attributeNames.add("crossrefCitations");
		attributeNames.add("crossrefReferences");
		attributeNames.add("nrCitationsCovered");
		attributeNames.add("nrReferencesCovered");
		attributeNames.add("percentCitationsCovered");
		attributeNames.add("percentReferencesCovered");
		choicesMap.put("Paper", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("year");
		attributeNames.add("nrPages");
		attributeNames.add("nrLinks");
		attributeNames.add("nrCitations");
		attributeNames.add("nrReferences");
		attributeNames.add("crossrefCitations");
		attributeNames.add("crossrefReferences");
		attributeNames.add("nrCitationsCovered");
		attributeNames.add("nrReferencesCovered");
		attributeNames.add("percentCitationsCovered");
		attributeNames.add("percentReferencesCovered");
		choicesMap.put("Article", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("year");
		attributeNames.add("nrPages");
		attributeNames.add("nrLinks");
		attributeNames.add("nrCitations");
		attributeNames.add("nrReferences");
		attributeNames.add("crossrefCitations");
		attributeNames.add("crossrefReferences");
		attributeNames.add("nrCitationsCovered");
		attributeNames.add("nrReferencesCovered");
		attributeNames.add("percentCitationsCovered");
		attributeNames.add("percentReferencesCovered");
		choicesMap.put("PhDThesis", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("year");
		attributeNames.add("nrPages");
		attributeNames.add("nrLinks");
		attributeNames.add("nrCitations");
		attributeNames.add("nrReferences");
		attributeNames.add("crossrefCitations");
		attributeNames.add("crossrefReferences");
		attributeNames.add("nrCitationsCovered");
		attributeNames.add("nrReferencesCovered");
		attributeNames.add("percentCitationsCovered");
		attributeNames.add("percentReferencesCovered");
		choicesMap.put("InCollection", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("year");
		attributeNames.add("nrPages");
		attributeNames.add("nrLinks");
		attributeNames.add("nrCitations");
		attributeNames.add("nrReferences");
		attributeNames.add("crossrefCitations");
		attributeNames.add("crossrefReferences");
		attributeNames.add("nrCitationsCovered");
		attributeNames.add("nrReferencesCovered");
		attributeNames.add("percentCitationsCovered");
		attributeNames.add("percentReferencesCovered");
		choicesMap.put("InBook", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("year");
		attributeNames.add("nrPages");
		attributeNames.add("nrLinks");
		attributeNames.add("nrCitations");
		attributeNames.add("nrReferences");
		attributeNames.add("crossrefCitations");
		attributeNames.add("crossrefReferences");
		attributeNames.add("nrCitationsCovered");
		attributeNames.add("nrReferencesCovered");
		attributeNames.add("percentCitationsCovered");
		attributeNames.add("percentReferencesCovered");
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
			else if (className.equals("Concept")) {
				objectList = mainApp.getConceptData();
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
