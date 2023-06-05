package net.bcsoft.bcbank.model;


import java.time.LocalDate;
import java.time.LocalTime;

import net.bcsoft.bcbank.enumeration.TipoTransazioneEnum;

public class Transazione {
    private Integer idTransazione;
    private Integer idRiferimentoContoCorrente;
    private Double importo;
    private LocalDate data;
    private LocalTime ora;
    private String ibanDestinatario;
    private TipoTransazioneEnum tipoTransazione;

    public Transazione() {
    }


    public Integer getIdTransazione() {
        return idTransazione;
    }

    public void setIdTransazione(Integer idTransazione) {
        this.idTransazione = idTransazione;
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
