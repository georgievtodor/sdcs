package com.musala.sdcs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Startup {
	private static final String LOGGER_INFO_MESSAGE = "Application Started";

	public static void main(String[] args) {

		SpringApplication.run(Startup.class, args);
		
		Logger logger = LoggerFactory.getLogger(Startup.class);
		logger.info(LOGGER_INFO_MESSAGE);

		
		
	}
} 