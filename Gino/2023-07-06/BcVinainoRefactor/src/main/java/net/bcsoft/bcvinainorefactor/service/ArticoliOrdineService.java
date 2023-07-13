package net.bcsoft.bcvinainorefactor.service;

import net.bcsoft.bcvinainorefactor.dao.ArticoliOrdineDAO;
import net.bcsoft.bcvinainorefactor.entity.ArticoliOrdine;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticoliOrdineService {
    private final ArticoliOrdineDAO articoliOrdineDao;

    public ArticoliOrdineService(ArticoliOrdineDAO articoliOrdineDao) {
        this.articoliOrdineDao = articoliOrdineDao;
    }

    public List<ArticoliOrdine> selectAll() {
        return articoliOrdineDao.selectAll();
    }

    @Transactional
    public void insert(List<ArticoliOrdine> articoli, long idOrdine) {
            articoli.forEach(articolo -> articoliOrdineDao.insert(articolo, idOrdine));
    }

    public void delete(Integer id) {
        articoliOrdineDao.delete(id);
    }
}
