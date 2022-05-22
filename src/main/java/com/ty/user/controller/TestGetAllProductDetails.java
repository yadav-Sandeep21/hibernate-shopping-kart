package com.ty.user.controller;

import java.util.List;

import com.ty.user.DTO.Product;
import com.ty.user.Services.ProductService;

public class TestGetAllProductDetails {

	public static void main(String[] args) {
		ProductService productService=new ProductService();
		List<Product> products=productService.getAllProductDetails();
		for(Product product : products) {
			System.out.println("Id is: "+product.getId());
			System.out.println("Name is: "+product.getName());
			System.out.println("Brand is: "+product.getPrice());
			System.out.println("Type is: "+product.getType());
			System.out.println("Size is: "+product.getSize());
			System.out.println("Rating is: "+product.getRating());
		}
	}

}
