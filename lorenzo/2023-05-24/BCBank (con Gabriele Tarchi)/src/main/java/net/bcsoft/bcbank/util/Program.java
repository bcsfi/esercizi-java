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

public class Program {

    public static void start () {
        Scanner input = new Scanner(System.in);
        System.out.println("Inserire il path dove salvare i file: ");
        String pathFinale = input.next();
        DatabaseManager database = null;
        try {
            database = new DatabaseManager("localhost", 5432,
                    "bc_bank", "postgres", "Gabry0308");
            Connection connessioneDatabase = database.getConnection();

            List<Transazione> transazioneList = Query.loadTransazioneList(connessioneDatabase);
            List<EstrattoContoMensile> estrattoContoMensileList = Query.loadEstrattoContoMensileList(connessioneDatabase);
            List<ContoCorrente> contoCorrenteList = Query.loadContoCorrenteList(connessioneDatabase);
            ReportCreator reportCreator = new ReportCreator(pathFinale, transazioneList, estrattoContoMensileList, contoCorrenteList);

            reportCreator.stampaSuFile();

        } catch (IllegalArgumentException exception) {
            System.out.println("ERRORE PATH INSERITO | " + exception.getMessage());
        } catch (SQLException | IOException | ClassNotFoundException exception) {
            System.out.println("ERRORE GENERICO | " + exception.getMessage());
            throw new RuntimeException(exception);
        } finally {
            closeConnection(database);
            }
    }

    private static void closeConnection(DatabaseManager database) {
        try {
            database.closeConnection();
        } catch (SQLException e) {
            System.out.println("ERRORE DISCONNESSIONE DATABASE | " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
