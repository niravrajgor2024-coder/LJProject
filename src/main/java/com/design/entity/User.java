package com.design.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation. constraints.NotBlank;

@Entity
@Table(name="tbluser")
public class User
{	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	private Long id;
	
	@NotBlank(message="Email Cannot be Null")
	@Email(message="Enter a valid email address")
	private String email;
		
	@NotBlank(message="User Name Required")	
	private String user_name;	
	
	@NotBlank(message="Password Required")
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
