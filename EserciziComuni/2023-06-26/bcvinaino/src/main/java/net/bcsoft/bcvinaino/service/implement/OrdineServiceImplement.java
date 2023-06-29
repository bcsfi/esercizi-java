package net.bcsoft.bcvinaino.service.implement;

import net.bcsoft.bcvinaino.dao.ArticoliOrdineDAO;
import net.bcsoft.bcvinaino.dao.OrdineDAO;
import net.bcsoft.bcvinaino.entity.Menu;
import net.bcsoft.bcvinaino.entity.Ordine;
import net.bcsoft.bcvinaino.entity.dettaglio.ArticoliOrdiniCompleto;
import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;
import net.bcsoft.bcvinaino.service.OrdineService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrdineServiceImplement implements OrdineService {
    private final OrdineDAO ordineDAO;
    private final ArticoliOrdineDAO articoliOrdineDAO;

    public OrdineServiceImplement(OrdineDAO ordineDAO, ArticoliOrdineDAO articoliOrdineDAO) {
        this.ordineDAO = ordineDAO;
        this.articoliOrdineDAO = articoliOrdineDAO;
    }


    @Override
    public Ordine insert(OrdineCompleto ordineCompleto) {
        List<ArticoliOrdiniCompleto> articoliOrdineList = ordineCompleto.getArticoliOrdiniList();
        Ordine ordine = new Ordine();

        ordine.setDataOrdine(ordineCompleto.getDataOrdine());
        ordineDAO.insert(ordine);
        Integer idOrdine = ordine.getIdOrdine();

        for(ArticoliOrdiniCompleto articoliNuovi : articoliOrdineList){
            ArticoliOrdiniCompleto articolo = new ArticoliOrdiniCompleto();
            articolo.setIdOrdine(idOrdine);

            Menu menu = articoliNuovi.getMenu();
            articolo.setIdMenu(menu.getIdMenu());

            articoliOrdineDAO.insert(articolo);
        }
        return ordine;
    }

    @Override
    public void deleteOrdinePerId(Integer id) {
        ordineDAO.deleteOrdinePerId(id);

    }


    @Override
    public void deleteOrdinePerData(LocalDate data) {
        List <Integer> idOrdineEliminato = ordineDAO.getOrdiniPerData(data);

        for(Integer i : idOrdineEliminato){
            articoliOrdineDAO.deletePerId(i);
        }
        ordineDAO.deleteOrdinePerData(data);
    }
}
