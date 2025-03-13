package com.ecommerce.ECommerceWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.ecommerce")
@EnableJpaRepositories(basePackages = "com.ecommerce.repo")
@EntityScan("com.ecommerce.entity")
public class ECommerceWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceWebApplication.class, args);
	}

}
