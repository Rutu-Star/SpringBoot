package com.apiformbuilder.Form_Validation_Builder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.apiformbuilder")
@EnableJpaRepositories(basePackages = "com.apiformbuilder.repo")
@EntityScan("com.apiformbuilder.model")
public class FormValidationBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormValidationBuilderApplication.class, args);
	}

}
