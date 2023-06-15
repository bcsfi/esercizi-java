package net.bcsoft.bcvinaino.dto;

import java.time.LocalDate;

public class OrdiniDto {
    private Long idOrdini;
    private LocalDate dataOrdine;

    public Long getIdOrdini() {
        return idOrdini;
    }

    public void setIdOrdini(Long idOrdini) {
        this.idOrdini = idOrdini;
    }

    public LocalDate getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(LocalDate dataOrdine) {
        this.dataOrdine = dataOrdine;
    }
}
