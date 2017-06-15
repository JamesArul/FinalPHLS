package com.jpro.philosophibackend.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jpro.philosophibackend.dao.ProductDAO;
import com.jpro.philosophibackend.domain.Product;
import junit.framework.Assert;

public class ProductTestCase {
	
	@Autowired
	private static Product product;
	
	@Autowired
	private static ProductDAO productDAO;
	
	@BeforeClass
	public static void init()//give any name for method
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.jpro.philosophibackend");
		context.refresh();
		product=(Product) context.getBean("product");
		productDAO =(ProductDAO) context.getBean("productDAO");
	}

	
	@Test
	public void addProductTestCase() //Product save success
	{
		product.setProductId("GN-USC001");
		product.setProductName("United States Coins");
		product.setCategoryId("GN001");
		product.setSupplierId("S001");
		product.setProductDesc("Book about United States Coins");
		product.setProductQuantity(10);
		product.setProductCost(600);
		boolean flag=productDAO.saveProduct(product);
		Assert.assertEquals("addProductTestCase", true, flag);
	}
	
	/*
	@Test
	public void editProductTestCase()//getProductById success, Product update success
	{
		product=productDAO.getProductById("MA1101");
		product.setProductDesc("Book for First Semester Computer Science and Engineering");
		boolean flag=productDAO.updateProduct(product);
		Assert.assertEquals("editProductTestCase", true, flag);
	}
	*/
	/*
	@Test
	public void deleteProductTestCase()//deleteProduct(String productID) success, getProductByName success, deleteProduct(Product product) success
	{
		product=productDAO.getProductByName("Test");
		boolean flag=productDAO.deleteProduct(product);
		Assert.assertEquals("deleteProductTestCase", true, flag);
	}
	*/
	
	@Test
	public void getAllProductTestCase()
	{
			int recordsFromDao = productDAO.getAllProducts().size();
			assertEquals("getAllProductTestCase",2 , recordsFromDao );
	}
}
