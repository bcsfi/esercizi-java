package net.bcsoft.BcVinaino.service.implement;

import net.bcsoft.BcVinaino.dao.ArticoliOrdineDAO;
import net.bcsoft.BcVinaino.entity.ArticoliOrdine;
import net.bcsoft.BcVinaino.entity.dettaglio.ArticoliOrdineCompleto;
import net.bcsoft.BcVinaino.service.ArticoliOrdineService;
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
        return  selectAll();
    }
}