package org.insightcentre.pthg24.imports;

import org.insightcentre.pthg24.datamodel.Scenario;
import org.insightcentre.pthg24.datamodel.Translator;

public class CreateTranslators {
    Scenario base;
    public CreateTranslators(Scenario base){
        this.base = base;
        ct("’","'");
//        ct("á","{\\'{a}}");
//        ct("é","{\\'{e}}");
//        ct("í","{\\'{i}}");
//        ct("ó","{\\'{o}}");
//        ct("ú","{\\'{u}}");
//        ct("Á","{\\'{A}}");
//        ct("É","{\\'{E}}");
//        ct("Í","{\\'{I}}");
//        ct("Ó","{\\'{O}}");
//        ct("Ú","{\\'{U}}");
//        ct("é","{\\'{e}}");
//        ct("å","a");
//        ct("Š","S");
//        ct("á","{\\'{a}}");
//        ct("Ç","C");
//        ct("ğ","g");
//        ct("ö","o");
//        ct("ü","u");
//        ct("ş","s");
        ct("\\u00c4","{\\\"{A}}");
        ct("\\u00e4","{\\\"{a}}");
        ct("\\u00d6","{\\\"{O}}");
        ct("\\u00f6","{\\\"{o}}");
        ct("\\u00dc","{\\\"{U}}");
        ct("\\u00fc","{\\\"{u}}");
        ct("\\u00df","ss");
        ct("\\u00e8","{\\`{e}}");
        ct("\\u00e9","{\\'{e}}");
        ct("\\u00ea","{\\^{e}}");
        ct("\\u00eb","{\\\"{e}}");
//        ct("","");
//        ct("","");
//        ct("","");

    }


    private void ct(String unicode,String latex){
        Translator t = new Translator(base);
        t.setUnicode(unicode);
        t.setLatex(latex);
    }
}
