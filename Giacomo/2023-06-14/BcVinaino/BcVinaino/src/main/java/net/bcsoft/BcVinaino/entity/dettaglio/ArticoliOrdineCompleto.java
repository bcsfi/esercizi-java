package net.bcsoft.BcVinaino.entity.dettaglio;


import net.bcsoft.BcVinaino.entity.ArticoliOrdine;
import net.bcsoft.BcVinaino.entity.Menu;

public class ArticoliOrdineCompleto extends ArticoliOrdine {
    private Menu menu;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}