package net.bcsoft.bcvinaino.controller;

import net.bcsoft.bcvinaino.entity.Menu;
import net.bcsoft.bcvinaino.service.MenuService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuRestController {
    private final MenuService menuService;

    public MenuRestController(final MenuService menuService) {
        this.menuService = menuService;
    }

    @PutMapping("/bcvinaino/menu/aggiornaFocaccia")
    public void updateFocaccia(@RequestBody Menu menu){
        menuService.updateFocaccia(menu);
    }
}
