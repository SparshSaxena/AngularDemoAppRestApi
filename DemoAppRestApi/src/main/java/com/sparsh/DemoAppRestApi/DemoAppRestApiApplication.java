package com.sparsh.DemoAppRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DemoAppRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAppRestApiApplication.class, args);
	}
}
