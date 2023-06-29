package com.bcvinaini.bcvinaini.controller;


import org.springframework.web.bind.annotation.*;
import com.bcvinaini.bcvinaini.services.ReportService;

@RestController
public class ReportController
{

    private final ReportService servizio;

    public ReportController(ReportService servizio) {
        this.servizio = servizio;
    }

    @RequestMapping(value = "/report/ordini", method = RequestMethod.GET)
    public String ordini(){
        return servizio.getReportOrdini();
    }

    @RequestMapping(value = "/report/incassi", method = RequestMethod.GET)
    public String incassi()
    {
        return servizio.getReportIncassi();
    }

    @RequestMapping(value = "/report/focacce", method = RequestMethod.GET)
    public String foccace(){
        return servizio.getReportFocacce();
    }

    @RequestMapping(value = "/report/sogliaordini", method = RequestMethod.GET)
    public String sogliaordini(@RequestParam int soglia){
        return servizio.getReportSogliaOrdini(soglia);
    }





}
