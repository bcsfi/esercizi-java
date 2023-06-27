package net.bcsoft.bcvinaino.service.implement;

import net.bcsoft.bcvinaino.dao.IncassiDAO;
import net.bcsoft.bcvinaino.entity.IncassoGiornaliero;
import net.bcsoft.bcvinaino.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReportServiceImpl implements ReportService {

    private final IncassiDAO incassiDAO;

    public ReportServiceImpl(final IncassiDAO incassiDAO) {
        this.incassiDAO = incassiDAO;
    }

    @Override
    public List<IncassoGiornaliero> calcolaIncassi() {
        return incassiDAO.calcolaIncassi();
    }

    @Override
    public String calcolaTipoFocaccia() {
        return null;
    }

    @Override
    public String calcolaSoglia() {
        return null;
    }

}