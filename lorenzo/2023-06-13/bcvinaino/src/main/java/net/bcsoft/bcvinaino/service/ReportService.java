package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import net.bcsoft.bcvinaino.entity.Menu;
import net.bcsoft.bcvinaino.entity.Ordini;
import net.bcsoft.bcvinaino.mapper.ArticoliOrdineMapper;
import net.bcsoft.bcvinaino.mapper.MenuMapper;
import net.bcsoft.bcvinaino.mapper.OrdiniMapper;
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
    MenuMapper menuMapper;

    @Autowired
    ArticoliOrdineMapper articoliOrdineMapper;

    @Autowired
    OrdiniMapper ordiniMapper;

    public String calcolaIncassiMensili() {
        StringBuffer output = new StringBuffer();
        Map<Date, Double> incassiMensiliMap = new HashMap<Date, Double>();

        Calendar giornoLimite = new GregorianCalendar();
        giornoLimite.add(Calendar.DAY_OF_MONTH, -30);

        List<Ordini> ordiniList = ordiniMapper.selectAll();
        List<ArticoliOrdine> articoliOrdineList = articoliOrdineMapper.selectAll();
        List<Menu> menuList = menuMapper.selectAll();

        for (Ordini ordine : ordiniList) {
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