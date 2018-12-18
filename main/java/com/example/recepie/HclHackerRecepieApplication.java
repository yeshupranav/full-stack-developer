package com.example.recepie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HclHackerRecepieApplication {

	public static void main(String[] args) {
		SpringApplication.run(HclHackerRecepieApplication.class, args);
	}

}

