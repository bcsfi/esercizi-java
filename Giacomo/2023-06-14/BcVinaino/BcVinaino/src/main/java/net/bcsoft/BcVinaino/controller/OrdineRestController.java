package net.bcsoft.BcVinaino.controller;

import net.bcsoft.BcVinaino.entity.Ordine;
import net.bcsoft.BcVinaino.entity.dettaglio.OrdineCompleto;
import net.bcsoft.BcVinaino.service.OrdineService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;


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
        try{
            ordineService.deleteOrdinePerData(data);
        }catch(NotFoundException e){
            e.printStackTrace();
        }
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