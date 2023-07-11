package net.bcsoft.bcvinaino.service.implement;

import net.bcsoft.bcvinaino.dao.ArticoliOrdineDAO;
import net.bcsoft.bcvinaino.dao.IncassoDAO;
import net.bcsoft.bcvinaino.dao.MenuDAO;
import net.bcsoft.bcvinaino.dao.OrdineDAO;
import net.bcsoft.bcvinaino.entity.*;
import net.bcsoft.bcvinaino.service.ReportService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {

    private final IncassoDAO incassoDAO;
    private final MenuDAO menuDAO;
    private final ArticoliOrdineDAO articoliOrdineDAO;
    private final OrdineDAO ordineDAO;

    public ReportServiceImpl(IncassoDAO incassoDAO, MenuDAO menuDAO, ArticoliOrdineDAO articoliOrdineDAO, OrdineDAO ordineDAO) {
        this.incassoDAO = incassoDAO;
        this.menuDAO = menuDAO;
        this.articoliOrdineDAO = articoliOrdineDAO;
        this.ordineDAO = ordineDAO;
    }

    @Override
    public List<IncassoGiornaliero> calcolaIncassi() {
        return incassoDAO.calcolaIncassi();
    }

    @Override
    public List<QuantitaFocaccia> calcolaTipoFocaccia() {

        List<Menu> menuList = menuDAO.selectAll();
        List<ArticoliOrdine> articoliOrdineList = articoliOrdineDAO.selectAll();
        List<Ordine> ordiniList = ordineDAO.selectAll();

        List<QuantitaFocaccia> quantitaFocacciaList = new ArrayList<>();
        int quantita;
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DAY_OF_MONTH, -30);
        Date data = calendar.getTime();

        for (Menu menu : menuList) {
            quantita = 0;

            for (ArticoliOrdine articoliOrdine : articoliOrdineList) {
                if (menu.getId().equals(articoliOrdine.getIdMenu())) {
                    for (Ordine ordine : ordiniList) {
                        if (articoliOrdine.getIdOrdine().equals(ordine.getId()) && data.after(ordine.getData())) {
                            quantita += articoliOrdine.getQuantita();
                        }
                    }
                }
            }

            quantitaFocacciaList.add(new QuantitaFocaccia(menu.getNome(), quantita));

        }

        return quantitaFocacciaList;
    }

    @Override
    public List<IncassoOrdine> calcolaOrdini7Giorni() {

        List<ArticoliOrdine> articoliOrdineList = articoliOrdineDAO.selectAll();
        List<Ordine> ordineList = ordineDAO.selectAll();
        List<Menu> menuList = menuDAO.selectAll();

        List<IncassoOrdine> incassoOrdineList = new ArrayList<>();

        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        Date data = calendar.getTime();

        double guadagnoSettimanale;

        for (Ordine ordine : ordineList) {
            IncassoOrdine incassoOrdine = new IncassoOrdine();
            guadagnoSettimanale = 0;
            for (ArticoliOrdine articoloOrdine : articoliOrdineList) {
                if (articoloOrdine.getIdOrdine().equals(ordine.getId()) && ordine.getData().after(data)) {
                    for (Menu menu : menuList) {
                        if (menu.getId().equals(articoloOrdine.getIdMenu())) {
                            incassoOrdine.setId(articoloOrdine.getIdOrdine());
                            incassoOrdine.setData(ordine.getData());
                            guadagnoSettimanale += menu.getPrezzo() * articoloOrdine.getQuantita();
                            incassoOrdine.setIncasso(guadagnoSettimanale);
                            incassoOrdineList.add(incassoOrdine);
                        }
                    }
                }
            }
        }
        return incassoOrdineList;
    }

    @Override
    public String calcolaSoglia() {
        return null;
    }

}