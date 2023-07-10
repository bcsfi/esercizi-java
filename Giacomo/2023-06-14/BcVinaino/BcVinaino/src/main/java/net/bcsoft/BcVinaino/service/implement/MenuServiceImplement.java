package net.bcsoft.BcVinaino.service.implement;

import net.bcsoft.BcVinaino.dao.MenuDAO;
import net.bcsoft.BcVinaino.entity.Menu;
import net.bcsoft.BcVinaino.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImplement implements MenuService {

    private final MenuDAO menuDAO;

    public MenuServiceImplement(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }
    @Override
    public void updateFocaccia(Menu menu){
        menuDAO.updateFocaccia(menu);
    }

    @Override
    public List<Menu> selectAll() {
        return menuDAO.selectAll();
    }
}