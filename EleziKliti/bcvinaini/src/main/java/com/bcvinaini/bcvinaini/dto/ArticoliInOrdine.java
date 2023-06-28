package com.bcvinaini.bcvinaini.dto;

import com.bcvinaini.bcvinaini.entity.Menu;

public class ArticoliInOrdine {

    private int idArticolo;
    private int idOrdine;
    private Menu menu;
    private int qta;

    public int getIdArticolo() {
        return idArticolo;
    }

    public void setIdArticolo(int idArticolo) {
        this.idArticolo = idArticolo;
    }

    public int getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getQta() {
        return qta;
    }

    public void setQta(int qta) {
        this.qta = qta;
    }

}
