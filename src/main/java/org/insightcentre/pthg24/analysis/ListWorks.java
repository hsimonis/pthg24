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
import static org.insightcentre.pthg24.datamodel.SubType.Application;
import static org.insightcentre.pthg24.datamodel.SubType.Regular;
import static org.insightcentre.pthg24.logging.LogShortcut.info;
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
        info("List works "+fullName);
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
        if (type == null) {
            return "All";
        }
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
        if (base.getUseLargerText()){
            showLargerTable(out,base,works,showLabel,caption);
        } else {
            showSmallerTable(out,base,works,showLabel,caption);
        }
    }

    //??? make changes in other table as well
    private void showSmallerTable(PrintWriter out,Scenario base,List<Work> works,boolean showLabel,String caption){
        //??? textSize is set correctly for smaller table
        out.printf("{\\scriptsize\n");
        out.printf("\\begin{longtable}{>{\\raggedright\\arraybackslash}p{2.5cm}>{\\raggedright\\arraybackslash}p{4.5cm}" +
                ">{\\raggedright\\arraybackslash}p{6.0cm}p{1.0cm}rr>{\\raggedright\\arraybackslash}p{2.0cm}r>{\\raggedright\\arraybackslash}p{1cm}p{1cm}p{1cm}p{1cm}}\n");
        out.printf("\\rowcolor{white}\\caption{%s (Total %d)}\\\\ \\toprule\n",safe(caption),works.size());
        out.printf("\\rowcolor{white}\\shortstack{Key\\\\Source} & Authors & Title (Colored by Open Access)& \\shortstack{Details\\\\LC} & Cite & Year & " +
                "\\shortstack{Conference\\\\/Journal\\\\/School\\\\\\textcolor{red}{/SubType}\\\\\\textcolor{goldenrod}{/Award}} & \\shortstack{Pages\\\\/\\textcolor{green}{Linked}\\\\/\\textcolor{blue}{Topical}} & \\shortstack{Rele-\\\\vance} &\\shortstack{Cites\\\\OC XR\\\\SC} & " +
                "\\shortstack{Refs\\\\OC\\\\XR} & \\shortstack{Links\\\\Cites\\\\Refs}\\\\ \\midrule");
        out.printf("\\endhead\n");
        out.printf("\\bottomrule\n");
        out.printf("\\endfoot\n");
        for(Work a:works){
            out.printf("%s%s \\href{%s}{%s} & %s & %s%s & %s & \\cite{%s} & %d & %s%s & %s%s & %s & %s & %s & %s",
                    rowLabel(a,"a:"+a.getName(),showLabel),
                    a.getKey(),
                    a.getUrl(),a.getKey()+awardHighlight(a),
                    authors(a),
                    openAccessHighlight(a),safe(a.getTitle())+awardHighlight(a),
                    lcAndDetails(a),
                    a.getName(),
                    a.getYear(),
                    awardColor(a),confOrJournal(a),
                    highlightLinked(a),
                    pageAndSpecialIssue(base,a),
                    showRelevances(a),
                    citations(a),
                    references(a),
                    links(a));
            out.printf("\\\\\n");
        }
        out.printf("\\end{longtable}\n");
        out.printf("}\n\n");

    }

    //??? make changes in other table as well
    private void showLargerTable(PrintWriter out,Scenario base,List<Work> works,boolean showLabel,String caption){
        out.printf("\\begin{longtable}{>{\\raggedright\\arraybackslash}p{3.0cm}>{\\raggedright\\arraybackslash}p{4.5cm}" +
                ">{\\raggedright\\arraybackslash}p{6.0cm}p{1.5cm}>{\\raggedright\\arraybackslash}p{2.0cm}r>{\\raggedright\\arraybackslash}p{1cm}p{1cm}p{1cm}}\n");
        out.printf("\\rowcolor{white}\\caption{%s (Total %d)}\\\\ \\toprule\n",safe(caption),works.size());
        out.printf("\\rowcolor{white}\\shortstack{Key\\\\Source} & Authors & Title (Colored by Open Access)& \\shortstack{Details\\\\LC} & " +
                "\\shortstack{Conference\\\\/Journal\\\\/School\\\\\\textcolor{red}{/SubType}} & \\shortstack{Pages\\\\/\\textcolor{green}{Linked}\\\\/\\textcolor{blue}{Topical}} & \\shortstack{Cites\\\\OC XR\\\\SC} & " +
                "\\shortstack{Refs\\\\OC\\\\XR} & \\shortstack{Links\\\\Cites\\\\Refs}\\\\ \\midrule");
        out.printf("\\endhead\n");
        out.printf("\\bottomrule\n");
        out.printf("\\endfoot\n");
        for(Work a:works){
            out.printf("%s%s \\href{%s}{%s} & %s & %s%s & %s & %s%s & %s%s &  %s & %s & %s",
                    rowLabel(a,"a:"+a.getName(),showLabel),
                    a.getKey(),
                    a.getUrl(),a.getKey()+awardHighlight(a),
                    authors(a),
                    openAccessHighlight(a),safe(a.getTitle())+awardHighlight(a),
                    lcAndDetails(a),
                    awardColor(a),confOrJournal(a),
                    highlightLinked(a),
                    pageAndSpecialIssue(base,a),
                    citations(a),
                    references(a),
                    links(a));
            out.printf("\\\\\n");
        }
        out.printf("\\end{longtable}\n\n");

    }

    public static String awardHighlight(Work a){
        if (a.getAward().isEmpty()){
            return "";
        } else {
            return "\\textcolor{goldenrod}{\\filledstar}";
        }
    }

    private String awardColor(Work a){
        if (a.getAward().isEmpty()){
            return "";
        } else {
            return "\\cellcolor{goldenrod!50}";
        }

    }

    private String lcAndDetails(Work a){
        return highlightNoLocalCopy(a)+"\\hyperref[detail:"+a.getKey()+"]{Details}"+" "+(localCopyExists1(a)?"\\href{works/"+a.getName()+".pdf}{Yes}":"No");
    }

    private String highlightNoLocalCopy(Work a){
        if (!localCopyExists1(a)) {
            return "\\cellcolor{red!30}";
        }
        return "";

    }

    private String highlightLinked(Work w){
        if (w instanceof Article a && a.getSpecialIssue() != null && a.getLink() != null) {
            return "\\cellcolor{black!30}";
        } else if (w instanceof Article a && a.getSpecialIssue() != null) {
                return "\\cellcolor{blue!20}";
        } else if (w.getLink()!=null){
            return "\\cellcolor{green!20}";
        } else if (w.getSubType()!=null && w.getSubType() != Application){
            return "\\cellcolor{red!10}";
        } else if (w instanceof Article a && !a.getIsOriginal()){
            return "\\cellcolor{yellow!20}";
        } else {
            return "";
        }
    }

    private String pageAndSpecialIssue(Scenario base,Work w){

        if (w instanceof Article a && a.getSpecialIssue() != null) {
            return "\\shortstack[r]{" + a.getNrPages() + "\\\\{"+smallerTextSize(base.getUseLargerText())+" " + a.getSpecialIssue().getShortName() + "}}";
        } else if (w.getLink() != null){
            return "\\shortstack[r]{"+w.getNrPages()+"\\\\{"+smallerTextSize(base.getUseLargerText())+" "+linkLabel(w.getLink())+"}}";
        } else {
            if (w.getNrPages()==null){
                return "0";
            }
            return w.getNrPages().toString();
        }
    }

    private String linkLabel(Link link){
        if (link.getPaper() == null){
            return link.getVenue();
        }
        return link.getJournal();
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

    private String links(Work a){
        return String.format("%d %d %d",a.getNrCitationsCovered()+a.getNrReferencesCovered(),a.getNrCitationsCovered(),a.getNrReferencesCovered());

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
        return lc;
    }

    private String confOrJournal(Work w){
        if (w instanceof Paper){
            return shortProc(((Paper)w).getProceedings())+subType(w);
        } else if (w instanceof Article){
            Journal j = ((Article)w).getJournal();
            return (j.getIsBlocked()?"\\cellcolor{red!20}":"")+nameOf(j)+subType(w);
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

    private String subType(Work a){
        if (a.getSubType() == null || a.getSubType()==Regular){
            return "";
        } else {
            return " \\textcolor{red}{"+a.getSubType()+"}";
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
        return a.getLocalCopy() != null && !a.getLocalCopy().isEmpty();
    }

    public static List<Work> notBackground(List<Work> list){
        return list.stream().filter(x->!x.getBackground()).collect(Collectors.toList());
    }

    public static List<Work> sortedWorks(Scenario base,WorkType type){
        return switch (type) {
            case null ->notBackground(base.getListWork().stream().
                    sorted(Comparator.comparing(Work::getYear).reversed().
                            thenComparing(Work::getName)).
                    collect(Collectors.toUnmodifiableList()));
            case PAPER -> notBackground(base.getListPaper().stream().
                    sorted(Comparator.comparing(Work::getYear).reversed().
                            thenComparing(Work::getName)).
                    collect(Collectors.toUnmodifiableList()));
            case ARTICLE -> notBackground(base.getListArticle().stream().
                    sorted(Comparator.comparing(Work::getYear).reversed().
                            thenComparing(Work::getName)).
                    collect(Collectors.toUnmodifiableList()));
            case BOOK -> notBackground(base.getListBook().stream().
                    sorted(Comparator.comparing(Work::getYear).reversed().
                            thenComparing(Work::getName)).
                    collect(Collectors.toUnmodifiableList()));
//            case COLLECTION:
//                return notBackground(base.getListCollection().stream().
//                        sorted(Comparator.comparing(Work::getYear).reversed().
//                                thenComparing(Work::getName)).
//                        collect(Collectors.toUnmodifiableList()));
            case THESIS -> notBackground(base.getListPhDThesis().stream().
                    sorted(Comparator.comparing(Work::getYear).reversed().
                            thenComparing(Work::getName)).
                    collect(Collectors.toUnmodifiableList()));
            case INBOOK -> notBackground(base.getListInBook().stream().
                    sorted(Comparator.comparing(Work::getYear).reversed().
                            thenComparing(Work::getName)).
                    collect(Collectors.toUnmodifiableList()));
            case INCOLLECTION -> notBackground(base.getListInCollection().stream().
                    sorted(Comparator.comparing(Work::getYear).reversed().
                            thenComparing(Work::getName)).
                    collect(Collectors.toUnmodifiableList()));
            default -> new ArrayList<>();
        };

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
