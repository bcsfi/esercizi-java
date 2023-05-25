package net.bcsoft.bcbank.model;

import net.bcsoft.bcbank.enumeration.MeseEnum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Month;
import java.time.Year;

public class EstrattoContoMensile {
    private Integer idRiferimentoContoCorrente;
    private Year anno;
    private MeseEnum mese;
    private Integer giacenzaInizioMese;

    public EstrattoContoMensile(ResultSet resultSet) throws SQLException {
        this.idRiferimentoContoCorrente = resultSet.getInt(1);
        this.anno = Year.of(resultSet.getInt(2));
        this.mese = MeseEnum.valueOf(resultSet.getString(3));
        this.giacenzaInizioMese = resultSet.getInt(4);
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

    public Integer getGiacenzaInizioMese() {
        return giacenzaInizioMese;
    }

    public void setGiacenzaInizioMese(Integer giacenzaInizioMese) {
        this.giacenzaInizioMese = giacenzaInizioMese;
    }
}
