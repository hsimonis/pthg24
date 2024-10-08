package org.insightcentre.pthg24.controller;

import framework.gui.AbstractJfxMainWindow;
import framework.gui.Table3Controller;
import java.lang.Exception;
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
import org.insightcentre.pthg24.datamodel.AuthorDouble;

/**
 * Generated at 08:56:10 on 2024-09-25 */
public class AuthorDoubleController extends Table3Controller {
	@FXML
	private TableView<AuthorDouble> table;

	@FXML
	private TableColumn<AuthorDouble, String> name;

	@FXML
	private TableColumn<AuthorDouble, String> reason;

	@FXML
	private TableColumn<AuthorDouble, Author> author1;

	@FXML
	private TableColumn<AuthorDouble, Author> author2;

	@FXML
	private TableColumn<AuthorDouble, String> work1;

	@FXML
	private TableColumn<AuthorDouble, String> work2;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getAuthorDoubleData());
		author1.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getAuthorData()));
		author1.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setAuthor1(event.getNewValue()); mainApp.reset();});
		author2.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getAuthorData()));
		author2.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setAuthor2(event.getNewValue()); mainApp.reset();});
	}

	public TableView<AuthorDouble> getTable() {
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
		choices.add("reason");
		reason.setCellValueFactory(new PropertyValueFactory<>("reason"));
		reason.setCellFactory(TextFieldTableCell.forTableColumn());
		reason.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setReason(event.getNewValue()); mainApp.reset();});
		choices.add("author1");
		author1.setCellValueFactory(new PropertyValueFactory<>("author1"));
		choices.add("author2");
		author2.setCellValueFactory(new PropertyValueFactory<>("author2"));
		choices.add("work1");
		work1.setCellValueFactory(cellData -> new SimpleStringProperty(convert(cellData.getValue().getWork1())));
		choices.add("work2");
		work2.setCellValueFactory(cellData -> new SimpleStringProperty(convert(cellData.getValue().getWork2())));
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getAuthorDoubleData());
		try {
			ObservableList<AuthorDouble> filteredItems = FXCollections.observableArrayList();
			for (AuthorDouble item : table.getItems()) {
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
