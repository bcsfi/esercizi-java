package net.bcsoft.bcvinaino.entity;

import java.util.Date;

public class Ordini
{
    private int idOrdine;
    private Date dataOrdine;

    public Ordini() {}

    public int getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }

    public Date getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(Date dataOrdine) {
        this.dataOrdine = dataOrdine;
    }
}
