package net.bcsoft.bcvinaino.entity.dettaglio;

import net.bcsoft.bcvinaino.entity.Ordine;

import java.util.ArrayList;
import java.util.List;

public class OrdineCompleto extends Ordine {
    private List<ArticoliOrdiniCompleto> articoliOrdineList = new ArrayList<>();

    public List<ArticoliOrdiniCompleto> getArticoliOrdineList() {
        return articoliOrdineList;
    }

    public void setArticoliOrdineList(List<ArticoliOrdiniCompleto> articoliOrdineList) {
        this.articoliOrdineList = articoliOrdineList;
    }
}
