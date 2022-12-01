package com.carrentalapplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carrentalapplication.dto.Cars;
import com.carrentalapplication.dto.Driver;
import com.carrentalapplication.repository.DriverRepository;

@Repository
public class DriverDao {
	@Autowired
	private DriverRepository driverRepository;
	
	public Driver addDriver(Driver driver  ){
		return driverRepository.save(driver);
		
	}
	/*
	 * Getting admin with the help of admin id 
	 * if it present give admin hole details
	 * if it is not present it return null value
	 */
	public Driver getDriverById(int id){
		 Optional<Driver> driver=driverRepository.findById(id);
		 if(driver.isEmpty()) {
			 return null;
		 }else {
			 return driver.get();
		 }
		
	}
	/*
	 * Removing admin with the help of id
	 * if Id is present it remove Admin it will give admin removed successfully
	 * otherwise Id is not present it return id is not present to remove
	 */
	
	public String removeDriver(int id){
		Driver driver=getDriverById(id);
		if(driver!=null) {
			driverRepository.delete(driver);
			return "driver is removed successfully";
		}else {
			return "no driver data to remove ";
		}
		
	}
	/*
	 * Updating admin details with the help of admin details and id
	 */
	public Driver updateDriver(Driver driver,int id){
		Driver driver2=getDriverById(id);
		if(driver2!=null) {
			if(driver.getDriverId()>0) {
				driver2.setDriverId(driver.getDriverId());
			}else {
				driver2.setDriverId(driver2.getDriverId());
			}
			if(driver.getDriverName()!=null) {
				driver2.setDriverName(driver.getDriverName());
			}else {
				driver2.setDriverName(driver.getDriverName());
			}
			if(driver.getEmail()!=null) {
				driver2.setEmail(driver.getEmail());
			}else {
				driver2.setEmail(driver2.getEmail());
			}
			if(driver.getPassword()!=null) {
				driver2.setPassword(driver.getPassword());
			}else {
				driver2.setPassword(driver2.getPassword());
			}
			if(driver.getDriverPhoneNo()>0) {
				driver2.setDriverPhoneNo(driver.getDriverPhoneNo());
			}else {
				driver2.setDriverPhoneNo(driver2.getDriverPhoneNo());
			}
			if(driver.getDriverGender()!=null) {
				driver2.setDriverGender(driver.getDriverGender());
			}else {
				driver2.setDriverGender(driver2.getDriverGender());
			}
			if(driver.getDriverAddress()!=null) {
				driver2.setDriverAddress(driver.getDriverAddress());
			}else {
				driver2.setDriverAddress(driver2.getDriverAddress());
			}
		}
		return driver2;
		
	}
	/*
	 * 1. LogIn method for Admin
	 *    its take email and password to log in
	 */
	public Driver logInDriver(String email,String password){
		return driverRepository.logInDriver(email, password);
		
	}
	public List<Driver> getAllDriver(){
		return driverRepository.findAll();
				
	}
	

}
