package net.bcsoft.bcvinaino.entity.dettaglio;

import net.bcsoft.bcvinaino.entity.Ordine;

import java.util.ArrayList;
import java.util.List;

public class OrdineCompleto extends Ordine {
    private List<ArticoliOrdineCompleto> articoliOrdineList = new ArrayList<>();


    public List<ArticoliOrdineCompleto> getArticoliOrdiniList() {
        return articoliOrdineList;
    }

    public void setArticoliOrdiniList(List<ArticoliOrdineCompleto> articoliOrdineList) {
        this.articoliOrdineList = articoliOrdineList;
    }
}
