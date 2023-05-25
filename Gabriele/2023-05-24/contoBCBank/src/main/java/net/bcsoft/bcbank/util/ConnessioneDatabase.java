package net.bcsoft.bcbank.util;

import java.sql.*;

public class ConnessioneDatabase {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Gabry0308";
    private static final String CONN_URL = "jdbc:postgresql://localhost:5432/bc_bank";

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
