package org.BCVinaiano.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.BCVinaiano.jdbc.ConnectionProvider;
import org.BCVinaiano.model.HtmlTable;
import org.BCVinaiano.model.ProgramManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

@WebServlet(name = "Controlla i tuoi ordini", urlPatterns = "/ordini")
public class Ordini extends HttpServlet
{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try {
            ConnectionProvider provider = new ConnectionProvider("localhost", "5432", "bcvinaino", "postgres", "Astrorep");
            Connection connessione = provider.getConnection();

            PreparedStatement statement = connessione.prepareStatement(                   "SELECT " +
                    " ordini.id_ordine, ordini.data_ordine, sum(menu.prezzo) " +
                    "FROM " +
                    "ordini, menu, articoli_ordine " +
                    "WHERE " +
                    "articoli_ordine.id_menu = menu.id_menu AND " +
                    "ordini.id_ordine = articoli_ordine.id_ordine AND " +
                    "ordini.data_ordine > ? " +
                    "GROUP BY " +
                    "ordini.id_ordine " +
                    "ORDER BY ordini.id_ordine; ");


                try {
                    Calendar cal = new GregorianCalendar();
                    cal.add(Calendar.DAY_OF_MONTH, -15);

                    Date sqlDate = new Date(cal.getTimeInMillis());
                    statement.setDate(1, sqlDate);

                    String htmlResult = "<html>" +
                            "           <table style=' margin: 1em; padding: 1em; background-color: #1B5891; border-radius: 5px;'>" +
                            "           <tr style='border: 2px solid grey; font-weight: bold; font-size: 1.3em; text-align: left;'>" +
                            "           <tr style='border: 2px solid grey; font-weight: bold; font-size: 1.3em; text-align: left;'>";

                    htmlResult += "<th style='width: 300px;'> ID_ORDINE </th>";
                    htmlResult += "<th style='width: 300px;'> GIORNO </th>";
                    htmlResult += "<th style='width: 300px;'> IMPORT_TOTALE </th>";
                    htmlResult += "<tr>";

                    ResultSet result = statement.executeQuery();
                    while (result.next()){
                        htmlResult += "<td style=' padding: 0.5em;'>";
                        htmlResult += result.getString(1);
                        htmlResult += "</td>";
                        htmlResult += "<td style=' padding: 0.5em;'>";
                        htmlResult += result.getString(2);
                        htmlResult += "</td>";
                        htmlResult += "<td style=' padding: 0.5em;'>";
                        htmlResult += result.getString(3);
                        htmlResult += "</td>";
                        htmlResult+= ("</tr>");
                    }

                    htmlResult += "</table>";
                    htmlResult += "<html>";
                    PrintWriter writer = resp.getWriter();
                    writer.println(htmlResult);
                } catch (SQLException e) {

                    throw new RuntimeException(e);
                }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
