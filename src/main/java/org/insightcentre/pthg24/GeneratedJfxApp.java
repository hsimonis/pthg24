package org.insightcentre.pthg24;

import framework.ApplicationDatasetInterface;
import framework.gui.AbstractJfxMainWindow;
import framework.gui.BaseController;
import framework.gui.StatusException;
import java.io.File;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.insightcentre.pthg24.controller.RootController;
import org.insightcentre.pthg24.datamodel.ApplicationDifference;
import org.insightcentre.pthg24.datamodel.ApplicationWarning;
import org.insightcentre.pthg24.datamodel.Article;
import org.insightcentre.pthg24.datamodel.Author;
import org.insightcentre.pthg24.datamodel.Authorship;
import org.insightcentre.pthg24.datamodel.Collection;
import org.insightcentre.pthg24.datamodel.Concept;
import org.insightcentre.pthg24.datamodel.ConceptWork;
import org.insightcentre.pthg24.datamodel.InCollection;
import org.insightcentre.pthg24.datamodel.Journal;
import org.insightcentre.pthg24.datamodel.Paper;
import org.insightcentre.pthg24.datamodel.PhDThesis;
import org.insightcentre.pthg24.datamodel.Proceedings;
import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.datamodel.School;
import org.insightcentre.pthg24.datamodel.Work;
import org.insightcentre.pthg24.datamodel.XMLLoader;

/**
 * Generated at 16:26:12 on 2024-02-25 */
public class GeneratedJfxApp extends AbstractJfxMainWindow {
	static {
		FREEMARKER_CFG.setClassForTemplateLoading(GeneratedJfxApp.class, "C:/Users/hsimonis/Documents/Github/pthg24/site/web");
	}

	public Scenario basebase;

	protected List<BaseController> controllers = new ArrayList<>();

	private RootController controller;

	private ObservableList<Scenario> scenarioData = FXCollections.observableArrayList();

	private ObservableList<ApplicationDifference> applicationDifferenceData = FXCollections.observableArrayList();

	private ObservableList<ApplicationWarning> applicationWarningData = FXCollections.observableArrayList();

	private ObservableList<Concept> conceptData = FXCollections.observableArrayList();

	private ObservableList<Author> authorData = FXCollections.observableArrayList();

	private ObservableList<Work> workData = FXCollections.observableArrayList();

	private ObservableList<Paper> paperData = FXCollections.observableArrayList();

	private ObservableList<Article> articleData = FXCollections.observableArrayList();

	private ObservableList<PhDThesis> phDThesisData = FXCollections.observableArrayList();

	private ObservableList<InCollection> inCollectionData = FXCollections.observableArrayList();

	private ObservableList<Authorship> authorshipData = FXCollections.observableArrayList();

	private ObservableList<Proceedings> proceedingsData = FXCollections.observableArrayList();

	private ObservableList<Journal> journalData = FXCollections.observableArrayList();

	private ObservableList<School> schoolData = FXCollections.observableArrayList();

	private ObservableList<Collection> collectionData = FXCollections.observableArrayList();

	private ObservableList<ConceptWork> conceptWorkData = FXCollections.observableArrayList();

