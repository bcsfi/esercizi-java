package net.bcsoft.bcvinaino.util;

import net.bcsoft.bcvinaino.model.Menu;
import net.bcsoft.bcvinaino.model.MenuOrdini;
import net.bcsoft.bcvinaino.model.Ordine;

import java.util.ArrayList;
import java.util.List;

public class ReportCreator {
        private List <Menu> menuList = new ArrayList<>();
        private List <MenuOrdini> menuOrdiniList = new ArrayList<>();
        private List <Ordine> ordineList = new ArrayList<>();


        public ReportCreator(List <Menu> menuList, List <MenuOrdini> menuOrdiniList, List <Ordine> ordineList){
            this.menuList = menuList;
            this.menuOrdiniList = menuOrdiniList;
            this.ordineList = ordineList;
        }
}
