package net.bcsoft.util;

import java.sql.*;

public class GestoreConnessione
{
    public static Connection creaConnessione() throws ClassNotFoundException, SQLException
    {
        Connection dbConn = null;

        Class.forName("org.postgresql.Driver");
        dbConn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
        System.out.println(dbConn != null ? "Connesso con successo" : "Impossibile connettersi al DB!");

        return dbConn;
    }
}