package org.insightcentre.pthg24.controller;

import framework.gui.AbstractJfxMainWindow;
import framework.gui.Table3Controller;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.reflect.Field;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.insightcentre.pthg24.GeneratedJfxApp;
import org.insightcentre.pthg24.datamodel.ConceptType;

/**
 * Generated at 08:56:10 on 2024-09-25 */
public class ConceptTypeController extends Table3Controller {
	@FXML
	private TableView<ConceptType> table;

	@FXML
	private TableColumn<ConceptType, String> name;

	@FXML
	private TableColumn<ConceptType, Double> weightA;

	@FXML
	private TableColumn<ConceptType, Double> weightB;

	@FXML
	private TableColumn<ConceptType, Double> weightC;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getConceptTypeData());
	}

	public TableView<ConceptType> getTable() {
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
		choices.add("weightA");
		weightA.setCellValueFactory(new PropertyValueFactory<>("weightA"));
		weightA.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		weightA.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setWeightA(event.getNewValue()); mainApp.reset();});
		choices.add("weightB");
		weightB.setCellValueFactory(new PropertyValueFactory<>("weightB"));
		weightB.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		weightB.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setWeightB(event.getNewValue()); mainApp.reset();});
		choices.add("weightC");
		weightC.setCellValueFactory(new PropertyValueFactory<>("weightC"));
		weightC.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		weightC.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setWeightC(event.getNewValue()); mainApp.reset();});
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getConceptTypeData());
		try {
			ObservableList<ConceptType> filteredItems = FXCollections.observableArrayList();
			for (ConceptType item : table.getItems()) {
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
