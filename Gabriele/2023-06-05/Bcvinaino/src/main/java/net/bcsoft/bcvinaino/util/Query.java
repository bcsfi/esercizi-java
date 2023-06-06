package net.bcsoft.bcvinaino.util;



import net.bcsoft.bcvinaino.model.Menu;
import net.bcsoft.bcvinaino.model.MenuOrdini;
import net.bcsoft.bcvinaino.model.Ordine;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Query {
    public static Map<LocalDate, Double> creaIncassiMensiliMap (Connection connessione) throws SQLException {
        String query = "SELECT ordini.data_ordine, SUM(menu.prezzo * menu_ordini.quantita) \n" +
                "FROM ordini JOIN menu_ordini ON ordini.id_ordine = menu_ordini.id_ordini \n" +
                "JOIN menu on menu_ordini.id_menu = menu.id_menu \n" +
                "GROUP BY ordini.data_ordine";
        Statement statement = connessione.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        Map <LocalDate, Double> mappaUscita = new HashMap<>();
        try{
            while(resultSet.next()){
               mappaUscita.put(resultSet.getDate(1).toLocalDate(), resultSet.getDouble(2));
            }
        }finally{
            resultSet.close();
            statement.close();
        }
        return mappaUscita;
    }

    public static Map<String, Integer> creaFocacceMap(Connection connessione) throws SQLException {
        String query = "SELECT menu.nome, COUNT(menu_ordini.id_ordini) \n" +
                    "FROM menu JOIN menu_ordini ON menu.id_menu = menu_ordini.id_menu \n" +
                    "GROUP BY menu.nome";
        Statement statement = connessione.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        Map <String, Integer> mappaUscita = new HashMap<>();
        try{
            while(resultSet.next()){
                mappaUscita.put(resultSet.getString(1), resultSet.getInt(2));
            }
        }finally{
            resultSet.close();
            statement.close();
        }
        return mappaUscita;
    }

}
