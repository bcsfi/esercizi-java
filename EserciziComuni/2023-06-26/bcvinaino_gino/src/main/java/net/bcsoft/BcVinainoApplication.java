package net.bcsoft;

import net.bcsoft.bcvinaino.entity.Ordine;
import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;
import net.bcsoft.bcvinaino.service.OrdineService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan(basePackages = {"net.bcsoft.bcvinaino"})
@SpringBootApplication //quando viene avviata l'app il programma va in questo package a cercare mybetis
public class BcVinainoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BcVinainoApplication.class, args);
    }

}
