package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.daos.MenuDAO;
import net.bcsoft.bcvinaino.daos.IncassiMensiliDAO;
import net.bcsoft.bcvinaino.daos.OrdiniDAO;
import net.bcsoft.bcvinaino.daos.ThresholdDAO;
import net.bcsoft.bcvinaino.entity.Menu;
import net.bcsoft.bcvinaino.entity.Incasso;
import net.bcsoft.bcvinaino.entity.Ordini;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    IncassiMensiliDAO incassiMensiliDAO;

    @Autowired
    MenuDAO menuDAO;

    @Autowired
    OrdiniDAO ordiniDAO;

    @Autowired
    ThresholdDAO thresholdDAO;

    public String incassi() {
        StringBuffer output = new StringBuffer();
        List<Incasso> incassoList = incassiMensiliDAO.incassiMensili();

        for (Incasso incasso : incassoList) {
            output.append(incasso.getData()).append(" | ").append(incasso.getSomma());
            output.append("<p>");
        }
        return output.toString();
    }

    public String focacce() {
        StringBuffer output = new StringBuffer();
        List<Menu> focacciaList = menuDAO.focaccePerOrdine();

        for (Menu focaccia : focacciaList) {
            output.append(focaccia.getNome()).append(" | ").append(focaccia.getQta());
            output.append("<p>");
        }
        return output.toString();
    }

    public String ordini() {
        StringBuffer output = new StringBuffer();
        List<Ordini> ordineList = ordiniDAO.incassoSettimana();

        for (Ordini ordine : ordineList) {
            output.append(ordine.getIdOrdine()).append(" | ");
            output.append(ordine.getDataOrdine()).append(" | ");
            output.append(ordine.getIncassoOrdine());
            output.append("<p>");
        }
        return output.toString();
    }

    public String ordiniThreshold(Double sogliaMin) {
        StringBuffer output = new StringBuffer();
        List<Ordini> ordineList = thresholdDAO.ordineThreshold(sogliaMin);

        for (Ordini ordine : ordineList) {
            output.append(ordine.getIdOrdine()).append(" | ");
            output.append(ordine.getDataOrdine()).append(" | ");
            output.append(ordine.getIncassoOrdine());
            output.append("<p>");
        }
        return output.toString();
    }
}