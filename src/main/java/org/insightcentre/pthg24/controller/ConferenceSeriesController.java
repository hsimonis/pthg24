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
import org.insightcentre.pthg24.datamodel.ConferenceSeries;

/**
 * Generated at 15:28:48 on 2024-05-18 */
public class ConferenceSeriesController extends Table3Controller {
	@FXML
	private TableView<ConferenceSeries> table;

	@FXML
	private TableColumn<ConferenceSeries, String> name;

	@FXML
	private TableColumn<ConferenceSeries, String> description;

	@FXML
	private TableColumn<ConferenceSeries, String> regExpr;

	@FXML
	private TableColumn<ConferenceSeries, Integer> nrPapers;

	@FXML
	private TableColumn<ConferenceSeries, Integer> nrCitations;

	@FXML
	private TableColumn<ConferenceSeries, Integer> nrBackgroundPapers;

	@FXML
	private TableColumn<ConferenceSeries, Integer> nrBackgroundCitations;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getConferenceSeriesData());
	}

	public TableView<ConferenceSeries> getTable() {
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
		choices.add("description");
		description.setCellValueFactory(new PropertyValueFactory<>("description"));
		description.setCellFactory(TextFieldTableCell.forTableColumn());
		description.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setDescription(event.getNewValue()); mainApp.reset();});
		choices.add("regExpr");
		regExpr.setCellValueFactory(new PropertyValueFactory<>("regExpr"));
		regExpr.setCellFactory(TextFieldTableCell.forTableColumn());
		regExpr.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setRegExpr(event.getNewValue()); mainApp.reset();});
		choices.add("nrPapers");
		nrPapers.setCellValueFactory(new PropertyValueFactory<>("nrPapers"));
		nrPapers.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrPapers.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrPapers(event.getNewValue()); mainApp.reset();});
		choices.add("nrCitations");
		nrCitations.setCellValueFactory(new PropertyValueFactory<>("nrCitations"));
		nrCitations.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrCitations.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrCitations(event.getNewValue()); mainApp.reset();});
		choices.add("nrBackgroundPapers");
		nrBackgroundPapers.setCellValueFactory(new PropertyValueFactory<>("nrBackgroundPapers"));
		nrBackgroundPapers.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrBackgroundPapers.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrBackgroundPapers(event.getNewValue()); mainApp.reset();});
		choices.add("nrBackgroundCitations");
		nrBackgroundCitations.setCellValueFactory(new PropertyValueFactory<>("nrBackgroundCitations"));
		nrBackgroundCitations.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrBackgroundCitations.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrBackgroundCitations(event.getNewValue()); mainApp.reset();});
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getConferenceSeriesData());
		try {
			ObservableList<ConferenceSeries> filteredItems = FXCollections.observableArrayList();
			for (ConferenceSeries item : table.getItems()) {
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
