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

@WebServlet(name = "Focacce", urlPatterns = "/focacce")
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
            database = new DatabaseManager();
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
                "       <title>BC Vinaino | Report focacce</title>\n" +
                "       <link href=\"./style/style.css\" rel=\"stylesheet\">" +
                "       <link href=\"./style/table.css\" rel=\"stylesheet\">" +
                "   </head>\n" +
                "   <body>\n" +
                "        <center>\n" +
                "        <h1>Report focacce</h1>\n" +
                "       <table class=\"table_user\">\n \n" +
                "           <tr>\n" +
                "               <th>Nome</th>\n" +
                "               <th>Numero vendite</th>\n" +
                "           </tr>\n \n";
        output += header;

        for (String nome : focacceMap.keySet()) {
            Integer quantita = focacceMap.get(nome);
            String rigaTabella =
                    "           <tr>\n" +
                    "               <td>" + nome + "</td>\n" +
                    "               <td>" + quantita + "</td>\n" +
                    "           </tr>\n \n";
            output += rigaTabella;
        }

        String chiusuraTag =
                "       </table>\n" +
                "        </center>\n" +
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
