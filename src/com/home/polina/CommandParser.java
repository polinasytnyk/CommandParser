package com.home.polina;

import java.awt.*;

public class CommandParser {

    public static void main(String[] args) {
        printHeader();
        if (args.length==0) {
            printHelp();
            return;
        }
        for (int i=0; i<args.length; i++) {
            if (args[i].equals("/?") || args[i].equals("/help") || args[i].equals("-help")) {
                printHelpExt();
            }
            if (args[i].equals("-print")) {
                printMessage(args[i+1]);
            }
            if (args[i].equals("-ping")) {
                printBeep();
            }
            if (args[i].equals("-k")) {
                printKeyValueTable(args,i);
            }
        }
    }

    private static void printKeyValueTable(String[] args, int i) {
        for (int j=i+1;j<args.length;) {
            String key = "";
            String value = "";
            
            try {
                key = args[j];
            } catch (Exception e) {
                key = "<null>";
            }
            try {
                value = args[j+1];
            } catch (Exception e) {
                value = "<null>";
            }

            if (key.equals("-ping") || key.equals("-print") || key.equals("/?") || key.equals("/help") || key.equals("-help")) {
                return;
            }
            if (value.equals("-ping") || value.equals("-print") || value.equals("/?") || value.equals("/help") || value.equals("-help")) {
                value = "<null>";
            }

            System.out.println(key + " - " + value);
            j=j+2;
        }
    }

    private static void printHeader() {
        System.out.println("Command line parser, powered by Polina Sytnik (C) 2015");
        System.out.println();
    }

    private static void printBeep() {
        Toolkit.getDefaultToolkit().beep();
        System.out.println("Be-e-e-e-e-p!!!!");
    }

    private static void printMessage(String arg) {
        System.out.println("Message: " + arg);
    }

    private static void printHelpExt() {
        System.out.println("CommandParser.exe [/?] [/help] [-help] [-k key value] [-ping] [-print <print a value>]");
    }

    private static void printHelp() {
        System.out.println("use CommandParser.exe /? to see set of allowed commands");
    }
}
