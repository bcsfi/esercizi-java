package com.bcvinaini.bcvinaini.services;

import com.bcvinaini.bcvinaini.entity.Menu;
import com.bcvinaini.bcvinaini.mapper.MapperNoXML.MenuMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class UpdateService {

    private final MenuMapper menuMapper;

    UpdateService(MenuMapper menuMapper){
        this.menuMapper=menuMapper;
    }

    @RequestMapping(value = "/update/changemenu", method = RequestMethod.POST)
    public Menu changeMenu(@RequestBody Menu menu){
        menuMapper.update(menu);
        return menu;
    }

}
