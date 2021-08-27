package com.example.rentalmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan("com.example.rentalmanagement.model")
@ComponentScan(basePackages = {"com.example"})
public class RentalManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalManagementApplication.class, args);
	}

}
