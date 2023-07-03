package net.bcsoft.bcvinaino.controller;

import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;
import net.bcsoft.bcvinaino.service.OrdineService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class OrdineRestController {
    private final OrdineService ordineService;

    public OrdineRestController(OrdineService ordineService) {
        this.ordineService = ordineService;
    }

    @PostMapping("/bcvinaino/ordini/ordine")
    public void insertOrdine(@RequestBody OrdineCompleto ordineCompleto){
        ordineService.insert(ordineCompleto);
    }
    @DeleteMapping("/bcvinaino/ordini/id")
    public void cancellaOrdinePerId(@RequestParam Integer id){
        ordineService.deleteOrdinePerId(id);
    }
    @DeleteMapping("/bcvinaino/ordini/data")
    public void cancellaOrdinePerData(@RequestParam LocalDate data){
        ordineService.deleteOrdinePerData(data);
    }

    @GetMapping("/bcvinaino/ordini/{id}")
    public OrdineCompleto ottieniOrdineCompleto(@RequestParam Integer id){
        return ordineService.getById(id);
    }
}
