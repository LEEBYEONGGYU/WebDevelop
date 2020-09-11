package com.busyvacation.happyclass;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.busyvacation.happyclass.config.StorageConfig;
import com.busyvacation.happyclass.db.service.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageConfig.class)
public class HappyclassApplication {

	public static void main(String[] args) {
		SpringApplication.run(HappyclassApplication.class, args);
	}
@Bean
CommandLineRunner init(StorageService storageService) {
	return (args) -> {
		storageService.deleteAll();
		storageService.init();
		};
}
}


