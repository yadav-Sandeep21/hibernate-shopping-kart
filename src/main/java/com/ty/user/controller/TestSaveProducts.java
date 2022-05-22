package com.ty.user.controller;

import com.ty.user.DTO.Product;
import com.ty.user.Services.ProductService;

public class TestSaveProducts {

	public static void main(String[] args) {
		ProductService productservice=new ProductService();
		Product product=new Product();
		product.setName("Jeans");
		product.setBrand("PETER ENGLAND");
		product.setPrice(9000);
		product.setType("pants");
		product.setSize("XL");
		product.setRating(4);
		
		productservice.saveProduct(product);
		
	}

}
