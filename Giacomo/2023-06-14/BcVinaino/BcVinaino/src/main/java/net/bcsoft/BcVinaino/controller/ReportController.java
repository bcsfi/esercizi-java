package net.bcsoft.BcVinaino.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {
    //n metodi, dove n è ilnumero di servlet + annotazioni per ciuscun metodo adotta la sua funzione
    @RequestMapping(value= "/Gino", method = RequestMethod.GET)

    @RequestBody
    public String get() {
        return "viva la pizza";
    }
}
