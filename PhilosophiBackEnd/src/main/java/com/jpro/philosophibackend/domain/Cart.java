package com.jpro.philosophibackend.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Table(name="Cart")
@Entity
@Component
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartID;
	
	private String userId;
	
	@ManyToOne
	@JoinColumn(name = "userId", nullable = false, updatable = false, insertable = false)
	private User user;
	
	@Size(min=5,max=25)
	private String delivery_name;
	
	@Min(value=1000000000)
	private long user_contact;
	
	private int totalCost;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street",column=@Column(name="bill_street")),
		@AttributeOverride(name="city",column=@Column(name="bill_city")),
		@AttributeOverride(name="state",column=@Column(name="bill_state")),
		@AttributeOverride(name="pincode",column=@Column(name="bill_pincode"))
	})
	private Address billingAddress;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street",column=@Column(name="ship_street")),
		@AttributeOverride(name="city",column=@Column(name="ship_city")),
		@AttributeOverride(name="state",column=@Column(name="ship_state")),
		@AttributeOverride(name="pincode",column=@Column(name="ship_pincode"))
	})
	private Address shippingAddress;
	
	private Date dateAdded;
	
	@NotNull
	private String cartStatus;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="CART_PRODUCTS", joinColumns=@JoinColumn(name="cartID"))
	private Set<ProductOfCart> productOfCart= new HashSet<ProductOfCart>();

	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDelivery_name() {
		return delivery_name;
	}

	public void setDelivery_name(String delivery_name) {
		this.delivery_name = delivery_name;
	}

	public long getUser_contact() {
		return user_contact;
	}

	public void setUser_contact(long user_contact) {
		this.user_contact = user_contact;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(String cartStatus) {
		this.cartStatus = cartStatus;
	}

	public Set<ProductOfCart> getProductOfCart() {
		return productOfCart;
	}

	public void setProductOfCart(Set<ProductOfCart> productOfCart) {
		this.productOfCart = productOfCart;
	}
	
}
