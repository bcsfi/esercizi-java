package net.bcsoft.BcVinaino.controller;

import net.bcsoft.BcVinaino.entity.IncassoGiornaliero;
import net.bcsoft.BcVinaino.entity.IncassoOrdine;
import net.bcsoft.BcVinaino.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ReportRestController {
    private final ReportService reportService;

    public ReportRestController(final ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/BcVinaino/report/incassi")
    public List<IncassoGiornaliero> calcolaIncassi() {
        //select All degli ordini (OrdineCompleto)
        //elaborazione per calcolare gli incassi (vedi Stream() e Collectors.groupingBy)
        return reportService.calcolaIncassi();
    }

    @GetMapping("/BcVinaino/report/tipoFocaccia")
    public Map<String, Integer> calcolaTipoFocaccia(){ return reportService.calcolaTipoFocaccia();}

    @GetMapping("/BcVinaino/report/ordini")
    public List<IncassoOrdine> calcolaOrdini7Giorni(){
        return reportService.calcolaOrdini7Giorni();
    }

}