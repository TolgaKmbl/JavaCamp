package com.example.oracleDbConnectionTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.oracleDbConnectionTest.model.Customer;
import com.example.oracleDbConnectionTest.repository.CustomerDao;

@SpringBootApplication
public class OracleDbConnectionTestApplication implements CommandLineRunner{
	
	@Autowired
	private ApplicationContext appContext;
	
	private final CustomerDao customerDao;

	public OracleDbConnectionTestApplication(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(OracleDbConnectionTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer1 = customerDao.save(new Customer("emailString", "tolga","12345123"));
		Customer customer2 = customerDao.save(new Customer("emailString2", "ceren","55123123"));
		
		System.out.println(customer1);
		System.out.println(customer2);
		
		SpringApplication.exit(appContext, () -> 0);
		
	}

}
