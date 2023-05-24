package net.bcsoft;

import net.bcsoft.Function.ErrorManager;
import net.bcsoft.Function.RaccoltaIncassi;
import net.bcsoft.Function.ReportCreator;

import java.io.IOException;
import java.sql.*;

public class Main {
    /**
     * Programma gestione Report Creator
     *
     * Realizzato da Kliti & Angelo <3
     */
    // public static final String REPORT_PROVINCE = "C:\\Users\\bcsoft\\outputPanelli\\reportProvince.txt";
    // public static final String REPORT_DATE = "C:\\Users\\bcsoft\\outputPanelli\\reportDate.txt";
    public static final String OUTPUT_DATA_LOGS = "C:\\Users\\bcsoft\\outputPanelli\\logs.txt";

    public Main() throws SQLException, ClassNotFoundException {
    }

    public static void main(String[] args)  {

        String titleError = "Gestore errori \n";
        StringBuilder titleErrorSB = new StringBuilder(titleError);
        ErrorManager gestoreErrori = new ErrorManager(titleErrorSB, OUTPUT_DATA_LOGS);

        try {

            // Verifica se i input sono 2
            if (args.length == 2) {


                String REPORT_PROVINCE = args[0];
                String REPORT_DATE = args[1];


                RaccoltaIncassi raccoltaIncassi = new RaccoltaIncassi();
                ReportCreator creator = new ReportCreator(raccoltaIncassi);
                creator.creaSommaPerPronvica(REPORT_PROVINCE);
                creator.creaSommaPerData(REPORT_DATE);

                System.out.print("\n \n Programma, terminato con successo, i file sono stati creati all'interno delle due directory.\n");
                System.out.print("\n | Directory dove è stato creato il report per le provincie: " + args[0]);
                System.out.print("\n | Directory dove è stato creato il report per le date: " + args[1]);
            } else {
                System.out.print("\nProgramma non partito, mancano i 2 output del report.\n");

            }

        }catch (SQLException x){
            gestoreErrori.addError("Errore SQLExcpetion rilevato nel codice");
        } catch (ClassNotFoundException e) {
            gestoreErrori.addError("Errore ClassNotFoundException rilevato nel codice");
        } catch (IOException x){
            gestoreErrori.addError("Errore IOExcpetion rilevato.");
        } catch (NullPointerException x){
            gestoreErrori.addError("Errore null Point Exception creato.");
        }

        gestoreErrori.writeError();
        System.out.print("File logs, creato.");
    }


}