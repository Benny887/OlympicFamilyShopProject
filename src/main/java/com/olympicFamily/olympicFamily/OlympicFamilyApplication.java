package com.olympicFamily.olympicFamily;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.olympicFamily.olympicFamily"})
public class OlympicFamilyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlympicFamilyApplication.class, args);
	}

}
