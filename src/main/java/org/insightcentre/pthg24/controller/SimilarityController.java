package org.insightcentre.pthg24.controller;

import framework.gui.AbstractJfxMainWindow;
import framework.gui.Table3Controller;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.reflect.Field;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.insightcentre.pthg24.GeneratedJfxApp;
import org.insightcentre.pthg24.datamodel.Similarity;
import org.insightcentre.pthg24.datamodel.Work;

/**
 * Generated at 13:06:16 on 2024-04-09 */
public class SimilarityController extends Table3Controller {
	@FXML
	private TableView<Similarity> table;

	@FXML
	private TableColumn<Similarity, String> name;

	@FXML
	private TableColumn<Similarity, Work> work1;

	@FXML
	private TableColumn<Similarity, Work> work2;

	@FXML
	private TableColumn<Similarity, Integer> ref1;

	@FXML
	private TableColumn<Similarity, Integer> ref2;

	@FXML
	private TableColumn<Similarity, Integer> nrSharedReferences;

	@FXML
	private TableColumn<Similarity, Integer> cite1;

	@FXML
	private TableColumn<Similarity, Integer> cite2;

	@FXML
	private TableColumn<Similarity, Integer> nrSharedCitations;

	@FXML
	private TableColumn<Similarity, Double> similarityRef;

	@FXML
	private TableColumn<Similarity, Double> similarityCite;

	@FXML
	private TableColumn<Similarity, Double> similarityConcept;

	@FXML
	private TableColumn<Similarity, Double> similarity;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getSimilarityData());
		work1.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getWorkData()));
		work1.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setWork1(event.getNewValue()); mainApp.reset();});
		work2.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getWorkData()));
		work2.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setWork2(event.getNewValue()); mainApp.reset();});
	}

	public TableView<Similarity> getTable() {
		return table;
	}

	@FXML
	private void initialize() {
		table.setTableMenuButtonVisible(true);
		table.setOnMouseClicked(event -> {if (event.isControlDown()) {mainApp.showObject(table.getFocusModel().getFocusedItem());}});
		ObservableList<String> choices = FXCollections.observableArrayList();
		choices.add("name");
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		name.setCellFactory(TextFieldTableCell.forTableColumn());
		name.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setName(event.getNewValue()); mainApp.reset();});
		choices.add("work1");
		work1.setCellValueFactory(new PropertyValueFactory<>("work1"));
		choices.add("work2");
		work2.setCellValueFactory(new PropertyValueFactory<>("work2"));
		choices.add("ref1");
		ref1.setCellValueFactory(new PropertyValueFactory<>("ref1"));
		ref1.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		ref1.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setRef1(event.getNewValue()); mainApp.reset();});
		choices.add("ref2");
		ref2.setCellValueFactory(new PropertyValueFactory<>("ref2"));
		ref2.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		ref2.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setRef2(event.getNewValue()); mainApp.reset();});
		choices.add("nrSharedReferences");
		nrSharedReferences.setCellValueFactory(new PropertyValueFactory<>("nrSharedReferences"));
		nrSharedReferences.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrSharedReferences.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrSharedReferences(event.getNewValue()); mainApp.reset();});
		choices.add("cite1");
		cite1.setCellValueFactory(new PropertyValueFactory<>("cite1"));
		cite1.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		cite1.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCite1(event.getNewValue()); mainApp.reset();});
		choices.add("cite2");
		cite2.setCellValueFactory(new PropertyValueFactory<>("cite2"));
		cite2.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		cite2.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCite2(event.getNewValue()); mainApp.reset();});
		choices.add("nrSharedCitations");
		nrSharedCitations.setCellValueFactory(new PropertyValueFactory<>("nrSharedCitations"));
		nrSharedCitations.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrSharedCitations.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrSharedCitations(event.getNewValue()); mainApp.reset();});
		choices.add("similarityRef");
		similarityRef.setCellValueFactory(new PropertyValueFactory<>("similarityRef"));
		similarityRef.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		similarityRef.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setSimilarityRef(event.getNewValue()); mainApp.reset();});
		choices.add("similarityCite");
		similarityCite.setCellValueFactory(new PropertyValueFactory<>("similarityCite"));
		similarityCite.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		similarityCite.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setSimilarityCite(event.getNewValue()); mainApp.reset();});
		choices.add("similarityConcept");
		similarityConcept.setCellValueFactory(new PropertyValueFactory<>("similarityConcept"));
		similarityConcept.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		similarityConcept.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setSimilarityConcept(event.getNewValue()); mainApp.reset();});
		choices.add("similarity");
		similarity.setCellValueFactory(new PropertyValueFactory<>("similarity"));
		similarity.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		similarity.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setSimilarity(event.getNewValue()); mainApp.reset();});
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getSimilarityData());
		try {
			ObservableList<Similarity> filteredItems = FXCollections.observableArrayList();
			for (Similarity item : table.getItems()) {
				String[] fields = attribute.split("\\.");
				Field f = null;
				Object obj = item;
				for (int i = 0; i < fields.length; i++) {
					f = obj.getClass().getField(fields[i]);
					obj = f.get(obj);
				}
				if (obj instanceof Integer && (comparison.equals("less than")||comparison.equals("greater than"))) {
					Integer value = (Integer) obj;
					int comp;
					try {
						comp = Integer.parseInt(text);
					}
					catch (NumberFormatException e) {
						comp = 0;
					}
					if ((comparison.equals("less than") && value < comp) ||(comparison.equals("greater than") && value > comp)) {
						filteredItems.add(item);
					}
				}
				else if (obj instanceof Double && (comparison.equals("less than")||comparison.equals("greater than"))) {
					Double value = (Double) obj;;
					double comp;;
					try {
						comp = Double.parseDouble(text);
					}
					catch (NumberFormatException e) {
						comp = 0.0;
					}
					if ((comparison.equals("less than") && value < comp) ||	(comparison.equals("greater than") && value > comp)) {
						filteredItems.add(item);
					}
				}
				else {
					String value = (obj==null?null:obj.toString());
					if (value != null && ((comparison.equals("equals") && value.equals(text)) ||(comparison.equals("not equals") && !value.equals(text)) ||(comparison.equals("contains") && value.contains(text)) ||(comparison.equals("matches") && value.matches(text)) ||(comparison.equals("starts with") && value.startsWith(text)) ||(comparison.equals("ends with") && value.endsWith(text)) ||(comparison.equals("less than") && value.compareTo(text) < 0) ||(comparison.equals("greater than") && value.compareTo(text) > 0))) {
						filteredItems.add(item);
					}
				}
			}
			table.setItems(filteredItems);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
