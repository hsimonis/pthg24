package org.insightcentre.pthg24.analysis;

import java.io.IOException;
import java.io.PrintWriter;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class Biblio {
    public Biblio(String exportDir, String fileName, String bibFile){
        assert(exportDir.endsWith("/"));
        String fullName = exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            out.printf("\\bibliography{imports/%s}\n",bibFile);
            out.close();
        } catch(IOException e){
            severe("Cannot write file "+fullName+", exception "+e.getMessage());
        }
    }
}
