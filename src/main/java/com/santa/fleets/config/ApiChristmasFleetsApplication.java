package com.santa.fleets.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.santa.fleets.util.Constants;

@SpringBootApplication
@ComponentScan({ Constants.BASE_PACKAGE })
public class ApiChristmasFleetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiChristmasFleetsApplication.class, args);
	}

}
