package com.carrentalapplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carrentalapplication.dto.Admin;
import com.carrentalapplication.dto.Cars;
import com.carrentalapplication.dto.Customer;
import com.carrentalapplication.repository.CustomerRepository;

@Repository
public class CustomerDao {
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer addCustomer(Customer customer){
		return customerRepository.save(customer);
		
	}
	/*
	 * Getting admin with the help of admin id 
	 * if it present give admin hole details
	 * if it is not present it return null value
	 */
	public Customer getCustomerById(int id){
		 Optional<Customer> customer=customerRepository.findById(id);
		 if(customer.isEmpty()) {
			 return null;
		 }else {
			 return customer.get();
		 }
		
	}
	/*
	 * Removing admin with the help of id
	 * if Id is present it remove Admin it will give admin removed successfully
	 * otherwise Id is not present it return id is not present to remove
	 */
	
	public String removeCustomer(int id){
		Customer customer=getCustomerById(id);
		if(customer!=null) {
			customerRepository.delete(customer);
			return "customer is removed successfully";
		}else {
			return "no customer data to remove ";
		}
		
	}
	/*
	 * Updating admin details with the help of admin details and id
	 */
	public Customer updateCustomer(Customer customer,int id){
		Customer customer2=getCustomerById(id);
		if(customer2!=null) {
			if(customer.getCustomerId()>0) {
				customer2.setCustomerId(customer.getCustomerId());
			}else {
				customer2.setCustomerId(customer2.getCustomerId());
			}
			if(customer.getCustomerName()!=null) {
				customer2.setCustomerName(customer.getCustomerName());
			}else {
				customer2.setCustomerName(customer2.getCustomerName());
			}
			if(customer.getEmail()!=null) {
				customer2.setEmail(customer.getEmail());
			}else {
				customer2.setEmail(customer2.getEmail());
			}
			if(customer.getPassword()!=null) {
				customer2.setPassword(customer.getPassword());
			}else {
				customer2.setPassword(customer2.getPassword());
			}
			if(customer.getCustomerPhoneNo()>0) {
				customer2.setCustomerPhoneNo(customer.getCustomerPhoneNo());
			}else {
				customer2.setCustomerPhoneNo(customer2.getCustomerPhoneNo());
			}
		}
		return customer2;
		
	}
	/*
	 * 1. LogIn method for Admin
	 *    its take email and password to log in
	 */
	public Customer logInCustomer(String email,String password){
		return customerRepository.logInCustomer(email, password);
		
	}
	public List<Customer> getAllCustomer(){
		return customerRepository.findAll();
				
	}
	

}
