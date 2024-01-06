package com.examen.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArteVivoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArteVivoAppApplication.class, args);
		
		System.out.println("Bienvenidos a Arte Viva app");
	}

}
