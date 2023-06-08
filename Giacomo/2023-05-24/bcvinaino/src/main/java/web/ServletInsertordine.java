package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.GestoreConnessione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "InsertOrdine", urlPatterns = "/insertordine")
public class ServletInsertordine extends HttpServlet
{
    Integer menu_id;
    Integer quantita;

    public ServletInsertordine() {}

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            menu_id = Integer.valueOf(request.getParameter("menu_id"));
            quantita = Integer.valueOf(request.getParameter("quantita"));
        }
        catch (NumberFormatException e)
        {
            throw new RuntimeException(e);
        }

        try
        {
            Connection connessione = GestoreConnessione.creaConnessione();
            PreparedStatement statement = connessione.prepareStatement("" +
                    "INSERT INTO ordini (dataora) VALUES (CURRENT_TIMESTAMP)", PreparedStatement.RETURN_GENERATED_KEYS);
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next())
            {
                statement = connessione.prepareStatement("" +
                        "INSERT INTO scontrini (idordini, idmenu, quantita) VALUES (?, ?, ?)");
                statement.setInt(1, resultSet.getInt(1));
                statement.setInt(2, menu_id);
                statement.setInt(3, quantita);
                statement.executeUpdate();
                resultSet.close();
                statement.close();
            }
        }
        catch (SQLException | ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
}