	public GeneratedJfxApp() {
		super("pthg24", "HolyGrail 2024", "*.data", "C:/Users/hsimonis/Documents/Github/pthg24");
		fs = minimalDataset();
		reset();
		tableViews.put("Concept", "Concept");
		tableViews.put("Author", "Author");
		tableViews.put("Work", "Work");
		tableViews.put("Paper", "Paper");
		tableViews.put("Article", "Article");
		tableViews.put("PhDThesis", "PhDThesis");
		tableViews.put("InCollection", "InCollection");
		tableViews.put("Authorship", "Authorship");
		tableViews.put("Proceedings", "Proceedings");
		tableViews.put("Journal", "Journal");
		tableViews.put("School", "School");
		tableViews.put("Collection", "Collection");
		tableViews.put("ConceptWork", "ConceptWork");
		tableViews.put("Scenario", "Scenario");
		tableViews.put("Scenario Differences", "ApplicationDifference");
		tableViews.put("Warnings", "ApplicationWarning");
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		super.start(primaryStage);
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("view/RootLayout.fxml"));
			BorderPane rootLayout = (BorderPane) loader.load();
			controller = loader.getController();
			controller.setMainApp(this);
			Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
			rootLayout.setPrefWidth(bounds.getWidth() * 0.7);
			rootLayout.setPrefHeight(bounds.getHeight() * 0.7);
			rootLayout.setCenter(tabPane);
			Scene scene = new Scene(rootLayout);
			URL url = getClass().getResource("/framework/gui/css/theme.css");
			if (url != null) {
				scene.getStylesheets().addAll(url.toExternalForm());
			}
			primaryStage.setScene(scene);
			primaryStage.setTitle(applicationTitle);
			primaryStage.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showView(String name) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(String.format("view/%s.fxml", name)));
			Tab tab = (Tab) loader.load();
			showTab(tab);
			BaseController controller = (BaseController) loader.getController();
			controller.setMainApp(this);
			controllers.add(controller);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setStatus(String text) {
		controller.setStatus(text);
	}

	@Override
	public ApplicationDatasetInterface minimalDataset() {
		Scenario base = new Scenario();
		base.setDirty(false);
		return base;
	}

	@Override
	public ApplicationDatasetInterface loadXML(File file) throws StatusException {
		return (Scenario) new XMLLoader().loadXML(file);
	}

	@Override
	public void reset() {
		Scenario base = (Scenario) fs;
		scenarioData.clear();
		scenarioData.addAll(base.getListScenario());
		applicationDifferenceData.clear();
		applicationDifferenceData.addAll(base.getListApplicationDifference());
		applicationWarningData.clear();
		applicationWarningData.addAll(base.getListApplicationWarning());
		conceptData.clear();
		conceptData.addAll(base.getListConcept());
		authorData.clear();
		authorData.addAll(base.getListAuthor());
		workData.clear();
		workData.addAll(base.getListWork());
		paperData.clear();
		paperData.addAll(base.getListPaper());
		articleData.clear();
		articleData.addAll(base.getListArticle());
		phDThesisData.clear();
		phDThesisData.addAll(base.getListPhDThesis());
		inCollectionData.clear();
		inCollectionData.addAll(base.getListInCollection());
		authorshipData.clear();
		authorshipData.addAll(base.getListAuthorship());
		proceedingsData.clear();
		proceedingsData.addAll(base.getListProceedings());
		journalData.clear();
		journalData.addAll(base.getListJournal());
		schoolData.clear();
		schoolData.addAll(base.getListSchool());
		collectionData.clear();
		collectionData.addAll(base.getListCollection());
		conceptWorkData.clear();
		conceptWorkData.addAll(base.getListConceptWork());
		for (BaseController controller : controllers) {
			controller.setMainApp(this);
		}
	}

	public ObservableList<Scenario> getScenarioData() {
		return scenarioData;
	}

	public ObservableList<ApplicationDifference> getApplicationDifferenceData() {
		return applicationDifferenceData;
	}

	public ObservableList<ApplicationWarning> getApplicationWarningData() {
		return applicationWarningData;
	}

	public ObservableList<Concept> getConceptData() {
		return conceptData;
	}

	public ObservableList<Author> getAuthorData() {
		return authorData;
	}

	public ObservableList<Work> getWorkData() {
		return workData;
	}

	public ObservableList<Paper> getPaperData() {
		return paperData;
	}

	public ObservableList<Article> getArticleData() {
		return articleData;
	}

	public ObservableList<PhDThesis> getPhDThesisData() {
		return phDThesisData;
	}

	public ObservableList<InCollection> getInCollectionData() {
		return inCollectionData;
	}

	public ObservableList<Authorship> getAuthorshipData() {
		return authorshipData;
	}

	public ObservableList<Proceedings> getProceedingsData() {
		return proceedingsData;
	}

	public ObservableList<Journal> getJournalData() {
		return journalData;
	}

	public ObservableList<School> getSchoolData() {
		return schoolData;
	}

	public ObservableList<Collection> getCollectionData() {
		return collectionData;
	}

	public ObservableList<ConceptWork> getConceptWorkData() {
		return conceptWorkData;
	}
}
