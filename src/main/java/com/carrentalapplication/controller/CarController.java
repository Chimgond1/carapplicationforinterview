package com.carrentalapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carrentalapplication.dto.Admin;
import com.carrentalapplication.dto.Cars;
import com.carrentalapplication.dto.LogIn;
import com.carrentalapplication.dto.ResponseStructure;
import com.carrentalapplication.service.CarService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CarController {
	@Autowired
	private CarService carService;

	@PostMapping("/cars")
	@ApiOperation("To Save Cars  ")
	@ApiResponses({@ApiResponse(code = 200,message = "Save Cars Successfully"),
        @ApiResponse(code = 400,message = "Bad Request for Data to Save Cars"),
        @ApiResponse(code = 500,message = "Internal Server Error")})	
	public ResponseEntity<ResponseStructure<Cars>> addCar(@RequestBody Cars cars) {
		return carService.addCar(cars);
	}

	@GetMapping("/cars/{id}")
	@ApiOperation("To Get Cars  ")
	@ApiResponses({@ApiResponse(code = 200,message = "Get Cars Successfully"),
        @ApiResponse(code = 400,message = "Bad Request for Data to Get Cars"),
        @ApiResponse(code = 500,message = "Internal Server Error")})	
	public ResponseEntity<ResponseStructure<Cars>> getCarById(@PathVariable @ApiParam("Car Id") int id) {
		return carService.getCarById(id);

	}

	@DeleteMapping("/cars/{id}")
	@ApiOperation("To Delete Cars  ")
	@ApiResponses({@ApiResponse(code = 200,message = "Save Cars Successfully"),
        @ApiResponse(code = 400,message = "Bad Request for Data to Save Cars"),
        @ApiResponse(code = 500,message = "Internal Server Error")})	
	public ResponseEntity<ResponseStructure<String>> removeCar(@PathVariable @ApiParam("Car Id") int id) {
		return carService.removeCar(id);
	}

	@PutMapping("/cars/{id}")
	@ApiOperation("To Update Cars  ")
	@ApiResponses({@ApiResponse(code = 200,message = "Update Cars Successfully"),
        @ApiResponse(code = 400,message = "Bad Request for Data to Update Cars"),
        @ApiResponse(code = 500,message = "Internal Server Error")})	
	public ResponseEntity<ResponseStructure<Cars>> updateCar(@RequestBody Cars cars, @PathVariable @ApiParam("Car Id") int id) {

		return carService.updateCar(cars, id);
	}
	@GetMapping("/cars")
	@ApiOperation("To Get All Cars  ")
	@ApiResponses({@ApiResponse(code = 200,message = "Get All Cars Successfully"),
        @ApiResponse(code = 400,message = "Bad Request for Data to Get All Cars"),
        @ApiResponse(code = 500,message = "Internal Server Error")})	
	public ResponseEntity<ResponseStructure<List<Cars>>> getAllCars(){
		return carService.getAllCars();
	}
}
