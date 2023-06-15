package net.bcsoft.bcvinaino;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"net.bcsoft.bcvinaino.mapper"}) //all'avvio lancia spring e attiva i mapper
public class BcVinainoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BcVinainoApplication.class, args);
	}

}
