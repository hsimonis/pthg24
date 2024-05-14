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
import org.insightcentre.pthg24.datamodel.DoiReference;
import org.insightcentre.pthg24.datamodel.MissingCross;
import org.insightcentre.pthg24.datamodel.MissingWork;
import org.insightcentre.pthg24.datamodel.Work;

/**
 * Generated at 19:13:04 on 2024-05-13 */
public class DoiReferenceController extends Table3Controller {
	@FXML
	private TableView<DoiReference> table;

	@FXML
	private TableColumn<DoiReference, String> name;

	@FXML
	private TableColumn<DoiReference, String> key;

	@FXML
	private TableColumn<DoiReference, Work> work;

	@FXML
	private TableColumn<DoiReference, Work> referredWork;

	@FXML
	private TableColumn<DoiReference, MissingWork> missingWork;

	@FXML
	private TableColumn<DoiReference, MissingCross> missingCross;

	@FXML
	private TableColumn<DoiReference, Integer> year;

	@FXML
	private TableColumn<DoiReference, String> author;

	@FXML
	private TableColumn<DoiReference, String> source;

	@FXML
	private TableColumn<DoiReference, String> title;

	@FXML
	private TableColumn<DoiReference, String> doi;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getDoiReferenceData());
		work.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getWorkData()));
		work.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setWork(event.getNewValue()); mainApp.reset();});
		referredWork.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getWorkData()));
		referredWork.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setReferredWork(event.getNewValue()); mainApp.reset();});
		missingWork.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getMissingWorkData()));
		missingWork.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setMissingWork(event.getNewValue()); mainApp.reset();});
		missingCross.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getMissingCrossData()));
		missingCross.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setMissingCross(event.getNewValue()); mainApp.reset();});
	}

	public TableView<DoiReference> getTable() {
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
		choices.add("key");
		key.setCellValueFactory(new PropertyValueFactory<>("key"));
		key.setCellFactory(TextFieldTableCell.forTableColumn());
		key.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setKey(event.getNewValue()); mainApp.reset();});
		choices.add("work");
		work.setCellValueFactory(new PropertyValueFactory<>("work"));
		choices.add("referredWork");
		referredWork.setCellValueFactory(new PropertyValueFactory<>("referredWork"));
		choices.add("missingWork");
		missingWork.setCellValueFactory(new PropertyValueFactory<>("missingWork"));
		choices.add("missingCross");
		missingCross.setCellValueFactory(new PropertyValueFactory<>("missingCross"));
		choices.add("year");
		year.setCellValueFactory(new PropertyValueFactory<>("year"));
		year.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		year.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setYear(event.getNewValue()); mainApp.reset();});
		choices.add("author");
		author.setCellValueFactory(new PropertyValueFactory<>("author"));
		author.setCellFactory(TextFieldTableCell.forTableColumn());
		author.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setAuthor(event.getNewValue()); mainApp.reset();});
		choices.add("source");
		source.setCellValueFactory(new PropertyValueFactory<>("source"));
		source.setCellFactory(TextFieldTableCell.forTableColumn());
		source.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setSource(event.getNewValue()); mainApp.reset();});
		choices.add("title");
		title.setCellValueFactory(new PropertyValueFactory<>("title"));
		title.setCellFactory(TextFieldTableCell.forTableColumn());
		title.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setTitle(event.getNewValue()); mainApp.reset();});
		choices.add("doi");
		doi.setCellValueFactory(new PropertyValueFactory<>("doi"));
		doi.setCellFactory(TextFieldTableCell.forTableColumn());
		doi.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setDoi(event.getNewValue()); mainApp.reset();});
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getDoiReferenceData());
		try {
			ObservableList<DoiReference> filteredItems = FXCollections.observableArrayList();
			for (DoiReference item : table.getItems()) {
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
