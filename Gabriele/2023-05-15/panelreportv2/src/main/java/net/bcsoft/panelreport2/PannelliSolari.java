package net.bcsoft.panelreport2;

import net.bcsoft.panelreport2.Exception.LetturaFileException;
import net.bcsoft.panelreport2.Exception.ProvinciaErrataException;
import net.bcsoft.panelreport2.Exception.StampaSuFileException;

import java.io.IOException;
import java.util.Scanner;

public class PannelliSolari {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Inserire il path del file iniziale: ");
        String pathIniziale = input.next();

        try {
            ReportCreator report = new ReportCreator(pathIniziale);
            report.creaMappaPerData();
            report.creaMappaPerProvincia();
            report.stampaSuFile();
        } catch (ProvinciaErrataException e) {
            System.out.println("TROVATA PROVINCIA ERRATA!");
        } catch (StampaSuFileException e) {
            System.out.println("ERRORE STAMPA SU FILE");
        } catch (LetturaFileException e) {
            System.out.println("ERRORE LETTURA FILE");
        }
    }
}
