package net.bcsoft.panelreport.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "admin";
    private static final String CONN_URL = "jdbc:postgresql://localhost:5432/pannelli_solari";

    private DatabaseConnection() {}
    public static Connection createConnection() throws SQLException {
        Connection dbConn = DriverManager.getConnection(CONN_URL, USERNAME, PASSWORD);

        if (dbConn != null) {
            System.out.println("Connection Successful");
        } else {
            System.out.println("Impossibile connettersi al DB!");
        }

        return dbConn;
    }
}
