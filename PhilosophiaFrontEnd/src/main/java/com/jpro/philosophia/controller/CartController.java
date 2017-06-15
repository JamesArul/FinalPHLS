package com.jpro.philosophia.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jpro.philosophibackend.dao.CartDAO;
import com.jpro.philosophibackend.dao.ProductDAO;
import com.jpro.philosophibackend.dao.UserDAO;
import com.jpro.philosophibackend.domain.Address;
import com.jpro.philosophibackend.domain.Cart;
import com.jpro.philosophibackend.domain.Product;
import com.jpro.philosophibackend.domain.ProductOfCart;
import com.jpro.philosophibackend.domain.User;;

@Controller
public class CartController {
	
	private static final Logger log = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	public HttpSession session;
	
	@RequestMapping("/addConfirmProduct")
	public ModelAndView confirmProdBuy(@RequestParam("prdAddId") String product_Add_Id)
	{
		log.debug("Start of method addConfirmProduct");
		String path="F:\\EclipseMain\\FinalProject\\Philosophia\\PhilosophiaFrontEnd\\src\\main\\webapp\\Resources\\Images\\";
		String user_Id=(String) session.getAttribute("UserID");
		ModelAndView mv=new ModelAndView();
		List<Cart> list_user_cart=cartDAO.getCartsOfUser(user_Id);
		Product product_Add=productDAO.getProductById(product_Add_Id);
		if(!list_user_cart.isEmpty())
		{
			Cart innerCart=new Cart();
			Iterator<Cart> iter=list_user_cart.iterator();
				while(iter.hasNext())
				{
					innerCart = iter.next();
				}
				if(innerCart.getCartStatus().equals("Delivered") || innerCart.getCartStatus().equals("Deployed"))
				{
					log.debug("Creating new Cart");
					mv=new ModelAndView("/User/CreateCart");
					mv.addObject("noCartInitialized","No Carts available Create New to continue");
					mv.addObject("userID", user_Id);
					log.debug("End of method addConfirmProduct");
					return mv;
				}
				else if(!innerCart.getProductOfCart().isEmpty())
				{
					for(ProductOfCart p: innerCart.getProductOfCart())
					{
						if(p.getProductId().equals(product_Add_Id))
						{
							log.debug("Product already in Cart");
							mv=new ModelAndView("/ViewProducts");
							mv.addObject("error","Product already in cart");
							List<Product> prodList=productDAO.getAllProducts();
							mv.addObject("prList", prodList);
							mv.addObject("path", path);
							log.debug("End of method addConfirmProduct");
							return mv;
						}
					}
				}
				mv=new ModelAndView("/User/ConfirmBookBuy");
				if(product_Add.getProductQuantity()==0)
				{
					log.debug("Product Out of Stock");
					mv.addObject("OutOfStock", "ProductIsOutOfStock");
				}
				else
				{
					log.debug("Product available for Purchase");
					mv.addObject("OutOfStock", null);
					mv.addObject("AvailableQty",product_Add.getProductQuantity());
				}
				mv.addObject("path", path);
				mv.addObject("ProductDetails",productDAO.getProductById(product_Add_Id));
				log.debug("End of method addConfirmProduct");
				return mv;
		}
		else
		{
			log.debug("Creating new Cart");
			mv=new ModelAndView("/User/CreateCart");
			mv.addObject("userID", user_Id);
			log.debug("End of method addConfirmProduct");
			return mv;
		}
	}
	
	
	@RequestMapping("/addCartProduct")
	public ModelAndView goUserCart(@RequestParam("prdAddId") String product_Add_Id, @RequestParam("quantity") int product_Add_Qty)
	{
		log.debug("Start of method addCartProduct");
		String path="F:\\EclipseMain\\FinalProject\\Philosophia\\PhilosophiaFrontEnd\\src\\main\\webapp\\Resources\\Images\\";
		List<Product> prodList=productDAO.getAllProducts();
		ModelAndView mv;
		String user_Id=(String) session.getAttribute("UserID");
		int cartID=(Integer)session.getAttribute("CurrentCartID");
		List<Cart> list_user_cart=cartDAO.getCartsOfUser(user_Id);
		ProductOfCart product_Put_In_Cart=new ProductOfCart();
		Product product_Added=productDAO.getProductById(product_Add_Id);
		if(!session.getAttribute("CurrentCartID").equals(null))
		{
			Cart currentCart=cartDAO.getCartById(cartID);
					//session.setAttribute("CurrentCartID", innerCart.getCartID());
					log.debug("Putting product in Cart");
					mv=new ModelAndView("/ViewProducts");
					product_Put_In_Cart.setProductId(product_Add_Id);
					product_Put_In_Cart.setProductName(product_Added.getProductName());
					product_Put_In_Cart.setProductQuantity(product_Add_Qty);
					product_Put_In_Cart.setProductCost(product_Added.getProductCost());
					currentCart.getProductOfCart().add(product_Put_In_Cart);
					product_Added.setProductQuantity(product_Added.getProductQuantity()-product_Add_Qty);
					productDAO.updateProduct(product_Added);
					currentCart.setTotalCost(currentCart.getTotalCost()+(product_Added.getProductCost()*product_Add_Qty));
					cartDAO.updateCart(currentCart);
					mv.addObject("prList", prodList);
					mv.addObject("path", path);				
		}
		else
		{
			log.debug("Creating new Cart");
			mv=new ModelAndView("/User/CreateCart");
			mv.addObject("userID", user_Id);
		}
		log.debug("End of method addCartProduct");
		return mv;
	}
	
