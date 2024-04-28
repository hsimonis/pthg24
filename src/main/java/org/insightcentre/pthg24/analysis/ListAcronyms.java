package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.Acronym;
import org.insightcentre.pthg24.datamodel.ApplicationObject;
import org.insightcentre.pthg24.datamodel.MissingWork;
import org.insightcentre.pthg24.datamodel.Scenario;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ListAcronyms {

    public ListAcronyms(Scenario base, String exportDir, String fileName){
        assert(exportDir.endsWith("/"));
        String fullFile = exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullFile);
            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{llp{12cm}}\n");
            out.printf("\\caption{Acronym Concepts}\\\\ \\toprule\n");
            out.printf("Acronym & Type & Description\\\\ \\midrule");
            out.printf("\\endhead\n");
            out.printf("\\bottomrule\n");
            out.printf("\\endfoot\n");
            for(Acronym a:base.getListAcronym().stream().sorted(Comparator.comparing(ApplicationObject::getName)).toList()) {
                out.printf("\\index{%s (%s)}\\index{%s (%s)}%s & %s & %s",
                        a.getName(),a.getDescription(),a.getDescription(),a.getName(),
                        a.getName(),
                        a.getConceptType().toString(),
                        a.getDescription());
                out.printf("\\\\\n");

            }
            out.printf("\\end{longtable}\n");
            out.printf("}\n\n");
            out.close();
        } catch(IOException e){
            severe("Cannot write file "+fullFile+", exception "+e.getMessage());
        }
    }

}
