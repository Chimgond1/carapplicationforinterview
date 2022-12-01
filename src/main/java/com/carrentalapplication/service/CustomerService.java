package com.carrentalapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.carrentalapplication.dao.CustomerDao;
import com.carrentalapplication.dto.Admin;
import com.carrentalapplication.dto.Customer;
import com.carrentalapplication.dto.ResponseStructure;
import com.carrentalapplication.exception.EnterPasswordOrEmailIsWorgException;
import com.carrentalapplication.exception.InvalidIdException;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;
	
	public ResponseEntity<ResponseStructure<Customer>> addCustomer(Customer customer){
		ResponseStructure<Customer> responseStructure=new ResponseStructure<Customer>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Customer saved successfully into application");
		responseStructure.setData(customerDao.addCustomer(customer));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(int id){
		ResponseStructure<Customer> responseStructure=new ResponseStructure<Customer>();

		if (customerDao.getCustomerById(id) != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Customer Details getting successfully from the application");
			responseStructure.setData(customerDao.getCustomerById(id));
			
		}else {
			throw new InvalidIdException("Enter id is wrong mention valid id");
		}

		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.OK);
 
		
	}
	
	public ResponseEntity<ResponseStructure<String>> removeCustomer(int id){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		if (customerDao.removeCustomer(id)!= null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Customer removed successfully from the application");
			responseStructure.setData(customerDao.removeCustomer(id));
			
		}else {
			throw new InvalidIdException("Enter id is wrong mention valid id");
		}
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);

	}
	
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(Customer customer,int id){
		ResponseStructure<Customer> responseStructure=new ResponseStructure<Customer>();
		if (customerDao.getCustomerById(id) != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Customer updated successfully from the application");
			responseStructure.setData(customerDao.updateCustomer(customer,id));
			
		}
		else {
			throw new InvalidIdException("Enter id is wrong mention valid id");
		}
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.OK);

		
	}
	
	public ResponseEntity<ResponseStructure<Customer>> logInCustomer(String email,String password){
		ResponseStructure<Customer> responseStructure=new ResponseStructure<Customer>();
		Customer customer = customerDao.logInCustomer(email, password);
		if (customer != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Customer Log In successfully into the application");
			responseStructure.setData(customerDao.logInCustomer(email,password));
			
		}else {
			throw new EnterPasswordOrEmailIsWorgException("Enter valid email and password");
		}
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.OK);

	}
	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomer() {
		ResponseEntity<ResponseStructure<List<Customer>>> responseEntity=null;
		ResponseStructure<List<Customer>> responseStructure = new ResponseStructure<List<Customer>>();
		List<Customer> customers=customerDao.getAllCustomer();
		if(customers!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(customers);
			responseEntity=new ResponseEntity<ResponseStructure<List<Customer>>>(responseStructure,HttpStatus.OK);
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage(" not success");
			responseStructure.setData(null);
			 responseEntity= new ResponseEntity<ResponseStructure<List<Customer>>> (responseStructure,HttpStatus.NOT_FOUND);
		
		}
		return responseEntity;
		
	}

}
