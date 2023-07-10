package net.bcsoft.BcVinaino.controller;

import net.bcsoft.BcVinaino.entity.Menu;
import net.bcsoft.BcVinaino.service.MenuService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuRestController {
    private final MenuService menuService;

    public MenuRestController(final MenuService menuService) {
        this.menuService = menuService;
    }

    @PutMapping("/BcVinaino/menu/aggiornaFocaccia")
    public void updateFocaccia(@RequestBody Menu menu) {
        menuService.updateFocaccia(menu);
    }
}