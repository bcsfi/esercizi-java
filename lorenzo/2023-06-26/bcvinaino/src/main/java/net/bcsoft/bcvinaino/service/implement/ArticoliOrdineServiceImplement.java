package net.bcsoft.bcvinaino.service.implement;

import net.bcsoft.bcvinaino.dao.ArticoliOrdineDAO;
import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import net.bcsoft.bcvinaino.entity.dettaglio.ArticoliOrdiniCompleto;
import net.bcsoft.bcvinaino.service.ArticoliOrdineService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class ArticoliOrdineServiceImplement implements ArticoliOrdineService {

    private final ArticoliOrdineDAO articoliOrdineDAO;

    public ArticoliOrdineServiceImplement(ArticoliOrdineDAO articoliOrdineDAO) {
        this.articoliOrdineDAO = articoliOrdineDAO;
    }

    @Override
    public List<ArticoliOrdine> selectAll() {
        return this.articoliOrdineDAO.selectAll();
    }

    @Override
    public void insert(ArticoliOrdiniCompleto articoliOrdine, Long idOrdine) { //TODO Exception Input
        this.articoliOrdineDAO.insert(articoliOrdine, idOrdine);
    }

    @Override
    public void deleteByIdOrdine(Long idOrdine) { //TODO Exception Input
        this.articoliOrdineDAO.deleteByIdOrdine(idOrdine);
    }

    @Override
    public void deleteByDataOrdine(Date dataOrdine) { //TODO Exception Input
        this.articoliOrdineDAO.deleteByDataOrdine(dataOrdine);
    }
}
