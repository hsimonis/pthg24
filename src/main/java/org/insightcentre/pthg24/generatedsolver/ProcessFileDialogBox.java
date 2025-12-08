package org.insightcentre.pthg24.generatedsolver;

import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.JfxApp;
import org.insightcentre.pthg24.GeneratedJfxApp;
import framework.gui.JfxSolverDialogBox;
import framework.solver.AbstractSolver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import framework.types.DateOnly;
import framework.types.IrishCalendar;
import static org.insightcentre.pthg24.logging.LogShortcut.info;

public class ProcessFileDialogBox extends GeneralDialogBox{
   private TextField problemItem = new TextField();

    public ProcessFileDialogBox(GeneratedJfxApp app, Scenario base,AbstractSolver solver){
        super(app, base, solver);
        setShowLineChart(false);
        setChartLabel("Cost");
        GridPane pane = new GridPane();
        pane.setVgap(10.0);
        pane.setHgap(10.0);
        int row = 0;
        pane.add(new Label("Problem:"), 0, row);
        pane.add(problemItem, 1, row++);
        problemItem.setText(((ProcessFileSolver)solver).getProblem());
        getDialogPane().setContent(pane);
        setTitle("ProcessFile Solver Parameters");
    }
@Override
public void handle(InputEvent event) {
    if (event.getEventType() == MouseEvent.MOUSE_RELEASED ||
      (event.getEventType() == KeyEvent.KEY_RELEASED &&
      ((KeyEvent) event).getCode() == KeyCode.ENTER)) {
        info("Get ProcessFile parameters");
        String problemValue = problemItem.getText();
        ((ProcessFileSolver)getSolver())
            .setProblem(problemValue)
            ;
        super.handle(event);
    }
}
}
