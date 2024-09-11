package org.insightcentre.pthg24.analysis;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class CreateMakefile {
    public CreateMakefile(String rootDir,String fileName, String type){
        assert(rootDir.endsWith("/"));
        String fullName = rootDir+fileName;
        if (!exists(fileName)) {
            try {
                PrintWriter out = new PrintWriter(fullName);
                out.printf("all: %s.pdf\n", type);
                out.printf("\n");
                out.printf("%s.pdf: %s.tex exports/title.tex\n", type, type);
                out.printf("\trm -f %s.pdf\n", type);
                out.printf("\tlualatex --interaction=nonstopmode %s\n", type);
                out.printf("\tbibtex %s\n", type);
                out.printf("\tlualatex --interaction=nonstopmode %s\n", type);
                out.printf("\tlualatex --interaction=nonstopmode %s\n", type);
                out.printf("\tlualatex --interaction=nonstopmode %s\n", type);
                out.printf("\n");
                out.printf("clean:\n");
                out.printf("\trm -f %s.pdf\n", type);
                out.close();
            } catch (IOException e) {
                severe("Cannot write file " + fullName + ", exception " + e.getMessage());
            }
        }
    }

    public static boolean exists(String fileName){
        Path path = Paths.get(fileName);
        return Files.exists(path);
    }

}
