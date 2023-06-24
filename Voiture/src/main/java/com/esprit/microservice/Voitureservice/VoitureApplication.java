package com.esprit.microservice.Voitureservice;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class VoitureApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoitureApplication.class, args);
	}
	
	 @Bean
	    ApplicationRunner init(VoitureRepository repository) {
	        return args -> {
	            Stream.of("citroen", "mercedes", "kia").forEach(type -> {
	                repository.save(new Voiture(type));
	            });
	            repository.findAll().forEach(System.out::println);
	        };
	    }

}
