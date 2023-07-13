package net.bcsoft.bcvinainorefactor.entity.dettaglio;

import net.bcsoft.bcvinainorefactor.entity.ArticoliOrdine;
import net.bcsoft.bcvinainorefactor.entity.Ordine;

import java.util.List;

public class OrdineCompleto extends Ordine {
    private List<ArticoliOrdine> articoliOrdineCompletoList;

    public List<ArticoliOrdine> getArticoli() {
        return articoliOrdineCompletoList;
    }

    public void setArticoli(List<ArticoliOrdine> articoliOrdineCompletoList) {
        this.articoliOrdineCompletoList = articoliOrdineCompletoList;
    }
}
