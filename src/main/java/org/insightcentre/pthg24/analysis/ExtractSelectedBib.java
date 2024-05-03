package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.MissingWork;
import org.insightcentre.pthg24.datamodel.Scenario;
import org.jfree.util.StringUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static org.insightcentre.pthg24.logging.LogShortcut.info;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ExtractSelectedBib {
    public ExtractSelectedBib(Scenario base, String dumpDir, String fileName){
        assert(dumpDir.endsWith("/"));
        String fullName = dumpDir+fileName;
        info("bib export to "+fullName);
        try{
            PrintWriter out = new PrintWriter(fullName);
            List<MissingWork> list = base.getListMissingWork().stream().
                    filter(MissingWork::getIsSelected).
                    sorted(Comparator.comparing(MissingWork::getYear)).
                    toList();
            for(MissingWork mw:list){
                exportBib(out,mw);
            }
            out.close();
        } catch(IOException e){
            severe("Cannot write file "+fullName+", exception "+e.getMessage());
        }
    }

    private void exportBib(PrintWriter out,MissingWork mw){
        out.printf("@%s{%s,\n",type(mw),key(mw));
        out.printf("  author={%s},\n",latexAuthor(mw.getAuthor()));
        out.printf("  title={%s},\n",mw.getTitle());
        out.printf("  doi={%s},\n",mw.getDoi());
        if (!mw.getUrl().equals("")) {
            out.printf("  url={%s},\n", mw.getUrl());
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
                return "book";
            case "book-chapter":
                return "inbook";
            case "report":
                return "techreport";
            case "thesis":
                return "phdthesis";
            case "other":
            default:
                return "misc";
        }
    }

    private String latexAuthor(String author){
        String[] split = author.split(",");
        return String.join(" and ", split);
    }

    private String key(MissingWork mw){
        String[] split = mw.getAuthor().split(",");
        return familyName(split[0])+mw.getYear();
    }

    private String familyName(String text){
        String[] parts = text.split(" ");
        int last = parts.length-1;
        return parts[last];
    }
}
