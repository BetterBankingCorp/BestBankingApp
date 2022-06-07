package com.account.bestbankingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class BestBankingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestBankingAppApplication.class, args);
	}

}
