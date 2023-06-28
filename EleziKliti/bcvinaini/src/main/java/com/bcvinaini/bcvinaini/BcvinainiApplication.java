package com.bcvinaini.bcvinaini;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@MapperScan("com.bcvinaini.bcvinaini.mapper")
public class BcvinainiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BcvinainiApplication.class, args);

	}



}
