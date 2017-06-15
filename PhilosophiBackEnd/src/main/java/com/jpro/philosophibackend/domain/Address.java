package com.jpro.philosophibackend.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Embeddable
public class Address {
	
	@Size(min=4,max=30)
	private String street;
	
	@Size(min=4,max=20)
	private String city;
	
	@Size(min=4,max=20)
	private String state;
	
	@Min(100000)
	private int pincode;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

}
