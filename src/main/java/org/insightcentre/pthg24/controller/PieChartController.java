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
 * Generated at 16:26:12 on 2024-02-25 */
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
		attributeNames.add("conceptType");
		attributeNames.add("label");
		attributeNames.add("regExpr");
		choicesMap.put("Concept", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("shortName");
		attributeNames.add("familyName");
		attributeNames.add("nrWorks");
		choicesMap.put("Author", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("key");
		attributeNames.add("author");
		attributeNames.add("authors");
		attributeNames.add("title");
		attributeNames.add("url");
		attributeNames.add("doi");
		attributeNames.add("localCopy");
		attributeNames.add("year");
		attributeNames.add("pages");
		attributeNames.add("nrPages");
		attributeNames.add("dataAvail");
		attributeNames.add("codeAvail");
		attributeNames.add("solutionAvail");
		attributeNames.add("cpSystem");
		attributeNames.add("classification");
		attributeNames.add("constraints");
		attributeNames.add("basedOn");
		attributeNames.add("citations");
		choicesMap.put("Work", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("key");
		attributeNames.add("author");
		attributeNames.add("authors");
		attributeNames.add("title");
		attributeNames.add("url");
		attributeNames.add("doi");
		attributeNames.add("localCopy");
		attributeNames.add("year");
		attributeNames.add("pages");
		attributeNames.add("nrPages");
		attributeNames.add("dataAvail");
		attributeNames.add("codeAvail");
		attributeNames.add("solutionAvail");
		attributeNames.add("cpSystem");
		attributeNames.add("classification");
		attributeNames.add("constraints");
		attributeNames.add("basedOn");
		attributeNames.add("citations");
		attributeNames.add("proceedings");
		choicesMap.put("Paper", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("key");
		attributeNames.add("author");
		attributeNames.add("authors");
		attributeNames.add("title");
		attributeNames.add("url");
		attributeNames.add("doi");
		attributeNames.add("localCopy");
		attributeNames.add("year");
		attributeNames.add("pages");
		attributeNames.add("nrPages");
		attributeNames.add("dataAvail");
		attributeNames.add("codeAvail");
		attributeNames.add("solutionAvail");
		attributeNames.add("cpSystem");
		attributeNames.add("classification");
		attributeNames.add("constraints");
		attributeNames.add("basedOn");
		attributeNames.add("citations");
		attributeNames.add("journal");
		choicesMap.put("Article", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("key");
		attributeNames.add("author");
		attributeNames.add("authors");
		attributeNames.add("title");
		attributeNames.add("url");
		attributeNames.add("doi");
		attributeNames.add("localCopy");
		attributeNames.add("year");
		attributeNames.add("pages");
		attributeNames.add("nrPages");
		attributeNames.add("dataAvail");
		attributeNames.add("codeAvail");
		attributeNames.add("solutionAvail");
		attributeNames.add("cpSystem");
		attributeNames.add("classification");
		attributeNames.add("constraints");
		attributeNames.add("basedOn");
		attributeNames.add("citations");
		attributeNames.add("school");
		choicesMap.put("PhDThesis", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("key");
		attributeNames.add("author");
		attributeNames.add("authors");
		attributeNames.add("title");
		attributeNames.add("url");
		attributeNames.add("doi");
		attributeNames.add("localCopy");
		attributeNames.add("year");
		attributeNames.add("pages");
		attributeNames.add("nrPages");
		attributeNames.add("dataAvail");
		attributeNames.add("codeAvail");
		attributeNames.add("solutionAvail");
		attributeNames.add("cpSystem");
		attributeNames.add("classification");
		attributeNames.add("constraints");
		attributeNames.add("basedOn");
		attributeNames.add("citations");
		attributeNames.add("collection");
		choicesMap.put("InCollection", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("author");
		attributeNames.add("work");
		choicesMap.put("Authorship", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("shortName");
		attributeNames.add("series");
		choicesMap.put("Proceedings", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("shortName");
		choicesMap.put("Journal", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		choicesMap.put("School", attributeNames);
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
			else if (className.equals("Authorship")) {
				objectList = mainApp.getAuthorshipData();
			}
			else if (className.equals("Proceedings")) {
				objectList = mainApp.getProceedingsData();
			}
			else if (className.equals("Journal")) {
				objectList = mainApp.getJournalData();
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
