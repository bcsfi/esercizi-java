package net.bcsoft.bcvinaino;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"net.bcsoft.bcvinaino"})
@SpringBootApplication //quando viene avviata l'app il programma va in questo package a cercare mybetis
public class BcVinainoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BcVinainoApplication.class, args);
	}

}