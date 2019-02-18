package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {

	// Here repositories from database

	@PostConstruct
	public void init() {

		// Examples for our application
	}

}
