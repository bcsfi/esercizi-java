package net.bcsoft.model;

import net.bcsoft.enumeration.EProvincia;

import java.sql.Date;

public class Incasso
{
    private Long id;
    private Date data;
    private EProvincia provincia;
    private Double importo;

    public Incasso(Long id, Date data, EProvincia provincia, Double importo)
    {
        this.id = id;
        this.data = data;
        this.provincia = provincia;
        this.importo = importo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public EProvincia getProvincia() {
        return provincia;
    }

    public void setProvincia(EProvincia provincia) {
        this.provincia = provincia;
    }

    public Double getImporto() {
        return importo;
    }

    public void setImporto(Double importo) {
        this.importo = importo;
    }

}