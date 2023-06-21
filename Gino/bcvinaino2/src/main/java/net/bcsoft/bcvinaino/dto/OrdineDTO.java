package net.bcsoft.bcvinaino.dto;

import java.time.LocalDate;

public class OrdineDTO {
    private int idOrdine;
    private LocalDate dataOrdine;

    public OrdineDTO(int idOrdine, LocalDate dataOrdine) {
        this.idOrdine = idOrdine;
        this.dataOrdine = dataOrdine;
    }
}
