package net.bcsoft.bcvinainorefactor.service;

import net.bcsoft.bcvinainorefactor.dao.OrdineDao;
import net.bcsoft.bcvinainorefactor.entity.Ordine;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class OrdineService
{
    private final OrdineDao ordineDao;

    public OrdineService(OrdineDao ordineDao)
    {
        this.ordineDao = ordineDao;
    }

    public List<Ordine> selectAll ()
    {
        return ordineDao.selectAll();
    }

    public Long insert (Ordine ordine)
    {
        ordineDao.insert(ordine);
        return ordine.getId();
    }
}
