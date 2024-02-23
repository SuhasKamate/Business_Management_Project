package com.business.entities;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Admin
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
private int adminId;
private String adminName;
private String adminEmail;	
@Value("1234")
private String adminPassword;
private String adminNumber;
public int getAdminId() {
	return adminId;
}
public void setAdminId(int adminId) {
	this.adminId = adminId;
}
public String getAdminName() {
	return adminName;
}
public void setAdminName(String adminName) {
	this.adminName = adminName;
}
public String getAdminEmail() {
	return adminEmail;
}
public void setAdminEmail(String adminEmail) {
	this.adminEmail = adminEmail;
}
public String getAdminPassword() {
	return adminPassword;
}
public void setAdminPassword(String adminPassword) {
	this.adminPassword = adminPassword;
}
public String getAdminNumber() {
	return adminNumber;
}
public void setAdminNumber(String adminNumber) {
	this.adminNumber = adminNumber;
}
@Override
public String toString() {
	return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminEmail=" + adminEmail + ", adminPassword="
			+ adminPassword + ", adminNumber=" + adminNumber + "]";
}





}
