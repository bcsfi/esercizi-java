package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.dao.ArticoliOrdiniDAO;
import net.bcsoft.bcvinaino.dao.MenuDAO;
import net.bcsoft.bcvinaino.dao.OrdiniDAO;
import net.bcsoft.bcvinaino.entity.ArticoliOrdini;
import net.bcsoft.bcvinaino.entity.Menu;
import net.bcsoft.bcvinaino.entity.Ordini;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class ReportService {
    @Autowired
    MenuDAO menuDAO;

    @Autowired
    ArticoliOrdiniDAO articoliOrdiniDAO;

    @Autowired
    OrdiniDAO ordiniDAO;

    public String calcolaIncassi(){
        StringBuilder report = new StringBuilder();
        List <ArticoliOrdini> articoliOrdiniList= articoliOrdiniDAO.selectAll();
        List <Menu> menuList = menuDAO.selectAll();
        List<Ordini> ordiniList = ordiniDAO.selectAll();
        Map<Date, Double> incassiMap = new HashMap<>();
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DAY_OF_MONTH, -30);

        for(Ordini ordini : ordiniList){
            for(ArticoliOrdini articoliOrdini : articoliOrdiniList){
                if(articoliOrdini.getIdOrdine().equals(ordini.getIdOrdine())){
                    for(Menu menu : menuList){
                        if(menu.getIdMenu().equals(articoliOrdini.getIdMenu())){
                            if (!incassiMap.containsKey(ordini.getDataOrdine())){
                                Double prezzo = (menu.getPrezzo() * articoliOrdini.getQta());
                                incassiMap.put(ordini.getDataOrdine(), prezzo);
                            }
                            else{
                                incassiMap.put(ordini.getDataOrdine(), incassiMap.get(ordini.getDataOrdine()) + (menu.getPrezzo() * articoliOrdini.getQta()));
                            }
                        }
                    }
                }
            }
        }
        for(Date data : incassiMap.keySet()){
            report.append(data).append(" : ").append(incassiMap.get(data)).append("\n");
        }
        return report.toString();
    }

}
