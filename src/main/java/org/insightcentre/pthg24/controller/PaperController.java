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
import org.insightcentre.pthg24.datamodel.OpenAccessType;
import org.insightcentre.pthg24.datamodel.Paper;
import org.insightcentre.pthg24.datamodel.Proceedings;
import org.insightcentre.pthg24.datamodel.Publisher;
import org.insightcentre.pthg24.datamodel.SourceGroup;

/**
 * Generated at 06:46:00 on 2024-05-25 */
public class PaperController extends Table3Controller {
	@FXML
	private TableView<Paper> table;

	@FXML
	private TableColumn<Paper, String> name;

	@FXML
	private TableColumn<Paper, String> shortName;

	@FXML
	private TableColumn<Paper, Integer> nr;

	@FXML
	private TableColumn<Paper, Integer> nrEdges;

	@FXML
	private TableColumn<Paper, Integer> cluster;

	@FXML
	private TableColumn<Paper, String> key;

	@FXML
	private TableColumn<Paper, String> author;

	@FXML
	private TableColumn<Paper, String> authors;

	@FXML
	private TableColumn<Paper, String> title;

	@FXML
	private TableColumn<Paper, Publisher> publisher;

	@FXML
	private TableColumn<Paper, String> url;

	@FXML
	private TableColumn<Paper, String> doi;

	@FXML
	private TableColumn<Paper, String> issn;

	@FXML
	private TableColumn<Paper, String> localCopy;

	@FXML
	private TableColumn<Paper, Integer> year;

	@FXML
	private TableColumn<Paper, String> pages;

	@FXML
	private TableColumn<Paper, Integer> nrPages;

	@FXML
	private TableColumn<Paper, Integer> nrHyperLinks;

	@FXML
	private TableColumn<Paper, Boolean> background;

	@FXML
	private TableColumn<Paper, SourceGroup> sourceGroup;

	@FXML
	private TableColumn<Paper, String> dataAvail;

	@FXML
	private TableColumn<Paper, String> codeAvail;

	@FXML
	private TableColumn<Paper, String> solutionAvail;

	@FXML
	private TableColumn<Paper, String> cpSystem;

	@FXML
	private TableColumn<Paper, String> classification;

	@FXML
	private TableColumn<Paper, String> constraints;

	@FXML
	private TableColumn<Paper, String> relatedTo;

	@FXML
	private TableColumn<Paper, String> openAccess;

	@FXML
	private TableColumn<Paper, OpenAccessType> openAccessType;

	@FXML
	private TableColumn<Paper, Integer> nrConcepts;

	@FXML
	private TableColumn<Paper, Integer> nrCitations;

	@FXML
	private TableColumn<Paper, Integer> nrReferences;

	@FXML
	private TableColumn<Paper, Integer> crossrefCitations;

	@FXML
	private TableColumn<Paper, Integer> crossrefReferences;

	@FXML
	private TableColumn<Paper, Integer> wosCitations;

	@FXML
	private TableColumn<Paper, Integer> wosReferences;

	@FXML
	private TableColumn<Paper, Integer> scopusCitations;

	@FXML
	private TableColumn<Paper, Integer> nrCitationsCovered;

	@FXML
	private TableColumn<Paper, Integer> nrReferencesCovered;

	@FXML
	private TableColumn<Paper, Double> percentCitationsCovered;

	@FXML
	private TableColumn<Paper, Double> percentReferencesCovered;

	@FXML
	private TableColumn<Paper, Integer> maxCitations;

	@FXML
	private TableColumn<Paper, Integer> rangeCitations;

	@FXML
	private TableColumn<Paper, Boolean> doiStatus;

	@FXML
	private TableColumn<Paper, Boolean> crossrefStatus;

	@FXML
	private TableColumn<Paper, Boolean> scopusStatus;

	@FXML
	private TableColumn<Paper, Boolean> wosStatus;

	@FXML
	private TableColumn<Paper, Double> relevanceTitle;

	@FXML
	private TableColumn<Paper, Double> relevanceAbstract;

	@FXML
	private TableColumn<Paper, Double> relevanceBody;

	@FXML
	private TableColumn<Paper, String> language;

	@FXML
	private TableColumn<Paper, String> abstractText;

	@FXML
	private TableColumn<Paper, String> concept;

