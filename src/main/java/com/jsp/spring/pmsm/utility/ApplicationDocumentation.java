package com.jsp.spring.pmsm.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class ApplicationDocumentation {
	@Bean
	Contact contact() {
		return new Contact().name("Ram")
				.url("www.google.com");
				
	}
	
	@Bean
	Info info() {
		return new Info().title("Product Management System")
				.description("RestFul API with basic CRUD operation.")
				.version("ram v1").contact(contact());
	}
	@Bean
	OpenAPI openApi() {
		return new OpenAPI().info(info());
	}
}
