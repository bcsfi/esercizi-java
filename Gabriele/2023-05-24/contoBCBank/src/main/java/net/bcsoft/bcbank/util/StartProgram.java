package net.bcsoft.bcbank.util;

import net.bcsoft.bcbank.model.ContoCorrente;
import net.bcsoft.bcbank.model.EstrattoContoMensile;
import net.bcsoft.bcbank.model.Transazione;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StartProgram {

    public static void start () {

        Scanner input = new Scanner(System.in);
        System.out.println("Inserire il path dove salvare i file: ");
        String pathFinale = input.next();
        Connection conessione = null;

        try {
            conessione = ConnessioneDatabase.createConnection();

            List<Transazione> transazioneList = Query.loadTransazioneList(conessione);
            List<EstrattoContoMensile> estrattoContoMensileList = Query.loadEstrattoContoMensileList(conessione);
            List<ContoCorrente> contoCorrenteList = Query.loadContoCorrenteList(conessione);
            Map<Integer, Integer> transazioneMap = new HashMap<>();
            Map<Integer, Double> giacenzaMap = new HashMap<>();
            ReportCreator reportCreator = new ReportCreator(pathFinale, transazioneList, estrattoContoMensileList, contoCorrenteList,transazioneMap, giacenzaMap );

            reportCreator.stampaSuFile();

        } catch (IllegalArgumentException exception) {
            System.out.println("ERRORE PATH INSERITO | " + exception.getMessage());
        } catch (SQLException | IOException | ClassNotFoundException exception) {
            System.out.println("ERRORE GENERICO | " + exception.getMessage());
            throw new RuntimeException(exception);
        } finally {
            try {
                conessione.close();
            } catch (SQLException exception) {
                System.out.println("ERRORE DISCONNESSIONE DATABASE | " + exception.getMessage());
                throw new RuntimeException(exception);
            }
        }
    }
}
