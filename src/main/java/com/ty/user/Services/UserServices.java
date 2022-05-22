package com.ty.user.Services;

import java.util.List;

import com.ty.user.DAO.UserDao;
import com.ty.user.DTO.User;
import com.ty.user.util.AES;
import static com.ty.user.util.AppConstants.SECRET_KEY;
public class UserServices {

	public User saveUser(User user) {
		UserDao userdao = new UserDao();
		
		String encEmail=AES.encrypt(user.getEmail(), SECRET_KEY);
		String encPassword=AES.encrypt(user.getPassword(), SECRET_KEY);
		user.setEmail(encEmail);
		user.setPassword(encPassword);
		
		if (user != null) {
			return userdao.saveUser(user);
		} else {
			return null;
		}
	}
	
	public User getUserById(int id) {
		UserDao userdao=new UserDao();
		
		return userdao.getUserById(id);
	}
	
	public List<User> getAllUsers(){
		UserDao userdao = new UserDao();
		return userdao.getAllUsers();
	}
	
	public boolean deleteUserById(int id) {
		UserDao userdao = new UserDao();
		return userdao.deleteUserById(id);
		
	}
	
	public User validateUserById(String name,String email) {
		UserDao userdao = new UserDao();
		return userdao.validateUser(name, email);
		
	}
}
