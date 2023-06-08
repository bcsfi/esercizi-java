package net.bcsoft.bcvinaino.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private String ipAddress;
    private String databaseName;
    private String username;
    private String password;
    private Integer port;
    private Connection connection = null;

    public DatabaseManager(String ipAddress, Integer port, String databaseName, String username, String password)
            throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        this.ipAddress = ipAddress;
        this.port = port;
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;
    }

    public DatabaseManager() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        this.ipAddress = "localhost";
        this.port = 5432;
        this.databaseName = "bc_vinaio";
        this.username = "postgres";
        this.password = "Gabry0308";
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || (connection != null && connection.isClosed())) {
            connection = DriverManager.getConnection("jdbc:postgresql://"
                            + ipAddress + ":" + port + "/" + databaseName,
                    username, password);
        }
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
        connection = null;
    }
}

