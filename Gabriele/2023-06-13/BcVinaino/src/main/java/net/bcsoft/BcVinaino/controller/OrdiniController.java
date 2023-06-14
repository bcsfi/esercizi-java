package net.bcsoft.bcvinaino.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdiniController {
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert() {
        return "insert";
    }
}
