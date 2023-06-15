package net.bcsoft.bcvinaino.entity;

import java.util.Date;

public class Ordini {
    private Long idOrdine;
    private Date dataOrdine;

    public Long getId_ordine() {
        return idOrdine;
    }

    public void setId_ordine(Long id_ordine) {
        this.idOrdine = id_ordine;
    }

    public Date getData_ordine() {
        return dataOrdine;
    }

    public void setData_ordine(Date data_ordine) {
        this.dataOrdine = data_ordine;
    }
}
