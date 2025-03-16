package com.tshapedcoding.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.tshapedcoding.banking.repository")
public class BankingAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(BankingAppApplication.class, args);
	}
}
