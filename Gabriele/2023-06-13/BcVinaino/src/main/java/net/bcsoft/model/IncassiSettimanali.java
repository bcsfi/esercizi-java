package net.bcsoft.bcvinaino.model;

import java.util.Date;

public class IncassiSettimanali {
    private Short id_ordine;
    private Date giorno_ordine;
    private Double importo;

    public Short getId_ordine() {
        return id_ordine;
    }

    public void setId_ordine(Short id_ordine) {
        this.id_ordine = id_ordine;
    }

    public Date getGiorno_ordine() {
        return giorno_ordine;
    }

    public void setGiorno_ordine(Date giorno_ordine) {
        this.giorno_ordine = giorno_ordine;
    }

    public Double getImporto() {
        return importo;
    }

    public void setImporto(Double importo) {
        this.importo = importo;
    }
}
