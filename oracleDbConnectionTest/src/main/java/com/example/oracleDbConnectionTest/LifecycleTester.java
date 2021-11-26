package com.example.oracleDbConnectionTest;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class LifecycleTester {

	@PostConstruct
	private void postConstruct() {
		System.out.println("Initializing");
	}
	
	@PreDestroy
	private void preDestroy() {
		System.out.println("Shutting down");
	}
}
