package net.bcsoft;

import net.bcsoft.model.IncassoElaborato;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestoreReport
{
    public GestoreReport() {}

    public void produciReport(String query, String path) throws SQLException, IOException
    {
        ResultSet resultSet = LetturaScritturaDB.eseguiQuery(query);
        IncassoElaborato incassoElaborato = ElaboratoreDati.elaboraDati(resultSet);
        GestoreFile.creaFile(incassoElaborato.getIncassiCorretti(), incassoElaborato.getIncassiErrati(), path);
    }
}