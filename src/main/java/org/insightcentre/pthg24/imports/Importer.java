package org.insightcentre.pthg24.imports;

import org.insightcentre.pthg24.datamodel.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import static org.insightcentre.pthg24.datamodel.MatchLevel.*;
import static org.insightcentre.pthg24.logging.LogShortcut.*;

public class Importer {
    public Importer(Scenario base, ConceptType type,String dir, String file,int nrConcepts,int nrFiles,String outDir,String outFile){
        assert(dir.endsWith("/"));
        assert(outDir.endsWith("/"));

        String[] concepts = new String[nrConcepts];
        String[] files = new String[nrFiles];
        String[] dirs = new String[nrFiles];
        StringBuilder[] sb = new StringBuilder[nrFiles];
        for(int j=0;j<nrFiles;j++){
            sb[j] = new StringBuilder();
        }
        String fullName = dir+file;
        info("reading "+fullName);
        try{
            BufferedReader in = new BufferedReader(new FileReader(fullName));
            for(int i=0;i<nrConcepts;i++) {
                String empty = in.readLine();
                String command = in.readLine();
                info("cmd "+command);
                String[] split = command.split("\"");
                if (split.length!=3){
                    severe("cannot split into three: "+command);
                }
                assert(split.length==3);
                concepts[i] = split[1];
                Concept c = findConcept(base,concepts[i],type);

                for(int j=0;j<nrFiles;j++){
                    String match = in.readLine();
                    String[] matches = match.split(":");
                    String[] fullFile = matches[0].split("\\.");
                    String[] details = fullFile[0].split("/");
                    dirs[j] = details[0];
                    files[j] = details[1];
                    Work w = findWork(base,dirs[j],files[j]);
                    sb[j].append(" & ");
                    sb[j].append(matches[1]);
                    Integer count = Integer.parseInt(matches[1]);
                    if (w != null && count > 0) {
                        ConceptWork cw = findConceptWork(base,c,w,count);
                    }
                }
            }
            in.close();
            PrintWriter out = new PrintWriter(outDir+outFile);
            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{l*{%d}{r}}\n",nrConcepts);
            out.printf("\\toprule\n");
            out.printf("Ref. ");
            for(int i=0;i<nrConcepts;i++){
                out.printf("&\\rotatebox{90}{"+safer(concepts[i])+"}");
            }
            out.printf("\\\\ \\midrule\n");
            out.printf("\\endhead\n");
            out.printf("\\bottomrule\n");
            out.printf("\\endfoot\n");

            for(int j=0;j<nrFiles;j++){
                sb[j].append("\\\\\n");
                out.printf("\\href{%s/%s.pdf}{%s}~\\cite{%s}",dirs[j],files[j],files[j],files[j]);
                out.printf(sb[j].toString());
            }
            out.printf("\\end{longtable}\n");
            out.printf("}\n\n"); // close /scriptsize
            out.close();

        } catch(IOException e){
            severe("Cannot read file "+fullName+", exception "+e.getMessage());
        }

    }

    private Concept findConcept(Scenario base,String name,ConceptType type){
        Concept res = Concept.findByName(base,name);
        if (res == null){
            res = new Concept(base);
            res.setName(name);
            res.setConceptType(type);
        }
        return res;
    }
    private Work findWork(Scenario base,String dir, String name){
        Work res = null;
        switch(dir){
            case "papers":
                res = Paper.findByName(base,name);
                if (res == null){
                    warning("Paper "+name+" not in bibtex");
//                    res = new Paper(base);
//                    res.setName(name);
//                    res.setYear(year(name));
                }
                break;
            case "articles":
                res = Article.findByName(base,name);
                if (res == null){
                    warning("Article "+name+" not in bibtex");
//                    res = new Article(base);
//                    res.setName(name);
//                    res.setYear(year(name));
                }
                break;
            default:
                severe("Cannot find work "+dir+" "+name);

        }
        return res;
    }

    private ConceptWork findConceptWork(Scenario base,Concept c,Work w,int count){
        ConceptWork cw = new ConceptWork(base);
        cw.setConcept(c);
        cw.setWork(w);
        cw.setCount(count);
        cw.setMatchLevel(level(count));
        return cw;

    }

    private MatchLevel level(int count){
        if (count <= 2){
            return Weak;
        } else if (count <= 5){
            return Medium;
        } else {
            return Strong;
        }
    }

    private int year(String name){
        if(name.endsWith("a")){
            return 0;
        }
        String num = name.substring(name.length()-2);
//        info("num "+num);
        int year2 = Integer.parseInt(num);
        if (year2 >50){
            return 1900+year2;
        } else {
            return 2000+year2;
        }
    }

    public static String safer(String s){
        return s.replace("C\\+\\+","C++").
                replace(".?"," ").
                replace("#","sharp");
    }
}
