package com.ty.user.Services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.user.DAO.ProductDao;
import com.ty.user.DTO.Product;


public class ProductService {
	
	// Save Product in database
	public Product saveProduct(Product product) {
		ProductDao productdao = new ProductDao();
		
		if (product != null) {
			return productdao.saveProduct(product);
		} else {
			return null;
		}
	}

	// Get Product By Id
	public Product getProductById(int id) {
		ProductDao productdao = new ProductDao();
		return productdao.getProductById(id);
	}

	// Get all the product details
	public List<Product> getAllProductDetails() {
		ProductDao productdao = new ProductDao();
		return productdao.getAllProductDetails();
	}

	// Get the detail by brand
	public List<Product> getProductsDetailByBrand(String brand) {
		ProductDao productDao = new ProductDao();
		return productDao.getProductsDetailByBrand(brand);
	}

	// Get the detail by type
	public List<Product> getProductsDetailByType(String type) {
		ProductDao productDao = new ProductDao();
		return productDao.getProductsDetailByType(type);
	}

	// Get the details by using price
	public List<Product> getProductDetailByPrice(double price) {
		ProductDao productDao = new ProductDao();
		return productDao.getProductDetailByPrice(price);
	}

	// Delete the record by Id
	public boolean deleteById(int id) {
		ProductDao productDao = new ProductDao();
		return productDao.deleteProductById(id);
	}

	// Update Rating
	public void updateRating(String name, String brand, String type) {
		ProductDao productDao = new ProductDao();
		int id = 0;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String sql = "SELECT product FROM Product product WHERE product.name=?1 AND product.brand=?2 AND product.type=?3";

		Query query = entityManager.createQuery(sql);
		query.setParameter(1, name);
		query.setParameter(2, brand);
		query.setParameter(3, type);

		List<Product> products = query.getResultList();
		if (products.size() > 0) {
			for (Product product : products) {
				id = product.getId();
			}
		}
		productDao.updateRating(id);
	}
}
