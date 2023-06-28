package com.bcvinaini.bcvinaini.controller;


import com.bcvinaini.bcvinaini.dao.ResponseOrdineDAO;
import com.bcvinaini.bcvinaini.dto.RquestOrdine;
import com.bcvinaini.bcvinaini.entity.Menu;
import com.bcvinaini.bcvinaini.entity.Ordini;
import com.bcvinaini.bcvinaini.mapper.MapperNoXML.ArticoliOrdiniMapper;
import com.bcvinaini.bcvinaini.mapper.MapperNoXML.MenuMapper;
import com.bcvinaini.bcvinaini.mapper.MapperNoXML.OrdiniMapper;
import com.bcvinaini.bcvinaini.services.ServizioOrdini;
import org.springframework.web.bind.annotation.*;
import com.bcvinaini.bcvinaini.services.ReportService;

import java.sql.Date;
import java.util.List;

@RestController
public class ReportController
{

    private final ServizioOrdini servizioOrdini;
    private final MenuMapper menuMapper;
    private final OrdiniMapper ordiniMapper;
    private final ArticoliOrdiniMapper articoliOrdiniMapper;
    private final ReportService servizio;

    public ReportController(ServizioOrdini servizioOrdini,
                            MenuMapper menuMapper,
                            OrdiniMapper ordiniMapper,
                            ArticoliOrdiniMapper articoliOrdiniMapper,
                            ReportService servizio) {
        this.servizioOrdini = servizioOrdini;
        this.menuMapper = menuMapper;
        this.ordiniMapper = ordiniMapper;
        this.articoliOrdiniMapper = articoliOrdiniMapper;
        this.servizio = servizio;
    }

    @RequestMapping(value = "/report/ordini", method = RequestMethod.GET)
    public String ordini(){
        return servizio.getReportOrdini();
    }

    @RequestMapping(value = "/report/incassi", method = RequestMethod.GET)
    public String incassi()
    {
        return servizio.getReportIncassi();
    }

    @GetMapping("/report/focacce")
    public String foccace(){
        return servizio.getReportFocacce();
    }


    @RequestMapping(value = "/report/sogliaordini", method = RequestMethod.GET)
    public String sogliaordini(@RequestParam int soglia){
        return servizio.getReportSogliaOrdini(soglia);
    }

    @RequestMapping(value = "/change/changemenu", method = RequestMethod.POST)
    public Menu changeMenu(@RequestBody Menu menu){
        menuMapper.update(menu);
        return menu;
    }

    @RequestMapping(value = "/insert/ordine", method = RequestMethod.POST)
    public Ordini insertTheNewOrder(@RequestBody RquestOrdine richiestaOrdine){
        return servizioOrdini.sendOrder(richiestaOrdine);
    }

    @RequestMapping(value = "order/delete/id/{id}", method = RequestMethod.GET)
    public int deleteOrderById(@PathVariable("id") int id ){
        return servizioOrdini.deleteOrder(id);
    }

    @RequestMapping(value = "order/delete/date/{date}", method = RequestMethod.GET)
    public int deleteOrderByDate(@PathVariable("date") Date data){
        return servizioOrdini.deleteOrderByData(data);
    }

    @RequestMapping(value = "/order/get/{id}", method = RequestMethod.GET)
    public List<ResponseOrdineDAO> gerListOrderById(@PathVariable("id") int id){
        return servizioOrdini.getOrderListForId(id);
    }

}
