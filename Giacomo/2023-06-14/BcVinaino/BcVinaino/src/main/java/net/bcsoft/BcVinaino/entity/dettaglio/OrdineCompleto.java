package net.bcsoft.BcVinaino.entity.dettaglio;

import net.bcsoft.BcVinaino.entity.Ordine;

import java.util.ArrayList;
import java.util.List;

public class OrdineCompleto extends Ordine {
    private List<ArticoliOrdineCompleto> articoliOrdineCompletoList = new ArrayList<>();

    public List<ArticoliOrdineCompleto> getArticoliOrdineCompletoList() {
        return articoliOrdineCompletoList;
    }

    public void setArticoliOrdineCompletoList(List<ArticoliOrdineCompleto> articoliOrdineCompletoList) {
        this.articoliOrdineCompletoList = articoliOrdineCompletoList;
    }
}