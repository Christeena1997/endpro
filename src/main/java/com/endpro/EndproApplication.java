package com.endpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EndproApplication {

	public static void main(String[] args) {
		SpringApplication.run(EndproApplication.class, args);
	}
@Bean
public RestTemplate restTemp() {
	return new RestTemplate();
}
}
