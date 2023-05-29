package net.bcsoft.bcbank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnessioneDatabase {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Gabry0308";
    private static final String CONN_URL = "jdbc:postgresql://localhost:5432/bc_bank";

    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        Connection dbConn = DriverManager.getConnection(CONN_URL, USERNAME, PASSWORD);

        if (dbConn != null) {
            System.out.println("Connessione al DB riuscita!");
        } else {
            System.out.println("Impossibile connettersi al DB!");
        }

        return dbConn;
    }

}

/*
    private Connection conn = null;

    public ConnectionProvider(String ip_address, String port, string database_name, String username, String password) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        THIS ...
     }

     public Connection getConnection() throws ... {
        if (conn == null || (conn != null && conn.isClosed()))) {
            conn =
        }
 */
