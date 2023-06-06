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


@WebServlet(name="Guarda quante focaccie sono state vendute!", urlPatterns="/incassi")
public class RouteOrderByData extends HttpServlet{


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            ProgramManager program = new ProgramManager();
            PrintWriter writer = response.getWriter();
            String htmlStr = HtmlTable.createHtmlTable(program.createEraningByData(
                    "SELECT " +
                    "data_ordine, " +
                    "sum(menu.prezzo) " +
                    "FROM " +
                    "ordini, menu, articoli_ordine " +
                    "WHERE " +
                    "menu.id_menu = articoli_ordine.id_menu AND " +
                    "articoli_ordine.id_ordine = ordini.id_ordine " +
                    "GROUP BY " +
                    "data_ordine; "));
            writer.println(htmlStr);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
