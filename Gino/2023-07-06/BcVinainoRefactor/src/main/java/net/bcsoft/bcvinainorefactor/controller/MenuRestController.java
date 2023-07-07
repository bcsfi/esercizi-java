package net.bcsoft.bcvinainorefactor.controller;

import net.bcsoft.bcvinainorefactor.entity.Menu;
import net.bcsoft.bcvinainorefactor.service.interface_service.MenuServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bcvinainorefactor/menu")
public class MenuRestController
{
    private final MenuServiceInterface menuService;

    public MenuRestController (final MenuServiceInterface menuService)
    {
        this.menuService = menuService;
    }

    @PutMapping("/{id}")
    // TODO /menu/{id}: Update un item di menu (Nota. Può far comodo un MenuRestController)
    public List<Menu> update (@RequestBody Menu menu, @PathVariable(value = "id") Long idMenu)
    {
        return this.menuService.update(menu, idMenu);
    }
}
