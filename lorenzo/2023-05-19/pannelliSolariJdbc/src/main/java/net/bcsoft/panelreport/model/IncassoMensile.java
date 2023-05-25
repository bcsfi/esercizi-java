package net.bcsoft.panelreport.model;

import java.util.ArrayList;
import java.util.List;

public class IncassoMensile {
    private List<Incasso> incassoList;
    private List<String> incassiSbagliati;
    public IncassoMensile() {
        this.incassoList = new ArrayList<>();
    }

    public IncassoMensile(List<Incasso> incassoList, List<String> incassiSbagliati) {
        this.incassoList = incassoList;
        this.incassiSbagliati = incassiSbagliati;

    }

    public List<Incasso> getIncassoList() {
        return incassoList;
    }

    public void setIncassoList(List<Incasso> incassoList) {
        this.incassoList = incassoList;
    }
}
