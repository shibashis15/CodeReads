package com.cartservice.com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CartClientApplication {
	private static final Logger logger = LoggerFactory.getLogger(CartClientApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CartClientApplication.class, args);

	}

}
