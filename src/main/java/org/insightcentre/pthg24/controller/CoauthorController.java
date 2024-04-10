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
import org.insightcentre.pthg24.datamodel.Author;
import org.insightcentre.pthg24.datamodel.Coauthor;

/**
 * Generated at 13:06:16 on 2024-04-09 */
public class CoauthorController extends Table3Controller {
	@FXML
	private TableView<Coauthor> table;

	@FXML
	private TableColumn<Coauthor, String> name;

	@FXML
	private TableColumn<Coauthor, Author> author1;

	@FXML
	private TableColumn<Coauthor, Author> author2;

	@FXML
	private TableColumn<Coauthor, Integer> nrWorks;

	@FXML
	private TableColumn<Coauthor, Integer> nrCites;

	@FXML
	private TableColumn<Coauthor, Integer> earliestYear;

	@FXML
	private TableColumn<Coauthor, Integer> latestYear;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getCoauthorData());
		author1.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getAuthorData()));
		author1.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setAuthor1(event.getNewValue()); mainApp.reset();});
		author2.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getAuthorData()));
		author2.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setAuthor2(event.getNewValue()); mainApp.reset();});
	}

	public TableView<Coauthor> getTable() {
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
		choices.add("author1");
		author1.setCellValueFactory(new PropertyValueFactory<>("author1"));
		choices.add("author2");
		author2.setCellValueFactory(new PropertyValueFactory<>("author2"));
		choices.add("nrWorks");
		nrWorks.setCellValueFactory(new PropertyValueFactory<>("nrWorks"));
		nrWorks.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrWorks.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrWorks(event.getNewValue()); mainApp.reset();});
		choices.add("nrCites");
		nrCites.setCellValueFactory(new PropertyValueFactory<>("nrCites"));
		nrCites.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrCites.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrCites(event.getNewValue()); mainApp.reset();});
		choices.add("earliestYear");
		earliestYear.setCellValueFactory(new PropertyValueFactory<>("earliestYear"));
		earliestYear.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		earliestYear.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setEarliestYear(event.getNewValue()); mainApp.reset();});
		choices.add("latestYear");
		latestYear.setCellValueFactory(new PropertyValueFactory<>("latestYear"));
		latestYear.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		latestYear.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setLatestYear(event.getNewValue()); mainApp.reset();});
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getCoauthorData());
		try {
			ObservableList<Coauthor> filteredItems = FXCollections.observableArrayList();
			for (Coauthor item : table.getItems()) {
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
