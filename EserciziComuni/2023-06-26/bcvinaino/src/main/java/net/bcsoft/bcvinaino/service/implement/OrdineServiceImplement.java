package net.bcsoft.bcvinaino.service.implement;

import net.bcsoft.bcvinaino.dao.OrdineDAO;
import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import net.bcsoft.bcvinaino.entity.Menu;
import net.bcsoft.bcvinaino.entity.Ordine;
import net.bcsoft.bcvinaino.entity.dettaglio.ArticoliOrdineCompleto;
import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;
import net.bcsoft.bcvinaino.service.ArticoliOrdineService;
import net.bcsoft.bcvinaino.service.OrdineService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrdineServiceImplement implements OrdineService {
    private final OrdineDAO ordineDAO;
    private final ArticoliOrdineService articoliOrdineService;

    public OrdineServiceImplement(OrdineDAO ordineDAO, ArticoliOrdineService articoliOrdineService) {
        this.ordineDAO = ordineDAO;
        this.articoliOrdineService = articoliOrdineService;
    }


    @Override
    public Ordine insert(OrdineCompleto ordineCompleto) {
        List<ArticoliOrdineCompleto> articoliOrdineList = ordineCompleto.getArticoliOrdineCompletoList();

        ordineDAO.insert(ordineCompleto);
        Integer idOrdine = ordineCompleto.getIdOrdine();

        for (ArticoliOrdineCompleto articolo : articoliOrdineList) {

            articoliOrdineService.insert(articolo, idOrdine);
        }
        return ordineCompleto;
    }

    @Override
    public void deleteOrdinePerId(Integer id) {
        this.articoliOrdineService.deletePerIdOrdine(id);
        this.ordineDAO.deletePerId(id);
    }

    @Override
    public OrdineCompleto getById(Integer id) {
        return this.ordineDAO.getById(id);
    }

    @Override
    public void deleteOrdinePerData(LocalDate data) {
        List <Integer> idOrdineEliminato = ordineDAO.getOrdiniPerData(data);

        for(Integer idOrdine : idOrdineEliminato){
            articoliOrdineService.deletePerIdOrdine(idOrdine);
            ordineDAO.deletePerId(idOrdine);
        }
    }
}
