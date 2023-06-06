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
import java.util.Map;

@WebServlet(name = "Focacce", urlPatterns = "/bcvinaino/focacce")
public class FocacceServlet extends HttpServlet {

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
        Map<String, Integer> focacceMap;

        try {
            database = new DatabaseManager("localhost", 5432,
                    "bcvinaino", "postgres", "admin");
            Connection connessioneDatabase = database.getConnection();
            focacceMap = Query.creaFocacceMap(connessioneDatabase);


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
                "       <title>BC Vinaino | Report focacce</title>" +
                "       <style>" +
                "           .font { text-align: center; font-family: Arial, Helvetica, sans-serif;}" +
                "           th, td { border-top: 1px solid black; }" +
                "       </style>" +
                "   </head>\n" +
                "   <body>\n" +
                "       <table>\n \n" +
                "           <tr>\n" +
                "               <th class='font' style='color: black;'>Nome</th>\n" +
                "               <th class='font' style='color: black;'>Numero vendite</th>\n" +
                "           </tr>\n \n";
        output += header;

        for (String nome : focacceMap.keySet()) {
            Integer quantita = focacceMap.get(nome);
            String rigaTabella =
                    "           <tr>\n" +
                    "               <td class='font' style='color: grey;'>" + nome + "</td>\n" +
                    "               <td class='font' style='color: grey;'>" + quantita + "</td>\n" +
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
