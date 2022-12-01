package com.carrentalapplication.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carrentalapplication.dto.Admin;
import com.carrentalapplication.dto.LogIn;
import com.carrentalapplication.dto.ResponseStructure;
import com.carrentalapplication.service.AdminService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Getter;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/admins")
	@ApiOperation("To Save Admin  ")
	@ApiResponses({@ApiResponse(code = 200,message = "Save Admin Successfully"),
        @ApiResponse(code = 400,message = "Bad Request for Data to Save Admin"),
        @ApiResponse(code = 500,message = "Internal Server Error")})	
	public ResponseEntity<ResponseStructure<Admin>> addAdmin(@RequestBody Admin admin){
		return adminService.addAdmin(admin);
		}
	@GetMapping("/admins/{id}")
	@ApiOperation("To Get Admin By Id  ")
	@ApiResponses({@ApiResponse(code = 200,message = "Getting Admin Successfully"),
        @ApiResponse(code = 400,message = "Bad Request for Data to Getting Admin"),
        @ApiResponse(code = 500,message = "Internal Server Error")})	
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(@PathVariable @ApiParam("Admin Id") int id){
		return adminService.getAdminById(id);
		
	}
	@DeleteMapping("/admins/{id}")
	@ApiOperation("To Delete Admin  ")
	@ApiResponses({@ApiResponse(code = 200,message = "Deleted Admin Successfully"),
        @ApiResponse(code = 400,message = "Bad Request for Data to Delete Admin"),
        @ApiResponse(code = 500,message = "Internal Server Error")})	
	public ResponseEntity<ResponseStructure<String>> removeAdmin(@PathVariable @ApiParam("Admin Id") int id){
		return adminService.removeAdmin(id);
	}
	@PutMapping("/admins/{id}")
	@ApiOperation("To Update Admin  ")
	@ApiResponses({@ApiResponse(code = 200,message = "Update Admin Successfully"),
        @ApiResponse(code = 400,message = "Bad Request for Data to Update Admin"),
        @ApiResponse(code = 500,message = "Internal Server Error")})	
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin admin,@PathVariable @ApiParam("Admin Id") int id){
		
		return adminService.updateAdmin(admin, id);
	}
	@PostMapping("/admins/logIn")
	@ApiOperation("To Log In Admin  ")
	@ApiResponses({@ApiResponse(code = 200,message = "Log In Admin Successfully"),
        @ApiResponse(code = 400,message = "Bad Request for Data to Log In Admin"),
        @ApiResponse(code = 500,message = "Internal Server Error")})	
	public ResponseEntity<ResponseStructure<Admin>> logInAdmin(@RequestBody LogIn logIn){
		return adminService.logInAdmin(logIn.getEmail(), logIn.getPassword());
	}
	@GetMapping("/admins")
	@ApiOperation("To Get All Admin  ")
	@ApiResponses({@ApiResponse(code = 200,message = "Get All Admin Successfully"),
        @ApiResponse(code = 400,message = "Bad Request for Data to Get All Admin"),
        @ApiResponse(code = 500,message = "Internal Server Error")})	
	public ResponseEntity<ResponseStructure<List<Admin>>> getAllAdmin(){
		return adminService.getAllAdmin();
	}


}
