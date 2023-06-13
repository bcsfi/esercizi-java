package net.bcsoft.model;

import java.time.LocalDate;

public class Ordine {
    Short idOrdine;
    LocalDate dataOrdine;

    public Short getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(Short idOrdine) {
        this.idOrdine = idOrdine;
    }

    public LocalDate getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(LocalDate dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

}