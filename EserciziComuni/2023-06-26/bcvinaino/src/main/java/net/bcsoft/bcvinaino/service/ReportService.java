package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.IncassoGiornaliero;
import net.bcsoft.bcvinaino.entity.IncassoOrdine;


import java.util.List;
import java.util.Map;


public interface ReportService {
    List<IncassoGiornaliero> calcolaIncassi();
    Map <String, Integer> calcolaTipoFocaccia();
    List<IncassoOrdine> calcolaOrdini7Giorni();
}
