package org.insightcentre.pthg24.analysis;

import org.apache.commons.lang3.StringUtils;
import org.insightcentre.pthg24.datamodel.MissingWork;
import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.datamodel.Work;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import static java.util.stream.Collectors.joining;
import static org.insightcentre.pthg24.logging.LogShortcut.*;

public class ExtractSelectedBib {
    public ExtractSelectedBib(Scenario base, String dumpDir, String fileName){
        assert(dumpDir.endsWith("/"));
        String fullName = dumpDir+fileName;
        info("bib export to "+fullName);
        Hashtable<String,String> keyHash = createWorkHash(base);
        try{
            PrintWriter out = new PrintWriter(fullName);
            List<MissingWork> list = base.getListMissingWork().stream().
                    filter(MissingWork::getIsSelected).
                    filter(x->!x.getType().equals("")).
                    filter(x->!x.getType().equals("other")).
                    filter(x->!x.getType().equals("posted-content")).
                    filter(x->!x.getType().equals("dataset")).
                    filter(x->!x.getType().equals("report")).
                    filter(x->!x.getType().equals("reference-entry")).
                    //??? what is more important, relevance or age
                    sorted(Comparator.comparing(MissingWork::getRelevance).reversed()).
//                    sorted(Comparator.comparing(MissingWork::getYear)).
                    toList();
            for(MissingWork mw:list){
                exportBib(out,mw,keyHash);
            }
            out.close();
        } catch(IOException e){
            severe("Cannot write file "+fullName+", exception "+e.getMessage());
        }
    }

    private void exportBib(PrintWriter out,MissingWork mw,Hashtable<String,String> keyHash){
        out.printf("@%s{%s,\n",type(mw),key(mw,keyHash));

        if (!mw.getAuthor().equals("")) {
            out.printf("  author={%s},\n", latexAuthor(mw.getAuthor()));
        }
        if (!mw.getEditor().equals("")) {
            out.printf("  editor={%s},\n", latexAuthor(mw.getEditor()));
        }
        out.printf("  title={%s},\n",mw.getTitle());
        out.printf("  doi={%s},\n",mw.getDoi());
        if (!mw.getUrl().equals("")) {
            out.printf("  url={%s},\n", mw.getUrl());
        }
        if (!mw.getVolume().equals("")) {
            out.printf("  volume={%s},\n", mw.getVolume());
        }
        if (!mw.getIssue().equals("")) {
            out.printf("  issue={%s},\n", mw.getIssue());
        }
        if (!mw.getPage().equals("")) {
            out.printf("  page={%s},\n", mw.getPage());
        }
        if (!mw.getChapter().equals("")) {
            out.printf("  chapter={%s},\n", mw.getChapter());
        }
        if (!mw.getPublisher().equals("")) {
            out.printf("  publisher={%s},\n", mw.getPublisher());
        }
        if(mw.getType().equals("journal-article")){
            out.printf("  journal={%s},\n",mw.getSource());

        } else {
            out.printf("  booktitle={%s},\n",mw.getSource());
        }
        if (!mw.getAbstractText().equals("")){
            out.printf("  abstract={%s},\n",mw.getAbstractText());
        }
        out.printf("  year={%d}\n",mw.getYear());
        out.printf("}\n\n");
    }

    private String type(MissingWork mw){
        switch (mw.getType()){
            case "journal-article":
                return "article";
            case "proceedings-article":
                return "inproceedings";
            case "book":
            case "monograph":
            case "reference-book":
            case "edited-book":
                return "book";
            case "book-chapter":
                return "inbook";
            case "report":
                return "techreport";
            case "thesis":
                return "phdthesis";
            case "other":
            default:
                warning("MissingWork type bad "+mw.getType());
                return "misc";
        }
    }

    private String latexAuthor(String author){
        String[] split = author.split(",");
        return String.join(" and ", split);
    }

    String[] suffix= new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v"};

    private String key(MissingWork mw,Hashtable<String,String> keyHash){

        String[] split = (!mw.getAuthor().equals("")?mw.getAuthor():mw.getEditor()).split(",");
        String root = keySafe(familyName(split[0]))+mw.getYear();
        String res = root;
        int i= 0;
        while (keyHash.get(res) != null){
            if (i<suffix.length) {
                res = root + suffix[i];
            } else {
                res = root+i;
            }
            i++;
        }
        keyHash.put(res,res);
        return res;
    }

    private String familyName(String text){
        String[] parts = text.split(" ");
        int last = parts.length-1;
        if (last >= 0) {
            return capitalize(parts[last]);
        } else {
            return "";
        }
    }

    private String capitalize(String t){
        if (StringUtils.isAllUpperCase(t)) {
            return StringUtils.capitalize(t);
        }
        return t;
    }

    // we cannot have non-ascii unicode characters in keys, bibtex library does not like all this
    //??? the ' is not the standard single quote I think
    public static String keySafe(String key){
        return key.replaceAll("[^\\x00-\\x7F]","").replace("*","-").replace("?","-").replace("'","");
    }

    private Hashtable<String,String> createWorkHash(Scenario base){
        Hashtable<String,String> res = new Hashtable<>();
        for(Work w:base.getListWork()){
            res.put(w.getKey(),w.getKey());
        }
        return res;
    }
}
