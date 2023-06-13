package net.bcsoft.model;

public class MenuOrdini {
    short id;
    short idMenu;
    short idOrdine;
    int quantita;

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public short getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(short idMenu) {
        this.idMenu = idMenu;
    }

    public short getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(short idOrdine) {
        this.idOrdine = idOrdine;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }
}