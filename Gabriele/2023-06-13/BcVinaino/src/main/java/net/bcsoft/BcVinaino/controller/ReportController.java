package net.bcsoft.bcvinaino.controller;


import net.bcsoft.bcvinaino.service.ReportService;
import net.bcsoft.bcvinaino.dao.OrdiniDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReportController {
    @Autowired
    ReportService reportService;
    @Autowired
    OrdiniDAO ordiniDAO;
    @GetMapping("/report/incassi")
    public String focaccia(){
        return reportService.calcolaIncassi();
    }

   @GetMapping("/report/focacce")
    public String incassi(){
        return null;
    }

    @GetMapping("/report/ordini")
    public String ordini(){
        return "ordini";
    }

    @GetMapping("/report/soglia")
    public String ordiniSoglia(){
        return "ordiniSoglia";
    }

}
