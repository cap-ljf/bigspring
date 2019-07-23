package org.capljf.bigspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories
@EnableScheduling
@EnableAsync
@EnableCaching
public class BigspringApplication implements ApplicationRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(BigspringApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BigspringApplication.class, args);
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		LOGGER.info(String.format("test, test=%s", "123123"));
		LOGGER.info("test, test={}", "123123");
	}
}
