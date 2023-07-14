package net.bcsoft.bcvinaino.dto;

import java.util.List;

public class ArticoliOrdineCompletoDTO {
    private Long id;
    private List<ArticoloOrdineDTO> menu;
    private Integer quantita;

    public Long getId() {
        return id;
    }

    public List<ArticoloOrdineDTO> getMenu() {
        return menu;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMenu(List<ArticoloOrdineDTO> menu) {
        this.menu = menu;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }
}
