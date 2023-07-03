package net.bcsoft.bcvinaino.entity.dettaglio;

import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import net.bcsoft.bcvinaino.entity.Menu;

public class ArticoliOrdineCompleto extends ArticoliOrdine {
    private Menu menu;


    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

}
