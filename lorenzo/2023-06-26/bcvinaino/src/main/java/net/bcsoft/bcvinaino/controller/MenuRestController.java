package net.bcsoft.bcvinaino.controller;

import net.bcsoft.bcvinaino.entity.Menu;
import net.bcsoft.bcvinaino.exception.IdNotValidException;
import net.bcsoft.bcvinaino.service.MenuService;
import net.bcsoft.bcvinaino.validation.InputValidation;
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
    public List<Menu> getAll() {
        return menuService.getAll();
    }

    @PutMapping("/{id}")
    public List<Menu> update(@RequestBody Menu menu, @PathVariable(value = "id") Long id) {
        Long validId = InputValidation.idIsValid(id);
        if (menu.getId() != id) { throw new IdNotValidException("Body ID and Path ID is different"); };
        return menuService.update(menu, validId);
    }
}
