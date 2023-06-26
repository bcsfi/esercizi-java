package net.bcsoft.bcvinaino.controller;

import net.bcsoft.bcvinaino.entity.Menu;
import net.bcsoft.bcvinaino.entity.Ordini;
import net.bcsoft.bcvinaino.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdiniController {
    @Autowired
    ReportService reportService;
    @PostMapping("/report/insertMenu")
    public void insertMenu(@RequestBody Menu menu) {
        reportService.insertMenu(menu);
    }

    @PutMapping("/report/update")
    public void updateFocaccia(@RequestBody Menu menu){
        reportService.updateFocaccia(menu);
    }
}
