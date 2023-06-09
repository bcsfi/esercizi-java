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

@WebServlet(name = "Homepage", urlPatterns = "/home")
public class HomepageServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        PrintWriter writer = null;
        String output = null;
        try {
            writer = response.getWriter();
            output = createHtml();
        } catch (IOException e) {
            output = "ERRORE: " + e.getMessage();
        }
        writer.println(output);
        writer.flush();
    }

    private String createHtml() {
        String output = "";

        String header =
                "<!DOCTYPE html>" +
                        "<html>\n" +
                        "  <head>\n" +
                        "       <title>BC Vinaino | Homepage</title>\n" +
                        "       <link href=\"./style/style.css\" rel=\"stylesheet\">" +
                        "       <link href=\"./style/table.css\" rel=\"stylesheet\">" +
                        "   </head>\n" +
                        "   <body>\n" +
                        "        <center>\n" +
                        "        <h1>Vinaino</h1>\n" +
                        "        <a href=\"./focacce\">Report focacce</a> <br>" +
                        "        <a href=\"./incassi\">Report incassi mensili</a> <br>" +
                        "        <a href=\"./ordini\">Report incassi settimanali</a> <br>" +
                        "        <a href=\"./soglia \">Incassi settimanali soglia</a> <br>" +
                        "        <a href=\"./insert \">Inserisci ordine</a>";

        output += header;

        String chiusuraTag =
                "       </table>\n" +
                        "        </center>\n" +
                        "   </body>\n" +
                        "</html>";
        output += chiusuraTag;

        return output.toString();
    }
}