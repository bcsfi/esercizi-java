package net.bcsoft;

import java.time.Month;
import java.time.Year;

public class EstrattoContoMensile
{
    private Long id; // Key
    private Long idContoCorrente; // Foreign key
    private Year anno;
    private Month mese;
    private Double giacenzaInizioMese;

    public EstrattoContoMensile(Long id, Long idContoCorrente, Year anno, Month mese, Double giacenzaInizioMese)
    {
        this.id = id;
        this.idContoCorrente = idContoCorrente;
        this.anno = anno;
        this.mese = mese;
        this.giacenzaInizioMese = giacenzaInizioMese;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdContoCorrente()
    {
        return idContoCorrente;
    }

    public void setIdContoCorrente(Long idContoCorrente)
    {
        this.idContoCorrente = idContoCorrente;
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
