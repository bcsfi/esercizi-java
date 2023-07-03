package net.bcsoft.bcvinaino.service.implement;

import net.bcsoft.bcvinaino.dao.ArticoliOrdineDAO;
import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import net.bcsoft.bcvinaino.service.ArticoliOrdineService;
import org.springframework.stereotype.Service;

@Service
public class ArticoliOrdineServiceImplement implements ArticoliOrdineService {

    private final ArticoliOrdineDAO articoliOrdineDAO;

    public ArticoliOrdineServiceImplement(ArticoliOrdineDAO articoliOrdineDAO) {
        this.articoliOrdineDAO = articoliOrdineDAO;
    }

    @Override
    public void insert(ArticoliOrdine articoliOrdine, long idOrdine) {
        this.articoliOrdineDAO.insert(articoliOrdine, idOrdine);
    }
}
