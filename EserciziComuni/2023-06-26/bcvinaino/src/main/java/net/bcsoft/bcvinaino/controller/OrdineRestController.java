package net.bcsoft.bcvinaino.controller;

import net.bcsoft.bcvinaino.entity.Ordine;
import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;
import net.bcsoft.bcvinaino.service.OrdineService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/bcvinaino/ordini")
public class OrdineRestController {
    private final OrdineService ordineService;

    public OrdineRestController(OrdineService ordineService) {
        this.ordineService = ordineService;
    }

    @GetMapping()
    public List<Ordine> selectAll() {
        return ordineService.selectAll();
    }

    @PostMapping()
    public void insert(@RequestBody OrdineCompleto ordineCompleto) {
        ordineService.insert(ordineCompleto);
    }

    @DeleteMapping("/{id}")
    public List<Ordine> deleteByID(@PathVariable(value = "id") Long id) {
        return ordineService.deleteByID(id);
    }

    @DeleteMapping("/data/{data}")
    public List<Ordine> deleteByData(@PathVariable(value = "data") Date data) {
        return ordineService.deleteByData(data);
    }
}
