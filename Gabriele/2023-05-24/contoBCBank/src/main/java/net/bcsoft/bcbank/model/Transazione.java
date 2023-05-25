package net.bcsoft.bcbank.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import net.bcsoft.bcbank.enumeration.TipoTransazioneEnum;
public class Transazione {
    private Integer idRiferimentoContoCorrente;
    private Float importo;
    private LocalDate data;
    private LocalTime ora;
    private String ibanDestinatario;
    private TipoTransazioneEnum tipoTransazione;

    public Transazione(ResultSet resultSet) throws SQLException {
        this.idRiferimentoContoCorrente = resultSet.getInt(1);
        this.importo = resultSet.getFloat(2);
        this.data = resultSet.getDate(3).toLocalDate();
        this.ora = resultSet.getTime(4).toLocalTime();
        this.ibanDestinatario = resultSet.getString(5);
        this.tipoTransazione = TipoTransazioneEnum.valueOf(resultSet.getString(6));
    }

    public Integer getIdRiferimentoContoCorrente() {
        return idRiferimentoContoCorrente;
    }

    public void setIdRiferimentoContoCorrente(Integer idRiferimentoContoCorrente) {
        this.idRiferimentoContoCorrente = idRiferimentoContoCorrente;
    }

    public Float getImporto() {
        return importo;
    }

    public void setImporto(Float importo) {
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
