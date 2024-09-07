package org.insightcentre.pthg24.controller;

import framework.gui.AbstractJfxMainWindow;
import framework.gui.Table3Controller;
import java.lang.Boolean;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.reflect.Field;
import javafx.beans.property.Property;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import org.insightcentre.pthg24.GeneratedJfxApp;
import org.insightcentre.pthg24.datamodel.Journal;
import org.insightcentre.pthg24.datamodel.Publisher;

/**
 * Generated at 08:45:01 on 2024-09-07 */
public class JournalController extends Table3Controller {
	@FXML
	private TableView<Journal> table;

	@FXML
	private TableColumn<Journal, String> name;

	@FXML
	private TableColumn<Journal, String> shortName;

	@FXML
	private TableColumn<Journal, Publisher> publisher;

	@FXML
	private TableColumn<Journal, String> issn;

	@FXML
	private TableColumn<Journal, Integer> nrArticles;

	@FXML
	private TableColumn<Journal, Integer> nrBackgroundArticles;

	@FXML
	private TableColumn<Journal, Integer> nrCitations;

	@FXML
	private TableColumn<Journal, Integer> nrBackgroundCitations;

	@FXML
	private TableColumn<Journal, Boolean> isBlocked;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getJournalData());
		publisher.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getPublisherData()));
		publisher.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setPublisher(event.getNewValue()); mainApp.reset();});
	}

	public TableView<Journal> getTable() {
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
		choices.add("publisher");
		publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
		choices.add("issn");
		issn.setCellValueFactory(new PropertyValueFactory<>("issn"));
		issn.setCellFactory(TextFieldTableCell.forTableColumn());
		issn.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setIssn(event.getNewValue()); mainApp.reset();});
		choices.add("nrArticles");
		nrArticles.setCellValueFactory(new PropertyValueFactory<>("nrArticles"));
		nrArticles.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrArticles.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrArticles(event.getNewValue()); mainApp.reset();});
		choices.add("nrBackgroundArticles");
		nrBackgroundArticles.setCellValueFactory(new PropertyValueFactory<>("nrBackgroundArticles"));
		nrBackgroundArticles.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrBackgroundArticles.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrBackgroundArticles(event.getNewValue()); mainApp.reset();});
		choices.add("nrCitations");
		nrCitations.setCellValueFactory(new PropertyValueFactory<>("nrCitations"));
		nrCitations.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrCitations.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrCitations(event.getNewValue()); mainApp.reset();});
		choices.add("nrBackgroundCitations");
		nrBackgroundCitations.setCellValueFactory(new PropertyValueFactory<>("nrBackgroundCitations"));
		nrBackgroundCitations.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrBackgroundCitations.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrBackgroundCitations(event.getNewValue()); mainApp.reset();});
		choices.add("isBlocked");
		isBlocked.setCellValueFactory(new IsBlockedCallback());
		isBlocked.setCellFactory(CheckBoxTableCell.forTableColumn(isBlocked));
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getJournalData());
		try {
			ObservableList<Journal> filteredItems = FXCollections.observableArrayList();
			for (Journal item : table.getItems()) {
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

	class IsBlockedCallback implements Callback<TableColumn.CellDataFeatures<Journal, Boolean>, ObservableValue<Boolean>> {
		@Override
		public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Journal, Boolean> cellData) {
			Property<Boolean> prop = cellData.getValue().isBlockedWrapperProperty();
			prop.addListener(new ChangeListener<Boolean>() {
				@Override
				@SuppressWarnings("rawtypes")
				public void changed(ObservableValue observable, Boolean oldValue, Boolean newValue) {
					cellData.getValue().setIsBlocked(newValue);
				}
			});
			return prop;
		}
	}
}
