package com.carrentalapplication.dto;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
/*
 * Admin class is entity class 
 * it ctreate the table in data base and
 * each variabe is column name in data base
 *  @Data :- use is create getter and Setter so
 *  for this i added lombok dependency in poem.xml
 */
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/*
	 * Admin Id is here primery key and i make it as auto increament primary key
	 */
	private int adminId;
	@NotBlank(message = "admin name should not be blank")
	private String adminName;
	@NotBlank(message = "email should not be blank")
	@Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z"+"A-Z]{2,7}$",message="email should be EXAMPLE abc@gmail.com")
	private String email;
	@NotBlank(message = "password should not be blank")
	private String password;
	private long adminPhoneNumber;
	
	@JsonIgnore
	@OneToMany(mappedBy = "admin" , cascade = CascadeType.ALL)
	private  List<Cars> cars;
	
	@JsonIgnore
	@OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
	private List<Customer> customers;
	
	@JsonIgnore
	@OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
	private List<Driver> drivers;
	
}
