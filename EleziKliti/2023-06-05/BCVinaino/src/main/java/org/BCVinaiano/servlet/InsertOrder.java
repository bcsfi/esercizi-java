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
import java.time.LocalDate;


@WebServlet(name="Inserisci l'ordine bello!!!", urlPatterns="/insertordine")
public class InsertOrder extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id_ordine = 0;
        long menu_id = 0;
        int qta = 0;

        try {

            try {
                menu_id = Integer.parseInt(request.getParameter("menu_id"));
                qta = Integer.parseInt(request.getParameter("qta"));
            } catch (NumberFormatException x){
                request.getRequestDispatcher("/errorInsert.html").forward(request, response);

            }


            ConnectionProvider provider = new ConnectionProvider("localhost", "5432", "bcvinaino", "postgres", "Astrorep");
            Connection connessione = provider.getConnection();


            PreparedStatement queryForOrdini = connessione.prepareStatement("INSERT INTO ordini(data_ordine) VALUES (?);", Statement.RETURN_GENERATED_KEYS);
            LocalDate dataOggi = LocalDate.now();
            Date data = Date.valueOf(dataOggi);
            queryForOrdini.setDate(1, data);

            queryForOrdini.executeUpdate();

            ResultSet chiaviGenerate = queryForOrdini.getGeneratedKeys();

            while(chiaviGenerate.next()){
                id_ordine = chiaviGenerate.getInt(1);
            }


            chiaviGenerate.close();
            queryForOrdini.close();


            PreparedStatement queryForArticoliOrdine = connessione.prepareStatement("INSERT INTO articoli_ordine(id_ordine, id_menu, qta) VALUES (?, ?, ?);");
            queryForArticoliOrdine.setInt(1, id_ordine); // valore per colonna1
            queryForArticoliOrdine.setLong(2, menu_id); // valore per colonna2
            queryForArticoliOrdine.setInt(3, qta); // valore per colonna2

            queryForArticoliOrdine.executeUpdate();
            queryForArticoliOrdine.close();

            // PrintWriter writer = response.getWriter();
            // writer.println("Inserszione avvenuta con success.");

            request.getRequestDispatcher("/successInsert.html").forward(request, response);

        } catch (ClassNotFoundException | SQLException | ServletException e) {
            throw new RuntimeException(e);
        }

    }
}
