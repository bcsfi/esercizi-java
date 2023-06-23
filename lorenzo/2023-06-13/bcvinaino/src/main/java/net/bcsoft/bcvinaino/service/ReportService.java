package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.dao.FocacceDAO;
import net.bcsoft.bcvinaino.dao.IncassiDAO;
import net.bcsoft.bcvinaino.dao.OrdiniDAO;
import net.bcsoft.bcvinaino.dao.SogliaDAO;
import net.bcsoft.bcvinaino.entity.Focaccia;
import net.bcsoft.bcvinaino.entity.Incasso;
import net.bcsoft.bcvinaino.entity.Ordine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //TODO Tipo di Component
public class ReportService {
    @Autowired
    IncassiDAO incassiDAO;

    @Autowired
    FocacceDAO focacceDAO;

    @Autowired
    OrdiniDAO ordiniDAO;

    @Autowired
    SogliaDAO sogliaDAO;

    public String incassi() {
        StringBuffer output = new StringBuffer();
        List<Incasso> incassoList = incassiDAO.incassi30Giorni();

        for (Incasso incasso : incassoList) {
            output.append(incasso.getData()).append(" | ").append(incasso.getSommaTotale());
            output.append("<br>");
        }
        return output.toString();
    }

    public String focacce() {
        StringBuffer output = new StringBuffer();
        List<Focaccia> focacciaList = focacceDAO.focaccePiuVendute30Giorni();

        for (Focaccia focaccia : focacciaList) {
            output.append(focaccia.getNome()).append(" | ").append(focaccia.getQuantita());
            output.append("<br>");
        }
        return output.toString();
    }

    public String ordini() {
        StringBuffer output = new StringBuffer();
        List<Ordine> ordineList = ordiniDAO.incassoGiornaliero7Giorni();

        for (Ordine ordine : ordineList) {
            output.append(ordine.getIdOrdine()).append(" | ");
            output.append(ordine.getDataOrdine()).append(" | ");
            output.append(ordine.getIncassoOrdine());
            output.append("<br>");
        }
        return output.toString();
    }

    public String sogliaOrdini(Double inputMinSoglia) {
        StringBuffer output = new StringBuffer();
        List<Ordine> ordineList = sogliaDAO.sogliaOrdine(inputMinSoglia);

        for (Ordine ordine : ordineList) {
            output.append(ordine.getIdOrdine()).append(" | ");
            output.append(ordine.getDataOrdine()).append(" | ");
            output.append(ordine.getIncassoOrdine());
            output.append("<br>");
        }
        return output.toString();
    }
}
