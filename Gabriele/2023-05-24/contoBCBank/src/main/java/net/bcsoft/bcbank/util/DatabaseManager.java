package net.bcsoft.bcbank.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private static Connection connessione;

    public DatabaseManager(Connection connessione) {
        this.connessione = connessione;
    }

    public ResultSet ottieniResultSet(String query) throws SQLException {
        Statement statement = null;
        statement = connessione.createStatement();
        return statement.executeQuery(query);
    }

}
