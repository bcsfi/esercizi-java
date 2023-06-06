package org.BCVinaiano.model;

import org.BCVinaiano.jdbc.ConnectionProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProgramManager {

    Connection connesione;
    Statement statement;

    public ProgramManager() throws ClassNotFoundException {
        try {
            ConnectionProvider provider = new ConnectionProvider("localhost", "5432", "bcvinaino", "postgres", "Astrorep");
            Connection connessione = provider.getConnection();
            Statement statement = connessione.createStatement();
            this.connesione=connessione;
            this.statement=statement;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<EarningsByData> createEraningByData(String Query) throws ClassNotFoundException, SQLException {


        ResultSet catpureData = this.statement.executeQuery(Query);
        List<EarningsByData> elencoByData = new ArrayList<>();

        while (catpureData.next()){
            LocalDate data =  catpureData.getDate(1).toLocalDate();
            Double price = catpureData.getDouble(2);
            EarningsByData riga = new EarningsByData(data, price);
            elencoByData.add(riga);
        }

        catpureData.close();
        statement.close();

        return elencoByData;
    }

    public List<OrderByFoccacia> createOrderByFoccacia(String Query) throws ClassNotFoundException, SQLException {



        ResultSet catpureData = this.statement.executeQuery(Query);
        List<OrderByFoccacia> elencoByFoccacia  = new ArrayList<>();

        while (catpureData.next()){
            String focaccia =  catpureData.getString(1);
            int ordinate = catpureData.getInt(2);
            OrderByFoccacia riga = new OrderByFoccacia(focaccia, ordinate);
            elencoByFoccacia.add(riga);
        }

        catpureData.close();
        this.statement.close();

        return elencoByFoccacia;
    }

}
