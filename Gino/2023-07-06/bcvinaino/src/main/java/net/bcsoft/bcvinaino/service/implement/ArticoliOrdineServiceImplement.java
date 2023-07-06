package net.bcsoft.bcvinaino.service.implement;

import net.bcsoft.bcvinaino.dao.ArticoliOrdineDAO;
import net.bcsoft.bcvinaino.entity.dettaglio.ArticoliOrdiniCompleto;
import net.bcsoft.bcvinaino.service.ArticoliOrdineService;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class ArticoliOrdineServiceImplement implements ArticoliOrdineService {

    private final ArticoliOrdineDAO articoliOrdineDAO;

    public ArticoliOrdineServiceImplement(ArticoliOrdineDAO articoliOrdineDAO) {
        this.articoliOrdineDAO = articoliOrdineDAO;
    }

    @Override
    public void insert(ArticoliOrdiniCompleto articoliOrdine, Long idOrdine) {
        this.articoliOrdineDAO.insert(articoliOrdine, idOrdine);
    }

    public void deleteByIdOrdine(Long idOrdine) {
        this.articoliOrdineDAO.deleteByIdOrdine(idOrdine);
    }

    public void deleteByDataOrdine(Date dataOrdine) {
        this.articoliOrdineDAO.deleteByDataOrdine(dataOrdine);
    }
}
