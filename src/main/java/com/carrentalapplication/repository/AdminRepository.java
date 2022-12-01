package com.carrentalapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.carrentalapplication.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	@Query("select r from Admin r where r.email=?1 and r.password=?2")
	Admin logInAdmin(String email,String password) ;

}
