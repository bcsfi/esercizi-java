package net.bcsoft.JDBCystemManage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SendQueryToDriver {

    ConnectToDriver connessione;

    public SendQueryToDriver(ConnectToDriver connessione){
        this.connessione = connessione;
    }

    public ResultSet sendCommand(String ilComandoCheVogliamoCheIlDbEseguaERitorniSetDiDati) throws SQLException {

        Statement oggettoCheComunicaEMandaComandocheSqlEsegueEStampaDelDb = connessione.activeConnection().createStatement();
        return oggettoCheComunicaEMandaComandocheSqlEsegueEStampaDelDb.executeQuery(ilComandoCheVogliamoCheIlDbEseguaERitorniSetDiDati);
    }
}
