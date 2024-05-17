package org.insightcentre.pthg24.analysis;

import org.apache.commons.lang3.StringUtils;
import org.insightcentre.pthg24.datamodel.OtherWork;
import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.datamodel.Work;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;

import static org.insightcentre.pthg24.datamodel.WorkType.ARTICLE;
import static org.insightcentre.pthg24.logging.LogShortcut.*;

public class ExtractOtherBib {
    public ExtractOtherBib(Scenario base, String dumpDir, String fileName){
        assert(dumpDir.endsWith("/"));
        String fullName = dumpDir+fileName;
        info("bib export to "+fullName);
        Hashtable<String,String> keyHash = createWorkHash(base);
        try{
            PrintWriter out = new PrintWriter(fullName);
            List<OtherWork> list = base.getListOtherWork().stream().
                    filter(OtherWork::getIsSelected).
                    filter(x->!x.getIsFound()).
                   sorted(Comparator.comparing(OtherWork::getYear)).
                    toList();
            for(OtherWork mw:list){
                exportBib(out,mw,keyHash);
            }
            out.close();
        } catch(IOException e){
            severe("Cannot write file "+fullName+", exception "+e.getMessage());
        }
    }

    private void exportBib(PrintWriter out,OtherWork mw,Hashtable<String,String> keyHash){
        out.printf("@%s{%s,\n",type(mw),key(mw,keyHash));

        if (!mw.getAuthor().equals("")) {
            out.printf("  author={%s},\n", mw.getAuthor());
        }
        if (!mw.getEditor().equals("")) {
            out.printf("  editor={%s},\n", mw.getEditor());
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
        if(mw.getWorkType().equals(ARTICLE)){
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

    private String type(OtherWork mw){
        switch (mw.getWorkType()){
            case ARTICLE:
                return "article";
            case PAPER:
                return "inproceedings";
            case COLLECTION:
            case BOOK:
                return "book";
            case INBOOK:
                return "inbook";
            case INCOLLECTION:
                return "incollection";
            case THESIS:
                return "phdthesis";
            default:
                warning("MissingWork type bad "+mw.getWorkType());
                return "misc";
        }
    }


    String[] suffix= new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v"};

    private String key(OtherWork mw,Hashtable<String,String> keyHash){

        String root = mw.getKey();
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
    private Hashtable<String,String> createWorkHash(Scenario base){
        Hashtable<String,String> res = new Hashtable<>();
        for(Work w:base.getListWork()){
            res.put(w.getKey(),w.getKey());
        }
        return res;
    }
}
