package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.IncassoGiornaliero;
import net.bcsoft.bcvinaino.entity.IncassoOrdine;
import net.bcsoft.bcvinaino.entity.QuantitaFocaccia;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


public interface ReportService {
    List<IncassoGiornaliero> calcolaIncassi();
    List<QuantitaFocaccia> calcolaTipoFocaccia();
    List<IncassoOrdine> calcolaOrdini7Giorni();
    String calcolaSoglia();
}
