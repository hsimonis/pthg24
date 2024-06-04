package org.insightcentre.pthg24.controller;

import framework.gui.AbstractJfxMainWindow;
import framework.gui.Table3Controller;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.reflect.Field;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
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
import org.insightcentre.pthg24.datamodel.OtherWork;
import org.insightcentre.pthg24.datamodel.WorkType;

/**
 * Generated at 11:17:58 on 2024-06-04 */
public class OtherWorkController extends Table3Controller {
	@FXML
	private TableView<OtherWork> table;

	@FXML
	private TableColumn<OtherWork, String> name;

	@FXML
	private TableColumn<OtherWork, String> shortName;

	@FXML
	private TableColumn<OtherWork, Integer> nr;

	@FXML
	private TableColumn<OtherWork, String> key;

	@FXML
	private TableColumn<OtherWork, WorkType> workType;

	@FXML
	private TableColumn<OtherWork, String> editor;

	@FXML
	private TableColumn<OtherWork, String> author;

	@FXML
	private TableColumn<OtherWork, String> authors;

	@FXML
	private TableColumn<OtherWork, Integer> workCount;

	@FXML
	private TableColumn<OtherWork, String> title;

	@FXML
	private TableColumn<OtherWork, String> source;

	@FXML
	private TableColumn<OtherWork, String> url;

	@FXML
	private TableColumn<OtherWork, String> doi;

	@FXML
	private TableColumn<OtherWork, Integer> year;

	@FXML
	private TableColumn<OtherWork, Double> relevance;

	@FXML
	private TableColumn<OtherWork, Boolean> isFound;

	@FXML
	private TableColumn<OtherWork, Boolean> isSelected;

	@FXML
	private TableColumn<OtherWork, String> concept;

	@FXML
	private TableColumn<OtherWork, String> keywords;

	@FXML
	private TableColumn<OtherWork, String> abstractText;

	@FXML
	private TableColumn<OtherWork, String> volume;

	@FXML
	private TableColumn<OtherWork, String> issue;

	@FXML
	private TableColumn<OtherWork, String> page;

	@FXML
	private TableColumn<OtherWork, String> chapter;

