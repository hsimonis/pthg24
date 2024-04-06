package org.insightcentre.pthg24.controller;

import java.lang.Exception;
import java.lang.Number;
import java.lang.Object;
import java.lang.String;
import java.lang.SuppressWarnings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;

/**
 * Generated at 08:30:11 on 2024-04-05 */
public class ScatterChartController extends ChartXYFilterController {
	@FXML
	private ScatterChart<Number, Number> chart;

	@FXML
	@SuppressWarnings("unchecked")
	private void initialize() {
		ObservableList<String> attributeNames = FXCollections.observableArrayList();
		ObservableList<String> filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("dirty");
		filterNames.add("valid");
		filterNames.add("name");
		filterNames.add("type");
		filterNames.add("item");
		filterNames.add("classString");
		filterNames.add("name");
		filterNames.add("attrString");
		filterNames.add("item");
		filterNames.add("type");
		filterNames.add("limit");
		filterNames.add("name");
		filterNames.add("conceptType");
		filterNames.add("label");
		filterNames.add("regExpr");
		filterNames.add("caseSensitive");
		attributeNames.add("revision");
		filterNames.add("revision");
		choicesMap.put("Concept", attributeNames);
		filterMap.put("Concept", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("shortName");
		filterNames.add("familyName");
		filterNames.add("key");
		attributeNames.add("nrWorks");
		filterNames.add("nrWorks");
		attributeNames.add("nrCitations");
		filterNames.add("nrCitations");
		attributeNames.add("nrBackgroundWorks");
		filterNames.add("nrBackgroundWorks");
		attributeNames.add("nrBackgroundCitations");
		filterNames.add("nrBackgroundCitations");
		choicesMap.put("Author", attributeNames);
		filterMap.put("Author", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("key");
		filterNames.add("author");
		filterNames.add("authors");
		filterNames.add("title");
		filterNames.add("url");
		filterNames.add("doi");
		filterNames.add("localCopy");
		attributeNames.add("year");
		filterNames.add("year");
		filterNames.add("pages");
		attributeNames.add("nrPages");
		filterNames.add("nrPages");
		attributeNames.add("nrLinks");
		filterNames.add("nrLinks");
		filterNames.add("background");
		filterNames.add("dataAvail");
		filterNames.add("codeAvail");
		filterNames.add("solutionAvail");
		filterNames.add("cpSystem");
		filterNames.add("classification");
		filterNames.add("constraints");
		filterNames.add("relatedTo");
		attributeNames.add("nrCitations");
		filterNames.add("nrCitations");
		attributeNames.add("nrReferences");
		filterNames.add("nrReferences");
		choicesMap.put("Work", attributeNames);
		filterMap.put("Work", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("key");
		filterNames.add("author");
		filterNames.add("authors");
		filterNames.add("title");
		filterNames.add("url");
		filterNames.add("doi");
		filterNames.add("localCopy");
		attributeNames.add("year");
		filterNames.add("year");
		filterNames.add("pages");
		attributeNames.add("nrPages");
		filterNames.add("nrPages");
		attributeNames.add("nrLinks");
		filterNames.add("nrLinks");
		filterNames.add("background");
		filterNames.add("dataAvail");
		filterNames.add("codeAvail");
		filterNames.add("solutionAvail");
		filterNames.add("cpSystem");
		filterNames.add("classification");
		filterNames.add("constraints");
		filterNames.add("relatedTo");
		attributeNames.add("nrCitations");
		filterNames.add("nrCitations");
		attributeNames.add("nrReferences");
		filterNames.add("nrReferences");
		filterNames.add("proceedings");
		choicesMap.put("Paper", attributeNames);
		filterMap.put("Paper", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("key");
		filterNames.add("author");
		filterNames.add("authors");
		filterNames.add("title");
		filterNames.add("url");
		filterNames.add("doi");
		filterNames.add("localCopy");
		attributeNames.add("year");
		filterNames.add("year");
		filterNames.add("pages");
		attributeNames.add("nrPages");
		filterNames.add("nrPages");
		attributeNames.add("nrLinks");
		filterNames.add("nrLinks");
		filterNames.add("background");
		filterNames.add("dataAvail");
		filterNames.add("codeAvail");
		filterNames.add("solutionAvail");
		filterNames.add("cpSystem");
		filterNames.add("classification");
		filterNames.add("constraints");
		filterNames.add("relatedTo");
		attributeNames.add("nrCitations");
		filterNames.add("nrCitations");
		attributeNames.add("nrReferences");
		filterNames.add("nrReferences");
		filterNames.add("journal");
		choicesMap.put("Article", attributeNames);
		filterMap.put("Article", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("key");
		filterNames.add("author");
		filterNames.add("authors");
		filterNames.add("title");
		filterNames.add("url");
		filterNames.add("doi");
		filterNames.add("localCopy");
		attributeNames.add("year");
		filterNames.add("year");
		filterNames.add("pages");
		attributeNames.add("nrPages");
		filterNames.add("nrPages");
		attributeNames.add("nrLinks");
		filterNames.add("nrLinks");
		filterNames.add("background");
		filterNames.add("dataAvail");
		filterNames.add("codeAvail");
		filterNames.add("solutionAvail");
		filterNames.add("cpSystem");
		filterNames.add("classification");
		filterNames.add("constraints");
		filterNames.add("relatedTo");
		attributeNames.add("nrCitations");
		filterNames.add("nrCitations");
		attributeNames.add("nrReferences");
		filterNames.add("nrReferences");
		filterNames.add("school");
		choicesMap.put("PhDThesis", attributeNames);
		filterMap.put("PhDThesis", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("key");
		filterNames.add("author");
		filterNames.add("authors");
		filterNames.add("title");
		filterNames.add("url");
		filterNames.add("doi");
		filterNames.add("localCopy");
		attributeNames.add("year");
		filterNames.add("year");
		filterNames.add("pages");
		attributeNames.add("nrPages");
		filterNames.add("nrPages");
		attributeNames.add("nrLinks");
		filterNames.add("nrLinks");
		filterNames.add("background");
		filterNames.add("dataAvail");
		filterNames.add("codeAvail");
		filterNames.add("solutionAvail");
		filterNames.add("cpSystem");
		filterNames.add("classification");
		filterNames.add("constraints");
		filterNames.add("relatedTo");
		attributeNames.add("nrCitations");
		filterNames.add("nrCitations");
		attributeNames.add("nrReferences");
		filterNames.add("nrReferences");
		filterNames.add("collection");
		choicesMap.put("InCollection", attributeNames);
		filterMap.put("InCollection", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("key");
		filterNames.add("author");
		filterNames.add("authors");
		filterNames.add("title");
		filterNames.add("url");
		filterNames.add("doi");
		filterNames.add("localCopy");
		attributeNames.add("year");
		filterNames.add("year");
		filterNames.add("pages");
		attributeNames.add("nrPages");
		filterNames.add("nrPages");
		attributeNames.add("nrLinks");
		filterNames.add("nrLinks");
		filterNames.add("background");
		filterNames.add("dataAvail");
		filterNames.add("codeAvail");
		filterNames.add("solutionAvail");
		filterNames.add("cpSystem");
		filterNames.add("classification");
		filterNames.add("constraints");
		filterNames.add("relatedTo");
		attributeNames.add("nrCitations");
		filterNames.add("nrCitations");
		attributeNames.add("nrReferences");
		filterNames.add("nrReferences");
		filterNames.add("booktitle");
		choicesMap.put("InBook", attributeNames);
		filterMap.put("InBook", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("key");
		filterNames.add("author");
		filterNames.add("authors");
		filterNames.add("title");
		filterNames.add("url");
		filterNames.add("doi");
		filterNames.add("localCopy");
		attributeNames.add("year");
		filterNames.add("year");
		filterNames.add("pages");
		attributeNames.add("nrPages");
		filterNames.add("nrPages");
		attributeNames.add("nrLinks");
		filterNames.add("nrLinks");
		filterNames.add("background");
		filterNames.add("dataAvail");
		filterNames.add("codeAvail");
		filterNames.add("solutionAvail");
		filterNames.add("cpSystem");
		filterNames.add("classification");
		filterNames.add("constraints");
		filterNames.add("relatedTo");
		attributeNames.add("nrCitations");
		filterNames.add("nrCitations");
		attributeNames.add("nrReferences");
		filterNames.add("nrReferences");
		choicesMap.put("Book", attributeNames);
		filterMap.put("Book", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("author");
		filterNames.add("work");
		filterNames.add("name");
		filterNames.add("shortName");
		filterNames.add("conferenceSeries");
		filterNames.add("name");
		attributeNames.add("nrPapers");
		filterNames.add("nrPapers");
		attributeNames.add("nrCitations");
		filterNames.add("nrCitations");
		attributeNames.add("nrBackgroundPapers");
		filterNames.add("nrBackgroundPapers");
		attributeNames.add("nrBackgroundCitations");
		filterNames.add("nrBackgroundCitations");
		choicesMap.put("ConferenceSeries", attributeNames);
		filterMap.put("ConferenceSeries", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("shortName");
		attributeNames.add("nrArticles");
		filterNames.add("nrArticles");
		attributeNames.add("nrBackgroundArticles");
		filterNames.add("nrBackgroundArticles");
		attributeNames.add("nrCitations");
		filterNames.add("nrCitations");
		attributeNames.add("nrBackgroundCitations");
		filterNames.add("nrBackgroundCitations");
		choicesMap.put("Journal", attributeNames);
		filterMap.put("Journal", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("journal");
		filterNames.add("alias");
		filterNames.add("name");
		filterNames.add("name");
		filterNames.add("name");
		filterNames.add("concept");
		filterNames.add("work");
		attributeNames.add("count");
		filterNames.add("count");
		filterNames.add("matchLevel");
		choicesMap.put("ConceptWork", attributeNames);
		filterMap.put("ConceptWork", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("oci");
		filterNames.add("citedWork");
		filterNames.add("citingWork");
		filterNames.add("cited");
		filterNames.add("citing");
		filterNames.add("creation");
		filterNames.add("timespan");
		filterNames.add("authorSC");
		filterNames.add("journalSC");
		filterNames.add("name");
		filterNames.add("oci");
		filterNames.add("citedWork");
		filterNames.add("citingWork");
		filterNames.add("cited");
		filterNames.add("citing");
		filterNames.add("creation");
		filterNames.add("timespan");
		filterNames.add("authorSC");
		filterNames.add("journalSC");
		filterNames.add("name");
		filterNames.add("doi");
		attributeNames.add("nrCited");
		filterNames.add("nrCited");
		choicesMap.put("MissingCitingWork", attributeNames);
		filterMap.put("MissingCitingWork", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("doi");
		attributeNames.add("nrCitations");
		filterNames.add("nrCitations");
		choicesMap.put("MissingCitedWork", attributeNames);
		filterMap.put("MissingCitedWork", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("author1");
		filterNames.add("author2");
		attributeNames.add("nrWorks");
		filterNames.add("nrWorks");
		attributeNames.add("nrCites");
		filterNames.add("nrCites");
		attributeNames.add("earliestYear");
		filterNames.add("earliestYear");
		attributeNames.add("latestYear");
		filterNames.add("latestYear");
		choicesMap.put("Coauthor", attributeNames);
		filterMap.put("Coauthor", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		ObservableList<String> classes = FXCollections.observableArrayList();
		classes.addAll(choicesMap.keySet());
		classChoiceBox.getItems().addAll(classes);
		ObservableList<String> compOps = FXCollections.observableArrayList();
		compOps.addAll(filterComparisons);
		filterComparisonBox.getItems().addAll(compOps);
		chart.setLegendVisible(false);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void drawChart() {
		String className = classChoiceBox.getSelectionModel().getSelectedItem();
		String attributeXName = attributeChoiceBox.getSelectionModel().getSelectedItem();
		String attributeYName = attributeYChoiceBox.getSelectionModel().getSelectedItem();
		String attributeFilterName = attributeFilterBox.getSelectionModel().getSelectedItem();
		String filterComparisonName = filterComparisonBox.getSelectionModel().getSelectedItem();
		String filterTextName = filterTextField.getText();
		String attributeGroupName = attributeGroupBox.getSelectionModel().getSelectedItem();
		if (className == null || attributeXName == null|| attributeYName == null) {
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
					Object objX = deref(obj,attributeXName);
					Object objY = deref(obj,attributeYName);
					Object objFilter = obj;
					if(attributeFilterName != null && !attributeFilterName.equals(filterNone)) {
						objFilter=deref(obj,attributeFilterName);
					}
					if (keepFiltered(objFilter,attributeFilterName,filterComparisonName,filterTextName) && Number.class.isAssignableFrom(objX.getClass()) && Number.class.isAssignableFrom(objY.getClass())) {
						series.getData().add(new XYChart.Data(objX,objY));
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
