package com.bcvinaini.bcvinaini.controller;

import com.bcvinaini.bcvinaini.entity.Menu;
import com.bcvinaini.bcvinaini.services.UpdateService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class UpdateController {

    private final UpdateService updateService;

    UpdateController(UpdateService updateService){
        this.updateService=updateService;
        
    }

    @RequestMapping(value = "/update/changemenu", method = RequestMethod.POST)
    public Menu changeMenu(@RequestBody Menu menu){
        updateService.changeMenu(menu);
        return menu;
    }

}
