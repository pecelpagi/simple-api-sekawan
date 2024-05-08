package com.example.simpleapisekawan;

import com.example.simpleapisekawan.storage.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SimpleApiSekawanApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleApiSekawanApplication.class, args);
	}

}
