package net.bcsoft.bcvinainorefactor.controller;

import net.bcsoft.bcvinainorefactor.entity.Menu;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/bcvinainorefactor/menu")
public class MenuRestController
{
    private final MenuService menuService;

    public MenuRestController (final MenuService menuService)
    {
        this.menuService = menuService;
    }

    @GetMapping()
    public List<Menu> selectAll ()
    {
        return menuService.selectAll();
    }

    @PutMapping("/{id}")
    public void update (@RequestBody Menu menu)
    {
        menuService.update(menu);
    }
}
