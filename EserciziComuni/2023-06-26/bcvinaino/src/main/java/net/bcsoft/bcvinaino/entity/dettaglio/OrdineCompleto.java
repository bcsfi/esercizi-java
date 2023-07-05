package net.bcsoft.bcvinaino.entity.dettaglio;

import net.bcsoft.bcvinaino.entity.Ordine;
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
