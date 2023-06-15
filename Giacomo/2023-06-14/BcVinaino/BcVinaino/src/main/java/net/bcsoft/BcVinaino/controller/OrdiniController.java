package net.bcsoft.BcVinaino.controller;

import org.springframework.web.bind.annotation.RestController;
import net.bcsoft.BcVinaino.controller.dto.InsertDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrdiniController {
    @RequestMapping(value= "/Vinaino", method = RequestMethod.POST)
    public String ordini(@RequestParam InsertDto insertDto) {
        return "viva la pizza";
    }
}
