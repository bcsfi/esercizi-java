package net.bcsoft.bcvinaino.web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.bcsoft.bcvinaino.util.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "InsertOrdine", urlPatterns = "/insertordine")
public class InsertOrdineServlet extends HttpServlet {
    private Short menu_id;
    private Integer quantita;

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        menu_id = Short.valueOf(request.getParameter("menu_id"));
        quantita = Integer.valueOf(request.getParameter("quantita"));
    }

    private void insert() {
        DatabaseManager database = null;
        try {
            database = new DatabaseManager();
            Connection connessioneDatabase = database.getConnection();


        } catch (SQLException | ClassNotFoundException exception) {
            System.out.println("ERRORE GENERICO | " + exception.getMessage());
            throw new RuntimeException(exception);
        } finally {
            closeDatabaseConnection(database);
        }
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

