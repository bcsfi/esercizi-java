package net.bcsoft.bcvinaino.controller;

import net.bcsoft.bcvinaino.entity.Ordine;
import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;
import net.bcsoft.bcvinaino.service.OrdineService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class OrdineRestController {
    private final OrdineService ordineService;

    public OrdineRestController(OrdineService ordineService) {
        this.ordineService = ordineService;
    }

    @PostMapping("/bcvinaino/ordini")
    public Ordine insertOrdine(@RequestBody OrdineCompleto ordineCompleto){
        return ordineService.insert(ordineCompleto);
    }
    @DeleteMapping("/bcvinaino/ordini/id/{id}")
    public void cancellaOrdinePerId(@PathVariable Integer id){
        try{
            ordineService.deleteOrdinePerId(id);
        }catch(NotFoundException e){
            e.printStackTrace();
        }
    }
    @DeleteMapping("/bcvinaino/ordini/data/{data}")
    public void cancellaOrdinePerData(@PathVariable LocalDate data){
            ordineService.deleteOrdinePerData(data);
    }

    @GetMapping("/bcvinaino/ordini/{id}")
    public OrdineCompleto ottieniOrdineCompleto(@PathVariable Integer id) {
        OrdineCompleto ordineCompletoTemp = new OrdineCompleto();
        try {
            ordineCompletoTemp = ordineService.getById(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return ordineCompletoTemp;
    }
}
