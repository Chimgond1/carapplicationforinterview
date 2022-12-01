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
import com.carrentalapplication.dto.Customer;
import com.carrentalapplication.dto.LogIn;
import com.carrentalapplication.dto.ResponseStructure;
import com.carrentalapplication.service.CustomerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customers")
	@ApiOperation("To Save Customer  ")
	@ApiResponses({@ApiResponse(code = 200,message = "Save Customer Successfully"),
        @ApiResponse(code = 400,message = "Bad Request for Data to Save Customer"),
        @ApiResponse(code = 500,message = "Internal Server Error")})	
	public ResponseEntity<ResponseStructure<Customer>> addCustomer(@RequestBody Customer customer){
		return customerService.addCustomer(customer);
		}
	@GetMapping("/customers/{id}")
	@ApiOperation("To Get Customer  ")
	@ApiResponses({@ApiResponse(code = 200,message = "Get Customer Successfully"),
        @ApiResponse(code = 400,message = "Bad Request for Data to Get Customer"),
        @ApiResponse(code = 500,message = "Internal Server Error")})	
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(@PathVariable @ApiParam("Customer Id") int id){
		return customerService.getCustomerById(id);
		
	}
	@DeleteMapping("/customers/{id}")
	@ApiOperation("To Delete Customer  ")
	@ApiResponses({@ApiResponse(code = 200,message = "Delete Customer Successfully"),
        @ApiResponse(code = 400,message = "Bad Request for Data to Delete Customer"),
        @ApiResponse(code = 500,message = "Internal Server Error")})	
	public ResponseEntity<ResponseStructure<String>> removeCustomer(@PathVariable @ApiParam("Customer Id") int id){
		return customerService.removeCustomer(id);
	}
	@PutMapping("/customers/{id}")
	@ApiOperation("To Uodate Customer  ")
	@ApiResponses({@ApiResponse(code = 200,message = "Update Customer Successfully"),
        @ApiResponse(code = 400,message = "Bad Request for Data to Update Customer"),
        @ApiResponse(code = 500,message = "Internal Server Error")})	
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestBody Customer customer,@PathVariable @ApiParam("Customer Id") int id){
		
		return customerService.updateCustomer(customer, id);
	}
	@PostMapping("/customers/logIn")
	@ApiOperation("To Log In  Customer  ")
	@ApiResponses({@ApiResponse(code = 200,message = "Log In Customer Successfully"),
        @ApiResponse(code = 400,message = "Bad Request for Data to Log In Customer"),
        @ApiResponse(code = 500,message = "Internal Server Error")})	
	public ResponseEntity<ResponseStructure<Customer>> logInCustomer(@RequestBody LogIn logIn){
		return customerService.logInCustomer(logIn.getEmail(), logIn.getPassword());
	}
	
	@GetMapping("/customers")
	@ApiOperation("To Get All Customer  ")
	@ApiResponses({@ApiResponse(code = 200,message = "Get All Customer Successfully"),
        @ApiResponse(code = 400,message = "Bad Request for Data to Get All Customer"),
        @ApiResponse(code = 500,message = "Internal Server Error")})	
	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCars(){
		return customerService.getAllCustomer();
	}


}
