package com.example.oracleDbConnectionTest.model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class JavaUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;	
	
	private String email;

	public JavaUser(String email) {
		this.email = email;
	}
}
