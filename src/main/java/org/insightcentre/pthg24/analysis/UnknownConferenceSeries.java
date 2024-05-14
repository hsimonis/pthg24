package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.Proceedings;
import org.insightcentre.pthg24.datamodel.Scenario;

import java.io.IOException;
import java.io.PrintWriter;

import static org.insightcentre.pthg24.logging.LogShortcut.severe;

/*
write out names of proceedings for which we do not have conference series data
requires manual edit to include in import/conferenceseries.json
 */
public class UnknownConferenceSeries {
    public UnknownConferenceSeries(Scenario base, String exportDir, String fileName){
        assert(exportDir.endsWith("/"));
        String fullName = exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            out.printf("[\n");
            for(Proceedings p:base.getListProceedings().stream().filter(x->x.getConferenceSeries().getName().equals("unknown")).toList()){
                out.printf("{\"abbrev\":\"\",\"name\":\"%s\"},\n",p.getName());
            }
            out.printf("]\n");
            out.close();
        } catch(IOException e){
            severe("Cannot write file: "+fullName+", exception "+e.getMessage());
        }
    }
}
