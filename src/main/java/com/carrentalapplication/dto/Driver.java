package com.carrentalapplication.dto;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int driverId;
	@NotBlank(message = "driver name should not be blank")
	private String driverName;
	@NotBlank(message = "email should not be blank")
	@Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z"+"A-Z]{2,7}$",message="email should be EXAMPLE abc@gmail.com")
	private String email;
	@NotBlank(message = "driver gender should not be blank")
	private String driverGender;
	@NotBlank(message = "driver phone number should not be blank")
	private long driverPhoneNo;
	@NotBlank(message = "password should not be blank")
	private String password;
	@NotBlank(message = "driver address should not be blank")
	private String driverAddress;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	@JsonIgnore
	private Admin admin;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	@JsonIgnore
	private Cars cars;
	
	@OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Customer> customers;

}
