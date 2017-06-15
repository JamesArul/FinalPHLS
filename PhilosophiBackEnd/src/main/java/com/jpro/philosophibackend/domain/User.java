package com.jpro.philosophibackend.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

@Table(name="User")
@Entity
@Component
public class User {
	
	@Id
	private String userID;
	
	@Size(min=4,max=25)
	private String userName;
	
	@Size(min=7,max=20)
	private String userPassword;
	
	//@Pattern(regexp="(\\w+)([@])(\\w+)([.])([c])([o])([m])")
	@Email
	private String userEmail;
	
	@Column(columnDefinition="varchar(10) default 'ROLE_USER'")
	private String userRole;
	
	@Min(value=1000000000)
	private long userContact;
	
	@OneToMany(mappedBy="user",fetch = FetchType.EAGER)
	private Set<Cart> carts=new HashSet<Cart>();

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public long getUserContact() {
		return userContact;
	}

	public void setUserContact(long userContact) {
		this.userContact = userContact;
	}

	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

}
