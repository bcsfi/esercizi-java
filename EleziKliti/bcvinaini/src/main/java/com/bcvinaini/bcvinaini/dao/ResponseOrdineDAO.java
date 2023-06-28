package com.bcvinaini.bcvinaini.dao;

import java.util.Date;

public class ResponseOrdineDAO {

    private Date data_ordine;
    private String menu_ordinati;
    private String focaccia;
    private double costo_ordine;
    private int qta;

    public Date getData_ordine() {
        return data_ordine;
    }

    public void setData_ordine(Date data_ordine) {
        this.data_ordine = data_ordine;
    }

    public String getMenu_ordinati() {
        return menu_ordinati;
    }

    public void setMenu_ordinati(String menu_ordinati) {
        this.menu_ordinati = menu_ordinati;
    }

    public String getFocaccia() {
        return focaccia;
    }

    public void setFocaccia(String focaccia) {
        this.focaccia = focaccia;
    }

    public double getCosto_ordine() {
        return costo_ordine;
    }

    public void setCosto_ordine(double costo_ordine) {
        this.costo_ordine = costo_ordine;
    }

    public int getQta() {
        return qta;
    }

    public void setQta(int qta) {
        this.qta = qta;
    }
}
