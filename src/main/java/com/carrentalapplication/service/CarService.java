package com.carrentalapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.carrentalapplication.dao.CarsDao;
import com.carrentalapplication.dto.Admin;
import com.carrentalapplication.dto.Cars;
import com.carrentalapplication.dto.ResponseStructure;
import com.carrentalapplication.exception.InvalidIdException;

@Service
public class CarService {
	@Autowired
	private CarsDao carsDao;
	
	
	public ResponseEntity<ResponseStructure<Cars>> addCar(Cars cars){
		ResponseStructure<Cars> responseStructure=new ResponseStructure<Cars>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Car saved successfully into application");
		responseStructure.setData(carsDao.addCars(cars));
		return new ResponseEntity<ResponseStructure<Cars>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Cars>> getCarById(int id){
		ResponseStructure<Cars> responseStructure=new ResponseStructure<Cars>();

		if (carsDao.getCarsById(id) != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Car Details getting successfully from the application");
			responseStructure.setData(carsDao.getCarsById(id));
			
		}
		else {
			throw new InvalidIdException("Enter id is wrong mention valid id");
		}
		return new ResponseEntity<ResponseStructure<Cars>>(responseStructure,HttpStatus.OK);
 
		
	}
	
	public ResponseEntity<ResponseStructure<String>> removeCar(int id){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		if (carsDao.removeCars(id) != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Car removed successfully from the application");
			responseStructure.setData(carsDao.removeCars(id));
			
		}else {
			throw new InvalidIdException("Enter id is wrong mention valid id");
		}
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);

	}
	
	public ResponseEntity<ResponseStructure<Cars>> updateCar(Cars cars,int id){
		ResponseStructure<Cars> responseStructure=new ResponseStructure<Cars>();
		if (carsDao.getCarsById(id) != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Car updated successfully from the application");
			responseStructure.setData(carsDao.updateCars(cars,id));
			
		}else {
			throw new InvalidIdException("Enter id is wrong mention valid id");
		}
		return new ResponseEntity<ResponseStructure<Cars>>(responseStructure,HttpStatus.OK);

		
	}
	

	public ResponseEntity<ResponseStructure<List<Cars>>> getAllCars() {
		ResponseEntity<ResponseStructure<List<Cars>>> responseEntity=null;
		ResponseStructure<List<Cars>> responseStructure = new ResponseStructure<List<Cars>>();
		List<Cars> cars=carsDao.getAllCars();
		if(cars!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(cars);
			responseEntity=new ResponseEntity<ResponseStructure<List<Cars>>>(responseStructure,HttpStatus.OK);
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage(" not success");
			responseStructure.setData(null);
			 responseEntity= new ResponseEntity<ResponseStructure<List<Cars>>> (responseStructure,HttpStatus.NOT_FOUND);
		
		}
		return responseEntity;
		
	}

}
