package com.bcvinaini.bcvinaini.controller;

import com.bcvinaini.bcvinaini.dao.ResponseOrdineDAO;
import com.bcvinaini.bcvinaini.dto.RquestOrdine;
import com.bcvinaini.bcvinaini.entity.Ordini;
import com.bcvinaini.bcvinaini.services.OrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Date;
import java.util.List;

public class OrderController {

    private final OrderService servizioOrdini;

    OrderController(OrderService servizioOrdini){
        this.servizioOrdini=servizioOrdini;
    }

    @RequestMapping(value = "/order/delete/id/{id}", method = RequestMethod.GET)
    public int deleteOrderById(@PathVariable("id") int id ){
        return servizioOrdini.deleteOrder(id);
    }

    @RequestMapping(value = "/order/delete/date/{date}", method = RequestMethod.GET)
    public String deleteOrderByDate(@PathVariable("date") Date data){
        return servizioOrdini.deleteOrderByData(data);
    }

    @RequestMapping(value = "/order/get/{id}", method = RequestMethod.GET)
    public List<ResponseOrdineDAO> gerListOrderById(@PathVariable("id") int id){
        return servizioOrdini.getOrderListForId(id);
    }

    @RequestMapping(value = "/insert/ordine", method = RequestMethod.POST)
    public Ordini insertTheNewOrder(@RequestBody RquestOrdine richiestaOrdine){
        return servizioOrdini.sendOrder(richiestaOrdine);
    }

}
