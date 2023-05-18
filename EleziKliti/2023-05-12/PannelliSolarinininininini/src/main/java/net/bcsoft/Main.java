package net.bcsoft;

import javax.print.DocFlavor;
import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    /**
     * Programma gestione Report Creator
     *
     * Realizzato da Kliti & Angelo <3
     */
    // public static final String REPORT_PROVINCE = "C:\\Users\\bcsoft\\outputPanelli\\reportProvince.txt";
    // public static final String REPORT_DATE = "C:\\Users\\bcsoft\\outputPanelli\\reportDate.txt";
    public static final String LOGS_DATA = "C:\\Users\\bcsoft\\outputPanelli\\logs.txt";

    public static void main(String[] args) {

            // Verifica se i input sono 2
            if(args.length == 1){

                Path directoryUtenteProvinei = Paths.get(args[0]);
                Path directoryUtenteDate = Paths.get(args[1]);

                if(Files.isDirectory(directoryUtenteProvinei) && Files.isDirectory(directoryUtenteDate)){
                    String REPORT_PROVINCE = args[0];
                    String REPORT_DATE = args[1];

                    System.out.print("Stiamo leggendo i percosi");

                    IncassoMensile incassoMensile = new IncassoMensile("resoconto.txt");
                    ReportCreator creator = new ReportCreator(incassoMensile);

                    creator.creaSommaPerPronvica(REPORT_PROVINCE);
                    creator.creaSommaPerData(REPORT_DATE);
                    creator.createLogs(LOGS_DATA);
                } else {
                    System.out.print("Questo programma non puo funzionare, perchè le directory inserite sembrano inesistenti...");
                }

            }

        System.out.print("Programma non partito, mancano i 2 output del report.");



    }
}