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

import com.carrentalapplication.dto.Cars;
import com.carrentalapplication.dto.Customer;
import com.carrentalapplication.dto.Driver;
import com.carrentalapplication.dto.LogIn;
import com.carrentalapplication.dto.ResponseStructure;
import com.carrentalapplication.service.DriverService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class DriverController {
	@Autowired
	private DriverService driverService;
	
	
	@PostMapping("/drivers")
	@ApiOperation("To Save Driver  ")
	@ApiResponses({@ApiResponse(code = 200,message = "Save Driver Successfully"),
        @ApiResponse(code = 400,message = "Bad Request for Data to Save Driver"),
        @ApiResponse(code = 500,message = "Internal Server Error")})	
	public ResponseEntity<ResponseStructure<Driver>> adddriver(@RequestBody Driver driver){
		return driverService.addDriver(driver);
		}
	@GetMapping("/drivers/{id}")
	@ApiOperation("To Get Driver  ")
	@ApiResponses({@ApiResponse(code = 200,message = "Get Driver Successfully"),
        @ApiResponse(code = 400,message = "Bad Request for Data to Get Driver"),
        @ApiResponse(code = 500,message = "Internal Server Error")})	
	public ResponseEntity<ResponseStructure<Driver>> getAdminById(@PathVariable @ApiParam("Driver Id") int id){
		return driverService.getDriveryId(id);
		
	}
	@DeleteMapping("/drivers/{id}")
	@ApiOperation("To Delete Driver  ")
	@ApiResponses({@ApiResponse(code = 200,message = "Delete Driver Successfully"),
        @ApiResponse(code = 400,message = "Bad Request for Data to Delete Driver"),
        @ApiResponse(code = 500,message = "Internal Server Error")})	
	public ResponseEntity<ResponseStructure<String>> removeAdmin(@PathVariable @ApiParam("Driver Id") int id){
		return driverService.removeDriver(id);
	}
	@PutMapping("/drivers/{id}")
	@ApiOperation("To Update Driver  ")
	@ApiResponses({@ApiResponse(code = 200,message = "Update Driver Successfully"),
        @ApiResponse(code = 400,message = "Bad Request for Data to Update Driver"),
        @ApiResponse(code = 500,message = "Internal Server Error")})	
	public ResponseEntity<ResponseStructure<Driver>> updateAdmin(@RequestBody Driver driver,@PathVariable @ApiParam("Driver Id") int id){
		
		return driverService.updateDriver(driver, id);
	}
	@PostMapping("/drivers/logIn")
	@ApiOperation("To Log In Driver  ")
	@ApiResponses({@ApiResponse(code = 200,message = "Log In Driver Successfully"),
        @ApiResponse(code = 400,message = "Bad Request for Data to Log In Driver"),
        @ApiResponse(code = 500,message = "Internal Server Error")})	
	public ResponseEntity<ResponseStructure<Driver>> logInAdmin(@RequestBody LogIn logIn){
		return driverService.logInDrivern(logIn.getEmail(), logIn.getPassword());
	}

	@GetMapping("/drivers")
	@ApiOperation("To Get All Driver  ")
	@ApiResponses({@ApiResponse(code = 200,message = "Get All Driver Successfully"),
        @ApiResponse(code = 400,message = "Bad Request for Data to Get All Driver"),
        @ApiResponse(code = 500,message = "Internal Server Error")})	
	public ResponseEntity<ResponseStructure<List<Driver>>> getAllDriver(){
		return driverService.getAllDriver();
	}


}
