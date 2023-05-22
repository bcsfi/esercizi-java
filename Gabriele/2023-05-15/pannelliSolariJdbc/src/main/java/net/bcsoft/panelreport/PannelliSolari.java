package net.bcsoft.panelreport;

import java.io.IOException;
import java.util.Scanner;

public class PannelliSolari {
    public static void main(String[] args) {
        String pathIniziale = args[0];
        String pathFinale = args[1];

        /*
        Scanner input = new Scanner(System.in);
        System.out.print("Inserire il path del file iniziale: ");
        String pathIniziale = input.next();

        System.out.print("Inserire il path dove creare i file: ");
        String pathFinale = input.next();
        */

        try {
            ReportCreator report = new ReportCreator(pathIniziale, pathFinale);
            report.creaMappaPerData();
            report.creaMappaPerProvincia();
            report.stampaSuFile();
            Logger.printLog(pathFinale);
        } catch (IOException e) {
            System.out.println("ERRORE FILE");
        }
    }
}
