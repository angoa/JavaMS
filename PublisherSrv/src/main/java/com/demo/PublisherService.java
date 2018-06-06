package com.demo;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PublisherService {
	protected Logger logger = Logger.getLogger(PublisherService.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(PublisherService.class, args);
	}

}
