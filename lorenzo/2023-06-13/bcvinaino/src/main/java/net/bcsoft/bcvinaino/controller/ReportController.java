package net.bcsoft.bcvinaino.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    @RequestMapping(value = "/report/incassi", method = RequestMethod.GET)
    public void incassi() {
    }

    @RequestMapping(value = "/report/focacce", method = RequestMethod.GET)
    public void focacce() {
    }

    @RequestMapping(value = "/report/ordini", method = RequestMethod.GET)
    public void ordini() {
    }

    @RequestMapping(value = "/report/soglia", method = RequestMethod.GET)
    public void soglia() {
    }
}
