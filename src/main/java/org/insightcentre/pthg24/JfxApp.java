package org.insightcentre.pthg24;

/*
Generated once, should be extended by user
*/

import framework.ApplicationDatasetInterface;
import framework.ApplicationObjectInterface;
import framework.types.IrishCalendar;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.insightcentre.pthg24.analysis.*;
import org.insightcentre.pthg24.clustering.DumpFeatures;
import org.insightcentre.pthg24.datamodel.*;
import org.insightcentre.pthg24.generatedsolver.ProcessFileDialogBox;
import org.insightcentre.pthg24.generatedsolver.ProcessFileSolver;
import org.insightcentre.pthg24.implementedsolver.ProcessFileSolverImpl;
import org.insightcentre.pthg24.imports.*;
import org.insightcentre.pthg24.pdfgrep.RunPDFGrep;
import org.insightcentre.pthg24.pdfgrep.RunPDFInfo;
import org.insightcentre.pthg24.pdfgrep.RunPDFInfoURL;
import org.insightcentre.pthg24.reports.CoauthorGraph;
import org.insightcentre.pthg24.reports.PublicationReport;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.insightcentre.pthg24.datamodel.WorkType.*;
import static org.insightcentre.pthg24.logging.LogShortcut.info;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class JfxApp extends GeneratedJfxApp {

        // set from commandline; use it to change survey
        static String[] args;


         public void showObject(ApplicationObjectInterface obj){
                super.showObject(obj);
        }

// callback called once at startup to create initial data in application
        @Override
        public ApplicationDatasetInterface minimalDataset() {
                Scenario base = new Scenario();
                IrishCalendar.buildCalendar();
                base.setDirty(false);

                if (args.length==1){
                    base.setProblem(args[0]);
                } else {
                    base.setProblem("");
                }

                return base;
        }

// main entry point for interactive application
        public static void main(String[] args) {
                JfxApp.args = args;
                launch(args);
        }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.getIcons().add(new Image(JfxApp.class.getResourceAsStream("/LightGreen_LiteratureSurvey.png")));
        //     primaryStage.getIcons().add(new Image(JfxApp.class.getResourceAsStream("/insight.jpg")));
        super.start(primaryStage);
    }

    @Override
    public void processFileSolverRun(Scenario base) {
        Optional<Boolean> result = new ProcessFileDialogBox(this,base,new ProcessFileSolverImpl(base).setProblem(base.getProblem())).showAndWait();
        reset();
    }





}
