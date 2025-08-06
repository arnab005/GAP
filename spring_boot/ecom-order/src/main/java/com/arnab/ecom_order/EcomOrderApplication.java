package com.arnab.ecom_order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EcomOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomOrderApplication.class, args);
	}

}
