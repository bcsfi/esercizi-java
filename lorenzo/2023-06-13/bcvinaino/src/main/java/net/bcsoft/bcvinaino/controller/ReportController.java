package net.bcsoft.bcvinaino.controller;

import net.bcsoft.bcvinaino.dao.OrdiniDAO;
import net.bcsoft.bcvinaino.entity.Ordine;
import net.bcsoft.bcvinaino.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//TODO Far andare la stringa del ReportService
@RestController
public class ReportController {
    @Autowired
    ReportService reportService;

    @Autowired
    OrdiniDAO ordiniDAO;

    @GetMapping("/report/incassi")
    public String incassi() {
        return reportService.calcolaIncassiMensili();
    }

    @GetMapping("/report/focacce")
    public void focacce() {
    }

    @GetMapping("/report/ordini")
    public List<Ordine> ordini() {
        List<Ordine> a = this.ordiniDAO.OrdiniList();
        return a;
    }

    @GetMapping("/report/soglia")
    public void soglia() {
    }
}
