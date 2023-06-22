package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.dao.IncassiDAO;
import net.bcsoft.bcvinaino.entity.Incasso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //TODO Tipo di Component
public class ReportService {
    @Autowired
    IncassiDAO incassiDAO;

    public String incassi() {
        StringBuffer output = new StringBuffer();
        List<Incasso> incassoList = incassiDAO.incassi30Giorni();

        for (Incasso incasso : incassoList) {
            output.append(incasso.getData()).append(" | ").append(incasso.getSommaTotale());
            output.append("<br>");
        }
        return output.toString();
    }
}
