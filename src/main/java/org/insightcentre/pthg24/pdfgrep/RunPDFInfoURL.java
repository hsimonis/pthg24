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
import java.util.stream.Collectors;

import static org.insightcentre.pthg24.logging.LogShortcut.info;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class RunPDFInfoURL {
    public RunPDFInfoURL(Scenario base){
        for (Work a : base.getListWork().stream().
                filter(x -> x.getLocalCopy() != null).
                filter(x -> !x.getLocalCopy().equals("")).
                sorted(Comparator.comparing(Work::getName)).
                collect(Collectors.toUnmodifiableList())) {
            String logFile = "links.txt";
            deleteExistingResultFile("greps/", logFile);
            runPDFInfo("greps/",
                    "C:/texlive/2022/bin/win32/pdfinfo",
                    "../overview/" + a.getLocalCopy(),
                    logFile);
            int nrURL = parseResult("greps/", logFile);
            info(a.getName() + ": " + nrURL);
            a.setNrLinks(nrURL);


        }

    }



    private void runPDFInfo(String directory, String program,String pdfFile,String logFile) {
        assert(directory.endsWith("/"));
        String cmd = String.format("%s %s",program,pdfFile);
        try {
            ProcessBuilder pb;
            pb = new ProcessBuilder(program,
                    "-url",
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
            int cnt  =0;
            BufferedReader br = new BufferedReader(new FileReader(fullName));
            while((line = br.readLine()) != null){
                cnt += interpret(line);
//                info("line "+line);
            }
            br.close();
            return cnt;

        } catch(IOException e){
            severe("Cannot read file "+fullName+", exception "+e.getMessage());
            assert(false);
            return -1;
        }
    }

    private int interpret(String line){
        for(String pattern:ignore){
            if (!line.contains("Annotation") || line.contains(pattern)){
                return 0;
            }
        }
        info("line "+line);
        return 1;
    }

    String[] ignore = new String[]{"mailto","mail to","orcid.org","refhub.elsevier","crossref.org","www.elsevier.com","arvix.org","arxiv.org",
            "link.springer.com","www.researchgate.net","pubsonline.informs.org",
            "doi.org","creativecommons","dagstuhl.de","sciencedirect","www.gurobi.com","www.ibm.com","dl.acm.org",
            "ibm.com/software",
            "www.ilog.com","www.wiley.com","minizinc.org","nvidia.com","citeseer","gecode.org","ScienceDirect.com",
            "www.ieee.org","ieeexplore.ieee.org","bbc.co.uk","ijcai.org","www.dynadec.com","www.ercim.eu",
            "www.boeing.com","www.faa.gov","www.cosytec.com","www.choco-solver.org","www.nytimes.com","scip.zib.de","www.opturion.com",
            "http://choco.sourceforge.net","https://bitbucket.org/oscarlib/oscar","https://choco-solver.org",
            "https://developers.google.com/optimization","https://github.com/chuffed","www-03.ibm.com","www-01.ibm.com",
            "www.forbes.com","www.statista.com","www.eia.gov","sicstus.sics.se","www.sics.se","ibm.biz",
            "www.eirgrid.com","sem-o.com","ec.europa.eu","jstor.org"
    };


}

