package net.bcsoft.bcvinaino.service.implement;

import net.bcsoft.bcvinaino.dao.OrdineDAO;
import net.bcsoft.bcvinaino.entity.Ordine;
import net.bcsoft.bcvinaino.entity.dettaglio.ArticoliOrdiniCompleto;
import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;
import net.bcsoft.bcvinaino.exception.IdNotValidException;
import net.bcsoft.bcvinaino.service.ArticoliOrdineService;
import net.bcsoft.bcvinaino.service.MenuService;
import net.bcsoft.bcvinaino.service.OrdineService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class OrdineServiceImplement implements OrdineService {
    private final OrdineDAO ordineDAO;
    private final ArticoliOrdineService articoliOrdineService;
    private final MenuService menuService;

    public OrdineServiceImplement(OrdineDAO ordineDAO,
                                  ArticoliOrdineService articoliOrdineService,
                                  MenuService menuService) {
        this.ordineDAO = ordineDAO;
        this.articoliOrdineService = articoliOrdineService;
        this.menuService = menuService;
    }

    @Override
    public List<Ordine> getAll() {
        return doSelectAll();
    }

    @Override
    public OrdineCompleto get(Long id) {
        if (ordineDAO.select(id) == null) {
            throw new IdNotValidException("Ordine not found");
        } else {
            return ordineDAO.select(id);
        }
    }

    @Override
    public List<Ordine> create(OrdineCompleto ordineCompleto) {
        List<ArticoliOrdiniCompleto> articoliOrdineList = ordineCompleto.getArticoliOrdineCompletoList();
        ordineDAO.insert(ordineCompleto);
        Long idOrdine = ordineCompleto.getId();

        for (ArticoliOrdiniCompleto articolo : ordineCompleto.getArticoliOrdineCompletoList()) {
            articoliOrdineService.insert(articolo, idOrdine);
        }
        return doSelectAll();
    }

    @Override
    public List<Ordine> deleteByID(Long id) { //TODO Exception Input
        articoliOrdineService.deleteByIdOrdine(id);
        ordineDAO.deleteByID(id);
        return doSelectAll();
    }

    @Override
    public List<Ordine> deleteByData(Date data) { //TODO Exception Input
            articoliOrdineService.deleteByDataOrdine(data);
            ordineDAO.deleteByData(data);
            return doSelectAll();
    }

    private List<Ordine> doSelectAll() {
        return ordineDAO.selectAll();
    }

}
