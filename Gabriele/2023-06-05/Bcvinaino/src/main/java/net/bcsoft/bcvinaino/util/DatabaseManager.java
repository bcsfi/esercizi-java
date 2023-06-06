package net.bcsoft.bcvinaino.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private String ipAddress, databaseName, username, password;
    private Integer port;
    private Connection connection = null;

    public DatabaseManager(String ipAddress, Integer port, String databaseName, String username, String password) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        this.ipAddress = ipAddress;
        this.port = port;
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;
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

