package net.bcsoft.bcvinainorefactor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"net.bcsoft.bcvinainorefactor"})
@SpringBootApplication
public class BcVinainoRefactorApplication {
    public static void main(String[] args) {
        SpringApplication.run(BcVinainoRefactorApplication.class, args);
    }
}
