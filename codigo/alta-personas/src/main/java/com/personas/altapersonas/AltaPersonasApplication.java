package com.personas.altapersonas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.personas.*")
@EnableJpaRepositories("com.personas.*")
@EntityScan("com.personas.*")
public class AltaPersonasApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AltaPersonasApplication.class, args);
	}

}
