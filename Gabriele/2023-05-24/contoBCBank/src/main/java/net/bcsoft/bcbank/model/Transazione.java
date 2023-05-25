package net.bcsoft.bcbank.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import net.bcsoft.bcbank.enumeration.TipoTransazioneEnum;
import net.bcsoft.bcbank.util.ConnessioneDatabase;
import net.bcsoft.bcbank.util.DatabaseManager;

public class Transazione {
    private Integer idTransazione;
    private Integer idRiferimentoContoCorrente;
    private Double importo;
    private LocalDate data;
    private LocalTime ora;
    private String ibanDestinatario;
    private TipoTransazioneEnum tipoTransazione;
    private List <Transazione> transazioneList = new ArrayList<>();

    public Transazione() throws SQLException, ClassNotFoundException {
        Connection connection = ConnessioneDatabase.createConnection();
        DatabaseManager databaseManager = new DatabaseManager(connection);
        ResultSet resultSet = databaseManager.ottieniResultSet("SELECT * FROM transazioni");
        try{ //TODO SISTEMARE QUI PER FARGLI ENTRARE COSE NELLA LISTA
            this.idTransazione = resultSet.getInt(1);
            this.idRiferimentoContoCorrente = resultSet.getInt(2);
            this.importo = resultSet.getDouble(3);
            this.data = resultSet.getDate(4).toLocalDate();
            this.ora = resultSet.getTime(5).toLocalTime();
            this.ibanDestinatario = resultSet.getString(6);
            this.tipoTransazione = TipoTransazioneEnum.valueOf(resultSet.getString(7));
        }finally {
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

    public Double getImporto() {
        return importo;
    }

    public void setImporto(Double importo) {
        this.importo = importo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public String getIbanDestinatario() {
        return ibanDestinatario;
    }

    public void setIbanDestinatario(String ibanDestinatario) {
        this.ibanDestinatario = ibanDestinatario;
    }

    public TipoTransazioneEnum getTipoTransazione() {
        return tipoTransazione;
    }

    public void setTipoTransazione(TipoTransazioneEnum tipoTransazione) {
        this.tipoTransazione = tipoTransazione;
    }

}
