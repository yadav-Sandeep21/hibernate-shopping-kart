package com.ty.user.controller;

import com.ty.user.DTO.User;
import com.ty.user.Services.UserServices;

public class TestGetById {

	public static void main(String[] args) {
		UserServices userservice=new UserServices();
		User user=new User();
		userservice.getUserById(1);
		
	}

}
