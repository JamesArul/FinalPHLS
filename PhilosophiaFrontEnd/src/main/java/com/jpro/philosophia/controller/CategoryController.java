package com.jpro.philosophia.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jpro.philosophibackend.dao.CategoryDAO;
import com.jpro.philosophibackend.domain.Category;

@Controller
public class CategoryController {
	
	Logger log = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping("/selManageCategories")
	public ModelAndView showCategoryManage()
	{
		log.debug("Start of showCategoryManage");
		List<Category> categoryList=categoryDAO.getAllCategory();
		ModelAndView mv=new ModelAndView("/Admin/Admin","command", new Category());
		mv.addObject("cgList" ,categoryList);
		mv.addObject("CategoryManage","CategoryManagement");
		mv.addObject("editCategoryMsg", null);
		mv.addObject("SuppierManage", null);
		mv.addObject("ProductManage", null);
		log.debug("End of showCategoryManage");
		return mv;
	}
	
	@RequestMapping("/findCategory")
	public ModelAndView findCategory(@RequestParam("ctgEditID") String cgID)
	{
		log.debug("Start of findCategory");
		List<Category> categoryList=categoryDAO.getAllCategory();
		Category ctgFound=categoryDAO.getCategoryById(cgID);
		log.debug("Category Found");
		ModelAndView mv=new ModelAndView("/Admin/Admin","command", new Category());
		mv.addObject("cgList" ,categoryList);
		mv.addObject("CategoryManage","CategoryManagement");
		mv.addObject("editCategoryMsg", "CategoryEditTrue");
		mv.addObject("cgFound", ctgFound);
		mv.addObject("SuppierManage", null);
		mv.addObject("ProductManage", null);
		log.debug("End of findCategory");
		return mv;
	}
	
	@RequestMapping("/deleteCategory")
	public ModelAndView deleteCategory(@RequestParam("ctgDeleteID") String cgID)
	{
		log.debug("Start of deleteCategory");
		categoryDAO.deleteCategory(cgID);
		log.debug("Category deleted Successfully");
		List<Category> categoryList=categoryDAO.getAllCategory();
		ModelAndView mv=new ModelAndView("/Admin/Admin","command", new Category());
		mv.addObject("cgList" ,categoryList);
		mv.addObject("CategoryManage","CategoryManagement");
		mv.addObject("editCategoryMsg", null);
		mv.addObject("SuppierManage", null);
		mv.addObject("ProductManage", null);
		log.debug("End of deleteCategory");
		return mv;
	}
	
	@RequestMapping(value="/addCategory",  method = RequestMethod.POST)
	public ModelAndView addCategoryFunction(@ModelAttribute Category category)
	{
		log.debug("Start of addCategory");
		categoryDAO.saveCategory(category);
		log.debug("Category added Successfully");
		List<Category> categoryList=categoryDAO.getAllCategory();
		ModelAndView mv=new ModelAndView("/Admin/Admin","command", new Category());
		mv.addObject("cgList" ,categoryList);
		mv.addObject("CategoryManage","CategoryManagement");
		mv.addObject("editCategoryMsg", null);
		mv.addObject("SuppierManage", null);
		mv.addObject("ProductManage", null);		
		log.debug("End of addCategory");
		return mv;
	}
	
	@RequestMapping(value="/editCategory",  method = RequestMethod.POST)
	public ModelAndView editCategoryFunction(@RequestParam("ctID") String cgID,@RequestParam("categoryName") String cgName,@RequestParam("categoryDescription") String cgDesc)
	{
		log.debug("Start of editCategory");
		Category category=new Category();
		category.setCategoryId(cgID);
		category.setCategoryName(cgName);
		category.setCategoryDescription(cgDesc);
		categoryDAO.updateCategory(category);
		log.debug("Category edited Successfully");
		List<Category> categoryList=categoryDAO.getAllCategory();
		ModelAndView mv=new ModelAndView("/Admin/Admin","command", new Category());
		mv.addObject("cgList" ,categoryList);
		mv.addObject("CategoryManage","CategoryManagement");
		mv.addObject("editCategoryMsg", null);
		mv.addObject("SuppierManage", null);
		mv.addObject("ProductManage", null);
		log.debug("End of editCategory");
		return mv;
	}
	
}
