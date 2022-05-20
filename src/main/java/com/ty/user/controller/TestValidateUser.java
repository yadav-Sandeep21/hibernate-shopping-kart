package com.ty.user.controller;

import com.ty.user.Services.UserServices;

public class TestValidateUser {

	public static void main(String[] args) {
		UserServices userServices=new UserServices();
		userServices.validateUserById("Rose", "rose@gmail.com");
	}

}
