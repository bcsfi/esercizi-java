package net.bcsoft.bcvinaino.controller;

import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;
import net.bcsoft.bcvinaino.entity.dettaglio.OrdineFinale;
import net.bcsoft.bcvinaino.service.OrdineService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
        ordineService.deleteOrdinePerId(id);
    }
    @DeleteMapping("/bcvinaino/ordini/cancellaOrdinePerData")
    public void cancellaOrdinePerData(@RequestParam LocalDate data){
        ordineService.deleteOrdinePerData(data);
    }

    @GetMapping("/bcvinaino/ordini/ottieniOrdineCompleto")
    public List<OrdineFinale> ottieniOrdineCompleto(@RequestParam Integer id){
        return ordineService.getOrdineCompleto(id);
    }
}
