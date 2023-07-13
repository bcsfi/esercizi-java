package net.bcsoft.bcvinainorefactor.service;

import net.bcsoft.bcvinainorefactor.dao.OrdineDAO;
import net.bcsoft.bcvinainorefactor.entity.Ordine;
import net.bcsoft.bcvinainorefactor.entity.dettaglio.OrdineCompleto;
import net.bcsoft.bcvinainorefactor.exception.FormatoSbagliatoEccezione;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdineService {
    private final OrdineDAO ordineDao;
    private final ArticoliOrdineService articoliOrdineService;

    public OrdineService(OrdineDAO ordineDao, ArticoliOrdineService articoliOrdineService) {
        this.ordineDao = ordineDao;
        this.articoliOrdineService = articoliOrdineService;
    }

    private List<Ordine> doGetAll() {
        return ordineDao.selectAll();
    }

    public List<Ordine> selectAll() {
        return doGetAll();
    }

    public List<Ordine> insert(OrdineCompleto ordine) {
        ordineDao.insert(ordine);
        this.articoliOrdineService.insert(ordine.getArticoli(), ordine.getId());
        return this.doGetAll();
    }

    public void deleteById(Integer id) {
        articoliOrdineService.delete(id);
        ordineDao.deleteById(id);
    }

    public OrdineCompleto selectOrdineCompleto(Integer id){
        return ordineDao.selectOrdineCompleto(id);
    }
}
