package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.Menu;

import java.util.List;


public interface MenuService {
    List<Menu> selectAll();

    List<Menu> update(Menu menu, Long id);
}
