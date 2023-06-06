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

    public static List <Menu> creaMenuList(Connection connessione) throws SQLException {
        String query = "SELECT * FROM menu ";
        Statement statement = connessione.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List <Menu> listaUscita = new ArrayList<>();
        try{
            while(resultSet.next()){
                Menu menu = new Menu();
                menu.setId(resultSet.getShort(1));
                menu.setNome(resultSet.getString(2));
                menu.setIngredienti(resultSet.getString(3));
                menu.setPrezzo(resultSet.getDouble(4));
                listaUscita.add(menu);
            }
        }finally{
            resultSet.close();
            statement.close();
        }
        return listaUscita;
    }

    public static List <Ordine> creaOrdineList(Connection connessione) throws SQLException {
        String query = "SELECT * FROM ordini ";
        Statement statement = connessione.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List <Ordine> listaUscita = new ArrayList<>();
        try{
            while(resultSet.next()){
                Ordine ordine = new Ordine();
                ordine.setIdOrdine(resultSet.getShort(1));
                ordine.setDataOrdine(resultSet.getDate(2).toLocalDate());
                listaUscita.add(ordine);
            }
        }finally{
            resultSet.close();
            statement.close();
        }
        return listaUscita;
    }

    public static List <MenuOrdini> creaMenuOrdiniList(Connection connessione) throws SQLException {
        String query = "SELECT * FROM menu_ordini";
        Statement statement = connessione.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List <MenuOrdini> listaUscita = new ArrayList<>();
        try{
            while(resultSet.next()) {
                MenuOrdini menuOrdini = new MenuOrdini();
                menuOrdini.setId(resultSet.getShort(1));
                menuOrdini.setIdOrdine(resultSet.getShort(2));
                menuOrdini.setIdMenu(resultSet.getShort(3));
                menuOrdini.setQuantita(resultSet.getShort(4));
                listaUscita.add(menuOrdini);
            }
        }finally{
            resultSet.close();
            statement.close();
        }
        return listaUscita;
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
               mappaUscita.put(resultSet.getDate(1).toLocalDate(), resultSet.getDouble(2));
            }
        }finally{
            resultSet.close();
            statement.close();
        }
        return mappaUscita;
    }

}
