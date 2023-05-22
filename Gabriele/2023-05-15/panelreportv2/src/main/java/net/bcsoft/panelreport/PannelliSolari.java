package net.bcsoft.panelreport;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class PannelliSolari {
    public static void main(String[] args) {

        String pathFinale = args[0];

        /*
        String pathIniziale = args[0];
        Scanner input = new Scanner(System.in);
        System.out.print("Inserire il path del file iniziale: ");
        String pathIniziale = input.next();

        System.out.print("Inserire il path dove creare i file: ");
        String pathFinale = input.next();
        */

        try {
            ReportCreator report = new ReportCreator(pathFinale);
            report.creaMappaPerData();
            report.creaMappaPerProvincia();
            report.stampaSuFile();
            Logger.printLog(pathFinale);
        } catch (IOException e) {
            System.out.println("ERRORE FILE " + e.getMessage());
        }
    }
}
