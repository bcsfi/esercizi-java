package net.bcsoft.bcvinaino.service.implement;

import net.bcsoft.bcvinaino.dao.ReportDAO;
import net.bcsoft.bcvinaino.entity.*;
import net.bcsoft.bcvinaino.service.ArticoliOrdineService;
import net.bcsoft.bcvinaino.service.MenuService;
import net.bcsoft.bcvinaino.service.OrdineService;
import net.bcsoft.bcvinaino.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportDAO reportDAO;
    private final MenuService menuService;
    private final ArticoliOrdineService articoliOrdineService;
    private final OrdineService ordineService;

    public ReportServiceImpl(ReportDAO reportDAO, MenuService menuService, ArticoliOrdineService articoliOrdineService, OrdineService ordineService) {
        this.reportDAO = reportDAO;
        this.menuService = menuService;
        this.articoliOrdineService = articoliOrdineService;
        this.ordineService = ordineService;
    }

    @Override
    public List<IncassoGiornaliero> calcolaIncassi() {
        return reportDAO.calcolaIncassi();
    }

    @Override
    public Map <String, Integer> calcolaTipoFocaccia() {

        List<Menu> menuList = menuService.selectAll();
        List<ArticoliOrdine> articoliOrdineList = articoliOrdineService.selectAll();
        List<Ordine> ordiniList = ordineService.selectAll();
        Map <String, Integer> focacceMap = new HashMap<>();


        for(Menu menu : menuList){
            Integer quantita = 0;
            for(ArticoliOrdine articoliOrdine : articoliOrdineList){
                if(articoliOrdine.getIdMenu().equals(menu.getIdMenu())){
                    for(Ordine ordine : ordiniList){
                        if(ordine.getIdOrdine().equals(articoliOrdine.getIdOrdine())){
                            focacceMap.put(menu.getFocaccia(), quantita++);
                        }
                    }
                }
            }
        }
        return focacceMap;
    }

    @Override
    public List<IncassoOrdine> calcolaOrdini7Giorni() {

        List<ArticoliOrdine> articoliOrdineList = articoliOrdineService.selectAll();
        List<Ordine> ordineList = ordineService.selectAll();
        List<Menu> menuList = menuService.selectAll();

        List<IncassoOrdine> incassoOrdineList = new ArrayList<>();

        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        Date data = calendar.getTime();

        double guadagnoSettimanale;

        for (Ordine ordine : ordineList) {
            IncassoOrdine incassoOrdine = new IncassoOrdine();
            guadagnoSettimanale = 0;
            for (ArticoliOrdine articoloOrdine : articoliOrdineList) {
                if (articoloOrdine.getIdOrdine().equals(ordine.getIdOrdine()) && ordine.getDataOrdine().after(data)) {
                    for (Menu menu : menuList) {
                        if (menu.getIdMenu().equals(articoloOrdine.getIdMenu())) {
                            incassoOrdine.setIdOrdine(articoloOrdine.getIdOrdine());
                            incassoOrdine.setDataOrdine(ordine.getDataOrdine());
                            guadagnoSettimanale += menu.getPrezzo() * articoloOrdine.getQta();
                            incassoOrdine.setIncasso(guadagnoSettimanale);
                            incassoOrdineList.add(incassoOrdine);
                        }
                    }
                }
            }
        }
        return incassoOrdineList;
    }


}