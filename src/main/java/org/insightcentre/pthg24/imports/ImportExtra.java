package org.insightcentre.pthg24.imports;

import au.com.bytecode.opencsv.CSVReader;
import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.datamodel.Work;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.insightcentre.pthg24.logging.LogShortcut.info;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ImportExtra {
    public ImportExtra(Scenario base, String importDir, String fileName){
        assert(importDir.endsWith("/"));
        String fullName = importDir+fileName;
        try{
            CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(fullName)),'&');
            String[] firstLine = reader.readNext();
            String[] nextLine;
            int line = 1;
            int created = 0;
            while ((nextLine = reader.readNext()) != null) {
                int col = 0;
                String key = nextLine[col++].trim();
                info("Entry "+key+" items "+nextLine.length);
                String system = nextLine[col++].trim();
                String data = nextLine[col++].trim();
                String code = nextLine[col++].trim();
                String basedOn = nextLine[col++].trim();
                String classification = nextLine[col++].trim();
                String constraints = nextLine[col++].trim();

                Work w = Work.findByName(base,key);
                if (w == null){
                    severe("Unknown key "+key);
                    assert(false);
                }
                w.setCpSystem(system);
                w.setDataAvail(data);
                w.setCodeAvail(code);
                w.setBasedOn(basedOn);
                w.setClassification(classification);
                w.setConstraints(constraints);
                if (nextLine.length> 7){
                    String solution = nextLine[col++].trim();
                    w.setSolutionAvail(solution);
                }

            }


        } catch(IOException e){
            severe("Cannot read file "+fullName+", exception "+e.getMessage());
        }
    }
}
