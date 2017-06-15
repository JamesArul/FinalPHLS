package com.jpro.philosophibackend.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jpro.philosophibackend.dao.CategoryDAO;
import com.jpro.philosophibackend.domain.Category;

@EnableTransactionManagement
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	private static final Logger log = LoggerFactory.getLogger(CategoryDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;		
	}

	@Transactional
	public List<Category> getAllCategory() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	@Transactional
	public boolean saveCategory(Category category) {
		log.debug("Start of saveCategory");
		try
		{
		sessionFactory.getCurrentSession().save(category);
		log.debug("End of saveCategory");
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.debug("End of saveCategory");
			return false;
		}
	}

	@Transactional
	public boolean updateCategory(Category category) {
		log.debug("Start of updateCategory");
		try
		{
		sessionFactory.getCurrentSession().update(category);
		log.debug("End of updateCategory");
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.debug("End of updateCategory");
			return false;
		}
	}

	@Transactional
	public boolean deleteCategory(Category category) {
		log.debug("Start of deleteCategory");
		try
		{
		sessionFactory.getCurrentSession().delete(category);
		log.debug("End of deleteCategory");
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.debug("End of deleteCategory");
			return false;
		}
	}

	@Transactional
	public boolean deleteCategory(String categoryId) {
		log.debug("Start of deleteCategory");
		try {
			sessionFactory.getCurrentSession().delete(getCategoryById(categoryId));
			log.debug("End of deleteCategory");
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			log.debug("End of deleteCategory");
			return false;
		}
	}

	@Transactional
	public Category getCategoryById(String categoryId) {
		return (Category) sessionFactory.getCurrentSession().createQuery("from Category where categoryId ='"+ categoryId +"'" ).uniqueResult();
	}

	@Transactional
	public Category getCategoryByName(String categoryName) {
		return (Category) sessionFactory.getCurrentSession().createQuery("from Category where categoryName ='"+ categoryName +"'" ).list().get(0);
	}

}
