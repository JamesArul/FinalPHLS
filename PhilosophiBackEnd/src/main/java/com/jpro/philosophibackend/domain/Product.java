package com.jpro.philosophibackend.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Table(name="Product")
@Entity
@Component
public class Product {
	
	@Id
	private String productId;
	
	@Size(min=4,max=30)
	private String productName;
	
	private String categoryId;
	
	private String supplierId;
	
	@Size(min=10)
	private String productDesc;
	
	private int productQuantity;
	
	@Min(1)
	private int productCost;
	
	@Transient
	private MultipartFile productImage;
	
	@ManyToOne
	@JoinColumn(name = "supplierId", nullable = false, updatable = false, insertable = false)
	private Supplier supplier;
	
	@ManyToOne
	@JoinColumn(name = "categoryId", nullable = false, updatable = false, insertable = false)
	private Category category;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getProductCost() {
		return productCost;
	}

	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
