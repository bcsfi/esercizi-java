package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.ArticoliOrdini;
import net.bcsoft.bcvinaino.entity.Menu;
import net.bcsoft.bcvinaino.entity.Ordini;
import net.bcsoft.bcvinaino.mapper.ArticoliOrdiniMapper;
import net.bcsoft.bcvinaino.mapper.MenuMapper;
import net.bcsoft.bcvinaino.mapper.OrdiniMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReportService {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    OrdiniMapper ordiniMapper;
    @Autowired
    ArticoliOrdiniMapper articoliOrdiniMapper;

    public String calcolaIncassi(){
        StringBuilder report = new StringBuilder();
        List <ArticoliOrdini> articoliOrdiniList= articoliOrdiniMapper.selectAll();
        List <Menu> menuList = menuMapper.selectAll();
        List <Ordini> ordiniList = ordiniMapper.selectAll();
        Map <Date, Double> incassiMap = new HashMap<>();
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

    public String focacce(){
        StringBuilder report = new StringBuilder();
        List <ArticoliOrdini> articoliOrdiniList= articoliOrdiniMapper.selectAll();
        List <Menu> menuList = menuMapper.selectAll();
        List <Ordini> ordiniList = ordiniMapper.selectAll();
        Map <String, Integer> incassiMap = new HashMap<>();
        Integer conteggio= 1;

        for (Menu menu : menuList){
            for(ArticoliOrdini articolo : articoliOrdiniList){
                if(articolo.getIdMenu().equals(menu.getIdMenu())){
                    for(Ordini ordine : ordiniList){
                        if(ordine.getIdOrdine().equals(articolo.getIdOrdine())){
                            incassiMap.put(menu.getFocaccia(), conteggio);
                            conteggio ++;
                        }
                    }
                }
            }
        }

        for(String focaccia : incassiMap.keySet()){
            report.append(focaccia).append(" : ").append(incassiMap.get(focaccia)).append("\n");
        }
        return report.toString();
    }



}
