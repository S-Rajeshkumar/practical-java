package com.course.practicaljava.service;

import java.util.List;

import com.course.practicaljava.entity.Car;

public interface CarService {

	List<String> BRANDS = List.of("Toyota", "Ford", "Honda", "BMW", "Benz");
	
	List<String> COLORS = List.of("Black", "Red", "White", "Blue", "Silver");
	
	List<String> TYPES = List.of("Prime", "Sedan", "SUV", "Hatch", "Convertible");
	
	List<String> ADDITIONAL_FEATURES = List.of("GPS", "Alarm", "Sunroof", "Touchpad", "MediaPlayer");
	
	List<String> FUELTYPE = List.of("Petrol", "Diesel", "Electric", "Hybrid");
	
	List<String> TIRE_MANUFACTURER = List.of("MRF", "CEAT", "APOLLO", "Roadster", "Thrust");
	
	Car generateCar();
	
}
