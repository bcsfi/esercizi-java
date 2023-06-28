package com.bcvinaini.bcvinaini.dto;

import com.bcvinaini.bcvinaini.entity.ArticoliOrdine;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public class RquestOrdine {

    private int id;
    private Date data;

    List<ArticoliInOrdine> listaArticoli;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ArticoliInOrdine> getListaArticoli() {
        return listaArticoli;
    }

    public void setListaArticoli(List<ArticoliInOrdine> listaArticoli) {
        this.listaArticoli = listaArticoli;
    }
}
