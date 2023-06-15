package net.bcsoft.bcvinaino.dto;

import java.time.LocalDate;

public class OrdiniDto {
    private Integer idOrdini;
    private LocalDate dataOrdine;

    public int getIdOrdini() {
        return idOrdini;
    }

    public void setIdOrdini(int idOrdini) {
        this.idOrdini = idOrdini;
    }

    public LocalDate getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(LocalDate dataOrdine) {
        this.dataOrdine = dataOrdine;
    }
}
