package net.bcsoft;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Incasso
{
    private LocalDate data = null;
    private ProvinciaEnum provincia = null;
    private Double importo = null;

    public Incasso() {};

    public Incasso(LocalDate date, ProvinciaEnum provincia, Double importo) throws DateTimeParseException
    {
        this.data = date;
        this.provincia = provincia;
        this.importo = importo;
    }

    public LocalDate getData()
    {
        return data;
    }

    /*public void setData(LocalDate data)
    {
        this.data = data;
    }*/

    public ProvinciaEnum getProvincia()
    {
        return provincia;
    }

    /*public void setProvincia(ProvinciaEnum provincia)
    {
        this.provincia = provincia;
    }*/

    public Double getImporto()
    {
        return importo;
    }

    public void setImporto(Double importo)
    {
        this.importo = importo;
    }
}