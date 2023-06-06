package net.bcsoft.bcvinaino.web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.bcsoft.bcvinaino.model.Menu;
import net.bcsoft.bcvinaino.model.Ordine;
import net.bcsoft.bcvinaino.util.DatabaseManager;
import net.bcsoft.bcvinaino.util.Query;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Incassi", urlPatterns = "/incassi")
public class IncassiServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        PrintWriter writer = null;
        String output = null;
        try {
            writer = response.getWriter();
            output = createHtmlReport();
        } catch (IOException e) {
            output = "ERRORE: " + e.getMessage();
        }
        writer.println(output);
        writer.flush();
    }

    private String createHtmlReport() {
        DatabaseManager database = null;
        Map<LocalDate, Double> incassiMensiliMap;

        try {
            database = new DatabaseManager("localhost", 5432,
                    "bcbank", "postgres", "admin");
            Connection connessioneDatabase = database.getConnection();
            incassiMensiliMap = Query.creaIncassiMensiliMap(connessioneDatabase);

        } catch (SQLException | ClassNotFoundException exception) {
            System.out.println("ERRORE GENERICO | " + exception.getMessage());
            throw new RuntimeException(exception);
        } finally {
            closeDatabaseConnection(database);
        }

        String output =
                "<!DOCTYPE html>" +
                        "<html>\n" +
                        "  <head>\n" +
                        "       <title>BCBank | Report</title>\n" +
                        "       <style>" +
                        "           .font { text-align: center; font-family: Arial, Helvetica, sans-serif;}" +
                        "           th, td { border-top: 1px solid black; }" +
                        "       </style>" +
                        "   </head>\n" +
                        "   <body>\n" +
                        "<p>" + incassiMensiliMap + "</p>\n" +
                        "   </body>\n" +
                        "</html>";
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
