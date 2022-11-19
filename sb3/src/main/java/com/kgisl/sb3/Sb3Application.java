package com.kgisl.sb3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
@OpenAPIDefinition
@SpringBootApplication
public class Sb3Application {

	public static void main(String[] args) {
		SpringApplication.run(Sb3Application.class, args);
	}

}
