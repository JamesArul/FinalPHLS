package com.jpro.philosophibackend.domain;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.Column;

import org.springframework.stereotype.Component;

@Table(name="Supplier")
@Entity
@Component
public class Supplier {
	
	@Id
	private String supplierId;
	
	@Size(min=4,max=30)
	private String supplierName;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street",column=@Column(name="supplier_street")),
		@AttributeOverride(name="city",column=@Column(name="supplier_city")),
		@AttributeOverride(name="state",column=@Column(name="supplier_state")),
		@AttributeOverride(name="pincode",column=@Column(name="supplier_pincode"))
	})
	private Address supplierAddress;
	
	private String supplierDescription;
	
	@OneToMany(mappedBy="supplier",fetch = FetchType.EAGER)
	private Set<Product> products;

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Address getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(Address supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getSupplierDescription() {
		return supplierDescription;
	}

	public void setSupplierDescription(String supplierDescription) {
		this.supplierDescription = supplierDescription;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}
