package net.bcsoft.bcvinaino.dto;

public class MenuDto {
    private Long idMenu;
    private String focaccia;
    private double prezzo;

    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    public String getFocaccia() {
        return focaccia;
    }

    public void setFocaccia(String focaccia) {
        this.focaccia = focaccia;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}
