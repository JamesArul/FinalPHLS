package com.jpro.philosophia.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jpro.philosophibackend.dao.ProductDAO;
import com.jpro.philosophibackend.domain.Product;

@Controller
public class ProductController {
	
	Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("selManageProducts")
	public ModelAndView showProductManage()
	{
		log.debug("Start of selManageProducts");
		List<Product> productList=productDAO.getAllProducts();
		ModelAndView mv=new ModelAndView("/Admin/Admin","command", new Product());
		mv.addObject("prList" ,productList);
		mv.addObject("SuppierManage", null);
		mv.addObject("editProductMsg", null);
		mv.addObject("CategoryManage", null);
		mv.addObject("path","F:\\EclipseMain\\FinalProject\\Philosophia\\PhilosophiaFrontEnd\\src\\main\\webapp\\Resources\\Images\\");
		mv.addObject("ProductManage", "ProductManagement");
		log.debug("End of selManageProducts");
		return mv;
	}
	
	@RequestMapping("/findProduct")
	public ModelAndView findProduct(@RequestParam("prdEditID") String prID)
	{
		log.debug("Start of findProduct");
		List<Product> productList=productDAO.getAllProducts();
		Product prdFound=productDAO.getProductById(prID);
		log.debug("Product Found");
		ModelAndView mv=new ModelAndView("/Admin/Admin","command", new Product());
		mv.addObject("prList" ,productList);
		mv.addObject("prFound", prdFound);
		mv.addObject("SuppierManage", null);
		mv.addObject("editProductMsg", "EditProduct True");
		mv.addObject("CategoryManage", null);
		mv.addObject("path","F:\\EclipseMain\\FinalProject\\Philosophia\\PhilosophiaFrontEnd\\src\\main\\webapp\\Resources\\Images\\");
		mv.addObject("ProductManage", "ProductManagement");
		log.debug("End of findProduct");
		return mv;
	}
	
	@RequestMapping("/deleteProduct")
	public ModelAndView deleteProduct(@RequestParam("prdDeleteID") String prID)
	{
		log.debug("Start of deleteProduct");
		productDAO.deleteProduct(prID);
		List<Product> productList=productDAO.getAllProducts();
		ModelAndView mv=new ModelAndView("/Admin/Admin","command", new Product());
		mv.addObject("prList" ,productList);
		mv.addObject("SuppierManage", null);
		mv.addObject("editProductMsg", null);
		mv.addObject("CategoryManage", null);
		mv.addObject("path","F:\\EclipseMain\\FinalProject\\Philosophia\\PhilosophiaFrontEnd\\src\\main\\webapp\\Resources\\Images\\");
		mv.addObject("ProductManage", "ProductManagement");
		log.debug("End of deleteProduct");
		return mv;
	}
	
	@RequestMapping(value="/addProduct")
	public ModelAndView addProductFunction(@ModelAttribute Product product,HttpServletRequest request,RedirectAttributes attributes)
	{
		System.out.println("Start of addProductFunction");
		log.debug("Start of addProductFunction");
		productDAO.saveProduct(product);
		String path="F:\\EclipseMain\\FinalProject\\Philosophia\\PhilosophiaFrontEnd\\src\\main\\webapp\\Resources\\Images\\";
		path=path+String.valueOf(product.getProductId())+".jpg";
		File f=new File(path);
		MultipartFile filedet= product.getProductImage();
		if(!filedet.isEmpty())
		{
			try
			{
			  byte[] bytes=filedet.getBytes();
			  System.out.println(bytes.length);
			  FileOutputStream fos=new FileOutputStream(f);
              BufferedOutputStream bs=new BufferedOutputStream(fos);
              bs.write(bytes);
              bs.close();
             log.debug("Image uploaded Successfully");
			}
			catch(Exception e)
			{
				log.debug("Exception encountered in Image Upload");
			}
		}
		else
		{
			log.debug("File is Empty not uploaded");
		}		
		List<Product> productList=productDAO.getAllProducts();
		ModelAndView mv=new ModelAndView("/Admin/Admin","command", new Product());
		mv.addObject("prList" ,productList);
		mv.addObject("SuppierManage", null);
		mv.addObject("editProductMsg", null);
		mv.addObject("CategoryManage", null);
		mv.addObject("path","F:\\EclipseMain\\FinalProject\\Philosophia\\PhilosophiaFrontEnd\\src\\main\\webapp\\Resources\\Images\\");
		mv.addObject("ProductManage", "ProductManagement");
		log.debug("End of addProductFunction");
		return mv;
	}
	
	@RequestMapping(value="/editProduct",  method = RequestMethod.POST)
	public ModelAndView editProductFunction(@RequestParam("prID") String pID,@RequestParam("productName") String pName,@RequestParam("productDesc") String pDesc,@RequestParam("supplierId") String psupplierId,@RequestParam("categoryId") String pcategoryId,@RequestParam("productQuantity") int pQuantity,@RequestParam("productCost") int pCost)
	{
		log.debug("Start of editProductFunction");
		Product product=new Product();
		product.setProductId(pID);
		product.setProductName(pName);
		product.setProductDesc(pDesc);
		product.setCategoryId(pcategoryId);
		product.setSupplierId(psupplierId);
		product.setProductQuantity(pQuantity);
		product.setProductCost(pCost);
		productDAO.updateProduct(product);
		log.debug("Product Edited Successfully");
		List<Product> productList=productDAO.getAllProducts();
		ModelAndView mv=new ModelAndView("/Admin/Admin","command", new Product());
		mv.addObject("prList" ,productList);
		mv.addObject("SuppierManage", null);
		mv.addObject("editProductMsg", null);
		mv.addObject("CategoryManage", null);
		mv.addObject("path","F:\\EclipseMain\\FinalProject\\Philosophia\\PhilosophiaFrontEnd\\src\\main\\webapp\\Resources\\Images\\");
		mv.addObject("ProductManage", "ProductManagement");
		log.debug("End of editProductFunction");
		return mv;
	}
	
}
