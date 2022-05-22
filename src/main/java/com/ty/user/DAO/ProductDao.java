package com.ty.user.DAO;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.user.DTO.Product;
import com.ty.user.DTO.User;

public class ProductDao {

	// Save Product in database table
	public Product saveProduct(Product product) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(product);
		entityTransaction.commit();

		if (product != null) {
			return product;
		} else
			return null;
	}

	// Get Product By Id
	public Product getProductById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Product product = entityManager.find(Product.class, id);

		if (product != null) {
			System.out.println("Id is: " + product.getId());
			System.out.println("Name is: " + product.getName());
			System.out.println("Brand is: " + product.getBrand());
			System.out.println("Price is: " + product.getPrice());
			System.out.println("Type is: " + product.getType());
			System.out.println("Size is: " + product.getSize());
			System.out.println("Rating is: " + product.getRating());
		} else {
			System.out.println("Product Details are not found!");
		}
		return null;
	}

	// Get All User From database Table
	public List<Product> getAllProductDetails() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String sql = "SELECT p FROM Product p";
		Query query = entityManager.createQuery(sql);

		return query.getResultList();
	}

	// Get the detail by brand
	public List<Product> getProductsDetailByBrand(String brand) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String sql = "SELECT p FROM Product p WHERE p.brand=?1";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, brand);
		List<Product> products = query.getResultList();

		if (products.size() > 0) {
			for (Product product : products) {
				System.out.println("Id is: " + product.getId());
				System.out.println("Name is: " + product.getName());
				System.out.println("Brand is: " + product.getBrand());
				System.out.println("Price is: " + product.getPrice());
				System.out.println("Type is: " + product.getType());
				System.out.println("Size is: " + product.getSize());
				System.out.println("Rating is: " + product.getRating());
			}
		} else {
			System.out.println("Enter Valid Name, It's Invalid Brand.");
		}
		return null;
	}

	// Get the detail by type
	public List<Product> getProductsDetailByType(String type) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String sql = "SELECT p FROM Product p WHERE p.type=?1";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, type);
		List<Product> products = query.getResultList();

		if (products.size() > 0) {
			for (Product product : products) {
				System.out.println("Id is: " + product.getId());
				System.out.println("Name is: " + product.getName());
				System.out.println("Brand is: " + product.getBrand());
				System.out.println("Price is: " + product.getPrice());
				System.out.println("Type is: " + product.getType());
				System.out.println("Size is: " + product.getSize());
				System.out.println("Rating is: " + product.getRating());
			}
		} else {
			System.out.println("Enter Valid Name, It's Invalid Brand.");
		}
		return null;
	}

	// Get the detail by price
	public List<Product> getProductDetailByPrice(double price) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String sql = "SELECT p FROM Product p WHERE p.price=?1";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, price);
		List<Product> products = query.getResultList();
		if (products.size() > 0) {
			for (Product product : products) {
				System.out.println("Id is: " + product.getId());
				System.out.println("Name is: " + product.getName());
				System.out.println("Brand is: " + product.getBrand());
				System.out.println("Price is: " + product.getPrice());
				System.out.println("Type is: " + product.getSize());
				System.out.println("Rating is: " + product.getRating());
			}
		} else {
			System.out.println("Enter Valid price, This is Invalid!");
		}

		return null;
	}

	// Delete the record by Id
	public boolean deleteProductById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Product products = entityManager.find(Product.class, id);

		if (products != null) {
			entityTransaction.begin();
			entityManager.remove(products);
			entityTransaction.commit();
			System.out.println("Product id " + id +" is Deleted!" );
			return true;
		} else {
			System.out.println("No user found for delete!");
		}
		return false;
	}
	//Update All the details
	public void updateAlltheDetails() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		
	}
	
	
	// Update rating
	public int updateRating(int id) {
		int count = 1;
		count++;
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Product product = entityManager.find(Product.class, id);
		if (product != null) {
			System.out.println("For the details provided the ID of your Product is" + id);
			System.out.println(product.getRating() + "your product present rating ");
			System.out.println("Enter your new rating");

			int nrating = sc.nextInt();

			int temp = product.getRating();
			temp = (temp + nrating) / count;
			System.out.println("This is the updated rating: " + temp);
			product.setRating(temp);

			entityTransaction.begin();
			entityManager.merge(product);
			entityTransaction.commit();
			System.out.println("Done, Rating is Updated!");
			return temp;
		}
		return 0;
	}
}
