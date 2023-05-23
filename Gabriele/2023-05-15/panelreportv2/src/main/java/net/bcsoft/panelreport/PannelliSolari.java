package net.bcsoft.panelreport;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class PannelliSolari {
    public static void main(String[] args) {
        String pathFinale = args[0];

        try {
            ReportCreator report = new ReportCreator(pathFinale);
            GestoreMappa gestoreMappa = new GestoreMappa();
            report.stampaSuFile( gestoreMappa.creaMappaPerProvincia(),gestoreMappa.creaMappaPerData());
            Logger.printLog(pathFinale);
        } catch (IOException e) {
            System.out.println("ERRORE FILE " + e.getMessage());
        }
    }
}
