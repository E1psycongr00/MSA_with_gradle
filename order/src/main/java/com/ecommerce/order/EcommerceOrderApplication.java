package com.ecommerce.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EcommerceOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceOrderApplication.class, args);
	}

}
