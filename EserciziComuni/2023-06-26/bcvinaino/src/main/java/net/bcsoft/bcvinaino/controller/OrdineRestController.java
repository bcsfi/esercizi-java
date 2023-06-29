package net.bcsoft.bcvinaino.controller;

import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;
import net.bcsoft.bcvinaino.service.OrdineService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdineRestController {
    private final OrdineService ordineService;

    public OrdineRestController(OrdineService ordineService) {
        this.ordineService = ordineService;
    }

    @PostMapping("/bcvinaino/ordini/insertOrdine")
    public void insertOrdine(@RequestBody OrdineCompleto ordineCompleto){
        ordineService.insert(ordineCompleto);
    }
}
