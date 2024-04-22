package org.insightcentre.pthg24.controller;

import framework.gui.AbstractJfxMainWindow;
import framework.gui.Table3Controller;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.reflect.Field;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.insightcentre.pthg24.GeneratedJfxApp;
import org.insightcentre.pthg24.datamodel.ScopusAffiliation;
import org.insightcentre.pthg24.datamodel.ScopusCity;
import org.insightcentre.pthg24.datamodel.ScopusCountry;

/**
 * Generated at 16:41:52 on 2024-04-22 */
public class ScopusAffiliationController extends Table3Controller {
	@FXML
	private TableView<ScopusAffiliation> table;

	@FXML
	private TableColumn<ScopusAffiliation, String> name;

	@FXML
	private TableColumn<ScopusAffiliation, String> inst;

	@FXML
	private TableColumn<ScopusAffiliation, ScopusCity> scopusCity;

	@FXML
	private TableColumn<ScopusAffiliation, Integer> workCount;

	@FXML
	private TableColumn<ScopusAffiliation, ScopusCountry> scopusCountry;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getScopusAffiliationData());
		scopusCity.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getScopusCityData()));
		scopusCity.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setScopusCity(event.getNewValue()); mainApp.reset();});
	}

	public TableView<ScopusAffiliation> getTable() {
		return table;
	}

	@FXML
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		table.setTableMenuButtonVisible(true);
		table.setOnMouseClicked(event -> {if (event.isControlDown()) {mainApp.showObject(table.getFocusModel().getFocusedItem());}});
		ObservableList<String> choices = FXCollections.observableArrayList();
		choices.add("name");
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		name.setCellFactory(TextFieldTableCell.forTableColumn());
		name.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setName(event.getNewValue()); mainApp.reset();});
		choices.add("inst");
		inst.setCellValueFactory(new PropertyValueFactory<>("inst"));
		inst.setCellFactory(TextFieldTableCell.forTableColumn());
		inst.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setInst(event.getNewValue()); mainApp.reset();});
		choices.add("scopusCity");
		scopusCity.setCellValueFactory(new PropertyValueFactory<>("scopusCity"));
		choices.add("workCount");
		workCount.setCellValueFactory(new PropertyValueFactory<>("workCount"));
		workCount.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		workCount.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setWorkCount(event.getNewValue()); mainApp.reset();});
		choices.add("scopusCity.scopusCountry");
		try {
			scopusCountry.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getScopusCity().getScopusCountry()));
		}
		catch (NullPointerException e) {
			System.err.println(e);
		}
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getScopusAffiliationData());
		try {
			ObservableList<ScopusAffiliation> filteredItems = FXCollections.observableArrayList();
			for (ScopusAffiliation item : table.getItems()) {
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
