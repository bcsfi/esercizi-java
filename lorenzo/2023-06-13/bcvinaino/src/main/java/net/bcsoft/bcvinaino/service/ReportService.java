package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import net.bcsoft.bcvinaino.entity.Menu;
import net.bcsoft.bcvinaino.entity.Ordine;
import net.bcsoft.bcvinaino.dao.ArticoliOrdineDAO;
import net.bcsoft.bcvinaino.dao.MenuDAO;
import net.bcsoft.bcvinaino.dao.OrdiniDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service //TODO Tipo di Component
public class ReportService {

    @Autowired //Quando il Service viene istanziato viene preso MenuMapper
    MenuDAO menuDao;

    @Autowired
    ArticoliOrdineDAO articoliOrdineDao;

    @Autowired
    OrdiniDAO ordiniDao;

    public String calcolaIncassiMensili() {
        StringBuffer output = new StringBuffer();
        Map<Date, Double> incassiMensiliMap = new HashMap<Date, Double>();

        Calendar giornoLimite = new GregorianCalendar();
        giornoLimite.add(Calendar.DAY_OF_MONTH, -30);

        List<Ordine> ordineList = ordiniDao.OrdiniList();
        List<ArticoliOrdine> articoliOrdineList = articoliOrdineDao.selectAll();
        List<Menu> menuList = menuDao.selectAll();

        for (Ordine ordine : ordineList) {
            if (ordine.getDataOrdine().after(giornoLimite.getTime())) {

                for (ArticoliOrdine articoloOrdine : articoliOrdineList) {
                    if (articoloOrdine.getIdOrdine() == ordine.getIdOrdine()) {

                        for (Menu menu : menuList) {
                            if (menu.getIdMenu() == articoloOrdine.getIdMenu()) {

                                if (!incassiMensiliMap.containsKey(ordine.getDataOrdine())) {
                                    Double prezzo = (menu.getPrezzo() * articoloOrdine.getQta());
                                    incassiMensiliMap.put(ordine.getDataOrdine(), prezzo);
                                } else {
                                    incassiMensiliMap.put(
                                            ordine.getDataOrdine(), incassiMensiliMap.get(ordine.getDataOrdine()) +
                                                    menu.getPrezzo() * articoloOrdine.getQta());
                                }
                            }
                        }
                    }
                }
            }
        }

        incassiMensiliMap.forEach((Date data, Double incassiGiornalieri) ->
                output.append(data)
                        .append(" | ")
                        .append(incassiGiornalieri)
                        .append("\n"));

        return output.toString();
    }
}