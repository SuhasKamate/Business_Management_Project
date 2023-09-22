package com.business.entities;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int u_id;

	private String uname;
	private String uemail;
	private String upassword;
	private Long unumber;
	
@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Orders> orders;
	
	
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;

	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public Long getUnumber() {
		return unumber;
	}
	public void setUnumber(Long unumber) {
		this.unumber = unumber;
	}
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", uname=" + uname + ", uemail=" + uemail + ", upassword=" + upassword
				+ ", unumber=" + unumber + ", orders=" + orders + "]";
	}
	



}
