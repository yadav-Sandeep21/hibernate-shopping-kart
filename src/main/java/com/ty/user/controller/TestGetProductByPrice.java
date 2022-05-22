package com.ty.user.controller;

import com.ty.user.Services.ProductService;

public class TestGetProductByPrice {

	public static void main(String[] args) {
		ProductService productService=new ProductService();
		productService.getProductDetailByPrice(9000);
	}

}
