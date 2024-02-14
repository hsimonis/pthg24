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
import org.insightcentre.pthg24.datamodel.Article;
import org.insightcentre.pthg24.datamodel.Journal;

/**
 * Generated at 09:07:04 on 2024-02-14 */
public class ArticleController extends Table3Controller {
	@FXML
	private TableView<Article> table;

	@FXML
	private TableColumn<Article, String> name;

	@FXML
	private TableColumn<Article, String> key;

	@FXML
	private TableColumn<Article, String> author;

	@FXML
	private TableColumn<Article, String> authors;

	@FXML
	private TableColumn<Article, String> title;

	@FXML
	private TableColumn<Article, String> url;

	@FXML
	private TableColumn<Article, String> doi;

	@FXML
	private TableColumn<Article, String> localCopy;

	@FXML
	private TableColumn<Article, Integer> year;

	@FXML
	private TableColumn<Article, String> pages;

	@FXML
	private TableColumn<Article, Integer> nrPages;

	@FXML
	private TableColumn<Article, String> dataAvail;

	@FXML
	private TableColumn<Article, String> codeAvail;

	@FXML
	private TableColumn<Article, String> solutionAvail;

	@FXML
	private TableColumn<Article, String> cpSystem;

	@FXML
	private TableColumn<Article, String> constraints;

	@FXML
	private TableColumn<Article, String> basedOn;

	@FXML
	private TableColumn<Article, String> citations;

	@FXML
	private TableColumn<Article, Journal> journal;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getArticleData());
		journal.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getJournalData()));
		journal.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setJournal(event.getNewValue()); mainApp.reset();});
	}

	public TableView<Article> getTable() {
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
		choices.add("author");
		author.setCellValueFactory(new PropertyValueFactory<>("author"));
		author.setCellFactory(TextFieldTableCell.forTableColumn());
		author.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setAuthor(event.getNewValue()); mainApp.reset();});
		choices.add("authors");
		authors.setCellValueFactory(cellData -> new SimpleStringProperty(convert(cellData.getValue().getAuthors())));
		choices.add("title");
		title.setCellValueFactory(new PropertyValueFactory<>("title"));
		title.setCellFactory(TextFieldTableCell.forTableColumn());
		title.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setTitle(event.getNewValue()); mainApp.reset();});
		choices.add("url");
		url.setCellValueFactory(new PropertyValueFactory<>("url"));
		url.setCellFactory(TextFieldTableCell.forTableColumn());
		url.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setUrl(event.getNewValue()); mainApp.reset();});
		choices.add("doi");
		doi.setCellValueFactory(new PropertyValueFactory<>("doi"));
		doi.setCellFactory(TextFieldTableCell.forTableColumn());
		doi.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setDoi(event.getNewValue()); mainApp.reset();});
		choices.add("localCopy");
		localCopy.setCellValueFactory(new PropertyValueFactory<>("localCopy"));
		localCopy.setCellFactory(TextFieldTableCell.forTableColumn());
		localCopy.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setLocalCopy(event.getNewValue()); mainApp.reset();});
		choices.add("year");
		year.setCellValueFactory(new PropertyValueFactory<>("year"));
		year.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		year.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setYear(event.getNewValue()); mainApp.reset();});
		choices.add("pages");
		pages.setCellValueFactory(new PropertyValueFactory<>("pages"));
		pages.setCellFactory(TextFieldTableCell.forTableColumn());
		pages.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setPages(event.getNewValue()); mainApp.reset();});
		choices.add("nrPages");
		nrPages.setCellValueFactory(new PropertyValueFactory<>("nrPages"));
		nrPages.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrPages.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrPages(event.getNewValue()); mainApp.reset();});
		choices.add("dataAvail");
		dataAvail.setCellValueFactory(new PropertyValueFactory<>("dataAvail"));
		dataAvail.setCellFactory(TextFieldTableCell.forTableColumn());
		dataAvail.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setDataAvail(event.getNewValue()); mainApp.reset();});
		choices.add("codeAvail");
		codeAvail.setCellValueFactory(new PropertyValueFactory<>("codeAvail"));
		codeAvail.setCellFactory(TextFieldTableCell.forTableColumn());
		codeAvail.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCodeAvail(event.getNewValue()); mainApp.reset();});
		choices.add("solutionAvail");
		solutionAvail.setCellValueFactory(new PropertyValueFactory<>("solutionAvail"));
		solutionAvail.setCellFactory(TextFieldTableCell.forTableColumn());
		solutionAvail.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setSolutionAvail(event.getNewValue()); mainApp.reset();});
		choices.add("cpSystem");
		cpSystem.setCellValueFactory(new PropertyValueFactory<>("cpSystem"));
		cpSystem.setCellFactory(TextFieldTableCell.forTableColumn());
		cpSystem.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCpSystem(event.getNewValue()); mainApp.reset();});
		choices.add("constraints");
		constraints.setCellValueFactory(new PropertyValueFactory<>("constraints"));
		constraints.setCellFactory(TextFieldTableCell.forTableColumn());
		constraints.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setConstraints(event.getNewValue()); mainApp.reset();});
		choices.add("basedOn");
		basedOn.setCellValueFactory(new PropertyValueFactory<>("basedOn"));
		basedOn.setCellFactory(TextFieldTableCell.forTableColumn());
		basedOn.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setBasedOn(event.getNewValue()); mainApp.reset();});
		choices.add("citations");
		citations.setCellValueFactory(new PropertyValueFactory<>("citations"));
		citations.setCellFactory(TextFieldTableCell.forTableColumn());
		citations.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCitations(event.getNewValue()); mainApp.reset();});
		choices.add("journal");
		journal.setCellValueFactory(new PropertyValueFactory<>("journal"));
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getArticleData());
		try {
			ObservableList<Article> filteredItems = FXCollections.observableArrayList();
			for (Article item : table.getItems()) {
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
