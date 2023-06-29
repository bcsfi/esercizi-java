package com.bcvinaini.bcvinaini.services;

import com.bcvinaini.bcvinaini.dao.ResponseOrdineDAO;
import com.bcvinaini.bcvinaini.dto.ArticoliInOrdine;
import com.bcvinaini.bcvinaini.dto.RquestOrdine;
import com.bcvinaini.bcvinaini.entity.ArticoliOrdine;
import com.bcvinaini.bcvinaini.entity.Menu;
import com.bcvinaini.bcvinaini.entity.Ordini;
import com.bcvinaini.bcvinaini.mapper.MapperNoXML.ArticoliOrdiniMapper;
import com.bcvinaini.bcvinaini.mapper.MapperNoXML.MenuMapper;
import com.bcvinaini.bcvinaini.mapper.MapperNoXML.OrdiniMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;


@Service
public class OrderService {

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    OrdiniMapper ordiniMapper;

    @Autowired
    ArticoliOrdiniMapper articoliOrdiniMapper;


    public Ordini sendOrder(RquestOrdine richiestaOrdine) {

        List<ArticoliInOrdine> listaArticoli = richiestaOrdine.getListaArticoli();
        Ordini ordine = new Ordini();

        ordine.setData(richiestaOrdine.getData());
        ordiniMapper.insert(ordine);
        System.out.print("Ordine inserito \n");

        int idOrdine = ordine.getId();

        for(ArticoliInOrdine articoliNuovi : listaArticoli){

            ArticoliOrdine articolo = new ArticoliOrdine();
            articolo.setIdOrdine(idOrdine);

            Menu menu = articoliNuovi.getMenu();
            articolo.setIdMenu(menu.getId());

            articoliOrdiniMapper.insert(articolo);
            System.out.print("Articolo Inserito \n");
        }
        return ordine;
    }

    public int deleteOrder(int OrderIdToDelate) {
        return ordiniMapper.deleteAllOrderById(OrderIdToDelate);
    }

    public String deleteOrderByData(Date data) {
        String status = "";

        List<Integer> idOrdineEliminato = ordiniMapper.getIdOrderByData(data);

        for(Integer i : idOrdineEliminato){
            ordiniMapper.deleteArticoliById(i);
        }

        int res = ordiniMapper.deleteOrderByData(data);

        if(res > 0){
            status = "Eliminazione dei dei ordini e dei articoli andata a buon fine.";
        } else {
            status = "Errore, eliminazione non possibile";
        }

        return status;
}

    public List<ResponseOrdineDAO> getOrderListForId(int id){
        return ordiniMapper.recoverOrderListForId(id);
    }

}
