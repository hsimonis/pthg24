package org.insightcentre.pthg24.pdfgrep;

import org.insightcentre.pthg24.datamodel.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Collectors;

import static org.insightcentre.pthg24.datamodel.MatchLevel.*;
import static org.insightcentre.pthg24.logging.LogShortcut.info;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class RunPDFInfo {
    public RunPDFInfo(Scenario base){
        for (Work a : base.getListWork().stream().
                filter(x -> x.getLocalCopy() != null).
                filter(x -> !x.getLocalCopy().equals("")).
                filter(x->x.getNrPages()==null || x.getNrPages() == 1).
                sorted(Comparator.comparing(Work::getName)).
                collect(Collectors.toUnmodifiableList())) {
            String logFile = "info.txt";
            deleteExistingResultFile("greps/", logFile);
            runPDFInfo("greps/",
                    "C:/texlive/2022/bin/win32/pdfinfo",
                    "../overview/" + a.getLocalCopy(),
                    logFile);
            int nrPages = parseResult("greps/", logFile);
            info(a.getName() + ": " + nrPages);
            a.setNrPages(nrPages);


        }

    }



    private void runPDFInfo(String directory, String program,String pdfFile,String logFile) {
        assert(directory.endsWith("/"));
        String cmd = String.format("%s %s",program,pdfFile);
        try {
            ProcessBuilder pb;
            pb = new ProcessBuilder(program,
                    pdfFile);

//            info("command-line: "+cmd);
            pb.directory(new File(directory));
//            info("directory: " + directory);
            pb.redirectErrorStream(true);
            File log = new File(directory+logFile);
            pb.redirectErrorStream(true);
            pb.redirectOutput(ProcessBuilder.Redirect.to(log));
//            info("Start program: " + program);
            Process p = pb.start();
//           info("started");
            p.waitFor();
//            info("command run");
        } catch(Exception e) {
            severe("Problem with executing command, " + e.getMessage());
        }
    }

    private void deleteExistingResultFile(String directory,String resFile){
        String fullName = directory+resFile;
        try {
            Files.deleteIfExists(
                    Paths.get(fullName));
        }
        catch (NoSuchFileException e) {
            severe("No such file/directory exists");
        }
        catch (DirectoryNotEmptyException e) {
            severe("Directory is not empty.");
        }
        catch (IOException e) {
            severe("Invalid permissions: "+fullName+", exception "+e.getMessage());
        }
    }

    private int parseResult(String dir,String resFile){
        String fullName = dir+resFile;
        String line;
        try{
            BufferedReader br = new BufferedReader(new FileReader(fullName));
            while((line = br.readLine()) != null){
//                info("line "+line);
                if (line.startsWith("Pages")){
                    br.close();
                    String[] parts = line.split(":");
                    return Integer.parseInt(parts[1].trim());
                }
            }
            br.close();
            return -1;

        } catch(IOException e){
            severe("Cannot read file "+fullName+", exception "+e.getMessage());
            assert(false);
            return -1;
        }
    }


}

