package com.example.Prep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class PrepApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrepApplication.class, args);
	}

}
