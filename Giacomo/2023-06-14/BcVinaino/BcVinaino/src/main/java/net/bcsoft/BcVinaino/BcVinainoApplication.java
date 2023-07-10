package net.bcsoft.BcVinaino;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//quando viene avviata l'app il programma va in questo package a cercare componenti:
// @Configuration, @Bean. @Component, @RestController, @Mapper, ...
@ComponentScan(basePackages = {"net.bcsoft.BcVinaino"})
@SpringBootApplication
public class BcVinainoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BcVinainoApplication.class, args);
	}

}