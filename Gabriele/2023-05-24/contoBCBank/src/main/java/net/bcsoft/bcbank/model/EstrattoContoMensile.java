package net.bcsoft.bcbank.model;

import net.bcsoft.bcbank.enumeration.MeseEnum;
import net.bcsoft.bcbank.util.ConnessioneDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class EstrattoContoMensile {
    private Integer idEstrattoConto;
    private Integer idRiferimentoContoCorrente;
    private Year anno;
    private MeseEnum mese;
    private Double giacenzaInizioMese;

    public EstrattoContoMensile()  {

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
