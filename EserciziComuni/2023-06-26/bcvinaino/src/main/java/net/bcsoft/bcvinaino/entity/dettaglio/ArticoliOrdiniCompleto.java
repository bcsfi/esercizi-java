package net.bcsoft.bcvinaino.entity.dettaglio;

import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import net.bcsoft.bcvinaino.entity.Menu;

public class ArticoliOrdiniCompleto {
    private Menu menu;
    private Short quantita;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Short getQuantita() {
        return quantita;
    }

    public void setQuantita(Short quantita) {
        this.quantita = quantita;
    }
}
