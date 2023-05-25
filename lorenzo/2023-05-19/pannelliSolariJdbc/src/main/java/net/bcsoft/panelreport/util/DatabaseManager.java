package net.bcsoft.panelreport.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public final class DatabaseManager {
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
