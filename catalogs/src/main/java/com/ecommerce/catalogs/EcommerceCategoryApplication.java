package com.ecommerce.catalogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EcommerceCategoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceCategoryApplication.class, args);
	}

}
