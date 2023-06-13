package net.bcsoft.bcvinaino.web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.bcsoft.bcvinaino.util.DatabaseManager;
import net.bcsoft.bcvinaino.util.Query;

import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "InsertOrdine", urlPatterns = "/insertordine")
public class InsertOrdineServlet extends HttpServlet {
    private Short menu_id;
    private Integer quantita;

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            menu_id = Short.valueOf(request.getParameter("menu_id"));
            quantita = Integer.valueOf(request.getParameter("quantita"));
        } catch(IllegalArgumentException exception) {
            System.out.println("ERRORE INSERIMENTO UTENTE | " + exception.getMessage());
            exception.printStackTrace();
        }

        insert();
    }

    private void insert() {
        DatabaseManager database = null;
        try {
            database = new DatabaseManager();
            Connection connessioneDatabase = database.getConnection();
            Query.inserisciMenu(connessioneDatabase, menu_id, quantita);

        } catch (SQLException | ClassNotFoundException exception) {
            System.out.println("ERRORE INSERIMENTO DATI NEL DATABASE | " + exception.getMessage());
            exception.printStackTrace();
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

