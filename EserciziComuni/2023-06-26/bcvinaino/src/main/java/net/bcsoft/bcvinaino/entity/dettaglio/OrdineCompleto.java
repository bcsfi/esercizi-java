package net.bcsoft.bcvinaino.entity.dettaglio;

import net.bcsoft.bcvinaino.entity.ArticoliOrdini;
import net.bcsoft.bcvinaino.entity.Ordini;

import java.util.ArrayList;
import java.util.List;

public class OrdineCompleto extends Ordini {
    private List<ArticoliOrdini> articoliOrdiniList = new ArrayList<>();


    public List<ArticoliOrdini> getArticoliOrdiniList() {
        return articoliOrdiniList;
    }

    public void setArticoliOrdiniList(List<ArticoliOrdini> articoliOrdiniList) {
        this.articoliOrdiniList = articoliOrdiniList;
    }
}
