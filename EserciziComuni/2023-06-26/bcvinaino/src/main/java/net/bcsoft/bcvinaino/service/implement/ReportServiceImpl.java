package net.bcsoft.bcvinaino.service.implement;

import net.bcsoft.bcvinaino.dao.ArticoliOrdineDAO;
import net.bcsoft.bcvinaino.dao.IncassoDAO;
import net.bcsoft.bcvinaino.dao.MenuDAO;
import net.bcsoft.bcvinaino.dao.OrdineDAO;
import net.bcsoft.bcvinaino.entity.*;
import net.bcsoft.bcvinaino.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
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
                if (menu.getIdMenu() == articoliOrdine.getIdMenu()) {
                    for (Ordine ordine : ordiniList) {
                        if (articoliOrdine.getIdOrdine() == ordine.getIdOrdine() && data.before(ordine.getDataOrdine())) {
                            quantita += articoliOrdine.getQta();
                        }
                    }
                }
            }

            quantitaFocacciaList.add(new QuantitaFocaccia(menu.getFocaccia(), quantita));

        }

        return quantitaFocacciaList;
    }

    @Override
    public String calcolaSoglia() {
        return null;
    }

}