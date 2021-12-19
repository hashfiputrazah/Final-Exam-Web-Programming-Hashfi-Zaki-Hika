package com.springboot_tiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class MainApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/e_library");
		SpringApplication.run(MainApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MainApplication.class);
	}
}
