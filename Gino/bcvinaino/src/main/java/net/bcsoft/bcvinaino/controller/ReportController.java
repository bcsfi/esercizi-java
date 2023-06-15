package net.bcsoft.bcvinaino.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController
{
    @RequestMapping(value = "/vinaino", method = RequestMethod.GET)
    public String home()
    {
        return "/focacce\n/incassi\n/ordini\n/sogliaOrdini";
    }

    @RequestMapping(value = "/vinaino/focacce", method = RequestMethod.GET)
    public String focacce()
    {
        return "focacce";
    }

    @RequestMapping(value = "/vinaino/incassi", method = RequestMethod.GET)
    public String incassi()
    {
        return "incassi";
    }

    @RequestMapping(value = "/vinaino/ordini", method = RequestMethod.GET)
    public String ordini()
    {
        return "ordini";
    }


    @RequestMapping(value = "/vinaino/sogliaordini", method = RequestMethod.GET)
    public String sogliaOrdini()
    {
        return "sogliaOrdini";
    }
}