	@RequestMapping("/goMyCart")
	public ModelAndView goToCart()
	{
		log.debug("Start of method goMyCart");
		ModelAndView mv;
		String user_Id=(String) session.getAttribute("UserID");
		if(session.getAttribute("CurrentCartID")!=null)
		{
		log.debug("Viewing Products in Cart");
		int cartID=(Integer)session.getAttribute("CurrentCartID");
		List<ProductOfCart> product_In_Cart=cartDAO.getProductsInCart(cartID);
		mv= new ModelAndView("/User/UserCart");
		mv.addObject("prInCartList", product_In_Cart );
		mv.addObject("totalCostOfCart",cartDAO.getCartById(cartID).getTotalCost());
		}
		else
		{
			log.debug("Creating new Cart");
			mv=new ModelAndView("/User/CreateCart");
			mv.addObject("noCartInitialized","No Carts available Create New Cart to continue");
			mv.addObject("userID", user_Id);
		}
		log.debug("End of method goMyCart");
		return mv;
	}
	
	@RequestMapping("/createCartOfUser")
	public ModelAndView createCart(@RequestParam("usID") String userID,@RequestParam("usName") String userName,@RequestParam("addr1") String addrLine1,@RequestParam("addr2") String addrLine2,@RequestParam("addr3") String addrLine3,@RequestParam("addr4") int addrLine4)
	{
		log.debug("Start of method createCartOfUser");
		String path="F:\\EclipseMain\\FinalProject\\Philosophia\\PhilosophiaFrontEnd\\src\\main\\webapp\\Resources\\Images\\";
		List<Product> prodList=productDAO.getAllProducts();
		Cart cart=new Cart();
		User user=userDAO.getUserById(userID);
		System.out.println(user.getUserName());
		Date date=new Date();
		Address address=new Address();
		address.setStreet(addrLine1);
		address.setCity(addrLine2);
		address.setState(addrLine3);
		address.setPincode(addrLine4);
		cart.setUserId(user.getUserID());
		cart.setDelivery_name(userName);
		cart.setBillingAddress(address);
		cart.setUser_contact(user.getUserContact());
		cart.setTotalCost(0);
		cart.setDateAdded(date);
		cart.setCartStatus("Created");
		log.debug("Adding cart");
		cartDAO.saveCart(cart);
		ModelAndView mv=new ModelAndView("/ViewProducts");
		mv.addObject("prList", prodList);
		mv.addObject("path", path);
		session.setAttribute("CurrentCartID", cart.getCartID());
		log.debug("Start of method createCartOfUser");
		return mv;
	}
	
