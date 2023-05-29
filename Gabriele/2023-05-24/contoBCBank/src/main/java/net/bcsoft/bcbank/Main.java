package net.bcsoft.bcbank;

import net.bcsoft.bcbank.model.ContoCorrente;
import net.bcsoft.bcbank.model.EstrattoContoMensile;
import net.bcsoft.bcbank.model.Transazione;
import net.bcsoft.bcbank.util.ConnessioneDatabase;
import net.bcsoft.bcbank.util.Query;
import net.bcsoft.bcbank.util.ReportCreator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Inserire il path dove salvare i file: ");
        String pathFinale = input.next();
        Connection connesione = null;

        try {
            connesione = ConnessioneDatabase.createConnection();

            List<Transazione> transazioneList = Query.loadTransazioneList(connesione);
            List<EstrattoContoMensile> estrattoContoMensileList = Query.loadEstrattoContoMensileList(connesione);
            List<ContoCorrente> contoCorrenteList = Query.loadContoCorrenteList(connesione);

            ReportCreator reportCreator = new ReportCreator(pathFinale);
            Map<Integer, Integer> transazioneMap = reportCreator.aggregaTransazioni(transazioneList);
            Map<Integer, Double> giacenzaMap = reportCreator.aggregaGiacenze(estrattoContoMensileList, transazioneList);
            reportCreator.stampaSuFile(contoCorrenteList, giacenzaMap, transazioneMap);

        } catch (IllegalArgumentException exception) {
            System.out.println("ERRORE PATH INSERITO | " + exception.getMessage());
        } catch (SQLException | IOException | ClassNotFoundException exception) {
            System.out.println("ERRORE GENERICO | " + exception.getMessage());
            throw new RuntimeException(exception);
        } finally {
            try {
                connesione.close();
            } catch (SQLException exception) {
                System.out.println("ERRORE DISCONNESSIONE DATABASE | " + exception.getMessage());
                throw new RuntimeException(exception);
            }
        }
    }
}