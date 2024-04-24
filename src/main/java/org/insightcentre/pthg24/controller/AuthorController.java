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
import org.insightcentre.pthg24.datamodel.Author;

/**
 * Generated at 12:30:10 on 2024-04-24 */
public class AuthorController extends Table3Controller {
	@FXML
	private TableView<Author> table;

	@FXML
	private TableColumn<Author, String> name;

	@FXML
	private TableColumn<Author, String> shortName;

	@FXML
	private TableColumn<Author, String> familyName;

	@FXML
	private TableColumn<Author, String> crossFamily;

	@FXML
	private TableColumn<Author, String> crossGiven;

	@FXML
	private TableColumn<Author, String> orcid;

	@FXML
	private TableColumn<Author, String> key;

	@FXML
	private TableColumn<Author, Integer> nrWorks;

	@FXML
	private TableColumn<Author, Integer> nrCitations;

	@FXML
	private TableColumn<Author, Integer> nrBackgroundWorks;

	@FXML
	private TableColumn<Author, Integer> nrBackgroundCitations;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getAuthorData());
	}

	public TableView<Author> getTable() {
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
		choices.add("familyName");
		familyName.setCellValueFactory(new PropertyValueFactory<>("familyName"));
		familyName.setCellFactory(TextFieldTableCell.forTableColumn());
		familyName.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setFamilyName(event.getNewValue()); mainApp.reset();});
		choices.add("crossFamily");
		crossFamily.setCellValueFactory(new PropertyValueFactory<>("crossFamily"));
		crossFamily.setCellFactory(TextFieldTableCell.forTableColumn());
		crossFamily.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCrossFamily(event.getNewValue()); mainApp.reset();});
		choices.add("crossGiven");
		crossGiven.setCellValueFactory(new PropertyValueFactory<>("crossGiven"));
		crossGiven.setCellFactory(TextFieldTableCell.forTableColumn());
		crossGiven.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCrossGiven(event.getNewValue()); mainApp.reset();});
		choices.add("orcid");
		orcid.setCellValueFactory(new PropertyValueFactory<>("orcid"));
		orcid.setCellFactory(TextFieldTableCell.forTableColumn());
		orcid.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setOrcid(event.getNewValue()); mainApp.reset();});
		choices.add("key");
		key.setCellValueFactory(new PropertyValueFactory<>("key"));
		key.setCellFactory(TextFieldTableCell.forTableColumn());
		key.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setKey(event.getNewValue()); mainApp.reset();});
		choices.add("nrWorks");
		nrWorks.setCellValueFactory(new PropertyValueFactory<>("nrWorks"));
		nrWorks.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrWorks.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrWorks(event.getNewValue()); mainApp.reset();});
		choices.add("nrCitations");
		nrCitations.setCellValueFactory(new PropertyValueFactory<>("nrCitations"));
		nrCitations.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrCitations.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrCitations(event.getNewValue()); mainApp.reset();});
		choices.add("nrBackgroundWorks");
		nrBackgroundWorks.setCellValueFactory(new PropertyValueFactory<>("nrBackgroundWorks"));
		nrBackgroundWorks.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrBackgroundWorks.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrBackgroundWorks(event.getNewValue()); mainApp.reset();});
		choices.add("nrBackgroundCitations");
		nrBackgroundCitations.setCellValueFactory(new PropertyValueFactory<>("nrBackgroundCitations"));
		nrBackgroundCitations.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrBackgroundCitations.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrBackgroundCitations(event.getNewValue()); mainApp.reset();});
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getAuthorData());
		try {
			ObservableList<Author> filteredItems = FXCollections.observableArrayList();
			for (Author item : table.getItems()) {
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
