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

public class RunPDFGrep {
    public RunPDFGrep(Scenario base){
        String savedFile = "imports/savedConceptWork.json";
        ConceptWorkHash cwh = new ConceptWorkHash(base,savedFile);
        for(ConceptType ct:ConceptType.values()) {
            for (Concept c : base.getListConcept().stream().
                    filter(x -> x.getConceptType() == ct).
                    sorted(Comparator.comparing(Concept::getLabel)).
//                    limit(5).
                    collect(Collectors.toUnmodifiableList())) {
                info("Type " + c.getConceptType() + " Concept " + c.getName());
                for (Work a : base.getListWork().stream().
                        filter(x -> x.getLocalCopy() != null).
                        filter(x -> !x.getLocalCopy().equals("")).
                        sorted(Comparator.comparing(Work::getName)).
                        limit(150).

                        collect(Collectors.toUnmodifiableList())) {
                    if (!cwh.present(c,a)) {
                        String logFile = "log.txt";
                        deleteExistingResultFile("greps/", logFile);
                        runPDFGrep("greps/",
                                "C:/cygwin64/bin/pdfgrep",
                                c.getRegExpr(),
                                "../overview/" + a.getLocalCopy(),
                                logFile);
                        int v = parseResult("greps/", logFile);
                        info(a.getName() + ": " + v);

                        ConceptWork cw = new ConceptWork(base);
                        cw.setConcept(c);
                        cw.setWork(a);
                        cw.setCount(v);
                        cw.setMatchLevel(matchLevel(v));
                        cwh.add(cw);
                    }

                }
            }
        }
        cwh.save(savedFile);
    }



    private void runPDFGrep(String directory, String program,String pattern, String pdfFile,String logFile) {
        assert(directory.endsWith("/"));
        String cmd = String.format("%s -i -c \"%s\" %s",program,pattern,pdfFile);
        try {
            ProcessBuilder pb;
            pb = new ProcessBuilder(program,
                    "-i",
                    "-c",
                    pattern,pdfFile);

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
            severe("Invalid permissions.");
        }
    }

    private int parseResult(String dir,String resFile){
        String fullName = dir+resFile;
        try{
            BufferedReader br = new BufferedReader(new FileReader(fullName));
            String line = br.readLine();
//            info("read "+line);
            br.close();
            return Integer.parseInt(line);

        } catch(IOException e){
            severe("Cannot read file "+fullName+", exception "+e.getMessage());
            assert(false);
            return -1;
        }
    }

    private MatchLevel matchLevel(int count){
        if (count ==0) {
            return None;
        } else if (count <= 2){
            return Weak;
        } else if (count <= 5){
            return Medium;
        } else {
            return Strong;
        }
    }
}

