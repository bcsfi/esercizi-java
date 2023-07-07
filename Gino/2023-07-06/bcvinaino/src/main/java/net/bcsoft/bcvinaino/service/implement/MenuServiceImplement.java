package net.bcsoft.bcvinaino.service.implement;

import net.bcsoft.bcvinaino.dao.MenuDAO;
import net.bcsoft.bcvinaino.entity.Menu;
import net.bcsoft.bcvinaino.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImplement implements MenuService {

    private final MenuDAO menuDAO;

    public MenuServiceImplement(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }

    @Override
    public List<Menu> selectAll() {
        return doSelectAll();
    }

    private List<Menu> doSelectAll() {
        return menuDAO.selectAll();
    }

    @Override
    public List<Menu> update(Menu menu, Long id) {
        if (doCheckID(menu, id)) { //TODO Gestione errori
            menuDAO.update(menu);
            return doSelectAll();
        } else {
            return null;
        }
    }





    private Boolean doCheckID(Menu bodyMenu, Long urlID) {
        return bodyMenu.getId() == urlID;
    }
}