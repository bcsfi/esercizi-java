package net.bcsoft;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Incasso
{
    private LocalDate data = null;
    private ProvinciaEnum provincia = null;
    private Double importo = null;

    public Incasso() {}; //Per renderlo Java Been

    public Incasso(String riga) throws DateTimeParseException, NumberFormatException
    {
        String[] parts = riga.split(";");

        data = LocalDate.parse(parts[0]);
        provincia = ProvinciaEnum.valueOf(parts[1].toUpperCase());
        importo = Double.parseDouble(parts[2]);
    }

    public LocalDate getData()
    {
        return data;
    }

    public void setData(LocalDate data)
    {
        this.data = data;
    }

    public ProvinciaEnum getProvincia()
    {
        return provincia;
    }

    public void setProvincia(ProvinciaEnum provincia)
    {
        this.provincia = provincia;
    }

    public Double getImporto()
    {
        return importo;
    }

    public void setImporto(Double importo)
    {
        this.importo = importo;
    }
}