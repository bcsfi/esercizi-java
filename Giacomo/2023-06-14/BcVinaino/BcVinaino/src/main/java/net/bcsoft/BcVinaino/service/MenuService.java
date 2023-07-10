package net.bcsoft.BcVinaino.service;

import net.bcsoft.BcVinaino.entity.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuService {
    void updateFocaccia(Menu menu);
    List<Menu> selectAll();

}
