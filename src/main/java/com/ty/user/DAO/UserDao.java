package com.ty.user.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.user.DTO.User;

public class UserDao {
	
	//save data
	public User saveUser(User user) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		
		if(user!=null) {
			return user;
		}else
		    return null;
	}
	//Get User By Id
	public User getUserById(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		User user=entityManager.find(User.class, id);
		
		if(user!=null) {
			System.out.println("Id is "+user.getId());
			System.out.println("Name is "+user.getName());
			System.out.println("Email is "+user.getEmail());
			System.out.println("Phone is "+user.getPhone());
			System.out.println("Password is "+user.getPassword());
		}
		else
		{
			System.out.println("User detail not found");
		}
		
		return null;
	}
	//Get all Users
	public List<User> getAllUsers(){
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		String sql="SELECT u FROM User u";
		Query query=entityManager.createQuery(sql);

		return query.getResultList();
	}
	//Delete By id
	public boolean deleteUserById(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		User user=entityManager.find(User.class, id);
		
		if(user!=null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			System.out.println("User deleting id is!:"+id);
			return true;
		}
		else
		{
			System.out.println("No user found for delete!");
		}
		return false;
	}
	//Validate User
	public User validateUser(String name, String email) {
		EntityManagerFactory emfFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager emManager=emfFactory.createEntityManager();
		
		String sql="SELECT u FROM User u WHERE u.name=?1 AND u.email=?2";
		
		Query query=emManager.createQuery(sql);
		query.setParameter(1, name);
		query.setParameter(2, email);
		
		List<User> users=query.getResultList();
		if(users.size()>0) {
			for(User user : users) {
				System.out.println("Id is: "+user.getId());
				System.out.println("Name is: "+user.getName());
				System.out.println("Email is: "+user.getEmail());
				System.out.println("Phone is: "+user.getPhone());
				System.out.println("Password is: "+user.getPassword());
			}
		}
		else {
			System.out.println("Invalid name & email");
		}
		
		return null;
		
	}
	 
}
