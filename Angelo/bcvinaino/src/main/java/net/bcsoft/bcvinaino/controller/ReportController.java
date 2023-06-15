package net.bcsoft.bcvinaino.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {
    @RequestMapping(value= "/focacce", method = RequestMethod.GET )
    public String focaccia() {
        return "focaccia";
    }
    @RequestMapping(value= "/incassi", method = RequestMethod.GET )
    public String incassi() {
        return "incassi";
    }
    @RequestMapping(value= "/ordini", method = RequestMethod.GET )
    public String ordini() {
        return "ordini";
    }
    @RequestMapping(value= "/ordiniThreshold", method = RequestMethod.GET )
    public String ordiniThreshold() {
        return "ordiniThreshold";
    }
}
