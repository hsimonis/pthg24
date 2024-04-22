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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.insightcentre.pthg24.GeneratedJfxApp;
import org.insightcentre.pthg24.datamodel.MissingCross;

/**
 * Generated at 16:41:52 on 2024-04-22 */
public class MissingCrossController extends Table3Controller {
	@FXML
	private TableView<MissingCross> table;

	@FXML
	private TableColumn<MissingCross, String> name;

	@FXML
	private TableColumn<MissingCross, String> doi;

	@FXML
	private TableColumn<MissingCross, Integer> count;

	@FXML
	private TableColumn<MissingCross, Integer> year;

	@FXML
	private TableColumn<MissingCross, String> author;

	@FXML
	private TableColumn<MissingCross, String> source;

	@FXML
	private TableColumn<MissingCross, String> title;

	@FXML
	private TableColumn<MissingCross, String> url;

	@FXML
	private TableColumn<MissingCross, String> type;

	@FXML
	private TableColumn<MissingCross, Integer> crossrefReferences;

	@FXML
	private TableColumn<MissingCross, Integer> crossrefCitations;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getMissingCrossData());
	}

	public TableView<MissingCross> getTable() {
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
		choices.add("doi");
		doi.setCellValueFactory(new PropertyValueFactory<>("doi"));
		doi.setCellFactory(TextFieldTableCell.forTableColumn());
		doi.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setDoi(event.getNewValue()); mainApp.reset();});
		choices.add("count");
		count.setCellValueFactory(new PropertyValueFactory<>("count"));
		count.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		count.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCount(event.getNewValue()); mainApp.reset();});
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
		choices.add("url");
		url.setCellValueFactory(new PropertyValueFactory<>("url"));
		url.setCellFactory(TextFieldTableCell.forTableColumn());
		url.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setUrl(event.getNewValue()); mainApp.reset();});
		choices.add("type");
		type.setCellValueFactory(new PropertyValueFactory<>("type"));
		type.setCellFactory(TextFieldTableCell.forTableColumn());
		type.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setType(event.getNewValue()); mainApp.reset();});
		choices.add("crossrefReferences");
		crossrefReferences.setCellValueFactory(new PropertyValueFactory<>("crossrefReferences"));
		crossrefReferences.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		crossrefReferences.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCrossrefReferences(event.getNewValue()); mainApp.reset();});
		choices.add("crossrefCitations");
		crossrefCitations.setCellValueFactory(new PropertyValueFactory<>("crossrefCitations"));
		crossrefCitations.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		crossrefCitations.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCrossrefCitations(event.getNewValue()); mainApp.reset();});
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getMissingCrossData());
		try {
			ObservableList<MissingCross> filteredItems = FXCollections.observableArrayList();
			for (MissingCross item : table.getItems()) {
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
