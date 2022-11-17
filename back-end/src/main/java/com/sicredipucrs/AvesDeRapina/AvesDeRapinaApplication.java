package com.sicredipucrs.AvesDeRapina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@EntityScan(basePackages = { "com.sicredipucrs.AvesDeRapina.dto", "com.sicredipucrs.AvesDeRapina.entities" })
@EnableJpaRepositories(basePackages = { "com.sicredipucrs.AvesDeRapina.repositories" })
@ComponentScan(basePackages = { "com.sicredipucrs.AvesDeRapina.controllers",
		"com.sicredipucrs.AvesDeRapina.services", "com.sicredipucrs.AvesDeRapina.config",
		"com.sicredipucrs.AvesDeRapina.kafka", "com.sicredipucrs.AvesDeRapina.utilities" })
@SpringBootApplication
public class AvesDeRapinaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvesDeRapinaApplication.class, args);
	}

}
