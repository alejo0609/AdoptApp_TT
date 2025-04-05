package com.pruebas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.pruebas.model")  
public class AdoptappApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdoptappApplication.class, args);
	}

}



