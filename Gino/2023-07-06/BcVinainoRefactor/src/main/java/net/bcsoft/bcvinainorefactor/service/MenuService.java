package net.bcsoft.bcvinainorefactor.service;

import net.bcsoft.bcvinainorefactor.dao.MenuDAO;
import net.bcsoft.bcvinainorefactor.entity.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    private final MenuDAO menuDao;

    public MenuService(MenuDAO menuDao) {
        this.menuDao = menuDao;
    }

    public List<Menu> selectAll() {
        return menuDao.selectAll();
    }

    public void update(Menu menu) {
        menuDao.update(menu);
    }
}
