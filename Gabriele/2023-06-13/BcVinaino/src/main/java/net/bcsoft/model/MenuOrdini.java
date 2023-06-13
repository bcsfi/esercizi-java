package net.bcsoft.model;

public class MenuOrdini {
    Short id;
    Short idMenu;
    Short idOrdine;
    Integer quantita;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Short getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Short idMenu) {
        this.idMenu = idMenu;
    }

    public Short getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(Short idOrdine) {
        this.idOrdine = idOrdine;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }
}
