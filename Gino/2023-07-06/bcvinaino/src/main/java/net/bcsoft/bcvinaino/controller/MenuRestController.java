package net.bcsoft.bcvinaino.controller;

import net.bcsoft.bcvinaino.entity.Menu;
import net.bcsoft.bcvinaino.service.MenuService;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/{id}" )
    public List<Menu> update(@RequestBody Menu menu, @PathVariable(value = "id") Long id){
        return menuService.update(menu, id);
    }

}
