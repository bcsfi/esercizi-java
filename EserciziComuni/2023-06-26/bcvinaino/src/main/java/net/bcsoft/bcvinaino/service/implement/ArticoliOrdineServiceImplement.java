package net.bcsoft.bcvinaino.service.implement;

import net.bcsoft.bcvinaino.dao.ArticoliOrdineDAO;
import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import net.bcsoft.bcvinaino.entity.dettaglio.ArticoliOrdineCompleto;
import net.bcsoft.bcvinaino.service.ArticoliOrdineService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticoliOrdineServiceImplement implements ArticoliOrdineService {
    ArticoliOrdineDAO articoliOrdineDAO;

    public ArticoliOrdineServiceImplement(ArticoliOrdineDAO articoliOrdineDAO) {
        this.articoliOrdineDAO = articoliOrdineDAO;
    }

    @Override
    public void insert(ArticoliOrdineCompleto articoliOrdineCompleto, Integer idOrdine) {
        articoliOrdineDAO.insert(articoliOrdineCompleto, idOrdine);
    }

    @Override
    public void deletePerIdOrdine(Integer id) {
        articoliOrdineDAO.deletePerId(id);
    }

    @Override
    public List<ArticoliOrdine> selectAll() {
        return articoliOrdineDAO.selectAll();
    }
}
