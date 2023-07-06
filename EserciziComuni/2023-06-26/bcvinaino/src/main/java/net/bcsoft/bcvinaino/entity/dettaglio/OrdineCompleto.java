package net.bcsoft.bcvinaino.entity.dettaglio;

import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import net.bcsoft.bcvinaino.entity.Ordine;

import java.util.ArrayList;
import java.util.List;

public class OrdineCompleto extends Ordine {
    private List<ArticoliOrdiniCompleto> articoliOrdineList;

    public OrdineCompleto() {
        this.articoliOrdineList =  new ArrayList<>();
    }

    public List<ArticoliOrdiniCompleto> getArticoliOrdiniList() {
        return articoliOrdineList;
    }

    public void setArticoliOrdiniList(List<ArticoliOrdiniCompleto> articoliOrdineList) {
        this.articoliOrdineList = articoliOrdineList;
    }
}
