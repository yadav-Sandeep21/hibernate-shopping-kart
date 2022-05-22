package com.ty.user.controller;

import com.ty.user.Services.ProductService;

public class TestGetProductDetailByBrand {

	public static void main(String[] args) {
		ProductService productService=new ProductService();
		productService.getProductsDetailByBrand("NIKE");
	}

}
