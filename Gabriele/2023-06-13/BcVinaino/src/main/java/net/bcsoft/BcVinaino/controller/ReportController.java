package net.bcsoft.bcvinaino.controller;


import org.springframework.web.bind.annotation.*;

@RestController
public class ReportController {
    //TODO creare tanti metodi quante servlet avevamo e mettere l'annotazione che si reputa corretta
    @RequestMapping(value = "/focacce/{param1}", method = RequestMethod.GET)
    public String focaccia(){
        return "focaccia";
    }

    @RequestMapping(value = "/incassi", method = RequestMethod.GET )
    public String incassi(){
        return "incassi";
    }

    @RequestMapping(value = "/ordini", method = RequestMethod.GET)
    public String ordini(){
        return "ordini";
    }

    @RequestMapping(value = "/ordinisoglia", method = RequestMethod.GET)
    public String ordiniSoglia(){
        return "ordiniSoglia";
    }

}
