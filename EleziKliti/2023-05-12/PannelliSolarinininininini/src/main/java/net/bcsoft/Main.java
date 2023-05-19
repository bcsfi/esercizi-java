package net.bcsoft;

import java.io.IOException;

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
            if(args.length == 2){


                    String REPORT_PROVINCE = args[0];
                    String REPORT_DATE = args[1];

                    System.out.print("\n \n File resoconto.txt trovato all'interno della cartella, stiamo iniziando la lettura... \n \n");

                    try {

                        IncassoMensile incassoMensile = new IncassoMensile("resoconto.txt");
                        ReportCreator creator = new ReportCreator(incassoMensile);
                        creator.creaSommaPerPronvica(REPORT_PROVINCE);
                        creator.creaSommaPerData(REPORT_DATE);
                        creator.createLogs(LOGS_DATA);

                    } catch (IOException d){
                        System.out.print("Errore, il file resoconto.txt non esiste, inserire all'interno il file ");
                    }

                System.out.print("\n \n Programma, terminato con successo, i file sono stati creati all'interno dele due directory.\n");
                System.out.print("\n  | Directory dove è stato creato il report per le provincie: " + args[0] + "\n");
                System.out.print("\n | Directory dove è stato creato il report per le date: " + args[1] + "\n");
            } else {
                System.out.print("\n Programma non partito, mancano i 2 output del report.");

            }


    }
}