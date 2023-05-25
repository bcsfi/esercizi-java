package net.bcsoft.bcbank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestioneDatabase {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "admin";
    private static final String CONN_URL = "postgres://localhost:5432/pannelli_solari"; //da cambiare nome del database

    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        Connection dbConn = DriverManager.getConnection(CONN_URL, USERNAME, PASSWORD);

        if (dbConn != null) {
            System.out.println("Connection Successful");
        } else {
            System.out.println("Impossibile connettersi al DB!");
        }

        return dbConn;
    }
}
