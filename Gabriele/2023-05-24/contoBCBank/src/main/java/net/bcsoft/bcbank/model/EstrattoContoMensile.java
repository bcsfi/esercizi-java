package net.bcsoft.bcbank.model;

import java.time.Month;
import java.time.Year;

public class EstrattoContoMensile {
    private Integer idEstrattoConto;
    private Integer idRiferimentoContoCorrente;
    private Year anno;
    private Month mese;
    private Double giacenzaInizioMese;

    public EstrattoContoMensile() {

    }

    public void setIdEstrattoConto(Integer idEstrattoConto) {
        this.idEstrattoConto = idEstrattoConto;
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

    public Month getMese() {
        return mese;
    }

    public void setMese(Month mese) {
        this.mese = mese;
    }

    public Double getGiacenzaInizioMese() {
        return giacenzaInizioMese;
    }

    public void setGiacenzaInizioMese(Double giacenzaInizioMese) {
        this.giacenzaInizioMese = giacenzaInizioMese;
    }
}
