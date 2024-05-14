package org.insightcentre.pthg24.controller;

import framework.gui.AbstractJfxMainWindow;
import framework.gui.Table3Controller;
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
import org.insightcentre.pthg24.datamodel.Concept;
import org.insightcentre.pthg24.datamodel.ConceptWork;
import org.insightcentre.pthg24.datamodel.MatchLevel;
import org.insightcentre.pthg24.datamodel.Work;

/**
 * Generated at 19:13:04 on 2024-05-13 */
public class ConceptWorkController extends Table3Controller {
	@FXML
	private TableView<ConceptWork> table;

	@FXML
	private TableColumn<ConceptWork, String> name;

	@FXML
	private TableColumn<ConceptWork, Concept> concept;

	@FXML
	private TableColumn<ConceptWork, Work> work;

	@FXML
	private TableColumn<ConceptWork, Integer> count;

	@FXML
	private TableColumn<ConceptWork, MatchLevel> matchLevel;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getConceptWorkData());
		concept.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getConceptData()));
		concept.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setConcept(event.getNewValue()); mainApp.reset();});
		work.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getWorkData()));
		work.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setWork(event.getNewValue()); mainApp.reset();});
		ObservableList<MatchLevel> matchLevelValues = FXCollections.observableArrayList(MatchLevel.values());
		matchLevel.setCellFactory(ComboBoxTableCell.forTableColumn(matchLevelValues));
		matchLevel.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setMatchLevel(event.getNewValue()); mainApp.reset();});
	}

	public TableView<ConceptWork> getTable() {
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
		choices.add("concept");
		concept.setCellValueFactory(new PropertyValueFactory<>("concept"));
		choices.add("work");
		work.setCellValueFactory(new PropertyValueFactory<>("work"));
		choices.add("count");
		count.setCellValueFactory(new PropertyValueFactory<>("count"));
		count.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		count.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCount(event.getNewValue()); mainApp.reset();});
		choices.add("matchLevel");
		matchLevel.setCellValueFactory(new PropertyValueFactory<>("matchLevel"));
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getConceptWorkData());
		try {
			ObservableList<ConceptWork> filteredItems = FXCollections.observableArrayList();
			for (ConceptWork item : table.getItems()) {
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
