package com.java;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EntityScan(basePackageClasses = { 
		PollingAppApplication.class,
		Jsr310JpaConverters.class 
})
public class PollingAppApplication {

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PollingAppApplication.class, args);
	}

}
