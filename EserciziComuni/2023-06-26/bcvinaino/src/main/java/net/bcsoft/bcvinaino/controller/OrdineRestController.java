package net.bcsoft.bcvinaino.controller;

import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;
import net.bcsoft.bcvinaino.service.OrdineService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class OrdineRestController {
    private final OrdineService ordineService;

    public OrdineRestController(OrdineService ordineService) {
        this.ordineService = ordineService;
    }

//    @PostMapping("/bcvinaino/ordini")
//    public void insertOrdine(@RequestBody OrdineCompleto ordineCompleto){
//        ordineService.insert(ordineCompleto);
//    }

    @DeleteMapping("/bcvinaino/ordini/{id}")
    public void deleteOrdineByID(@PathVariable(value = "id") Long id){
        ordineService.deleteOrdineByID(id);
    }

    @DeleteMapping("/bcvinaino/ordini/data/{data}")
    public void deleteOrdineByData(@PathVariable(value = "data") LocalDate data){
        ordineService.deleteOrdineByData(data);
    }
}
