package net.bcsoft.bcvinaino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {"net.bcsoft.bcvinaino"})
@SpringBootApplication
public class BcVinainoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BcVinainoApplication.class, args);
    }

}
