package com.jpro.philosophibackend.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jpro.philosophibackend.dao.SupplierDAO;
import com.jpro.philosophibackend.domain.Address;
import com.jpro.philosophibackend.domain.Supplier;

import junit.framework.Assert;

public class SupplierTestCase {
	

	@Autowired
	private static Supplier supplier;
	
	@Autowired
	private static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void init()//give any name for method
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.jpro.philosophibackend");
		context.refresh();
		
		supplier=(Supplier) context.getBean("supplier");
		supplierDAO =(SupplierDAO) context.getBean("supplierDAO");
	}
	
	
	@Test
	public void createSupplierTestCase()//Supplier save success
	{
		Address addr=new Address();
		supplier.setSupplierId("S002");
		supplier.setSupplierName("Ruby Book");
		supplier.setSupplierDescription("Supplier of Books for Engineering GMAT TOEFEL and other entrance exams");
		addr.setStreet("No: 60 , Valasaravakkam");
		addr.setCity("Chennai");
		addr.setState("Tamil Nadu");
		addr.setPincode(600011);
		supplier.setSupplierAddress(addr);
		boolean flag=supplierDAO.saveSupplier(supplier);
		Assert.assertEquals("createSupplierTestCase", true, flag);
	}
 	
	/*
	@Test
	public void editSupplierTestCase()// Supplier edit success
	{
		supplier.setSupplierId("S002");
		supplier.setSupplierDescription("Supplier of Books for Engineering GMAT TOEFEL and other entrance exams");
		boolean flag=supplierDAO.updateSupplier(supplier);
		Assert.assertEquals("editSupplierTestCase", true, flag);
	}
	*/
	/*
	@Test
	public void deleteSupplierTestCase()//getSupplierById success, deleteSupplier(Supplier supplier) success, getSupplierByName success, deleteSupplier(String supplierId) success
	{
		//supplier=supplierDAO.getSupplierById("Test");
		//supplier=supplierDAO.getSupplierByName("Test");
		boolean flag=supplierDAO.deleteSupplier("Test3");
		Assert.assertEquals("deleteSupplierTestCase", true, flag);
	}
	*/	
}
