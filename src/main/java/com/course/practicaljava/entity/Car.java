package com.course.practicaljava.entity;

import java.time.LocalDate;

public class Car {

	private boolean available;
	private String brand;
	private String color;
	private LocalDate firstReleaseDate;
	private int price;
	private String type;

	public Car() {
		super();
	}

	public Car(boolean available, String brand, String color, LocalDate firstReleaseDate, int price, String type) {
		super();
		this.available = available;
		this.brand = brand;
		this.color = color;
		this.firstReleaseDate = firstReleaseDate;
		this.price = price;
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public String getColor() {
		return color;
	}

	public LocalDate getFirstReleaseDate() {
		return firstReleaseDate;
	}

	public int getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setFirstReleaseDate(LocalDate firstReleaseDate) {
		this.firstReleaseDate = firstReleaseDate;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", color=" + color + ", type=" + type + ", available=" + available + ", price="
				+ price + ", firstReleaseDate=" + firstReleaseDate + "]";
	}

}
