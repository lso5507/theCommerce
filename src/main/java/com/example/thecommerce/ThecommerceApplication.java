package com.example.thecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ThecommerceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ThecommerceApplication.class, args);
	}
}

