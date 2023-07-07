package net.bcsoft.bcvinaino.entity.dettaglio;

import net.bcsoft.bcvinaino.entity.Ordine;

import java.util.ArrayList;
import java.util.List;

public class OrdineCompleto extends Ordine {
    private List<ArticoliOrdiniCompleto> articoliOrdineCompletoList = new ArrayList<>();

    public List<ArticoliOrdiniCompleto> getArticoliOrdineCompletoList() {
        return articoliOrdineCompletoList;
    }


    public void setArticoliOrdineCompletoList(List<ArticoliOrdiniCompleto> articoliOrdineCompletoList) {
        this.articoliOrdineCompletoList = articoliOrdineCompletoList;
    }
}
