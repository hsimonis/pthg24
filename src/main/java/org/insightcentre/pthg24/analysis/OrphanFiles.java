package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.Orphan;
import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.datamodel.Work;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.insightcentre.pthg24.logging.LogShortcut.info;

public class OrphanFiles {
    public OrphanFiles(Scenario base, String worksDir) {
        assert (worksDir.endsWith("/"));
        Hashtable<String,Work> hash = new Hashtable<>();
        for(Work w:base.getListWork()){
            hash.put(w.getKey(),w);
        }

        File directory = new File(worksDir);

        // Using listFiles method we get all the files of a directory
        // return type of listFiles is array
        File[] files = directory.listFiles();
        for(File f:files){
//            info("File "+f.getName());
            if (f.getName().endsWith(".pdf")){
                String name = f.getName().substring(0,f.getName().length()-4);
//                info("root "+name);
                if (hash.get(name)== null){
                    info("Orphan "+f.getName());
                    Orphan orphan = new Orphan(base);
                    orphan.setName(name);
                    orphan.setFileName(f.getName());
                }
            }
        }

    }
}
