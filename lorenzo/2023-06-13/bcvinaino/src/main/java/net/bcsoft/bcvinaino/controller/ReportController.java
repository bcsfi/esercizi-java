package net.bcsoft.bcvinaino.controller;

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

    @GetMapping("/report/incassi")
    public String incassi() {
        return reportService.incassi();
    }

    @GetMapping("/report/focacce")
    public void focacce() {
    }
}
