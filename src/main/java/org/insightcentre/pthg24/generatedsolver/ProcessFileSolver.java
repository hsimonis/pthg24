package org.insightcentre.pthg24.generatedsolver;

import org.insightcentre.pthg24.datamodel.*;
import framework.solver.AbstractSolver;
import framework.types.DateOnly;
import static org.insightcentre.pthg24.logging.LogShortcut.info;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;
import static org.insightcentre.pthg24.logging.LogShortcut.warning;

public class ProcessFileSolver extends DefaultSolver{
// solver internal variables
    protected long startSystem = 0;
// solver parameters
    protected String problem="";

    public ProcessFileSolver(Scenario base){
        super(base,new String[] {});
    }
    public ProcessFileSolver(Scenario base,String problem){
        super(base,new String[] {});
        this.problem=problem;
    }

public String getProblem(){
 return problem;
}

public ProcessFileSolver setProblem(String v){
 problem = v;
 return this;
}

public void stop() {
}
public boolean solve() {
    boolean isfeas = true;
    startSystem = System.currentTimeMillis();
// reset objects
// create indices
    long endSystem = System.currentTimeMillis();
    info("Run Time: "+(endSystem - startSystem) / 1000.0);
// remove indices
    return isfeas;
}


}
