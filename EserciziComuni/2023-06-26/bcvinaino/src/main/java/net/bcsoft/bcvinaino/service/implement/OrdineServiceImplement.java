package net.bcsoft.bcvinaino.service.implement;

import net.bcsoft.bcvinaino.dao.OrdineDAO;
import net.bcsoft.bcvinaino.entity.dettaglio.ArticoliOrdiniCompleto;
import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;
import net.bcsoft.bcvinaino.service.ArticoliOrdineService;
import net.bcsoft.bcvinaino.service.OrdineService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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


//    @Override
//    public List<Ordine> insert(OrdineCompleto ordineCompleto) {
//        ordineDAO.insert(ordineCompleto);
//        Long idOrdine = ordineCompleto.getIdOrdine();
//
//        for(ArticoliOrdiniCompleto articolo : ordineCompleto.getArticoliOrdiniList()){
//
//            long id_ordine;
//            articoliOrdineService.insert(articolo, idOrdine);
//        }
//        return ordine;
//    }

    @Override
    public void deleteOrdineByID(Long id){
        ordineDAO.deleteByID(id);
    }

    @Override
    public void deleteOrdineByData(LocalDate data){
        ordineDAO.deleteByData(data);
    }

    @Override
    public List<OrdineCompleto> inserisci(OrdineCompleto ordineCompleto) {
        //inserire l'ordine -> ottieni l'id calcolato a db
        //inserire OGNI articolo dell'ordine e farlo riferire all'ordine appena creato:
        ordineDAO.insert(ordineCompleto);
        long idOrdine = ordineCompleto.getIdOrdine();
        for (ArticoliOrdiniCompleto articolo : ordineCompleto.getArticoliOrdiniList()) {
            articoliOrdineService.insert(articolo, idOrdine);
        }
        return null;
    }
}
