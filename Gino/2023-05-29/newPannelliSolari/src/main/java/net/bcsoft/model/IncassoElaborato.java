package net.bcsoft.model;

import java.util.List;

public class IncassoElaborato {

    private List<Incasso> incassiCorretti;
    private String incassiErrati;

    public IncassoElaborato(List<Incasso> incassiCorretti, String incassiErrati)
    {
        this.incassiCorretti = incassiCorretti;
        this.incassiErrati = incassiErrati;
    }

    public List<Incasso> getIncassiCorretti() {
        return incassiCorretti;
    }

    public void setIncassiCorretti(List<Incasso> incassiCorretti) {
        this.incassiCorretti = incassiCorretti;
    }

    public String getIncassiErrati() {
        return incassiErrati;
    }

    public void setIncassiErrati(String incassiErrati) {
        this.incassiErrati = incassiErrati;
    }
}