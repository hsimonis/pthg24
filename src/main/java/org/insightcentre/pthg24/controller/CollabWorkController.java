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
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.insightcentre.pthg24.GeneratedJfxApp;
import org.insightcentre.pthg24.datamodel.CollabWork;
import org.insightcentre.pthg24.datamodel.ScopusAffiliation;
import org.insightcentre.pthg24.datamodel.Work;

/**
 * Generated at 16:50:29 on 2024-05-02 */
public class CollabWorkController extends Table3Controller {
	@FXML
	private TableView<CollabWork> table;

	@FXML
	private TableColumn<CollabWork, String> name;

	@FXML
	private TableColumn<CollabWork, ScopusAffiliation> affiliation1;

	@FXML
	private TableColumn<CollabWork, ScopusAffiliation> affiliation2;

	@FXML
	private TableColumn<CollabWork, Work> work;

	@FXML
	private TableColumn<CollabWork, Double> fraction;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getCollabWorkData());
		affiliation1.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getScopusAffiliationData()));
		affiliation1.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setAffiliation1(event.getNewValue()); mainApp.reset();});
		affiliation2.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getScopusAffiliationData()));
		affiliation2.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setAffiliation2(event.getNewValue()); mainApp.reset();});
		work.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getWorkData()));
		work.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setWork(event.getNewValue()); mainApp.reset();});
	}

	public TableView<CollabWork> getTable() {
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
		choices.add("affiliation1");
		affiliation1.setCellValueFactory(new PropertyValueFactory<>("affiliation1"));
		choices.add("affiliation2");
		affiliation2.setCellValueFactory(new PropertyValueFactory<>("affiliation2"));
		choices.add("work");
		work.setCellValueFactory(new PropertyValueFactory<>("work"));
		choices.add("fraction");
		fraction.setCellValueFactory(new PropertyValueFactory<>("fraction"));
		fraction.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		fraction.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setFraction(event.getNewValue()); mainApp.reset();});
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getCollabWorkData());
		try {
			ObservableList<CollabWork> filteredItems = FXCollections.observableArrayList();
			for (CollabWork item : table.getItems()) {
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
