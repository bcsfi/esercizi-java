package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.GestoreConnessione;
import util.Repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "InsertOrdine", urlPatterns = "/insertordine")
public class ServletInsertordine
{
    public ServletInsertordine() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    {


        try
        {
            Connection connessione = GestoreConnessione.creaConnessione();
            PreparedStatement statement = connessione.prepareStatement("" +"INSERT INTO ordini () VALUES()");
        }
        catch (SQLException | ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
}
