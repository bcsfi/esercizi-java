package net.bcsoft;

import java.time.Month;
import java.time.Year;

public class EstrattoContoMensile
{
    Long idEstrattoContoMensile, idContoCorrente;
    Year anno;
    Month mese;
    double giacenzaInizioMese;

    public EstrattoContoMensile(Long idEstrattoContoMensile, Long idContoCorrente, Year anno, Month mese, double giacenzaInizioMese) {
        this.idEstrattoContoMensile = idEstrattoContoMensile;
        this.idContoCorrente = idContoCorrente;
        this.anno = anno;
        this.mese = mese;
        this.giacenzaInizioMese = giacenzaInizioMese;
    }

    public Long getIdEstrattoContoMensile() {
        return idEstrattoContoMensile;
    }

    public void setIdEstrattoContoMensile(Long idEstrattoContoMensile) {
        this.idEstrattoContoMensile = idEstrattoContoMensile;
    }

    public Long getIdContoCorrente() {
        return idContoCorrente;
    }

    public void setIdContoCorrente(Long idContoCorrente) {
        this.idContoCorrente = idContoCorrente;
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

    public double getGiacenzaInizioMese() {
        return giacenzaInizioMese;
    }

    public void setGiacenzaInizioMese(double giacenzaInizioMese) {
        this.giacenzaInizioMese = giacenzaInizioMese;
    }
}