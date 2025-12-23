package org.insightcentre.pthg24.pdfgrep;

import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.datamodel.Work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Comparator;

import static org.insightcentre.pthg24.imports.ImportCrossref.exists;
import static org.insightcentre.pthg24.logging.LogShortcut.*;
import static org.insightcentre.pthg24.pdfgrep.RunPDFInfoURL.*;

public class RunPDF2Text {
    public RunPDF2Text(Scenario base, String worksDir,String textDir){
        info("Convert pdf to text");
        assert(worksDir.endsWith("/"));
        assert(textDir.endsWith("/"));
        for (Work a : base.getListWork()) {
            if (exists(worksDir+a.getName()+".pdf") && !exists(textDir+a.getName()+".txt")) {
                String logDirectory = "greps/";
                String logFile = "info.txt";

                deleteExistingResultFile(logDirectory, logFile);
                runPDF2Text(logDirectory, "C:/texlive/2025/bin/windows/pdftotext",
                        relativeLink(base,a),
                        relativeText(base,a),
                        logFile);
            }
        }
    }

    private void runPDF2Text(String directory,String program,String pdfFile,String textFile,String logFile) {
        assert(directory.endsWith("/"));
        String cmd = String.format("%s %s %s",program,pdfFile,textFile);
        try {
            ProcessBuilder pb;
            pb = new ProcessBuilder(program,
                    pdfFile,
                    textFile);

            info("command-line: "+cmd);
            pb.directory(new File(directory));
            info("directory: " + directory);
            pb.redirectErrorStream(true);
            File log = new File(directory+logFile);
            pb.redirectErrorStream(true);
            pb.redirectOutput(ProcessBuilder.Redirect.to(log));
            info("Start program: " + program);
            Process p = pb.start();
           info("started");
            p.waitFor();
            info("command run");
        } catch(Exception e) {
            severe("Problem with executing command, " + e.getMessage());
        }
    }

}

