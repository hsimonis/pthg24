package org.insightcentre.pthg24.controller;

import framework.gui.AbstractJfxMainWindow;
import framework.gui.Table3Controller;
import java.lang.Exception;
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
import org.insightcentre.pthg24.datamodel.Work;
import org.insightcentre.pthg24.datamodel.WorkAffiliation;

/**
 * Generated at 12:30:10 on 2024-04-24 */
public class WorkAffiliationController extends Table3Controller {
	@FXML
	private TableView<WorkAffiliation> table;

	@FXML
	private TableColumn<WorkAffiliation, String> name;

	@FXML
	private TableColumn<WorkAffiliation, Work> work;

	@FXML
	private TableColumn<WorkAffiliation, ScopusAffiliation> scopusAffiliation;

	@FXML
	private TableColumn<WorkAffiliation, ScopusCity> scopusCity;

	@FXML
	private TableColumn<WorkAffiliation, ScopusCountry> scopusCountry;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getWorkAffiliationData());
		work.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getWorkData()));
		work.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setWork(event.getNewValue()); mainApp.reset();});
		scopusAffiliation.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getScopusAffiliationData()));
		scopusAffiliation.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setScopusAffiliation(event.getNewValue()); mainApp.reset();});
	}

	public TableView<WorkAffiliation> getTable() {
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
		choices.add("work");
		work.setCellValueFactory(new PropertyValueFactory<>("work"));
		choices.add("scopusAffiliation");
		scopusAffiliation.setCellValueFactory(new PropertyValueFactory<>("scopusAffiliation"));
		choices.add("scopusAffiliation.scopusCity");
		try {
			scopusCity.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getScopusAffiliation().getScopusCity()));
		}
		catch (NullPointerException e) {
			System.err.println(e);
		}
		choices.add("scopusAffiliation.scopusCity.scopusCountry");
		try {
			scopusCountry.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getScopusAffiliation().getScopusCity().getScopusCountry()));
		}
		catch (NullPointerException e) {
			System.err.println(e);
		}
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getWorkAffiliationData());
		try {
			ObservableList<WorkAffiliation> filteredItems = FXCollections.observableArrayList();
			for (WorkAffiliation item : table.getItems()) {
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
