package com.ty.user.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String name;
private String brand;
private double price; 
private String type;
private String size;
private int rating;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	if(rating>0 & rating<=5) {
		
	this.rating = rating;
	}else {
		System.out.println("Rating is not in range!");
	}
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
}
