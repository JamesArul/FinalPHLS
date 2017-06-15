package com.jpro.philosophibackend.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jpro.philosophibackend.dao.CategoryDAO;
import com.jpro.philosophibackend.domain.Category;

import junit.framework.Assert;

public class CategoryTestCase {
	
	@Autowired
	private static Category category;
	
	@Autowired
	private static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void init()//give any name for method
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.jpro.philosophibackend");
		context.refresh();
		category=(Category) context.getBean("category");
		categoryDAO =(CategoryDAO) context.getBean("categoryDAO");
	}

	
	@Test
	public void createCategoryTestCase()//Category save success
	{
		category.setCategoryId("TS005");
		category.setCategoryName("Entrance Exams");
		category.setCategoryDescription("Preparation Books for Entrance Exams");
		boolean flag=categoryDAO.saveCategory(category);
		Assert.assertEquals("createCategoryTestCase", true, flag);
	}
	
	/*
	@Test
	public void editCategoryTestCase()//Category edit success
	{
		category.setCategoryId("EE001");
		category.setCategoryDescription("Engineering related books of CSE and IT ");
		boolean flag=categoryDAO.updateCategory(category);
		Assert.assertEquals("editCategoryTestCase", true, flag);
	}
	*/
	/*
	@Test
	public void deleteCategoryTestCase()//getCategoryById success, deleteCategory(Category category) success, deleteCategory(String id) success, getCategoryByName(String name) success
	{
		category=categoryDAO.getCategoryById("Test3");
		//category=categoryDAO.getCategoryByName("Test");
		boolean flag=categoryDAO.deleteCategory(category);
		//boolean flag=categoryDAO.deleteCategory("Test2");
		Assert.assertEquals("deleteCategoryTestCase", true, flag);
	}
	*/
}
