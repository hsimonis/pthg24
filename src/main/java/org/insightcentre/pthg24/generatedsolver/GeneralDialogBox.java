package org.insightcentre.pthg24.generatedsolver;
import org.insightcentre.pthg24.GeneratedJfxApp;
import org.insightcentre.pthg24.datamodel.Scenario;
import framework.gui.JfxSolverDialogBox;
import framework.solver.AbstractSolver;
import javafx.scene.control.TextField;
public class GeneralDialogBox extends JfxSolverDialogBox {
    Scenario base;

    GeneralDialogBox(GeneratedJfxApp app, Scenario base, AbstractSolver solver){
        super(app,solver);
        this.base = base;
    }

     class IntegerTextField extends TextField {

     @Override
     public void replaceText(int start, int end, String text) {
         if (validate(text)) {
             super.replaceText(start, end, text);
         }
     }

     @Override
     public void replaceSelection(String replacement) {
         if (validate(replacement)) {
             super.replaceSelection(replacement);
         }
     }

     boolean validate(String text) {
         return text.matches("-?[0-9]*");
     }
}

     class DoubleTextField extends TextField {

     @Override
     public void replaceText(int start, int end, String text) {
         if (validate(text)) {
             super.replaceText(start, end, text);
         }
     }

     @Override
     public void replaceSelection(String replacement) {
         if (validate(replacement)) {
             super.replaceSelection(replacement);
         }
     }

     boolean validate(String text) {
         return text.matches("[\\.0-9]*");
     }
}

    class DateTextField extends TextField {
    @Override
    public void replaceText(int start, int end, String text) {
        if (validate(text)) {
            super.replaceText(start, end, text);
        }
    }

    @Override
    public void replaceSelection(String replacement) {
        if (validate(replacement)) {
            super.replaceSelection(replacement);
        }
    }

    boolean validate(String text) {
        return text.matches("[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]");
    }
}

}
