package net.bcsoft.bcvinaino.web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.bcsoft.bcvinaino.util.DatabaseManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "Focacce", urlPatterns = "bcvinaino/focacce")
public class FocacceServlet {

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
        String output = null;

        try {
            database = new DatabaseManager("localhost", 5432,
                    "bcbank", "postgres", "admin");
            Connection connessioneDatabase = database.getConnection();



        } catch (SQLException | ClassNotFoundException exception) {
            System.out.println("ERRORE GENERICO | " + exception.getMessage());
            throw new RuntimeException(exception);
        } finally {
            closeDatabaseConnection(database);
        }
        return output;
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
