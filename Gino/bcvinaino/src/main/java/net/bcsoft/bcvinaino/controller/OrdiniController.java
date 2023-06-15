package net.bcsoft.bcvinaino.controller;

import net.bcsoft.bcvinaino.dto.InsertDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrdiniController {
    @RequestMapping(value = "/insertordine", method = RequestMethod.POST)
    public void insertOrdine(@RequestBody InsertDto insertDto)
    {

    }
}
