package org.insightcentre.pthg24.controller;

import framework.gui.AbstractJfxMainWindow;
import framework.gui.Table3Controller;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.reflect.Field;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.insightcentre.pthg24.GeneratedJfxApp;
import org.insightcentre.pthg24.datamodel.Author;
import org.insightcentre.pthg24.datamodel.Authorship;
import org.insightcentre.pthg24.datamodel.Work;

/**
 * Generated at 15:28:48 on 2024-05-18 */
public class AuthorshipController extends Table3Controller {
	@FXML
	private TableView<Authorship> table;

	@FXML
	private TableColumn<Authorship, String> name;

	@FXML
	private TableColumn<Authorship, Integer> seqNr;

	@FXML
	private TableColumn<Authorship, String> sequence;

	@FXML
	private TableColumn<Authorship, Author> author;

	@FXML
	private TableColumn<Authorship, Work> work;

	@FXML
	private TableColumn<Authorship, String> affiliation;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getAuthorshipData());
		author.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getAuthorData()));
		author.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setAuthor(event.getNewValue()); mainApp.reset();});
		work.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getWorkData()));
		work.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setWork(event.getNewValue()); mainApp.reset();});
	}

	public TableView<Authorship> getTable() {
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
		choices.add("seqNr");
		seqNr.setCellValueFactory(new PropertyValueFactory<>("seqNr"));
		seqNr.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		seqNr.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setSeqNr(event.getNewValue()); mainApp.reset();});
		choices.add("sequence");
		sequence.setCellValueFactory(new PropertyValueFactory<>("sequence"));
		sequence.setCellFactory(TextFieldTableCell.forTableColumn());
		sequence.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setSequence(event.getNewValue()); mainApp.reset();});
		choices.add("author");
		author.setCellValueFactory(new PropertyValueFactory<>("author"));
		choices.add("work");
		work.setCellValueFactory(new PropertyValueFactory<>("work"));
		choices.add("affiliation");
		affiliation.setCellValueFactory(cellData -> new SimpleStringProperty(convert(cellData.getValue().getAffiliation())));
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getAuthorshipData());
		try {
			ObservableList<Authorship> filteredItems = FXCollections.observableArrayList();
			for (Authorship item : table.getItems()) {
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
