package com.jpro.philosophia.controller;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jpro.philosophibackend.dao.CartDAO;
import com.jpro.philosophibackend.dao.UserDAO;
import com.jpro.philosophibackend.domain.Cart;
import com.jpro.philosophibackend.domain.User;

@Controller
public class SpringSecurityController {

	public static Logger log = LoggerFactory.getLogger(SpringSecurityController.class);
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	public User user;
	
	@RequestMapping(value="/loginError",method = RequestMethod.GET)
	public ModelAndView loginErrorEncountered()
	{
		log.debug("Starting of the method loginErrorEncountered");
		ModelAndView mv=new ModelAndView("/Home");
		mv.addObject("msg","Invalid User Credential");
		log.debug("Ending of the method loginErrorEncountered");
		return mv;
	}
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied(Model model) {
		log.debug("Starting of the method accessDenied");
		model.addAttribute("errorMsg", "You are not authorized to access this page");
		log.debug("Ending of the method accessDenied");
		return "/Error";

	}
	
	@SuppressWarnings("unchecked")	
	@RequestMapping(value="/user_validate")
	public ModelAndView userlogin(HttpSession session,Model model)
	{
		log.debug("Starting of the method userlogin");
		String userid = SecurityContextHolder.getContext().getAuthentication().getName();
		log.debug("Start of method userlogin");
		User user=userDAO.getUserById(userid);
		ModelAndView mv;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
		String loggedInUserid = auth.getName();
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) auth.getAuthorities(); 
		if(user.getUserRole().equals("ROLE_ADMIN")) 
		{ 
			log.debug("Admin has Logged in");
			mv=new ModelAndView("/Home");
			session.setAttribute("AdminMsg","AdminLoggedIn");
			session.setAttribute("UserName", user.getUserName());
			session.setAttribute("loginMsg", null);
		} 
		else 
		{ 
			log.debug("User has Logged in");
			mv=new ModelAndView("/Home");
			session.setAttribute("UserMsg","LoggedIn");
			session.setAttribute("UserID", user.getUserID());
			session.setAttribute("UserName", user.getUserName());
			session.setAttribute("loginMsg", null);
		    List<Cart> cartsOfUser=userDAO.getCartsOfUser(userid);
		    if(cartsOfUser.isEmpty())
		    {
		    	log.debug("No Cart Present for User");
		    	session.setAttribute("CurrentCartID", null);
		    }
		    else
		    {
		    	List<Cart> list_user_cart=cartDAO.getCartsOfUser(user.getUserID());
		    	Cart innerCart=new Cart();
				Iterator<Cart> iter=list_user_cart.iterator();
					while(iter.hasNext())
					{
						innerCart = iter.next();
					}
			    	log.debug("Cart obtained for User");
					session.setAttribute("CurrentCartID", innerCart.getCartID());
		    }
		}
		log.debug("Ending of the method userlogin");
		return mv;
	}
	
	@RequestMapping("/secure_logout")
	public ModelAndView secureLogout()
	{		
		log.debug("Starting of the method secureLogout");
		session.invalidate();		
		log.debug("Logged out and session attributes invalidated");
		ModelAndView mv = new ModelAndView("/Home");
		session.setAttribute("loginMsg", "notLoggedIn");
		session.setAttribute("UserMsg", null);
		session.setAttribute("AdminMsg", null);
		log.debug("Ending of the method secureLogout");
		return mv;		
	}
	
}