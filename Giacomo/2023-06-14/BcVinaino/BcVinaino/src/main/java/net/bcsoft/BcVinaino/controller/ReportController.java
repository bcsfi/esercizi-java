package net.bcsoft.BcVinaino.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ReportController {

    @RequestMapping(value= "Report/Incassi", method = RequestMethod.GET)
    public String incassi (){
        return "incassi ";
    }

    @RequestMapping(value= "Report/ordini", method = RequestMethod.GET)
    public String ordini (){
        return "ordini ";
    }


    @RequestMapping(value= "Report/sogliaordini", method = RequestMethod.GET)
    public String sogliaOrdini (){
        return "soglia ordini";
    }


    @RequestMapping(value= "Report/focacce", method = RequestMethod.GET)
    public String focacce (){
        return "focacce";
    }
    }

