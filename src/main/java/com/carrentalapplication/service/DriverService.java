package com.carrentalapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.carrentalapplication.dao.DriverDao;
import com.carrentalapplication.dto.Admin;
import com.carrentalapplication.dto.Driver;
import com.carrentalapplication.dto.ResponseStructure;
import com.carrentalapplication.exception.EnterPasswordOrEmailIsWorgException;
import com.carrentalapplication.exception.InvalidIdException;

@Service
public class DriverService {
	@Autowired
	private DriverDao driverDao;
	
	public ResponseEntity<ResponseStructure<Driver>> addDriver(Driver driver){
		ResponseStructure<Driver> responseStructure=new ResponseStructure<Driver>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Driver saved successfully into application");
		responseStructure.setData(driverDao.addDriver(driver));
		return new ResponseEntity<ResponseStructure<Driver>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Driver>> getDriveryId(int id){
		ResponseStructure<Driver> responseStructure=new ResponseStructure<Driver>();

		if (driverDao.getDriverById(id)!= null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Driver Details getting successfully from the application");
			responseStructure.setData(driverDao.getDriverById(id));
			
		}else {
			throw new InvalidIdException("Enter id is wrong mention valid id");
		}
		return new ResponseEntity<ResponseStructure<Driver>>(responseStructure,HttpStatus.OK);
 
		
	}
	
	public ResponseEntity<ResponseStructure<String>> removeDriver(int id){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		if (driverDao.removeDriver(id)!= null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Driver removed successfully from the application");
			responseStructure.setData(driverDao.removeDriver(id));
			
		}else {
			throw new InvalidIdException("Enter id is wrong mention valid id");
		}
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);

	}
	
	public ResponseEntity<ResponseStructure<Driver>> updateDriver(Driver driver,int id){
		ResponseStructure<Driver> responseStructure=new ResponseStructure<Driver>();
		if (driverDao.getDriverById(id) != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Driver updated successfully from the application");
			responseStructure.setData(driverDao.updateDriver(driver,id));
			
		}
		else {
			throw new InvalidIdException("Enter id is wrong mention valid id");
		}
		return new ResponseEntity<ResponseStructure<Driver>>(responseStructure,HttpStatus.OK);

		
	}
	
	public ResponseEntity<ResponseStructure<Driver>> logInDrivern(String email,String password){
		ResponseStructure<Driver> responseStructure=new ResponseStructure<Driver>();
		Driver driver = driverDao.logInDriver(email, password);
		if (driver != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Driver Log In successfully into the application");
			responseStructure.setData(driverDao.logInDriver(email,password));
			
		}else {
			throw new EnterPasswordOrEmailIsWorgException("Enter valid email and password");
		}
		return new ResponseEntity<ResponseStructure<Driver>>(responseStructure,HttpStatus.OK);

	}
	public ResponseEntity<ResponseStructure<List<Driver>>> getAllDriver() {
		ResponseEntity<ResponseStructure<List<Driver>>> responseEntity=null;
		ResponseStructure<List<Driver>> responseStructure = new ResponseStructure<List<Driver>>();
		List<Driver> drivers=driverDao.getAllDriver();
		if(drivers!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(drivers);
			responseEntity=new ResponseEntity<ResponseStructure<List<Driver>>>(responseStructure,HttpStatus.OK);
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage(" not success");
			responseStructure.setData(null);
			 responseEntity= new ResponseEntity<ResponseStructure<List<Driver>>> (responseStructure,HttpStatus.NOT_FOUND);
		
		}
		return responseEntity;
		
	}

}
