package net.bcsoft.bcvinainorefactor.service.implementation_service;

import net.bcsoft.bcvinainorefactor.dao.MenuDao;
import net.bcsoft.bcvinainorefactor.entity.Menu;
import net.bcsoft.bcvinainorefactor.service.interface_service.MenuServiceInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImplementation implements MenuServiceInterface
{
    private final MenuDao menuDao;

    public MenuServiceImplementation(MenuDao menuDao)
    {
        this.menuDao = menuDao;
    }

    @Override
    public List<Menu> update (Menu menu, Long idMenu) // prova a spostarla nel controlle (nenache c'è bisogno dell'ecccezione)
    {
        if (!menu.getIdMenu().equals(idMenu)) throw new IllegalArgumentException("menu.getIdMenu != idMenu");
        menuDao.update(menu);
        return menuDao.selectAll();
    }
}
