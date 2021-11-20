package com.example.oracleDbConnectionTest.model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@PrimaryKeyJoinColumn(name = "customer_id", referencedColumnName = "id")
public class Customer extends JavaUser{

	private String name;
	
	private String tckno;

	public Customer(String email, String name, String tckno) {
		super(email);
		this.name = name;
		this.tckno = tckno;
	}
}
