package org.insightcentre.pthg24.analysis;

import org.insightcentre.pthg24.datamodel.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static framework.reports.AbstractCommon.safe;
import static org.insightcentre.pthg24.logging.LogShortcut.severe;

public class ListPapers {
    public ListPapers(Scenario base, String exportDir, String fileName){
        assert(exportDir.endsWith("/"));
        String fullName= exportDir+fileName;
        try{
            PrintWriter out = new PrintWriter(fullName);
            out.printf("{\\scriptsize\n");
            out.printf("\\begin{longtable}{p{3cm}p{6cm}p{7cm}rrrp{3cm}r}\n");
            out.printf("\\caption{Papers from bibtex}\\\\ \\toprule\n");
            out.printf("Key& Authors & Title & LC &Cite & Year & Conference & Pages \\\\ \\midrule");
            out.printf("\\endhead\n");
            out.printf("\\bottomrule\n");
            out.printf("\\endfoot\n");
            for(Paper a:sortedPapers(base)){
                out.printf("%s \\href{%s}{%s} & %s & \\href{%s}{%s} & %s & \\cite{%s} & %d & %s & %d",
                        a.getKey(),a.getUrl(),a.getKey(),
                        authors(a),
                        a.getLocalCopy(), safe(a.getTitle()),
                        (localCopyExists(a)?"":"NO"),
                        a.getName(),
                        a.getYear(),
                        shortProc(a.getProceedings()),
                        a.getNrPages());
                out.printf("\\\\\n");
            }
            out.printf("\\end{longtable}\n");
            out.printf("}\n\n");
            out.close();
        } catch(IOException e){
            severe("Cannot write file: "+fullName+", exception "+e.getMessage());
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
        Path path = Paths.get("overview/"+a.getLocalCopy());
        return Files.exists(path);

    }

    private List<Paper> sortedPapers(Scenario base){
        return base.getListPaper().stream().
                sorted(Comparator.comparing(Work::getYear).reversed().
                        thenComparing(Work::getName)).
                collect(Collectors.toUnmodifiableList());
    }

    private String authors(Work a){
        return a.getAuthors().stream().
                map(Author::getShortName).
                collect(Collectors.joining(", "));
    }

    private String nameOf(ApplicationObject a){
        if (a==null){
            return "";
        } else {
            return safe(a.getName());
        }
    }
}
