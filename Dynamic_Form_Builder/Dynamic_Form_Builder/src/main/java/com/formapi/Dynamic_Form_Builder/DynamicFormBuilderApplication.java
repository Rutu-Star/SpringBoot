package com.formapi.Dynamic_Form_Builder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = "com.formapi")
@EnableJpaRepositories(basePackages = "com.formapi.repo")
@EntityScan("com.formapi.model")

@EnableAsync

public class DynamicFormBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicFormBuilderApplication.class, args);
	}

}
