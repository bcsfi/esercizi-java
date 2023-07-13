package net.bcsoft.bcvinainorefactor.controller;

import net.bcsoft.bcvinainorefactor.dto.OrdineCompletoDTO;
import net.bcsoft.bcvinainorefactor.dto.OrdineDTO;
import net.bcsoft.bcvinainorefactor.entity.Ordine;
import net.bcsoft.bcvinainorefactor.entity.dettaglio.OrdineCompleto;
import net.bcsoft.bcvinainorefactor.exception.FormatoSbagliatoEccezione;
import net.bcsoft.bcvinainorefactor.mapper.OrdineMapper;
import net.bcsoft.bcvinainorefactor.service.ArticoliOrdineService;
import net.bcsoft.bcvinainorefactor.service.OrdineService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/bcvinainorefactor/ordini")
public class OrdineRestController {
    private final OrdineService ordineService;
    private final ArticoliOrdineService articoliOrdineService;
    private final OrdineMapper ordineMapper;

    public OrdineRestController(OrdineService ordineService, ArticoliOrdineService articoliOrdineService, OrdineMapper ordineMapper) {
        this.ordineService = ordineService;
        this.articoliOrdineService = articoliOrdineService;
        this.ordineMapper = ordineMapper;
    }

    @GetMapping()
    public List<Ordine> selectAll() {
        return ordineService.selectAll();
    }

    @PostMapping()
    public List<OrdineDTO> insert(@RequestBody OrdineCompletoDTO ordineCompletoDTO) {
        try {
            return this.ordineMapper.toDTOLista(ordineService.insert(this.ordineMapper.toOrdineCompleto(ordineCompletoDTO)));
        } catch (FormatoSbagliatoEccezione e) {
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(value = "id") Integer id) {
        ordineService.deleteById(id);
    }

    @GetMapping("{id}")
    public OrdineCompleto ordineCompleto(@PathVariable(value = "id") Integer id) {
        return ordineService.selectOrdineCompleto(id);
    }
}
