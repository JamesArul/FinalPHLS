package com.jpro.philosophibackend.dao;

import java.util.List;

import com.jpro.philosophibackend.domain.Category;

public interface CategoryDAO {

	public List<Category> getAllCategory();
	
	public boolean saveCategory(Category category);
	
	public boolean updateCategory(Category category);
	
	public boolean deleteCategory(Category category);
	
	public boolean deleteCategory(String categoryId);
	
	public Category getCategoryById(String categoryId);
	
	public Category getCategoryByName(String categoryName);
}
