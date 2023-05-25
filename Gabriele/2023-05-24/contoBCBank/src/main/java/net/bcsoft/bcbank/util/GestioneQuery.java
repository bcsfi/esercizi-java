package net.bcsoft.bcbank.util;

import net.bcsoft.bcbank.model.Transazione;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GestioneQuery {
    private Connection connessione;

    public GestioneQuery(Connection connessione){
        this.connessione = connessione;
    }

    public Map <String, Integer> contaTransazioni() throws SQLException {
        Map <String, Integer> transazioniMap = new HashMap<>();

        String query = "SELECT COUNT(iban), iban FROM conto_corrente INNER JOIN transazioni " +
                "ON conto_corrente.conto_corrente_id = transazioni.conto_corrente_id " +
                "GROUP BY iban";
        DatabaseManager databaseManager = new DatabaseManager(connessione);
        ResultSet resultSet = databaseManager.ottieniResultSet(query);
        while(resultSet.next()) {
            transazioniMap.put(resultSet.getString(2), resultSet.getInt(1));
        }
        return transazioniMap;
    }

    public Connection getConnessione() {
        return connessione;
    }
}
