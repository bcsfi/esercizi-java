package net.bcsoft.BcVinaino.entity;


import net.bcsoft.BcVinaino.entity.dettaglio.ArticoliOrdineCompleto;

import java.util.Date;
import java.util.List;

public class Ordine {
    private Integer idOrdine;
    private Date dataOrdine;

    public Integer getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(Integer idOrdine) {
        this.idOrdine = idOrdine;
    }

    public Date getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(Date dataOrdine) {
        this.dataOrdine = dataOrdine;
    }


}