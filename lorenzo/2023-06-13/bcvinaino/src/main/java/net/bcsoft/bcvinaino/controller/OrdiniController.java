package net.bcsoft.bcvinaino.controller;

import net.bcsoft.bcvinaino.dto.InsertDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdiniController {
    @RequestMapping(value = "/ordine/insert", method = RequestMethod.POST)
    public String insertOrdine(@RequestParam InsertDto insertDto) {
        return "Get some Foos";
    }
}
