package net.bcsoft.bcvinainorefactor.service.interface_service;

import net.bcsoft.bcvinainorefactor.entity.Menu;

import java.util.List;

public interface MenuServiceInterface
{
    List<Menu> update (Menu menu, Long idMenu);
}
