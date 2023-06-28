package net.bcsoft.bcvinaino.service.implement;

import net.bcsoft.bcvinaino.dao.MenuDAO;
import net.bcsoft.bcvinaino.entity.Menu;
import net.bcsoft.bcvinaino.service.MenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImplement implements MenuService {

    private final MenuDAO menuDAO;

    public MenuServiceImplement(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }

    public void updateFocaccia(Menu menu){
        menuDAO.updateFocaccia(menu);
    }
}
