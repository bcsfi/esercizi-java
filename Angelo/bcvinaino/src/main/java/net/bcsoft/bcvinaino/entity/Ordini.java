package net.bcsoft.bcvinaino.entity;

import java.time.LocalDate;

public class Ordini {
    Long idOrdine;
    LocalDate dataOrdine;
    Double incassoOrdine;

    public Long getIdOrdine() {
        return idOrdine;
    }

    public LocalDate getDataOrdine() {
        return dataOrdine;
    }

    public Double getIncassoOrdine() {
        return incassoOrdine;
    }
}