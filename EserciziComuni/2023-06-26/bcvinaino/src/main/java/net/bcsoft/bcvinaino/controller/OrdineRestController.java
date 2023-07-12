package net.bcsoft.bcvinaino.controller;

import net.bcsoft.bcvinaino.dto.OrdineDTO;
import net.bcsoft.bcvinaino.entity.Ordine;
import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;
import net.bcsoft.bcvinaino.service.OrdineService;
import net.bcsoft.bcvinaino.mapper.OrdineMapper;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;


@RestController
public class OrdineRestController {
    private final OrdineService ordineService;
    private final OrdineMapper ordineMapper;

    public OrdineRestController(OrdineService ordineService, OrdineMapper ordineMapper) {
        this.ordineService = ordineService;
        this.ordineMapper = ordineMapper;
    }

    @GetMapping("/bcvinaino/ordini/selectAll")
    public List<OrdineDTO> getAll(){
        return this.ordineMapper.toDTOs(this.ordineService.selectAll());
    }
    @PostMapping("/bcvinaino/ordini/insert")
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
