package org.insightcentre.pthg24.logging;

import org.insightcentre.pthg24.logging.Logger;
import java.util.logging.ConsoleHandler;

public class LogShortcut {

       public static void initConsole(){
//        Logger.getInstance().addHandler(new ConsoleHandler());
       }

       public static void info(String msg){
           Logger.getInstance().info(msg);
           System.out.println("info: "+msg);
       }

       public static void warning(String msg){
           Logger.getInstance().warning(msg);
           System.out.println("warning: "+msg);
       }

       public static void severe(String msg){
           Logger.getInstance().severe(msg);
           System.out.println("error: "+msg);
       }
}
