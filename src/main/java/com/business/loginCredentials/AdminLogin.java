package com.business.loginCredentials;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AdminLogin
{
	/*
	 * @NotNull(message="email should not be null")
	 * 
	 * @Email(message="email like ex : suhaskamate@gmail.com")
	 */
	private String email;
	/*
	 * @NotNull
	 * 
	 * @Size(min=4,max=12, message="Password should be 4-12 characters.")
	 */
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdminLogin [name=" + email + ", password=" + password + "]";
	}
	
	
	
	

}
