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
 * Generated at 08:30:11 on 2024-04-05 */
public class BarChartController extends ChartController {
	@FXML
	private BarChart<String, Number> chart;

	@FXML
	@SuppressWarnings("unchecked")
	private void initialize() {
		ObservableList<String> attributeNames = FXCollections.observableArrayList();
		attributeNames.add("revision");
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
		choicesMap.put("Work", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("year");
		attributeNames.add("nrPages");
		attributeNames.add("nrLinks");
		attributeNames.add("nrCitations");
		attributeNames.add("nrReferences");
		choicesMap.put("Paper", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("year");
		attributeNames.add("nrPages");
		attributeNames.add("nrLinks");
		attributeNames.add("nrCitations");
		attributeNames.add("nrReferences");
		choicesMap.put("Article", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("year");
		attributeNames.add("nrPages");
		attributeNames.add("nrLinks");
		attributeNames.add("nrCitations");
		attributeNames.add("nrReferences");
		choicesMap.put("PhDThesis", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("year");
		attributeNames.add("nrPages");
		attributeNames.add("nrLinks");
		attributeNames.add("nrCitations");
		attributeNames.add("nrReferences");
		choicesMap.put("InCollection", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("year");
		attributeNames.add("nrPages");
		attributeNames.add("nrLinks");
		attributeNames.add("nrCitations");
		attributeNames.add("nrReferences");
		choicesMap.put("InBook", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("year");
		attributeNames.add("nrPages");
		attributeNames.add("nrLinks");
		attributeNames.add("nrCitations");
		attributeNames.add("nrReferences");
		choicesMap.put("Book", attributeNames);
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
		attributeNames.add("nrWorks");
		attributeNames.add("nrCites");
		attributeNames.add("earliestYear");
		attributeNames.add("latestYear");
		choicesMap.put("Coauthor", attributeNames);
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
			else if (className.equals("Coauthor")) {
				objectList = mainApp.getCoauthorData();
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
