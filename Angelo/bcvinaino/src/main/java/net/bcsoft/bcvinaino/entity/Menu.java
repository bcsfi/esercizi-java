package net.bcsoft.bcvinaino.entity;

public class Menu {
    private Long idMenu;
    private String focaccia;
    private Double prezzo;

    public Long getId_menu() {
        return idMenu;
    }

    public void setId_menu(Long id_menu) {
        this.idMenu = id_menu;
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

