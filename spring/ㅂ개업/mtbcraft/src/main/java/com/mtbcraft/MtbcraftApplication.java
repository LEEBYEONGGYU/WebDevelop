package com.mtbcraft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mtbcraft.config.DataAccessConfig;

@SpringBootApplication
@MapperScan(value = {"com.mtbcraft.mapper"})
public class MtbcraftApplication {

	public static void main(String[] args) {
		SpringApplication.run(MtbcraftApplication.class, args);
	}
	
}
