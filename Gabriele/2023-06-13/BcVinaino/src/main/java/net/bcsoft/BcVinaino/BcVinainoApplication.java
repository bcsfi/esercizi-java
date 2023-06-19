package net.bcsoft.bcvinaino;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"net.bcsoft.bcvinaino.mapper"}) //quando viene avviata l'app il programma va in questo package a cercare mybetis
public class BcVinainoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BcVinainoApplication.class, args);
	}

}