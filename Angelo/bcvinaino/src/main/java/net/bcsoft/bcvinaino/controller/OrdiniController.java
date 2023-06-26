package net.bcsoft.bcvinaino.controller;

import net.bcsoft.bcvinaino.dtos.InsertDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdiniController {
    @RequestMapping(value = "/insertordine", method = RequestMethod.POST)
    public String insertOrdine(@RequestBody InsertDTO insertDTO) {
        return "insert";
    }
}