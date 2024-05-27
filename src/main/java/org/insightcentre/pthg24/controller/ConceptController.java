package org.insightcentre.pthg24.controller;

import framework.gui.AbstractJfxMainWindow;
import framework.gui.Table3Controller;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.reflect.Field;
import javafx.beans.property.Property;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import org.insightcentre.pthg24.GeneratedJfxApp;
import org.insightcentre.pthg24.datamodel.Concept;
import org.insightcentre.pthg24.datamodel.ConceptType;

/**
 * Generated at 06:46:00 on 2024-05-25 */
public class ConceptController extends Table3Controller {
	@FXML
	private TableView<Concept> table;

	@FXML
	private TableColumn<Concept, String> name;

	@FXML
	private TableColumn<Concept, String> shortName;

	@FXML
	private TableColumn<Concept, ConceptType> conceptType;

	@FXML
	private TableColumn<Concept, String> label;

	@FXML
	private TableColumn<Concept, String> regExpr;

	@FXML
	private TableColumn<Concept, Boolean> caseSensitive;

	@FXML
	private TableColumn<Concept, Integer> revision;

	@FXML
	private TableColumn<Concept, Double> weight;

	@FXML
	private TableColumn<Concept, Integer> nrOccurrences;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getConceptData());
		conceptType.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getConceptTypeData()));
		conceptType.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setConceptType(event.getNewValue()); mainApp.reset();});
	}

	public TableView<Concept> getTable() {
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
		choices.add("shortName");
		shortName.setCellValueFactory(new PropertyValueFactory<>("shortName"));
		shortName.setCellFactory(TextFieldTableCell.forTableColumn());
		shortName.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setShortName(event.getNewValue()); mainApp.reset();});
		choices.add("conceptType");
		conceptType.setCellValueFactory(new PropertyValueFactory<>("conceptType"));
		choices.add("label");
		label.setCellValueFactory(new PropertyValueFactory<>("label"));
		label.setCellFactory(TextFieldTableCell.forTableColumn());
		label.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setLabel(event.getNewValue()); mainApp.reset();});
		choices.add("regExpr");
		regExpr.setCellValueFactory(new PropertyValueFactory<>("regExpr"));
		regExpr.setCellFactory(TextFieldTableCell.forTableColumn());
		regExpr.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setRegExpr(event.getNewValue()); mainApp.reset();});
		choices.add("caseSensitive");
		caseSensitive.setCellValueFactory(new CaseSensitiveCallback());
		caseSensitive.setCellFactory(CheckBoxTableCell.forTableColumn(caseSensitive));
		choices.add("revision");
		revision.setCellValueFactory(new PropertyValueFactory<>("revision"));
		revision.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		revision.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setRevision(event.getNewValue()); mainApp.reset();});
		choices.add("weight");
		weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
		weight.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		weight.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setWeight(event.getNewValue()); mainApp.reset();});
		choices.add("nrOccurrences");
		nrOccurrences.setCellValueFactory(new PropertyValueFactory<>("nrOccurrences"));
		nrOccurrences.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrOccurrences.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrOccurrences(event.getNewValue()); mainApp.reset();});
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getConceptData());
		try {
			ObservableList<Concept> filteredItems = FXCollections.observableArrayList();
			for (Concept item : table.getItems()) {
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

	class CaseSensitiveCallback implements Callback<TableColumn.CellDataFeatures<Concept, Boolean>, ObservableValue<Boolean>> {
		@Override
		public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Concept, Boolean> cellData) {
			Property<Boolean> prop = cellData.getValue().caseSensitiveWrapperProperty();
			prop.addListener(new ChangeListener<Boolean>() {
				@Override
				@SuppressWarnings("rawtypes")
				public void changed(ObservableValue observable, Boolean oldValue, Boolean newValue) {
					cellData.getValue().setCaseSensitive(newValue);
				}
			});
			return prop;
		}
	}
}
