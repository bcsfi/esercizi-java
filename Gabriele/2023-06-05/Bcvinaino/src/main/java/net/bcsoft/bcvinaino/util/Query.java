package net.bcsoft.bcvinaino.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Query {
    public static Map<LocalDate, Double> creaIncassiMensiliMap(Connection connessione) throws SQLException {
        String query = "SELECT ordini.data_ordine, SUM(menu.prezzo * menu_ordini.quantita) " +
                "FROM ordini JOIN menu_ordini ON ordini.id_ordine = menu_ordini.id_ordini " +
                "JOIN menu on menu_ordini.id_menu = menu.id_menu " +
                "WHERE ordini.data_ordine > ? " +
                "GROUP BY ordini.data_ordine " +
                "ORDER BY ordini.data_ordine DESC";

        PreparedStatement statement = connessione.prepareStatement(query);
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DAY_OF_MONTH, -15);
        Date sqlDate = new Date(calendar.getTimeInMillis());
        statement.setDate(1, sqlDate);
        ResultSet resultSet = statement.executeQuery();

        Map<LocalDate, Double> mappaUscita = new HashMap<>();
        try {
            while (resultSet.next()) {
                mappaUscita.put(resultSet.getDate(1).toLocalDate(), resultSet.getDouble(2));
            }
        } finally {
            resultSet.close();
            statement.close();
        }
        return mappaUscita;
    }

    public static Map<String, Integer> creaFocacceMap(Connection connessione) throws SQLException {
        String query = "SELECT menu.nome, COUNT(*) " +
                "FROM menu JOIN menu_ordini ON menu.id_menu = menu_ordini.id_menu " +
                "JOIN ordini ON menu_ordini.id_ordini = ordini.id_ordine " +
                "WHERE ordini.data_ordine > ? " +
                "GROUP BY menu.nome, ordini.data_ordine " +
                "ORDER BY ordini.data_ordine DESC";

        PreparedStatement statement = connessione.prepareStatement(query);
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DAY_OF_MONTH, -15);
        Date sqlDate = new Date(calendar.getTimeInMillis());
        statement.setDate(1, sqlDate);
        ResultSet resultSet = statement.executeQuery();

        Map<String, Integer> mappaUscita = new HashMap<>();
        try {
            while (resultSet.next()) {
                mappaUscita.put(resultSet.getString(1), resultSet.getInt(2));
            }
        } finally {
            resultSet.close();
            statement.close();
        }
        return mappaUscita;
    }

}
