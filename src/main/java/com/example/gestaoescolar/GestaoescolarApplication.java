package com.example.gestaoescolar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GestaoescolarApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoescolarApplication.class, args);
	}

}