	@FXML
	private TableColumn<Paper, Proceedings> proceedings;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getPaperData());
		publisher.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getPublisherData()));
		publisher.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setPublisher(event.getNewValue()); mainApp.reset();});
		sourceGroup.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getSourceGroupData()));
		sourceGroup.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setSourceGroup(event.getNewValue()); mainApp.reset();});
		ObservableList<OpenAccessType> openAccessTypeValues = FXCollections.observableArrayList(OpenAccessType.values());
		openAccessType.setCellFactory(ComboBoxTableCell.forTableColumn(openAccessTypeValues));
		openAccessType.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setOpenAccessType(event.getNewValue()); mainApp.reset();});
		proceedings.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getProceedingsData()));
		proceedings.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setProceedings(event.getNewValue()); mainApp.reset();});
	}

	public TableView<Paper> getTable() {
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
		choices.add("nrEdges");
		nrEdges.setCellValueFactory(new PropertyValueFactory<>("nrEdges"));
		nrEdges.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrEdges.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrEdges(event.getNewValue()); mainApp.reset();});
		choices.add("cluster");
		cluster.setCellValueFactory(new PropertyValueFactory<>("cluster"));
		cluster.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		cluster.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCluster(event.getNewValue()); mainApp.reset();});
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
		choices.add("publisher");
		publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
		choices.add("url");
		url.setCellValueFactory(new PropertyValueFactory<>("url"));
		url.setCellFactory(TextFieldTableCell.forTableColumn());
		url.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setUrl(event.getNewValue()); mainApp.reset();});
		choices.add("doi");
		doi.setCellValueFactory(new PropertyValueFactory<>("doi"));
		doi.setCellFactory(TextFieldTableCell.forTableColumn());
		doi.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setDoi(event.getNewValue()); mainApp.reset();});
		choices.add("issn");
		issn.setCellValueFactory(new PropertyValueFactory<>("issn"));
		issn.setCellFactory(TextFieldTableCell.forTableColumn());
		issn.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setIssn(event.getNewValue()); mainApp.reset();});
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
		choices.add("nrHyperLinks");
		nrHyperLinks.setCellValueFactory(new PropertyValueFactory<>("nrHyperLinks"));
		nrHyperLinks.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrHyperLinks.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrHyperLinks(event.getNewValue()); mainApp.reset();});
		choices.add("background");
		background.setCellValueFactory(new BackgroundCallback());
		background.setCellFactory(CheckBoxTableCell.forTableColumn(background));
		choices.add("sourceGroup");
		sourceGroup.setCellValueFactory(new PropertyValueFactory<>("sourceGroup"));
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
		choices.add("classification");
		classification.setCellValueFactory(new PropertyValueFactory<>("classification"));
		classification.setCellFactory(TextFieldTableCell.forTableColumn());
		classification.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setClassification(event.getNewValue()); mainApp.reset();});
		choices.add("constraints");
		constraints.setCellValueFactory(new PropertyValueFactory<>("constraints"));
		constraints.setCellFactory(TextFieldTableCell.forTableColumn());
		constraints.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setConstraints(event.getNewValue()); mainApp.reset();});
		choices.add("relatedTo");
		relatedTo.setCellValueFactory(new PropertyValueFactory<>("relatedTo"));
		relatedTo.setCellFactory(TextFieldTableCell.forTableColumn());
		relatedTo.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setRelatedTo(event.getNewValue()); mainApp.reset();});
		choices.add("openAccess");
		openAccess.setCellValueFactory(new PropertyValueFactory<>("openAccess"));
		openAccess.setCellFactory(TextFieldTableCell.forTableColumn());
		openAccess.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setOpenAccess(event.getNewValue()); mainApp.reset();});
		choices.add("openAccessType");
		openAccessType.setCellValueFactory(new PropertyValueFactory<>("openAccessType"));
		choices.add("nrConcepts");
		nrConcepts.setCellValueFactory(new PropertyValueFactory<>("nrConcepts"));
		nrConcepts.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrConcepts.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrConcepts(event.getNewValue()); mainApp.reset();});
		choices.add("nrCitations");
		nrCitations.setCellValueFactory(new PropertyValueFactory<>("nrCitations"));
		nrCitations.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrCitations.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrCitations(event.getNewValue()); mainApp.reset();});
		choices.add("nrReferences");
		nrReferences.setCellValueFactory(new PropertyValueFactory<>("nrReferences"));
		nrReferences.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrReferences.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrReferences(event.getNewValue()); mainApp.reset();});
		choices.add("crossrefCitations");
		crossrefCitations.setCellValueFactory(new PropertyValueFactory<>("crossrefCitations"));
		crossrefCitations.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		crossrefCitations.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCrossrefCitations(event.getNewValue()); mainApp.reset();});
		choices.add("crossrefReferences");
		crossrefReferences.setCellValueFactory(new PropertyValueFactory<>("crossrefReferences"));
		crossrefReferences.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		crossrefReferences.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCrossrefReferences(event.getNewValue()); mainApp.reset();});
		choices.add("wosCitations");
		wosCitations.setCellValueFactory(new PropertyValueFactory<>("wosCitations"));
		wosCitations.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		wosCitations.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setWosCitations(event.getNewValue()); mainApp.reset();});
		choices.add("wosReferences");
		wosReferences.setCellValueFactory(new PropertyValueFactory<>("wosReferences"));
		wosReferences.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		wosReferences.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setWosReferences(event.getNewValue()); mainApp.reset();});
		choices.add("scopusCitations");
		scopusCitations.setCellValueFactory(new PropertyValueFactory<>("scopusCitations"));
		scopusCitations.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		scopusCitations.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setScopusCitations(event.getNewValue()); mainApp.reset();});
		choices.add("nrCitationsCovered");
		nrCitationsCovered.setCellValueFactory(new PropertyValueFactory<>("nrCitationsCovered"));
		nrCitationsCovered.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrCitationsCovered.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrCitationsCovered(event.getNewValue()); mainApp.reset();});
		choices.add("nrReferencesCovered");
		nrReferencesCovered.setCellValueFactory(new PropertyValueFactory<>("nrReferencesCovered"));
		nrReferencesCovered.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrReferencesCovered.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrReferencesCovered(event.getNewValue()); mainApp.reset();});
		choices.add("percentCitationsCovered");
		percentCitationsCovered.setCellValueFactory(new PropertyValueFactory<>("percentCitationsCovered"));
		percentCitationsCovered.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		percentCitationsCovered.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setPercentCitationsCovered(event.getNewValue()); mainApp.reset();});
		choices.add("percentReferencesCovered");
		percentReferencesCovered.setCellValueFactory(new PropertyValueFactory<>("percentReferencesCovered"));
		percentReferencesCovered.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		percentReferencesCovered.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setPercentReferencesCovered(event.getNewValue()); mainApp.reset();});
		choices.add("maxCitations");
		maxCitations.setCellValueFactory(new PropertyValueFactory<>("maxCitations"));
		maxCitations.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		maxCitations.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setMaxCitations(event.getNewValue()); mainApp.reset();});
		choices.add("rangeCitations");
		rangeCitations.setCellValueFactory(new PropertyValueFactory<>("rangeCitations"));
		rangeCitations.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		rangeCitations.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setRangeCitations(event.getNewValue()); mainApp.reset();});
		choices.add("doiStatus");
		doiStatus.setCellValueFactory(new DoiStatusCallback());
		doiStatus.setCellFactory(CheckBoxTableCell.forTableColumn(doiStatus));
		choices.add("crossrefStatus");
		crossrefStatus.setCellValueFactory(new CrossrefStatusCallback());
		crossrefStatus.setCellFactory(CheckBoxTableCell.forTableColumn(crossrefStatus));
		choices.add("scopusStatus");
		scopusStatus.setCellValueFactory(new ScopusStatusCallback());
		scopusStatus.setCellFactory(CheckBoxTableCell.forTableColumn(scopusStatus));
		choices.add("wosStatus");
		wosStatus.setCellValueFactory(new WosStatusCallback());
		wosStatus.setCellFactory(CheckBoxTableCell.forTableColumn(wosStatus));
		choices.add("relevanceTitle");
		relevanceTitle.setCellValueFactory(new PropertyValueFactory<>("relevanceTitle"));
		relevanceTitle.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		relevanceTitle.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setRelevanceTitle(event.getNewValue()); mainApp.reset();});
		choices.add("relevanceAbstract");
		relevanceAbstract.setCellValueFactory(new PropertyValueFactory<>("relevanceAbstract"));
		relevanceAbstract.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		relevanceAbstract.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setRelevanceAbstract(event.getNewValue()); mainApp.reset();});
		choices.add("relevanceBody");
		relevanceBody.setCellValueFactory(new PropertyValueFactory<>("relevanceBody"));
		relevanceBody.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		relevanceBody.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setRelevanceBody(event.getNewValue()); mainApp.reset();});
		choices.add("language");
		language.setCellValueFactory(new PropertyValueFactory<>("language"));
		language.setCellFactory(TextFieldTableCell.forTableColumn());
		language.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setLanguage(event.getNewValue()); mainApp.reset();});
		choices.add("abstractText");
		abstractText.setCellValueFactory(new PropertyValueFactory<>("abstractText"));
		abstractText.setCellFactory(TextFieldTableCell.forTableColumn());
		abstractText.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setAbstractText(event.getNewValue()); mainApp.reset();});
		choices.add("concept");
		concept.setCellValueFactory(cellData -> new SimpleStringProperty(convert(cellData.getValue().getConcept())));
		choices.add("proceedings");
		proceedings.setCellValueFactory(new PropertyValueFactory<>("proceedings"));
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getPaperData());
		try {
			ObservableList<Paper> filteredItems = FXCollections.observableArrayList();
			for (Paper item : table.getItems()) {
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

	class BackgroundCallback implements Callback<TableColumn.CellDataFeatures<Paper, Boolean>, ObservableValue<Boolean>> {
		@Override
		public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Paper, Boolean> cellData) {
			Property<Boolean> prop = cellData.getValue().backgroundWrapperProperty();
			prop.addListener(new ChangeListener<Boolean>() {
				@Override
				@SuppressWarnings("rawtypes")
				public void changed(ObservableValue observable, Boolean oldValue, Boolean newValue) {
					cellData.getValue().setBackground(newValue);
				}
			});
			return prop;
		}
	}

	class DoiStatusCallback implements Callback<TableColumn.CellDataFeatures<Paper, Boolean>, ObservableValue<Boolean>> {
		@Override
		public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Paper, Boolean> cellData) {
			Property<Boolean> prop = cellData.getValue().doiStatusWrapperProperty();
			prop.addListener(new ChangeListener<Boolean>() {
				@Override
				@SuppressWarnings("rawtypes")
				public void changed(ObservableValue observable, Boolean oldValue, Boolean newValue) {
					cellData.getValue().setDoiStatus(newValue);
				}
			});
			return prop;
		}
	}

	class CrossrefStatusCallback implements Callback<TableColumn.CellDataFeatures<Paper, Boolean>, ObservableValue<Boolean>> {
		@Override
		public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Paper, Boolean> cellData) {
			Property<Boolean> prop = cellData.getValue().crossrefStatusWrapperProperty();
			prop.addListener(new ChangeListener<Boolean>() {
				@Override
				@SuppressWarnings("rawtypes")
				public void changed(ObservableValue observable, Boolean oldValue, Boolean newValue) {
					cellData.getValue().setCrossrefStatus(newValue);
				}
			});
			return prop;
		}
	}

	class ScopusStatusCallback implements Callback<TableColumn.CellDataFeatures<Paper, Boolean>, ObservableValue<Boolean>> {
		@Override
		public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Paper, Boolean> cellData) {
			Property<Boolean> prop = cellData.getValue().scopusStatusWrapperProperty();
			prop.addListener(new ChangeListener<Boolean>() {
				@Override
				@SuppressWarnings("rawtypes")
				public void changed(ObservableValue observable, Boolean oldValue, Boolean newValue) {
					cellData.getValue().setScopusStatus(newValue);
				}
			});
			return prop;
		}
	}

	class WosStatusCallback implements Callback<TableColumn.CellDataFeatures<Paper, Boolean>, ObservableValue<Boolean>> {
		@Override
		public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Paper, Boolean> cellData) {
			Property<Boolean> prop = cellData.getValue().wosStatusWrapperProperty();
			prop.addListener(new ChangeListener<Boolean>() {
				@Override
				@SuppressWarnings("rawtypes")
				public void changed(ObservableValue observable, Boolean oldValue, Boolean newValue) {
					cellData.getValue().setWosStatus(newValue);
				}
			});
			return prop;
		}
	}
}
