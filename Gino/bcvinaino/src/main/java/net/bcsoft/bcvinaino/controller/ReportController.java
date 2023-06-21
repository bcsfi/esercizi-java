package net.bcsoft.bcvinaino.controller;

import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import net.bcsoft.bcvinaino.entity.Menu;
import net.bcsoft.bcvinaino.entity.Ordini;
import net.bcsoft.bcvinaino.mapper.ArticoliOrdiniMapper;
import net.bcsoft.bcvinaino.mapper.MenuMapper;
import net.bcsoft.bcvinaino.mapper.OrdiniMapper;
import net.bcsoft.bcvinaino.service.ReportService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ReportController
{
    private final ReportService reportService;

    public ReportController(final OrdiniMapper ordiniMapper,
                            final ArticoliOrdiniMapper articoliOrdiniMapper,
                            final MenuMapper menuMapper,
                            final ReportService reportService) {
        this.ordiniMapper = ordiniMapper;
        this.articoliOrdiniMapper = articoliOrdiniMapper;
        this.menuMapper = menuMapper;
        this.reportService = reportService;
    }

    @RequestMapping(value = "/vinaino", method = RequestMethod.GET)
    public String home()
    {
        return "/focacce\n/incassi\n/ordini\n/sogliaOrdini";
    }

    // la quantita di focacce vendute per ciascun tipo dopo una certa data
    @RequestMapping(value = "/vinaino/focacce", method = RequestMethod.GET)
    public String focacce()
    {
        List<Menu> menuList = menuMapper.selectAll();
        List<ArticoliOrdine> articoliOrdineList = articoliOrdiniMapper.selectAll();
        List<Ordini> ordiniList = ordiniMapper.selectAll();

        StringBuffer response = new StringBuffer();
        int quantita;

        for (Menu menu : menuList)
        {
            quantita = 0;

            for (ArticoliOrdine articoliOrdine : articoliOrdineList)
            {
                if (menu.getIdMenu() == articoliOrdine.getIdMenu())
                {
                    for (Ordini ordine : ordiniList)
                    {
                        if (articoliOrdine.getIdOrdine() == ordine.getIdOrdine() &&
                                LocalDate.now().minusMonths(1).isBefore(ordine.getDataOrdine()))
                        {
                            quantita += articoliOrdine.getQta();
                        }
                    }
                }
            }

            response.append(menu.getFocaccia()).append(" ").append(quantita).append("\n");
        }

        return response.toString();
    }

    // valore totale ordini effettuati in una solita data negli ultimi 30 giorni
    @RequestMapping(value = "/vinaino/incassi", method = RequestMethod.GET)
    public String incassi()
    {
        List<Menu> menuList = menuMapper.selectAll();
        List<ArticoliOrdine> articoliOrdineList = articoliOrdiniMapper.selectAll();
        List<Ordini> ordiniList = ordiniMapper.selectAll();

        StringBuffer response = new StringBuffer();
        double totale;

        LocalDate endDate = LocalDate.now().minusMonths(1);
        LocalDate startDate = LocalDate.now();

        for (LocalDate date = startDate; date.isAfter(endDate); date = date.minusDays(1))
        {
            totale = 0D;

            for (Ordini ordine : ordiniList)
            {
                if (date.getDayOfMonth() == ordine.getDataOrdine().getDayOfMonth())
                {
                    for (ArticoliOrdine articoliOrdine : articoliOrdineList)
                    {
                        if (ordine.getIdOrdine() == articoliOrdine.getIdOrdine())
                        {
                            for (Menu menu : menuList)
                            {
                                if (articoliOrdine.getIdMenu() == menu.getIdMenu())
                                {
                                    totale += articoliOrdine.getQta() * menu.getPrezzo();
                                }
                            }
                        }
                    }
                }
            }

            response.append(date).append(" ").append(totale).append("<br>");
        }

        return response.toString();
    }

    // per ogni ordine dopo una certa data, id, data e prezzo totale
    @GetMapping("/vinaino/ordini/{date}")
    public String ordini(@PathVariable("date") LocalDate dataInput)
    {
        return this.reportService.getOrdini(dataInput);
    }

    // per ogni ordine dopo una certa data, id, data e prezzo totale se l'ordine supera una certa soglia
    @RequestMapping(value = "/vinaino/sogliaordini", method = RequestMethod.GET)
    public String sogliaOrdini()
    {
        return "sogliaOrdini";
    }
}
