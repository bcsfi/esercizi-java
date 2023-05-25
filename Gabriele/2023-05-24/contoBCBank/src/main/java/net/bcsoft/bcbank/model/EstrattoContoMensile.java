package net.bcsoft.bcbank.model;

import net.bcsoft.bcbank.enumeration.MeseEnum;
import net.bcsoft.bcbank.util.ConnessioneDatabase;
import net.bcsoft.bcbank.util.DatabaseManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Month;
import java.time.Year;

public class EstrattoContoMensile {
    private Integer idRiferimentoContoCorrente;
    private Year anno;
    private MeseEnum mese;
    private Double giacenzaInizioMese;

    public EstrattoContoMensile() throws SQLException, ClassNotFoundException {
        Connection connection = ConnessioneDatabase.createConnection();
        DatabaseManager databaseManager = new DatabaseManager(connection);
        ResultSet resultSet = databaseManager.ottieniResultSet("SELECT * FROM estratto_conto_corrente");
        try{
            this.idRiferimentoContoCorrente = resultSet.getInt(1);
            this.anno = Year.of(resultSet.getInt(2));
            this.mese = MeseEnum.valueOf(resultSet.getString(3));
            this.giacenzaInizioMese = resultSet.getDouble(4);
        }finally{
            resultSet.close();
            connection.close();
        }

    }

    public Integer getIdRiferimentoContoCorrente() {
        return idRiferimentoContoCorrente;
    }

    public void setIdRiferimentoContoCorrente(Integer idRiferimentoContoCorrente) {
        this.idRiferimentoContoCorrente = idRiferimentoContoCorrente;
    }

    public Year getAnno() {
        return anno;
    }

    public void setAnno(Year anno) {
        this.anno = anno;
    }

    public MeseEnum getMese() {
        return mese;
    }

    public void setMese(MeseEnum mese) {
        this.mese = mese;
    }

    public Double getGiacenzaInizioMese() {
        return giacenzaInizioMese;
    }

    public void setGiacenzaInizioMese(Double giacenzaInizioMese) {
        this.giacenzaInizioMese = giacenzaInizioMese;
    }
}
