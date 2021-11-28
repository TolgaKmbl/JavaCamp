package com.example.oracleDbConnectionTest.model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@PrimaryKeyJoinColumn(name = "customer_id", referencedColumnName = "id")
public class Customer extends JavaUser{

	private String name;
	
	private String tckno;
	
	private boolean isActive;

	public Customer(String email, String name, String tckno, boolean isActive) {
		super(email);
		this.name = name;
		this.tckno = tckno;
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", tckno=" + tckno + ", isActive=" + isActive + "]";
	}	

	
}
