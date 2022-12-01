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
public class Cars {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "car number should not be blank")
	private String carNo;
	@NotBlank(message = "car type should not be blank")
	private String carType;
	@NotBlank(message = "car model should not be blank")
	private String carModel;
	@NotBlank(message = " number of seats should not be blank")
	private int carNoOfSeats;
	@NotBlank(message = "rent should not be blank")
	private double rent;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn
	private Admin admin;
	
	@OneToMany(mappedBy = "cars" , cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Customer> customers;
	
	@OneToOne(mappedBy = "cars",cascade = CascadeType.ALL)
	@JsonIgnore
	private Driver driver;

}
