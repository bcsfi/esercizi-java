package net.bcsoft.bcvinaino.service.implement;

import net.bcsoft.bcvinaino.dao.MenuDAO;
import net.bcsoft.bcvinaino.entity.Menu;
import net.bcsoft.bcvinaino.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuServiceImplement implements MenuService {

    private final MenuDAO menuDAO;

    public MenuServiceImplement(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }

    @Override
    public List<Menu> getAll() {
        return doSelectAll();
    }

    @Override
    public List<Menu> update(Menu menu, Long id) { //TODO Exception Input
        if (doCheckID(menu, id)) {
            menuDAO.update(menu);
            return doSelectAll();
        } else {
            return null;
        }
    }

    private List<Menu> doSelectAll() {
        return menuDAO.selectAll();
    }

    private Boolean doCheckID(Menu bodyMenu, Long urlID) {
        return bodyMenu.getId() == urlID;
    }
}