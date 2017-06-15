package com.jpro.philosophibackend.dao;

import java.util.List;

import com.jpro.philosophibackend.domain.Cart;
import com.jpro.philosophibackend.domain.User;;

public interface UserDAO {
	
	public List<User> getAlluser();
	
	public boolean saveUser(User user);
	
	public boolean updateUser(User user);
	
	public boolean deleteUser(User user);
	
	public boolean deleteUser(String userId);
	
	public User getUserById(String userId);
	
	public User getUserByName(String userName);
	
	public List<Cart> getCartsOfUser(String userId);

}
