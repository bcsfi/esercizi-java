package util;

import model.Focaccia;
import model.Incasso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository
{
    public Repository() {}

    public static List<Incasso> eseguiQueryIncassi(Connection connection) throws SQLException
    {
        List<Incasso> incassi = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("" +
                "SELECT ordini.dataora, COUNT(distinct ordini.id), SUM(menu.prezzo) " +
                "FROM ordini JOIN scontrini ON ordini.id = scontrini.idordini " +
                "   JOIN menu ON scontrini.idmenu = menu.id " +
                "WHERE DATE_PART('day', CURRENT_DATE - ordini.dataora) < 30 " +
                "GROUP BY(ordini.dataora) " +
                "ORDER BY ordini.dataora");

        while (resultSet.next())
        {
            incassi.add(new Incasso (resultSet.getTimestamp(1).toLocalDateTime(), resultSet.getInt(2), resultSet.getDouble(3)));
        }

        resultSet.close();
        statement.close();

        return incassi;
    }

    public static List<Focaccia> eseguiQueryFocacce(Connection connection) throws SQLException
    {
        List<Focaccia> focacce = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("" +
                "SELECT menu.nome, COUNT(*) " +
                "FROM menu JOIN scontrini ON menu.id = scontrini.idmenu " +
                "   JOIN ordini ON scontrini.idordini = ordini.id " +
                "WHERE DATE_PART('day', CURRENT_DATE - ordini.dataora) < 30  " +
                "GROUP BY(menu.nome)");

        while (resultSet.next())
        {
            focacce.add(new Focaccia (resultSet.getString(1), resultSet.getInt(2)));
        }

        resultSet.close();
        statement.close();

        return focacce;
    }
}
