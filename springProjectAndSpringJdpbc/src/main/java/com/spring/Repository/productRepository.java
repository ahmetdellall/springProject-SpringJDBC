package com.spring.Repository;

import java.util.List;

import com.spring.Product.Product;

public interface productRepository {
	
	boolean createProductTable();
	
	boolean save(Product product);
	
	boolean saveBatch(List<Product> product);
	
	Product listById(int id);
	
	List<Product> findProducts();
	
	boolean update(Product product);
	
	boolean delete(int id );

}
