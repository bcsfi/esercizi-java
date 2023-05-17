package net.bcsoft;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PannelliSolari {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Inserire il path del file iniziale: ");
        String pathIniziale = input.next();

        try {
            ReportCreator report = new ReportCreator(pathIniziale);
            try {
                report.creaMappaPerData();
                report.creaMappaPerProvincia();
                report.stampaSuFile();
            } catch (IOException e) {
                System.out.println("ERRORE NELLA STAMPA DEL FILE");
                e.getStackTrace();
            }
        } catch (IOException e) {
            System.out.println("IL PATH " + pathIniziale + " NON E' CORRETTO");
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}