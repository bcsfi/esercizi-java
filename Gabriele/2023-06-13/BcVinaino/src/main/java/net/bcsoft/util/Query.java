package net.bcsoft.bcvinaino.util;

import net.bcsoft.bcvinaino.model.IncassiSettimanali;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;

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

    public static void inserisciMenu(Connection connessione, Short idMenu, Integer quantita)
            throws SQLException, RuntimeException {
        Date sqlDate = new Date(new java.util.Date().getTime());
        String query1 = "INSERT INTO ordini (data_ordine) " +
                "VALUES (?)";
        PreparedStatement preparedStatement1 = connessione.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
        preparedStatement1.setDate(1, sqlDate);
        preparedStatement1.executeUpdate();
        ResultSet resultSet1 = preparedStatement1.getGeneratedKeys();

        if (resultSet1.next()) {
            Integer idOrdine = resultSet1.getInt(1);
            String query2 = "INSERT INTO menu_ordini (id_ordini, id_menu, quantita) " +
                    "VALUES (?, ?, ?)";
            PreparedStatement preparedStatement2 = connessione.prepareStatement(query2);
            preparedStatement2.setInt(1, idOrdine);
            preparedStatement2.setShort(2, idMenu);
            preparedStatement2.setInt(3, quantita);
            preparedStatement2.executeUpdate();
            preparedStatement2.close();
        }
        resultSet1.close();
        preparedStatement1.close();
    }

    public static List<IncassiSettimanali> creaIncassiSettimanali(Connection connessione) throws SQLException {
        String query = "SELECT id_ordini, ordini.data_ordine, SUM(menu.prezzo * menu_ordini.quantita) " +
                "FROM ordini JOIN menu_ordini ON ordini.id_ordine = menu_ordini.id_ordini " +
                "JOIN menu on menu_ordini.id_menu = menu.id_menu " +
                "WHERE ordini.data_ordine > ? " +
                "GROUP BY menu_ordini.id_ordini, ordini.data_ordine " +
                "ORDER BY menu_ordini.id_ordini ASC";

        PreparedStatement statement = connessione.prepareStatement(query);
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        Date sqlDate = new Date(calendar.getTimeInMillis());
        statement.setDate(1, sqlDate);
        ResultSet resultSet = statement.executeQuery();
        List <IncassiSettimanali> incassiSettimanaliList = new ArrayList<>();
        try{
            while(resultSet.next()){
                IncassiSettimanali incassiSettimanali = new IncassiSettimanali();
                incassiSettimanali.setId_ordine(resultSet.getShort(1));
                incassiSettimanali.setGiorno_ordine(resultSet.getDate(2));
                incassiSettimanali.setImporto(resultSet.getDouble(3));
                incassiSettimanaliList.add(incassiSettimanali);
            }
        }finally {
            resultSet.close();
            statement.close();
        }
        return incassiSettimanaliList;
    }

    public static List<IncassiSettimanali> creaIncassiSettimanaliSoglia(Connection connessione) throws SQLException {
        String query = "SELECT id_ordini, ordini.data_ordine, SUM(menu.prezzo * menu_ordini.quantita) " +
                "FROM ordini JOIN menu_ordini ON ordini.id_ordine = menu_ordini.id_ordini " +
                "JOIN menu on menu_ordini.id_menu = menu.id_menu " +
                "GROUP BY menu_ordini.id_ordini, ordini.data_ordine " +
                "HAVING SUM(menu.prezzo * menu_ordini.quantita) > ? "+
                "ORDER BY menu_ordini.id_ordini ASC";

        PreparedStatement statement = connessione.prepareStatement(query);
        Integer soglia = 10;
        statement.setInt(1, soglia);
        ResultSet resultSet = statement.executeQuery();
        List <IncassiSettimanali> incassiSettimanaliSogliaList = new ArrayList<>();
        try{
            while(resultSet.next()){
                IncassiSettimanali incassiSettimanali = new IncassiSettimanali();
                incassiSettimanali.setId_ordine(resultSet.getShort(1));
                incassiSettimanali.setGiorno_ordine(resultSet.getDate(2));
                incassiSettimanali.setImporto(resultSet.getDouble(3));
                incassiSettimanaliSogliaList.add(incassiSettimanali);
            }
        }finally {
            resultSet.close();
            statement.close();
        }
        return incassiSettimanaliSogliaList;
    }

}
