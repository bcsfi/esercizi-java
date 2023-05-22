package net.bcsoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String DRIVER = "org.postgresql.Driver";

    private static final String USERNAME = "postgres";

    private static final String PASSWORD ="3237";

    private static final String CONN_URL = "jdbc:postgresql://localhost:5432/pannelli_solari";

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
