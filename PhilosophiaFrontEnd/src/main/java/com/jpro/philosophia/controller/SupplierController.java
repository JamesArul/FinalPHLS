package com.jpro.philosophia.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jpro.philosophibackend.dao.SupplierDAO;
import com.jpro.philosophibackend.domain.Address;
import com.jpro.philosophibackend.domain.Supplier;

@Controller
public class SupplierController {
	
Logger log = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@RequestMapping("selManageSuppliers")
	public ModelAndView showSupplierManage()
	{
		log.debug("Start of showSupplierManage");
		List<Supplier> supplierList=supplierDAO.getAllSupplier();
		ModelAndView mv=new ModelAndView("/Admin/Admin","command", new Supplier());
		mv.addObject("spList" ,supplierList);
		mv.addObject("SuppierManage","SupplierManagement");
		mv.addObject("editSupplierMsg", null);
		mv.addObject("CategoryManage", null);
		mv.addObject("ProductManage", null);
		log.debug("End of showSupplierManage");
		return mv;
	}
	
	@RequestMapping("/findSupplier")
	public ModelAndView findSupplier(@RequestParam("supEditID") String spID)
	{
		log.debug("Start of findSupplier");
		List<Supplier> supplierList=supplierDAO.getAllSupplier();
		Supplier spFound=supplierDAO.getSupplierById(spID);
		log.debug("Supplier Found");
		ModelAndView mv=new ModelAndView("/Admin/Admin","command", new Supplier());
		mv.addObject("spList" ,supplierList);
		mv.addObject("supFound", spFound);
		mv.addObject("SuppierManage","SupplierManagement");
		mv.addObject("editSupplierMsg", "EditSupplier True");
		mv.addObject("CategoryManage", null);
		mv.addObject("ProductManage", null);
		log.debug("End of findSupplier");
		return mv;
	}
	
	@RequestMapping("/deleteSupplier")
	public ModelAndView deleteSupplier(@RequestParam("supDeleteID") String spID)
	{
		log.debug("Start of deleteSupplier");
		supplierDAO.deleteSupplier(spID);
		log.debug("Supplier Deleted");
		List<Supplier> supplierList=supplierDAO.getAllSupplier();
		ModelAndView mv=new ModelAndView("/Admin/Admin","command", new Supplier());
		mv.addObject("spList" ,supplierList);
		mv.addObject("SuppierManage","SupplierManagement");
		mv.addObject("editSupplierMsg", null);
		mv.addObject("CategoryManage", null);
		mv.addObject("ProductManage", null);
		log.debug("End of deleteSupplier");
		return mv;
	}
	
	@RequestMapping(value="/addSupplier",  method = RequestMethod.POST)
	public ModelAndView addSupplierFunction(@ModelAttribute Supplier supplier)
	{
		log.debug("Start of addSupplierFunction");
		supplierDAO.saveSupplier(supplier);
		List<Supplier> supplierList=supplierDAO.getAllSupplier();
		ModelAndView mv=new ModelAndView("/Admin/Admin","command", new Supplier());
		mv.addObject("spList" ,supplierList);
		mv.addObject("SuppierManage","SupplierManagement");
		mv.addObject("editSupplierMsg", null);
		mv.addObject("CategoryManage", null);
		mv.addObject("ProductManage", null);		
		log.debug("End of addSupplierFunction");
		return mv;
	}
	
	@RequestMapping(value="/editSupplier",  method = RequestMethod.POST)
	public ModelAndView editSupplierFunction(@RequestParam("spID") String suppID,@RequestParam("supplierName") String spName,@RequestParam("supplierDescription") String spDesc,@RequestParam("supplierAddressStreet") String spStreet,@RequestParam("supplierAddressCity") String spCity,@RequestParam("supplierAddressState") String spState,@RequestParam("supplierAddressPincode") int spPincode)
	{
		log.debug("Start of editSupplierFunction");
		Supplier supplier=new Supplier();
		supplier.setSupplierId(suppID);
		supplier.setSupplierName(spName);
		supplier.setSupplierDescription(spDesc);
		Address addr=new Address();
		addr.setStreet(spStreet);
		addr.setCity(spCity);
		addr.setState(spState);
		addr.setPincode(spPincode);
		supplier.setSupplierAddress(addr);
		supplierDAO.updateSupplier(supplier);
		log.debug("Supplier edited Successsfully");
		List<Supplier> supplierList=supplierDAO.getAllSupplier();
		ModelAndView mv=new ModelAndView("/Admin/Admin","command", new Supplier());
		mv.addObject("spList" ,supplierList);
		mv.addObject("SuppierManage","SupplierManagement");
		mv.addObject("editSupplierMsg", null);
		mv.addObject("CategoryManage", null);
		mv.addObject("ProductManage", null);		
		log.debug("End of editSupplierFunction");
		return mv;
	}

}
