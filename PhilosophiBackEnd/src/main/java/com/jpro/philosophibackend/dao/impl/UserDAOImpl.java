package com.jpro.philosophibackend.dao.impl;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jpro.philosophibackend.dao.UserDAO;
import com.jpro.philosophibackend.domain.Cart;
import com.jpro.philosophibackend.domain.User;

@EnableTransactionManagement
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	
	private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;		
	}

	@Transactional
	public List<User> getAlluser() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Transactional
	public boolean saveUser(User user) {
		log.debug("Start of saveUser");
		try
		{
		sessionFactory.getCurrentSession().save(user);
		log.debug("End of saveUser");
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.debug("End of saveUser");
			return false;
		}	
	}

	@Transactional
	public boolean updateUser(User user) {
		log.debug("Start of updateUser");
		try
		{
		sessionFactory.getCurrentSession().update(user);
		log.debug("End of updateUser");
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.debug("End of updateUser");
			return false;
		}
	}

	@Transactional
	public boolean deleteUser(User user) {
		log.debug("Start of deleteUser");
		try
		{
		sessionFactory.getCurrentSession().delete(user);
		log.debug("End of deleteUser");
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.debug("End of deleteUser");
			return false;
		}
	}

	@Transactional
	public boolean deleteUser(String userId) {
		log.debug("Start of deleteUser");
		try {
			sessionFactory.getCurrentSession().delete(getUserById(userId));
			log.debug("End of deleteUser");
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			log.debug("End of deleteUser");
			return false;
		}
	}

	@Transactional
	public User getUserById(String userId) {
		return (User) sessionFactory.getCurrentSession().createQuery("from User where userID ='"+ userId +"'" ).uniqueResult();
	}

	@Transactional
	public User getUserByName(String userName) {
		return (User) sessionFactory.getCurrentSession().createQuery("from User where userName ='"+ userName +"'" ).uniqueResult();
	}

	@Transactional
	public List<Cart> getCartsOfUser(String userId) {
		return sessionFactory.getCurrentSession().createQuery("from Cart where userId='"+userId+"'").list();
	}
}
