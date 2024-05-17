package org.insightcentre.pthg24.controller;

import framework.gui.AbstractJfxMainWindow;
import framework.gui.Table3Controller;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.reflect.Field;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.insightcentre.pthg24.GeneratedJfxApp;
import org.insightcentre.pthg24.datamodel.ScopusAffiliation;
import org.insightcentre.pthg24.datamodel.ScopusCity;
import org.insightcentre.pthg24.datamodel.ScopusCountry;

/**
 * Generated at 18:03:54 on 2024-05-16 */
public class ScopusAffiliationController extends Table3Controller {
	@FXML
	private TableView<ScopusAffiliation> table;

	@FXML
	private TableColumn<ScopusAffiliation, String> name;

	@FXML
	private TableColumn<ScopusAffiliation, String> inst;

	@FXML
	private TableColumn<ScopusAffiliation, ScopusCity> scopusCity;

	@FXML
	private TableColumn<ScopusAffiliation, Integer> workCount;

	@FXML
	private TableColumn<ScopusAffiliation, Integer> collabCount;

	@FXML
	private TableColumn<ScopusAffiliation, Integer> domesticCollabCount;

	@FXML
	private TableColumn<ScopusAffiliation, Integer> internationalCollabCount;

	@FXML
	private TableColumn<ScopusAffiliation, Double> collabFraction;

	@FXML
	private TableColumn<ScopusAffiliation, Double> domesticCollabFraction;

	@FXML
	private TableColumn<ScopusAffiliation, Double> internationalCollabFraction;

	@FXML
	private TableColumn<ScopusAffiliation, Double> collabPercentage;

	@FXML
	private TableColumn<ScopusAffiliation, Double> internationalPercentage;

	@FXML
	private TableColumn<ScopusAffiliation, ScopusCountry> scopusCountry;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getScopusAffiliationData());
		scopusCity.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getScopusCityData()));
		scopusCity.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setScopusCity(event.getNewValue()); mainApp.reset();});
	}

	public TableView<ScopusAffiliation> getTable() {
		return table;
	}

	@FXML
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		table.setTableMenuButtonVisible(true);
		table.setOnMouseClicked(event -> {if (event.isControlDown()) {mainApp.showObject(table.getFocusModel().getFocusedItem());}});
		ObservableList<String> choices = FXCollections.observableArrayList();
		choices.add("name");
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		name.setCellFactory(TextFieldTableCell.forTableColumn());
		name.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setName(event.getNewValue()); mainApp.reset();});
		choices.add("inst");
		inst.setCellValueFactory(new PropertyValueFactory<>("inst"));
		inst.setCellFactory(TextFieldTableCell.forTableColumn());
		inst.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setInst(event.getNewValue()); mainApp.reset();});
		choices.add("scopusCity");
		scopusCity.setCellValueFactory(new PropertyValueFactory<>("scopusCity"));
		choices.add("workCount");
		workCount.setCellValueFactory(new PropertyValueFactory<>("workCount"));
		workCount.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		workCount.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setWorkCount(event.getNewValue()); mainApp.reset();});
		choices.add("collabCount");
		collabCount.setCellValueFactory(new PropertyValueFactory<>("collabCount"));
		collabCount.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		collabCount.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCollabCount(event.getNewValue()); mainApp.reset();});
		choices.add("domesticCollabCount");
		domesticCollabCount.setCellValueFactory(new PropertyValueFactory<>("domesticCollabCount"));
		domesticCollabCount.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		domesticCollabCount.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setDomesticCollabCount(event.getNewValue()); mainApp.reset();});
		choices.add("internationalCollabCount");
		internationalCollabCount.setCellValueFactory(new PropertyValueFactory<>("internationalCollabCount"));
		internationalCollabCount.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		internationalCollabCount.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setInternationalCollabCount(event.getNewValue()); mainApp.reset();});
		choices.add("collabFraction");
		collabFraction.setCellValueFactory(new PropertyValueFactory<>("collabFraction"));
		collabFraction.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		collabFraction.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCollabFraction(event.getNewValue()); mainApp.reset();});
		choices.add("domesticCollabFraction");
		domesticCollabFraction.setCellValueFactory(new PropertyValueFactory<>("domesticCollabFraction"));
		domesticCollabFraction.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		domesticCollabFraction.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setDomesticCollabFraction(event.getNewValue()); mainApp.reset();});
		choices.add("internationalCollabFraction");
		internationalCollabFraction.setCellValueFactory(new PropertyValueFactory<>("internationalCollabFraction"));
		internationalCollabFraction.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		internationalCollabFraction.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setInternationalCollabFraction(event.getNewValue()); mainApp.reset();});
		choices.add("collabPercentage");
		collabPercentage.setCellValueFactory(new PropertyValueFactory<>("collabPercentage"));
		collabPercentage.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		collabPercentage.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCollabPercentage(event.getNewValue()); mainApp.reset();});
		choices.add("internationalPercentage");
		internationalPercentage.setCellValueFactory(new PropertyValueFactory<>("internationalPercentage"));
		internationalPercentage.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		internationalPercentage.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setInternationalPercentage(event.getNewValue()); mainApp.reset();});
		choices.add("scopusCity.scopusCountry");
		try {
			scopusCountry.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getScopusCity().getScopusCountry()));
		}
		catch (NullPointerException e) {
			System.err.println(e);
		}
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getScopusAffiliationData());
		try {
			ObservableList<ScopusAffiliation> filteredItems = FXCollections.observableArrayList();
			for (ScopusAffiliation item : table.getItems()) {
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
