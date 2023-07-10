package net.bcsoft.BcVinaino.service;

import net.bcsoft.BcVinaino.entity.IncassoGiornaliero;
import net.bcsoft.BcVinaino.entity.IncassoOrdine;

import java.util.List;
import java.util.Map;

public interface ReportService {
    List<IncassoGiornaliero> calcolaIncassi();
    Map <String, Integer> calcolaTipoFocaccia();
    List<IncassoOrdine> calcolaOrdini7Giorni();
}