package org.BCVinaiano.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.BCVinaiano.model.HtmlTable;
import org.BCVinaiano.model.ProgramManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet(name="Foccaccine buone", urlPatterns="/foccacie")
public class RouteOrderByFoccacia extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            ProgramManager program = new ProgramManager();
            PrintWriter writer = response.getWriter();
            String htmlStr = HtmlTable.createHtmlTable(program.createOrderByFoccacia(
                     "SELECT " +
                            "menu.focaccia, " +
                            "COUNT(*) " +
                            "FROM " +
                            "articoli_ordine, menu, ordini " +
                            "WHERE " +
                            "articoli_ordine.id_ordine = ordini.id_ordine AND " +
                            "menu.id_menu = articoli_ordine.id_menu " +
                            "GROUP BY " +
                            "menu.focaccia "));
            writer.println(htmlStr);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
