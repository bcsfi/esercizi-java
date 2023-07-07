package net.bcsoft.bcvinainorefactor.controller;

import net.bcsoft.bcvinainorefactor.entity.ArticoliOrdine;
import net.bcsoft.bcvinainorefactor.entity.Ordine;
import net.bcsoft.bcvinainorefactor.dto.ArticoliOrdineDto;
import net.bcsoft.bcvinainorefactor.service.ArticoliOrdineService;
import net.bcsoft.bcvinainorefactor.service.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/bcvinainorefactor/ordini")
public class OrdineRestController
{
    /// TODO ordini: Creazione di un nuovo ordine costituito da N item di menu con ID = X, M item di menu con ID = Y.

    private final OrdineService ordineService;
    private final ArticoliOrdineService articoliOrdineService;

    @Autowired
    public OrdineRestController (OrdineService ordineService, ArticoliOrdineService articoliOrdineService)
    {
        this.ordineService = ordineService;
        this.articoliOrdineService = articoliOrdineService;
    }

    @GetMapping()
    public List<Ordine> selectAll () {
        return ordineService.selectAll();
    }

    @PostMapping()
    public void insert (@RequestBody List<ArticoliOrdineDto> articoliOrdineDtoList)
    {
        Ordine ordine = new Ordine();
        ordine.setData(new Date());
        ordineService.insert(ordine);

        for (ArticoliOrdineDto articoliOrdineDto : articoliOrdineDtoList)
        {
            ArticoliOrdine articoliOrdine = new ArticoliOrdine();
            articoliOrdine.setIdOrdine(ordine.getId());
            articoliOrdine.setQuantita(articoliOrdineDto.getQuantita());
            articoliOrdine.setIdMenu(articoliOrdineDto.getIdMenu());
            articoliOrdineService.insert(articoliOrdine);
        }
    }
}
