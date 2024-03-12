package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class TranslatorApi3Application {

	public static void main(String[] args) {
		SpringApplication.run(TranslatorApi3Application.class, args);
	}

}
