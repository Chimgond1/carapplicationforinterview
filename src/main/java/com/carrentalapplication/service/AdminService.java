package com.carrentalapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.carrentalapplication.dao.AdminDao;
import com.carrentalapplication.dto.Admin;
import com.carrentalapplication.dto.ResponseStructure;
import com.carrentalapplication.exception.EnterPasswordOrEmailIsWorgException;
import com.carrentalapplication.exception.InvalidIdException;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	public ResponseEntity<ResponseStructure<Admin>> addAdmin(Admin admin) {

		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Admin saved successfully into application");
		responseStructure.setData(adminDao.addAdmin(admin));
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Admin>> getAdminById(int id) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();

		if (adminDao.getAdminById(id) != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Admin Details getting successfully from the application");
			responseStructure.setData(adminDao.getAdminById(id));

		} else {
			throw new InvalidIdException("Enter id is wrong mention valid id");
		}
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<String>> removeAdmin(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (adminDao.getAdminById(id) != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Admin removed successfully from the application");
			responseStructure.setData(adminDao.removeAdmin(id));

		} else {
			throw new InvalidIdException("Enter id is wrong mention valid id");
		}
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin, int id) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		if (adminDao.getAdminById(id) != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Admin updated successfully from the application");
			responseStructure.setData(adminDao.updateAdmin(admin, id));

		} else {
			throw new InvalidIdException("Enter id is wrong mention valid id");
		}
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Admin>> logInAdmin(String email, String password) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();

		Admin admin1 = adminDao.logInAdmin(email, password);
		if (admin1 != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Admin Log In successfully into the application");
			responseStructure.setData(adminDao.logInAdmin(email, password));

		} else {
			throw new EnterPasswordOrEmailIsWorgException("Enter valid email and password");
		}
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<List<Admin>>> getAllAdmin() {
		ResponseEntity<ResponseStructure<List<Admin>>> responseEntity=null;
		ResponseStructure<List<Admin>> responseStructure = new ResponseStructure<List<Admin>>();
		List<Admin> admins=adminDao.getAllAdmin();
		if(admins!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(admins);
			responseEntity=new ResponseEntity<ResponseStructure<List<Admin>>>(responseStructure,HttpStatus.OK);
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage(" not success");
			responseStructure.setData(null);
			 responseEntity= new ResponseEntity<ResponseStructure<List<Admin>>> (responseStructure,HttpStatus.NOT_FOUND);
		
		}
		return responseEntity;
		
	}
}