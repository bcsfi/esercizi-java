package net.bcsoft.bcvinaino.entity;

import java.time.LocalDate;
import java.util.Date;

public class Ordini
{
    private int idOrdine;
    private LocalDate dataOrdine;

    public Ordini() {}

    public int getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }

    public LocalDate getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(LocalDate dataOrdine) {
        this.dataOrdine = dataOrdine;
    }
}