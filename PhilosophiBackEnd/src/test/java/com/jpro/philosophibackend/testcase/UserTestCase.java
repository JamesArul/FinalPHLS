package com.jpro.philosophibackend.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jpro.philosophibackend.dao.UserDAO;
import com.jpro.philosophibackend.domain.User;

import junit.framework.Assert;

public class UserTestCase {
	
	@Autowired
	private static User user;
	
	@Autowired
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void init()//give any name for method
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.jpro.philosophibackend");
		context.refresh();
		user=(User) context.getBean("user");
		userDAO =(UserDAO) context.getBean("userDAO");
	}

	@Test
	public void addUserTestCase() 
	{
		user.setUserID("Dhinesh27");
		user.setUserName("Dhinesh");
		user.setUserEmail("d.dhinesh@gmail.com");
		user.setUserPassword("DHIN94");
		user.setUserContact(9787325454L);
		user.setUserRole("ROLE_USER");
		boolean flag=userDAO.saveUser(user);
		Assert.assertEquals("addUserTestCase", true, flag);
	}
	
	@Test
	public void editUserTestCase()
	{
		user=userDAO.getUserById("JA007");
		user.setUserContact(8939941211L);
		user.setUserRole("ROLE_USER");
		boolean flag=userDAO.updateUser(user);
		Assert.assertEquals("editUserTestCase", true, flag);
	}

}
