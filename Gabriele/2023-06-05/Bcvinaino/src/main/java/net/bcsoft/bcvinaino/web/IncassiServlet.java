package net.bcsoft.bcvinaino.web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.bcsoft.bcvinaino.util.DatabaseManager;
import net.bcsoft.bcvinaino.util.Query;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;

@WebServlet(name = "Incassi", urlPatterns = "/incassi")
public class IncassiServlet extends HttpServlet {
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
                    "bcvinaino", "postgres", "admin");
            Connection connessioneDatabase = database.getConnection();
            incassiMensiliMap = Query.creaIncassiMensiliMap(connessioneDatabase);

        } catch (SQLException | ClassNotFoundException exception) {
            System.out.println("ERRORE GENERICO | " + exception.getMessage());
            throw new RuntimeException(exception);
        } finally {
            closeDatabaseConnection(database);
        }

        String output = "";

        String header =
                "<!DOCTYPE html>" +
                "<html>\n" +
                "  <head>\n" +
                "       <title>BC Vinaino | Report incassi</title>\n" +
                "       <style>" +
                "           .font { text-align: center; font-family: Arial, Helvetica, sans-serif;}" +
                "           th, td { border-top: 1px solid black; }" +
                "       </style>" +
                "   </head>\n" +
                "   <body>\n" +
                "       <table>\n \n" +
                "           <tr>\n" +
                "               <th class='font' style='color: black;'>Data</th>\n" +
                "               <th class='font' style='color: black;'>Incasso</th>\n" +
                "           </tr>\n \n";
        output += header;

        for (LocalDate localDate : incassiMensiliMap.keySet()) {
            Double incasso = incassiMensiliMap.get(localDate);
            String rigaTabella =
                    "           <tr>\n" +
                    "               <td class='font' style='color: grey;'>" + localDate + "</td>\n" +
                    "               <td class='font' style='color: grey;'>" + incasso + "</td>\n" +
                    "           </tr>\n \n";
            output += rigaTabella;
        }

        String chiusuraTag =
                "       </table>\n" +
                "   </body>\n" +
                "</html>";
        output += chiusuraTag;

        return output.toString();
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
