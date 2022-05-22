package com.ty.user.controller;

import com.ty.user.Services.ProductService;

public class TestDeleteUserByIds {

	public static void main(String[] args) {
		ProductService productService=new ProductService();
		productService.deleteById(6);
	}

}
