package net.bcsoft.bcvinaino;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"net.bcsoft.bcvinaino"})
@SpringBootApplication
@MapperScan(basePackages = {"net.bcsoft.bcvinaino.mapper"})
public class BcvinainoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BcvinainoApplication.class, args);
	}

}
