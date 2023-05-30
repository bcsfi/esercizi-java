package net.bcsoft;

import java.time.Month;
import java.time.Year;

public class EstrattoContoMensile
{
    private Long id_EstrattoContoMensile; // Key
    private Long id_ContoCorrente; // Foreign key
    private Year anno;
    private Month mese;
    private Double giacenzaInizioMese;

    public EstrattoContoMensile(Long id_EstrattoContoMensile, Long id_ContoCorrente, Year anno, Month mese, Double giacenzaInizioMese)
    {
        this.id_EstrattoContoMensile = id_EstrattoContoMensile;
        this.id_ContoCorrente = id_ContoCorrente;
        this.anno = anno;
        this.mese = mese;
        this.giacenzaInizioMese = giacenzaInizioMese;
    }

    public Long getId_EstrattoContoMensile()
    {
        return id_EstrattoContoMensile;
    }

    public void setId_EstrattoContoMensile(Long id_EstrattoContoMensile) {
        this.id_EstrattoContoMensile = id_EstrattoContoMensile;
    }

    public Long getId_ContoCorrente()
    {
        return id_ContoCorrente;
    }

    public void setId_ContoCorrente(Long id_ContoCorrente)
    {
        this.id_ContoCorrente = id_ContoCorrente;
    }

    public Year getAnno()
    {
        return anno;
    }

    public void setAnno(Year anno)
    {
        this.anno = anno;
    }

    public Month getMese()
    {
        return mese;
    }

    public void setMese(Month mese)
    {
        this.mese = mese;
    }

    public Double getGiacenzaInizioMese()
    {
        return giacenzaInizioMese;
    }

    public void setGiacenzaInizioMese(Double giacenzaInizioMese)
    {
        this.giacenzaInizioMese = giacenzaInizioMese;
    }
}