	@FXML
	private TableColumn<OtherWork, String> publisher;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getOtherWorkData());
		ObservableList<WorkType> workTypeValues = FXCollections.observableArrayList(WorkType.values());
		workType.setCellFactory(ComboBoxTableCell.forTableColumn(workTypeValues));
		workType.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setWorkType(event.getNewValue()); mainApp.reset();});
	}

	public TableView<OtherWork> getTable() {
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
		choices.add("nr");
		nr.setCellValueFactory(new PropertyValueFactory<>("nr"));
		nr.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nr.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNr(event.getNewValue()); mainApp.reset();});
		choices.add("key");
		key.setCellValueFactory(new PropertyValueFactory<>("key"));
		key.setCellFactory(TextFieldTableCell.forTableColumn());
		key.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setKey(event.getNewValue()); mainApp.reset();});
		choices.add("workType");
		workType.setCellValueFactory(new PropertyValueFactory<>("workType"));
		choices.add("editor");
		editor.setCellValueFactory(new PropertyValueFactory<>("editor"));
		editor.setCellFactory(TextFieldTableCell.forTableColumn());
		editor.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setEditor(event.getNewValue()); mainApp.reset();});
		choices.add("author");
		author.setCellValueFactory(new PropertyValueFactory<>("author"));
		author.setCellFactory(TextFieldTableCell.forTableColumn());
		author.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setAuthor(event.getNewValue()); mainApp.reset();});
		choices.add("authors");
		authors.setCellValueFactory(cellData -> new SimpleStringProperty(convert(cellData.getValue().getAuthors())));
		choices.add("workCount");
		workCount.setCellValueFactory(new PropertyValueFactory<>("workCount"));
		workCount.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		workCount.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setWorkCount(event.getNewValue()); mainApp.reset();});
		choices.add("title");
		title.setCellValueFactory(new PropertyValueFactory<>("title"));
		title.setCellFactory(TextFieldTableCell.forTableColumn());
		title.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setTitle(event.getNewValue()); mainApp.reset();});
		choices.add("source");
		source.setCellValueFactory(new PropertyValueFactory<>("source"));
		source.setCellFactory(TextFieldTableCell.forTableColumn());
		source.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setSource(event.getNewValue()); mainApp.reset();});
		choices.add("url");
		url.setCellValueFactory(new PropertyValueFactory<>("url"));
		url.setCellFactory(TextFieldTableCell.forTableColumn());
		url.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setUrl(event.getNewValue()); mainApp.reset();});
		choices.add("doi");
		doi.setCellValueFactory(new PropertyValueFactory<>("doi"));
		doi.setCellFactory(TextFieldTableCell.forTableColumn());
		doi.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setDoi(event.getNewValue()); mainApp.reset();});
		choices.add("year");
		year.setCellValueFactory(new PropertyValueFactory<>("year"));
		year.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		year.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setYear(event.getNewValue()); mainApp.reset();});
		choices.add("relevance");
		relevance.setCellValueFactory(new PropertyValueFactory<>("relevance"));
		relevance.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		relevance.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setRelevance(event.getNewValue()); mainApp.reset();});
		choices.add("isFound");
		isFound.setCellValueFactory(new IsFoundCallback());
		isFound.setCellFactory(CheckBoxTableCell.forTableColumn(isFound));
		choices.add("isSelected");
		isSelected.setCellValueFactory(new IsSelectedCallback());
		isSelected.setCellFactory(CheckBoxTableCell.forTableColumn(isSelected));
		choices.add("concept");
		concept.setCellValueFactory(cellData -> new SimpleStringProperty(convert(cellData.getValue().getConcept())));
		choices.add("keywords");
		keywords.setCellValueFactory(new PropertyValueFactory<>("keywords"));
		keywords.setCellFactory(TextFieldTableCell.forTableColumn());
		keywords.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setKeywords(event.getNewValue()); mainApp.reset();});
		choices.add("abstractText");
		abstractText.setCellValueFactory(new PropertyValueFactory<>("abstractText"));
		abstractText.setCellFactory(TextFieldTableCell.forTableColumn());
		abstractText.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setAbstractText(event.getNewValue()); mainApp.reset();});
		choices.add("volume");
		volume.setCellValueFactory(new PropertyValueFactory<>("volume"));
		volume.setCellFactory(TextFieldTableCell.forTableColumn());
		volume.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setVolume(event.getNewValue()); mainApp.reset();});
		choices.add("issue");
		issue.setCellValueFactory(new PropertyValueFactory<>("issue"));
		issue.setCellFactory(TextFieldTableCell.forTableColumn());
		issue.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setIssue(event.getNewValue()); mainApp.reset();});
		choices.add("page");
		page.setCellValueFactory(new PropertyValueFactory<>("page"));
		page.setCellFactory(TextFieldTableCell.forTableColumn());
		page.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setPage(event.getNewValue()); mainApp.reset();});
		choices.add("chapter");
		chapter.setCellValueFactory(new PropertyValueFactory<>("chapter"));
		chapter.setCellFactory(TextFieldTableCell.forTableColumn());
		chapter.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setChapter(event.getNewValue()); mainApp.reset();});
		choices.add("publisher");
		publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
		publisher.setCellFactory(TextFieldTableCell.forTableColumn());
		publisher.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setPublisher(event.getNewValue()); mainApp.reset();});
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getOtherWorkData());
		try {
			ObservableList<OtherWork> filteredItems = FXCollections.observableArrayList();
			for (OtherWork item : table.getItems()) {
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

	class IsFoundCallback implements Callback<TableColumn.CellDataFeatures<OtherWork, Boolean>, ObservableValue<Boolean>> {
		@Override
		public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<OtherWork, Boolean> cellData) {
			Property<Boolean> prop = cellData.getValue().isFoundWrapperProperty();
			prop.addListener(new ChangeListener<Boolean>() {
				@Override
				@SuppressWarnings("rawtypes")
				public void changed(ObservableValue observable, Boolean oldValue, Boolean newValue) {
					cellData.getValue().setIsFound(newValue);
				}
			});
			return prop;
		}
	}

	class IsSelectedCallback implements Callback<TableColumn.CellDataFeatures<OtherWork, Boolean>, ObservableValue<Boolean>> {
		@Override
		public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<OtherWork, Boolean> cellData) {
			Property<Boolean> prop = cellData.getValue().isSelectedWrapperProperty();
			prop.addListener(new ChangeListener<Boolean>() {
				@Override
				@SuppressWarnings("rawtypes")
				public void changed(ObservableValue observable, Boolean oldValue, Boolean newValue) {
					cellData.getValue().setIsSelected(newValue);
				}
			});
			return prop;
		}
	}
}
