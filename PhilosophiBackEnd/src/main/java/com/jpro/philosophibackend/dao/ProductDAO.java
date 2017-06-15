package com.jpro.philosophibackend.dao;

import java.util.List;

import com.jpro.philosophibackend.domain.Product;;

public interface ProductDAO {

	public List<Product> getAllProducts();
	
	public boolean saveProduct(Product product);
	
	public boolean updateProduct(Product product);
	
	public boolean deleteProduct(Product product);
	
	public boolean deleteProduct(String id);
	
	public Product getProductById(String id);
	
	public Product getProductByName(String name);

}
