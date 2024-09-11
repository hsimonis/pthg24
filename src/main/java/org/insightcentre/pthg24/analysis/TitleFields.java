package org.insightcentre.pthg24.analysis;

import java.io.IOException;
import java.io.PrintWriter;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class TitleFields {
    public TitleFields(String exportDir,String fileName,String title,String authors){
        assert(exportDir.endsWith("/"));
        String fullName = exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            out.printf("\\title{%s}\n",safe(title));
            out.printf("\\author{%s}\n",safe(authors));
            out.close();
        } catch(IOException e){
            severe("Cannot write file "+fullName+", exception "+e.getMessage());
        }
    }
}
