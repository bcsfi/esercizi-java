package net.bcsoft.bcvinaino.controller;

import net.bcsoft.bcvinaino.entity.Ordine;
import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;
import net.bcsoft.bcvinaino.service.OrdineService;
import net.bcsoft.bcvinaino.validation.InputValidation;
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
    public List<Ordine> getAll() {
        return ordineService.getAll();
    }

    @GetMapping("/{id}")
    public OrdineCompleto get(@PathVariable(value = "id") Long id) {
        return ordineService.get(InputValidation.idIsValid(id));
    }

    @PostMapping()
    public List<Ordine> create(@RequestBody OrdineCompleto ordineCompleto) {
        return ordineService.create(ordineCompleto);
    }

    @DeleteMapping("/{id}")
    public List<Ordine> deleteByID(@PathVariable(value = "id") Long id) {
        return ordineService.deleteByID(InputValidation.idIsValid(id));

    }

    @DeleteMapping("/data/{data}")
    public List<Ordine> deleteByData(@PathVariable(value = "data") Date data) {
        return ordineService.deleteByData(InputValidation.dateIsValid(data));
    }
}