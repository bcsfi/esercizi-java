package net.bcsoft;

import java.io.IOException;
import java.sql.*;
import java.lang.Class;


public class DbmSystemManage {
    String IP_ADDRESS = "", PORT, DATABASENAME;

    public DbmSystemManage(String IP_ADDRESS, String PORT, String DATABASENAME) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        this.IP_ADDRESS = IP_ADDRESS;
        this.PORT = PORT;
        this.DATABASENAME = DATABASENAME;
    }
    public Connection connectToDb() throws SQLException {
        Connection pannelli_solari = DriverManager.getConnection("jdbc:postgresql://"+ IP_ADDRESS + ":" + PORT + "/" + DATABASENAME, "postgres", "3237" );
        return pannelli_solari;

    }
    public ResultSet readDb(String ilComandoCheVogliamoCheIlDbEseguaERitorniSetDiDati) throws SQLException {
        Statement oggettoCheComunicaEMandaComandocheSqlEsegueEStampaDelDb = this.connectToDb().createStatement();
        return oggettoCheComunicaEMandaComandocheSqlEsegueEStampaDelDb.executeQuery(ilComandoCheVogliamoCheIlDbEseguaERitorniSetDiDati);

    }


}