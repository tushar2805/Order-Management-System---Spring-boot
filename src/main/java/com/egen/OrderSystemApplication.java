package com.egen;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class OrderSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderSystemApplication.class, args);
	}
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(apiDetails());
        
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Order Management API",
				"This API is for Order Management Microservice",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Tushar", "https://tushar2805.github.io/portfolio/", "yusharutd@gmail.com"),
				"API RELEASE",
				"http://",
				Collections.emptyList());
	}
}
