package com.kgisl.springmd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class SpringmdApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmdApplication.class, args);
	}

}
