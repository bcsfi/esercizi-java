package net.bcsoft.bcvinaino.controller;

import net.bcsoft.bcvinaino.entity.Menu;
import net.bcsoft.bcvinaino.service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bcvinaino/menu")
public class MenuRestController {
    private final MenuService menuService;

    public MenuRestController(final MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping()
    public List<Menu> selectAll(){
        return menuService.selectAll();
    }
    @PutMapping("/{id}")
    public List<Menu> update(@RequestBody Menu menu){
        return menuService.update(menu);
    }

}
