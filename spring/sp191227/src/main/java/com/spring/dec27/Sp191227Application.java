package com.spring.dec27;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.dec27.service.StorageService;

@SpringBootApplication
public class Sp191227Application {

	public static void main(String[] args) {
		SpringApplication.run(Sp191227Application.class, args);
	}
	
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}

}
