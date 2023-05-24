package net.bcsoft.bcbank.model;

import java.sql.ResultSet;
import java.time.Month;
import java.time.Year;

public class EstrattoContoMensile {
    private Integer idRiferimentoContoCorrente;
    private Year anno;
    private Month mese;
    private Integer giacenzaInizioMese;

    public EstrattoContoMensile(ResultSet resultSet){
        this.idRiferimentoContoCorrente = resultSet.getInt();
        this.anno = anno.toString(resultSet.getString());
        this.mese = mese.toString(resultSet.getString());
        this.giacenzaInizioMese = resultSet.getInt();
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

    public Integer getGiacenzaInizioMese() {
        return giacenzaInizioMese;
    }

    public void setGiacenzaInizioMese(Integer giacenzaInizioMese) {
        this.giacenzaInizioMese = giacenzaInizioMese;
    }
}
