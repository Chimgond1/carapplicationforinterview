package com.carrentalapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.carrentalapplication.dto.Admin;
import com.carrentalapplication.dto.Driver;

public interface DriverRepository extends JpaRepository<Driver, Integer>{

	@Query("select r from Driver r where r.email=?1 and r.password=?2")
	Driver logInDriver(String email,String password) ;

}
