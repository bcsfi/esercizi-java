package model;

import java.util.Date;

public class Ordine
{
    private int idOrdine;
    private Date data;
    private double importoTotale;

    public Ordine(int idOrdine, Date data, double importoTotale)
    {
        this.idOrdine = idOrdine;
        this.data = data;
        this.importoTotale = importoTotale;
    }

    public int getIdOrdine()
    {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine)
    {
        this.idOrdine = idOrdine;
    }

    public Date getData()
    {
        return data;
    }

    public void setData(Date data)
    {
        this.data = data;
    }

    public double getImportoTotale()
    {
        return importoTotale;
    }

    public void setImportoTotale(double importoTotale)
    {
        this.importoTotale = importoTotale;
    }
}
