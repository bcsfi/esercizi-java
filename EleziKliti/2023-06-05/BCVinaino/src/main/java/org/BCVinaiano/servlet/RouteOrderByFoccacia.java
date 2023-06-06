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
import java.sql.Connection;
import java.sql.SQLException;


@WebServlet(name="Foccaccine buone", urlPatterns="/foccacie")
public class RouteOrderByFoccacia extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {

            ConnectionProvider provider = new ConnectionProvider("localhost", "5432", "bcvinaino", "postgres", "Astrorep");
            Connection connessione = provider.getConnection();


            PrintWriter writer = response.getWriter();
            String htmlStr = HtmlTable.createHtmlTable(ProgramManager.createOrderByFoccacia( connessione,
                     "SELECT " +
                            "menu.focaccia, " +
                            "COUNT(*) " +
                            "FROM " +
                            "articoli_ordine, menu, ordini " +
                            "WHERE " +
                            "articoli_ordine.id_ordine = ordini.id_ordine AND " +
                            "menu.id_menu = articoli_ordine.id_menu AND menu.prezzo > ? AND menu.prezzo < ? " +
                            "GROUP BY " +
                            "menu.focaccia " +
                            "HAVING\n" +
                             "COUNT(*) > 3;"));
            writer.println(htmlStr);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
