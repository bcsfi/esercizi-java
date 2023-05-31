package net.bcsoft.bcbank.util;

import net.bcsoft.bcbank.model.ContoCorrente;
import net.bcsoft.bcbank.model.EstrattoContoMensile;
import net.bcsoft.bcbank.model.Transazione;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Program {

    public static String start() {
        DatabaseManager database = null;
        String output = null;

        try {
            database = new DatabaseManager("localhost", 5432,
                    "bc_bank", "postgres", "Gabry0308");
            Connection connessioneDatabase = database.getConnection();

            List<Transazione> transazioneList = Query.loadTransazioneList(connessioneDatabase);
            List<EstrattoContoMensile> estrattoContoMensileList = Query.loadEstrattoContoMensileList(connessioneDatabase);
            List<ContoCorrente> contoCorrenteList = Query.loadContoCorrenteList(connessioneDatabase);
            ReportCreator reportCreator = new ReportCreator(transazioneList, estrattoContoMensileList, contoCorrenteList);
            output = reportCreator.outputWeb();

        } catch (SQLException | IOException | ClassNotFoundException exception) {
            System.out.println("ERRORE GENERICO | " + exception.getMessage());
            throw new RuntimeException(exception);
        } finally {
            closeDatabaseConnection(database);
        }
        return output;
    }

    private static void closeDatabaseConnection(DatabaseManager database) {
        try {
            database.closeConnection();
        } catch (SQLException e) {
            System.out.println("ERRORE DISCONNESSIONE DATABASE | " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
