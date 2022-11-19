package com.kgisl.sb1;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class Sb1Application {

	public static void main(String[] args) {
		SpringApplication.run(Sb1Application.class, args);
	}

}
