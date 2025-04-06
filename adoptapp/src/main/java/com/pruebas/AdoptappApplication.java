package com.pruebas.adoptapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackages = "com.pruebas")
@EntityScan(basePackages = "com.pruebas.model")
@EnableJpaRepositories(basePackages = "com.pruebas.repository")
public class AdoptappApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdoptappApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
