package com.ty.user.controller;

import com.ty.user.DTO.User;
import com.ty.user.Services.UserServices;

public class SaveUserController {

	public static void main(String[] args) {
		UserServices userServices=new UserServices();
		
		User user=new User();
		user.setName("Rose");
		user.setEmail("rose@gmail.com");
		user.setPhone(77855l);
		user.setPassword("neerajlovelily");
		userServices.saveUser(user);
	}

}
