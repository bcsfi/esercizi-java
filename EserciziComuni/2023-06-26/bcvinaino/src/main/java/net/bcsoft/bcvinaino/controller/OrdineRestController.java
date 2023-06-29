package net.bcsoft.bcvinaino.controller;

import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;
import net.bcsoft.bcvinaino.service.OrdineService;
import org.springframework.web.bind.annotation.*;

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
    @DeleteMapping("/bcvinaino/ordini/cancellaOrdine")
    public void cancellaOrdine(@RequestParam Integer id){
        ordineService.deleteOrdine(id);
    }
}
