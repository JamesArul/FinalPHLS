package com.jpro.philosophibackend.dao;

import java.util.List;

import com.jpro.philosophibackend.domain.Supplier;

public interface SupplierDAO {
	
	public List<Supplier> getAllSupplier();
	
	public boolean saveSupplier(Supplier supplier);
	
	public boolean updateSupplier(Supplier supplier);
	
	public boolean deleteSupplier(Supplier supplier);
	
	public boolean deleteSupplier(String supplierId);
	
	public Supplier getSupplierById(String supplierId);
	
	public Supplier getSupplierByName(String supplierName);

}
