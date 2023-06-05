package net.bcsoft.bcvinaino.util;

;


import net.bcsoft.bcvinaino.model.Menu;
import net.bcsoft.bcvinaino.model.MenuOrdini;
import net.bcsoft.bcvinaino.model.Ordine;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

//TODO questa classe processerà le query per prendere dati dal database
public class Query {

    public static void creaMenu(Connection connessione) throws SQLException {
        String query = "SELECT * FROM menu ";
        Statement statement = connessione.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        try{
            while(resultSet.next()){
                Menu menu = new Menu();
                menu.setId(resultSet.getShort(1));
                menu.setNome(resultSet.getString(2));
                menu.setIngredienti(resultSet.getString(3));
                menu.setPrezzo(resultSet.getDouble(4));
            }
        }finally{
            resultSet.close();
            statement.close();
        }
    }

    public static void creaOrdine(Connection connessione) throws SQLException {
        String query = "SELECT * FROM ordini ";
        Statement statement = connessione.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        try{
            while(resultSet.next()){
                Ordine ordine = new Ordine();
                ordine.setIdOrdine(resultSet.getShort(1));
                ordine.setDataOrdine(resultSet.getDate(2).toLocalDate());
            }
        }finally{
            resultSet.close();
            statement.close();
        }
    }

    public static void creaMenuOrdini(Connection connessione) throws SQLException {
        String query = "SELECT * FROM menu_ordini";
        Statement statement = connessione.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        try{
            while(resultSet.next()) {
                MenuOrdini menuOrdini = new MenuOrdini();
                menuOrdini.setId(resultSet.getShort(1));
                menuOrdini.setIdOrdine(resultSet.getShort(2));
                menuOrdini.setIdMenu(resultSet.getShort(3));
                menuOrdini.setQuantita(resultSet.getShort(4));

            }
        }finally{
            resultSet.close();
            statement.close();
        }
    }




    public static Map<LocalDate, Double> creaIncassiMensiliMap (Connection connessione) throws SQLException {
        String query = "SELECT ordini.data_ordine, SUM(menu.prezzo * menu_ordini.quantita)" +
                "FROM ordine JOIN menu_ordini ON ordini.id = menu_ordini.id_ordini" +
                "JOIN menu on menu_ordini.id_menu = menu.id " +
                "GROUP BY ordini.data";
        Statement statement = connessione.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        Map <LocalDate, Double> mappaUscita = new HashMap<>();
        try{
            while(resultSet.next()){

            }
        }finally{
            resultSet.close();
            statement.close();
        }
        return mappaUscita;
    }

}
