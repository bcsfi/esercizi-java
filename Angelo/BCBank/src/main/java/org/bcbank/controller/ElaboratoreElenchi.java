package org.bcbank.controller;
import org.bcbank.jdbc.ConnectionProvider;
import org.bcbank.model.Conto;
import org.bcbank.model.Estratto;
import org.bcbank.model.Transazione;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ElaboratoreElenchi {
    private ConnectionProvider driver;

    public ElaboratoreElenchi(ConnectionProvider driver) throws SQLException, ClassNotFoundException {
        this.driver=driver;
    }

    public List<Transazione> creaElencoTransazioni(String executeQuery) throws SQLException, ClassNotFoundException {
        Connection connection = driver.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultQuery = statement.executeQuery(executeQuery);

        List<Transazione> elencoTransazioni = new ArrayList<Transazione>();
        while(resultQuery.next())
        {
            Timestamp timestamp = resultQuery.getTimestamp(4);
            LocalDate localDate = timestamp.toLocalDateTime().toLocalDate();
            Transazione transazione = new Transazione(resultQuery.getInt(1), resultQuery.getDouble(2), resultQuery.getString(3),
                    localDate, resultQuery.getString(5), resultQuery.getInt(6));
            elencoTransazioni.add(transazione);
        }

        statement.close();
        resultQuery.close();
        return elencoTransazioni;
    }

    public List<Estratto> creaElenecoEstratti(String executeQuery) throws SQLException, ClassNotFoundException {
        Connection connection = driver.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultQuery = statement.executeQuery(executeQuery);

        List<Estratto> elencoEstratti = new ArrayList<>();
        while(resultQuery.next())
        {
            Estratto estratto = new Estratto(resultQuery.getInt(1), resultQuery.getInt(2), resultQuery.getInt(3),
                    resultQuery.getDouble(4), resultQuery.getInt(5));
            elencoEstratti.add(estratto);
        }
        statement.close();
        resultQuery.close();
        return elencoEstratti;
    }

    public List<Conto> creaElencoConti(String executeQuery) throws SQLException, ClassNotFoundException {

        Connection connection = driver.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultQuery = statement.executeQuery(executeQuery);

        List<Conto> elencoConti = new ArrayList<>();
        while (resultQuery.next())
        {
            Conto conto = new Conto(resultQuery.getInt(1), resultQuery.getString(2), resultQuery.getString(3),
                    resultQuery.getString(4), resultQuery.getBigDecimal(5));
            elencoConti.add(conto);
        }

        statement.close();
        resultQuery.close();
        return elencoConti;
    }


}
