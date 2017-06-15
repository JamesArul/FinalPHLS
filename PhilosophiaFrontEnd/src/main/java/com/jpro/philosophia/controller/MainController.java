package com.jpro.philosophia.controller;

import org.springframework.stereotype.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jpro.philosophibackend.dao.CartDAO;
import com.jpro.philosophibackend.dao.ProductDAO;
import com.jpro.philosophibackend.domain.Product;

@Controller
public class MainController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CartDAO cartDAO;
	
	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping("/")
	public ModelAndView show()
	{
		log.debug("Start of show Entering the Home page");
		ModelAndView mv=new ModelAndView("/Home");
		session.setAttribute("loginMsg", "notLoggedIn");
		session.setAttribute("UserMsg", null);//Indicates user is logged in
		session.setAttribute("AdminMsg", null);//Indicates Admin is logged in
		log.debug("End of show");
		return mv;
	}
	
	@RequestMapping("/goHome")
	public ModelAndView showHome()
	{
		log.debug("Show of showHome");
		ModelAndView mv=new ModelAndView("/Home");
		log.debug("End of showHome");
		return mv;
	}
	
	@RequestMapping("/goAboutUs")
	public ModelAndView showAboutUs()
	{
		log.debug("Start of showAboutUs");
		ModelAndView mv=new ModelAndView("/AboutUs");
		log.debug("End of showAboutUs");
		return mv;
	}
	
	@RequestMapping("/goLogin")
	public ModelAndView showLogin()
	{
		log.debug("Start of showLogin");
		ModelAndView mv=new ModelAndView("/Login");
		log.debug("End of showLogin");
		return mv;
	}
	
	@RequestMapping("/goAdmin")
	public ModelAndView showAdmin()
	{
		log.debug("Start of showAdmin");
		ModelAndView mv=new ModelAndView("/Admin/Admin");
		mv.addObject("CategoryManage", null);
		mv.addObject("SuppierManage", null);
		mv.addObject("ProductManage", null);
		log.debug("End of showAdmin");
		return mv;
	}
	
	@RequestMapping("/goProdView")
	public ModelAndView showProducts()
	{
		log.debug("Start of showProducts");
		ModelAndView mv=new ModelAndView("/ViewProducts");
		String path="F:\\EclipseMain\\FinalProject\\Philosophia\\PhilosophiaFrontEnd\\src\\main\\webapp\\Resources\\Images\\";
		List<Product> prodList=productDAO.getAllProducts();
		mv.addObject("prList", prodList);
		mv.addObject("path", path);
		log.debug("End of showProducts");
		return mv;
	}

}
