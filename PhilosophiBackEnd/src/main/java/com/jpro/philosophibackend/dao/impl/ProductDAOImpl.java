package com.jpro.philosophibackend.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jpro.philosophibackend.dao.ProductDAO;
import com.jpro.philosophibackend.domain.Product;

@EnableTransactionManagement
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	
	private static final Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;		
	}

	@Transactional
	public List<Product> getAllProducts() {
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	@Transactional
	public boolean saveProduct(Product product) {
		log.debug("Start of saveProduct");
		try
		{
		sessionFactory.getCurrentSession().save(product);
		log.debug("End of saveProduct");
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.debug("End of saveProduct");
			return false;
		}
	}

	@Transactional
	public boolean updateProduct(Product product) {
		log.debug("Start of updateProduct");
		try
		{
		sessionFactory.getCurrentSession().update(product);
		log.debug("End of updateProduct");
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.debug("End of updateProduct");
			return false;
		}
	}

	@Transactional
	public boolean deleteProduct(Product product) {
		log.debug("Start of deleteProduct");
		try
		{
		sessionFactory.getCurrentSession().delete(product);
		log.debug("End of deleteProduct");
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.debug("End of deleteProduct");
			return false;
		}
	}

	@Transactional
	public boolean deleteProduct(String produtcId) {
		log.debug("Start of deleteProduct");
		try {
			sessionFactory.getCurrentSession().delete(getProductById(produtcId));
			log.debug("End of deleteProduct");
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			log.debug("End of deleteProduct");
			return false;
		}
	}

	@Transactional
	public Product getProductById(String produtcId) {
		return (Product) sessionFactory.getCurrentSession().createQuery("from Product where productId ='"+ produtcId +"'" ).uniqueResult();
	}

	@Transactional
	public Product getProductByName(String productName) {
		return (Product) sessionFactory.getCurrentSession().createQuery("from Product where productName ='"+ productName +"'" ).list().get(0);
	}

}
