package net.bcsoft.bcvinainorefactor.service;

import net.bcsoft.bcvinainorefactor.dao.MenuDao;
import net.bcsoft.bcvinainorefactor.entity.Menu;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuService implements MenuService
{
    private final MenuDao menuDao;

    public MenuService(MenuDao menuDao)
    {
        this.menuDao = menuDao;
    }

    @Override
    public List<Menu> selectAll ()
    {
        return menuDao.selectAll();
    }

    @Override
    public void update (Menu menu)
    {
        menuDao.update(menu);
    }
}
