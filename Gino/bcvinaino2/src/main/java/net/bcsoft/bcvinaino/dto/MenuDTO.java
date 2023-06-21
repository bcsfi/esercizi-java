package net.bcsoft.bcvinaino.dto;

public class MenuDTO {
    private Long idMenu;
    private String focaccia;
    private double prezzo;

    public MenuDTO(Long idMenu, String focaccia, double prezzo) {
        this.idMenu = idMenu;
        this.focaccia = focaccia;
        this.prezzo = prezzo;
    }
}
