package net.bcsoft.bcvinaino.controller;

import net.bcsoft.bcvinaino.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//TODO Far andare la stringa del ReportService
@RestController
public class ReportController {
    @Autowired
    ReportService reportService;

    @GetMapping("/report/incassi")
    public String incassi() {
        return reportService.calcolaIncassiMensili();
    }

    @GetMapping("/report/focacce")
    public void focacce() {
    }

    @GetMapping("/report/ordini")
    public void ordini() {
    }

    @GetMapping("/report/soglia")
    public void soglia() {
    }
}
