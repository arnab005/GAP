package com.arnab.ecom_registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EcomRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomRegistrationApplication.class, args);
	}

}
