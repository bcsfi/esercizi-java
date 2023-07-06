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

    @Override
    public List<Menu> update(Menu menu, Long id) {
        if (checkId(menu, id)) {
            menuDAO.update(menu);
            return doSelectAll();
        }
        return null;
    }

    private Boolean checkId(Menu menu, Long id)
    {
        return menu.getId() == id;
    }

    private List<Menu> doSelectAll() {
        return menuDAO.selectAll();
    }
}
