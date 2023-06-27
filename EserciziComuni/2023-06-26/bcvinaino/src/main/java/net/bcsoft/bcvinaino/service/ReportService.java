package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.IncassoGiornaliero;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


public interface ReportService {
    List<IncassoGiornaliero> calcolaIncassi();
    String calcolaTipoFocaccia();
    String calcolaSoglia();
}
