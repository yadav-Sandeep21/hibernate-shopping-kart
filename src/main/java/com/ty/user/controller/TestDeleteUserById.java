package com.ty.user.controller;

import com.ty.user.Services.UserServices;

public class TestDeleteUserById {

	public static void main(String[] args) {
		UserServices userservices=new UserServices();
		userservices.deleteUserById(1);
	}

}
