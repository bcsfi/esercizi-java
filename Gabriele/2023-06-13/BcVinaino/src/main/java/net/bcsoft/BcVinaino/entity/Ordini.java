package net.bcsoft.bcvinaino.model;

import java.time.LocalDate;

public class Ordini {
    private Long id;
    private LocalDate dataOrdine;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(LocalDate dataOrdine) {
        this.dataOrdine = dataOrdine;
    }
}
