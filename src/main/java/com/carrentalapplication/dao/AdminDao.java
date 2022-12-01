package com.carrentalapplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carrentalapplication.dto.Admin;
import com.carrentalapplication.repository.AdminRepository;

@Repository
public class AdminDao {
	
	@Autowired
	private AdminRepository adminRepository;
	
	/*
	 * Adding admin with the help of spring data jpa methods
	 */
	public Admin addAdmin(Admin admin){
		return adminRepository.save(admin);
		
	}
	/*
	 * Getting admin with the help of admin id 
	 * if it present give admin hole details
	 * if it is not present it return null value
	 */
	public Admin getAdminById(int id){
		 Optional<Admin> admin=adminRepository.findById(id);
		 if(admin.isEmpty()) {
			 return null;
		 }else {
			 return admin.get();
		 }
		
	}
	/*
	 * Removing admin with the help of id
	 * if Id is present it remove Admin it will give admin removed successfully
	 * otherwise Id is not present it return id is not present to remove
	 */
	
	public String removeAdmin(int id){
		Admin admin=getAdminById(id);
		if(admin!=null) {
			adminRepository.delete(admin);
			return "admin is removed successfully";
		}else {
			return "no admin data to remove ";
		}
		
	}
	/*
	 * Updating admin details with the help of admin details and id
	 */
	public Admin updateAdmin(Admin admin,int id){
		Admin admin2=getAdminById(id);
		if(admin2!=null) {
			if(admin.getAdminId()>0) {
				admin2.setAdminId(admin.getAdminId());
			}else {
				admin2.setAdminId(admin2.getAdminId());
			}
			if(admin.getAdminName()!=null) {
				admin2.setAdminName(admin.getAdminName());
			}else {
				admin2.setAdminName(admin2.getAdminName());
			}
			if(admin.getEmail()!=null) {
				admin2.setEmail(admin.getEmail());
			}else {
				admin2.setEmail(admin2.getEmail());
			}
			if(admin.getPassword()!=null) {
				admin2.setPassword(admin.getPassword());
			}else {
				admin2.setPassword(admin2.getPassword());
			}
			if(admin.getAdminPhoneNumber()>0) {
				admin2.setAdminPhoneNumber(admin.getAdminPhoneNumber());
			}else {
				admin2.setAdminPhoneNumber(admin2.getAdminPhoneNumber());
			}
		}
		return admin2;
		
	}
	/*
	 * 1. LogIn method for Admin
	 *    its take email and password to log in
	 */
	public Admin logInAdmin(String email,String password){
		return adminRepository.logInAdmin(email, password);
		
	}
	public List<Admin> getAllAdmin(){
		return adminRepository.findAll();
	}
	

}
