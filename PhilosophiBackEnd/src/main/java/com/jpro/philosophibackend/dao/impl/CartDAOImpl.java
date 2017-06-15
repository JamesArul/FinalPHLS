package com.jpro.philosophibackend.dao.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jpro.philosophibackend.dao.CartDAO;
import com.jpro.philosophibackend.domain.Cart;
import com.jpro.philosophibackend.domain.ProductOfCart;
import com.jpro.philosophibackend.domain.User;

@EnableTransactionManagement
@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {
	
	private static final Logger log = LoggerFactory.getLogger(CartDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CartDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;		
	}

	@Transactional
	public boolean saveCart(Cart cart) {
		log.debug("Start of saveCart");
		try
		{
		sessionFactory.getCurrentSession().save(cart);
		log.debug("Cart saved");
		log.debug("End of saveCart");
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();		
			log.debug("End of saveCart");
			return false;
		}
	}

	@Transactional
	public boolean updateCart(Cart cart) {
		log.debug("Start of updateCart");
		try
		{
		sessionFactory.getCurrentSession().update(cart);
		log.debug("Cart updated");
		log.debug("End of updateCart");
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.debug("End of updateCart");
			return false;
		}
	}

	@Transactional
	public boolean deleteCart(Cart cart) {
		log.debug("Start of deleteCart");
		try
		{
		sessionFactory.getCurrentSession().delete(cart);
		log.debug("Cart Deleted");
		log.debug("End of deleteCart");
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.debug("End of deleteCart");
			return false;
		}
	}

	@Transactional
	public boolean deleteCart(int cartId) {
		log.debug("Start of deleteCart");
		try {
			sessionFactory.getCurrentSession().delete(getCartById(cartId));
			log.debug("Cart Deleted");
			log.debug("End of deleteCart");
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			log.debug("End of deleteCart");
			return false;
		}
	}

	@Transactional
	public Cart getCartById(int cartId) {
		return (Cart) sessionFactory.getCurrentSession().createQuery("from Cart where cartID ='"+ cartId +"'" ).uniqueResult();
	}

	@Transactional
	public List<Cart> getAllCart() {
		return sessionFactory.getCurrentSession().createQuery("from Cart").list();
	}

	@Transactional
	public List<Cart> getCartsOfUser(String userId) {
		return sessionFactory.getCurrentSession().createQuery("from Cart where userId='"+userId+"'" ).list();
	}

	@Transactional
	public String getCartStatus(int cartId) {
		return (String) sessionFactory.getCurrentSession().createQuery("select cartStatus from Cart where cartID='"+cartId+"'" ).uniqueResult();
	}

	@Transactional
	public int getTotalAmount(int cartID) {
		return (Integer) sessionFactory.getCurrentSession().createQuery("select totalCost from Cart where cartID='"+cartID+"'" ).uniqueResult();
	}

	@Transactional
	public void generateBill(int cartId) {
		log.debug("Start of generateBill");
		Cart cart=(Cart) sessionFactory.getCurrentSession().createQuery("from Cart where cartID ='"+ cartId +"'" ).uniqueResult();
		User user=(User) sessionFactory.getCurrentSession().createQuery("from User where userID='"+cart.getUserId()+"'").uniqueResult();
		try{
			String billFile="F:/EclipseMain/FinalProject/Philosophia/PhilosophiaFrontEnd/src/main/webapp/Resources/Bills/Bill"+cart.getCartID()+".txt";
			String receiptFile="F:/EclipseMain/FinalProject/Philosophia/PhilosophiaFrontEnd/src/main/webapp/Resources/Bills/Receipt"+cart.getCartID()+".txt";
		    PrintWriter writerBill = new PrintWriter(billFile, "UTF-8");
		    PrintWriter writerReceipt=new PrintWriter(receiptFile ,"UTF-8");
		    List<ProductOfCart> billProducts_List=getProductsInCart(cart.getCartID());
		    writerReceipt.println("Name:"+cart.getDelivery_name());
		    writerReceipt.println(cart.getShippingAddress().getStreet()+"\n"+cart.getShippingAddress().getCity()+"\n"+cart.getShippingAddress().getState()+"\n"+cart.getShippingAddress().getPincode());
		    writerReceipt.println("\n\nBook\t\tBook Qty");
		    for(ProductOfCart prod: billProducts_List)
		    {
		    writerReceipt.println(prod.getProductName()+"\t\t"+prod.getProductQuantity());
		    }
		    writerReceipt.close();
		    writerBill.println("Name:"+user.getUserName());
		    writerBill.println(cart.getBillingAddress().getStreet()+"\n"+cart.getBillingAddress().getCity()+"\n"+cart.getBillingAddress().getState()+"\n"+cart.getBillingAddress().getPincode());
		    writerBill.println(user.getUserContact()+"\n");
		    writerBill.println("Book\t\tBook Cost\t\tBook Qty\t\tTotal");
		    for(ProductOfCart prod: billProducts_List)
		    {
		    	writerBill.println(prod.getProductName()+"\t\t"+prod.getProductCost()+"\t\t"+prod.getProductQuantity()+"\t\t"+(prod.getProductCost()*prod.getProductQuantity()));
		    }
		    writerBill.println("Totatl:"+cart.getTotalCost());
		    writerBill.close();
		    log.debug("Bill Generated");
		} catch (IOException e) {
		  System.err.println(e);
		}
		log.debug("End of generateBill");
	}

	@Transactional
	public boolean removeProductFromCart(String productID, int cartID) {
		log.debug("Start of removeProductFromCart");
		try {
				String sql="delete from CART_PRODUCTS where CARTID = :cartID and PRODUCTID = :productID";
				SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery(sql);
				query.setParameter("cartID", cartID);
				query.setParameter("productID", productID);
				int i=query.executeUpdate();
				log.debug("Prduct removed from Cart");
				log.debug("End of removeProductFromCart");
				return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			log.debug("End of removeProductFromCart");
			return false;
		}
	}
	
	@Transactional
	public List<ProductOfCart> getProductsInCart(int cartId) {
		log.debug("Start of getProductsInCart");
		String sql="SELECT PRODUCTID, PRODUCTQUANTITY, PRODUCTNAME, PRODUCTCOST AS PRODUCT_CART FROM CART_PRODUCTS WHERE CARTID='"+cartId+ "'";
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql);
		List<Object> tempList=query.list();
		List<ProductOfCart> returnList=new ArrayList<ProductOfCart>();
		ProductOfCart tempProductOfCart;
		for(int i=0;i<tempList.size();i++)
		{
			tempProductOfCart=new ProductOfCart();
			Object[] obj = (Object[]) tempList.get(i);
			tempProductOfCart.setProductId((String) obj[0]);
			tempProductOfCart.setProductQuantity((Integer) obj[1]);
			tempProductOfCart.setProductName((String) obj[2]); 
			tempProductOfCart.setProductCost((Integer) obj[3]);
			returnList.add(i, tempProductOfCart);
		}
		log.debug("End of getProductsInCart");
		return returnList;
	}

	@Transactional
	public boolean updateTotalCost(int cartId, int newTotalCost) {
		log.debug("Start of updateTotalCost");
		try {			
			String sql="update Cart set totalCost = :newTotalCost where cartID = :cartId";
			SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setParameter("cartId", cartId);
			query.setParameter("newTotalCost", newTotalCost);
			query.executeUpdate();
			log.debug("End of updateTotalCost");
			return true;
	}
	catch (Exception e) {
		e.printStackTrace();
		log.debug("End of updateTotalCost");
		return false;
	}
	}

}
