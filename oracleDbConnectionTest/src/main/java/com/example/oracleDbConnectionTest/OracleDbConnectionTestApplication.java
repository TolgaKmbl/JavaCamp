package com.example.oracleDbConnectionTest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.oracleDbConnectionTest.model.Customer;
import com.example.oracleDbConnectionTest.repository.CustomerDao;

@SpringBootApplication
public class OracleDbConnectionTestApplication implements CommandLineRunner{
	
	private final CustomerDao customerDao;

	public OracleDbConnectionTestApplication(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(OracleDbConnectionTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer1 = customerDao.save(new Customer("emailString", "tolga","123456"));
		
		System.out.println(customer1);
		
	}

}
