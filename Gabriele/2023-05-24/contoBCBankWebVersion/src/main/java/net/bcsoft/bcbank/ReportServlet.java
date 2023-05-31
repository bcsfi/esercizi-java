package net.bcsoft.bcbank;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.bcsoft.bcbank.model.ContoCorrente;
import net.bcsoft.bcbank.model.EstrattoContoMensile;
import net.bcsoft.bcbank.model.Transazione;
import net.bcsoft.bcbank.util.DatabaseManager;
import net.bcsoft.bcbank.util.Query;
import net.bcsoft.bcbank.util.ReportCreator;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Report", urlPatterns = "/report")
public class ReportServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/plain");
        PrintWriter writer = null;
        String output = null;
        try { 
            writer = response.getWriter();
            output = createStringReport();
        } catch (IOException e) {
            output = "ERRORE: " + e.getMessage();
        }
        writer.println(output);
        writer.flush();
    }

    private String createStringReport() {
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

    private void closeDatabaseConnection(DatabaseManager database) {
        try {
            database.closeConnection();
        } catch (SQLException e) {
            System.out.println("ERRORE DISCONNESSIONE DATABASE | " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
