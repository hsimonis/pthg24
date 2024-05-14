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
import static org.insightcentre.pthg24.analysis.ListWorksManual.manualInterest;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ListWorks extends AbstractList{

    public ListWorks(PrintWriter out, Scenario base,List<Work> works,boolean showLabel,String caption){
        super(base);
        showTable(out,base,works,showLabel,caption);
    }
    public ListWorks(Scenario base, WorkType type, String exportDir, String fileName){
        super(base);
        assert(exportDir.endsWith("/"));
        String fullName= exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            List<Work> works = sortedWorks(base,type);
            showTable(out,base,works,true,typeCaption(type));
            out.close();
        } catch(IOException e){
            severe("Cannot write file: "+fullName+", exception "+e.getMessage());
        }
    }

    private String typeCaption(WorkType type){
        return type.toString();
    }
    public ListWorks(Scenario base, List<Work> works, String exportDir, String fileName,String caption){
        super(base);
        assert(exportDir.endsWith("/"));
        String fullName= exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            showTable(out,base,works,false,caption);
            out.close();
        } catch(IOException e){
            severe("Cannot write file: "+fullName+", exception "+e.getMessage());
        }
    }

    private void showTable(PrintWriter out,Scenario base,List<Work> works,boolean showLabel,String caption){
        out.printf("{\\scriptsize\n");
        out.printf("\\begin{longtable}{>{\\raggedright\\arraybackslash}p{3cm}>{\\raggedright\\arraybackslash}p{4.5cm}>{\\raggedright\\arraybackslash}p{6.0cm}rrrp{2.5cm}rp{1cm}p{1cm}p{1cm}rr}\n");
        out.printf("\\rowcolor{white}\\caption{%s (Total %d)}\\\\ \\toprule\n",safe(caption),works.size());
        out.printf("\\rowcolor{white}\\shortstack{Key\\\\Source} & Authors & Title (Colored by Open Access)& LC & Cite & Year & " +
                "\\shortstack{Conference\\\\/Journal\\\\/School} & Pages & Relevance &\\shortstack{Cites\\\\OC XR\\\\SC} & " +
                "\\shortstack{Refs\\\\OC\\\\XR} & b & c \\\\ \\midrule");
        out.printf("\\endhead\n");
        out.printf("\\bottomrule\n");
        out.printf("\\endfoot\n");
        for(Work a:works){
            out.printf("%s%s \\href{%s}{%s} & %s & %s%s & %s & \\cite{%s} & %d & %s & %d & %s & %s & %s & %s & %s",
                    rowLabel(a,"a:"+a.getName(),showLabel),
                    a.getKey(),
                    a.getUrl(),a.getKey(),
                    authors(a),
                    openAccessHighlight(a),safe(a.getTitle()+(a.getAbstractText().equals("")?"":" \\hyperref[abs:"+a.getKey()+"]{Abstract}")),
                    (localCopyExists1(a)?"\\href{"+local(a.getLocalCopy())+"}{Yes}":"No"),
                    a.getName(),
                    a.getYear(),
                    confOrJournal(a),
                    a.getNrPages(),
                    showRelevances(a),
                    citations(a),
                    references(a),
                    bLabelRef(a),
                    cLabelRef(base,a));
            out.printf("\\\\\n");
        }
        out.printf("\\end{longtable}\n");
        out.printf("}\n\n");

    }


    public static String openAccessHighlight(Work w){
        if (w.getOpenAccessType()==OpenAccessType.Gold){
            return "\\cellcolor{gold!20}";
        }
        if (w.getOpenAccessType()==OpenAccessType.Green){
            return "\\cellcolor{green!10}";
        }
        //??? should the closed version be highlighted
//        if (w.getOpenAccessType()==OpenAccessType.Closed){
//            return "\\cellcolor{black!20}";
//        }
        return "";
    }

    private String citations(Work a){
        return String.format("%d %d %d",a.getNrCitations(),a.getCrossrefCitations(),a.getScopusCitations());
//        return String.format("\\shortstack[r]{%d\\\\%d\\\\%d}",a.getNrCitations(),a.getCrossrefCitations(),a.getScopusCitations());
    }

    private String references(Work a){
        return String.format("%d %d",a.getNrReferences(),a.getCrossrefReferences());
//        return String.format("\\shortstack[r]{%d\\\\%d}",a.getNrReferences(),a.getCrossrefReferences());
    }

    private String rowLabel(Work w,String label,boolean showLabel){
        if (showLabel){
            return String.format("\\index{%s}\\rowlabel{%s}",w.getKey(),label);
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
    public static String cLabelRef(Scenario base,Work w){
        if (manualInterest(base,w) && !w.getBackground() && (w instanceof Paper || w instanceof Article)) {
            return "\\ref{c:" + w.getName() + "}";
        } else {
            return "n/a";
        }
    }

    private String confOrJournal(Work w){
        if (w instanceof Paper){
            return shortProc(((Paper)w).getProceedings());
        } else if (w instanceof Article){
            Journal j = ((Article)w).getJournal();
            return (j.getIsBlocked()?"\\cellcolor{red!20}":"")+nameOf(j);
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
