package net.bcsoft.bcvinaino.api;

import net.bcsoft.bcvinaino.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class ReportController{
    private final ReportService reportService;

    public ReportController(final ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/vinaino/focacce")
    public String focacce() {
        return this.reportService.getFocacce();
    }

    @GetMapping("/vinaino/incassi")
    public String incassi() {
        return this.reportService.getIncassi();
    }

    @GetMapping("/vinaino/ordini/{date}")
    public String ordini(@PathVariable("date") LocalDate dataInput) {
        return this.reportService.getOrdini(dataInput);
    }

    @GetMapping("/vinaino/sogliaordini/{min}/{max}")
    public String sogliaOrdini(@PathVariable("min") double min, @PathVariable("max") double max) {
        return this.reportService.getSogliaOrdini(min, max);
    }
}
