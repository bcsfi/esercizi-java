package net.bcsoft.bcvinaino.controller;

import net.bcsoft.bcvinaino.entity.InsertDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdiniController {
    @RequestMapping(value = "/ordine/insertordine", method = RequestMethod.POST)
    public void insertOrdine(@RequestParam InsertDto insertDto) {}
}
