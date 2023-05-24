package net.bcsoft;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LetturaScritturaDB
{
    public LetturaScritturaDB( ) {}

    public static ResultSet eseguiQuery(String query) throws SQLException
    {
        return GestoreConnesione.creaConnessione().createStatement().executeQuery(query);
    }
}