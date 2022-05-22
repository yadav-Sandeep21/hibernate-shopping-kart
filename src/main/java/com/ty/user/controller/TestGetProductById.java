package com.ty.user.controller;

import com.ty.user.DTO.Product;
import com.ty.user.Services.ProductService;

public class TestGetProductById {

	public static void main(String[] args) {
		ProductService productService=new ProductService();
		Product product=new Product();
		productService.getProductById(1);
	}

}
