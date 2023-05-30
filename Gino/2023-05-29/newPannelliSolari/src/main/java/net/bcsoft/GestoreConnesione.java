package net.bcsoft;

import java.sql.*;

public class GestoreConnesione
{
    public static Connection creaConnessione() throws SQLException
    {
        Connection dbConn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pannelli_solari", "postgres", "Giacomo1.");
        System.out.println(dbConn != null ? "Connesso" : "Impossibile connettersi al DB!");
        return dbConn;
    }
}


