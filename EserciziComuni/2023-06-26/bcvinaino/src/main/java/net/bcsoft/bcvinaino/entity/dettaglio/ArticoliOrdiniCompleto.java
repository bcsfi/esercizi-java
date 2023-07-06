package net.bcsoft.bcvinaino.entity.dettaglio;

import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import net.bcsoft.bcvinaino.entity.Menu;

public class ArticoliOrdiniCompleto {

    private Long IdMenu;
    private Integer quantita;

    public Long getMenu() {
        return IdMenu;
    }

    public void setIdMenu(Long idMenu) {
        IdMenu = idMenu;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

}
