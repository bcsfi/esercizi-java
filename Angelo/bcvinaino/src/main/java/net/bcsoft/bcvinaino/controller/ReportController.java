package net.bcsoft.bcvinaino.controller;

import net.bcsoft.bcvinaino.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ReportController {
    @Autowired
    ReportService reportService;

    @GetMapping("/report/incassi")
    public String incassi() {
        return reportService.incassi();
    }

    @GetMapping("/report/focacce")
    public String focacce() {
        return reportService.focacce();
    }

    @GetMapping("/report/ordini")
    public String ordini() {
        return reportService.ordini();
    }

    @GetMapping("/report/threshold/input_min_soglia")
    public String soglia(@PathVariable("input_min_soglia") Double sogliaMin) {
        return this.reportService.ordiniThreshold(sogliaMin);
    }
}