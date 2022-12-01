package com.carrentalapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.carrentalapplication.dto.Admin;
import com.carrentalapplication.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query("select r from Customer r where r.email=?1 and r.password=?2")
	Customer logInCustomer(String email,String password) ;

}
