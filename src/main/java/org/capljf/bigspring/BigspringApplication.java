package org.capljf.bigspring;

import org.capljf.bigspring.dao.CustomerRepository;
import org.capljf.bigspring.dto.Customer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.annotation.Resource;

@SpringBootApplication
@EnableJpaRepositories
public class BigspringApplication implements ApplicationRunner {
	@Resource
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(BigspringApplication.class, args);
	}

	@Override
	@CrossOrigin
	public void run(ApplicationArguments args) throws Exception {
//		customerRepository.save(new Customer("Jack", "Bauer"));
	}
}
