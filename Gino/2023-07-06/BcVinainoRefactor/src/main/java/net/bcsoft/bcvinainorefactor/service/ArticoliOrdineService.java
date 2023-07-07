package net.bcsoft.bcvinainorefactor.service;

import net.bcsoft.bcvinainorefactor.dao.ArticoliOrdineDao;
import net.bcsoft.bcvinainorefactor.entity.ArticoliOrdine;
import net.bcsoft.bcvinainorefactor.dto.ArticoliOrdineDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class ArticoliOrdineService
{
    private final ArticoliOrdineDao articoliOrdineDao;

    public ArticoliOrdineService(ArticoliOrdineDao articoliOrdineDao)
    {
        this.articoliOrdineDao = articoliOrdineDao;
    }

    public List<ArticoliOrdine> selectAll ()
    {
        return articoliOrdineDao.selectAll();
    }

    public void insert (ArticoliOrdineDto articoliOrdineDto)
    {
        articoliOrdineDao.insert(articoliOrdineDto);
    }
}
