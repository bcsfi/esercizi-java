package net.bcsoft.bcvinaino.controller;


import net.bcsoft.bcvinaino.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReportController {
    @Autowired
    ReportService reportService;
    @RequestMapping(value = "/focacce/{param1}", method = RequestMethod.GET)
    public String focaccia(){
        return "focaccia";
    }

    @RequestMapping(value = "/incassi", method = RequestMethod.GET )
    public String incassi(){
        return reportService.calcolaIncassi();
    }

    @RequestMapping(value = "/ordini", method = RequestMethod.GET)
    public String ordini(){
        return "ordini";
    }

    @RequestMapping(value = "/ordinisoglia", method = RequestMethod.GET)
    public String ordiniSoglia(){
        return "ordiniSoglia";
    }

}
