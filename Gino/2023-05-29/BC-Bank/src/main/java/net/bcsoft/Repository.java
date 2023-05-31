package net.bcsoft;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Repository
{
    public static List<ContoCorrente> eseguiQueryContiCorrente(Connection connection) throws SQLException
    {
        List<ContoCorrente> contiCorrente = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM contocorrente");

        while (resultSet.next())
        {
            contiCorrente.add(new ContoCorrente(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)));
        }

        resultSet.close();
        statement.close();

        return contiCorrente;
    }

    public static List<EstrattoContoMensile> eseguiQueryEstrattoContoMensile(Connection connection) throws SQLException
    {
        List<EstrattoContoMensile> estrattiContoMensili = new ArrayList<>();

        Statement stm = connection.createStatement();
        ResultSet resultSet = stm.executeQuery("SELECT * FROM estrattocontomensile WHERE mese = EXTRACT(MONTH FROM CURRENT_DATE)");

        while (resultSet.next())
        {
            try
            {
                estrattiContoMensili.add(new EstrattoContoMensile(resultSet.getLong(1), resultSet.getLong(2), Year.of(resultSet.getInt(3)), Month.of(resultSet.getInt(4)), resultSet.getDouble(5)));
            }
            catch (DateTimeException e)
            {
                e.printStackTrace();
            }
        }

        resultSet.close();
        stm.close();

        return estrattiContoMensili;
    }

    public static List<Transazione> eseguiQueryTransazioni(Connection connection) throws SQLException
    {
        Statement stm = connection.createStatement();
        ResultSet resultSet = stm.executeQuery("SELECT * FROM transazione");

        List<Transazione> transazioni = new ArrayList<>();

        while (resultSet.next())
        {
            LocalDateTime dataOraTransazione = resultSet.getTimestamp(4).toLocalDateTime();
            MezzoPagamentoEnum mezzoPagamentoEnum = MezzoPagamentoEnum.dbValueOf(resultSet.getString(6));
            transazioni.add(new Transazione(resultSet.getLong(1), resultSet.getLong(2), resultSet.getDouble(3), dataOraTransazione, resultSet.getString(5), mezzoPagamentoEnum));
        }

        resultSet.close();
        stm.close();

        return transazioni;
    }
}
