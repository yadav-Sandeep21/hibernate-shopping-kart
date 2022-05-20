package com.ty.user.controller;

import java.util.List;

import com.ty.user.DTO.User;
import com.ty.user.Services.UserServices;

public class TestGetAllUsers {

	public static void main(String[] args) {
		UserServices userservices=new UserServices();
		
		List<User> users=userservices.getAllUsers();
		for(User user : users) {
			System.out.println("ID is "+user.getId());
			System.out.println("Name is "+user.getName());
			System.out.println("Email is "+user.getEmail());
			System.out.println("Phone is "+user.getPhone());
			System.out.println("Password is "+user.getPassword());
		}
	}

}
