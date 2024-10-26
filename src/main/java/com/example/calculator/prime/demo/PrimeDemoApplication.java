package com.example.calculator.prime.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PrimeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeDemoApplication.class, args);
	}

}
