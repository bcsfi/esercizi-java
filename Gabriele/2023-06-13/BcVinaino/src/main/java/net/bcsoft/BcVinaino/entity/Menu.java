package net.bcsoft.bcvinaino.model;

public class Menu {
    private Long id;
    private String focaccia;
    private Double prezzo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFocaccia() {
        return focaccia;
    }

    public void setFocaccia(String focaccia) {
        this.focaccia = focaccia;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }
}
