package com.carrentalapplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carrentalapplication.dto.Cars;
import com.carrentalapplication.repository.CarsRepository;

@Repository
public class CarsDao {
	@Autowired
	private CarsRepository  carsRepository;
	
	/*
	 * Adding admin with the help of spring data jpa methods
	 */
	public Cars addCars(Cars cars){
		return carsRepository.save(cars);
		
	}
	/*
	 * Getting admin with the help of admin id 
	 * if it present give admin hole details
	 * if it is not present it return null value
	 */
	public Cars getCarsById(int id){
		 Optional<Cars> car=carsRepository.findById(id);
		 if(car.isEmpty()) {
			 return null;
		 }else {
			 return car.get();
		 }
		
	}
	/*
	 * Removing admin with the help of id
	 * if Id is present it remove Admin it will give admin removed successfully
	 * otherwise Id is not present it return id is not present to remove
	 */
	
	public String removeCars(int id){
		Cars cars=getCarsById(id);
		if(cars!=null) {
			carsRepository.delete(cars);
			return "admin is removed successfully";
		}else {
			return "no admin data to remove ";
		}
		
	}
	/*
	 * Updating admin details with the help of admin details and id
	 */
	public Cars updateCars(Cars cars,int id){
		Cars cars2=getCarsById(id);
		if(cars2!=null) {
			if(cars.getId()>0) {
				cars2.setId(cars.getId());
			}else {
				cars2.setId(cars2.getId());
			}
			if(cars2.getCarNo()!=null) {
				cars2.setCarNo(cars.getCarNo());
			}else {
				cars2.setCarNo(cars2.getCarNo());
			}
			if(cars2.getCarType()!=null) {
				cars2.setCarType(cars.getCarType());
			}else {
				cars2.setCarType(cars2.getCarType());
			}
			if(cars.getCarModel()!=null) {
				cars2.setCarModel(cars.getCarModel());
			}else {
				cars2.setCarModel(cars2.getCarModel());
			}
			if(cars2.getCarNoOfSeats()>0) {
				cars2.setCarNoOfSeats(cars.getCarNoOfSeats());
			}else {
				cars2.setCarNoOfSeats(cars2.getCarNoOfSeats());
			}
		}
		return cars2;
		
	}
	public List<Cars> getAllCars(){
		return carsRepository.findAll();
				
	}

}
