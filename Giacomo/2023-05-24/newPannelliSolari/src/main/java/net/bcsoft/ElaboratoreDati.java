package net.bcsoft;

import net.bcsoft.enumeration.EProvincia;
import net.bcsoft.model.Incasso;
import net.bcsoft.model.IncassoElaborato;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ElaboratoreDati
{
    public ElaboratoreDati() {}

    public static IncassoElaborato elaboraDati(ResultSet resultSet) throws SQLException
    {
        List<Incasso> incassiCorretti = new ArrayList<>();
        String incassiErrati = "";

        while (resultSet.next())
        {
            try
            {
                Long id = resultSet.getLong(1);
                Date data = resultSet.getDate(2);
                EProvincia provincia = EProvincia.valueOf(resultSet.getString(3));
                Double importo = resultSet.getDouble(4);
                incassiCorretti.add(new Incasso(id, data, provincia, importo));
            }
            catch (IllegalArgumentException e)
            {
                 incassiErrati += resultSet.getRow() + e.getMessage() + "\n";
            }
        }
        return new IncassoElaborato(incassiCorretti, incassiErrati);
    }
}