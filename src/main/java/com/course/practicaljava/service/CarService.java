package com.course.practicaljava.service;

import java.util.List;

import com.course.practicaljava.entity.Car;

public interface CarService {

	List<String> BRANDS = List.of("Toyota", "Ford", "Honda");
	
	List<String> COLORS = List.of("Black", "Red", "White");
	
	List<String> TYPES = List.of("Prime", "Sedan", "SUV");
	
	List<String> ADDITIONAL_FEATURES = List.of("GPS", "Alarm", "Sunroof", "Touchpad", "MediaPlayer");
	
	List<String> FUELTYPE = List.of("Petrol", "Diesel", "Electric", "Hybrid");
	
	List<String> TIRE_MANUFACTURER = List.of("MRF", "CEAT", "APOLLO");
	
	Car generateCar();
	
}
