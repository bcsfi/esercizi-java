package net.bcsoft.bcvinaino.entity.dettaglio;

import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import net.bcsoft.bcvinaino.entity.Ordine;

import java.util.ArrayList;
import java.util.List;

public class OrdineCompleto extends Ordine {
    private List<ArticoliOrdine> articoliOrdineList = new ArrayList<>();


    public List<ArticoliOrdine> getArticoliOrdiniList() {
        return articoliOrdineList;
    }

    public void setArticoliOrdiniList(List<ArticoliOrdine> articoliOrdineList) {
        this.articoliOrdineList = articoliOrdineList;
    }
}
