package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.Menu;
import java.util.List;


public interface MenuService {
    void updateFocaccia(Menu menu);
    List<Menu> selectAll();
}
