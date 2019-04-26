package org.capljf.bigspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BigspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BigspringApplication.class, args);
	}

}