	@RequestMapping("/removeProdFromCart")
	public ModelAndView goRemoveProduct(@RequestParam("prID") String prodId)
	{
		log.debug("Start of method removeProdFromCart");
		ModelAndView mv;
		Product product=productDAO.getProductById(prodId);
		Cart cart=cartDAO.getCartById((Integer)session.getAttribute("CurrentCartID"));
		int prQtyInCart=0;
		List<ProductOfCart> prInCart=cartDAO.getProductsInCart(cart.getCartID());
		for(ProductOfCart p : prInCart)
		{
			if(prodId.equals(p.getProductId()))
			{
				prQtyInCart=p.getProductQuantity();
			}
		}
		if(cart.getCartStatus().equals("Delivered") || cart.getCartStatus().equals("Deployed"))
		{
			log.debug("Cart is deployed cannot remove products");
			mv=new ModelAndView("/User/UserCart");
			mv.addObject("msg","Error Cart has been deployed cannot be modified");
		}
		else
		{
		log.debug("Removing product from Cart");
		product.setProductId(prodId);
		product.setProductQuantity(product.getProductQuantity()+prQtyInCart);
		productDAO.updateProduct(product);
		cartDAO.removeProductFromCart(prodId, cart.getCartID());
		int newTotalCost=cart.getTotalCost()-(product.getProductCost()*prQtyInCart);
		cartDAO.updateTotalCost(cart.getCartID(), newTotalCost);
		List<ProductOfCart> product_In_Cart=cartDAO.getProductsInCart(cart.getCartID());
		mv=new ModelAndView("/User/UserCart");
		mv.addObject("prInCartList", product_In_Cart );
		mv.addObject("totalCostOfCart",cartDAO.getCartById(cart.getCartID()).getTotalCost());
		}
		log.debug("End of method removeProdFromCart");
		return mv;
	}
	
	@RequestMapping("goGenerateBill")
	public ModelAndView goGenerateBill()
	{
		log.debug("Start of the goGenerateBill");
		Cart cart=cartDAO.getCartById((Integer)session.getAttribute("CurrentCartID"));
		ModelAndView mv;
		if(cartDAO.getProductsInCart(cart.getCartID()).size()==0 || cartDAO.getCartStatus(cart.getCartID()).equals("Deployed"))
		{
			log.debug("There are no products in cart or Create New Cart");
			mv=new ModelAndView("/ViewProducts");
			mv.addObject("error","Cart is Empty or Create New Cart");
			return mv;
		}
		mv=new ModelAndView("/User/CreateCart2");
		log.debug("End of the goGenerateBill");
		return mv;
	}

	@RequestMapping("getShippingAddress")
	public ModelAndView finishCartOrder(@RequestParam("addr1") String addrLine1,@RequestParam("addr2") String addrLine2,@RequestParam("addr3") String addrLine3,@RequestParam("addr4") int addrLine4)
	{
		log.debug("Start of the getShippingAddress");
		Address address=new Address();
		address.setStreet(addrLine1);
		address.setCity(addrLine2);
		address.setState(addrLine3);
		address.setPincode(addrLine4);
		Cart cart=cartDAO.getCartById((Integer)session.getAttribute("CurrentCartID"));
		cart.setShippingAddress(address);
		cart.setCartStatus("Deployed");
		log.debug("Cart status updated");
		cartDAO.updateCart(cart);
		cartDAO.generateBill((Integer)session.getAttribute("CurrentCartID"));
		ModelAndView mv=new ModelAndView("/Home");
		mv.addObject("cartSuccess", "Order Confirmed");
		log.debug("End of the getShippingAddress");
		return mv;		
	}	
	
}
