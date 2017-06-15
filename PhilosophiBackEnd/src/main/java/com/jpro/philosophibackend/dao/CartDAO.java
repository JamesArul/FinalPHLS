package com.jpro.philosophibackend.dao;

import java.util.List;

import com.jpro.philosophibackend.domain.Cart;
import com.jpro.philosophibackend.domain.ProductOfCart;;

public interface CartDAO {
	
public boolean saveCart(Cart cart);
	
	public boolean updateCart(Cart cart);
	
	public boolean deleteCart(Cart cart);
	
	public boolean deleteCart(int cartId);
	
	public Cart getCartById(int cartId);
	
	public List<Cart> getAllCart();
	
	public List<Cart> getCartsOfUser(String userId);
	
	public String getCartStatus(int cartId);
	
	public List<ProductOfCart> getProductsInCart(int cartId);
	
	public int getTotalAmount(int cartID);
	
	public void generateBill(int cartId);
	
	public boolean removeProductFromCart(String productID, int cartID);
	
	public boolean updateTotalCost(int cartId,int newTotalCost);

}
