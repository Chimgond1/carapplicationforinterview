package com.carrentalapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carrentalapplication.dto.Cars;

public interface CarsRepository extends JpaRepository<Cars, Integer>{

}
