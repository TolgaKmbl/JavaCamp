package com.example.oracleDbConnectionTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.oracleDbConnectionTest.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

}
