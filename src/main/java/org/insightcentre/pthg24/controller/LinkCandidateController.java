package org.insightcentre.pthg24.controller;

import framework.gui.AbstractJfxMainWindow;
import framework.gui.Table3Controller;
import java.lang.Double;
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
import org.insightcentre.pthg24.datamodel.Citation;
import org.insightcentre.pthg24.datamodel.LinkCandidate;
import org.insightcentre.pthg24.datamodel.MissingWork;
import org.insightcentre.pthg24.datamodel.Work;

/**
 * Generated code
 */
public class LinkCandidateController extends Table3Controller {
	@FXML
	private TableView<LinkCandidate> table;

	@FXML
	private TableColumn<LinkCandidate, String> name;

	@FXML
	private TableColumn<LinkCandidate, Work> work;

	@FXML
	private TableColumn<LinkCandidate, MissingWork> missingWork;

	@FXML
	private TableColumn<LinkCandidate, Citation> citation;

	@FXML
	private TableColumn<LinkCandidate, Double> authorMatch;

	@FXML
	private TableColumn<LinkCandidate, Double> titleMatch;

	@FXML
	private TableColumn<LinkCandidate, String> link;

	@FXML
	private TableColumn<LinkCandidate, String> journal;

	@FXML
	private TableColumn<LinkCandidate, Integer> year;

	@FXML
	private TableColumn<LinkCandidate, String> wAuthor;

	@FXML
	private TableColumn<LinkCandidate, String> mwAuthor;

	@FXML
	private TableColumn<LinkCandidate, String> wTitle;

	@FXML
	private TableColumn<LinkCandidate, String> mwTitle;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setEditable(true);
		table.setItems(mainApp.getLinkCandidateData());
		work.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getWorkData()));
		work.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setWork(event.getNewValue()); mainApp.reset();});
		missingWork.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getMissingWorkData()));
		missingWork.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setMissingWork(event.getNewValue()); mainApp.reset();});
		citation.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getCitationData()));
		citation.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCitation(event.getNewValue()); mainApp.reset();});
	}

	public TableView<LinkCandidate> getTable() {
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
		choices.add("work");
		work.setCellValueFactory(new PropertyValueFactory<>("work"));
		choices.add("missingWork");
		missingWork.setCellValueFactory(new PropertyValueFactory<>("missingWork"));
		choices.add("citation");
		citation.setCellValueFactory(new PropertyValueFactory<>("citation"));
		choices.add("authorMatch");
		authorMatch.setCellValueFactory(new PropertyValueFactory<>("authorMatch"));
		authorMatch.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		authorMatch.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setAuthorMatch(event.getNewValue()); mainApp.reset();});
		choices.add("titleMatch");
		titleMatch.setCellValueFactory(new PropertyValueFactory<>("titleMatch"));
		titleMatch.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		titleMatch.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setTitleMatch(event.getNewValue()); mainApp.reset();});
		choices.add("link");
		link.setCellValueFactory(new PropertyValueFactory<>("link"));
		link.setCellFactory(TextFieldTableCell.forTableColumn());
		link.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setLink(event.getNewValue()); mainApp.reset();});
		choices.add("journal");
		journal.setCellValueFactory(new PropertyValueFactory<>("journal"));
		journal.setCellFactory(TextFieldTableCell.forTableColumn());
		journal.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setJournal(event.getNewValue()); mainApp.reset();});
		choices.add("year");
		year.setCellValueFactory(new PropertyValueFactory<>("year"));
		year.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		year.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setYear(event.getNewValue()); mainApp.reset();});
		choices.add("wAuthor");
		wAuthor.setCellValueFactory(new PropertyValueFactory<>("wAuthor"));
		wAuthor.setCellFactory(TextFieldTableCell.forTableColumn());
		wAuthor.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setWAuthor(event.getNewValue()); mainApp.reset();});
		choices.add("mwAuthor");
		mwAuthor.setCellValueFactory(new PropertyValueFactory<>("mwAuthor"));
		mwAuthor.setCellFactory(TextFieldTableCell.forTableColumn());
		mwAuthor.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setMwAuthor(event.getNewValue()); mainApp.reset();});
		choices.add("wTitle");
		wTitle.setCellValueFactory(new PropertyValueFactory<>("wTitle"));
		wTitle.setCellFactory(TextFieldTableCell.forTableColumn());
		wTitle.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setWTitle(event.getNewValue()); mainApp.reset();});
		choices.add("mwTitle");
		mwTitle.setCellValueFactory(new PropertyValueFactory<>("mwTitle"));
		mwTitle.setCellFactory(TextFieldTableCell.forTableColumn());
		mwTitle.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setMwTitle(event.getNewValue()); mainApp.reset();});
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getLinkCandidateData());
		try {
			ObservableList<LinkCandidate> filteredItems = FXCollections.observableArrayList();
			for (LinkCandidate item : table.getItems()) {
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
