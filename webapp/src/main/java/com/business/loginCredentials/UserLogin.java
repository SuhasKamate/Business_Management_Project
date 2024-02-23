package com.business.loginCredentials;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class UserLogin 
{

private String userEmail;
private String userPassword;
public String getUserEmail() {
	return userEmail;
}
public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}
public String getUserPassword() {
	return userPassword;
}
public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
}
@Override
public String toString() {
	return "UserLogin [userEmail=" + userEmail + ", userPassword=" + userPassword + "]";
}



}
