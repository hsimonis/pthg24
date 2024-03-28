package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ListWorks {

    public ListWorks(PrintWriter out, Scenario base,List<Work> works,boolean showLabel){
        showTable(out,base,works,showLabel);
    }
    public ListWorks(Scenario base, WorkType type, String exportDir, String fileName){
        assert(exportDir.endsWith("/"));
        String fullName= exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            List<Work> works = sortedWorks(base,type);
            showTable(out,base,works,true);
            out.close();
        } catch(IOException e){
            severe("Cannot write file: "+fullName+", exception "+e.getMessage());
        }
    }
    public ListWorks(Scenario base, List<Work> works, String exportDir, String fileName){
        assert(exportDir.endsWith("/"));
        String fullName= exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            showTable(out,base,works,false);
            out.close();
        } catch(IOException e){
            severe("Cannot write file: "+fullName+", exception "+e.getMessage());
        }
    }

    private void showTable(PrintWriter out,Scenario base,List<Work> works,boolean showLabel){
        out.printf("{\\scriptsize\n");
        out.printf("\\begin{longtable}{>{\\raggedright\\arraybackslash}p{3cm}>{\\raggedright\\arraybackslash}p{6cm}>{\\raggedright\\arraybackslash}p{6.5cm}rrrp{2.5cm}rrrrr}\n");
        out.printf("\\rowcolor{white}\\caption{Works from bibtex (Total %d)}\\\\ \\toprule\n",works.size());
        out.printf("\\rowcolor{white}\\shortstack{Key\\\\Source} & Authors & Title & LC & Cite & Year & " +
                "\\shortstack{Conference\\\\/Journal\\\\/School} & Pages & \\shortstack{Nr\\\\Cites} & " +
                "\\shortstack{Nr\\\\Refs} & b & c \\\\ \\midrule");
        out.printf("\\endhead\n");
        out.printf("\\bottomrule\n");
        out.printf("\\endfoot\n");
        for(Work a:works){
            out.printf("%s%s \\href{%s}{%s} & %s & %s & %s & \\cite{%s} & %d & %s & %d & %d & %d & %s & %s",
                    rowLabel("a:"+a.getName(),showLabel),
                    a.getKey(),a.getUrl(),a.getKey(),
                    authors(a),
                    safe(a.getTitle()),
                    (localCopyExists1(a)?"\\href{"+local(a.getLocalCopy())+"}{Yes}":"No"),
                    a.getName(),
                    a.getYear(),
                    confOrJournal(a),
                    a.getNrPages(),
                    a.getNrCitations(),
                    a.getNrReferences(),
                    bLabelRef(a),
                    cLabelRef(a));
            out.printf("\\\\\n");
        }
        out.printf("\\end{longtable}\n");
        out.printf("}\n\n");

    }

    private String rowLabel(String label,boolean showLabel){
        if (showLabel){
            return "\\rowlabel{"+label+"}";
        }
        return "";
    }


    public static String local(String lc){
        return "../"+lc;
    }
    public static String aLabelRef(Work w){
        return "\\ref{a:"+w.getName()+"}";
    }
    public static String bLabelRef(Work w){
        if (w.getLocalCopy().equals("") || w.getBackground()){
            return "No";
        } else {
            return "\\ref{b:"+w.getName()+"}";
        }
    }
    public static String cLabelRef(Work w){
        if (!w.getBackground() && (w instanceof Paper || w instanceof Article)) {
            return "\\ref{c:" + w.getName() + "}";
        } else {
            return "n/a";
        }
    }

    private String confOrJournal(Work w){
        if (w instanceof Paper){
            return shortProc(((Paper)w).getProceedings());
        } else if (w instanceof Article){
            return nameOf(((Article)w).getJournal());
        } else if (w instanceof InCollection){
            return nameOf(((InCollection)w).getCollection());
        } else if (w instanceof InBook){
            return safe(((InBook)w).getBooktitle());
        } else if (w instanceof Book){
            return "Book";
        } else if (w instanceof PhDThesis){
            return nameOf(((PhDThesis)w).getSchool());
        } else {
            return "n/a";
        }
    }

    private String shortProc(Proceedings p){
        if (p==null){
            return "-";
        } else {
            return safe(p.getShortName());
        }
    }

    public static boolean localCopyExists(Work a){
        Path path = Paths.get(a.getLocalCopy());
        return Files.exists(path);
    }

    public static boolean localCopyExists1(Work a){
        return a.getLocalCopy() != null && !a.getLocalCopy().equals("");
    }

    public static List<Work> notBackground(List<Work> list){
        return list.stream().filter(x->!x.getBackground()).collect(Collectors.toList());
    }

    public static List<Work> sortedWorks(Scenario base,WorkType type){
        switch(type) {

            case PAPER:
                return notBackground(base.getListPaper().stream().
                        sorted(Comparator.comparing(Work::getYear).reversed().
                                thenComparing(Work::getName)).
                        collect(Collectors.toUnmodifiableList()));
            case ARTICLE:
                return notBackground(base.getListArticle().stream().
                        sorted(Comparator.comparing(Work::getYear).reversed().
                                thenComparing(Work::getName)).
                        collect(Collectors.toUnmodifiableList()));
            case BOOK:
                return notBackground(base.getListBook().stream().
                        sorted(Comparator.comparing(Work::getYear).reversed().
                                thenComparing(Work::getName)).
                        collect(Collectors.toUnmodifiableList()));
//            case COLLECTION:
//                return notBackground(base.getListCollection().stream().
//                        sorted(Comparator.comparing(Work::getYear).reversed().
//                                thenComparing(Work::getName)).
//                        collect(Collectors.toUnmodifiableList()));
            case THESIS:
                return notBackground(base.getListPhDThesis().stream().
                        sorted(Comparator.comparing(Work::getYear).reversed().
                                thenComparing(Work::getName)).
                        collect(Collectors.toUnmodifiableList()));
            case INBOOK:
                return notBackground(base.getListInBook().stream().
                        sorted(Comparator.comparing(Work::getYear).reversed().
                                thenComparing(Work::getName)).
                        collect(Collectors.toUnmodifiableList()));
            case INCOLLECTION:
                return notBackground(base.getListInCollection().stream().
                        sorted(Comparator.comparing(Work::getYear).reversed().
                                thenComparing(Work::getName)).
                        collect(Collectors.toUnmodifiableList()));
            default:
                return new ArrayList<>();
        }

    }

    public static String authors(Work a){
        return a.getAuthors().stream().
                map(ListWorks::hyperref).
                collect(Collectors.joining(", "));
    }

    private static String hyperref(Author a){
        if (a.getNrWorks() > 0) {
            return "\\hyperref[auth:" + a.getKey() + "]{" + a.getShortName() + "}";
        } else {
            return a.getShortName();
        }

    }

    private String nameOf(ApplicationObject a){
        if (a==null){
            return "";
        } else {
            return safe(a.getName());
        }
    }
}
