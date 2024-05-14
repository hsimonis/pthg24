package org.insightcentre.pthg24.controller;

import framework.gui.AbstractJfxMainWindow;
import framework.gui.Table3Controller;
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
import org.insightcentre.pthg24.datamodel.Reference;
import org.insightcentre.pthg24.datamodel.Work;

/**
 * Generated at 19:13:04 on 2024-05-13 */
public class ReferenceController extends Table3Controller {
	@FXML
	private TableView<Reference> table;

	@FXML
	private TableColumn<Reference, String> name;

	@FXML
	private TableColumn<Reference, String> oci;

	@FXML
	private TableColumn<Reference, Work> citedWork;

	@FXML
	private TableColumn<Reference, Work> citingWork;

	@FXML
	private TableColumn<Reference, String> cited;

	@FXML
	private TableColumn<Reference, String> citing;

	@FXML
	private TableColumn<Reference, String> creation;

	@FXML
	private TableColumn<Reference, String> timespan;

	@FXML
	private TableColumn<Reference, String> authorSC;

	@FXML
	private TableColumn<Reference, String> journalSC;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getReferenceData());
		citedWork.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getWorkData()));
		citedWork.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCitedWork(event.getNewValue()); mainApp.reset();});
		citingWork.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getWorkData()));
		citingWork.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCitingWork(event.getNewValue()); mainApp.reset();});
	}

	public TableView<Reference> getTable() {
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
		choices.add("oci");
		oci.setCellValueFactory(new PropertyValueFactory<>("oci"));
		oci.setCellFactory(TextFieldTableCell.forTableColumn());
		oci.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setOci(event.getNewValue()); mainApp.reset();});
		choices.add("citedWork");
		citedWork.setCellValueFactory(new PropertyValueFactory<>("citedWork"));
		choices.add("citingWork");
		citingWork.setCellValueFactory(new PropertyValueFactory<>("citingWork"));
		choices.add("cited");
		cited.setCellValueFactory(new PropertyValueFactory<>("cited"));
		cited.setCellFactory(TextFieldTableCell.forTableColumn());
		cited.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCited(event.getNewValue()); mainApp.reset();});
		choices.add("citing");
		citing.setCellValueFactory(new PropertyValueFactory<>("citing"));
		citing.setCellFactory(TextFieldTableCell.forTableColumn());
		citing.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCiting(event.getNewValue()); mainApp.reset();});
		choices.add("creation");
		creation.setCellValueFactory(new PropertyValueFactory<>("creation"));
		creation.setCellFactory(TextFieldTableCell.forTableColumn());
		creation.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCreation(event.getNewValue()); mainApp.reset();});
		choices.add("timespan");
		timespan.setCellValueFactory(new PropertyValueFactory<>("timespan"));
		timespan.setCellFactory(TextFieldTableCell.forTableColumn());
		timespan.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setTimespan(event.getNewValue()); mainApp.reset();});
		choices.add("authorSC");
		authorSC.setCellValueFactory(new PropertyValueFactory<>("authorSC"));
		authorSC.setCellFactory(TextFieldTableCell.forTableColumn());
		authorSC.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setAuthorSC(event.getNewValue()); mainApp.reset();});
		choices.add("journalSC");
		journalSC.setCellValueFactory(new PropertyValueFactory<>("journalSC"));
		journalSC.setCellFactory(TextFieldTableCell.forTableColumn());
		journalSC.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setJournalSC(event.getNewValue()); mainApp.reset();});
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getReferenceData());
		try {
			ObservableList<Reference> filteredItems = FXCollections.observableArrayList();
			for (Reference item : table.getItems()) {
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
