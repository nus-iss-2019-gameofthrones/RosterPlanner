package com.anitime.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServicesApplication {

	public static void main(String[] args) {
		System.out.println("Starting RosterPlanner.....");
		SpringApplication.run(ServicesApplication.class, args);
		System.out.println("RosterPlanner is started successfully.");
	}

}
