package net.bcsoft.bcvinaino.controller;

import net.bcsoft.bcvinaino.entity.IncassoGiornaliero;
import net.bcsoft.bcvinaino.entity.QuantitaFocaccia;
import net.bcsoft.bcvinaino.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportRestController {
    private final ReportService reportService;

    public ReportRestController(final ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/bcvinaino/report/incassi")
    public List<IncassoGiornaliero> calcolaIncassi() {
        //select All degli ordini (OrdineCompleto)
        //elaborazione per calcolare gli incassi (vedi Stream() e Collectors.groupingBy)
        return reportService.calcolaIncassi();
    }

    @GetMapping("/bcvinaino/report/tipoFocaccia")
    public List<QuantitaFocaccia> calcolaTipoFocaccia(){ return reportService.calcolaTipoFocaccia();}

    @GetMapping("/bcvinaino/report/soglia")
    public String calcolaSoglia(){
        return reportService.calcolaSoglia();
    }
}
