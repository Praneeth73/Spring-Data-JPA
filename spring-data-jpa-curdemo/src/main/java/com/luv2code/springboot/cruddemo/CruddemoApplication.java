package com.luv2code.springboot.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CruddemoApplication {
// this Code is by using Entity Manager but leaverage native hibernate API
	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
}


